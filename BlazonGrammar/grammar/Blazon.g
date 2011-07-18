grammar Blazon;

options {
  language = Java;
}

@header {
  package blazon.server.grammar;
  import blazon.shared.shield.*;
  import blazon.shared.shield.ShieldDivision.ShieldDivisionType;
  import blazon.shared.shield.tinctures.*;
  import blazon.shared.numberconversion.WordToNumberConverter;
}

@members {
  WordToNumberConverter converter = new WordToNumberConverter();
}

@lexer::header {
  package blazon.server.grammar;
}

@rulecatch {
    catch (MyRecognitionException re) {
        System.err.println("Caught MyRecognitionException:");
        System.err.println(re.message);
    } 
    catch (RecognitionException re) {
        reportError(re);
        recover(input,re);
    }
} 

shield returns [Shield s]
		    :   field { $s = Shield.build($field.layer); }
		    ;

field returns [ShieldLayer layer]
		    :   plain_field { $layer = $plain_field.layer; }
		    |   divided_field { $layer = $divided_field.layer; }
		    ;
    
divided_field returns [ShieldLayer layer]
		    : 
		      {
		        ShieldDivisionType division = null;
		        Tinctures tinctures = new Tinctures();
		      }
			    (
			        PARTYPER
			        div {
			            ShieldDivision divisions = new ShieldDivision();
			            division = divisions.getDivisionType($div.text);
			        }
			    |
			        special_div { 
			            ShieldDivision divisions = new ShieldDivision();
			            division = divisions.getDivisionType($special_div.text); 
			        }
			        
			    )
		        some_tinctures[tinctures, division] { $layer = $some_tinctures.layer; }
		    ;    
    
plain_field returns [ShieldLayer layer]
		    :   { Tinctures tinctures = new Tinctures(); }
		        tincture[tinctures] ('plain')?
		        {
		            tinctures.addTincture($tincture.tincture);
		            $layer = ShieldLayer.build(tinctures);
		        }
		    ;

some_tinctures [Tinctures tinctures, ShieldDivisionType division] returns [ShieldLayer layer]
        :   { int count = 0; }    
            (
                t = tincture[tinctures] 
                { tinctures.addTincture($t.tincture); count++; }
            )*
            AND
            t = tincture[tinctures]
            {
		            count++;
		            tinctures.addTincture($t.tincture);
		            int allowableNumberOfTinctures = division.getNumberOfAllowableTinctures();
		            if (allowableNumberOfTinctures != count) {
		                throw new MyRecognitionException(
		                    "Incorrect number of tinctures specified. The '" + division 
		                    + "' division type only allows the following number of tinctures: "
		                    + allowableNumberOfTinctures + " but found " + count);
		            }
		            $layer = ShieldLayer.build(tinctures, division);
		        }
        ;

div     :   DIV MODIFIER?
        ;

special_div returns [String text]
        :   GYRONNY { text = $GYRONNY.text; }
            (
                OF { text += " " + $OF.text; }
                number_digits_or_words
                {
                    try {
                        int gyronnyOf = converter.convert($number_digits_or_words.text);
                        if (gyronnyOf \% 2 == 1) {
                            gyronnyOf++;
                            System.err.println("Parsing 'special_div', gyronny can only be of an"
                                    + " even number; incremented number of sections to " + gyronnyOf);
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

DIV     :   'fess' | 'pale' | 'bend' | 'cross' | 'saltire' | 'chevron' | 'pall'
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

NUMWORDS
        :   'one' | 'eleven' | 'two' | 'twelve' | 'three' | 'thirteen' 
        |   'four''teen'? | 'five' | 'fifteen' | 'six''teen'? | 'seven''teen'?
        |   'eight''een'? | 'nine''teen'? | 'twenty' | 'thirty' | 'fourty'
        |   'fifty' | 'sixty' | 'seventy' | 'eighty' | 'ninety' | 'hundred'
        |   'thousand' | 'million' | 'billion'
        ;
        
WS      :   (' '|'\t')+ {$channel=HIDDEN;}
        ;