// $ANTLR 3.3 Nov 30, 2010 12:50:56 /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g 2011-09-11 21:45:55

package blazon.server.grammar;
import blazon.shared.shield.*;
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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "PLAIN", "AND", "TIERCED", "PARTYPER", "DIV", "DIV_MODIFIER", "VARIABLE_DIV", "OF", "CONTINUOUS_DIV", "QUARTER", "DIGITS", "NUMWORDS", "COLOUR", "METAL", "FUR", "WS"
    };
    public static final int EOF=-1;
    public static final int PLAIN=4;
    public static final int AND=5;
    public static final int TIERCED=6;
    public static final int PARTYPER=7;
    public static final int DIV=8;
    public static final int DIV_MODIFIER=9;
    public static final int VARIABLE_DIV=10;
    public static final int OF=11;
    public static final int CONTINUOUS_DIV=12;
    public static final int QUARTER=13;
    public static final int DIGITS=14;
    public static final int NUMWORDS=15;
    public static final int COLOUR=16;
    public static final int METAL=17;
    public static final int FUR=18;
    public static final int WS=19;

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


      private WordToNumberConverter converter = new WordToNumberConverter();
      private List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
      
      @Override
      public void emitErrorMessage(String msg) {
        diags.add(ShieldDiagnostic.build(LogLevel.ERROR, msg));
      }



    // $ANTLR start "shield"
    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:37:1: shield returns [Shield s] : field ;
    public final Shield shield() throws RecognitionException {
        Shield s = null;

        ShieldLayer field1 = null;


        try {
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:38:7: ( field )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:38:11: field
            {
             String blazon = input.toString(); 
            pushFollow(FOLLOW_field_in_shield73);
            field1=field();

            state._fsp--;

             
            		    s = ShieldImpl.build(field1, blazon);
            		    //LATER make HTML pretty
            		    //TODO add charges
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
    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:51:1: field returns [ShieldLayer layer] : ( plain_field | divided_field );
    public final ShieldLayer field() throws RecognitionException {
        ShieldLayer layer = null;

        ShieldLayer plain_field2 = null;

        ShieldLayer divided_field3 = null;


        try {
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:52:7: ( plain_field | divided_field )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( ((LA1_0>=COLOUR && LA1_0<=FUR)) ) {
                alt1=1;
            }
            else if ( ((LA1_0>=TIERCED && LA1_0<=PARTYPER)||LA1_0==VARIABLE_DIV||(LA1_0>=CONTINUOUS_DIV && LA1_0<=QUARTER)) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:52:11: plain_field
                    {
                    pushFollow(FOLLOW_plain_field_in_field114);
                    plain_field2=plain_field();

                    state._fsp--;

                     layer = plain_field2; 

                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:53:11: divided_field
                    {
                    pushFollow(FOLLOW_divided_field_in_field128);
                    divided_field3=divided_field();

                    state._fsp--;

                     layer = divided_field3; 

                    }
                    break;

            }
        }

            catch (RecognitionException re) {
                throw re;
            }
        finally {
        }
        return layer;
    }
    // $ANTLR end "field"


    // $ANTLR start "divided_field"
    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:56:1: divided_field returns [ShieldLayer layer] : div some_tinctures[tinctures, division] ;
    public final ShieldLayer divided_field() throws RecognitionException {
        ShieldLayer layer = null;

        ShieldDivisionType div4 = null;

        ShieldLayer some_tinctures5 = null;


        try {
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:57:7: ( div some_tinctures[tinctures, division] )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:58:9: div some_tinctures[tinctures, division]
            {
             Tinctures tinctures = new Tinctures(); 
            pushFollow(FOLLOW_div_in_divided_field177);
            div4=div();

            state._fsp--;

             ShieldDivisionType division = div4; 
            pushFollow(FOLLOW_some_tinctures_in_divided_field190);
            some_tinctures5=some_tinctures(tinctures, division);

            state._fsp--;

             layer = some_tinctures5; 

            }

        }

            catch (RecognitionException re) {
                throw re;
            }
        finally {
        }
        return layer;
    }
    // $ANTLR end "divided_field"


    // $ANTLR start "plain_field"
    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:63:1: plain_field returns [ShieldLayer layer] : tincture[tinctures] ( PLAIN )? ;
    public final ShieldLayer plain_field() throws RecognitionException {
        ShieldLayer layer = null;

        Tincture tincture6 = null;


        try {
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:64:7: ( tincture[tinctures] ( PLAIN )? )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:64:11: tincture[tinctures] ( PLAIN )?
            {
             Tinctures tinctures = new Tinctures(); 
            pushFollow(FOLLOW_tincture_in_plain_field240);
            tincture6=tincture(tinctures);

            state._fsp--;

            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:65:31: ( PLAIN )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==PLAIN) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:65:31: PLAIN
                    {
                    match(input,PLAIN,FOLLOW_PLAIN_in_plain_field243); 

                    }
                    break;

            }


            		            tinctures.addTincture(tincture6);
            		            layer = ShieldLayer.buildUndividedShieldLayer(tinctures);
            		        

            }

        }

            catch (RecognitionException re) {
                throw re;
            }
        finally {
        }
        return layer;
    }
    // $ANTLR end "plain_field"


    // $ANTLR start "some_tinctures"
    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:72:1: some_tinctures[Tinctures tinctures, ShieldDivisionType division] returns [ShieldLayer layer] : (t= tincture[tinctures] )+ AND t= tincture[tinctures] ;
    public final ShieldLayer some_tinctures(Tinctures tinctures, ShieldDivisionType division) throws RecognitionException {
        ShieldLayer layer = null;

        Tincture t = null;


        try {
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:73:9: ( (t= tincture[tinctures] )+ AND t= tincture[tinctures] )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:73:13: (t= tincture[tinctures] )+ AND t= tincture[tinctures]
            {
             int count = 0; 
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:74:13: (t= tincture[tinctures] )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=COLOUR && LA3_0<=FUR)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:75:17: t= tincture[tinctures]
            	    {
            	    pushFollow(FOLLOW_tincture_in_some_tinctures327);
            	    t=tincture(tinctures);

            	    state._fsp--;

            	     tinctures.addTincture(t); count++; 

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);

            match(input,AND,FOLLOW_AND_in_some_tinctures376); 
            pushFollow(FOLLOW_tincture_in_some_tinctures394);
            t=tincture(tinctures);

            state._fsp--;


            		            count++;
            		            tinctures.addTincture(t);
            		            int numberOfTinctures = division.getNumberOfTinctures();
            		            if (numberOfTinctures != count) {
            		                diags.add(ShieldDiagnostic.build(LogLevel.ERROR, "Incorrect number of tinctures specified." +
            		                    "  The '" + division + "' division type only allows the following number of tinctures: "
            		                    + numberOfTinctures + " but found " + count));
            		                throw new RecognitionException(this.input);
            		            }
            		            layer = ShieldLayer.buildDividedShieldLayer(tinctures, division);
            		        

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


    // $ANTLR start "div"
    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:94:1: div returns [ShieldDivisionType division] : ( ( TIERCED )? PARTYPER DIV (divModifier1= DIV_MODIFIER )? | VARIABLE_DIV (divModifier2= DIV_MODIFIER )? ( OF number_digits_or_words )? | CONTINUOUS_DIV | QUARTER ) ;
    public final ShieldDivisionType div() throws RecognitionException {
        ShieldDivisionType division = null;

        Token divModifier1=null;
        Token divModifier2=null;
        Token TIERCED7=null;
        Token DIV8=null;
        Token VARIABLE_DIV9=null;
        Token OF10=null;
        Token CONTINUOUS_DIV12=null;
        Token QUARTER13=null;
        BlazonParser.number_digits_or_words_return number_digits_or_words11 = null;


        try {
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:95:9: ( ( ( TIERCED )? PARTYPER DIV (divModifier1= DIV_MODIFIER )? | VARIABLE_DIV (divModifier2= DIV_MODIFIER )? ( OF number_digits_or_words )? | CONTINUOUS_DIV | QUARTER ) )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:95:13: ( ( TIERCED )? PARTYPER DIV (divModifier1= DIV_MODIFIER )? | VARIABLE_DIV (divModifier2= DIV_MODIFIER )? ( OF number_digits_or_words )? | CONTINUOUS_DIV | QUARTER )
            {
             String text = ""; 
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:96:9: ( ( TIERCED )? PARTYPER DIV (divModifier1= DIV_MODIFIER )? | VARIABLE_DIV (divModifier2= DIV_MODIFIER )? ( OF number_digits_or_words )? | CONTINUOUS_DIV | QUARTER )
            int alt8=4;
            switch ( input.LA(1) ) {
            case TIERCED:
            case PARTYPER:
                {
                alt8=1;
                }
                break;
            case VARIABLE_DIV:
                {
                alt8=2;
                }
                break;
            case CONTINUOUS_DIV:
                {
                alt8=3;
                }
                break;
            case QUARTER:
                {
                alt8=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:97:13: ( TIERCED )? PARTYPER DIV (divModifier1= DIV_MODIFIER )?
                    {
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:97:13: ( TIERCED )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==TIERCED) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:98:17: TIERCED
                            {
                            TIERCED7=(Token)match(input,TIERCED,FOLLOW_TIERCED_in_div486); 
                             text = (TIERCED7!=null?TIERCED7.getText():null) + " "; 

                            }
                            break;

                    }

                    match(input,PARTYPER,FOLLOW_PARTYPER_in_div517); 
                    DIV8=(Token)match(input,DIV,FOLLOW_DIV_in_div531); 
                     text += (DIV8!=null?DIV8.getText():null); 
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:102:13: (divModifier1= DIV_MODIFIER )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==DIV_MODIFIER) ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:103:17: divModifier1= DIV_MODIFIER
                            {
                            divModifier1=(Token)match(input,DIV_MODIFIER,FOLLOW_DIV_MODIFIER_in_div569); 
                             text += " " + (divModifier1!=null?divModifier1.getText():null); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:106:13: VARIABLE_DIV (divModifier2= DIV_MODIFIER )? ( OF number_digits_or_words )?
                    {
                    VARIABLE_DIV9=(Token)match(input,VARIABLE_DIV,FOLLOW_VARIABLE_DIV_in_div610); 
                     text = (VARIABLE_DIV9!=null?VARIABLE_DIV9.getText():null); 
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:107:13: (divModifier2= DIV_MODIFIER )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==DIV_MODIFIER) ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:108:17: divModifier2= DIV_MODIFIER
                            {
                            divModifier2=(Token)match(input,DIV_MODIFIER,FOLLOW_DIV_MODIFIER_in_div648); 
                             text += " " + (divModifier2!=null?divModifier2.getText():null); 

                            }
                            break;

                    }

                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:110:13: ( OF number_digits_or_words )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==OF) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:111:17: OF number_digits_or_words
                            {
                            OF10=(Token)match(input,OF,FOLLOW_OF_in_div697); 
                             text += " " + (OF10!=null?OF10.getText():null); 
                            pushFollow(FOLLOW_number_digits_or_words_in_div717);
                            number_digits_or_words11=number_digits_or_words();

                            state._fsp--;


                                                try {
                                                    int gyronnyOf = converter.convert((number_digits_or_words11!=null?input.toString(number_digits_or_words11.start,number_digits_or_words11.stop):null));
                                                    if (gyronnyOf % 2 != 0) {
                                                        gyronnyOf++;
                                                        diags.add(ShieldDiagnostic.build(LogLevel.WARN, "Parsing rule 'div'.  '" + (VARIABLE_DIV9!=null?VARIABLE_DIV9.getText():null) 
                                                                + "' can only be of an even number; incremented number of sections to " + gyronnyOf));
                                                    }
                                                    text += " " + gyronnyOf;
                                                } catch (Exception e) {
                                                    diags.add(ShieldDiagnostic.build(LogLevel.ERROR, "Unable to convert '" + (number_digits_or_words11!=null?input.toString(number_digits_or_words11.start,number_digits_or_words11.stop):null) 
                                                        + "' into an integer. Caught: " +  e));
                                                    throw new RecognitionException(this.input);
                                                }
                                            

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:130:13: CONTINUOUS_DIV
                    {
                    CONTINUOUS_DIV12=(Token)match(input,CONTINUOUS_DIV,FOLLOW_CONTINUOUS_DIV_in_div774); 
                     text = (CONTINUOUS_DIV12!=null?CONTINUOUS_DIV12.getText():null); 

                    }
                    break;
                case 4 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:132:13: QUARTER
                    {
                    QUARTER13=(Token)match(input,QUARTER,FOLLOW_QUARTER_in_div800); 
                     text = (QUARTER13!=null?QUARTER13.getText():null); 

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

    public static class number_digits_or_words_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "number_digits_or_words"
    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:143:1: number_digits_or_words : ( DIGITS | NUMWORDS ( ( AND )? NUMWORDS )* );
    public final BlazonParser.number_digits_or_words_return number_digits_or_words() throws RecognitionException {
        BlazonParser.number_digits_or_words_return retval = new BlazonParser.number_digits_or_words_return();
        retval.start = input.LT(1);

        try {
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:144:9: ( DIGITS | NUMWORDS ( ( AND )? NUMWORDS )* )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==DIGITS) ) {
                alt11=1;
            }
            else if ( (LA11_0==NUMWORDS) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:144:13: DIGITS
                    {
                    match(input,DIGITS,FOLLOW_DIGITS_in_number_digits_or_words849); 

                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:145:13: NUMWORDS ( ( AND )? NUMWORDS )*
                    {
                    match(input,NUMWORDS,FOLLOW_NUMWORDS_in_number_digits_or_words863); 
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:145:22: ( ( AND )? NUMWORDS )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==AND||LA10_0==NUMWORDS) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:145:23: ( AND )? NUMWORDS
                    	    {
                    	    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:145:23: ( AND )?
                    	    int alt9=2;
                    	    int LA9_0 = input.LA(1);

                    	    if ( (LA9_0==AND) ) {
                    	        alt9=1;
                    	    }
                    	    switch (alt9) {
                    	        case 1 :
                    	            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:145:23: AND
                    	            {
                    	            match(input,AND,FOLLOW_AND_in_number_digits_or_words866); 

                    	            }
                    	            break;

                    	    }

                    	    match(input,NUMWORDS,FOLLOW_NUMWORDS_in_number_digits_or_words869); 

                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);


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


    // $ANTLR start "tincture"
    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:148:1: tincture[Tinctures tinctures] returns [Tincture tincture] : ( COLOUR | METAL | FUR ) ;
    public final Tincture tincture(Tinctures tinctures) throws RecognitionException {
        Tincture tincture = null;

        Token COLOUR14=null;
        Token METAL15=null;
        Token FUR16=null;

        try {
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:149:9: ( ( COLOUR | METAL | FUR ) )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:149:13: ( COLOUR | METAL | FUR )
            {
             String tinctureName = ""; 
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:150:9: ( COLOUR | METAL | FUR )
            int alt12=3;
            switch ( input.LA(1) ) {
            case COLOUR:
                {
                alt12=1;
                }
                break;
            case METAL:
                {
                alt12=2;
                }
                break;
            case FUR:
                {
                alt12=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:150:13: COLOUR
                    {
                    COLOUR14=(Token)match(input,COLOUR,FOLLOW_COLOUR_in_tincture921); 
                     tinctureName = (COLOUR14!=null?COLOUR14.getText():null); 

                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:151:13: METAL
                    {
                    METAL15=(Token)match(input,METAL,FOLLOW_METAL_in_tincture937); 
                     tinctureName = (METAL15!=null?METAL15.getText():null); 

                    }
                    break;
                case 3 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:152:13: FUR
                    {
                    FUR16=(Token)match(input,FUR,FOLLOW_FUR_in_tincture954); 
                     tinctureName = (FUR16!=null?FUR16.getText():null); 

                    }
                    break;

            }

               try {
                            tincture = tinctures.getTincture(tinctureName);
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

    // Delegated rules


 

    public static final BitSet FOLLOW_field_in_shield73 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_plain_field_in_field114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_divided_field_in_field128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_div_in_divided_field177 = new BitSet(new long[]{0x0000000000070000L});
    public static final BitSet FOLLOW_some_tinctures_in_divided_field190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tincture_in_plain_field240 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_PLAIN_in_plain_field243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tincture_in_some_tinctures327 = new BitSet(new long[]{0x0000000000070020L});
    public static final BitSet FOLLOW_AND_in_some_tinctures376 = new BitSet(new long[]{0x0000000000070000L});
    public static final BitSet FOLLOW_tincture_in_some_tinctures394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TIERCED_in_div486 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_PARTYPER_in_div517 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_DIV_in_div531 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_DIV_MODIFIER_in_div569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_DIV_in_div610 = new BitSet(new long[]{0x0000000000000A02L});
    public static final BitSet FOLLOW_DIV_MODIFIER_in_div648 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_OF_in_div697 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_number_digits_or_words_in_div717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONTINUOUS_DIV_in_div774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUARTER_in_div800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DIGITS_in_number_digits_or_words849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMWORDS_in_number_digits_or_words863 = new BitSet(new long[]{0x0000000000008022L});
    public static final BitSet FOLLOW_AND_in_number_digits_or_words866 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_NUMWORDS_in_number_digits_or_words869 = new BitSet(new long[]{0x0000000000008022L});
    public static final BitSet FOLLOW_COLOUR_in_tincture921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_METAL_in_tincture937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUR_in_tincture954 = new BitSet(new long[]{0x0000000000000002L});

}