grammar Blazon;

options {
  language = Java;
}

@lexer::header {
package blazon.server.grammar;

import blazon.shared.shield.diagnostic.ShieldDiagnostic;
import blazon.shared.shield.diagnostic.ShieldDiagnostic.LogLevel;

}

@lexer::members {
  
  public BlazonLexer(CharStream input, List<ShieldDiagnostic> diags) {
      this(input, new RecognizerSharedState(), diags);
  }
  
  public BlazonLexer(CharStream input, RecognizerSharedState state, List<ShieldDiagnostic> diags) {
      super(input,state);
      this.diags = diags;
  }
  
  private List<ShieldDiagnostic> diags;
  
  
  @Override
  public void recover(RecognitionException re) {
    diags.add(ShieldDiagnostic.build(LogLevel.ERROR, getErrorHeader(re) + ":" + getErrorMessage(re, getTokenNames())));
    input.consume();
  }
}

@header {
package blazon.server.grammar;
import blazon.shared.shield.*;
import blazon.shared.shield.charges.*;
import blazon.shared.shield.charges.Ordinary.OrdinaryType;
import blazon.shared.shield.ShieldDivision.ShieldDivisionType;
import blazon.shared.shield.diagnostic.ShieldDiagnostic;
import blazon.shared.shield.diagnostic.ShieldDiagnostic.LogLevel;
import blazon.shared.shield.tinctures.*;
import blazon.shared.numberconversion.WordToNumberConverter;
}

@members {
  
  public BlazonParser(TokenStream input, List<ShieldDiagnostic> diags) {
      this(input, new RecognizerSharedState(), diags);
  }
  
  public BlazonParser(TokenStream input, RecognizerSharedState state, List<ShieldDiagnostic> diags) {
      super(input, state);
      this.diags = diags;
  }
  
  private WordToNumberConverter converter = new WordToNumberConverter();
  private List<ShieldDiagnostic> diags;
  
  @Override
  public void emitErrorMessage(String msg) {
    diags.add(ShieldDiagnostic.build(LogLevel.ERROR, msg));
  }
}

@rulecatch {
    catch (RecognitionException re) {
        throw re;
    }
} 

shield returns [Shield s]
		    :   { String blazon = input.toString(); } // parser uses Interpreter pattern
		    field { $s = ShieldImpl.build($field.layer, blazon); }
		    ( charges[$field.layer.getTinctureTypeOfLayer()] { $s.getField().addNextLayer($charges.layer); })?
		    {
		        //LATER make HTML pretty
				    //TODO add charges
				    $s.addDiagnostics(diags);
				}
		    ;
		    catch [RecognitionException re] {
		        reportError(re);
            return InvalidShield.build(diags);
        }

field returns [ShieldLayer layer]
		    :   { Tinctures tinctures = new Tinctures(); }
		    (
		        div { ShieldDivisionType division = $div.division; }
            some_tinctures[tinctures, division] { $layer = $some_tinctures.layer; }
        |
            tincture[tinctures] 'plain'? {
                $layer = ShieldLayer.buildUndividedShieldLayer(tinctures);
            }
        )
		    ;

charges [TinctureType underLayerTinctureType] returns [ChargedShieldLayer layer]
        :   { Tinctures tinctures = new Tinctures(); }
            A ordinary[tinctures, underLayerTinctureType]
            {
                $layer = ChargedShieldLayer.build(tinctures, $ordinary.ordinary);
            }
        ;

ordinary [Tinctures tinctures, TinctureType underLayerTinctureType] returns [OrdinaryType ordinary]
        :   ord = (ORDINARY | OTHER_ORDINARY ) { String text = $ord.text; }
            ( MODIFIER { text += "_" + $MODIFIER.text; } )?
            t=tincture[tinctures]
            { 
                TinctureType thisTinctureType = t.getTinctureType();
                if (underLayerTinctureType == thisTinctureType) {
                    if (thisTinctureType == TinctureType.COLOUR || thisTinctureType == TinctureType.METAL) {
                        diags.add(ShieldDiagnostic.build(LogLevel.WARN, "You are not obeying the rule of tincture. You can not put a colour on a colour, or a metal on a metal"));
                    }
                }              
                $ordinary = new Ordinary().getOrdinaryType(text, t, diags);
            }
        ;

