// $ANTLR 3.3 Nov 30, 2010 12:50:56 C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g 2012-03-14 18:23:36

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "DETERMINER", "ORDINARY_DIV", "OTHER_ORDINARY", "SUBORDINARY_DIV", "SUBORDINARY", "MODIFIER", "SUBORDINARY_MULTIPLE", "MOBILE_CHARGE", "BEAST", "WINGED_BEAST", "ATTITUDE", "BIRD_FLYING_INSECT", "FLYING_ATTITUDE", "SWIMMING_BEAST", "SWIMMING_ATTITUDE", "ATTITUDE_MODIFIER", "BODY_PART", "AND", "TIERCED", "PARTYPER", "VARIABLE_DIV", "OF", "CONTINUOUS_DIV", "QUARTER", "COLOUR", "METAL", "FUR", "PROPER", "DIGITS", "NUMWORDS", "WS", "'plain'"
    };
    public static final int EOF=-1;
    public static final int T__35=35;
    public static final int DETERMINER=4;
    public static final int ORDINARY_DIV=5;
    public static final int OTHER_ORDINARY=6;
    public static final int SUBORDINARY_DIV=7;
    public static final int SUBORDINARY=8;
    public static final int MODIFIER=9;
    public static final int SUBORDINARY_MULTIPLE=10;
    public static final int MOBILE_CHARGE=11;
    public static final int BEAST=12;
    public static final int WINGED_BEAST=13;
    public static final int ATTITUDE=14;
    public static final int BIRD_FLYING_INSECT=15;
    public static final int FLYING_ATTITUDE=16;
    public static final int SWIMMING_BEAST=17;
    public static final int SWIMMING_ATTITUDE=18;
    public static final int ATTITUDE_MODIFIER=19;
    public static final int BODY_PART=20;
    public static final int AND=21;
    public static final int TIERCED=22;
    public static final int PARTYPER=23;
    public static final int VARIABLE_DIV=24;
    public static final int OF=25;
    public static final int CONTINUOUS_DIV=26;
    public static final int QUARTER=27;
    public static final int COLOUR=28;
    public static final int METAL=29;
    public static final int FUR=30;
    public static final int PROPER=31;
    public static final int DIGITS=32;
    public static final int NUMWORDS=33;
    public static final int WS=34;

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

    public BlazonParser(TokenStream input, RecognizerSharedState state,
    		List<ShieldDiagnostic> diags) {
    	super(input, state);
    	this.diags = diags;
    }

    private WordToNumberConverter converter = new WordToNumberConverter();
    private List<ShieldDiagnostic> diags;

    private void diagnoseRuleOfTincture(Tincture t,
    		TinctureType underLayerTinctureType) {
    	TinctureType thisTinctureType = t.getTinctureType();
    	if (underLayerTinctureType == thisTinctureType) {
    		if (thisTinctureType == TinctureType.COLOUR
    				|| thisTinctureType == TinctureType.METAL) {
    			diags.add(ShieldDiagnostic
    					.build(LogLevel.WARNING,
    							"You are not obeying the rule of tincture. You can not put a colour on a colour, or a metal on a metal"));
    		}
    	}
    }

    private String checkForPlurals(String text, int number) {
      if (number > 1) {
        if (!text.endsWith("s")) {
          diags.add(ShieldDiagnostic.build(LogLevel.WARNING, 
              "You have specified that there is more than one of a charge, but not used the plural. Changing '"
               + text + "' to '" + text + "s'."));
        } else {
          text = text.substring(0, text.length() - 1);
        }
      } else if (number == 1) {
        if (text.endsWith("s")) {
          text = text.substring(0, text.length() - 1);
          diags.add(ShieldDiagnostic.build(LogLevel.WARNING,
              "You have specified that there is only one of a charge, but used the plural. Changing '"
               + text + "s' to '" + text + "'."));
        }
      }
      return text;
    }

    private boolean startsWithAVowel(String word) {
      return word.startsWith("a") || word.startsWith("e") || word.startsWith("i") || word.startsWith("o") || word.startsWith("u");
    }

    private int convertNumber(String numberWords) throws RecognitionException {
    	try {
    		if (numberWords.equals("a") || numberWords.equals("an")) {
    			return 1;
    		}
    		return converter.convert(numberWords);
    	} catch (Exception e) {
    		diags.add(ShieldDiagnostic.build(LogLevel.ERROR, "Unable to convert '"
    				+ numberWords + "' into an integer. Caught: " + e));
    		throw new RecognitionException(this.input);
    	}
    }

    @Override
    public void emitErrorMessage(String msg) {
    	diags.add(ShieldDiagnostic.build(LogLevel.ERROR, msg));
    }

    protected void mismatch(IntStream input, int ttype, BitSet follow)
    		throws RecognitionException {
    	throw new MismatchedTokenException(ttype, input);
    }

    public Object recoverFromMismatchedSet(IntStream input, RecognitionException e, BitSet follow) throws RecognitionException {
    	throw e;
    }



    // $ANTLR start "shield"
    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:154:1: shield returns [Shield s] : field ( charges[$field.field.getTinctureTypeOfLayer()] )* ;
    public final Shield shield() throws RecognitionException {
        Shield s = null;

        Field field1 = null;

        List<Charge> charges2 = null;


        try {
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:155:3: ( field ( charges[$field.field.getTinctureTypeOfLayer()] )* )
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:156:3: field ( charges[$field.field.getTinctureTypeOfLayer()] )*
            {

                String blazon = input.toString();
              
            pushFollow(FOLLOW_field_in_shield73);
            field1=field();

            state._fsp--;


                s = ShieldImpl.build(field1, blazon);
              
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:162:3: ( charges[$field.field.getTinctureTypeOfLayer()] )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==DETERMINER||(LA1_0>=DIGITS && LA1_0<=NUMWORDS)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:163:5: charges[$field.field.getTinctureTypeOfLayer()]
            	    {
            	    pushFollow(FOLLOW_charges_in_shield85);
            	    charges2=charges(field1.getTinctureTypeOfLayer());

            	    state._fsp--;


            	          s.addCharges(charges2);
            	        

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


                s.addDiagnostics(diags);
              

            }

        }
        catch (RecognitionException e) {

              displayRecognitionError(this.getTokenNames(), e);
              return InvalidShield.build(diags);

        }
        finally {
        }
        return s;
    }
    // $ANTLR end "shield"


    // $ANTLR start "field"
    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:175:1: field returns [Field field] : ( div some_tinctures[tinctures, division] | tincture[tinctures] ( 'plain' )? ) ;
    public final Field field() throws RecognitionException {
        Field field = null;

        ShieldDivisionType div3 = null;

        Field some_tinctures4 = null;


        try {
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:176:3: ( ( div some_tinctures[tinctures, division] | tincture[tinctures] ( 'plain' )? ) )
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:177:3: ( div some_tinctures[tinctures, division] | tincture[tinctures] ( 'plain' )? )
            {

                Tinctures tinctures = new Tinctures();
              
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:180:3: ( div some_tinctures[tinctures, division] | tincture[tinctures] ( 'plain' )? )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>=TIERCED && LA3_0<=VARIABLE_DIV)||(LA3_0>=CONTINUOUS_DIV && LA3_0<=QUARTER)) ) {
                alt3=1;
            }
            else if ( ((LA3_0>=COLOUR && LA3_0<=PROPER)) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:181:5: div some_tinctures[tinctures, division]
                    {
                    pushFollow(FOLLOW_div_in_field130);
                    div3=div();

                    state._fsp--;


                          ShieldDivisionType division = div3;
                        
                    pushFollow(FOLLOW_some_tinctures_in_field138);
                    some_tinctures4=some_tinctures(tinctures, division);

                    state._fsp--;


                          field = some_tinctures4;
                        

                    }
                    break;
                case 2 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:188:5: tincture[tinctures] ( 'plain' )?
                    {
                    pushFollow(FOLLOW_tincture_in_field151);
                    tincture(tinctures);

                    state._fsp--;

                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:188:25: ( 'plain' )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==35) ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:188:25: 'plain'
                            {
                            match(input,35,FOLLOW_35_in_field154); 

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
    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:193:1: charges[TinctureType underLayerTinctureType] returns [List<Charge> charges] : ( DETERMINER single_geometric_charge[tinctures, underLayerTinctureType] | geometricCount= number_digits_or_words multiple_geometric_charges[tinctures, underLayerTinctureType, convertNumber($geometricCount.text)] | advancedCount= number_digits_or_words advanced_charge[tinctures, underLayerTinctureType, convertNumber($advancedCount.text)] ) ;
    public final List<Charge> charges(TinctureType underLayerTinctureType) throws RecognitionException {
        List<Charge> charges = null;

        Token DETERMINER6=null;
        BlazonParser.number_digits_or_words_return geometricCount = null;

        BlazonParser.number_digits_or_words_return advancedCount = null;

        GeometricCharge single_geometric_charge5 = null;

        List <Charge> multiple_geometric_charges7 = null;

        List <Charge> advanced_charge8 = null;


        try {
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:194:3: ( ( DETERMINER single_geometric_charge[tinctures, underLayerTinctureType] | geometricCount= number_digits_or_words multiple_geometric_charges[tinctures, underLayerTinctureType, convertNumber($geometricCount.text)] | advancedCount= number_digits_or_words advanced_charge[tinctures, underLayerTinctureType, convertNumber($advancedCount.text)] ) )
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:195:3: ( DETERMINER single_geometric_charge[tinctures, underLayerTinctureType] | geometricCount= number_digits_or_words multiple_geometric_charges[tinctures, underLayerTinctureType, convertNumber($geometricCount.text)] | advancedCount= number_digits_or_words advanced_charge[tinctures, underLayerTinctureType, convertNumber($advancedCount.text)] )
            {

                Tinctures tinctures = new Tinctures();
                charges = new ArrayList<Charge>();
              
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:199:3: ( DETERMINER single_geometric_charge[tinctures, underLayerTinctureType] | geometricCount= number_digits_or_words multiple_geometric_charges[tinctures, underLayerTinctureType, convertNumber($geometricCount.text)] | advancedCount= number_digits_or_words advanced_charge[tinctures, underLayerTinctureType, convertNumber($advancedCount.text)] )
            int alt4=3;
            alt4 = dfa4.predict(input);
            switch (alt4) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:200:5: DETERMINER single_geometric_charge[tinctures, underLayerTinctureType]
                    {
                    DETERMINER6=(Token)match(input,DETERMINER,FOLLOW_DETERMINER_in_charges188); 
                    pushFollow(FOLLOW_single_geometric_charge_in_charges190);
                    single_geometric_charge5=single_geometric_charge(tinctures, underLayerTinctureType);

                    state._fsp--;


                          if (single_geometric_charge5 != null) {
                    			  charges.add(single_geometric_charge5);
                    				if ("a".equals((DETERMINER6!=null?DETERMINER6.getText():null))) {
                    					String chargeName = single_geometric_charge5.getName().toString().toLowerCase();
                    					if (startsWithAVowel(chargeName)) {
                    						diags.add(ShieldDiagnostic.build(LogLevel.WARNING,
                    										"You have asked for the charge '" + (DETERMINER6!=null?DETERMINER6.getText():null) + " " + chargeName
                    												+ "'. A charge starting with a vowel should be preceded by 'an' i.e. 'an "
                    												+ chargeName + "'."));
                    					}
                    				} else if ("an".equals((DETERMINER6!=null?DETERMINER6.getText():null))) {
                    					String chargeName = single_geometric_charge5.getName().toString().toLowerCase();
                    					if (!startsWithAVowel(chargeName)) {
                    						diags.add(ShieldDiagnostic.build(LogLevel.WARNING,
                    										"You have asked for the charge '" + (DETERMINER6!=null?DETERMINER6.getText():null) + " " + chargeName
                    											  + "'. A charge starting with a consonants should be preceded by 'a' i.e. 'a "
                    												+ chargeName + "'."));
                    					}
                    	     }
                         }
                       

                    }
                    break;
                case 2 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:222:4: geometricCount= number_digits_or_words multiple_geometric_charges[tinctures, underLayerTinctureType, convertNumber($geometricCount.text)]
                    {
                    pushFollow(FOLLOW_number_digits_or_words_in_charges200);
                    geometricCount=number_digits_or_words();

                    state._fsp--;

                    pushFollow(FOLLOW_multiple_geometric_charges_in_charges202);
                    multiple_geometric_charges7=multiple_geometric_charges(tinctures, underLayerTinctureType, convertNumber((geometricCount!=null?input.toString(geometricCount.start,geometricCount.stop):null)));

                    state._fsp--;


                         if (multiple_geometric_charges7 != null) {
                    	     charges.addAll(multiple_geometric_charges7);
                         }
                       

                    }
                    break;
                case 3 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:227:4: advancedCount= number_digits_or_words advanced_charge[tinctures, underLayerTinctureType, convertNumber($advancedCount.text)]
                    {
                    pushFollow(FOLLOW_number_digits_or_words_in_charges212);
                    advancedCount=number_digits_or_words();

                    state._fsp--;

                    pushFollow(FOLLOW_advanced_charge_in_charges214);
                    advanced_charge8=advanced_charge(tinctures, underLayerTinctureType, convertNumber((advancedCount!=null?input.toString(advancedCount.start,advancedCount.stop):null)));

                    state._fsp--;


                         if (advanced_charge8 != null) {
                    	     charges.addAll(advanced_charge8);
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
    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:234:1: single_geometric_charge[Tinctures tinctures, TinctureType underLayerTinctureType] returns [GeometricCharge charge] : ord= ( ORDINARY_DIV | OTHER_ORDINARY | SUBORDINARY_DIV | SUBORDINARY ) ( MODIFIER )? t= tincture[tinctures] ;
    public final GeometricCharge single_geometric_charge(Tinctures tinctures, TinctureType underLayerTinctureType) throws RecognitionException {
        GeometricCharge charge = null;

        Token ord=null;
        Token MODIFIER9=null;
        Tincture t = null;


        try {
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:235:3: (ord= ( ORDINARY_DIV | OTHER_ORDINARY | SUBORDINARY_DIV | SUBORDINARY ) ( MODIFIER )? t= tincture[tinctures] )
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:236:3: ord= ( ORDINARY_DIV | OTHER_ORDINARY | SUBORDINARY_DIV | SUBORDINARY ) ( MODIFIER )? t= tincture[tinctures]
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
              
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:245:3: ( MODIFIER )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==MODIFIER) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:246:5: MODIFIER
                    {
                    MODIFIER9=(Token)match(input,MODIFIER,FOLLOW_MODIFIER_in_single_geometric_charge291); 

                          text += "_" + (MODIFIER9!=null?MODIFIER9.getText():null);
                        

                    }
                    break;

            }

            pushFollow(FOLLOW_tincture_in_single_geometric_charge304);
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
    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:255:1: multiple_geometric_charges[Tinctures tinctures, TinctureType underLayerTinctureType, int number] returns [List <Charge> charges] : ords= ( SUBORDINARY_MULTIPLE | MOBILE_CHARGE ) ( MODIFIER )? t= tincture[tinctures] ;
    public final List <Charge> multiple_geometric_charges(Tinctures tinctures, TinctureType underLayerTinctureType, int number) throws RecognitionException {
        List <Charge> charges = null;

        Token ords=null;
        Token MODIFIER10=null;
        Tincture t = null;


        try {
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:256:3: (ords= ( SUBORDINARY_MULTIPLE | MOBILE_CHARGE ) ( MODIFIER )? t= tincture[tinctures] )
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:257:3: ords= ( SUBORDINARY_MULTIPLE | MOBILE_CHARGE ) ( MODIFIER )? t= tincture[tinctures]
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


                String text = checkForPlurals((ords!=null?ords.getText():null), number);
              
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:264:3: ( MODIFIER )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==MODIFIER) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:265:5: MODIFIER
                    {
                    MODIFIER10=(Token)match(input,MODIFIER,FOLLOW_MODIFIER_in_multiple_geometric_charges360); 

                          text += "_" + (MODIFIER10!=null?MODIFIER10.getText():null);
                        

                    }
                    break;

            }

            pushFollow(FOLLOW_tincture_in_multiple_geometric_charges373);
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
    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:278:1: advanced_charge[Tinctures tinctures, TinctureType underLayerTinctureType, int number] returns [List <Charge> charges] : (beast= ( BEAST | WINGED_BEAST ) attitude= ATTITUDE | beast= ( WINGED_BEAST | BIRD_FLYING_INSECT ) attitude= FLYING_ATTITUDE | beast= SWIMMING_BEAST attitude= SWIMMING_ATTITUDE ) ( ATTITUDE_MODIFIER )? tincture[tinctures] ( body_parts[tinctures] )? ;
    public final List <Charge> advanced_charge(Tinctures tinctures, TinctureType underLayerTinctureType, int number) throws RecognitionException {
        List <Charge> charges = null;

        Token beast=null;
        Token attitude=null;
        Token ATTITUDE_MODIFIER12=null;
        Tincture tincture11 = null;

        Map<String, Tincture> body_parts13 = null;


        try {
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:279:3: ( (beast= ( BEAST | WINGED_BEAST ) attitude= ATTITUDE | beast= ( WINGED_BEAST | BIRD_FLYING_INSECT ) attitude= FLYING_ATTITUDE | beast= SWIMMING_BEAST attitude= SWIMMING_ATTITUDE ) ( ATTITUDE_MODIFIER )? tincture[tinctures] ( body_parts[tinctures] )? )
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:280:3: (beast= ( BEAST | WINGED_BEAST ) attitude= ATTITUDE | beast= ( WINGED_BEAST | BIRD_FLYING_INSECT ) attitude= FLYING_ATTITUDE | beast= SWIMMING_BEAST attitude= SWIMMING_ATTITUDE ) ( ATTITUDE_MODIFIER )? tincture[tinctures] ( body_parts[tinctures] )?
            {
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:280:3: (beast= ( BEAST | WINGED_BEAST ) attitude= ATTITUDE | beast= ( WINGED_BEAST | BIRD_FLYING_INSECT ) attitude= FLYING_ATTITUDE | beast= SWIMMING_BEAST attitude= SWIMMING_ATTITUDE )
            int alt7=3;
            switch ( input.LA(1) ) {
            case WINGED_BEAST:
                {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==ATTITUDE) ) {
                    alt7=1;
                }
                else if ( (LA7_1==FLYING_ATTITUDE) ) {
                    alt7=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    throw nvae;
                }
                }
                break;
            case BEAST:
                {
                alt7=1;
                }
                break;
            case BIRD_FLYING_INSECT:
                {
                alt7=2;
                }
                break;
            case SWIMMING_BEAST:
                {
                alt7=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:281:5: beast= ( BEAST | WINGED_BEAST ) attitude= ATTITUDE
                    {
                    beast=(Token)input.LT(1);
                    if ( (input.LA(1)>=BEAST && input.LA(1)<=WINGED_BEAST) ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                    attitude=(Token)match(input,ATTITUDE,FOLLOW_ATTITUDE_in_advanced_charge416); 

                    }
                    break;
                case 2 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:282:5: beast= ( WINGED_BEAST | BIRD_FLYING_INSECT ) attitude= FLYING_ATTITUDE
                    {
                    beast=(Token)input.LT(1);
                    if ( input.LA(1)==WINGED_BEAST||input.LA(1)==BIRD_FLYING_INSECT ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                    attitude=(Token)match(input,FLYING_ATTITUDE,FOLLOW_FLYING_ATTITUDE_in_advanced_charge438); 

                    }
                    break;
                case 3 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:283:5: beast= SWIMMING_BEAST attitude= SWIMMING_ATTITUDE
                    {
                    beast=(Token)match(input,SWIMMING_BEAST,FOLLOW_SWIMMING_BEAST_in_advanced_charge448); 
                    attitude=(Token)match(input,SWIMMING_ATTITUDE,FOLLOW_SWIMMING_ATTITUDE_in_advanced_charge454); 

                    }
                    break;

            }

            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:285:3: ( ATTITUDE_MODIFIER )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==ATTITUDE_MODIFIER) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:285:3: ATTITUDE_MODIFIER
                    {
                    ATTITUDE_MODIFIER12=(Token)match(input,ATTITUDE_MODIFIER,FOLLOW_ATTITUDE_MODIFIER_in_advanced_charge462); 

                    }
                    break;

            }

            pushFollow(FOLLOW_tincture_in_advanced_charge467);
            tincture11=tincture(tinctures);

            state._fsp--;

            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:287:3: ( body_parts[tinctures] )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( ((LA9_0>=BODY_PART && LA9_0<=AND)) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:287:3: body_parts[tinctures]
                    {
                    pushFollow(FOLLOW_body_parts_in_advanced_charge472);
                    body_parts13=body_parts(tinctures);

                    state._fsp--;


                    }
                    break;

            }


              diagnoseRuleOfTincture(tincture11, underLayerTinctureType);
              String beastName = checkForPlurals((beast!=null?beast.getText():null), number);
              AdvancedCharge charge = AdvancedCharge.build(beastName, (attitude!=null?attitude.getText():null), (ATTITUDE_MODIFIER12!=null?ATTITUDE_MODIFIER12.getText():null), tincture11, body_parts13);
              charges = new ArrayList<Charge>();
              for (int i = 0; i < number; i++) {
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
    // $ANTLR end "advanced_charge"


    // $ANTLR start "body_parts"
    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:297:1: body_parts[Tinctures tinctures] returns [Map<String, Tincture> bodyParts] : (bp1= BODY_PART t1= tincture[tinctures] | (bp2= BODY_PART t2= tincture[tinctures] )* AND bp3= BODY_PART t3= tincture[tinctures] ) ;
    public final Map<String, Tincture> body_parts(Tinctures tinctures) throws RecognitionException {
        Map<String, Tincture> bodyParts = null;

        Token bp1=null;
        Token bp2=null;
        Token bp3=null;
        Tincture t1 = null;

        Tincture t2 = null;

        Tincture t3 = null;


        try {
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:298:3: ( (bp1= BODY_PART t1= tincture[tinctures] | (bp2= BODY_PART t2= tincture[tinctures] )* AND bp3= BODY_PART t3= tincture[tinctures] ) )
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:299:3: (bp1= BODY_PART t1= tincture[tinctures] | (bp2= BODY_PART t2= tincture[tinctures] )* AND bp3= BODY_PART t3= tincture[tinctures] )
            {

                bodyParts = new HashMap<String, Tincture>();
              
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:302:3: (bp1= BODY_PART t1= tincture[tinctures] | (bp2= BODY_PART t2= tincture[tinctures] )* AND bp3= BODY_PART t3= tincture[tinctures] )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==BODY_PART) ) {
                switch ( input.LA(2) ) {
                case COLOUR:
                    {
                    int LA11_3 = input.LA(3);

                    if ( (LA11_3==EOF||LA11_3==DETERMINER||(LA11_3>=DIGITS && LA11_3<=NUMWORDS)) ) {
                        alt11=1;
                    }
                    else if ( ((LA11_3>=BODY_PART && LA11_3<=AND)) ) {
                        alt11=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 11, 3, input);

                        throw nvae;
                    }
                    }
                    break;
                case METAL:
                    {
                    int LA11_4 = input.LA(3);

                    if ( (LA11_4==EOF||LA11_4==DETERMINER||(LA11_4>=DIGITS && LA11_4<=NUMWORDS)) ) {
                        alt11=1;
                    }
                    else if ( ((LA11_4>=BODY_PART && LA11_4<=AND)) ) {
                        alt11=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 11, 4, input);

                        throw nvae;
                    }
                    }
                    break;
                case FUR:
                    {
                    int LA11_5 = input.LA(3);

                    if ( (LA11_5==EOF||LA11_5==DETERMINER||(LA11_5>=DIGITS && LA11_5<=NUMWORDS)) ) {
                        alt11=1;
                    }
                    else if ( ((LA11_5>=BODY_PART && LA11_5<=AND)) ) {
                        alt11=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 11, 5, input);

                        throw nvae;
                    }
                    }
                    break;
                case PROPER:
                    {
                    int LA11_6 = input.LA(3);

                    if ( (LA11_6==EOF||LA11_6==DETERMINER||(LA11_6>=DIGITS && LA11_6<=NUMWORDS)) ) {
                        alt11=1;
                    }
                    else if ( ((LA11_6>=BODY_PART && LA11_6<=AND)) ) {
                        alt11=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 11, 6, input);

                        throw nvae;
                    }
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 1, input);

                    throw nvae;
                }

            }
            else if ( (LA11_0==AND) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:303:5: bp1= BODY_PART t1= tincture[tinctures]
                    {
                    bp1=(Token)match(input,BODY_PART,FOLLOW_BODY_PART_in_body_parts507); 
                    pushFollow(FOLLOW_tincture_in_body_parts511);
                    t1=tincture(tinctures);

                    state._fsp--;


                          bodyParts.put((bp1!=null?bp1.getText():null), t1);
                        

                    }
                    break;
                case 2 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:307:5: (bp2= BODY_PART t2= tincture[tinctures] )* AND bp3= BODY_PART t3= tincture[tinctures]
                    {
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:307:5: (bp2= BODY_PART t2= tincture[tinctures] )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==BODY_PART) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:308:7: bp2= BODY_PART t2= tincture[tinctures]
                    	    {
                    	    bp2=(Token)match(input,BODY_PART,FOLLOW_BODY_PART_in_body_parts537); 
                    	    pushFollow(FOLLOW_tincture_in_body_parts541);
                    	    t2=tincture(tinctures);

                    	    state._fsp--;


                    	            bodyParts.put((bp2!=null?bp2.getText():null), t2);
                    	          

                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);

                    match(input,AND,FOLLOW_AND_in_body_parts557); 
                    bp3=(Token)match(input,BODY_PART,FOLLOW_BODY_PART_in_body_parts563); 
                    pushFollow(FOLLOW_tincture_in_body_parts567);
                    t3=tincture(tinctures);

                    state._fsp--;


                          bodyParts.put((bp3!=null?bp3.getText():null), t3);
                        

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
        return bodyParts;
    }
    // $ANTLR end "body_parts"


    // $ANTLR start "div"
    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:317:1: div returns [ShieldDivisionType division] : ( ( TIERCED )? PARTYPER divType= ( ORDINARY_DIV | SUBORDINARY_DIV ) (divModifier1= MODIFIER )? | VARIABLE_DIV (divModifier2= MODIFIER )? ( OF number_digits_or_words )? | CONTINUOUS_DIV | QUARTER ) ;
    public final ShieldDivisionType div() throws RecognitionException {
        ShieldDivisionType division = null;

        Token divType=null;
        Token divModifier1=null;
        Token divModifier2=null;
        Token TIERCED14=null;
        Token VARIABLE_DIV15=null;
        Token OF16=null;
        Token CONTINUOUS_DIV18=null;
        Token QUARTER19=null;
        BlazonParser.number_digits_or_words_return number_digits_or_words17 = null;


        try {
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:318:3: ( ( ( TIERCED )? PARTYPER divType= ( ORDINARY_DIV | SUBORDINARY_DIV ) (divModifier1= MODIFIER )? | VARIABLE_DIV (divModifier2= MODIFIER )? ( OF number_digits_or_words )? | CONTINUOUS_DIV | QUARTER ) )
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:319:3: ( ( TIERCED )? PARTYPER divType= ( ORDINARY_DIV | SUBORDINARY_DIV ) (divModifier1= MODIFIER )? | VARIABLE_DIV (divModifier2= MODIFIER )? ( OF number_digits_or_words )? | CONTINUOUS_DIV | QUARTER )
            {

                String text = "";
              
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:322:3: ( ( TIERCED )? PARTYPER divType= ( ORDINARY_DIV | SUBORDINARY_DIV ) (divModifier1= MODIFIER )? | VARIABLE_DIV (divModifier2= MODIFIER )? ( OF number_digits_or_words )? | CONTINUOUS_DIV | QUARTER )
            int alt16=4;
            switch ( input.LA(1) ) {
            case TIERCED:
            case PARTYPER:
                {
                alt16=1;
                }
                break;
            case VARIABLE_DIV:
                {
                alt16=2;
                }
                break;
            case CONTINUOUS_DIV:
                {
                alt16=3;
                }
                break;
            case QUARTER:
                {
                alt16=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:323:5: ( TIERCED )? PARTYPER divType= ( ORDINARY_DIV | SUBORDINARY_DIV ) (divModifier1= MODIFIER )?
                    {
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:323:5: ( TIERCED )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==TIERCED) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:324:7: TIERCED
                            {
                            TIERCED14=(Token)match(input,TIERCED,FOLLOW_TIERCED_in_div608); 

                                    text = (TIERCED14!=null?TIERCED14.getText():null) + " ";
                                  

                            }
                            break;

                    }

                    match(input,PARTYPER,FOLLOW_PARTYPER_in_div623); 
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
                        
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:336:5: (divModifier1= MODIFIER )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==MODIFIER) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:337:7: divModifier1= MODIFIER
                            {
                            divModifier1=(Token)match(input,MODIFIER,FOLLOW_MODIFIER_in_div681); 

                                    text += " " + (divModifier1!=null?divModifier1.getText():null);
                                  

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:342:5: VARIABLE_DIV (divModifier2= MODIFIER )? ( OF number_digits_or_words )?
                    {
                    VARIABLE_DIV15=(Token)match(input,VARIABLE_DIV,FOLLOW_VARIABLE_DIV_in_div701); 

                          text = (VARIABLE_DIV15!=null?VARIABLE_DIV15.getText():null);
                        
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:345:5: (divModifier2= MODIFIER )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==MODIFIER) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:346:7: divModifier2= MODIFIER
                            {
                            divModifier2=(Token)match(input,MODIFIER,FOLLOW_MODIFIER_in_div721); 

                                    text += " " + (divModifier2!=null?divModifier2.getText():null);
                                  

                            }
                            break;

                    }

                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:350:5: ( OF number_digits_or_words )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==OF) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:351:7: OF number_digits_or_words
                            {
                            OF16=(Token)match(input,OF,FOLLOW_OF_in_div744); 

                                    text += " " + (OF16!=null?OF16.getText():null);
                                  
                            pushFollow(FOLLOW_number_digits_or_words_in_div754);
                            number_digits_or_words17=number_digits_or_words();

                            state._fsp--;


                                    int gyronnyOf = convertNumber((number_digits_or_words17!=null?input.toString(number_digits_or_words17.start,number_digits_or_words17.stop):null));
                                    if (gyronnyOf % 2 != 0) {
                                        gyronnyOf++;
                                        diags.add(ShieldDiagnostic.build(LogLevel.WARNING, "Parsing rule 'div'.  '" + (VARIABLE_DIV15!=null?VARIABLE_DIV15.getText():null) 
                                                + "' can only be of an even number; incremented number of sections to " + gyronnyOf));
                                    }
                                    text += " " + gyronnyOf;
                                  

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:365:5: CONTINUOUS_DIV
                    {
                    CONTINUOUS_DIV18=(Token)match(input,CONTINUOUS_DIV,FOLLOW_CONTINUOUS_DIV_in_div773); 

                          text = (CONTINUOUS_DIV18!=null?CONTINUOUS_DIV18.getText():null);
                        

                    }
                    break;
                case 4 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:369:5: QUARTER
                    {
                    QUARTER19=(Token)match(input,QUARTER,FOLLOW_QUARTER_in_div786); 

                          text = (QUARTER19!=null?QUARTER19.getText():null);
                        

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
    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:382:1: some_tinctures[Tinctures tinctures, ShieldDivisionType division] returns [Field layer] : ( tincture[tinctures] )+ AND tincture[tinctures] ;
    public final Field some_tinctures(Tinctures tinctures, ShieldDivisionType division) throws RecognitionException {
        Field layer = null;

        try {
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:383:3: ( ( tincture[tinctures] )+ AND tincture[tinctures] )
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:384:3: ( tincture[tinctures] )+ AND tincture[tinctures]
            {

                int count = 0;
              
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:387:3: ( tincture[tinctures] )+
            int cnt17=0;
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>=COLOUR && LA17_0<=PROPER)) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:388:5: tincture[tinctures]
            	    {
            	    pushFollow(FOLLOW_tincture_in_some_tinctures826);
            	    tincture(tinctures);

            	    state._fsp--;


            	          count++;
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt17 >= 1 ) break loop17;
                        EarlyExitException eee =
                            new EarlyExitException(17, input);
                        throw eee;
                }
                cnt17++;
            } while (true);

            match(input,AND,FOLLOW_AND_in_some_tinctures838); 
            pushFollow(FOLLOW_tincture_in_some_tinctures840);
            tincture(tinctures);

            state._fsp--;


                count++;
                int numberOfTinctures = division.getNumberOfTinctures();
                if (numberOfTinctures != count) {
            	    diags.add(ShieldDiagnostic.build(LogLevel.ERROR,
            			  "Incorrect number of tinctures specified.  The '"
            				+ division + "' division type only allows the following number of tinctures: "
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
    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:405:1: tincture[Tinctures tinctures] returns [Tincture tincture] : ( COLOUR | METAL | FUR | PROPER ) ;
    public final Tincture tincture(Tinctures tinctures) throws RecognitionException {
        Tincture tincture = null;

        Token COLOUR20=null;
        Token METAL21=null;
        Token FUR22=null;
        Token PROPER23=null;

        try {
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:406:3: ( ( COLOUR | METAL | FUR | PROPER ) )
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:407:3: ( COLOUR | METAL | FUR | PROPER )
            {

                String tinctureName = "";
              
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:410:3: ( COLOUR | METAL | FUR | PROPER )
            int alt18=4;
            switch ( input.LA(1) ) {
            case COLOUR:
                {
                alt18=1;
                }
                break;
            case METAL:
                {
                alt18=2;
                }
                break;
            case FUR:
                {
                alt18=3;
                }
                break;
            case PROPER:
                {
                alt18=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:411:5: COLOUR
                    {
                    COLOUR20=(Token)match(input,COLOUR,FOLLOW_COLOUR_in_tincture870); 

                          tinctureName = (COLOUR20!=null?COLOUR20.getText():null);
                        

                    }
                    break;
                case 2 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:415:5: METAL
                    {
                    METAL21=(Token)match(input,METAL,FOLLOW_METAL_in_tincture882); 

                          tinctureName = (METAL21!=null?METAL21.getText():null);
                        

                    }
                    break;
                case 3 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:419:5: FUR
                    {
                    FUR22=(Token)match(input,FUR,FOLLOW_FUR_in_tincture894); 

                          tinctureName = (FUR22!=null?FUR22.getText():null);
                        

                    }
                    break;
                case 4 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:422:5: PROPER
                    {
                    PROPER23=(Token)match(input,PROPER,FOLLOW_PROPER_in_tincture902); 

                          tinctureName = (PROPER23!=null?PROPER23.getText():null);
                        

                    }
                    break;

            }


                try {
            	    tincture = tinctures.getTincture(tinctureName);
            	    tinctures.addTincture(tincture);
                } catch (UnknownTinctureException e) {
            	    diags.add(ShieldDiagnostic.build(LogLevel.ERROR,
            			  "Unknown tincture found. Caught: " + e));
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
    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:437:1: number_digits_or_words : ( DIGITS | NUMWORDS ( ( AND )? NUMWORDS )* | DETERMINER );
    public final BlazonParser.number_digits_or_words_return number_digits_or_words() throws RecognitionException {
        BlazonParser.number_digits_or_words_return retval = new BlazonParser.number_digits_or_words_return();
        retval.start = input.LT(1);

        try {
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:438:3: ( DIGITS | NUMWORDS ( ( AND )? NUMWORDS )* | DETERMINER )
            int alt21=3;
            switch ( input.LA(1) ) {
            case DIGITS:
                {
                alt21=1;
                }
                break;
            case NUMWORDS:
                {
                alt21=2;
                }
                break;
            case DETERMINER:
                {
                alt21=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:439:3: DIGITS
                    {
                    match(input,DIGITS,FOLLOW_DIGITS_in_number_digits_or_words924); 

                    }
                    break;
                case 2 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:440:5: NUMWORDS ( ( AND )? NUMWORDS )*
                    {
                    match(input,NUMWORDS,FOLLOW_NUMWORDS_in_number_digits_or_words930); 
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:441:5: ( ( AND )? NUMWORDS )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==AND||LA20_0==NUMWORDS) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:442:7: ( AND )? NUMWORDS
                    	    {
                    	    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:442:7: ( AND )?
                    	    int alt19=2;
                    	    int LA19_0 = input.LA(1);

                    	    if ( (LA19_0==AND) ) {
                    	        alt19=1;
                    	    }
                    	    switch (alt19) {
                    	        case 1 :
                    	            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:442:7: AND
                    	            {
                    	            match(input,AND,FOLLOW_AND_in_number_digits_or_words945); 

                    	            }
                    	            break;

                    	    }

                    	    match(input,NUMWORDS,FOLLOW_NUMWORDS_in_number_digits_or_words948); 

                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);


                    }
                    break;
                case 3 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:444:5: DETERMINER
                    {
                    match(input,DETERMINER,FOLLOW_DETERMINER_in_number_digits_or_words961); 

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


    protected DFA4 dfa4 = new DFA4(this);
    static final String DFA4_eotS =
        "\11\uffff";
    static final String DFA4_eofS =
        "\11\uffff";
    static final String DFA4_minS =
        "\1\4\1\5\2\12\3\uffff\1\41\1\12";
    static final String DFA4_maxS =
        "\1\41\2\21\1\41\3\uffff\2\41";
    static final String DFA4_acceptS =
        "\4\uffff\1\1\1\2\1\3\2\uffff";
    static final String DFA4_specialS =
        "\11\uffff}>";
    static final String[] DFA4_transitionS = {
            "\1\1\33\uffff\1\2\1\3",
            "\4\4\1\uffff\2\5\2\6\1\uffff\1\6\1\uffff\1\6",
            "\2\5\2\6\1\uffff\1\6\1\uffff\1\6",
            "\2\5\2\6\1\uffff\1\6\1\uffff\1\6\3\uffff\1\7\13\uffff\1\10",
            "",
            "",
            "",
            "\1\10",
            "\2\5\2\6\1\uffff\1\6\1\uffff\1\6\3\uffff\1\7\13\uffff\1\10"
    };

    static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);
    static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);
    static final char[] DFA4_min = DFA.unpackEncodedStringToUnsignedChars(DFA4_minS);
    static final char[] DFA4_max = DFA.unpackEncodedStringToUnsignedChars(DFA4_maxS);
    static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);
    static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);
    static final short[][] DFA4_transition;

    static {
        int numStates = DFA4_transitionS.length;
        DFA4_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
        }
    }

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = DFA4_eot;
            this.eof = DFA4_eof;
            this.min = DFA4_min;
            this.max = DFA4_max;
            this.accept = DFA4_accept;
            this.special = DFA4_special;
            this.transition = DFA4_transition;
        }
        public String getDescription() {
            return "199:3: ( DETERMINER single_geometric_charge[tinctures, underLayerTinctureType] | geometricCount= number_digits_or_words multiple_geometric_charges[tinctures, underLayerTinctureType, convertNumber($geometricCount.text)] | advancedCount= number_digits_or_words advanced_charge[tinctures, underLayerTinctureType, convertNumber($advancedCount.text)] )";
        }
    }
 

    public static final BitSet FOLLOW_field_in_shield73 = new BitSet(new long[]{0x0000000300000012L});
    public static final BitSet FOLLOW_charges_in_shield85 = new BitSet(new long[]{0x0000000300000012L});
    public static final BitSet FOLLOW_div_in_field130 = new BitSet(new long[]{0x00000000F0000000L});
    public static final BitSet FOLLOW_some_tinctures_in_field138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tincture_in_field151 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_35_in_field154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DETERMINER_in_charges188 = new BitSet(new long[]{0x00000000000001E0L});
    public static final BitSet FOLLOW_single_geometric_charge_in_charges190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_number_digits_or_words_in_charges200 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_multiple_geometric_charges_in_charges202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_number_digits_or_words_in_charges212 = new BitSet(new long[]{0x000000000002B000L});
    public static final BitSet FOLLOW_advanced_charge_in_charges214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_single_geometric_charge243 = new BitSet(new long[]{0x00000000F0000200L});
    public static final BitSet FOLLOW_MODIFIER_in_single_geometric_charge291 = new BitSet(new long[]{0x00000000F0000000L});
    public static final BitSet FOLLOW_tincture_in_single_geometric_charge304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_multiple_geometric_charges328 = new BitSet(new long[]{0x00000000F0000200L});
    public static final BitSet FOLLOW_MODIFIER_in_multiple_geometric_charges360 = new BitSet(new long[]{0x00000000F0000000L});
    public static final BitSet FOLLOW_tincture_in_multiple_geometric_charges373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_advanced_charge404 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_ATTITUDE_in_advanced_charge416 = new BitSet(new long[]{0x00000000F0080000L});
    public static final BitSet FOLLOW_set_in_advanced_charge426 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_FLYING_ATTITUDE_in_advanced_charge438 = new BitSet(new long[]{0x00000000F0080000L});
    public static final BitSet FOLLOW_SWIMMING_BEAST_in_advanced_charge448 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_SWIMMING_ATTITUDE_in_advanced_charge454 = new BitSet(new long[]{0x00000000F0080000L});
    public static final BitSet FOLLOW_ATTITUDE_MODIFIER_in_advanced_charge462 = new BitSet(new long[]{0x00000000F0000000L});
    public static final BitSet FOLLOW_tincture_in_advanced_charge467 = new BitSet(new long[]{0x0000000000300002L});
    public static final BitSet FOLLOW_body_parts_in_advanced_charge472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BODY_PART_in_body_parts507 = new BitSet(new long[]{0x00000000F0000000L});
    public static final BitSet FOLLOW_tincture_in_body_parts511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BODY_PART_in_body_parts537 = new BitSet(new long[]{0x00000000F0000000L});
    public static final BitSet FOLLOW_tincture_in_body_parts541 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_AND_in_body_parts557 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_BODY_PART_in_body_parts563 = new BitSet(new long[]{0x00000000F0000000L});
    public static final BitSet FOLLOW_tincture_in_body_parts567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TIERCED_in_div608 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_PARTYPER_in_div623 = new BitSet(new long[]{0x00000000000000A0L});
    public static final BitSet FOLLOW_set_in_div633 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_MODIFIER_in_div681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_DIV_in_div701 = new BitSet(new long[]{0x0000000002000202L});
    public static final BitSet FOLLOW_MODIFIER_in_div721 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_OF_in_div744 = new BitSet(new long[]{0x0000000300000010L});
    public static final BitSet FOLLOW_number_digits_or_words_in_div754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONTINUOUS_DIV_in_div773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUARTER_in_div786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tincture_in_some_tinctures826 = new BitSet(new long[]{0x00000000F0200000L});
    public static final BitSet FOLLOW_AND_in_some_tinctures838 = new BitSet(new long[]{0x00000000F0000000L});
    public static final BitSet FOLLOW_tincture_in_some_tinctures840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COLOUR_in_tincture870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_METAL_in_tincture882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUR_in_tincture894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PROPER_in_tincture902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DIGITS_in_number_digits_or_words924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMWORDS_in_number_digits_or_words930 = new BitSet(new long[]{0x0000000200200002L});
    public static final BitSet FOLLOW_AND_in_number_digits_or_words945 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_NUMWORDS_in_number_digits_or_words948 = new BitSet(new long[]{0x0000000200200002L});
    public static final BitSet FOLLOW_DETERMINER_in_number_digits_or_words961 = new BitSet(new long[]{0x0000000000000002L});

}