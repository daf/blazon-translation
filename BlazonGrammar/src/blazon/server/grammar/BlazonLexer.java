// $ANTLR 3.3 Nov 30, 2010 12:50:56 C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g 2011-07-07 13:15:50

  package blazon.server.grammar;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class BlazonLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__8=8;
    public static final int COLOUR=4;
    public static final int METAL=5;
    public static final int FUR=6;
    public static final int WS=7;

    // delegates
    // delegators

    public BlazonLexer() {;} 
    public BlazonLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public BlazonLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g"; }

    // $ANTLR start "T__8"
    public final void mT__8() throws RecognitionException {
        try {
            int _type = T__8;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:11:6: ( 'plain' )
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:11:8: 'plain'
            {
            match("plain"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__8"

    // $ANTLR start "COLOUR"
    public final void mCOLOUR() throws RecognitionException {
        try {
            int _type = COLOUR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:39:9: ( 'azure' | 'gules' | 'vert' | 'sable' | 'purpure' )
            int alt1=5;
            switch ( input.LA(1) ) {
            case 'a':
                {
                alt1=1;
                }
                break;
            case 'g':
                {
                alt1=2;
                }
                break;
            case 'v':
                {
                alt1=3;
                }
                break;
            case 's':
                {
                alt1=4;
                }
                break;
            case 'p':
                {
                alt1=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:39:13: 'azure'
                    {
                    match("azure"); 


                    }
                    break;
                case 2 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:39:23: 'gules'
                    {
                    match("gules"); 


                    }
                    break;
                case 3 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:39:33: 'vert'
                    {
                    match("vert"); 


                    }
                    break;
                case 4 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:39:42: 'sable'
                    {
                    match("sable"); 


                    }
                    break;
                case 5 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:39:52: 'purpure'
                    {
                    match("purpure"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COLOUR"

    // $ANTLR start "METAL"
    public final void mMETAL() throws RecognitionException {
        try {
            int _type = METAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:42:9: ( 'or' | 'argent' )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='o') ) {
                alt2=1;
            }
            else if ( (LA2_0=='a') ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:42:13: 'or'
                    {
                    match("or"); 


                    }
                    break;
                case 2 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:42:20: 'argent'
                    {
                    match("argent"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "METAL"

    // $ANTLR start "FUR"
    public final void mFUR() throws RecognitionException {
        try {
            int _type = FUR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:46:5: ( 'ermine' | 'ermines' | 'erminois' | 'pean' | 'vair' | 'counter-vair' | 'vair-en-pale' | 'vair-en-point' | 'potent' | 'counter-potent' | 'potent-en-pale' | 'potent-en-point' )
            int alt3=12;
            alt3 = dfa3.predict(input);
            switch (alt3) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:46:9: 'ermine'
                    {
                    match("ermine"); 


                    }
                    break;
                case 2 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:46:20: 'ermines'
                    {
                    match("ermines"); 


                    }
                    break;
                case 3 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:46:32: 'erminois'
                    {
                    match("erminois"); 


                    }
                    break;
                case 4 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:46:45: 'pean'
                    {
                    match("pean"); 


                    }
                    break;
                case 5 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:47:10: 'vair'
                    {
                    match("vair"); 


                    }
                    break;
                case 6 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:47:19: 'counter-vair'
                    {
                    match("counter-vair"); 


                    }
                    break;
                case 7 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:47:36: 'vair-en-pale'
                    {
                    match("vair-en-pale"); 


                    }
                    break;
                case 8 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:47:53: 'vair-en-point'
                    {
                    match("vair-en-point"); 


                    }
                    break;
                case 9 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:48:10: 'potent'
                    {
                    match("potent"); 


                    }
                    break;
                case 10 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:48:21: 'counter-potent'
                    {
                    match("counter-potent"); 


                    }
                    break;
                case 11 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:48:40: 'potent-en-pale'
                    {
                    match("potent-en-pale"); 


                    }
                    break;
                case 12 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:48:59: 'potent-en-point'
                    {
                    match("potent-en-point"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FUR"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:51:5: ( ( ' ' | '\\t' )+ )
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:51:9: ( ' ' | '\\t' )+
            {
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:51:9: ( ' ' | '\\t' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='\t'||LA4_0==' ') ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:
            	    {
            	    if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


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

            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    public void mTokens() throws RecognitionException {
        // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:1:8: ( T__8 | COLOUR | METAL | FUR | WS )
        int alt5=5;
        switch ( input.LA(1) ) {
        case 'p':
            {
            switch ( input.LA(2) ) {
            case 'l':
                {
                alt5=1;
                }
                break;
            case 'u':
                {
                alt5=2;
                }
                break;
            case 'e':
            case 'o':
                {
                alt5=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 1, input);

                throw nvae;
            }

            }
            break;
        case 'a':
            {
            int LA5_2 = input.LA(2);

            if ( (LA5_2=='z') ) {
                alt5=2;
            }
            else if ( (LA5_2=='r') ) {
                alt5=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 2, input);

                throw nvae;
            }
            }
            break;
        case 'g':
        case 's':
            {
            alt5=2;
            }
            break;
        case 'v':
            {
            int LA5_4 = input.LA(2);

            if ( (LA5_4=='e') ) {
                alt5=2;
            }
            else if ( (LA5_4=='a') ) {
                alt5=4;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 4, input);

                throw nvae;
            }
            }
            break;
        case 'o':
            {
            alt5=3;
            }
            break;
        case 'c':
        case 'e':
            {
            alt5=4;
            }
            break;
        case '\t':
        case ' ':
            {
            alt5=5;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 5, 0, input);

            throw nvae;
        }

        switch (alt5) {
            case 1 :
                // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:1:10: T__8
                {
                mT__8(); 

                }
                break;
            case 2 :
                // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:1:15: COLOUR
                {
                mCOLOUR(); 

                }
                break;
            case 3 :
                // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:1:22: METAL
                {
                mMETAL(); 

                }
                break;
            case 4 :
                // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:1:28: FUR
                {
                mFUR(); 

                }
                break;
            case 5 :
                // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:1:32: WS
                {
                mWS(); 

                }
                break;

        }

    }


    protected DFA3 dfa3 = new DFA3(this);
    static final String DFA3_eotS =
        "\20\uffff\1\25\6\uffff\1\35\1\uffff\1\37\25\uffff";
    static final String DFA3_eofS =
        "\57\uffff";
    static final String DFA3_minS =
        "\1\143\1\162\1\145\1\141\1\157\1\155\1\uffff\1\164\1\151\1\165"+
        "\1\151\1\145\1\162\3\156\1\55\1\164\1\145\1\164\1\145\1\uffff\1"+
        "\145\1\163\1\uffff\1\55\1\156\1\162\2\uffff\1\145\1\uffff\2\55\1"+
        "\156\2\160\1\55\1\141\2\uffff\1\160\2\uffff\1\141\2\uffff";
    static final String DFA3_maxS =
        "\1\166\1\162\1\157\1\141\1\157\1\155\1\uffff\1\164\1\151\1\165"+
        "\1\151\1\145\1\162\3\156\1\55\1\164\1\157\1\164\1\145\1\uffff\1"+
        "\145\1\163\1\uffff\1\55\1\156\1\162\2\uffff\1\145\1\uffff\2\55\1"+
        "\156\1\160\1\166\1\55\1\157\2\uffff\1\160\2\uffff\1\157\2\uffff";
    static final String DFA3_acceptS =
        "\6\uffff\1\4\16\uffff\1\5\2\uffff\1\3\3\uffff\1\2\1\1\1\uffff\1"+
        "\11\7\uffff\1\6\1\12\1\uffff\1\7\1\10\1\uffff\1\13\1\14";
    static final String DFA3_specialS =
        "\57\uffff}>";
    static final String[] DFA3_transitionS = {
            "\1\4\1\uffff\1\1\12\uffff\1\2\5\uffff\1\3",
            "\1\5",
            "\1\6\11\uffff\1\7",
            "\1\10",
            "\1\11",
            "\1\12",
            "",
            "\1\13",
            "\1\14",
            "\1\15",
            "\1\16",
            "\1\17",
            "\1\20",
            "\1\21",
            "\1\22",
            "\1\23",
            "\1\24",
            "\1\26",
            "\1\27\11\uffff\1\30",
            "\1\31",
            "\1\32",
            "",
            "\1\33",
            "\1\34",
            "",
            "\1\36",
            "\1\40",
            "\1\41",
            "",
            "",
            "\1\42",
            "",
            "\1\43",
            "\1\44",
            "\1\45",
            "\1\46",
            "\1\50\5\uffff\1\47",
            "\1\51",
            "\1\52\15\uffff\1\53",
            "",
            "",
            "\1\54",
            "",
            "",
            "\1\55\15\uffff\1\56",
            "",
            ""
    };

    static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
    static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
    static final char[] DFA3_min = DFA.unpackEncodedStringToUnsignedChars(DFA3_minS);
    static final char[] DFA3_max = DFA.unpackEncodedStringToUnsignedChars(DFA3_maxS);
    static final short[] DFA3_accept = DFA.unpackEncodedString(DFA3_acceptS);
    static final short[] DFA3_special = DFA.unpackEncodedString(DFA3_specialS);
    static final short[][] DFA3_transition;

    static {
        int numStates = DFA3_transitionS.length;
        DFA3_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA3_transition[i] = DFA.unpackEncodedString(DFA3_transitionS[i]);
        }
    }

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = DFA3_eot;
            this.eof = DFA3_eof;
            this.min = DFA3_min;
            this.max = DFA3_max;
            this.accept = DFA3_accept;
            this.special = DFA3_special;
            this.transition = DFA3_transition;
        }
        public String getDescription() {
            return "46:1: FUR : ( 'ermine' | 'ermines' | 'erminois' | 'pean' | 'vair' | 'counter-vair' | 'vair-en-pale' | 'vair-en-point' | 'potent' | 'counter-potent' | 'potent-en-pale' | 'potent-en-point' );";
        }
    }
 

}