div returns [ShieldDivisionType division]
        :   { String text = ""; }
        (    
            (
                TIERCED { text = $TIERCED.text + " "; }
            )?
            PARTYPER
            divType = (ORDINARY | OTHER_DIV) { text += $divType.text; }
            (
                divModifier1 = MODIFIER { text += " " + $divModifier1.text; }
            )?
        |
            VARIABLE_DIV { text = $VARIABLE_DIV.text; }
            (
                divModifier2 = MODIFIER { text += " " + $divModifier2.text; }
            )?
            (
                OF { text += " " + $OF.text; }
                number_digits_or_words
                {
                    try {
                        int gyronnyOf = converter.convert($number_digits_or_words.text);
                        if (gyronnyOf \% 2 != 0) {
                            gyronnyOf++;
                            diags.add(ShieldDiagnostic.build(LogLevel.WARN, "Parsing rule 'div'.  '" + $VARIABLE_DIV.text 
                                    + "' can only be of an even number; incremented number of sections to " + gyronnyOf));
                        }
                        text += " " + gyronnyOf;
                    } catch (Exception e) {
                        diags.add(ShieldDiagnostic.build(LogLevel.ERROR, "Unable to convert '" + $number_digits_or_words.text 
                            + "' into an integer. Caught: " +  e));
                        throw new RecognitionException(this.input);
                    }
                }
            )?
        |
            CONTINUOUS_DIV { text = $CONTINUOUS_DIV.text; }
        |
            QUARTER { text = $QUARTER.text; }
        )
        {
            if (state.errorRecovery) {
                throw new RecognitionException(this.input);
            }
            ShieldDivision divisions = new ShieldDivision();
            $division = divisions.getDivisionType(text, diags);
        }
        ;
        
some_tinctures [Tinctures tinctures, ShieldDivisionType division] returns [ShieldLayer layer]
        :   { int count = 0; }    
            (
                tincture[tinctures] 
                { count++; }
            )+
            AND
            tincture[tinctures]
            {
                count++;
                int numberOfTinctures = division.getNumberOfTinctures();
                if (numberOfTinctures != count) {
                    diags.add(ShieldDiagnostic.build(LogLevel.ERROR, "Incorrect number of tinctures specified." +
                        "  The '" + division + "' division type only allows the following number of tinctures: "
                        + numberOfTinctures + " but found " + count));
                    throw new RecognitionException(this.input);
                }
                $layer = ShieldLayer.buildDividedShieldLayer(tinctures, division);
            }
        ;

tincture [Tinctures tinctures] returns [Tincture tincture]   
        :   { String tinctureName = ""; }
        (   COLOUR { tinctureName = $COLOUR.text; }
        |   METAL  { tinctureName = $METAL.text; }
        |   FUR    { tinctureName = $FUR.text; }
        )
        {   try {
                $tincture = tinctures.getTincture(tinctureName);
                $tinctures.addTincture($tincture);
            } catch (UnknownTinctureException e) {
                diags.add(ShieldDiagnostic.build(LogLevel.ERROR, "Unknown tincture found. Caught: " + e));
                throw new RecognitionException(this.input);
            }
        }
        ;

number_digits_or_words
        :   DIGITS
        |   NUMWORDS (AND? NUMWORDS)*
        ;

MODIFIER
        :   'reversed' | 'sinister'
        ;

TIERCED
        :   'tierced'
        ;

ORDINARY
        :   'fess' | 'pale' | 'bend' | 'cross' | 'saltire' | 'chevron'
        ;

OTHER_DIV
        :   'pall'
        ;
        
OTHER_ORDINARY
        :   'chief' | 'base'
        ;
        
VARIABLE_DIV
        :   'gyronny' | 'barry' | 'paly' | 'bendy' | 'chevronny'
        ;
        
CONTINUOUS_DIV
        :   'chequy' | 'lozengy'
        ;
      
QUARTER :   'quarter'('ed'|'ly')
        ;
      
PARTYPER
        :   ('part'('ed'|'y')' ')? 'per'
        ;
    
COLOUR  :   'azure' | 'gules' | 'vert' | 'sable' | 'purpure'
        ;

METAL   :   'or' | 'argent'
        ;

FUR     :   'ermine' | 'ermines' | 'erminois' | 'pean'
        |   'vair' | 'counter-vair' | 'vair-en-pale' | 'vair-en-point'
        |   'potent' | 'counter-potent' | 'potent-en-pale' | 'potent-en-point'
        ;
        
DIGITS  :   ('0'..'9')+
        ;
        
NUMWORDS
        :   'one' | 'eleven' | 'two' | 'twelve' | 'three' | 'thirteen' 
        |   'four''teen'? | 'five' | 'fifteen' | 'six''teen'? | 'seven''teen'?
        |   'eight''een'? | 'nine''teen'? | 'twenty' | 'thirty' | 'fourty'
        |   'fifty' | 'sixty' | 'seventy' | 'eighty' | 'ninety' | 'hundred'
        |   'thousand' | 'million' | 'billion'
        ;

OF      :   'of'
        ;
        
AND     :   'and'
        ;

A       :   'a'
        ;
        
WS      :   (' '|'\t')+ { $channel=HIDDEN; }
        ;