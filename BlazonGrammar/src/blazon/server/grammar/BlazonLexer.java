// $ANTLR 3.3 Nov 30, 2010 12:50:56 /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g 2011-09-09 16:45:05

package blazon.server.grammar;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class BlazonLexer extends Lexer {
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

    public BlazonLexer() {;} 
    public BlazonLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public BlazonLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "/Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g"; }

    // $ANTLR start "DIV_MODIFIER"
    public final void mDIV_MODIFIER() throws RecognitionException {
        try {
            int _type = DIV_MODIFIER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:164:9: ( 'reversed' | 'sinister' )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='r') ) {
                alt1=1;
            }
            else if ( (LA1_0=='s') ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:164:13: 'reversed'
                    {
                    match("reversed"); 


                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:164:26: 'sinister'
                    {
                    match("sinister"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DIV_MODIFIER"

    // $ANTLR start "TIERCED"
    public final void mTIERCED() throws RecognitionException {
        try {
            int _type = TIERCED;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:168:9: ( 'tierced' )
            // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:168:13: 'tierced'
            {
            match("tierced"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TIERCED"

    // $ANTLR start "DIV"
    public final void mDIV() throws RecognitionException {
        try {
            int _type = DIV;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:171:9: ( 'fess' | 'pale' | 'bend' | 'cross' | 'saltire' | 'chevron' | 'pall' | 'pairle' )
            int alt2=8;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:171:13: 'fess'
                    {
                    match("fess"); 


                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:171:22: 'pale'
                    {
                    match("pale"); 


                    }
                    break;
                case 3 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:171:31: 'bend'
                    {
                    match("bend"); 


                    }
                    break;
                case 4 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:171:40: 'cross'
                    {
                    match("cross"); 


                    }
                    break;
                case 5 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:171:50: 'saltire'
                    {
                    match("saltire"); 


                    }
                    break;
                case 6 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:171:62: 'chevron'
                    {
                    match("chevron"); 


                    }
                    break;
                case 7 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:171:74: 'pall'
                    {
                    match("pall"); 


                    }
                    break;
                case 8 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:171:83: 'pairle'
                    {
                    match("pairle"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DIV"

    // $ANTLR start "VARIABLE_DIV"
    public final void mVARIABLE_DIV() throws RecognitionException {
        try {
            int _type = VARIABLE_DIV;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:175:9: ( 'gyronny' | 'barry' | 'paly' | 'bendy' | 'chevronny' )
            int alt3=5;
            switch ( input.LA(1) ) {
            case 'g':
                {
                alt3=1;
                }
                break;
            case 'b':
                {
                int LA3_2 = input.LA(2);

                if ( (LA3_2=='a') ) {
                    alt3=2;
                }
                else if ( (LA3_2=='e') ) {
                    alt3=4;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 2, input);

                    throw nvae;
                }
                }
                break;
            case 'p':
                {
                alt3=3;
                }
                break;
            case 'c':
                {
                alt3=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:175:13: 'gyronny'
                    {
                    match("gyronny"); 


                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:175:25: 'barry'
                    {
                    match("barry"); 


                    }
                    break;
                case 3 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:175:35: 'paly'
                    {
                    match("paly"); 


                    }
                    break;
                case 4 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:175:44: 'bendy'
                    {
                    match("bendy"); 


                    }
                    break;
                case 5 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:175:54: 'chevronny'
                    {
                    match("chevronny"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VARIABLE_DIV"

    // $ANTLR start "CONTINUOUS_DIV"
    public final void mCONTINUOUS_DIV() throws RecognitionException {
        try {
            int _type = CONTINUOUS_DIV;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:179:9: ( 'chequy' | 'lozengy' )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='c') ) {
                alt4=1;
            }
            else if ( (LA4_0=='l') ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:179:13: 'chequy'
                    {
                    match("chequy"); 


                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:179:24: 'lozengy'
                    {
                    match("lozengy"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CONTINUOUS_DIV"

    // $ANTLR start "QUARTER"
    public final void mQUARTER() throws RecognitionException {
        try {
            int _type = QUARTER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:182:9: ( 'quarter' ( 'ed' | 'ly' ) )
            // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:182:13: 'quarter' ( 'ed' | 'ly' )
            {
            match("quarter"); 

            // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:182:22: ( 'ed' | 'ly' )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='e') ) {
                alt5=1;
            }
            else if ( (LA5_0=='l') ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:182:23: 'ed'
                    {
                    match("ed"); 


                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:182:28: 'ly'
                    {
                    match("ly"); 


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "QUARTER"

    // $ANTLR start "PARTYPER"
    public final void mPARTYPER() throws RecognitionException {
        try {
            int _type = PARTYPER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:186:9: ( ( 'part' ( 'ed' | 'y' ) ' ' )? 'per' )
            // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:186:13: ( 'part' ( 'ed' | 'y' ) ' ' )? 'per'
            {
            // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:186:13: ( 'part' ( 'ed' | 'y' ) ' ' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='p') ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1=='a') ) {
                    alt7=1;
                }
            }
            switch (alt7) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:186:14: 'part' ( 'ed' | 'y' ) ' '
                    {
                    match("part"); 

                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:186:20: ( 'ed' | 'y' )
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0=='e') ) {
                        alt6=1;
                    }
                    else if ( (LA6_0=='y') ) {
                        alt6=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 0, input);

                        throw nvae;
                    }
                    switch (alt6) {
                        case 1 :
                            // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:186:21: 'ed'
                            {
                            match("ed"); 


                            }
                            break;
                        case 2 :
                            // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:186:26: 'y'
                            {
                            match('y'); 

                            }
                            break;

                    }

                    match(' '); 

                    }
                    break;

            }

            match("per"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PARTYPER"

    // $ANTLR start "COLOUR"
    public final void mCOLOUR() throws RecognitionException {
        try {
            int _type = COLOUR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:189:9: ( 'azure' | 'gules' | 'vert' | 'sable' | 'purpure' )
            int alt8=5;
            switch ( input.LA(1) ) {
            case 'a':
                {
                alt8=1;
                }
                break;
            case 'g':
                {
                alt8=2;
                }
                break;
            case 'v':
                {
                alt8=3;
                }
                break;
            case 's':
                {
                alt8=4;
                }
                break;
            case 'p':
                {
                alt8=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:189:13: 'azure'
                    {
                    match("azure"); 


                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:189:23: 'gules'
                    {
                    match("gules"); 


                    }
                    break;
                case 3 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:189:33: 'vert'
                    {
                    match("vert"); 


                    }
                    break;
                case 4 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:189:42: 'sable'
                    {
                    match("sable"); 


                    }
                    break;
                case 5 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:189:52: 'purpure'
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
            // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:192:9: ( 'or' | 'argent' )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='o') ) {
                alt9=1;
            }
            else if ( (LA9_0=='a') ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:192:13: 'or'
                    {
                    match("or"); 


                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:192:20: 'argent'
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
            // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:195:9: ( 'ermine' | 'ermines' | 'erminois' | 'pean' | 'vair' | 'counter-vair' | 'vair-en-pale' | 'vair-en-point' | 'potent' | 'counter-potent' | 'potent-en-pale' | 'potent-en-point' )
            int alt10=12;
            alt10 = dfa10.predict(input);
            switch (alt10) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:195:13: 'ermine'
                    {
                    match("ermine"); 


                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:195:24: 'ermines'
                    {
                    match("ermines"); 


                    }
                    break;
                case 3 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:195:36: 'erminois'
                    {
                    match("erminois"); 


                    }
                    break;
                case 4 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:195:49: 'pean'
                    {
                    match("pean"); 


                    }
                    break;
                case 5 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:196:13: 'vair'
                    {
                    match("vair"); 


                    }
                    break;
                case 6 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:196:22: 'counter-vair'
                    {
                    match("counter-vair"); 


                    }
                    break;
                case 7 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:196:39: 'vair-en-pale'
                    {
                    match("vair-en-pale"); 


                    }
                    break;
                case 8 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:196:56: 'vair-en-point'
                    {
                    match("vair-en-point"); 


                    }
                    break;
                case 9 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:197:13: 'potent'
                    {
                    match("potent"); 


                    }
                    break;
                case 10 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:197:24: 'counter-potent'
                    {
                    match("counter-potent"); 


                    }
                    break;
                case 11 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:197:43: 'potent-en-pale'
                    {
                    match("potent-en-pale"); 


                    }
                    break;
                case 12 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:197:62: 'potent-en-point'
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

    // $ANTLR start "DIGITS"
    public final void mDIGITS() throws RecognitionException {
        try {
            int _type = DIGITS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:200:9: ( ( '0' .. '9' )+ )
            // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:200:13: ( '0' .. '9' )+
            {
            // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:200:13: ( '0' .. '9' )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='0' && LA11_0<='9')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:200:14: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DIGITS"

    // $ANTLR start "AND"
    public final void mAND() throws RecognitionException {
        try {
            int _type = AND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:203:9: ( 'and' )
            // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:203:13: 'and'
            {
            match("and"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AND"

    // $ANTLR start "OF"
    public final void mOF() throws RecognitionException {
        try {
            int _type = OF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:206:9: ( 'of' )
            // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:206:13: 'of'
            {
            match("of"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OF"

    // $ANTLR start "PLAIN"
    public final void mPLAIN() throws RecognitionException {
        try {
            int _type = PLAIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:209:9: ( 'plain' )
            // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:209:13: 'plain'
            {
            match("plain"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PLAIN"

    // $ANTLR start "NUMWORDS"
    public final void mNUMWORDS() throws RecognitionException {
        try {
            int _type = NUMWORDS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:213:9: ( 'one' | 'eleven' | 'two' | 'twelve' | 'three' | 'thirteen' | 'four' ( 'teen' )? | 'five' | 'fifteen' | 'six' ( 'teen' )? | 'seven' ( 'teen' )? | 'eight' ( 'een' )? | 'nine' ( 'teen' )? | 'twenty' | 'thirty' | 'fourty' | 'fifty' | 'sixty' | 'seventy' | 'eighty' | 'ninety' | 'hundred' | 'thousand' | 'million' | 'billion' )
            int alt17=25;
            alt17 = dfa17.predict(input);
            switch (alt17) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:213:13: 'one'
                    {
                    match("one"); 


                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:213:21: 'eleven'
                    {
                    match("eleven"); 


                    }
                    break;
                case 3 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:213:32: 'two'
                    {
                    match("two"); 


                    }
                    break;
                case 4 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:213:40: 'twelve'
                    {
                    match("twelve"); 


                    }
                    break;
                case 5 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:213:51: 'three'
                    {
                    match("three"); 


                    }
                    break;
                case 6 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:213:61: 'thirteen'
                    {
                    match("thirteen"); 


                    }
                    break;
                case 7 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:214:13: 'four' ( 'teen' )?
                    {
                    match("four"); 

                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:214:19: ( 'teen' )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0=='t') ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:214:19: 'teen'
                            {
                            match("teen"); 


                            }
                            break;

                    }


                    }
                    break;
                case 8 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:214:29: 'five'
                    {
                    match("five"); 


                    }
                    break;
                case 9 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:214:38: 'fifteen'
                    {
                    match("fifteen"); 


                    }
                    break;
                case 10 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:214:50: 'six' ( 'teen' )?
                    {
                    match("six"); 

                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:214:55: ( 'teen' )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0=='t') ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:214:55: 'teen'
                            {
                            match("teen"); 


                            }
                            break;

                    }


                    }
                    break;
                case 11 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:214:65: 'seven' ( 'teen' )?
                    {
                    match("seven"); 

                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:214:72: ( 'teen' )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0=='t') ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:214:72: 'teen'
                            {
                            match("teen"); 


                            }
                            break;

                    }


                    }
                    break;
                case 12 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:215:13: 'eight' ( 'een' )?
                    {
                    match("eight"); 

                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:215:20: ( 'een' )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0=='e') ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:215:20: 'een'
                            {
                            match("een"); 


                            }
                            break;

                    }


                    }
                    break;
                case 13 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:215:29: 'nine' ( 'teen' )?
                    {
                    match("nine"); 

                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:215:35: ( 'teen' )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0=='t') ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:215:35: 'teen'
                            {
                            match("teen"); 


                            }
                            break;

                    }


                    }
                    break;
                case 14 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:215:45: 'twenty'
                    {
                    match("twenty"); 


                    }
                    break;
                case 15 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:215:56: 'thirty'
                    {
                    match("thirty"); 


                    }
                    break;
                case 16 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:215:67: 'fourty'
                    {
                    match("fourty"); 


                    }
                    break;
                case 17 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:216:13: 'fifty'
                    {
                    match("fifty"); 


                    }
                    break;
                case 18 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:216:23: 'sixty'
                    {
                    match("sixty"); 


                    }
                    break;
                case 19 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:216:33: 'seventy'
                    {
                    match("seventy"); 


                    }
                    break;
                case 20 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:216:45: 'eighty'
                    {
                    match("eighty"); 


                    }
                    break;
                case 21 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:216:56: 'ninety'
                    {
                    match("ninety"); 


                    }
                    break;
                case 22 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:216:67: 'hundred'
                    {
                    match("hundred"); 


                    }
                    break;
                case 23 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:217:13: 'thousand'
                    {
                    match("thousand"); 


                    }
                    break;
                case 24 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:217:26: 'million'
                    {
                    match("million"); 


                    }
                    break;
                case 25 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:217:38: 'billion'
                    {
                    match("billion"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NUMWORDS"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:220:9: ( ( ' ' | '\\t' )+ )
            // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:220:13: ( ' ' | '\\t' )+
            {
            // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:220:13: ( ' ' | '\\t' )+
            int cnt18=0;
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0=='\t'||LA18_0==' ') ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:
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
            	    if ( cnt18 >= 1 ) break loop18;
                        EarlyExitException eee =
                            new EarlyExitException(18, input);
                        throw eee;
                }
                cnt18++;
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
        // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:1:8: ( DIV_MODIFIER | TIERCED | DIV | VARIABLE_DIV | CONTINUOUS_DIV | QUARTER | PARTYPER | COLOUR | METAL | FUR | DIGITS | AND | OF | PLAIN | NUMWORDS | WS )
        int alt19=16;
        alt19 = dfa19.predict(input);
        switch (alt19) {
            case 1 :
                // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:1:10: DIV_MODIFIER
                {
                mDIV_MODIFIER(); 

                }
                break;
            case 2 :
                // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:1:23: TIERCED
                {
                mTIERCED(); 

                }
                break;
            case 3 :
                // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:1:31: DIV
                {
                mDIV(); 

                }
                break;
            case 4 :
                // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:1:35: VARIABLE_DIV
                {
                mVARIABLE_DIV(); 

                }
                break;
            case 5 :
                // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:1:48: CONTINUOUS_DIV
                {
                mCONTINUOUS_DIV(); 

                }
                break;
            case 6 :
                // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:1:63: QUARTER
                {
                mQUARTER(); 

                }
                break;
            case 7 :
                // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:1:71: PARTYPER
                {
                mPARTYPER(); 

                }
                break;
            case 8 :
                // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:1:80: COLOUR
                {
                mCOLOUR(); 

                }
                break;
            case 9 :
                // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:1:87: METAL
                {
                mMETAL(); 

                }
                break;
            case 10 :
                // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:1:93: FUR
                {
                mFUR(); 

                }
                break;
            case 11 :
                // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:1:97: DIGITS
                {
                mDIGITS(); 

                }
                break;
            case 12 :
                // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:1:104: AND
                {
                mAND(); 

                }
                break;
            case 13 :
                // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:1:108: OF
                {
                mOF(); 

                }
                break;
            case 14 :
                // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:1:111: PLAIN
                {
                mPLAIN(); 

                }
                break;
            case 15 :
                // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:1:117: NUMWORDS
                {
                mNUMWORDS(); 

                }
                break;
            case 16 :
                // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:1:126: WS
                {
                mWS(); 

                }
                break;

        }

    }


    protected DFA2 dfa2 = new DFA2(this);
    protected DFA10 dfa10 = new DFA10(this);
    protected DFA17 dfa17 = new DFA17(this);
    protected DFA19 dfa19 = new DFA19(this);
    static final String DFA2_eotS =
        "\15\uffff";
    static final String DFA2_eofS =
        "\15\uffff";
    static final String DFA2_minS =
        "\1\142\1\uffff\1\141\1\uffff\1\150\1\uffff\1\151\2\uffff\1\145\3"+
        "\uffff";
    static final String DFA2_maxS =
        "\1\163\1\uffff\1\141\1\uffff\1\162\1\uffff\1\154\2\uffff\1\154\3"+
        "\uffff";
    static final String DFA2_acceptS =
        "\1\uffff\1\1\1\uffff\1\3\1\uffff\1\5\1\uffff\1\4\1\6\1\uffff\1\10"+
        "\1\2\1\7";
    static final String DFA2_specialS =
        "\15\uffff}>";
    static final String[] DFA2_transitionS = {
            "\1\3\1\4\2\uffff\1\1\11\uffff\1\2\2\uffff\1\5",
            "",
            "\1\6",
            "",
            "\1\10\11\uffff\1\7",
            "",
            "\1\12\2\uffff\1\11",
            "",
            "",
            "\1\13\6\uffff\1\14",
            "",
            "",
            ""
    };

    static final short[] DFA2_eot = DFA.unpackEncodedString(DFA2_eotS);
    static final short[] DFA2_eof = DFA.unpackEncodedString(DFA2_eofS);
    static final char[] DFA2_min = DFA.unpackEncodedStringToUnsignedChars(DFA2_minS);
    static final char[] DFA2_max = DFA.unpackEncodedStringToUnsignedChars(DFA2_maxS);
    static final short[] DFA2_accept = DFA.unpackEncodedString(DFA2_acceptS);
    static final short[] DFA2_special = DFA.unpackEncodedString(DFA2_specialS);
    static final short[][] DFA2_transition;

    static {
        int numStates = DFA2_transitionS.length;
        DFA2_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA2_transition[i] = DFA.unpackEncodedString(DFA2_transitionS[i]);
        }
    }

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = DFA2_eot;
            this.eof = DFA2_eof;
            this.min = DFA2_min;
            this.max = DFA2_max;
            this.accept = DFA2_accept;
            this.special = DFA2_special;
            this.transition = DFA2_transition;
        }
        public String getDescription() {
            return "171:1: DIV : ( 'fess' | 'pale' | 'bend' | 'cross' | 'saltire' | 'chevron' | 'pall' | 'pairle' );";
        }
    }
    static final String DFA10_eotS =
        "\20\uffff\1\25\6\uffff\1\35\1\uffff\1\37\25\uffff";
    static final String DFA10_eofS =
        "\57\uffff";
    static final String DFA10_minS =
        "\1\143\1\162\1\145\1\141\1\157\1\155\1\uffff\1\164\1\151\1\165\1"+
        "\151\1\145\1\162\3\156\1\55\1\164\1\145\1\164\1\145\1\uffff\1\145"+
        "\1\163\1\uffff\1\55\1\156\1\162\2\uffff\1\145\1\uffff\2\55\1\156"+
        "\2\160\1\55\1\141\2\uffff\1\160\2\uffff\1\141\2\uffff";
    static final String DFA10_maxS =
        "\1\166\1\162\1\157\1\141\1\157\1\155\1\uffff\1\164\1\151\1\165\1"+
        "\151\1\145\1\162\3\156\1\55\1\164\1\157\1\164\1\145\1\uffff\1\145"+
        "\1\163\1\uffff\1\55\1\156\1\162\2\uffff\1\145\1\uffff\2\55\1\156"+
        "\1\160\1\166\1\55\1\157\2\uffff\1\160\2\uffff\1\157\2\uffff";
    static final String DFA10_acceptS =
        "\6\uffff\1\4\16\uffff\1\5\2\uffff\1\3\3\uffff\1\2\1\1\1\uffff\1"+
        "\11\7\uffff\1\6\1\12\1\uffff\1\7\1\10\1\uffff\1\13\1\14";
    static final String DFA10_specialS =
        "\57\uffff}>";
    static final String[] DFA10_transitionS = {
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

    static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
    static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
    static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
    static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
    static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
    static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
    static final short[][] DFA10_transition;

    static {
        int numStates = DFA10_transitionS.length;
        DFA10_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = DFA10_eot;
            this.eof = DFA10_eof;
            this.min = DFA10_min;
            this.max = DFA10_max;
            this.accept = DFA10_accept;
            this.special = DFA10_special;
            this.transition = DFA10_transition;
        }
        public String getDescription() {
            return "195:1: FUR : ( 'ermine' | 'ermines' | 'erminois' | 'pean' | 'vair' | 'counter-vair' | 'vair-en-pale' | 'vair-en-point' | 'potent' | 'counter-potent' | 'potent-en-pale' | 'potent-en-point' );";
        }
    }
    static final String DFA17_eotS =
        "\34\uffff\1\46\6\uffff\1\54\4\uffff\1\62\1\64\6\uffff\1\71\13\uffff";
    static final String DFA17_eofS =
        "\74\uffff";
    static final String DFA17_minS =
        "\1\142\1\uffff\1\151\1\150\1\151\1\145\1\151\4\uffff\1\147\1\145"+
        "\1\151\1\165\1\146\1\170\1\166\1\156\1\150\1\uffff\1\154\1\uffff"+
        "\1\162\1\uffff\1\162\1\uffff\2\164\2\145\1\164\2\uffff\2\164\2\145"+
        "\1\uffff\1\156\1\164\1\171\2\145\4\uffff\1\164\1\145\6\uffff\1\145"+
        "\3\uffff";
    static final String DFA17_maxS =
        "\1\164\1\uffff\1\154\1\167\1\157\2\151\4\uffff\1\147\1\157\1\162"+
        "\1\165\1\166\1\170\1\166\1\156\1\150\1\uffff\1\156\1\uffff\1\162"+
        "\1\uffff\1\162\1\uffff\2\164\2\145\1\164\2\uffff\2\164\2\171\1\uffff"+
        "\1\156\1\164\3\171\4\uffff\1\164\1\171\6\uffff\1\171\3\uffff";
    static final String DFA17_acceptS =
        "\1\uffff\1\1\5\uffff\1\26\1\30\1\31\1\2\11\uffff\1\3\1\uffff\1\5"+
        "\1\uffff\1\27\1\uffff\1\10\5\uffff\1\4\1\16\4\uffff\1\12\5\uffff"+
        "\1\7\1\11\1\21\1\22\2\uffff\1\15\1\24\1\14\1\6\1\17\1\20\1\uffff"+
        "\1\13\1\25\1\23";
    static final String DFA17_specialS =
        "\74\uffff}>";
    static final String[] DFA17_transitionS = {
            "\1\11\2\uffff\1\2\1\4\1\uffff\1\7\4\uffff\1\10\1\6\1\1\3\uffff"+
            "\1\5\1\3",
            "",
            "\1\13\2\uffff\1\12",
            "\1\15\16\uffff\1\14",
            "\1\17\5\uffff\1\16",
            "\1\21\3\uffff\1\20",
            "\1\22",
            "",
            "",
            "",
            "",
            "\1\23",
            "\1\25\11\uffff\1\24",
            "\1\27\5\uffff\1\30\2\uffff\1\26",
            "\1\31",
            "\1\33\17\uffff\1\32",
            "\1\34",
            "\1\35",
            "\1\36",
            "\1\37",
            "",
            "\1\40\1\uffff\1\41",
            "",
            "\1\42",
            "",
            "\1\43",
            "",
            "\1\44",
            "\1\45",
            "\1\47",
            "\1\50",
            "\1\51",
            "",
            "",
            "\1\52",
            "\1\53",
            "\1\55\23\uffff\1\56",
            "\1\46\23\uffff\1\57",
            "",
            "\1\60",
            "\1\61",
            "\1\63",
            "\1\65\23\uffff\1\66",
            "\1\54\23\uffff\1\67",
            "",
            "",
            "",
            "",
            "\1\70",
            "\1\62\23\uffff\1\72",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\71\23\uffff\1\73",
            "",
            "",
            ""
    };

    static final short[] DFA17_eot = DFA.unpackEncodedString(DFA17_eotS);
    static final short[] DFA17_eof = DFA.unpackEncodedString(DFA17_eofS);
    static final char[] DFA17_min = DFA.unpackEncodedStringToUnsignedChars(DFA17_minS);
    static final char[] DFA17_max = DFA.unpackEncodedStringToUnsignedChars(DFA17_maxS);
    static final short[] DFA17_accept = DFA.unpackEncodedString(DFA17_acceptS);
    static final short[] DFA17_special = DFA.unpackEncodedString(DFA17_specialS);
    static final short[][] DFA17_transition;

    static {
        int numStates = DFA17_transitionS.length;
        DFA17_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA17_transition[i] = DFA.unpackEncodedString(DFA17_transitionS[i]);
        }
    }

    class DFA17 extends DFA {

        public DFA17(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 17;
            this.eot = DFA17_eot;
            this.eof = DFA17_eof;
            this.min = DFA17_min;
            this.max = DFA17_max;
            this.accept = DFA17_accept;
            this.special = DFA17_special;
            this.transition = DFA17_transition;
        }
        public String getDescription() {
            return "212:1: NUMWORDS : ( 'one' | 'eleven' | 'two' | 'twelve' | 'three' | 'thirteen' | 'four' ( 'teen' )? | 'five' | 'fifteen' | 'six' ( 'teen' )? | 'seven' ( 'teen' )? | 'eight' ( 'een' )? | 'nine' ( 'teen' )? | 'twenty' | 'thirty' | 'fourty' | 'fifty' | 'sixty' | 'seventy' | 'eighty' | 'ninety' | 'hundred' | 'thousand' | 'million' | 'billion' );";
        }
    }
    static final String DFA19_eotS =
        "\45\uffff\1\25\3\uffff\1\25";
    static final String DFA19_eofS =
        "\52\uffff";
    static final String DFA19_minS =
        "\1\11\1\uffff\1\141\1\150\1\145\2\141\1\150\1\165\2\uffff\1\156"+
        "\1\141\1\146\1\151\3\uffff\1\156\1\142\2\uffff\1\151\1\141\3\uffff"+
        "\1\156\1\uffff\1\145\3\uffff\1\145\1\uffff\1\144\1\161\1\171\1\162"+
        "\1\157\2\156";
    static final String DFA19_maxS =
        "\1\166\1\uffff\1\151\1\167\1\157\1\165\1\151\1\162\1\171\2\uffff"+
        "\1\172\1\145\2\162\3\uffff\1\170\1\154\2\uffff\2\162\3\uffff\1\156"+
        "\1\uffff\1\145\3\uffff\1\171\1\uffff\1\144\1\166\1\171\1\162\1\157"+
        "\2\156";
    static final String DFA19_acceptS =
        "\1\uffff\1\1\7\uffff\1\5\1\6\4\uffff\1\13\1\17\1\20\2\uffff\1\2"+
        "\1\3\2\uffff\1\10\1\12\1\16\1\uffff\1\4\1\uffff\1\11\1\14\1\15\1"+
        "\uffff\1\7\7\uffff";
    static final String DFA19_specialS =
        "\52\uffff}>";
    static final String[] DFA19_transitionS = {
            "\1\21\26\uffff\1\21\17\uffff\12\17\47\uffff\1\13\1\6\1\7\1\uffff"+
            "\1\16\1\4\1\10\1\20\3\uffff\1\11\2\20\1\15\1\5\1\12\1\1\1\2"+
            "\1\3\1\uffff\1\14",
            "",
            "\1\23\3\uffff\1\20\3\uffff\1\22",
            "\1\20\1\24\15\uffff\1\20",
            "\1\25\3\uffff\1\20\5\uffff\1\20",
            "\1\26\3\uffff\1\27\6\uffff\1\32\2\uffff\1\31\5\uffff\1\30",
            "\1\34\3\uffff\1\33\3\uffff\1\20",
            "\1\35\6\uffff\1\31\2\uffff\1\25",
            "\1\30\3\uffff\1\34",
            "",
            "",
            "\1\37\3\uffff\1\36\7\uffff\1\30",
            "\1\31\3\uffff\1\30",
            "\1\40\7\uffff\1\20\3\uffff\1\36",
            "\1\20\2\uffff\1\20\5\uffff\1\31",
            "",
            "",
            "",
            "\1\1\11\uffff\1\20",
            "\1\30\11\uffff\1\25",
            "",
            "",
            "\1\25\2\uffff\1\41\5\uffff\1\42",
            "\1\31\20\uffff\1\42",
            "",
            "",
            "",
            "\1\43",
            "",
            "\1\44",
            "",
            "",
            "",
            "\1\25\6\uffff\1\25\14\uffff\1\34",
            "",
            "\1\45",
            "\1\11\4\uffff\1\46",
            "\1\34",
            "\1\47",
            "\1\50",
            "\1\51",
            "\1\34"
    };

    static final short[] DFA19_eot = DFA.unpackEncodedString(DFA19_eotS);
    static final short[] DFA19_eof = DFA.unpackEncodedString(DFA19_eofS);
    static final char[] DFA19_min = DFA.unpackEncodedStringToUnsignedChars(DFA19_minS);
    static final char[] DFA19_max = DFA.unpackEncodedStringToUnsignedChars(DFA19_maxS);
    static final short[] DFA19_accept = DFA.unpackEncodedString(DFA19_acceptS);
    static final short[] DFA19_special = DFA.unpackEncodedString(DFA19_specialS);
    static final short[][] DFA19_transition;

    static {
        int numStates = DFA19_transitionS.length;
        DFA19_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA19_transition[i] = DFA.unpackEncodedString(DFA19_transitionS[i]);
        }
    }

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = DFA19_eot;
            this.eof = DFA19_eof;
            this.min = DFA19_min;
            this.max = DFA19_max;
            this.accept = DFA19_accept;
            this.special = DFA19_special;
            this.transition = DFA19_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( DIV_MODIFIER | TIERCED | DIV | VARIABLE_DIV | CONTINUOUS_DIV | QUARTER | PARTYPER | COLOUR | METAL | FUR | DIGITS | AND | OF | PLAIN | NUMWORDS | WS );";
        }
    }
 

}