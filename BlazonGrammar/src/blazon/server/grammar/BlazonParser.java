// $ANTLR 3.3 Nov 30, 2010 12:50:56 C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g 2011-11-13 14:35:08

package blazon.server.grammar;
import blazon.shared.shield.*;
import blazon.shared.shield.charges.*;
import blazon.shared.shield.ShieldDivision.ShieldDivisionType;
import blazon.shared.shield.diagnostic.ShieldDiagnostic;
import blazon.shared.shield.diagnostic.ShieldDiagnostic.LogLevel;
import blazon.shared.shield.tinctures.*;
import blazon.shared.numberconversion.WordToNumberConverter;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class BlazonParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "DETERMINER", "ORDINARY_DIV", "OTHER_ORDINARY", "SUBORDINARY_DIV", "SUBORDINARY", "MODIFIER", "SUBORDINARY_MULTIPLE", "TIERCED", "PARTYPER", "VARIABLE_DIV", "OF", "CONTINUOUS_DIV", "QUARTER", "AND", "COLOUR", "METAL", "FUR", "DIGITS", "NUMWORDS", "WS", "'plain'"
    };
    public static final int EOF=-1;
    public static final int T__24=24;
    public static final int DETERMINER=4;
    public static final int ORDINARY_DIV=5;
    public static final int OTHER_ORDINARY=6;
    public static final int SUBORDINARY_DIV=7;
    public static final int SUBORDINARY=8;
    public static final int MODIFIER=9;
    public static final int SUBORDINARY_MULTIPLE=10;
    public static final int TIERCED=11;
    public static final int PARTYPER=12;
    public static final int VARIABLE_DIV=13;
    public static final int OF=14;
    public static final int CONTINUOUS_DIV=15;
    public static final int QUARTER=16;
    public static final int AND=17;
    public static final int COLOUR=18;
    public static final int METAL=19;
    public static final int FUR=20;
    public static final int DIGITS=21;
    public static final int NUMWORDS=22;
    public static final int WS=23;

    // delegates
    // delegators


        public BlazonParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public BlazonParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return BlazonParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g"; }


      
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



    // $ANTLR start "shield"
    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:93:1: shield returns [Shield s] : field ( charges[$field.field.getTinctureTypeOfLayer()] )? ;
    public final Shield shield() throws RecognitionException {
        Shield s = null;

        Field field1 = null;

        List<GeometricCharge> charges2 = null;


        try {
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:94:7: ( field ( charges[$field.field.getTinctureTypeOfLayer()] )? )
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:94:11: field ( charges[$field.field.getTinctureTypeOfLayer()] )?
            {
             String blazon = input.toString(); 
            pushFollow(FOLLOW_field_in_shield82);
            field1=field();

            state._fsp--;

             s = ShieldImpl.build(field1, blazon); 
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:96:7: ( charges[$field.field.getTinctureTypeOfLayer()] )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==DETERMINER||(LA1_0>=DIGITS && LA1_0<=NUMWORDS)) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:96:9: charges[$field.field.getTinctureTypeOfLayer()]
                    {
                    pushFollow(FOLLOW_charges_in_shield94);
                    charges2=charges(field1.getTinctureTypeOfLayer());

                    state._fsp--;

                     s.addCharges(charges2); 

                    }
                    break;

            }


            		        //LATER make HTML pretty
            				    //TODO multiple geometric charges
            				    //TODO advanced charges
            				    s.addDiagnostics(diags);
            				

            }

        }
        catch (RecognitionException re) {

            		        reportError(re);
                        return InvalidShield.build(diags);
                    
        }
        finally {
        }
        return s;
    }
    // $ANTLR end "shield"


    // $ANTLR start "field"
    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:109:1: field returns [Field field] : ( div some_tinctures[tinctures, division] | tincture[tinctures] ( 'plain' )? ) ;
    public final Field field() throws RecognitionException {
        Field field = null;

        ShieldDivisionType div3 = null;

        Field some_tinctures4 = null;


        try {
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:110:7: ( ( div some_tinctures[tinctures, division] | tincture[tinctures] ( 'plain' )? ) )
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:110:11: ( div some_tinctures[tinctures, division] | tincture[tinctures] ( 'plain' )? )
            {
             Tinctures tinctures = new Tinctures(); 
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:111:7: ( div some_tinctures[tinctures, division] | tincture[tinctures] ( 'plain' )? )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>=TIERCED && LA3_0<=VARIABLE_DIV)||(LA3_0>=CONTINUOUS_DIV && LA3_0<=QUARTER)) ) {
                alt3=1;
            }
            else if ( ((LA3_0>=COLOUR && LA3_0<=FUR)) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:112:11: div some_tinctures[tinctures, division]
                    {
                    pushFollow(FOLLOW_div_in_field166);
                    div3=div();

                    state._fsp--;

                     ShieldDivisionType division = div3; 
                    pushFollow(FOLLOW_some_tinctures_in_field182);
                    some_tinctures4=some_tinctures(tinctures, division);

                    state._fsp--;

                     field = some_tinctures4; 

                    }
                    break;
                case 2 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:115:13: tincture[tinctures] ( 'plain' )?
                    {
                    pushFollow(FOLLOW_tincture_in_field209);
                    tincture(tinctures);

                    state._fsp--;

                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:115:33: ( 'plain' )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==24) ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:115:33: 'plain'
                            {
                            match(input,24,FOLLOW_24_in_field212); 

                            }
                            break;

                    }


                                    field = Field.buildUndividedShieldLayer(tinctures);
                                

                    }
                    break;

            }


            }

        }

            catch (RecognitionException re) {
                throw re;
            }
        finally {
        }
        return field;
    }
    // $ANTLR end "field"


    // $ANTLR start "charges"
    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:121:1: charges[TinctureType underLayerTinctureType] returns [List<GeometricCharge> charges] : ( DETERMINER single_geometric_charge[tinctures, underLayerTinctureType] | number_digits_or_words multiple_geometric_charges[tinctures, underLayerTinctureType, convertNumber($number_digits_or_words.text)] ) ;
    public final List<GeometricCharge> charges(TinctureType underLayerTinctureType) throws RecognitionException {
        List<GeometricCharge> charges = null;

        Token DETERMINER6=null;
        GeometricCharge single_geometric_charge5 = null;

        BlazonParser.number_digits_or_words_return number_digits_or_words7 = null;

        List<GeometricCharge> multiple_geometric_charges8 = null;


        try {
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:122:9: ( ( DETERMINER single_geometric_charge[tinctures, underLayerTinctureType] | number_digits_or_words multiple_geometric_charges[tinctures, underLayerTinctureType, convertNumber($number_digits_or_words.text)] ) )
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:122:13: ( DETERMINER single_geometric_charge[tinctures, underLayerTinctureType] | number_digits_or_words multiple_geometric_charges[tinctures, underLayerTinctureType, convertNumber($number_digits_or_words.text)] )
            {
             
                          Tinctures tinctures = new Tinctures();
                          charges = new ArrayList<GeometricCharge>();
                        
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:126:13: ( DETERMINER single_geometric_charge[tinctures, underLayerTinctureType] | number_digits_or_words multiple_geometric_charges[tinctures, underLayerTinctureType, convertNumber($number_digits_or_words.text)] )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==DETERMINER) ) {
                int LA4_1 = input.LA(2);

                if ( ((LA4_1>=ORDINARY_DIV && LA4_1<=SUBORDINARY)) ) {
                    alt4=1;
                }
                else if ( (LA4_1==SUBORDINARY_MULTIPLE) ) {
                    alt4=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA4_0>=DIGITS && LA4_0<=NUMWORDS)) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:127:17: DETERMINER single_geometric_charge[tinctures, underLayerTinctureType]
                    {
                    DETERMINER6=(Token)match(input,DETERMINER,FOLLOW_DETERMINER_in_charges288); 
                    pushFollow(FOLLOW_single_geometric_charge_in_charges290);
                    single_geometric_charge5=single_geometric_charge(tinctures, underLayerTinctureType);

                    state._fsp--;

                     
                                        if (single_geometric_charge5 != null) {
                                            charges.add(single_geometric_charge5);
                                            if ("a".equals((DETERMINER6!=null?DETERMINER6.getText():null))) {
                                                String chargeName = single_geometric_charge5.getName().toString().toLowerCase();
                                                if (chargeName.startsWith("a") || chargeName.startsWith("e") || chargeName.startsWith("i") || chargeName.startsWith("o") || chargeName.startsWith("u")) {
                                                    diags.add(ShieldDiagnostic.build(LogLevel.WARN, "You have asked for the charge '" + (DETERMINER6!=null?DETERMINER6.getText():null) + " " + chargeName 
                                                        + "'. A charge starting with a vowel should be preceded by 'an' i.e. 'an " + chargeName + "'."));
                                                }
                                            } else if ("an".equals((DETERMINER6!=null?DETERMINER6.getText():null))) {
                                                String chargeName = single_geometric_charge5.getName().toString().toLowerCase();
                                                if (!(chargeName.startsWith("a") || chargeName.startsWith("e") || chargeName.startsWith("i") || chargeName.startsWith("o") || chargeName.startsWith("u"))) {
                                                    diags.add(ShieldDiagnostic.build(LogLevel.WARN, "You have asked for the charge '" + (DETERMINER6!=null?DETERMINER6.getText():null) + " " + chargeName 
                                                        + "'. A charge starting with a consonants should be preceded by 'a' i.e. 'a " + chargeName + "'."));
                                                }
                                           }
                                       }
                                    

                    }
                    break;
                case 2 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:147:17: number_digits_or_words multiple_geometric_charges[tinctures, underLayerTinctureType, convertNumber($number_digits_or_words.text)]
                    {
                    pushFollow(FOLLOW_number_digits_or_words_in_charges341);
                    number_digits_or_words7=number_digits_or_words();

                    state._fsp--;

                    pushFollow(FOLLOW_multiple_geometric_charges_in_charges343);
                    multiple_geometric_charges8=multiple_geometric_charges(tinctures, underLayerTinctureType, convertNumber((number_digits_or_words7!=null?input.toString(number_digits_or_words7.start,number_digits_or_words7.stop):null)));

                    state._fsp--;


                                        if (multiple_geometric_charges8 != null) {
                                            charges.addAll(multiple_geometric_charges8);
                                        }
                                    

                    }
                    break;

            }


                            
                        

            }

        }

            catch (RecognitionException re) {
                throw re;
            }
        finally {
        }
        return charges;
    }
    // $ANTLR end "charges"


    // $ANTLR start "single_geometric_charge"
    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:159:1: single_geometric_charge[Tinctures tinctures, TinctureType underLayerTinctureType] returns [GeometricCharge charge] : ord= ( ORDINARY_DIV | OTHER_ORDINARY | SUBORDINARY_DIV | SUBORDINARY ) ( MODIFIER )? t= tincture[tinctures] ;
    public final GeometricCharge single_geometric_charge(Tinctures tinctures, TinctureType underLayerTinctureType) throws RecognitionException {
        GeometricCharge charge = null;

        Token ord=null;
        Token MODIFIER9=null;
        Tincture t = null;


        try {
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:160:9: (ord= ( ORDINARY_DIV | OTHER_ORDINARY | SUBORDINARY_DIV | SUBORDINARY ) ( MODIFIER )? t= tincture[tinctures] )
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:160:13: ord= ( ORDINARY_DIV | OTHER_ORDINARY | SUBORDINARY_DIV | SUBORDINARY ) ( MODIFIER )? t= tincture[tinctures]
            {
            ord=(Token)input.LT(1);
            if ( (input.LA(1)>=ORDINARY_DIV && input.LA(1)<=SUBORDINARY) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

             String text = (ord!=null?ord.getText():null); 
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:161:13: ( MODIFIER )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==MODIFIER) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:161:15: MODIFIER
                    {
                    MODIFIER9=(Token)match(input,MODIFIER,FOLLOW_MODIFIER_in_single_geometric_charge460); 
                     text += "_" + (MODIFIER9!=null?MODIFIER9.getText():null); 

                    }
                    break;

            }

            pushFollow(FOLLOW_tincture_in_single_geometric_charge481);
            t=tincture(tinctures);

            state._fsp--;

             
                            diagnoseRuleOfTincture(t, underLayerTinctureType);
                            charge = GeometricCharge.build(text, t, diags);
                        

            }

        }

            catch (RecognitionException re) {
                throw re;
            }
        finally {
        }
        return charge;
    }
    // $ANTLR end "single_geometric_charge"


    // $ANTLR start "multiple_geometric_charges"
    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:169:1: multiple_geometric_charges[Tinctures tinctures, TinctureType underLayerTinctureType, int number] returns [List<GeometricCharge> charges] : ords= SUBORDINARY_MULTIPLE ( MODIFIER )? t= tincture[tinctures] ;
    public final List<GeometricCharge> multiple_geometric_charges(Tinctures tinctures, TinctureType underLayerTinctureType, int number) throws RecognitionException {
        List<GeometricCharge> charges = null;

        Token ords=null;
        Token MODIFIER10=null;
        Tincture t = null;


        try {
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:170:9: (ords= SUBORDINARY_MULTIPLE ( MODIFIER )? t= tincture[tinctures] )
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:170:13: ords= SUBORDINARY_MULTIPLE ( MODIFIER )? t= tincture[tinctures]
            {
            ords=(Token)match(input,SUBORDINARY_MULTIPLE,FOLLOW_SUBORDINARY_MULTIPLE_in_multiple_geometric_charges533); 
             String text = (ords!=null?ords.getText():null); 

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
                        
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:185:13: ( MODIFIER )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==MODIFIER) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:185:15: MODIFIER
                    {
                    MODIFIER10=(Token)match(input,MODIFIER,FOLLOW_MODIFIER_in_multiple_geometric_charges567); 
                     text += "_" + (MODIFIER10!=null?MODIFIER10.getText():null); 

                    }
                    break;

            }

            pushFollow(FOLLOW_tincture_in_multiple_geometric_charges588);
            t=tincture(tinctures);

            state._fsp--;

             
                            diagnoseRuleOfTincture(t, underLayerTinctureType);
                            charges = new ArrayList<GeometricCharge>();
                            for (int i = 0; i < number; i++) {
                                GeometricCharge charge = GeometricCharge.build(text, t, diags);
                                charges.add(charge);
                            }
                        

            }

        }

            catch (RecognitionException re) {
                throw re;
            }
        finally {
        }
        return charges;
    }
    // $ANTLR end "multiple_geometric_charges"


    // $ANTLR start "div"
    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:197:1: div returns [ShieldDivisionType division] : ( ( TIERCED )? PARTYPER divType= ( ORDINARY_DIV | SUBORDINARY_DIV ) (divModifier1= MODIFIER )? | VARIABLE_DIV (divModifier2= MODIFIER )? ( OF number_digits_or_words )? | CONTINUOUS_DIV | QUARTER ) ;
    public final ShieldDivisionType div() throws RecognitionException {
        ShieldDivisionType division = null;

        Token divType=null;
        Token divModifier1=null;
        Token divModifier2=null;
        Token TIERCED11=null;
        Token VARIABLE_DIV12=null;
        Token OF13=null;
        Token CONTINUOUS_DIV15=null;
        Token QUARTER16=null;
        BlazonParser.number_digits_or_words_return number_digits_or_words14 = null;


        try {
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:198:9: ( ( ( TIERCED )? PARTYPER divType= ( ORDINARY_DIV | SUBORDINARY_DIV ) (divModifier1= MODIFIER )? | VARIABLE_DIV (divModifier2= MODIFIER )? ( OF number_digits_or_words )? | CONTINUOUS_DIV | QUARTER ) )
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:198:13: ( ( TIERCED )? PARTYPER divType= ( ORDINARY_DIV | SUBORDINARY_DIV ) (divModifier1= MODIFIER )? | VARIABLE_DIV (divModifier2= MODIFIER )? ( OF number_digits_or_words )? | CONTINUOUS_DIV | QUARTER )
            {
             String text = ""; 
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:199:9: ( ( TIERCED )? PARTYPER divType= ( ORDINARY_DIV | SUBORDINARY_DIV ) (divModifier1= MODIFIER )? | VARIABLE_DIV (divModifier2= MODIFIER )? ( OF number_digits_or_words )? | CONTINUOUS_DIV | QUARTER )
            int alt11=4;
            switch ( input.LA(1) ) {
            case TIERCED:
            case PARTYPER:
                {
                alt11=1;
                }
                break;
            case VARIABLE_DIV:
                {
                alt11=2;
                }
                break;
            case CONTINUOUS_DIV:
                {
                alt11=3;
                }
                break;
            case QUARTER:
                {
                alt11=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:200:13: ( TIERCED )? PARTYPER divType= ( ORDINARY_DIV | SUBORDINARY_DIV ) (divModifier1= MODIFIER )?
                    {
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:200:13: ( TIERCED )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==TIERCED) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:201:17: TIERCED
                            {
                            TIERCED11=(Token)match(input,TIERCED,FOLLOW_TIERCED_in_div680); 
                             text = (TIERCED11!=null?TIERCED11.getText():null) + " "; 

                            }
                            break;

                    }

                    match(input,PARTYPER,FOLLOW_PARTYPER_in_div711); 
                    divType=(Token)input.LT(1);
                    if ( input.LA(1)==ORDINARY_DIV||input.LA(1)==SUBORDINARY_DIV ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                     text += (divType!=null?divType.getText():null); 
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:205:13: (divModifier1= MODIFIER )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==MODIFIER) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:206:17: divModifier1= MODIFIER
                            {
                            divModifier1=(Token)match(input,MODIFIER,FOLLOW_MODIFIER_in_div773); 
                             text += " " + (divModifier1!=null?divModifier1.getText():null); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:209:13: VARIABLE_DIV (divModifier2= MODIFIER )? ( OF number_digits_or_words )?
                    {
                    VARIABLE_DIV12=(Token)match(input,VARIABLE_DIV,FOLLOW_VARIABLE_DIV_in_div814); 
                     text = (VARIABLE_DIV12!=null?VARIABLE_DIV12.getText():null); 
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:210:13: (divModifier2= MODIFIER )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==MODIFIER) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:211:17: divModifier2= MODIFIER
                            {
                            divModifier2=(Token)match(input,MODIFIER,FOLLOW_MODIFIER_in_div852); 
                             text += " " + (divModifier2!=null?divModifier2.getText():null); 

                            }
                            break;

                    }

                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:213:13: ( OF number_digits_or_words )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==OF) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:214:17: OF number_digits_or_words
                            {
                            OF13=(Token)match(input,OF,FOLLOW_OF_in_div901); 
                             text += " " + (OF13!=null?OF13.getText():null); 
                            pushFollow(FOLLOW_number_digits_or_words_in_div921);
                            number_digits_or_words14=number_digits_or_words();

                            state._fsp--;


                            		                int gyronnyOf = convertNumber((number_digits_or_words14!=null?input.toString(number_digits_or_words14.start,number_digits_or_words14.stop):null));
                            		                if (gyronnyOf % 2 != 0) {
                            		                    gyronnyOf++;
                            		                    diags.add(ShieldDiagnostic.build(LogLevel.WARN, "Parsing rule 'div'.  '" + (VARIABLE_DIV12!=null?VARIABLE_DIV12.getText():null) 
                            		                            + "' can only be of an even number; incremented number of sections to " + gyronnyOf));
                            		                }
                            		                text += " " + gyronnyOf;
                                            

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:227:13: CONTINUOUS_DIV
                    {
                    CONTINUOUS_DIV15=(Token)match(input,CONTINUOUS_DIV,FOLLOW_CONTINUOUS_DIV_in_div978); 
                     text = (CONTINUOUS_DIV15!=null?CONTINUOUS_DIV15.getText():null); 

                    }
                    break;
                case 4 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:229:13: QUARTER
                    {
                    QUARTER16=(Token)match(input,QUARTER,FOLLOW_QUARTER_in_div1004); 
                     text = (QUARTER16!=null?QUARTER16.getText():null); 

                    }
                    break;

            }


                        if (state.errorRecovery) {
                            throw new RecognitionException(this.input);
                        }
                        ShieldDivision divisions = new ShieldDivision();
                        division = divisions.getDivisionType(text, diags);
                    

            }

        }

            catch (RecognitionException re) {
                throw re;
            }
        finally {
        }
        return division;
    }
    // $ANTLR end "div"


    // $ANTLR start "some_tinctures"
    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:240:1: some_tinctures[Tinctures tinctures, ShieldDivisionType division] returns [Field layer] : ( tincture[tinctures] )+ AND tincture[tinctures] ;
    public final Field some_tinctures(Tinctures tinctures, ShieldDivisionType division) throws RecognitionException {
        Field layer = null;

        try {
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:241:9: ( ( tincture[tinctures] )+ AND tincture[tinctures] )
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:241:13: ( tincture[tinctures] )+ AND tincture[tinctures]
            {
             int count = 0; 
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:242:13: ( tincture[tinctures] )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>=COLOUR && LA12_0<=FUR)) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:243:17: tincture[tinctures]
            	    {
            	    pushFollow(FOLLOW_tincture_in_some_tinctures1103);
            	    tincture(tinctures);

            	    state._fsp--;

            	     count++; 

            	    }
            	    break;

            	default :
            	    if ( cnt12 >= 1 ) break loop12;
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
            } while (true);

            match(input,AND,FOLLOW_AND_in_some_tinctures1152); 
            pushFollow(FOLLOW_tincture_in_some_tinctures1166);
            tincture(tinctures);

            state._fsp--;


                            count++;
                            int numberOfTinctures = division.getNumberOfTinctures();
                            if (numberOfTinctures != count) {
                                diags.add(ShieldDiagnostic.build(LogLevel.ERROR, "Incorrect number of tinctures specified." +
                                    "  The '" + division + "' division type only allows the following number of tinctures: "
                                    + numberOfTinctures + " but found " + count));
                                throw new RecognitionException(this.input);
                            }
                            layer = Field.buildDividedShieldLayer(tinctures, division);
                        

            }

        }

            catch (RecognitionException re) {
                throw re;
            }
        finally {
        }
        return layer;
    }
    // $ANTLR end "some_tinctures"


    // $ANTLR start "tincture"
    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:261:1: tincture[Tinctures tinctures] returns [Tincture tincture] : ( COLOUR | METAL | FUR ) ;
    public final Tincture tincture(Tinctures tinctures) throws RecognitionException {
        Tincture tincture = null;

        Token COLOUR17=null;
        Token METAL18=null;
        Token FUR19=null;

        try {
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:262:9: ( ( COLOUR | METAL | FUR ) )
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:262:13: ( COLOUR | METAL | FUR )
            {
             String tinctureName = ""; 
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:263:9: ( COLOUR | METAL | FUR )
            int alt13=3;
            switch ( input.LA(1) ) {
            case COLOUR:
                {
                alt13=1;
                }
                break;
            case METAL:
                {
                alt13=2;
                }
                break;
            case FUR:
                {
                alt13=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:263:13: COLOUR
                    {
                    COLOUR17=(Token)match(input,COLOUR,FOLLOW_COLOUR_in_tincture1231); 
                     tinctureName = (COLOUR17!=null?COLOUR17.getText():null); 

                    }
                    break;
                case 2 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:264:13: METAL
                    {
                    METAL18=(Token)match(input,METAL,FOLLOW_METAL_in_tincture1247); 
                     tinctureName = (METAL18!=null?METAL18.getText():null); 

                    }
                    break;
                case 3 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:265:13: FUR
                    {
                    FUR19=(Token)match(input,FUR,FOLLOW_FUR_in_tincture1264); 
                     tinctureName = (FUR19!=null?FUR19.getText():null); 

                    }
                    break;

            }

               try {
                            tincture = tinctures.getTincture(tinctureName);
                            tinctures.addTincture(tincture);
                        } catch (UnknownTinctureException e) {
                            diags.add(ShieldDiagnostic.build(LogLevel.ERROR, "Unknown tincture found. Caught: " + e));
                            throw new RecognitionException(this.input);
                        }
                    

            }

        }

            catch (RecognitionException re) {
                throw re;
            }
        finally {
        }
        return tincture;
    }
    // $ANTLR end "tincture"

    public static class number_digits_or_words_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "number_digits_or_words"
    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:277:1: number_digits_or_words : ( DIGITS | NUMWORDS ( ( AND )? NUMWORDS )* | DETERMINER );
    public final BlazonParser.number_digits_or_words_return number_digits_or_words() throws RecognitionException {
        BlazonParser.number_digits_or_words_return retval = new BlazonParser.number_digits_or_words_return();
        retval.start = input.LT(1);

        try {
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:278:9: ( DIGITS | NUMWORDS ( ( AND )? NUMWORDS )* | DETERMINER )
            int alt16=3;
            switch ( input.LA(1) ) {
            case DIGITS:
                {
                alt16=1;
                }
                break;
            case NUMWORDS:
                {
                alt16=2;
                }
                break;
            case DETERMINER:
                {
                alt16=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:278:13: DIGITS
                    {
                    match(input,DIGITS,FOLLOW_DIGITS_in_number_digits_or_words1316); 

                    }
                    break;
                case 2 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:279:13: NUMWORDS ( ( AND )? NUMWORDS )*
                    {
                    match(input,NUMWORDS,FOLLOW_NUMWORDS_in_number_digits_or_words1330); 
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:279:22: ( ( AND )? NUMWORDS )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==AND||LA15_0==NUMWORDS) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:279:23: ( AND )? NUMWORDS
                    	    {
                    	    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:279:23: ( AND )?
                    	    int alt14=2;
                    	    int LA14_0 = input.LA(1);

                    	    if ( (LA14_0==AND) ) {
                    	        alt14=1;
                    	    }
                    	    switch (alt14) {
                    	        case 1 :
                    	            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:279:23: AND
                    	            {
                    	            match(input,AND,FOLLOW_AND_in_number_digits_or_words1333); 

                    	            }
                    	            break;

                    	    }

                    	    match(input,NUMWORDS,FOLLOW_NUMWORDS_in_number_digits_or_words1336); 

                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);


                    }
                    break;
                case 3 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:280:13: DETERMINER
                    {
                    match(input,DETERMINER,FOLLOW_DETERMINER_in_number_digits_or_words1352); 

                    }
                    break;

            }
            retval.stop = input.LT(-1);

        }

            catch (RecognitionException re) {
                throw re;
            }
        finally {
        }
        return retval;
    }
    // $ANTLR end "number_digits_or_words"

    // Delegated rules


 

    public static final BitSet FOLLOW_field_in_shield82 = new BitSet(new long[]{0x0000000000600012L});
    public static final BitSet FOLLOW_charges_in_shield94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_div_in_field166 = new BitSet(new long[]{0x00000000001C0000L});
    public static final BitSet FOLLOW_some_tinctures_in_field182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tincture_in_field209 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_field212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DETERMINER_in_charges288 = new BitSet(new long[]{0x00000000000001E0L});
    public static final BitSet FOLLOW_single_geometric_charge_in_charges290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_number_digits_or_words_in_charges341 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_multiple_geometric_charges_in_charges343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_single_geometric_charge427 = new BitSet(new long[]{0x00000000001C0200L});
    public static final BitSet FOLLOW_MODIFIER_in_single_geometric_charge460 = new BitSet(new long[]{0x00000000001C0000L});
    public static final BitSet FOLLOW_tincture_in_single_geometric_charge481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUBORDINARY_MULTIPLE_in_multiple_geometric_charges533 = new BitSet(new long[]{0x00000000001C0200L});
    public static final BitSet FOLLOW_MODIFIER_in_multiple_geometric_charges567 = new BitSet(new long[]{0x00000000001C0000L});
    public static final BitSet FOLLOW_tincture_in_multiple_geometric_charges588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TIERCED_in_div680 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_PARTYPER_in_div711 = new BitSet(new long[]{0x00000000000000A0L});
    public static final BitSet FOLLOW_set_in_div729 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_MODIFIER_in_div773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_DIV_in_div814 = new BitSet(new long[]{0x0000000000004202L});
    public static final BitSet FOLLOW_MODIFIER_in_div852 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_OF_in_div901 = new BitSet(new long[]{0x0000000000600010L});
    public static final BitSet FOLLOW_number_digits_or_words_in_div921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONTINUOUS_DIV_in_div978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUARTER_in_div1004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tincture_in_some_tinctures1103 = new BitSet(new long[]{0x00000000001E0000L});
    public static final BitSet FOLLOW_AND_in_some_tinctures1152 = new BitSet(new long[]{0x00000000001C0000L});
    public static final BitSet FOLLOW_tincture_in_some_tinctures1166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COLOUR_in_tincture1231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_METAL_in_tincture1247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUR_in_tincture1264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DIGITS_in_number_digits_or_words1316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMWORDS_in_number_digits_or_words1330 = new BitSet(new long[]{0x0000000000420002L});
    public static final BitSet FOLLOW_AND_in_number_digits_or_words1333 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_NUMWORDS_in_number_digits_or_words1336 = new BitSet(new long[]{0x0000000000420002L});
    public static final BitSet FOLLOW_DETERMINER_in_number_digits_or_words1352 = new BitSet(new long[]{0x0000000000000002L});

}