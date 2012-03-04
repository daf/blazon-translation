// $ANTLR 3.3 Nov 30, 2010 12:50:56 /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g 2012-03-03 13:47:54

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "DETERMINER", "ORDINARY_DIV", "OTHER_ORDINARY", "SUBORDINARY_DIV", "SUBORDINARY", "MODIFIER", "SUBORDINARY_MULTIPLE", "MOBILE_CHARGE", "BEAST", "ATTITUDE", "FLYING_BEAST", "FLYING_ATTITUDE", "ATTITUDE_MODIFIER", "BODY_PART", "AND", "TIERCED", "PARTYPER", "VARIABLE_DIV", "OF", "CONTINUOUS_DIV", "QUARTER", "COLOUR", "METAL", "FUR", "DIGITS", "NUMWORDS", "WS", "'plain'"
    };
    public static final int EOF=-1;
    public static final int T__31=31;
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
    public static final int FLYING_BEAST=14;
    public static final int FLYING_ATTITUDE=15;
    public static final int ATTITUDE_MODIFIER=16;
    public static final int BODY_PART=17;
    public static final int AND=18;
    public static final int TIERCED=19;
    public static final int PARTYPER=20;
    public static final int VARIABLE_DIV=21;
    public static final int OF=22;
    public static final int CONTINUOUS_DIV=23;
    public static final int QUARTER=24;
    public static final int COLOUR=25;
    public static final int METAL=26;
    public static final int FUR=27;
    public static final int DIGITS=28;
    public static final int NUMWORDS=29;
    public static final int WS=30;

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
    					.build(LogLevel.WARN,
    							"You are not obeying the rule of tincture. You can not put a colour on a colour, or a metal on a metal"));
    		}
    	}
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

    public Object recoverFromMismatchedSet(IntStream input, RecognitionException e,
    		BitSet follow) throws RecognitionException {
    	throw e;
    }



    // $ANTLR start "shield"
    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:115:1: shield returns [Shield s] : field ( charges[$field.field.getTinctureTypeOfLayer()] )* ;
    public final Shield shield() throws RecognitionException {
        Shield s = null;

        Field field1 = null;

        List<Charge> charges2 = null;


        try {
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:116:3: ( field ( charges[$field.field.getTinctureTypeOfLayer()] )* )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:117:3: field ( charges[$field.field.getTinctureTypeOfLayer()] )*
            {

                String blazon = input.toString();
              
            pushFollow(FOLLOW_field_in_shield73);
            field1=field();

            state._fsp--;


                s = ShieldImpl.build(field1, blazon);
              
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:123:3: ( charges[$field.field.getTinctureTypeOfLayer()] )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==DETERMINER||(LA1_0>=DIGITS && LA1_0<=NUMWORDS)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:124:5: charges[$field.field.getTinctureTypeOfLayer()]
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
        catch (MismatchedSetException me) {

              displayRecognitionError(this.getTokenNames(), me);
              return InvalidShield.build(diags);

        }
        catch (RecognitionException re) {

              return InvalidShield.build(diags);

        }
        finally {
        }
        return s;
    }
    // $ANTLR end "shield"


    // $ANTLR start "field"
    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:139:1: field returns [Field field] : ( div some_tinctures[tinctures, division] | tincture[tinctures] ( 'plain' )? ) ;
    public final Field field() throws RecognitionException {
        Field field = null;

        ShieldDivisionType div3 = null;

        Field some_tinctures4 = null;


        try {
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:140:3: ( ( div some_tinctures[tinctures, division] | tincture[tinctures] ( 'plain' )? ) )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:141:3: ( div some_tinctures[tinctures, division] | tincture[tinctures] ( 'plain' )? )
            {

                Tinctures tinctures = new Tinctures();
              
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:144:3: ( div some_tinctures[tinctures, division] | tincture[tinctures] ( 'plain' )? )
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
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:145:5: div some_tinctures[tinctures, division]
                    {
                    pushFollow(FOLLOW_div_in_field136);
                    div3=div();

                    state._fsp--;


                          ShieldDivisionType division = div3;
                        
                    pushFollow(FOLLOW_some_tinctures_in_field144);
                    some_tinctures4=some_tinctures(tinctures, division);

                    state._fsp--;


                          field = some_tinctures4;
                        

                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:152:5: tincture[tinctures] ( 'plain' )?
                    {
                    pushFollow(FOLLOW_tincture_in_field157);
                    tincture(tinctures);

                    state._fsp--;

                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:152:25: ( 'plain' )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==31) ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:152:25: 'plain'
                            {
                            match(input,31,FOLLOW_31_in_field160); 

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
    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:157:1: charges[TinctureType underLayerTinctureType] returns [List<Charge> charges] : ( DETERMINER single_geometric_charge[tinctures, underLayerTinctureType] | number_digits_or_words multiple_geometric_charges[tinctures, underLayerTinctureType, convertNumber($number_digits_or_words.text)] | advanced_charge[tinctures, underLayerTinctureType] ) ;
    public final List<Charge> charges(TinctureType underLayerTinctureType) throws RecognitionException {
        List<Charge> charges = null;

        Token DETERMINER6=null;
        GeometricCharge single_geometric_charge5 = null;

        BlazonParser.number_digits_or_words_return number_digits_or_words7 = null;

        List <Charge> multiple_geometric_charges8 = null;

        List <Charge> advanced_charge9 = null;


        try {
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:158:3: ( ( DETERMINER single_geometric_charge[tinctures, underLayerTinctureType] | number_digits_or_words multiple_geometric_charges[tinctures, underLayerTinctureType, convertNumber($number_digits_or_words.text)] | advanced_charge[tinctures, underLayerTinctureType] ) )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:159:3: ( DETERMINER single_geometric_charge[tinctures, underLayerTinctureType] | number_digits_or_words multiple_geometric_charges[tinctures, underLayerTinctureType, convertNumber($number_digits_or_words.text)] | advanced_charge[tinctures, underLayerTinctureType] )
            {

                Tinctures tinctures = new Tinctures();
                charges = new ArrayList<Charge>();
              
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:163:3: ( DETERMINER single_geometric_charge[tinctures, underLayerTinctureType] | number_digits_or_words multiple_geometric_charges[tinctures, underLayerTinctureType, convertNumber($number_digits_or_words.text)] | advanced_charge[tinctures, underLayerTinctureType] )
            int alt4=3;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==DETERMINER) ) {
                switch ( input.LA(2) ) {
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
                case BEAST:
                case FLYING_BEAST:
                    {
                    alt4=3;
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
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:164:5: DETERMINER single_geometric_charge[tinctures, underLayerTinctureType]
                    {
                    DETERMINER6=(Token)match(input,DETERMINER,FOLLOW_DETERMINER_in_charges194); 
                    pushFollow(FOLLOW_single_geometric_charge_in_charges196);
                    single_geometric_charge5=single_geometric_charge(tinctures, underLayerTinctureType);

                    state._fsp--;


                          if (single_geometric_charge5 != null) {
                    			  charges.add(single_geometric_charge5);
                    				if ("a".equals((DETERMINER6!=null?DETERMINER6.getText():null))) {
                    					String chargeName = single_geometric_charge5.getName().toString().toLowerCase();
                    					if (startsWithAVowel(chargeName)) {
                    						diags.add(ShieldDiagnostic.build(LogLevel.WARN,
                    										"You have asked for the charge '" + (DETERMINER6!=null?DETERMINER6.getText():null) + " " + chargeName
                    												+ "'. A charge starting with a vowel should be preceded by 'an' i.e. 'an "
                    												+ chargeName + "'."));
                    					}
                    				} else if ("an".equals((DETERMINER6!=null?DETERMINER6.getText():null))) {
                    					String chargeName = single_geometric_charge5.getName().toString().toLowerCase();
                    					if (!startsWithAVowel(chargeName)) {
                    						diags.add(ShieldDiagnostic.build(LogLevel.WARN,
                    										"You have asked for the charge '" + (DETERMINER6!=null?DETERMINER6.getText():null) + " " + chargeName
                    											  + "'. A charge starting with a consonants should be preceded by 'a' i.e. 'a "
                    												+ chargeName + "'."));
                    					}
                    	     }
                         }
                       

                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:186:4: number_digits_or_words multiple_geometric_charges[tinctures, underLayerTinctureType, convertNumber($number_digits_or_words.text)]
                    {
                    pushFollow(FOLLOW_number_digits_or_words_in_charges204);
                    number_digits_or_words7=number_digits_or_words();

                    state._fsp--;

                    pushFollow(FOLLOW_multiple_geometric_charges_in_charges206);
                    multiple_geometric_charges8=multiple_geometric_charges(tinctures, underLayerTinctureType, convertNumber((number_digits_or_words7!=null?input.toString(number_digits_or_words7.start,number_digits_or_words7.stop):null)));

                    state._fsp--;


                         if (multiple_geometric_charges8 != null) {
                    	     charges.addAll(multiple_geometric_charges8);
                         }
                       

                    }
                    break;
                case 3 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:191:4: advanced_charge[tinctures, underLayerTinctureType]
                    {
                    pushFollow(FOLLOW_advanced_charge_in_charges214);
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
    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:198:1: single_geometric_charge[Tinctures tinctures, TinctureType underLayerTinctureType] returns [GeometricCharge charge] : ord= ( ORDINARY_DIV | OTHER_ORDINARY | SUBORDINARY_DIV | SUBORDINARY ) ( MODIFIER )? t= tincture[tinctures] ;
    public final GeometricCharge single_geometric_charge(Tinctures tinctures, TinctureType underLayerTinctureType) throws RecognitionException {
        GeometricCharge charge = null;

        Token ord=null;
        Token MODIFIER10=null;
        Tincture t = null;


        try {
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:199:3: (ord= ( ORDINARY_DIV | OTHER_ORDINARY | SUBORDINARY_DIV | SUBORDINARY ) ( MODIFIER )? t= tincture[tinctures] )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:200:3: ord= ( ORDINARY_DIV | OTHER_ORDINARY | SUBORDINARY_DIV | SUBORDINARY ) ( MODIFIER )? t= tincture[tinctures]
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
              
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:209:3: ( MODIFIER )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==MODIFIER) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:210:5: MODIFIER
                    {
                    MODIFIER10=(Token)match(input,MODIFIER,FOLLOW_MODIFIER_in_single_geometric_charge291); 

                          text += "_" + (MODIFIER10!=null?MODIFIER10.getText():null);
                        

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
    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:219:1: multiple_geometric_charges[Tinctures tinctures, TinctureType underLayerTinctureType, int number] returns [List <Charge> charges] : ords= ( SUBORDINARY_MULTIPLE | MOBILE_CHARGE ) ( MODIFIER )? t= tincture[tinctures] ;
    public final List <Charge> multiple_geometric_charges(Tinctures tinctures, TinctureType underLayerTinctureType, int number) throws RecognitionException {
        List <Charge> charges = null;

        Token ords=null;
        Token MODIFIER11=null;
        Tincture t = null;


        try {
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:220:3: (ords= ( SUBORDINARY_MULTIPLE | MOBILE_CHARGE ) ( MODIFIER )? t= tincture[tinctures] )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:221:3: ords= ( SUBORDINARY_MULTIPLE | MOBILE_CHARGE ) ( MODIFIER )? t= tincture[tinctures]
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
            		    diags.add(ShieldDiagnostic.build(LogLevel.WARN,
            						"You have specified that there is more than one of a charge, but not used the plural. Changing '"
            								+ text + "' to '" + text + "s'."));
            			} else {
            				text = text.substring(0, text.length() - 1);
            			}
                } else if (number == 1) {
            	    if (text.endsWith("s")) {
            		    text = text.substring(0, text.length() - 1);
            		    diags.add(ShieldDiagnostic.build(LogLevel.WARN,
            						"You have specified that there is only one of a charge, but used the plural. Changing '"
            								+ text + "s' to '" + text + "'."));
            	    }
            	  }
              
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:245:3: ( MODIFIER )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==MODIFIER) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:246:5: MODIFIER
                    {
                    MODIFIER11=(Token)match(input,MODIFIER,FOLLOW_MODIFIER_in_multiple_geometric_charges360); 

                          text += "_" + (MODIFIER11!=null?MODIFIER11.getText():null);
                        

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
    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:259:1: advanced_charge[Tinctures tinctures, TinctureType underLayerTinctureType] returns [List <Charge> charges] : DETERMINER (beast= BEAST attitude= ATTITUDE | beast= FLYING_BEAST attitude= FLYING_ATTITUDE ) ( ATTITUDE_MODIFIER )? tincture[tinctures] ( body_parts[tinctures] )? ;
    public final List <Charge> advanced_charge(Tinctures tinctures, TinctureType underLayerTinctureType) throws RecognitionException {
        List <Charge> charges = null;

        Token beast=null;
        Token attitude=null;
        Token ATTITUDE_MODIFIER13=null;
        Tincture tincture12 = null;

        Map<String, Tincture> body_parts14 = null;


        try {
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:260:3: ( DETERMINER (beast= BEAST attitude= ATTITUDE | beast= FLYING_BEAST attitude= FLYING_ATTITUDE ) ( ATTITUDE_MODIFIER )? tincture[tinctures] ( body_parts[tinctures] )? )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:261:3: DETERMINER (beast= BEAST attitude= ATTITUDE | beast= FLYING_BEAST attitude= FLYING_ATTITUDE ) ( ATTITUDE_MODIFIER )? tincture[tinctures] ( body_parts[tinctures] )?
            {
            match(input,DETERMINER,FOLLOW_DETERMINER_in_advanced_charge393); 
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:262:3: (beast= BEAST attitude= ATTITUDE | beast= FLYING_BEAST attitude= FLYING_ATTITUDE )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==BEAST) ) {
                alt7=1;
            }
            else if ( (LA7_0==FLYING_BEAST) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:263:5: beast= BEAST attitude= ATTITUDE
                    {
                    beast=(Token)match(input,BEAST,FOLLOW_BEAST_in_advanced_charge408); 
                    attitude=(Token)match(input,ATTITUDE,FOLLOW_ATTITUDE_in_advanced_charge414); 

                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:264:5: beast= FLYING_BEAST attitude= FLYING_ATTITUDE
                    {
                    beast=(Token)match(input,FLYING_BEAST,FOLLOW_FLYING_BEAST_in_advanced_charge424); 
                    attitude=(Token)match(input,FLYING_ATTITUDE,FOLLOW_FLYING_ATTITUDE_in_advanced_charge430); 

                    }
                    break;

            }

            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:266:3: ( ATTITUDE_MODIFIER )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==ATTITUDE_MODIFIER) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:266:3: ATTITUDE_MODIFIER
                    {
                    ATTITUDE_MODIFIER13=(Token)match(input,ATTITUDE_MODIFIER,FOLLOW_ATTITUDE_MODIFIER_in_advanced_charge438); 

                    }
                    break;

            }

            pushFollow(FOLLOW_tincture_in_advanced_charge441);
            tincture12=tincture(tinctures);

            state._fsp--;

            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:266:42: ( body_parts[tinctures] )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( ((LA9_0>=BODY_PART && LA9_0<=AND)) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:266:42: body_parts[tinctures]
                    {
                    pushFollow(FOLLOW_body_parts_in_advanced_charge444);
                    body_parts14=body_parts(tinctures);

                    state._fsp--;


                    }
                    break;

            }


                diagnoseRuleOfTincture(tincture12, underLayerTinctureType);
                AdvancedCharge charge = AdvancedCharge.build((beast!=null?beast.getText():null), (attitude!=null?attitude.getText():null), (ATTITUDE_MODIFIER13!=null?ATTITUDE_MODIFIER13.getText():null), tincture12, body_parts14);
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
    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:273:1: body_parts[Tinctures tinctures] returns [Map<String, Tincture> bodyParts] : (bp1= BODY_PART t1= tincture[tinctures] | (bp2= BODY_PART t2= tincture[tinctures] )* AND bp3= BODY_PART t3= tincture[tinctures] ) ;
    public final Map<String, Tincture> body_parts(Tinctures tinctures) throws RecognitionException {
        Map<String, Tincture> bodyParts = null;

        Token bp1=null;
        Token bp2=null;
        Token bp3=null;
        Tincture t1 = null;

        Tincture t2 = null;

        Tincture t3 = null;


        try {
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:274:3: ( (bp1= BODY_PART t1= tincture[tinctures] | (bp2= BODY_PART t2= tincture[tinctures] )* AND bp3= BODY_PART t3= tincture[tinctures] ) )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:275:3: (bp1= BODY_PART t1= tincture[tinctures] | (bp2= BODY_PART t2= tincture[tinctures] )* AND bp3= BODY_PART t3= tincture[tinctures] )
            {

                bodyParts = new HashMap<String, Tincture>();
              
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:278:3: (bp1= BODY_PART t1= tincture[tinctures] | (bp2= BODY_PART t2= tincture[tinctures] )* AND bp3= BODY_PART t3= tincture[tinctures] )
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
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:279:5: bp1= BODY_PART t1= tincture[tinctures]
                    {
                    bp1=(Token)match(input,BODY_PART,FOLLOW_BODY_PART_in_body_parts479); 
                    pushFollow(FOLLOW_tincture_in_body_parts483);
                    t1=tincture(tinctures);

                    state._fsp--;


                          bodyParts.put((bp1!=null?bp1.getText():null), t1);
                        

                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:283:5: (bp2= BODY_PART t2= tincture[tinctures] )* AND bp3= BODY_PART t3= tincture[tinctures]
                    {
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:283:5: (bp2= BODY_PART t2= tincture[tinctures] )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==BODY_PART) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:284:7: bp2= BODY_PART t2= tincture[tinctures]
                    	    {
                    	    bp2=(Token)match(input,BODY_PART,FOLLOW_BODY_PART_in_body_parts509); 
                    	    pushFollow(FOLLOW_tincture_in_body_parts513);
                    	    t2=tincture(tinctures);

                    	    state._fsp--;


                    	            bodyParts.put((bp2!=null?bp2.getText():null), t2);
                    	          

                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);

                    match(input,AND,FOLLOW_AND_in_body_parts529); 
                    bp3=(Token)match(input,BODY_PART,FOLLOW_BODY_PART_in_body_parts535); 
                    pushFollow(FOLLOW_tincture_in_body_parts539);
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
    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:293:1: div returns [ShieldDivisionType division] : ( ( TIERCED )? PARTYPER divType= ( ORDINARY_DIV | SUBORDINARY_DIV ) (divModifier1= MODIFIER )? | VARIABLE_DIV (divModifier2= MODIFIER )? ( OF number_digits_or_words )? | CONTINUOUS_DIV | QUARTER ) ;
    public final ShieldDivisionType div() throws RecognitionException {
        ShieldDivisionType division = null;

        Token divType=null;
        Token divModifier1=null;
        Token divModifier2=null;
        Token TIERCED15=null;
        Token VARIABLE_DIV16=null;
        Token OF17=null;
        Token CONTINUOUS_DIV19=null;
        Token QUARTER20=null;
        BlazonParser.number_digits_or_words_return number_digits_or_words18 = null;


        try {
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:294:3: ( ( ( TIERCED )? PARTYPER divType= ( ORDINARY_DIV | SUBORDINARY_DIV ) (divModifier1= MODIFIER )? | VARIABLE_DIV (divModifier2= MODIFIER )? ( OF number_digits_or_words )? | CONTINUOUS_DIV | QUARTER ) )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:295:3: ( ( TIERCED )? PARTYPER divType= ( ORDINARY_DIV | SUBORDINARY_DIV ) (divModifier1= MODIFIER )? | VARIABLE_DIV (divModifier2= MODIFIER )? ( OF number_digits_or_words )? | CONTINUOUS_DIV | QUARTER )
            {

                String text = "";
              
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:298:3: ( ( TIERCED )? PARTYPER divType= ( ORDINARY_DIV | SUBORDINARY_DIV ) (divModifier1= MODIFIER )? | VARIABLE_DIV (divModifier2= MODIFIER )? ( OF number_digits_or_words )? | CONTINUOUS_DIV | QUARTER )
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
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:299:5: ( TIERCED )? PARTYPER divType= ( ORDINARY_DIV | SUBORDINARY_DIV ) (divModifier1= MODIFIER )?
                    {
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:299:5: ( TIERCED )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==TIERCED) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:300:7: TIERCED
                            {
                            TIERCED15=(Token)match(input,TIERCED,FOLLOW_TIERCED_in_div580); 

                                    text = (TIERCED15!=null?TIERCED15.getText():null) + " ";
                                  

                            }
                            break;

                    }

                    match(input,PARTYPER,FOLLOW_PARTYPER_in_div595); 
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
                        
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:312:5: (divModifier1= MODIFIER )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==MODIFIER) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:313:7: divModifier1= MODIFIER
                            {
                            divModifier1=(Token)match(input,MODIFIER,FOLLOW_MODIFIER_in_div653); 

                                    text += " " + (divModifier1!=null?divModifier1.getText():null);
                                  

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:318:5: VARIABLE_DIV (divModifier2= MODIFIER )? ( OF number_digits_or_words )?
                    {
                    VARIABLE_DIV16=(Token)match(input,VARIABLE_DIV,FOLLOW_VARIABLE_DIV_in_div673); 

                          text = (VARIABLE_DIV16!=null?VARIABLE_DIV16.getText():null);
                        
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:321:5: (divModifier2= MODIFIER )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==MODIFIER) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:322:7: divModifier2= MODIFIER
                            {
                            divModifier2=(Token)match(input,MODIFIER,FOLLOW_MODIFIER_in_div693); 

                                    text += " " + (divModifier2!=null?divModifier2.getText():null);
                                  

                            }
                            break;

                    }

                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:326:5: ( OF number_digits_or_words )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==OF) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:327:7: OF number_digits_or_words
                            {
                            OF17=(Token)match(input,OF,FOLLOW_OF_in_div716); 

                                    text += " " + (OF17!=null?OF17.getText():null);
                                  
                            pushFollow(FOLLOW_number_digits_or_words_in_div726);
                            number_digits_or_words18=number_digits_or_words();

                            state._fsp--;


                                    int gyronnyOf = convertNumber((number_digits_or_words18!=null?input.toString(number_digits_or_words18.start,number_digits_or_words18.stop):null));
                                    if (gyronnyOf % 2 != 0) {
                                        gyronnyOf++;
                                        diags.add(ShieldDiagnostic.build(LogLevel.WARN, "Parsing rule 'div'.  '" + (VARIABLE_DIV16!=null?VARIABLE_DIV16.getText():null) 
                                                + "' can only be of an even number; incremented number of sections to " + gyronnyOf));
                                    }
                                    text += " " + gyronnyOf;
                                  

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:341:5: CONTINUOUS_DIV
                    {
                    CONTINUOUS_DIV19=(Token)match(input,CONTINUOUS_DIV,FOLLOW_CONTINUOUS_DIV_in_div745); 

                          text = (CONTINUOUS_DIV19!=null?CONTINUOUS_DIV19.getText():null);
                        

                    }
                    break;
                case 4 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:345:5: QUARTER
                    {
                    QUARTER20=(Token)match(input,QUARTER,FOLLOW_QUARTER_in_div758); 

                          text = (QUARTER20!=null?QUARTER20.getText():null);
                        

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
    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:358:1: some_tinctures[Tinctures tinctures, ShieldDivisionType division] returns [Field layer] : ( tincture[tinctures] )+ AND tincture[tinctures] ;
    public final Field some_tinctures(Tinctures tinctures, ShieldDivisionType division) throws RecognitionException {
        Field layer = null;

        try {
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:359:3: ( ( tincture[tinctures] )+ AND tincture[tinctures] )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:360:3: ( tincture[tinctures] )+ AND tincture[tinctures]
            {

                int count = 0;
              
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:363:3: ( tincture[tinctures] )+
            int cnt17=0;
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>=COLOUR && LA17_0<=FUR)) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:364:5: tincture[tinctures]
            	    {
            	    pushFollow(FOLLOW_tincture_in_some_tinctures798);
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

            match(input,AND,FOLLOW_AND_in_some_tinctures810); 
            pushFollow(FOLLOW_tincture_in_some_tinctures812);
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
    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:381:1: tincture[Tinctures tinctures] returns [Tincture tincture] : ( COLOUR | METAL | FUR ) ;
    public final Tincture tincture(Tinctures tinctures) throws RecognitionException {
        Tincture tincture = null;

        Token COLOUR21=null;
        Token METAL22=null;
        Token FUR23=null;

        try {
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:382:3: ( ( COLOUR | METAL | FUR ) )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:383:3: ( COLOUR | METAL | FUR )
            {

                String tinctureName = "";
              
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:386:3: ( COLOUR | METAL | FUR )
            int alt18=3;
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
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:387:5: COLOUR
                    {
                    COLOUR21=(Token)match(input,COLOUR,FOLLOW_COLOUR_in_tincture842); 

                          tinctureName = (COLOUR21!=null?COLOUR21.getText():null);
                        

                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:391:5: METAL
                    {
                    METAL22=(Token)match(input,METAL,FOLLOW_METAL_in_tincture854); 

                          tinctureName = (METAL22!=null?METAL22.getText():null);
                        

                    }
                    break;
                case 3 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:395:5: FUR
                    {
                    FUR23=(Token)match(input,FUR,FOLLOW_FUR_in_tincture866); 

                          tinctureName = (FUR23!=null?FUR23.getText():null);
                        

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
    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:410:1: number_digits_or_words : ( DIGITS | NUMWORDS ( ( AND )? NUMWORDS )* | DETERMINER );
    public final BlazonParser.number_digits_or_words_return number_digits_or_words() throws RecognitionException {
        BlazonParser.number_digits_or_words_return retval = new BlazonParser.number_digits_or_words_return();
        retval.start = input.LT(1);

        try {
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:411:3: ( DIGITS | NUMWORDS ( ( AND )? NUMWORDS )* | DETERMINER )
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
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:412:3: DIGITS
                    {
                    match(input,DIGITS,FOLLOW_DIGITS_in_number_digits_or_words888); 

                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:413:5: NUMWORDS ( ( AND )? NUMWORDS )*
                    {
                    match(input,NUMWORDS,FOLLOW_NUMWORDS_in_number_digits_or_words894); 
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:414:5: ( ( AND )? NUMWORDS )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==AND||LA20_0==NUMWORDS) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:415:7: ( AND )? NUMWORDS
                    	    {
                    	    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:415:7: ( AND )?
                    	    int alt19=2;
                    	    int LA19_0 = input.LA(1);

                    	    if ( (LA19_0==AND) ) {
                    	        alt19=1;
                    	    }
                    	    switch (alt19) {
                    	        case 1 :
                    	            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:415:7: AND
                    	            {
                    	            match(input,AND,FOLLOW_AND_in_number_digits_or_words909); 

                    	            }
                    	            break;

                    	    }

                    	    match(input,NUMWORDS,FOLLOW_NUMWORDS_in_number_digits_or_words912); 

                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);


                    }
                    break;
                case 3 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:417:5: DETERMINER
                    {
                    match(input,DETERMINER,FOLLOW_DETERMINER_in_number_digits_or_words925); 

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


 

    public static final BitSet FOLLOW_field_in_shield73 = new BitSet(new long[]{0x0000000030000012L});
    public static final BitSet FOLLOW_charges_in_shield85 = new BitSet(new long[]{0x0000000030000012L});
    public static final BitSet FOLLOW_div_in_field136 = new BitSet(new long[]{0x000000000E000000L});
    public static final BitSet FOLLOW_some_tinctures_in_field144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tincture_in_field157 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_field160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DETERMINER_in_charges194 = new BitSet(new long[]{0x00000000000001E0L});
    public static final BitSet FOLLOW_single_geometric_charge_in_charges196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_number_digits_or_words_in_charges204 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_multiple_geometric_charges_in_charges206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_advanced_charge_in_charges214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_single_geometric_charge243 = new BitSet(new long[]{0x000000000E000200L});
    public static final BitSet FOLLOW_MODIFIER_in_single_geometric_charge291 = new BitSet(new long[]{0x000000000E000000L});
    public static final BitSet FOLLOW_tincture_in_single_geometric_charge304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_multiple_geometric_charges328 = new BitSet(new long[]{0x000000000E000200L});
    public static final BitSet FOLLOW_MODIFIER_in_multiple_geometric_charges360 = new BitSet(new long[]{0x000000000E000000L});
    public static final BitSet FOLLOW_tincture_in_multiple_geometric_charges373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DETERMINER_in_advanced_charge393 = new BitSet(new long[]{0x0000000000005000L});
    public static final BitSet FOLLOW_BEAST_in_advanced_charge408 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ATTITUDE_in_advanced_charge414 = new BitSet(new long[]{0x000000000E010000L});
    public static final BitSet FOLLOW_FLYING_BEAST_in_advanced_charge424 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_FLYING_ATTITUDE_in_advanced_charge430 = new BitSet(new long[]{0x000000000E010000L});
    public static final BitSet FOLLOW_ATTITUDE_MODIFIER_in_advanced_charge438 = new BitSet(new long[]{0x000000000E000000L});
    public static final BitSet FOLLOW_tincture_in_advanced_charge441 = new BitSet(new long[]{0x0000000000060002L});
    public static final BitSet FOLLOW_body_parts_in_advanced_charge444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BODY_PART_in_body_parts479 = new BitSet(new long[]{0x000000000E000000L});
    public static final BitSet FOLLOW_tincture_in_body_parts483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BODY_PART_in_body_parts509 = new BitSet(new long[]{0x000000000E000000L});
    public static final BitSet FOLLOW_tincture_in_body_parts513 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_AND_in_body_parts529 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_BODY_PART_in_body_parts535 = new BitSet(new long[]{0x000000000E000000L});
    public static final BitSet FOLLOW_tincture_in_body_parts539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TIERCED_in_div580 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_PARTYPER_in_div595 = new BitSet(new long[]{0x00000000000000A0L});
    public static final BitSet FOLLOW_set_in_div605 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_MODIFIER_in_div653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_DIV_in_div673 = new BitSet(new long[]{0x0000000000400202L});
    public static final BitSet FOLLOW_MODIFIER_in_div693 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_OF_in_div716 = new BitSet(new long[]{0x0000000030000010L});
    public static final BitSet FOLLOW_number_digits_or_words_in_div726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONTINUOUS_DIV_in_div745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUARTER_in_div758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tincture_in_some_tinctures798 = new BitSet(new long[]{0x000000000E040000L});
    public static final BitSet FOLLOW_AND_in_some_tinctures810 = new BitSet(new long[]{0x000000000E000000L});
    public static final BitSet FOLLOW_tincture_in_some_tinctures812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COLOUR_in_tincture842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_METAL_in_tincture854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUR_in_tincture866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DIGITS_in_number_digits_or_words888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMWORDS_in_number_digits_or_words894 = new BitSet(new long[]{0x0000000020040002L});
    public static final BitSet FOLLOW_AND_in_number_digits_or_words909 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_NUMWORDS_in_number_digits_or_words912 = new BitSet(new long[]{0x0000000020040002L});
    public static final BitSet FOLLOW_DETERMINER_in_number_digits_or_words925 = new BitSet(new long[]{0x0000000000000002L});

}