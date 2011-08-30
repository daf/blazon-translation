// $ANTLR 3.3 Nov 30, 2010 12:50:56 C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g 2011-08-30 11:07:58

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "PLAIN", "AND", "TIERCED", "PARTYPER", "DIV", "MODIFIER", "GYRONNY", "OF", "DIGITS", "NUMWORDS", "COLOUR", "METAL", "FUR", "WS"
    };
    public static final int EOF=-1;
    public static final int PLAIN=4;
    public static final int AND=5;
    public static final int TIERCED=6;
    public static final int PARTYPER=7;
    public static final int DIV=8;
    public static final int MODIFIER=9;
    public static final int GYRONNY=10;
    public static final int OF=11;
    public static final int DIGITS=12;
    public static final int NUMWORDS=13;
    public static final int COLOUR=14;
    public static final int METAL=15;
    public static final int FUR=16;
    public static final int WS=17;

    // delegates
    // delegators


        public BlazonParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public BlazonParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return BlazonParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g"; }


      private WordToNumberConverter converter = new WordToNumberConverter();
      private List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
      
      @Override
      public void emitErrorMessage(String msg) {
        diags.add(ShieldDiagnostic.build(LogLevel.ERROR, msg));
      }



    // $ANTLR start "shield"
    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:38:1: shield returns [Shield s] : field ;
    public final Shield shield() throws RecognitionException {
        Shield s = null;

        ShieldLayer field1 = null;


        try {
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:39:7: ( field )
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:39:11: field
            {
            pushFollow(FOLLOW_field_in_shield64);
            field1=field();

            state._fsp--;

             
            		    s = ShieldImpl.build(field1);
            		    //TOOD make HTML pretty
            		    //TODO add lozengy etc
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
    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:52:1: field returns [ShieldLayer layer] : ( plain_field | divided_field );
    public final ShieldLayer field() throws RecognitionException {
        ShieldLayer layer = null;

        ShieldLayer plain_field2 = null;

        ShieldLayer divided_field3 = null;


        try {
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:53:7: ( plain_field | divided_field )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( ((LA1_0>=COLOUR && LA1_0<=FUR)) ) {
                alt1=1;
            }
            else if ( ((LA1_0>=TIERCED && LA1_0<=PARTYPER)||LA1_0==GYRONNY) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:53:11: plain_field
                    {
                    pushFollow(FOLLOW_plain_field_in_field105);
                    plain_field2=plain_field();

                    state._fsp--;

                     layer = plain_field2; 

                    }
                    break;
                case 2 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:54:11: divided_field
                    {
                    pushFollow(FOLLOW_divided_field_in_field119);
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
            //catch (RecognitionException re) { reportError(re); recover(input,re); }
        finally {
        }
        return layer;
    }
    // $ANTLR end "field"


    // $ANTLR start "divided_field"
    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:57:1: divided_field returns [ShieldLayer layer] : ( div | special_div ) some_tinctures[tinctures, division] ;
    public final ShieldLayer divided_field() throws RecognitionException {
        ShieldLayer layer = null;

        String div4 = null;

        String special_div5 = null;

        ShieldLayer some_tinctures6 = null;


        try {
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:58:7: ( ( div | special_div ) some_tinctures[tinctures, division] )
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:59:9: ( div | special_div ) some_tinctures[tinctures, division]
            {

            		        ShieldDivisionType division = null;
            		        Tinctures tinctures = new Tinctures();
            		        ShieldDivision divisions = new ShieldDivision();
            		      
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:64:8: ( div | special_div )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( ((LA2_0>=TIERCED && LA2_0<=PARTYPER)) ) {
                alt2=1;
            }
            else if ( (LA2_0==GYRONNY) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:65:12: div
                    {
                    pushFollow(FOLLOW_div_in_divided_field181);
                    div4=div();

                    state._fsp--;


                    			            division = divisions.getDivisionType(div4);
                    			        

                    }
                    break;
                case 2 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:69:12: special_div
                    {
                    pushFollow(FOLLOW_special_div_in_divided_field205);
                    special_div5=special_div();

                    state._fsp--;

                     
                    			            division = divisions.getDivisionType(special_div5); 
                    			        

                    }
                    break;

            }

            pushFollow(FOLLOW_some_tinctures_in_divided_field240);
            some_tinctures6=some_tinctures(tinctures, division);

            state._fsp--;

             layer = some_tinctures6; 

            }

        }

            catch (RecognitionException re) {
                throw re;
            }
            //catch (RecognitionException re) { reportError(re); recover(input,re); }
        finally {
        }
        return layer;
    }
    // $ANTLR end "divided_field"


    // $ANTLR start "plain_field"
    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:77:1: plain_field returns [ShieldLayer layer] : tincture[tinctures] ( PLAIN )? ;
    public final ShieldLayer plain_field() throws RecognitionException {
        ShieldLayer layer = null;

        Tincture tincture7 = null;


        try {
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:78:7: ( tincture[tinctures] ( PLAIN )? )
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:78:11: tincture[tinctures] ( PLAIN )?
            {
             Tinctures tinctures = new Tinctures(); 
            pushFollow(FOLLOW_tincture_in_plain_field290);
            tincture7=tincture(tinctures);

            state._fsp--;

            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:79:31: ( PLAIN )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==PLAIN) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:79:31: PLAIN
                    {
                    match(input,PLAIN,FOLLOW_PLAIN_in_plain_field293); 

                    }
                    break;

            }


            		            tinctures.addTincture(tincture7);
            		            layer = ShieldLayer.buildUndividedShieldLayer(tinctures);
            		        

            }

        }

            catch (RecognitionException re) {
                throw re;
            }
            //catch (RecognitionException re) { reportError(re); recover(input,re); }
        finally {
        }
        return layer;
    }
    // $ANTLR end "plain_field"


    // $ANTLR start "some_tinctures"
    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:86:1: some_tinctures[Tinctures tinctures, ShieldDivisionType division] returns [ShieldLayer layer] : (t= tincture[tinctures] )+ AND t= tincture[tinctures] ;
    public final ShieldLayer some_tinctures(Tinctures tinctures, ShieldDivisionType division) throws RecognitionException {
        ShieldLayer layer = null;

        Tincture t = null;


        try {
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:87:9: ( (t= tincture[tinctures] )+ AND t= tincture[tinctures] )
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:87:13: (t= tincture[tinctures] )+ AND t= tincture[tinctures]
            {
             int count = 0; 
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:88:13: (t= tincture[tinctures] )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>=COLOUR && LA4_0<=FUR)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:89:17: t= tincture[tinctures]
            	    {
            	    pushFollow(FOLLOW_tincture_in_some_tinctures377);
            	    t=tincture(tinctures);

            	    state._fsp--;

            	     tinctures.addTincture(t); count++; 

            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);

            match(input,AND,FOLLOW_AND_in_some_tinctures426); 
            pushFollow(FOLLOW_tincture_in_some_tinctures444);
            t=tincture(tinctures);

            state._fsp--;


            		            count++;
            		            tinctures.addTincture(t);
            		            int numberOfTinctures = division.getNumberOfTinctures();
            		            if (numberOfTinctures != count) {
            		                throw new MyRecognitionException("Incorrect number of tinctures specified. The '" 
            		                    + division + "' division type only allows the following number of tinctures: "
            		                    + numberOfTinctures + " but found " + count);
            		            }
            		            layer = ShieldLayer.buildDividedShieldLayer(tinctures, division);
            		        

            }

        }

            catch (RecognitionException re) {
                throw re;
            }
            //catch (RecognitionException re) { reportError(re); recover(input,re); }
        finally {
        }
        return layer;
    }
    // $ANTLR end "some_tinctures"


    // $ANTLR start "div"
    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:107:1: div returns [String text] : ( TIERCED )? PARTYPER DIV ( MODIFIER )? ;
    public final String div() throws RecognitionException {
        String text = null;

        Token TIERCED8=null;
        Token DIV9=null;
        Token MODIFIER10=null;

        try {
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:108:9: ( ( TIERCED )? PARTYPER DIV ( MODIFIER )? )
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:108:13: ( TIERCED )? PARTYPER DIV ( MODIFIER )?
            {
             text = ""; 
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:109:13: ( TIERCED )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==TIERCED) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:110:17: TIERCED
                    {
                    TIERCED8=(Token)match(input,TIERCED,FOLLOW_TIERCED_in_div522); 
                     text = (TIERCED8!=null?TIERCED8.getText():null); 

                    }
                    break;

            }

            match(input,PARTYPER,FOLLOW_PARTYPER_in_div553); 
            DIV9=(Token)match(input,DIV,FOLLOW_DIV_in_div567); 
             text += " " + (DIV9!=null?DIV9.getText():null); 
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:114:13: ( MODIFIER )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==MODIFIER) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:115:17: MODIFIER
                    {
                    MODIFIER10=(Token)match(input,MODIFIER,FOLLOW_MODIFIER_in_div601); 
                     text += " " + (MODIFIER10!=null?MODIFIER10.getText():null); 

                    }
                    break;

            }


            }

        }

            catch (RecognitionException re) {
                throw re;
            }
            //catch (RecognitionException re) { reportError(re); recover(input,re); }
        finally {
        }
        return text;
    }
    // $ANTLR end "div"


    // $ANTLR start "special_div"
    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:119:1: special_div returns [String text] : GYRONNY ( OF number_digits_or_words )? ;
    public final String special_div() throws RecognitionException {
        String text = null;

        Token GYRONNY11=null;
        Token OF12=null;
        BlazonParser.number_digits_or_words_return number_digits_or_words13 = null;


        try {
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:120:9: ( GYRONNY ( OF number_digits_or_words )? )
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:120:13: GYRONNY ( OF number_digits_or_words )?
            {
            GYRONNY11=(Token)match(input,GYRONNY,FOLLOW_GYRONNY_in_special_div649); 
             text = (GYRONNY11!=null?GYRONNY11.getText():null); 
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:121:13: ( OF number_digits_or_words )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==OF) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:122:17: OF number_digits_or_words
                    {
                    OF12=(Token)match(input,OF,FOLLOW_OF_in_special_div683); 
                     text += " " + (OF12!=null?OF12.getText():null); 
                    pushFollow(FOLLOW_number_digits_or_words_in_special_div703);
                    number_digits_or_words13=number_digits_or_words();

                    state._fsp--;


                                        try {
                                            int gyronnyOf = converter.convert((number_digits_or_words13!=null?input.toString(number_digits_or_words13.start,number_digits_or_words13.stop):null));
                                            if (gyronnyOf % 2 != 0) {
                                                gyronnyOf++;
                                                diags.add(ShieldDiagnostic.build(LogLevel.WARN, "Parsing 'special_div', gyronny can only be of an"
                                                        + " even number; incremented number of sections to " + gyronnyOf));
                                            }
                                            text += " " + gyronnyOf;
                                        } catch (Exception e) {
                                        throw new MyRecognitionException("Unable to convert '" 
                                                + (number_digits_or_words13!=null?input.toString(number_digits_or_words13.start,number_digits_or_words13.stop):null) + "' into an integer.", e);
                                        }
                                    

                    }
                    break;

            }


            }

        }

            catch (RecognitionException re) {
                throw re;
            }
            //catch (RecognitionException re) { reportError(re); recover(input,re); }
        finally {
        }
        return text;
    }
    // $ANTLR end "special_div"

    public static class number_digits_or_words_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "number_digits_or_words"
    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:141:1: number_digits_or_words : ( DIGITS | NUMWORDS ( ( AND )? NUMWORDS )* );
    public final BlazonParser.number_digits_or_words_return number_digits_or_words() throws RecognitionException {
        BlazonParser.number_digits_or_words_return retval = new BlazonParser.number_digits_or_words_return();
        retval.start = input.LT(1);

        try {
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:142:9: ( DIGITS | NUMWORDS ( ( AND )? NUMWORDS )* )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==DIGITS) ) {
                alt10=1;
            }
            else if ( (LA10_0==NUMWORDS) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:142:13: DIGITS
                    {
                    match(input,DIGITS,FOLLOW_DIGITS_in_number_digits_or_words763); 

                    }
                    break;
                case 2 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:143:13: NUMWORDS ( ( AND )? NUMWORDS )*
                    {
                    match(input,NUMWORDS,FOLLOW_NUMWORDS_in_number_digits_or_words777); 
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:143:22: ( ( AND )? NUMWORDS )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==AND||LA9_0==NUMWORDS) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:143:23: ( AND )? NUMWORDS
                    	    {
                    	    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:143:23: ( AND )?
                    	    int alt8=2;
                    	    int LA8_0 = input.LA(1);

                    	    if ( (LA8_0==AND) ) {
                    	        alt8=1;
                    	    }
                    	    switch (alt8) {
                    	        case 1 :
                    	            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:143:23: AND
                    	            {
                    	            match(input,AND,FOLLOW_AND_in_number_digits_or_words780); 

                    	            }
                    	            break;

                    	    }

                    	    match(input,NUMWORDS,FOLLOW_NUMWORDS_in_number_digits_or_words783); 

                    	    }
                    	    break;

                    	default :
                    	    break loop9;
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
            //catch (RecognitionException re) { reportError(re); recover(input,re); }
        finally {
        }
        return retval;
    }
    // $ANTLR end "number_digits_or_words"


    // $ANTLR start "tincture"
    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:146:1: tincture[Tinctures tinctures] returns [Tincture tincture] : ( COLOUR | METAL | FUR ) ;
    public final Tincture tincture(Tinctures tinctures) throws RecognitionException {
        Tincture tincture = null;

        Token COLOUR14=null;
        Token METAL15=null;
        Token FUR16=null;

        try {
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:147:9: ( ( COLOUR | METAL | FUR ) )
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:147:13: ( COLOUR | METAL | FUR )
            {
             String tinctureName = ""; 
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:148:9: ( COLOUR | METAL | FUR )
            int alt11=3;
            switch ( input.LA(1) ) {
            case COLOUR:
                {
                alt11=1;
                }
                break;
            case METAL:
                {
                alt11=2;
                }
                break;
            case FUR:
                {
                alt11=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:148:13: COLOUR
                    {
                    COLOUR14=(Token)match(input,COLOUR,FOLLOW_COLOUR_in_tincture835); 
                     tinctureName = (COLOUR14!=null?COLOUR14.getText():null); 

                    }
                    break;
                case 2 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:149:13: METAL
                    {
                    METAL15=(Token)match(input,METAL,FOLLOW_METAL_in_tincture851); 
                     tinctureName = (METAL15!=null?METAL15.getText():null); 

                    }
                    break;
                case 3 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:150:13: FUR
                    {
                    FUR16=(Token)match(input,FUR,FOLLOW_FUR_in_tincture868); 
                     tinctureName = (FUR16!=null?FUR16.getText():null); 

                    }
                    break;

            }

               try {
                            tincture = tinctures.getTincture(tinctureName);
                        } catch (UnknownTinctureException e) {
                            throw new MyRecognitionException("Unknown tincture found.", e);
                        }
                    

            }

        }

            catch (RecognitionException re) {
                throw re;
            }
            //catch (RecognitionException re) { reportError(re); recover(input,re); }
        finally {
        }
        return tincture;
    }
    // $ANTLR end "tincture"

    // Delegated rules


 

    public static final BitSet FOLLOW_field_in_shield64 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_plain_field_in_field105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_divided_field_in_field119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_div_in_divided_field181 = new BitSet(new long[]{0x000000000001C000L});
    public static final BitSet FOLLOW_special_div_in_divided_field205 = new BitSet(new long[]{0x000000000001C000L});
    public static final BitSet FOLLOW_some_tinctures_in_divided_field240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tincture_in_plain_field290 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_PLAIN_in_plain_field293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tincture_in_some_tinctures377 = new BitSet(new long[]{0x000000000001C020L});
    public static final BitSet FOLLOW_AND_in_some_tinctures426 = new BitSet(new long[]{0x000000000001C000L});
    public static final BitSet FOLLOW_tincture_in_some_tinctures444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TIERCED_in_div522 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_PARTYPER_in_div553 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_DIV_in_div567 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_MODIFIER_in_div601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GYRONNY_in_special_div649 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_OF_in_special_div683 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_number_digits_or_words_in_special_div703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DIGITS_in_number_digits_or_words763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMWORDS_in_number_digits_or_words777 = new BitSet(new long[]{0x0000000000002022L});
    public static final BitSet FOLLOW_AND_in_number_digits_or_words780 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_NUMWORDS_in_number_digits_or_words783 = new BitSet(new long[]{0x0000000000002022L});
    public static final BitSet FOLLOW_COLOUR_in_tincture835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_METAL_in_tincture851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUR_in_tincture868 = new BitSet(new long[]{0x0000000000000002L});

}