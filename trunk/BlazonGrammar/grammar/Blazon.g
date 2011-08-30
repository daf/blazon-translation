grammar Blazon;

options {
  language = Java;
}

@header {
package blazon.server.grammar;
import blazon.shared.shield.*;
import blazon.shared.shield.ShieldDivision.ShieldDivisionType;
import blazon.shared.shield.diagnostic.ShieldDiagnostic;
import blazon.shared.shield.diagnostic.ShieldDiagnostic.LogLevel;
import blazon.shared.shield.tinctures.*;
import blazon.shared.numberconversion.WordToNumberConverter;
}

@members {
  private WordToNumberConverter converter = new WordToNumberConverter();
  private List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
  
  @Override
  public void emitErrorMessage(String msg) {
    diags.add(ShieldDiagnostic.build(LogLevel.ERROR, msg));
  }
}

@lexer::header {
package blazon.server.grammar;
}

@rulecatch {
    catch (RecognitionException re) {
        throw re;
    }
    //catch (RecognitionException re) { reportError(re); recover(input,re); }
} 

shield returns [Shield s]
		    :   field { 
		    $s = ShieldImpl.build($field.layer);
		    //TOOD make HTML pretty
		    //TODO add lozengy etc
		    //TODO add charges
		    $s.addDiagnostics(diags);
		    }
		    ;
		    catch [RecognitionException re] {
		        reportError(re);
            return InvalidShield.build(diags);
        }

field returns [ShieldLayer layer]
		    :   plain_field { $layer = $plain_field.layer; }
		    |   divided_field { $layer = $divided_field.layer; }
		    ;
    
divided_field returns [ShieldLayer layer]
		    : 
		      {
		        ShieldDivisionType division = null;
		        Tinctures tinctures = new Tinctures();
		        ShieldDivision divisions = new ShieldDivision();
		      }
			    (
			        div {
			            division = divisions.getDivisionType($div.text);
			        }
			    |
			        special_div { 
			            division = divisions.getDivisionType($special_div.text); 
			        }
			        
			    )
		        some_tinctures[tinctures, division] { $layer = $some_tinctures.layer; }
		    ;    
    
plain_field returns [ShieldLayer layer]
		    :   { Tinctures tinctures = new Tinctures(); }
		        tincture[tinctures] PLAIN?
		        {
		            tinctures.addTincture($tincture.tincture);
		            $layer = ShieldLayer.buildUndividedShieldLayer(tinctures);
		        }
		    ;

some_tinctures [Tinctures tinctures, ShieldDivisionType division] returns [ShieldLayer layer]
        :   { int count = 0; }    
            (
                t = tincture[tinctures] 
                { tinctures.addTincture($t.tincture); count++; }
            )+
            AND
            t = tincture[tinctures]
            {
		            count++;
		            tinctures.addTincture($t.tincture);
		            int numberOfTinctures = division.getNumberOfTinctures();
		            if (numberOfTinctures != count) {
		                throw new MyRecognitionException("Incorrect number of tinctures specified. The '" 
		                    + division + "' division type only allows the following number of tinctures: "
		                    + numberOfTinctures + " but found " + count);
		            }
		            $layer = ShieldLayer.buildDividedShieldLayer(tinctures, division);
		        }
        ;

div returns [String text]
        :   { text = ""; }
            (
                TIERCED { text = $TIERCED.text; }
            )?
            PARTYPER
            DIV { text += " " + $DIV.text; }
            (
                MODIFIER { text += " " + $MODIFIER.text; }
            )?
        ;

special_div returns [String text]
        :   GYRONNY { text = $GYRONNY.text; }
            (
                OF { text += " " + $OF.text; }
                number_digits_or_words
                {
                    try {
                        int gyronnyOf = converter.convert($number_digits_or_words.text);
                        if (gyronnyOf \% 2 != 0) {
                            gyronnyOf++;
                            diags.add(ShieldDiagnostic.build(LogLevel.WARN, "Parsing 'special_div', gyronny can only be of an"
                                    + " even number; incremented number of sections to " + gyronnyOf));
                        }
                        text += " " + gyronnyOf;
                    } catch (Exception e) {
                    throw new MyRecognitionException("Unable to convert '" 
                            + $number_digits_or_words.text + "' into an integer.", e);
                    }
                }
            )?
        ;

number_digits_or_words
        :   DIGITS
        |   NUMWORDS (AND? NUMWORDS)*
        ;

tincture [Tinctures tinctures] returns [Tincture tincture]   
        :   { String tinctureName = ""; }
        (   COLOUR { tinctureName = $COLOUR.text; }
        |   METAL  { tinctureName = $METAL.text; }
        |   FUR    { tinctureName = $FUR.text; }
        )
        {   try {
                $tincture = tinctures.getTincture(tinctureName);
            } catch (UnknownTinctureException e) {
                throw new MyRecognitionException("Unknown tincture found.", e);
            }
        }
        ;

MODIFIER
        :   'reversed' | 'sinister'
        ;

TIERCED
        :   'tierced'
        ;

DIV     :   'fess' | 'pale' | 'bend' | 'cross' | 'saltire' | 'chevron' | 'pall' | 'pairle'
        ;
        
GYRONNY :   'gyronny'
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
        
AND     :   'and'
        ;
        
OF      :   'of'
        ;

PLAIN   :   'plain'
        ;
        
NUMWORDS
        :   'one' | 'eleven' | 'two' | 'twelve' | 'three' | 'thirteen' 
        |   'four''teen'? | 'five' | 'fifteen' | 'six''teen'? | 'seven''teen'?
        |   'eight''een'? | 'nine''teen'? | 'twenty' | 'thirty' | 'fourty'
        |   'fifty' | 'sixty' | 'seventy' | 'eighty' | 'ninety' | 'hundred'
        |   'thousand' | 'million' | 'billion'
        ;
        
WS      :   (' '|'\t')+ {$channel=HIDDEN;}
        ;