// $ANTLR 3.3 Nov 30, 2010 12:50:56 C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g 2011-07-07 13:15:49

  package blazon.server.grammar;
  import blazon.shared.shield.Shield;
  import blazon.shared.shield.ShieldLayer;
  import blazon.shared.shield.tinctures.Tinctures;
  import blazon.shared.shield.tinctures.Tincture;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class BlazonParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "COLOUR", "METAL", "FUR", "WS", "'plain'"
    };
    public static final int EOF=-1;
    public static final int T__8=8;
    public static final int COLOUR=4;
    public static final int METAL=5;
    public static final int FUR=6;
    public static final int WS=7;

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



    // $ANTLR start "shield"
    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:19:1: shield returns [Shield s] : field ;
    public final Shield shield() throws RecognitionException {
        Shield s = null;

        ShieldLayer field1 = null;


        try {
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:20:5: ( field )
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:20:9: field
            {
            pushFollow(FOLLOW_field_in_shield49);
            field1=field();

            state._fsp--;


                        s = Shield.build(field1);        

            }

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
    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:25:1: field returns [ShieldLayer layer] : tincture[tinctures] ( 'plain' )? ;
    public final ShieldLayer field() throws RecognitionException {
        ShieldLayer layer = null;

        Tincture tincture2 = null;


        try {
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:26:5: ( tincture[tinctures] ( 'plain' )? )
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:26:9: tincture[tinctures] ( 'plain' )?
            {
             Tinctures tinctures = new Tinctures(); 
            pushFollow(FOLLOW_tincture_in_field85);
            tincture2=tincture(tinctures);

            state._fsp--;

            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:27:29: ( 'plain' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==8) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:27:29: 'plain'
                    {
                    match(input,8,FOLLOW_8_in_field88); 

                    }
                    break;

            }


                        tinctures.addTincture(tincture2);
                        layer = ShieldLayer.build(tinctures);
                    

            }

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


    // $ANTLR start "tincture"
    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:33:1: tincture[Tinctures tinctures] returns [Tincture tincture] : ( COLOUR | METAL | FUR );
    public final Tincture tincture(Tinctures tinctures) throws RecognitionException {
        Tincture tincture = null;

        Token COLOUR3=null;
        Token METAL4=null;
        Token FUR5=null;

        try {
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:34:5: ( COLOUR | METAL | FUR )
            int alt2=3;
            switch ( input.LA(1) ) {
            case COLOUR:
                {
                alt2=1;
                }
                break;
            case METAL:
                {
                alt2=2;
                }
                break;
            case FUR:
                {
                alt2=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:34:7: COLOUR
                    {
                    COLOUR3=(Token)match(input,COLOUR,FOLLOW_COLOUR_in_tincture118); 
                    tincture = tinctures.createTincture((COLOUR3!=null?COLOUR3.getText():null));

                    }
                    break;
                case 2 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:35:7: METAL
                    {
                    METAL4=(Token)match(input,METAL,FOLLOW_METAL_in_tincture128); 
                    tincture = tinctures.createTincture((METAL4!=null?METAL4.getText():null));

                    }
                    break;
                case 3 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:36:7: FUR
                    {
                    FUR5=(Token)match(input,FUR,FOLLOW_FUR_in_tincture138); 
                    tincture = tinctures.createTincture((FUR5!=null?FUR5.getText():null));

                    }
                    break;

            }
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


 

    public static final BitSet FOLLOW_field_in_shield49 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tincture_in_field85 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_8_in_field88 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COLOUR_in_tincture118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_METAL_in_tincture128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUR_in_tincture138 = new BitSet(new long[]{0x0000000000000002L});

}