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
  
  private void diagnoseRuleOfTincture(Tincture t, TinctureType underLayerTinctureType) {
      TinctureType thisTinctureType = t.getTinctureType();
      if (underLayerTinctureType == thisTinctureType) {
          if (thisTinctureType == TinctureType.COLOUR || thisTinctureType == TinctureType.METAL) {
              diags.add(ShieldDiagnostic.build(LogLevel.WARN, "You are not obeying the rule of tincture. You can not put a colour on a colour, or a metal on a metal"));
          }
      }
  }
  
  private int convertNumber(String numberWords) throws RecognitionException {
		  try {
		      if (numberWords.equals("a")) { return 1; }
		      return converter.convert(numberWords);
		  } catch (Exception e) {
		      diags.add(ShieldDiagnostic.build(LogLevel.ERROR, "Unable to convert '" + numberWords 
		          + "' into an integer. Caught: " +  e));
		      throw new RecognitionException(this.input);
		  }
  }
  
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
		    field { $s = ShieldImpl.build($field.field, blazon); }
		    ( charges[$field.field.getTinctureTypeOfLayer()] { $s.addCharges($charges.charges); })?
		    {
		        //LATER make HTML pretty
				    //TODO advanced charges
				    $s.addDiagnostics(diags);
				}
		    ;
		    catch [RecognitionException re] {
		        reportError(re);
            return InvalidShield.build(diags);
        }

field returns [Field field]
		    :   { Tinctures tinctures = new Tinctures(); }
		    (
		        div { ShieldDivisionType division = $div.division; }
            some_tinctures[tinctures, division] { $field = $some_tinctures.layer; }
        |
            tincture[tinctures] 'plain'? {
                $field = Field.buildUndividedShieldLayer(tinctures);
            }
        )
		    ;

charges [TinctureType underLayerTinctureType] returns [List<GeometricCharge> charges]
        :   { 
              Tinctures tinctures = new Tinctures();
              $charges = new ArrayList<GeometricCharge>();
            }
            (
                DETERMINER single_geometric_charge[tinctures, underLayerTinctureType]
                { 
                    if ($single_geometric_charge.charge != null) {
                        $charges.add($single_geometric_charge.charge);
                        if ("a".equals($DETERMINER.text)) {
                            String chargeName = $single_geometric_charge.charge.getName().toString().toLowerCase();
                            if (chargeName.startsWith("a") || chargeName.startsWith("e") || chargeName.startsWith("i") || chargeName.startsWith("o") || chargeName.startsWith("u")) {
                                diags.add(ShieldDiagnostic.build(LogLevel.WARN, "You have asked for the charge '" + $DETERMINER.text + " " + chargeName 
                                    + "'. A charge starting with a vowel should be preceded by 'an' i.e. 'an " + chargeName + "'."));
                            }
                        } else if ("an".equals($DETERMINER.text)) {
                            String chargeName = $single_geometric_charge.charge.getName().toString().toLowerCase();
                            if (!(chargeName.startsWith("a") || chargeName.startsWith("e") || chargeName.startsWith("i") || chargeName.startsWith("o") || chargeName.startsWith("u"))) {
                                diags.add(ShieldDiagnostic.build(LogLevel.WARN, "You have asked for the charge '" + $DETERMINER.text + " " + chargeName 
                                    + "'. A charge starting with a consonants should be preceded by 'a' i.e. 'a " + chargeName + "'."));
                            }
                       }
                   }
                }
            |
                number_digits_or_words multiple_geometric_charges[tinctures, underLayerTinctureType, convertNumber($number_digits_or_words.text)]
                {
                    if ($multiple_geometric_charges.charges != null) {
                        $charges.addAll($multiple_geometric_charges.charges);
                    }
                }
            |
                advanced_charge[tinctures, underLayerTinctureType]
            )
            {
                
            }
        ;

single_geometric_charge [Tinctures tinctures, TinctureType underLayerTinctureType] returns [GeometricCharge charge]
        :   ord = (ORDINARY_DIV | OTHER_ORDINARY | SUBORDINARY_DIV | SUBORDINARY) { String text = $ord.text; }
            ( MODIFIER { text += "_" + $MODIFIER.text; } )?
            t=tincture[tinctures]
            { 
                diagnoseRuleOfTincture(t, underLayerTinctureType);
                $charge = GeometricCharge.build(text, t, diags);
            }
        ;

