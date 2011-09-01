// $ANTLR 3.3 Nov 30, 2010 12:50:56 /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g 2011-09-01 22:34:07

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
    public static final int DIGITS=12;
    public static final int NUMWORDS=13;
    public static final int COLOUR=14;
    public static final int METAL=15;
    public static final int FUR=16;
    public static final int WS=17;

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
            // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:158:9: ( 'reversed' | 'sinister' )
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
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:158:13: 'reversed'
                    {
                    match("reversed"); 


                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:158:26: 'sinister'
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
            // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:162:9: ( 'tierced' )
            // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:162:13: 'tierced'
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
            // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:165:9: ( 'fess' | 'pale' | 'bend' | 'cross' | 'saltire' | 'chevron' | 'pall' | 'pairle' )
            int alt2=8;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:165:13: 'fess'
                    {
                    match("fess"); 


                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:165:22: 'pale'
                    {
                    match("pale"); 


                    }
                    break;
                case 3 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:165:31: 'bend'
                    {
                    match("bend"); 


                    }
                    break;
                case 4 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:165:40: 'cross'
                    {
                    match("cross"); 


                    }
                    break;
                case 5 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:165:50: 'saltire'
                    {
                    match("saltire"); 


                    }
                    break;
                case 6 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:165:62: 'chevron'
                    {
                    match("chevron"); 


                    }
                    break;
                case 7 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:165:74: 'pall'
                    {
                    match("pall"); 


                    }
                    break;
                case 8 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:165:83: 'pairle'
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
            // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:168:14: ( 'gyronny' | 'barry' | 'paly' | 'bendy' | 'chevronny' )
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
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:168:18: 'gyronny'
                    {
                    match("gyronny"); 


                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:168:30: 'barry'
                    {
                    match("barry"); 


                    }
                    break;
                case 3 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:168:40: 'paly'
                    {
                    match("paly"); 


                    }
                    break;
                case 4 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:168:49: 'bendy'
                    {
                    match("bendy"); 


                    }
                    break;
                case 5 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:168:59: 'chevronny'
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

    // $ANTLR start "PARTYPER"
    public final void mPARTYPER() throws RecognitionException {
        try {
            int _type = PARTYPER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:172:9: ( ( 'part' ( 'ed' | 'y' ) ' ' )? 'per' )
            // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:172:13: ( 'part' ( 'ed' | 'y' ) ' ' )? 'per'
            {
            // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:172:13: ( 'part' ( 'ed' | 'y' ) ' ' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='p') ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1=='a') ) {
                    alt5=1;
                }
            }
            switch (alt5) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:172:14: 'part' ( 'ed' | 'y' ) ' '
                    {
                    match("part"); 

                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:172:20: ( 'ed' | 'y' )
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0=='e') ) {
                        alt4=1;
                    }
                    else if ( (LA4_0=='y') ) {
                        alt4=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 4, 0, input);

                        throw nvae;
                    }
                    switch (alt4) {
                        case 1 :
                            // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:172:21: 'ed'
                            {
                            match("ed"); 


                            }
                            break;
                        case 2 :
                            // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:172:26: 'y'
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
            // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:175:9: ( 'azure' | 'gules' | 'vert' | 'sable' | 'purpure' )
            int alt6=5;
            switch ( input.LA(1) ) {
            case 'a':
                {
                alt6=1;
                }
                break;
            case 'g':
                {
                alt6=2;
                }
                break;
            case 'v':
                {
                alt6=3;
                }
                break;
            case 's':
                {
                alt6=4;
                }
                break;
            case 'p':
                {
                alt6=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:175:13: 'azure'
                    {
                    match("azure"); 


                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:175:23: 'gules'
                    {
                    match("gules"); 


                    }
                    break;
                case 3 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:175:33: 'vert'
                    {
                    match("vert"); 


                    }
                    break;
                case 4 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:175:42: 'sable'
                    {
                    match("sable"); 


                    }
                    break;
                case 5 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:175:52: 'purpure'
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
            // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:178:9: ( 'or' | 'argent' )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='o') ) {
                alt7=1;
            }
            else if ( (LA7_0=='a') ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:178:13: 'or'
                    {
                    match("or"); 


                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:178:20: 'argent'
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
            // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:181:9: ( 'ermine' | 'ermines' | 'erminois' | 'pean' | 'vair' | 'counter-vair' | 'vair-en-pale' | 'vair-en-point' | 'potent' | 'counter-potent' | 'potent-en-pale' | 'potent-en-point' )
            int alt8=12;
            alt8 = dfa8.predict(input);
            switch (alt8) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:181:13: 'ermine'
                    {
                    match("ermine"); 


                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:181:24: 'ermines'
                    {
                    match("ermines"); 


                    }
                    break;
                case 3 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:181:36: 'erminois'
                    {
                    match("erminois"); 


                    }
                    break;
                case 4 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:181:49: 'pean'
                    {
                    match("pean"); 


                    }
                    break;
                case 5 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:182:13: 'vair'
                    {
                    match("vair"); 


                    }
                    break;
                case 6 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:182:22: 'counter-vair'
                    {
                    match("counter-vair"); 


                    }
                    break;
                case 7 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:182:39: 'vair-en-pale'
                    {
                    match("vair-en-pale"); 


                    }
                    break;
                case 8 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:182:56: 'vair-en-point'
                    {
                    match("vair-en-point"); 


                    }
                    break;
                case 9 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:183:13: 'potent'
                    {
                    match("potent"); 


                    }
                    break;
                case 10 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:183:24: 'counter-potent'
                    {
                    match("counter-potent"); 


                    }
                    break;
                case 11 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:183:43: 'potent-en-pale'
                    {
                    match("potent-en-pale"); 


                    }
                    break;
                case 12 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:183:62: 'potent-en-point'
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
            // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:186:9: ( ( '0' .. '9' )+ )
            // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:186:13: ( '0' .. '9' )+
            {
            // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:186:13: ( '0' .. '9' )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>='0' && LA9_0<='9')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:186:14: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
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
            // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:189:9: ( 'and' )
            // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:189:13: 'and'
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
            // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:192:9: ( 'of' )
            // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:192:13: 'of'
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
            // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:195:9: ( 'plain' )
            // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:195:13: 'plain'
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
            // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:199:9: ( 'one' | 'eleven' | 'two' | 'twelve' | 'three' | 'thirteen' | 'four' ( 'teen' )? | 'five' | 'fifteen' | 'six' ( 'teen' )? | 'seven' ( 'teen' )? | 'eight' ( 'een' )? | 'nine' ( 'teen' )? | 'twenty' | 'thirty' | 'fourty' | 'fifty' | 'sixty' | 'seventy' | 'eighty' | 'ninety' | 'hundred' | 'thousand' | 'million' | 'billion' )
            int alt15=25;
            alt15 = dfa15.predict(input);
            switch (alt15) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:199:13: 'one'
                    {
                    match("one"); 


                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:199:21: 'eleven'
                    {
                    match("eleven"); 


                    }
                    break;
                case 3 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:199:32: 'two'
                    {
                    match("two"); 


                    }
                    break;
                case 4 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:199:40: 'twelve'
                    {
                    match("twelve"); 


                    }
                    break;
                case 5 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:199:51: 'three'
                    {
                    match("three"); 


                    }
                    break;
                case 6 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:199:61: 'thirteen'
                    {
                    match("thirteen"); 


                    }
                    break;
                case 7 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:200:13: 'four' ( 'teen' )?
                    {
                    match("four"); 

                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:200:19: ( 'teen' )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0=='t') ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:200:19: 'teen'
                            {
                            match("teen"); 


                            }
                            break;

                    }


                    }
                    break;
                case 8 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:200:29: 'five'
                    {
                    match("five"); 


                    }
                    break;
                case 9 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:200:38: 'fifteen'
                    {
                    match("fifteen"); 


                    }
                    break;
                case 10 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:200:50: 'six' ( 'teen' )?
                    {
                    match("six"); 

                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:200:55: ( 'teen' )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0=='t') ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:200:55: 'teen'
                            {
                            match("teen"); 


                            }
                            break;

                    }


                    }
                    break;
                case 11 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:200:65: 'seven' ( 'teen' )?
                    {
                    match("seven"); 

                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:200:72: ( 'teen' )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0=='t') ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:200:72: 'teen'
                            {
                            match("teen"); 


                            }
                            break;

                    }


                    }
                    break;
                case 12 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:201:13: 'eight' ( 'een' )?
                    {
                    match("eight"); 

                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:201:20: ( 'een' )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0=='e') ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:201:20: 'een'
                            {
                            match("een"); 


                            }
                            break;

                    }


                    }
                    break;
                case 13 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:201:29: 'nine' ( 'teen' )?
                    {
                    match("nine"); 

                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:201:35: ( 'teen' )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0=='t') ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:201:35: 'teen'
                            {
                            match("teen"); 


                            }
                            break;

                    }


                    }
                    break;
                case 14 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:201:45: 'twenty'
                    {
                    match("twenty"); 


                    }
                    break;
                case 15 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:201:56: 'thirty'
                    {
                    match("thirty"); 


                    }
                    break;
                case 16 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:201:67: 'fourty'
                    {
                    match("fourty"); 


                    }
                    break;
                case 17 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:202:13: 'fifty'
                    {
                    match("fifty"); 


                    }
                    break;
                case 18 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:202:23: 'sixty'
                    {
                    match("sixty"); 


                    }
                    break;
                case 19 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:202:33: 'seventy'
                    {
                    match("seventy"); 


                    }
                    break;
                case 20 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:202:45: 'eighty'
                    {
                    match("eighty"); 


                    }
                    break;
                case 21 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:202:56: 'ninety'
                    {
                    match("ninety"); 


                    }
                    break;
                case 22 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:202:67: 'hundred'
                    {
                    match("hundred"); 


                    }
                    break;
                case 23 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:203:13: 'thousand'
                    {
                    match("thousand"); 


                    }
                    break;
                case 24 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:203:26: 'million'
                    {
                    match("million"); 


                    }
                    break;
                case 25 :
                    // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:203:38: 'billion'
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
            // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:206:9: ( ( ' ' | '\\t' )+ )
            // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:206:13: ( ' ' | '\\t' )+
            {
            // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:206:13: ( ' ' | '\\t' )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0=='\t'||LA16_0==' ') ) {
                    alt16=1;
                }


                switch (alt16) {
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
            	    if ( cnt16 >= 1 ) break loop16;
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
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
        // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:1:8: ( DIV_MODIFIER | TIERCED | DIV | VARIABLE_DIV | PARTYPER | COLOUR | METAL | FUR | DIGITS | AND | OF | PLAIN | NUMWORDS | WS )
        int alt17=14;
        alt17 = dfa17.predict(input);
        switch (alt17) {
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
                // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:1:48: PARTYPER
                {
                mPARTYPER(); 

                }
                break;
            case 6 :
                // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:1:57: COLOUR
                {
                mCOLOUR(); 

                }
                break;
            case 7 :
                // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:1:64: METAL
                {
                mMETAL(); 

                }
                break;
            case 8 :
                // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:1:70: FUR
                {
                mFUR(); 

                }
                break;
            case 9 :
                // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:1:74: DIGITS
                {
                mDIGITS(); 

                }
                break;
            case 10 :
                // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:1:81: AND
                {
                mAND(); 

                }
                break;
            case 11 :
                // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:1:85: OF
                {
                mOF(); 

                }
                break;
            case 12 :
                // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:1:88: PLAIN
                {
                mPLAIN(); 

                }
                break;
            case 13 :
                // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:1:94: NUMWORDS
                {
                mNUMWORDS(); 

                }
                break;
            case 14 :
                // /Users/luketorjussen/Documents/workspace/BlazonGrammar/grammar/Blazon.g:1:103: WS
                {
                mWS(); 

                }
                break;

        }

    }


    protected DFA2 dfa2 = new DFA2(this);
    protected DFA8 dfa8 = new DFA8(this);
    protected DFA15 dfa15 = new DFA15(this);
    protected DFA17 dfa17 = new DFA17(this);
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
            return "165:1: DIV : ( 'fess' | 'pale' | 'bend' | 'cross' | 'saltire' | 'chevron' | 'pall' | 'pairle' );";
        }
    }
    static final String DFA8_eotS =
        "\20\uffff\1\25\6\uffff\1\35\1\uffff\1\37\25\uffff";
    static final String DFA8_eofS =
        "\57\uffff";
    static final String DFA8_minS =
        "\1\143\1\162\1\145\1\141\1\157\1\155\1\uffff\1\164\1\151\1\165\1"+
        "\151\1\145\1\162\3\156\1\55\1\164\1\145\1\164\1\145\1\uffff\1\145"+
        "\1\163\1\uffff\1\55\1\156\1\162\2\uffff\1\145\1\uffff\2\55\1\156"+
        "\2\160\1\55\1\141\2\uffff\1\160\2\uffff\1\141\2\uffff";
    static final String DFA8_maxS =
        "\1\166\1\162\1\157\1\141\1\157\1\155\1\uffff\1\164\1\151\1\165\1"+
        "\151\1\145\1\162\3\156\1\55\1\164\1\157\1\164\1\145\1\uffff\1\145"+
        "\1\163\1\uffff\1\55\1\156\1\162\2\uffff\1\145\1\uffff\2\55\1\156"+
        "\1\160\1\166\1\55\1\157\2\uffff\1\160\2\uffff\1\157\2\uffff";
    static final String DFA8_acceptS =
        "\6\uffff\1\4\16\uffff\1\5\2\uffff\1\3\3\uffff\1\2\1\1\1\uffff\1"+
        "\11\7\uffff\1\6\1\12\1\uffff\1\7\1\10\1\uffff\1\13\1\14";
    static final String DFA8_specialS =
        "\57\uffff}>";
    static final String[] DFA8_transitionS = {
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

    static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
    static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
    static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
    static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
    static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
    static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
    static final short[][] DFA8_transition;

    static {
        int numStates = DFA8_transitionS.length;
        DFA8_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
        }
    }

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = DFA8_eot;
            this.eof = DFA8_eof;
            this.min = DFA8_min;
            this.max = DFA8_max;
            this.accept = DFA8_accept;
            this.special = DFA8_special;
            this.transition = DFA8_transition;
        }
        public String getDescription() {
            return "181:1: FUR : ( 'ermine' | 'ermines' | 'erminois' | 'pean' | 'vair' | 'counter-vair' | 'vair-en-pale' | 'vair-en-point' | 'potent' | 'counter-potent' | 'potent-en-pale' | 'potent-en-point' );";
        }
    }
    static final String DFA15_eotS =
        "\34\uffff\1\46\6\uffff\1\54\4\uffff\1\62\1\64\6\uffff\1\71\13\uffff";
    static final String DFA15_eofS =
        "\74\uffff";
    static final String DFA15_minS =
        "\1\142\1\uffff\1\151\1\150\1\151\1\145\1\151\4\uffff\1\147\1\145"+
        "\1\151\1\165\1\146\1\170\1\166\1\156\1\150\1\uffff\1\154\1\uffff"+
        "\1\162\1\uffff\1\162\1\uffff\2\164\2\145\1\164\2\uffff\2\164\2\145"+
        "\1\uffff\1\156\1\164\1\171\2\145\4\uffff\1\164\1\145\6\uffff\1\145"+
        "\3\uffff";
    static final String DFA15_maxS =
        "\1\164\1\uffff\1\154\1\167\1\157\2\151\4\uffff\1\147\1\157\1\162"+
        "\1\165\1\166\1\170\1\166\1\156\1\150\1\uffff\1\156\1\uffff\1\162"+
        "\1\uffff\1\162\1\uffff\2\164\2\145\1\164\2\uffff\2\164\2\171\1\uffff"+
        "\1\156\1\164\3\171\4\uffff\1\164\1\171\6\uffff\1\171\3\uffff";
    static final String DFA15_acceptS =
        "\1\uffff\1\1\5\uffff\1\26\1\30\1\31\1\2\11\uffff\1\3\1\uffff\1\5"+
        "\1\uffff\1\27\1\uffff\1\10\5\uffff\1\4\1\16\4\uffff\1\12\5\uffff"+
        "\1\7\1\11\1\21\1\22\2\uffff\1\15\1\24\1\14\1\6\1\17\1\20\1\uffff"+
        "\1\13\1\25\1\23";
    static final String DFA15_specialS =
        "\74\uffff}>";
    static final String[] DFA15_transitionS = {
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

    static final short[] DFA15_eot = DFA.unpackEncodedString(DFA15_eotS);
    static final short[] DFA15_eof = DFA.unpackEncodedString(DFA15_eofS);
    static final char[] DFA15_min = DFA.unpackEncodedStringToUnsignedChars(DFA15_minS);
    static final char[] DFA15_max = DFA.unpackEncodedStringToUnsignedChars(DFA15_maxS);
    static final short[] DFA15_accept = DFA.unpackEncodedString(DFA15_acceptS);
    static final short[] DFA15_special = DFA.unpackEncodedString(DFA15_specialS);
    static final short[][] DFA15_transition;

    static {
        int numStates = DFA15_transitionS.length;
        DFA15_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA15_transition[i] = DFA.unpackEncodedString(DFA15_transitionS[i]);
        }
    }

    class DFA15 extends DFA {

        public DFA15(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 15;
            this.eot = DFA15_eot;
            this.eof = DFA15_eof;
            this.min = DFA15_min;
            this.max = DFA15_max;
            this.accept = DFA15_accept;
            this.special = DFA15_special;
            this.transition = DFA15_transition;
        }
        public String getDescription() {
            return "198:1: NUMWORDS : ( 'one' | 'eleven' | 'two' | 'twelve' | 'three' | 'thirteen' | 'four' ( 'teen' )? | 'five' | 'fifteen' | 'six' ( 'teen' )? | 'seven' ( 'teen' )? | 'eight' ( 'een' )? | 'nine' ( 'teen' )? | 'twenty' | 'thirty' | 'fourty' | 'fifty' | 'sixty' | 'seventy' | 'eighty' | 'ninety' | 'hundred' | 'thousand' | 'million' | 'billion' );";
        }
    }
    static final String DFA17_eotS =
        "\43\uffff\1\23\3\uffff\1\23";
    static final String DFA17_eofS =
        "\50\uffff";
    static final String DFA17_minS =
        "\1\11\1\uffff\1\141\1\150\1\145\2\141\1\150\1\165\1\156\1\141\1"+
        "\146\1\151\3\uffff\1\156\1\142\2\uffff\1\151\1\141\3\uffff\1\156"+
        "\1\uffff\1\145\3\uffff\1\145\1\uffff\1\144\1\166\1\171\1\162\1\157"+
        "\2\156";
    static final String DFA17_maxS =
        "\1\166\1\uffff\1\151\1\167\1\157\1\165\1\151\1\162\1\171\1\172\1"+
        "\145\2\162\3\uffff\1\170\1\154\2\uffff\2\162\3\uffff\1\156\1\uffff"+
        "\1\145\3\uffff\1\171\1\uffff\1\144\1\166\1\171\1\162\1\157\2\156";
    static final String DFA17_acceptS =
        "\1\uffff\1\1\13\uffff\1\11\1\15\1\16\2\uffff\1\2\1\3\2\uffff\1\6"+
        "\1\10\1\14\1\uffff\1\4\1\uffff\1\7\1\12\1\13\1\uffff\1\5\7\uffff";
    static final String DFA17_specialS =
        "\50\uffff}>";
    static final String[] DFA17_transitionS = {
            "\1\17\26\uffff\1\17\17\uffff\12\15\47\uffff\1\11\1\6\1\7\1\uffff"+
            "\1\14\1\4\1\10\1\16\4\uffff\2\16\1\13\1\5\1\uffff\1\1\1\2\1"+
            "\3\1\uffff\1\12",
            "",
            "\1\21\3\uffff\1\16\3\uffff\1\20",
            "\1\16\1\22\15\uffff\1\16",
            "\1\23\3\uffff\1\16\5\uffff\1\16",
            "\1\24\3\uffff\1\25\6\uffff\1\30\2\uffff\1\27\5\uffff\1\26",
            "\1\32\3\uffff\1\31\3\uffff\1\16",
            "\1\33\6\uffff\1\27\2\uffff\1\23",
            "\1\26\3\uffff\1\32",
            "\1\35\3\uffff\1\34\7\uffff\1\26",
            "\1\27\3\uffff\1\26",
            "\1\36\7\uffff\1\16\3\uffff\1\34",
            "\1\16\2\uffff\1\16\5\uffff\1\27",
            "",
            "",
            "",
            "\1\1\11\uffff\1\16",
            "\1\26\11\uffff\1\23",
            "",
            "",
            "\1\23\2\uffff\1\37\5\uffff\1\40",
            "\1\27\20\uffff\1\40",
            "",
            "",
            "",
            "\1\41",
            "",
            "\1\42",
            "",
            "",
            "",
            "\1\23\6\uffff\1\23\14\uffff\1\32",
            "",
            "\1\43",
            "\1\44",
            "\1\32",
            "\1\45",
            "\1\46",
            "\1\47",
            "\1\32"
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
            return "1:1: Tokens : ( DIV_MODIFIER | TIERCED | DIV | VARIABLE_DIV | PARTYPER | COLOUR | METAL | FUR | DIGITS | AND | OF | PLAIN | NUMWORDS | WS );";
        }
    }
 

}