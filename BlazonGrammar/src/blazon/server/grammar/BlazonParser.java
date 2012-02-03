// $ANTLR 3.3 Nov 30, 2010 12:50:56 /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g 2012-02-03 16:19:27

package blazon.server.grammar;
import blazon.shared.shield.*;
import blazon.shared.shield.charges.*;
import blazon.shared.shield.ShieldDivision.ShieldDivisionType;
import blazon.shared.shield.diagnostic.ShieldDiagnostic;
import blazon.shared.shield.diagnostic.ShieldDiagnostic.LogLevel;
import blazon.shared.shield.tinctures.*;
import blazon.shared.numberconversion.WordToNumberConverter;

import java.util.Map;
import java.util.HashMap;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class BlazonParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "DETERMINER", "ORDINARY_DIV", "OTHER_ORDINARY", "SUBORDINARY_DIV", "SUBORDINARY", "MODIFIER", "SUBORDINARY_MULTIPLE", "MOBILE_CHARGE", "BEAST", "ATTITUDE", "ATTITUDE_MODIFIER", "BODY_PART", "AND", "TIERCED", "PARTYPER", "VARIABLE_DIV", "OF", "CONTINUOUS_DIV", "QUARTER", "COLOUR", "METAL", "FUR", "DIGITS", "NUMWORDS", "WS", "'plain'"
    };
    public static final int EOF=-1;
    public static final int T__29=29;
    public static final int DETERMINER=4;
    public static final int ORDINARY_DIV=5;
    public static final int OTHER_ORDINARY=6;
    public static final int SUBORDINARY_DIV=7;
    public static final int SUBORDINARY=8;
    public static final int MODIFIER=9;
    public static final int SUBORDINARY_MULTIPLE=10;
    public static final int MOBILE_CHARGE=11;
    public static final int BEAST=12;
    public static final int ATTITUDE=13;
    public static final int ATTITUDE_MODIFIER=14;
    public static final int BODY_PART=15;
    public static final int AND=16;
    public static final int TIERCED=17;
    public static final int PARTYPER=18;
    public static final int VARIABLE_DIV=19;
    public static final int OF=20;
    public static final int CONTINUOUS_DIV=21;
    public static final int QUARTER=22;
    public static final int COLOUR=23;
    public static final int METAL=24;
    public static final int FUR=25;
    public static final int DIGITS=26;
    public static final int NUMWORDS=27;
    public static final int WS=28;

    // delegates
    // delegators


        public BlazonParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public BlazonParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return BlazonParser.tokenNames; }
    public String getGrammarFileName() { return "/Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g"; }


      
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
    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:96:1: shield returns [Shield s] : field ( charges[$field.field.getTinctureTypeOfLayer()] )? ;
    public final Shield shield() throws RecognitionException {
        Shield s = null;

        Field field1 = null;

        List<Charge> charges2 = null;


        try {
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:97:7: ( field ( charges[$field.field.getTinctureTypeOfLayer()] )? )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:97:11: field ( charges[$field.field.getTinctureTypeOfLayer()] )?
            {
             String blazon = input.toString(); 
            pushFollow(FOLLOW_field_in_shield82);
            field1=field();

            state._fsp--;

             s = ShieldImpl.build(field1, blazon); 
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:99:7: ( charges[$field.field.getTinctureTypeOfLayer()] )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==DETERMINER||(LA1_0>=DIGITS && LA1_0<=NUMWORDS)) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:99:9: charges[$field.field.getTinctureTypeOfLayer()]
                    {
                    pushFollow(FOLLOW_charges_in_shield94);
                    charges2=charges(field1.getTinctureTypeOfLayer());

                    state._fsp--;

                     s.addCharges(charges2); 

                    }
                    break;

            }


            		        //LATER make HTML pretty
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
    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:110:1: field returns [Field field] : ( div some_tinctures[tinctures, division] | tincture[tinctures] ( 'plain' )? ) ;
    public final Field field() throws RecognitionException {
        Field field = null;

        ShieldDivisionType div3 = null;

        Field some_tinctures4 = null;


        try {
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:111:7: ( ( div some_tinctures[tinctures, division] | tincture[tinctures] ( 'plain' )? ) )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:111:11: ( div some_tinctures[tinctures, division] | tincture[tinctures] ( 'plain' )? )
            {
             Tinctures tinctures = new Tinctures(); 
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:112:7: ( div some_tinctures[tinctures, division] | tincture[tinctures] ( 'plain' )? )
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
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:113:11: div some_tinctures[tinctures, division]
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
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:116:13: tincture[tinctures] ( 'plain' )?
                    {
                    pushFollow(FOLLOW_tincture_in_field209);
                    tincture(tinctures);

                    state._fsp--;

                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:116:33: ( 'plain' )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==29) ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:116:33: 'plain'
                            {
                            match(input,29,FOLLOW_29_in_field212); 

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
    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:122:1: charges[TinctureType underLayerTinctureType] returns [List<Charge> charges] : ( DETERMINER single_geometric_charge[tinctures, underLayerTinctureType] | number_digits_or_words multiple_geometric_charges[tinctures, underLayerTinctureType, convertNumber($number_digits_or_words.text)] | advanced_charge[tinctures, underLayerTinctureType] ) ;
    public final List<Charge> charges(TinctureType underLayerTinctureType) throws RecognitionException {
        List<Charge> charges = null;

        Token DETERMINER6=null;
        GeometricCharge single_geometric_charge5 = null;

        BlazonParser.number_digits_or_words_return number_digits_or_words7 = null;

        List<Charge> multiple_geometric_charges8 = null;

        List<Charge> advanced_charge9 = null;


        try {
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:123:9: ( ( DETERMINER single_geometric_charge[tinctures, underLayerTinctureType] | number_digits_or_words multiple_geometric_charges[tinctures, underLayerTinctureType, convertNumber($number_digits_or_words.text)] | advanced_charge[tinctures, underLayerTinctureType] ) )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:123:13: ( DETERMINER single_geometric_charge[tinctures, underLayerTinctureType] | number_digits_or_words multiple_geometric_charges[tinctures, underLayerTinctureType, convertNumber($number_digits_or_words.text)] | advanced_charge[tinctures, underLayerTinctureType] )
            {
             
                          Tinctures tinctures = new Tinctures();
                          charges = new ArrayList<Charge>();
                        
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:127:13: ( DETERMINER single_geometric_charge[tinctures, underLayerTinctureType] | number_digits_or_words multiple_geometric_charges[tinctures, underLayerTinctureType, convertNumber($number_digits_or_words.text)] | advanced_charge[tinctures, underLayerTinctureType] )
            int alt4=3;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==DETERMINER) ) {
                switch ( input.LA(2) ) {
                case BEAST:
                    {
                    alt4=3;
                    }
                    break;
                case ORDINARY_DIV:
                case OTHER_ORDINARY:
                case SUBORDINARY_DIV:
                case SUBORDINARY:
                    {
                    alt4=1;
                    }
                    break;
                case SUBORDINARY_MULTIPLE:
                case MOBILE_CHARGE:
                    {
                    alt4=2;
                    }
                    break;
                default:
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
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:128:17: DETERMINER single_geometric_charge[tinctures, underLayerTinctureType]
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
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:148:17: number_digits_or_words multiple_geometric_charges[tinctures, underLayerTinctureType, convertNumber($number_digits_or_words.text)]
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
                case 3 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:155:17: advanced_charge[tinctures, underLayerTinctureType]
                    {
                    pushFollow(FOLLOW_advanced_charge_in_charges394);
                    advanced_charge9=advanced_charge(tinctures, underLayerTinctureType);

                    state._fsp--;


                                        if (advanced_charge9 != null) {
                                            charges.addAll(advanced_charge9);
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
    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:167:1: single_geometric_charge[Tinctures tinctures, TinctureType underLayerTinctureType] returns [GeometricCharge charge] : ord= ( ORDINARY_DIV | OTHER_ORDINARY | SUBORDINARY_DIV | SUBORDINARY ) ( MODIFIER )? t= tincture[tinctures] ;
    public final GeometricCharge single_geometric_charge(Tinctures tinctures, TinctureType underLayerTinctureType) throws RecognitionException {
        GeometricCharge charge = null;

        Token ord=null;
        Token MODIFIER10=null;
        Tincture t = null;


        try {
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:168:9: (ord= ( ORDINARY_DIV | OTHER_ORDINARY | SUBORDINARY_DIV | SUBORDINARY ) ( MODIFIER )? t= tincture[tinctures] )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:168:13: ord= ( ORDINARY_DIV | OTHER_ORDINARY | SUBORDINARY_DIV | SUBORDINARY ) ( MODIFIER )? t= tincture[tinctures]
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
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:169:13: ( MODIFIER )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==MODIFIER) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:169:15: MODIFIER
                    {
                    MODIFIER10=(Token)match(input,MODIFIER,FOLLOW_MODIFIER_in_single_geometric_charge510); 
                     text += "_" + (MODIFIER10!=null?MODIFIER10.getText():null); 

                    }
                    break;

            }

            pushFollow(FOLLOW_tincture_in_single_geometric_charge531);
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
    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:177:1: multiple_geometric_charges[Tinctures tinctures, TinctureType underLayerTinctureType, int number] returns [List<Charge> charges] : ords= ( SUBORDINARY_MULTIPLE | MOBILE_CHARGE ) ( MODIFIER )? t= tincture[tinctures] ;
    public final List<Charge> multiple_geometric_charges(Tinctures tinctures, TinctureType underLayerTinctureType, int number) throws RecognitionException {
        List<Charge> charges = null;

        Token ords=null;
        Token MODIFIER11=null;
        Tincture t = null;


        try {
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:178:9: (ords= ( SUBORDINARY_MULTIPLE | MOBILE_CHARGE ) ( MODIFIER )? t= tincture[tinctures] )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:178:13: ords= ( SUBORDINARY_MULTIPLE | MOBILE_CHARGE ) ( MODIFIER )? t= tincture[tinctures]
            {
            ords=(Token)input.LT(1);
            if ( (input.LA(1)>=SUBORDINARY_MULTIPLE && input.LA(1)<=MOBILE_CHARGE) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

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
                        
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:193:13: ( MODIFIER )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==MODIFIER) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:193:15: MODIFIER
                    {
                    MODIFIER11=(Token)match(input,MODIFIER,FOLLOW_MODIFIER_in_multiple_geometric_charges623); 
                     text += "_" + (MODIFIER11!=null?MODIFIER11.getText():null); 

                    }
                    break;

            }

            pushFollow(FOLLOW_tincture_in_multiple_geometric_charges644);
            t=tincture(tinctures);

            state._fsp--;

             
                            diagnoseRuleOfTincture(t, underLayerTinctureType);
                            charges = new ArrayList<Charge>();
                            for (int i = 0; i < number; i++) {
                                Charge charge = GeometricCharge.build(text, t, diags);
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


    // $ANTLR start "advanced_charge"
    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:205:1: advanced_charge[Tinctures tinctures, TinctureType underLayerTinctureType] returns [List<Charge> charges] : DETERMINER BEAST ATTITUDE ( ATTITUDE_MODIFIER )? tincture[tinctures] body_parts[tinctures] ;
    public final List<Charge> advanced_charge(Tinctures tinctures, TinctureType underLayerTinctureType) throws RecognitionException {
        List<Charge> charges = null;

        Token BEAST13=null;
        Token ATTITUDE14=null;
        Token ATTITUDE_MODIFIER15=null;
        Tincture tincture12 = null;

        Map<String, Tincture> body_parts16 = null;


        try {
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:206:9: ( DETERMINER BEAST ATTITUDE ( ATTITUDE_MODIFIER )? tincture[tinctures] body_parts[tinctures] )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:206:12: DETERMINER BEAST ATTITUDE ( ATTITUDE_MODIFIER )? tincture[tinctures] body_parts[tinctures]
            {
            match(input,DETERMINER,FOLLOW_DETERMINER_in_advanced_charge691); 
            BEAST13=(Token)match(input,BEAST,FOLLOW_BEAST_in_advanced_charge693); 
            ATTITUDE14=(Token)match(input,ATTITUDE,FOLLOW_ATTITUDE_in_advanced_charge695); 
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:206:38: ( ATTITUDE_MODIFIER )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==ATTITUDE_MODIFIER) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:206:38: ATTITUDE_MODIFIER
                    {
                    ATTITUDE_MODIFIER15=(Token)match(input,ATTITUDE_MODIFIER,FOLLOW_ATTITUDE_MODIFIER_in_advanced_charge697); 

                    }
                    break;

            }

            pushFollow(FOLLOW_tincture_in_advanced_charge700);
            tincture12=tincture(tinctures);

            state._fsp--;

            pushFollow(FOLLOW_body_parts_in_advanced_charge703);
            body_parts16=body_parts(tinctures);

            state._fsp--;


                           diagnoseRuleOfTincture(tincture12, underLayerTinctureType);
                           AdvancedCharge charge = AdvancedCharge.build((BEAST13!=null?BEAST13.getText():null), (ATTITUDE14!=null?ATTITUDE14.getText():null), (ATTITUDE_MODIFIER15!=null?ATTITUDE_MODIFIER15.getText():null), tincture12, body_parts16);
                           charges = new ArrayList<Charge>();
                           charges.add(charge);
                       

            }

        }

            catch (RecognitionException re) {
                throw re;
            }
        finally {
        }
        return charges;
    }
    // $ANTLR end "advanced_charge"


    // $ANTLR start "body_parts"
    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:215:1: body_parts[Tinctures tinctures] returns [Map<String, Tincture> bodyParts] : ( BODY_PART tincture[tinctures] | (bp1= BODY_PART t1= tincture[tinctures] )* AND bp2= BODY_PART t2= tincture[tinctures] );
    public final Map<String, Tincture> body_parts(Tinctures tinctures) throws RecognitionException {
        Map<String, Tincture> bodyParts = null;

        Token bp1=null;
        Token bp2=null;
        Token BODY_PART17=null;
        Tincture t1 = null;

        Tincture t2 = null;

        Tincture tincture18 = null;


        try {
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:216:8: ( BODY_PART tincture[tinctures] | (bp1= BODY_PART t1= tincture[tinctures] )* AND bp2= BODY_PART t2= tincture[tinctures] )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==BODY_PART) ) {
                switch ( input.LA(2) ) {
                case COLOUR:
                    {
                    int LA9_3 = input.LA(3);

                    if ( (LA9_3==EOF) ) {
                        alt9=1;
                    }
                    else if ( ((LA9_3>=BODY_PART && LA9_3<=AND)) ) {
                        alt9=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 3, input);

                        throw nvae;
                    }
                    }
                    break;
                case METAL:
                    {
                    int LA9_4 = input.LA(3);

                    if ( (LA9_4==EOF) ) {
                        alt9=1;
                    }
                    else if ( ((LA9_4>=BODY_PART && LA9_4<=AND)) ) {
                        alt9=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 4, input);

                        throw nvae;
                    }
                    }
                    break;
                case FUR:
                    {
                    int LA9_5 = input.LA(3);

                    if ( (LA9_5==EOF) ) {
                        alt9=1;
                    }
                    else if ( ((LA9_5>=BODY_PART && LA9_5<=AND)) ) {
                        alt9=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 5, input);

                        throw nvae;
                    }
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 1, input);

                    throw nvae;
                }

            }
            else if ( (LA9_0==AND) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:216:11: BODY_PART tincture[tinctures]
                    {
                     bodyParts = new HashMap<String, Tincture>(); 
                    BODY_PART17=(Token)match(input,BODY_PART,FOLLOW_BODY_PART_in_body_parts769); 
                    pushFollow(FOLLOW_tincture_in_body_parts771);
                    tincture18=tincture(tinctures);

                    state._fsp--;

                     bodyParts.put((BODY_PART17!=null?BODY_PART17.getText():null) , tincture18); 

                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:220:13: (bp1= BODY_PART t1= tincture[tinctures] )* AND bp2= BODY_PART t2= tincture[tinctures]
                    {
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:220:13: (bp1= BODY_PART t1= tincture[tinctures] )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==BODY_PART) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:221:13: bp1= BODY_PART t1= tincture[tinctures]
                    	    {
                    	    bp1=(Token)match(input,BODY_PART,FOLLOW_BODY_PART_in_body_parts828); 
                    	    pushFollow(FOLLOW_tincture_in_body_parts832);
                    	    t1=tincture(tinctures);

                    	    state._fsp--;

                    	     bodyParts.put((bp1!=null?bp1.getText():null) , t1); 

                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);

                    match(input,AND,FOLLOW_AND_in_body_parts876); 
                    bp2=(Token)match(input,BODY_PART,FOLLOW_BODY_PART_in_body_parts880); 
                    pushFollow(FOLLOW_tincture_in_body_parts884);
                    t2=tincture(tinctures);

                    state._fsp--;

                     bodyParts.put((bp2!=null?bp2.getText():null) , t2); 

                    }
                    break;

            }
        }

            catch (RecognitionException re) {
                throw re;
            }
        finally {
        }
        return bodyParts;
    }
    // $ANTLR end "body_parts"


    // $ANTLR start "div"
    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:228:1: div returns [ShieldDivisionType division] : ( ( TIERCED )? PARTYPER divType= ( ORDINARY_DIV | SUBORDINARY_DIV ) (divModifier1= MODIFIER )? | VARIABLE_DIV (divModifier2= MODIFIER )? ( OF number_digits_or_words )? | CONTINUOUS_DIV | QUARTER ) ;
    public final ShieldDivisionType div() throws RecognitionException {
        ShieldDivisionType division = null;

        Token divType=null;
        Token divModifier1=null;
        Token divModifier2=null;
        Token TIERCED19=null;
        Token VARIABLE_DIV20=null;
        Token OF21=null;
        Token CONTINUOUS_DIV23=null;
        Token QUARTER24=null;
        BlazonParser.number_digits_or_words_return number_digits_or_words22 = null;


        try {
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:229:9: ( ( ( TIERCED )? PARTYPER divType= ( ORDINARY_DIV | SUBORDINARY_DIV ) (divModifier1= MODIFIER )? | VARIABLE_DIV (divModifier2= MODIFIER )? ( OF number_digits_or_words )? | CONTINUOUS_DIV | QUARTER ) )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:229:13: ( ( TIERCED )? PARTYPER divType= ( ORDINARY_DIV | SUBORDINARY_DIV ) (divModifier1= MODIFIER )? | VARIABLE_DIV (divModifier2= MODIFIER )? ( OF number_digits_or_words )? | CONTINUOUS_DIV | QUARTER )
            {
             String text = ""; 
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:230:9: ( ( TIERCED )? PARTYPER divType= ( ORDINARY_DIV | SUBORDINARY_DIV ) (divModifier1= MODIFIER )? | VARIABLE_DIV (divModifier2= MODIFIER )? ( OF number_digits_or_words )? | CONTINUOUS_DIV | QUARTER )
            int alt14=4;
            switch ( input.LA(1) ) {
            case TIERCED:
            case PARTYPER:
                {
                alt14=1;
                }
                break;
            case VARIABLE_DIV:
                {
                alt14=2;
                }
                break;
            case CONTINUOUS_DIV:
                {
                alt14=3;
                }
                break;
            case QUARTER:
                {
                alt14=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:231:13: ( TIERCED )? PARTYPER divType= ( ORDINARY_DIV | SUBORDINARY_DIV ) (divModifier1= MODIFIER )?
                    {
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:231:13: ( TIERCED )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==TIERCED) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:232:17: TIERCED
                            {
                            TIERCED19=(Token)match(input,TIERCED,FOLLOW_TIERCED_in_div983); 
                             text = (TIERCED19!=null?TIERCED19.getText():null) + " "; 

                            }
                            break;

                    }

                    match(input,PARTYPER,FOLLOW_PARTYPER_in_div1014); 
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
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:236:13: (divModifier1= MODIFIER )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==MODIFIER) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:237:17: divModifier1= MODIFIER
                            {
                            divModifier1=(Token)match(input,MODIFIER,FOLLOW_MODIFIER_in_div1076); 
                             text += " " + (divModifier1!=null?divModifier1.getText():null); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:240:13: VARIABLE_DIV (divModifier2= MODIFIER )? ( OF number_digits_or_words )?
                    {
                    VARIABLE_DIV20=(Token)match(input,VARIABLE_DIV,FOLLOW_VARIABLE_DIV_in_div1117); 
                     text = (VARIABLE_DIV20!=null?VARIABLE_DIV20.getText():null); 
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:241:13: (divModifier2= MODIFIER )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==MODIFIER) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:242:17: divModifier2= MODIFIER
                            {
                            divModifier2=(Token)match(input,MODIFIER,FOLLOW_MODIFIER_in_div1155); 
                             text += " " + (divModifier2!=null?divModifier2.getText():null); 

                            }
                            break;

                    }

                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:244:13: ( OF number_digits_or_words )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==OF) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:245:17: OF number_digits_or_words
                            {
                            OF21=(Token)match(input,OF,FOLLOW_OF_in_div1204); 
                             text += " " + (OF21!=null?OF21.getText():null); 
                            pushFollow(FOLLOW_number_digits_or_words_in_div1224);
                            number_digits_or_words22=number_digits_or_words();

                            state._fsp--;


                            		                int gyronnyOf = convertNumber((number_digits_or_words22!=null?input.toString(number_digits_or_words22.start,number_digits_or_words22.stop):null));
                            		                if (gyronnyOf % 2 != 0) {
                            		                    gyronnyOf++;
                            		                    diags.add(ShieldDiagnostic.build(LogLevel.WARN, "Parsing rule 'div'.  '" + (VARIABLE_DIV20!=null?VARIABLE_DIV20.getText():null) 
                            		                            + "' can only be of an even number; incremented number of sections to " + gyronnyOf));
                            		                }
                            		                text += " " + gyronnyOf;
                                            

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:258:13: CONTINUOUS_DIV
                    {
                    CONTINUOUS_DIV23=(Token)match(input,CONTINUOUS_DIV,FOLLOW_CONTINUOUS_DIV_in_div1281); 
                     text = (CONTINUOUS_DIV23!=null?CONTINUOUS_DIV23.getText():null); 

                    }
                    break;
                case 4 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:260:13: QUARTER
                    {
                    QUARTER24=(Token)match(input,QUARTER,FOLLOW_QUARTER_in_div1307); 
                     text = (QUARTER24!=null?QUARTER24.getText():null); 

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
    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:271:1: some_tinctures[Tinctures tinctures, ShieldDivisionType division] returns [Field layer] : ( tincture[tinctures] )+ AND tincture[tinctures] ;
    public final Field some_tinctures(Tinctures tinctures, ShieldDivisionType division) throws RecognitionException {
        Field layer = null;

        try {
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:272:9: ( ( tincture[tinctures] )+ AND tincture[tinctures] )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:272:13: ( tincture[tinctures] )+ AND tincture[tinctures]
            {
             int count = 0; 
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:273:13: ( tincture[tinctures] )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>=COLOUR && LA15_0<=FUR)) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:274:17: tincture[tinctures]
            	    {
            	    pushFollow(FOLLOW_tincture_in_some_tinctures1406);
            	    tincture(tinctures);

            	    state._fsp--;

            	     count++; 

            	    }
            	    break;

            	default :
            	    if ( cnt15 >= 1 ) break loop15;
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
            } while (true);

            match(input,AND,FOLLOW_AND_in_some_tinctures1455); 
            pushFollow(FOLLOW_tincture_in_some_tinctures1469);
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
    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:292:1: tincture[Tinctures tinctures] returns [Tincture tincture] : ( COLOUR | METAL | FUR ) ;
    public final Tincture tincture(Tinctures tinctures) throws RecognitionException {
        Tincture tincture = null;

        Token COLOUR25=null;
        Token METAL26=null;
        Token FUR27=null;

        try {
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:293:9: ( ( COLOUR | METAL | FUR ) )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:293:13: ( COLOUR | METAL | FUR )
            {
             String tinctureName = ""; 
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:294:9: ( COLOUR | METAL | FUR )
            int alt16=3;
            switch ( input.LA(1) ) {
            case COLOUR:
                {
                alt16=1;
                }
                break;
            case METAL:
                {
                alt16=2;
                }
                break;
            case FUR:
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
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:294:13: COLOUR
                    {
                    COLOUR25=(Token)match(input,COLOUR,FOLLOW_COLOUR_in_tincture1534); 
                     tinctureName = (COLOUR25!=null?COLOUR25.getText():null); 

                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:295:13: METAL
                    {
                    METAL26=(Token)match(input,METAL,FOLLOW_METAL_in_tincture1550); 
                     tinctureName = (METAL26!=null?METAL26.getText():null); 

                    }
                    break;
                case 3 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:296:13: FUR
                    {
                    FUR27=(Token)match(input,FUR,FOLLOW_FUR_in_tincture1567); 
                     tinctureName = (FUR27!=null?FUR27.getText():null); 

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
    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:308:1: number_digits_or_words : ( DIGITS | NUMWORDS ( ( AND )? NUMWORDS )* | DETERMINER );
    public final BlazonParser.number_digits_or_words_return number_digits_or_words() throws RecognitionException {
        BlazonParser.number_digits_or_words_return retval = new BlazonParser.number_digits_or_words_return();
        retval.start = input.LT(1);

        try {
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:309:9: ( DIGITS | NUMWORDS ( ( AND )? NUMWORDS )* | DETERMINER )
            int alt19=3;
            switch ( input.LA(1) ) {
            case DIGITS:
                {
                alt19=1;
                }
                break;
            case NUMWORDS:
                {
                alt19=2;
                }
                break;
            case DETERMINER:
                {
                alt19=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:309:13: DIGITS
                    {
                    match(input,DIGITS,FOLLOW_DIGITS_in_number_digits_or_words1619); 

                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:310:13: NUMWORDS ( ( AND )? NUMWORDS )*
                    {
                    match(input,NUMWORDS,FOLLOW_NUMWORDS_in_number_digits_or_words1633); 
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:310:22: ( ( AND )? NUMWORDS )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==AND||LA18_0==NUMWORDS) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:310:23: ( AND )? NUMWORDS
                    	    {
                    	    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:310:23: ( AND )?
                    	    int alt17=2;
                    	    int LA17_0 = input.LA(1);

                    	    if ( (LA17_0==AND) ) {
                    	        alt17=1;
                    	    }
                    	    switch (alt17) {
                    	        case 1 :
                    	            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:310:23: AND
                    	            {
                    	            match(input,AND,FOLLOW_AND_in_number_digits_or_words1636); 

                    	            }
                    	            break;

                    	    }

                    	    match(input,NUMWORDS,FOLLOW_NUMWORDS_in_number_digits_or_words1639); 

                    	    }
                    	    break;

                    	default :
                    	    break loop18;
                        }
                    } while (true);


                    }
                    break;
                case 3 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:311:13: DETERMINER
                    {
                    match(input,DETERMINER,FOLLOW_DETERMINER_in_number_digits_or_words1655); 

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


 

    public static final BitSet FOLLOW_field_in_shield82 = new BitSet(new long[]{0x000000000C000012L});
    public static final BitSet FOLLOW_charges_in_shield94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_div_in_field166 = new BitSet(new long[]{0x0000000003800000L});
    public static final BitSet FOLLOW_some_tinctures_in_field182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tincture_in_field209 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_field212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DETERMINER_in_charges288 = new BitSet(new long[]{0x00000000000001E0L});
    public static final BitSet FOLLOW_single_geometric_charge_in_charges290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_number_digits_or_words_in_charges341 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_multiple_geometric_charges_in_charges343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_advanced_charge_in_charges394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_single_geometric_charge478 = new BitSet(new long[]{0x0000000003800200L});
    public static final BitSet FOLLOW_MODIFIER_in_single_geometric_charge510 = new BitSet(new long[]{0x0000000003800000L});
    public static final BitSet FOLLOW_tincture_in_single_geometric_charge531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_multiple_geometric_charges583 = new BitSet(new long[]{0x0000000003800200L});
    public static final BitSet FOLLOW_MODIFIER_in_multiple_geometric_charges623 = new BitSet(new long[]{0x0000000003800000L});
    public static final BitSet FOLLOW_tincture_in_multiple_geometric_charges644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DETERMINER_in_advanced_charge691 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_BEAST_in_advanced_charge693 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ATTITUDE_in_advanced_charge695 = new BitSet(new long[]{0x0000000003804000L});
    public static final BitSet FOLLOW_ATTITUDE_MODIFIER_in_advanced_charge697 = new BitSet(new long[]{0x0000000003800000L});
    public static final BitSet FOLLOW_tincture_in_advanced_charge700 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_body_parts_in_advanced_charge703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BODY_PART_in_body_parts769 = new BitSet(new long[]{0x0000000003800000L});
    public static final BitSet FOLLOW_tincture_in_body_parts771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BODY_PART_in_body_parts828 = new BitSet(new long[]{0x0000000003800000L});
    public static final BitSet FOLLOW_tincture_in_body_parts832 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_AND_in_body_parts876 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_BODY_PART_in_body_parts880 = new BitSet(new long[]{0x0000000003800000L});
    public static final BitSet FOLLOW_tincture_in_body_parts884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TIERCED_in_div983 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_PARTYPER_in_div1014 = new BitSet(new long[]{0x00000000000000A0L});
    public static final BitSet FOLLOW_set_in_div1032 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_MODIFIER_in_div1076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_DIV_in_div1117 = new BitSet(new long[]{0x0000000000100202L});
    public static final BitSet FOLLOW_MODIFIER_in_div1155 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_OF_in_div1204 = new BitSet(new long[]{0x000000000C000010L});
    public static final BitSet FOLLOW_number_digits_or_words_in_div1224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONTINUOUS_DIV_in_div1281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUARTER_in_div1307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tincture_in_some_tinctures1406 = new BitSet(new long[]{0x0000000003810000L});
    public static final BitSet FOLLOW_AND_in_some_tinctures1455 = new BitSet(new long[]{0x0000000003800000L});
    public static final BitSet FOLLOW_tincture_in_some_tinctures1469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COLOUR_in_tincture1534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_METAL_in_tincture1550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUR_in_tincture1567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DIGITS_in_number_digits_or_words1619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMWORDS_in_number_digits_or_words1633 = new BitSet(new long[]{0x0000000008010002L});
    public static final BitSet FOLLOW_AND_in_number_digits_or_words1636 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_NUMWORDS_in_number_digits_or_words1639 = new BitSet(new long[]{0x0000000008010002L});
    public static final BitSet FOLLOW_DETERMINER_in_number_digits_or_words1655 = new BitSet(new long[]{0x0000000000000002L});

}