multiple_geometric_charges [Tinctures tinctures, TinctureType underLayerTinctureType, int number] returns [List<GeometricCharge> charges]
        :   ords = (SUBORDINARY_MULTIPLE | MOBILE_CHARGE) { String text = $ords.text; }
            {
                if (number > 1) {
                    if (!text.endsWith("s")) {
                        diags.add(ShieldDiagnostic.build(LogLevel.WARN, "You have specified that there is more than one of a charge, but not used the plural. Changing '" + text + "' to '" + text + "s'."));
                    } else {
                        text = text.substring(0, text.length() - 1);
                    }
                } else if (number == 1) {
                    if (text.endsWith("s")) {
                        text = text.substring(0, text.length() - 1);
                        diags.add(ShieldDiagnostic.build(LogLevel.WARN, "You have specified that there is only one of a charge, but used the plural. Changing '" + text + "s' to '" + text + "'."));
                    }
                }
            }  
            ( MODIFIER { text += "_" + $MODIFIER.text; } )?
            t=tincture[tinctures]
            { 
                diagnoseRuleOfTincture(t, underLayerTinctureType);
                $charges = new ArrayList<GeometricCharge>();
                for (int i = 0; i < number; i++) {
                    GeometricCharge charge = GeometricCharge.build(text, t, diags);
                    $charges.add(charge);
                }
            }
        ;

div returns [ShieldDivisionType division]
        :   { String text = ""; }
        (    
            (
                TIERCED { text = $TIERCED.text + " "; }
            )?
            PARTYPER
            divType = (ORDINARY_DIV | SUBORDINARY_DIV) { text += $divType.text; }
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
		                int gyronnyOf = convertNumber($number_digits_or_words.text);
		                if (gyronnyOf \% 2 != 0) {
		                    gyronnyOf++;
		                    diags.add(ShieldDiagnostic.build(LogLevel.WARN, "Parsing rule 'div'.  '" + $VARIABLE_DIV.text 
		                            + "' can only be of an even number; incremented number of sections to " + gyronnyOf));
		                }
		                text += " " + gyronnyOf;
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
        
some_tinctures [Tinctures tinctures, ShieldDivisionType division] returns [Field layer]
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
                $layer = Field.buildDividedShieldLayer(tinctures, division);
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
        |   DETERMINER
        ;
        
advanced_charge [Tinctures tinctures, TinctureType underLayerTinctureType]
        :  number_digits_or_words BEAST ATTITUDE ATTITUDE_MODIFIER* tincture[tinctures]
           {
               diags.add(ShieldDiagnostic.build(LogLevel.INFO, "number: '" + $number_digits_or_words.text + "'. charge: '" + $BEAST.text + "'. attitude: '" + $ATTITUDE.text + "'. attitudemod: '" + $ATTITUDE_MODIFIER.text + "'. tincture: '" + $tincture.tincture + "'."));
               diagnoseRuleOfTincture($tincture.tincture, underLayerTinctureType);
           }
        ;

MODIFIER
        :   'reversed' | 'sinister'
        ;

TIERCED
        :   'tierced'
        ;

ORDINARY_DIV
        :   'fess' | 'pale' | 'bend' | 'cross' | 'saltire' | 'chevron'
        ;

SUBORDINARY_DIV
        :   'pall'
        ;
        
OTHER_ORDINARY
        :   'chief' | 'base'
        ;
        
SUBORDINARY
        :   'pile' | 'quarter' | 'canton' | 'flaunches' | 'bordure' | 'orle' | 'tressure' | 'gyron' | 'fret'
        ;
        
VARIABLE_DIV
        :   'gyronny' | 'barry' | 'paly' | 'bendy' | 'chevronny'
        ;
        
SUBORDINARY_MULTIPLE 
        :   ('bar'|'bendlet'|'pallet'|'chevronel')'s'?
        ;

MOBILE_CHARGE
        :   ('in'?'escutcheon' | 'billet' | 'lozenge' | 'mascle' | 'fusil' | 'rustre' | 'roundel' | 'annulet' | 'mullet' | 'star')'s'?
        ;
        
BEAST   :   'lion'
        ;
        
ATTITUDE
        :   'rampant' | 'sejant'
        ;
        
ATTITUDE_MODIFIER
        :   'guardant' | 'reguardant'
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

DETERMINER
        :   'a' | 'an'
        ;        

WS      :   (' '|'\t')+ { $channel=HIDDEN; }
        ;