// $ANTLR 3.3 Nov 30, 2010 12:50:56 C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g 2011-07-18 14:47:14

  package blazon.server.grammar;
  import blazon.shared.shield.*;
  import blazon.shared.shield.ShieldDivision.ShieldDivisionType;
  import blazon.shared.shield.tinctures.*;
  import blazon.shared.numberconversion.WordToNumberConverter;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class BlazonParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "PARTYPER", "AND", "DIV", "MODIFIER", "GYRONNY", "OF", "DIGITS", "NUMWORDS", "COLOUR", "METAL", "FUR", "WS", "'plain'"
    };
    public static final int EOF=-1;
    public static final int T__16=16;
    public static final int PARTYPER=4;
    public static final int AND=5;
    public static final int DIV=6;
    public static final int MODIFIER=7;
    public static final int GYRONNY=8;
    public static final int OF=9;
    public static final int DIGITS=10;
    public static final int NUMWORDS=11;
    public static final int COLOUR=12;
    public static final int METAL=13;
    public static final int FUR=14;
    public static final int WS=15;

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


      WordToNumberConverter converter = new WordToNumberConverter();



    // $ANTLR start "shield"
    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:34:1: shield returns [Shield s] : field ;
    public final Shield shield() throws RecognitionException {
        Shield s = null;

        ShieldLayer field1 = null;


        try {
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:35:7: ( field )
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:35:11: field
            {
            pushFollow(FOLLOW_field_in_shield64);
            field1=field();

            state._fsp--;

             s = Shield.build(field1); 

            }

        }

            catch (MyRecognitionException re) {
                System.err.println("Caught MyRecognitionException:");
                System.err.println(re.message);
            } 
            catch (RecognitionException re) {
                reportError(re);
                recover(input,re);
            }
        finally {
        }
        return s;
    }
    // $ANTLR end "shield"


    // $ANTLR start "field"
    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:38:1: field returns [ShieldLayer layer] : ( plain_field | divided_field );
    public final ShieldLayer field() throws RecognitionException {
        ShieldLayer layer = null;

        ShieldLayer plain_field2 = null;

        ShieldLayer divided_field3 = null;


        try {
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:39:7: ( plain_field | divided_field )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( ((LA1_0>=COLOUR && LA1_0<=FUR)) ) {
                alt1=1;
            }
            else if ( (LA1_0==PARTYPER||LA1_0==GYRONNY) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:39:11: plain_field
                    {
                    pushFollow(FOLLOW_plain_field_in_field93);
                    plain_field2=plain_field();

                    state._fsp--;

                     layer = plain_field2; 

                    }
                    break;
                case 2 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:40:11: divided_field
                    {
                    pushFollow(FOLLOW_divided_field_in_field107);
                    divided_field3=divided_field();

                    state._fsp--;

                     layer = divided_field3; 

                    }
                    break;

            }
        }

            catch (MyRecognitionException re) {
                System.err.println("Caught MyRecognitionException:");
                System.err.println(re.message);
            } 
            catch (RecognitionException re) {
                reportError(re);
                recover(input,re);
            }
        finally {
        }
        return layer;
    }
    // $ANTLR end "field"


    // $ANTLR start "divided_field"
    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:43:1: divided_field returns [ShieldLayer layer] : ( PARTYPER div | special_div ) some_tinctures[tinctures, division] ;
    public final ShieldLayer divided_field() throws RecognitionException {
        ShieldLayer layer = null;

        BlazonParser.div_return div4 = null;

        String special_div5 = null;

        ShieldLayer some_tinctures6 = null;


        try {
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:44:7: ( ( PARTYPER div | special_div ) some_tinctures[tinctures, division] )
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:45:9: ( PARTYPER div | special_div ) some_tinctures[tinctures, division]
            {

            		        ShieldDivisionType division = null;
            		        Tinctures tinctures = new Tinctures();
            		      
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:49:8: ( PARTYPER div | special_div )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==PARTYPER) ) {
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
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:50:12: PARTYPER div
                    {
                    match(input,PARTYPER,FOLLOW_PARTYPER_in_divided_field169); 
                    pushFollow(FOLLOW_div_in_divided_field182);
                    div4=div();

                    state._fsp--;


                    			            ShieldDivision divisions = new ShieldDivision();
                    			            division = divisions.getDivisionType((div4!=null?input.toString(div4.start,div4.stop):null));
                    			        

                    }
                    break;
                case 2 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:56:12: special_div
                    {
                    pushFollow(FOLLOW_special_div_in_divided_field206);
                    special_div5=special_div();

                    state._fsp--;

                     
                    			            ShieldDivision divisions = new ShieldDivision();
                    			            division = divisions.getDivisionType(special_div5); 
                    			        

                    }
                    break;

            }

            pushFollow(FOLLOW_some_tinctures_in_divided_field241);
            some_tinctures6=some_tinctures(tinctures, division);

            state._fsp--;

             layer = some_tinctures6; 

            }

        }

            catch (MyRecognitionException re) {
                System.err.println("Caught MyRecognitionException:");
                System.err.println(re.message);
            } 
            catch (RecognitionException re) {
                reportError(re);
                recover(input,re);
            }
        finally {
        }
        return layer;
    }
    // $ANTLR end "divided_field"


    // $ANTLR start "plain_field"
    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:65:1: plain_field returns [ShieldLayer layer] : tincture[tinctures] ( 'plain' )? ;
    public final ShieldLayer plain_field() throws RecognitionException {
        ShieldLayer layer = null;

        Tincture tincture7 = null;


        try {
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:66:7: ( tincture[tinctures] ( 'plain' )? )
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:66:11: tincture[tinctures] ( 'plain' )?
            {
             Tinctures tinctures = new Tinctures(); 
            pushFollow(FOLLOW_tincture_in_plain_field291);
            tincture7=tincture(tinctures);

            state._fsp--;

            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:67:31: ( 'plain' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==16) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:67:32: 'plain'
                    {
                    match(input,16,FOLLOW_16_in_plain_field295); 

                    }
                    break;

            }


            		            tinctures.addTincture(tincture7);
            		            layer = ShieldLayer.build(tinctures);
            		        

            }

        }

            catch (MyRecognitionException re) {
                System.err.println("Caught MyRecognitionException:");
                System.err.println(re.message);
            } 
            catch (RecognitionException re) {
                reportError(re);
                recover(input,re);
            }
        finally {
        }
        return layer;
    }
    // $ANTLR end "plain_field"


    // $ANTLR start "some_tinctures"
    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:74:1: some_tinctures[Tinctures tinctures, ShieldDivisionType division] returns [ShieldLayer layer] : (t= tincture[tinctures] )* AND t= tincture[tinctures] ;
    public final ShieldLayer some_tinctures(Tinctures tinctures, ShieldDivisionType division) throws RecognitionException {
        ShieldLayer layer = null;

        Tincture t = null;


        try {
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:75:9: ( (t= tincture[tinctures] )* AND t= tincture[tinctures] )
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:75:13: (t= tincture[tinctures] )* AND t= tincture[tinctures]
            {
             int count = 0; 
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:76:13: (t= tincture[tinctures] )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>=COLOUR && LA4_0<=FUR)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:77:17: t= tincture[tinctures]
            	    {
            	    pushFollow(FOLLOW_tincture_in_some_tinctures380);
            	    t=tincture(tinctures);

            	    state._fsp--;

            	     tinctures.addTincture(t); count++; 

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            match(input,AND,FOLLOW_AND_in_some_tinctures429); 
            pushFollow(FOLLOW_tincture_in_some_tinctures447);
            t=tincture(tinctures);

            state._fsp--;


            		            count++;
            		            tinctures.addTincture(t);
            		            int allowableNumberOfTinctures = division.getNumberOfAllowableTinctures();
            		            if (allowableNumberOfTinctures != count) {
            		                throw new MyRecognitionException(
            		                    "Incorrect number of tinctures specified. The '" + division 
            		                    + "' division type only allows the following number of tinctures: "
            		                    + allowableNumberOfTinctures + " but found " + count);
            		            }
            		            layer = ShieldLayer.build(tinctures, division);
            		        

            }

        }

            catch (MyRecognitionException re) {
                System.err.println("Caught MyRecognitionException:");
                System.err.println(re.message);
            } 
            catch (RecognitionException re) {
                reportError(re);
                recover(input,re);
            }
        finally {
        }
        return layer;
    }
    // $ANTLR end "some_tinctures"

    public static class div_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "div"
    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:96:1: div : DIV ( MODIFIER )? ;
    public final BlazonParser.div_return div() throws RecognitionException {
        BlazonParser.div_return retval = new BlazonParser.div_return();
        retval.start = input.LT(1);

        try {
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:96:9: ( DIV ( MODIFIER )? )
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:96:13: DIV ( MODIFIER )?
            {
            match(input,DIV,FOLLOW_DIV_in_div485); 
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:96:17: ( MODIFIER )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==MODIFIER) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:96:17: MODIFIER
                    {
                    match(input,MODIFIER,FOLLOW_MODIFIER_in_div487); 

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

        }

            catch (MyRecognitionException re) {
                System.err.println("Caught MyRecognitionException:");
                System.err.println(re.message);
            } 
            catch (RecognitionException re) {
                reportError(re);
                recover(input,re);
            }
        finally {
        }
        return retval;
    }
    // $ANTLR end "div"


    // $ANTLR start "special_div"
    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:99:1: special_div returns [String text] : GYRONNY ( OF number_digits_or_words )? ;
    public final String special_div() throws RecognitionException {
        String text = null;

        Token GYRONNY8=null;
        Token OF9=null;
        BlazonParser.number_digits_or_words_return number_digits_or_words10 = null;


        try {
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:100:9: ( GYRONNY ( OF number_digits_or_words )? )
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:100:13: GYRONNY ( OF number_digits_or_words )?
            {
            GYRONNY8=(Token)match(input,GYRONNY,FOLLOW_GYRONNY_in_special_div519); 
             text = (GYRONNY8!=null?GYRONNY8.getText():null); 
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:101:13: ( OF number_digits_or_words )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==OF) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:102:17: OF number_digits_or_words
                    {
                    OF9=(Token)match(input,OF,FOLLOW_OF_in_special_div553); 
                     text += " " + (OF9!=null?OF9.getText():null); 
                    pushFollow(FOLLOW_number_digits_or_words_in_special_div573);
                    number_digits_or_words10=number_digits_or_words();

                    state._fsp--;


                                        try {
                                            int gyronnyOf = converter.convert((number_digits_or_words10!=null?input.toString(number_digits_or_words10.start,number_digits_or_words10.stop):null));
                                            if (gyronnyOf % 2 == 1) {
                                                gyronnyOf++;
                                                System.err.println("Parsing 'special_div', gyronny can only be of an"
                                                        + " even number; incremented number of sections to " + gyronnyOf);
                                            }
                                            text += " " + gyronnyOf;
                                        } catch (Exception e) {
                                        throw new MyRecognitionException("Unable to convert '" 
                                                + (number_digits_or_words10!=null?input.toString(number_digits_or_words10.start,number_digits_or_words10.stop):null) + "' into an integer.", e);
                                        }
                                    

                    }
                    break;

            }


            }

        }

            catch (MyRecognitionException re) {
                System.err.println("Caught MyRecognitionException:");
                System.err.println(re.message);
            } 
            catch (RecognitionException re) {
                reportError(re);
                recover(input,re);
            }
        finally {
        }
        return text;
    }
    // $ANTLR end "special_div"

    public static class number_digits_or_words_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "number_digits_or_words"
    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:121:1: number_digits_or_words : ( DIGITS | NUMWORDS ( ( AND )? NUMWORDS )* );
    public final BlazonParser.number_digits_or_words_return number_digits_or_words() throws RecognitionException {
        BlazonParser.number_digits_or_words_return retval = new BlazonParser.number_digits_or_words_return();
        retval.start = input.LT(1);

        try {
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:122:9: ( DIGITS | NUMWORDS ( ( AND )? NUMWORDS )* )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==DIGITS) ) {
                alt9=1;
            }
            else if ( (LA9_0==NUMWORDS) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:122:13: DIGITS
                    {
                    match(input,DIGITS,FOLLOW_DIGITS_in_number_digits_or_words633); 

                    }
                    break;
                case 2 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:123:13: NUMWORDS ( ( AND )? NUMWORDS )*
                    {
                    match(input,NUMWORDS,FOLLOW_NUMWORDS_in_number_digits_or_words647); 
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:123:22: ( ( AND )? NUMWORDS )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==AND) ) {
                            int LA8_2 = input.LA(2);

                            if ( (LA8_2==NUMWORDS) ) {
                                alt8=1;
                            }


                        }
                        else if ( (LA8_0==NUMWORDS) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:123:23: ( AND )? NUMWORDS
                    	    {
                    	    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:123:23: ( AND )?
                    	    int alt7=2;
                    	    int LA7_0 = input.LA(1);

                    	    if ( (LA7_0==AND) ) {
                    	        alt7=1;
                    	    }
                    	    switch (alt7) {
                    	        case 1 :
                    	            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:123:23: AND
                    	            {
                    	            match(input,AND,FOLLOW_AND_in_number_digits_or_words650); 

                    	            }
                    	            break;

                    	    }

                    	    match(input,NUMWORDS,FOLLOW_NUMWORDS_in_number_digits_or_words653); 

                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);


                    }
                    break;

            }
            retval.stop = input.LT(-1);

        }

            catch (MyRecognitionException re) {
                System.err.println("Caught MyRecognitionException:");
                System.err.println(re.message);
            } 
            catch (RecognitionException re) {
                reportError(re);
                recover(input,re);
            }
        finally {
        }
        return retval;
    }
    // $ANTLR end "number_digits_or_words"


    // $ANTLR start "tincture"
    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:126:1: tincture[Tinctures tinctures] returns [Tincture tincture] : ( COLOUR | METAL | FUR ) ;
    public final Tincture tincture(Tinctures tinctures) throws RecognitionException {
        Tincture tincture = null;

        Token COLOUR11=null;
        Token METAL12=null;
        Token FUR13=null;

        try {
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:127:9: ( ( COLOUR | METAL | FUR ) )
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:127:13: ( COLOUR | METAL | FUR )
            {
             String tinctureName = ""; 
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:128:9: ( COLOUR | METAL | FUR )
            int alt10=3;
            switch ( input.LA(1) ) {
            case COLOUR:
                {
                alt10=1;
                }
                break;
            case METAL:
                {
                alt10=2;
                }
                break;
            case FUR:
                {
                alt10=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:128:13: COLOUR
                    {
                    COLOUR11=(Token)match(input,COLOUR,FOLLOW_COLOUR_in_tincture705); 
                     tinctureName = (COLOUR11!=null?COLOUR11.getText():null); 

                    }
                    break;
                case 2 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:129:13: METAL
                    {
                    METAL12=(Token)match(input,METAL,FOLLOW_METAL_in_tincture721); 
                     tinctureName = (METAL12!=null?METAL12.getText():null); 

                    }
                    break;
                case 3 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:130:13: FUR
                    {
                    FUR13=(Token)match(input,FUR,FOLLOW_FUR_in_tincture738); 
                     tinctureName = (FUR13!=null?FUR13.getText():null); 

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

            catch (MyRecognitionException re) {
                System.err.println("Caught MyRecognitionException:");
                System.err.println(re.message);
            } 
            catch (RecognitionException re) {
                reportError(re);
                recover(input,re);
            }
        finally {
        }
        return tincture;
    }
    // $ANTLR end "tincture"

    // Delegated rules


 

    public static final BitSet FOLLOW_field_in_shield64 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_plain_field_in_field93 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_divided_field_in_field107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARTYPER_in_divided_field169 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_div_in_divided_field182 = new BitSet(new long[]{0x0000000000007020L});
    public static final BitSet FOLLOW_special_div_in_divided_field206 = new BitSet(new long[]{0x0000000000007020L});
    public static final BitSet FOLLOW_some_tinctures_in_divided_field241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tincture_in_plain_field291 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_plain_field295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tincture_in_some_tinctures380 = new BitSet(new long[]{0x0000000000007020L});
    public static final BitSet FOLLOW_AND_in_some_tinctures429 = new BitSet(new long[]{0x0000000000007000L});
    public static final BitSet FOLLOW_tincture_in_some_tinctures447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DIV_in_div485 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_MODIFIER_in_div487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GYRONNY_in_special_div519 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_OF_in_special_div553 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_number_digits_or_words_in_special_div573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DIGITS_in_number_digits_or_words633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMWORDS_in_number_digits_or_words647 = new BitSet(new long[]{0x0000000000000822L});
    public static final BitSet FOLLOW_AND_in_number_digits_or_words650 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NUMWORDS_in_number_digits_or_words653 = new BitSet(new long[]{0x0000000000000822L});
    public static final BitSet FOLLOW_COLOUR_in_tincture705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_METAL_in_tincture721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUR_in_tincture738 = new BitSet(new long[]{0x0000000000000002L});

}