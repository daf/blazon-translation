// $ANTLR 3.3 Nov 30, 2010 12:50:56 C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g 2011-08-17 18:52:21

  package blazon.server.grammar;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class BlazonLexer extends Lexer {
    public static final int EOF=-1;
    public static final int PARTYPER=4;
    public static final int PLAIN=5;
    public static final int AND=6;
    public static final int DIV=7;
    public static final int MODIFIER=8;
    public static final int GYRONNY=9;
    public static final int OF=10;
    public static final int DIGITS=11;
    public static final int NUMWORDS=12;
    public static final int COLOUR=13;
    public static final int METAL=14;
    public static final int FUR=15;
    public static final int WS=16;

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

    // $ANTLR start "MODIFIER"
    public final void mMODIFIER() throws RecognitionException {
        try {
            int _type = MODIFIER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:144:9: ( 'reversed' | 'sinister' )
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
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:144:13: 'reversed'
                    {
                    match("reversed"); 


                    }
                    break;
                case 2 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:144:26: 'sinister'
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
    // $ANTLR end "MODIFIER"

    // $ANTLR start "DIV"
    public final void mDIV() throws RecognitionException {
        try {
            int _type = DIV;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:147:9: ( 'fess' | 'pale' | 'bend' | 'cross' | 'saltire' | 'chevron' | 'pall' )
            int alt2=7;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:147:13: 'fess'
                    {
                    match("fess"); 


                    }
                    break;
                case 2 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:147:22: 'pale'
                    {
                    match("pale"); 


                    }
                    break;
                case 3 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:147:31: 'bend'
                    {
                    match("bend"); 


                    }
                    break;
                case 4 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:147:40: 'cross'
                    {
                    match("cross"); 


                    }
                    break;
                case 5 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:147:50: 'saltire'
                    {
                    match("saltire"); 


                    }
                    break;
                case 6 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:147:62: 'chevron'
                    {
                    match("chevron"); 


                    }
                    break;
                case 7 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:147:74: 'pall'
                    {
                    match("pall"); 


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

    // $ANTLR start "GYRONNY"
    public final void mGYRONNY() throws RecognitionException {
        try {
            int _type = GYRONNY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:150:9: ( 'gyronny' )
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:150:13: 'gyronny'
            {
            match("gyronny"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GYRONNY"

    // $ANTLR start "PARTYPER"
    public final void mPARTYPER() throws RecognitionException {
        try {
            int _type = PARTYPER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:154:9: ( ( 'part' ( 'ed' | 'y' ) ' ' )? 'per' )
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:154:13: ( 'part' ( 'ed' | 'y' ) ' ' )? 'per'
            {
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:154:13: ( 'part' ( 'ed' | 'y' ) ' ' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='p') ) {
                int LA4_1 = input.LA(2);

                if ( (LA4_1=='a') ) {
                    alt4=1;
                }
            }
            switch (alt4) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:154:14: 'part' ( 'ed' | 'y' ) ' '
                    {
                    match("part"); 

                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:154:20: ( 'ed' | 'y' )
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0=='e') ) {
                        alt3=1;
                    }
                    else if ( (LA3_0=='y') ) {
                        alt3=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 0, input);

                        throw nvae;
                    }
                    switch (alt3) {
                        case 1 :
                            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:154:21: 'ed'
                            {
                            match("ed"); 


                            }
                            break;
                        case 2 :
                            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:154:26: 'y'
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
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:157:9: ( 'azure' | 'gules' | 'vert' | 'sable' | 'purpure' )
            int alt5=5;
            switch ( input.LA(1) ) {
            case 'a':
                {
                alt5=1;
                }
                break;
            case 'g':
                {
                alt5=2;
                }
                break;
            case 'v':
                {
                alt5=3;
                }
                break;
            case 's':
                {
                alt5=4;
                }
                break;
            case 'p':
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
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:157:13: 'azure'
                    {
                    match("azure"); 


                    }
                    break;
                case 2 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:157:23: 'gules'
                    {
                    match("gules"); 


                    }
                    break;
                case 3 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:157:33: 'vert'
                    {
                    match("vert"); 


                    }
                    break;
                case 4 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:157:42: 'sable'
                    {
                    match("sable"); 


                    }
                    break;
                case 5 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:157:52: 'purpure'
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
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:160:9: ( 'or' | 'argent' )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='o') ) {
                alt6=1;
            }
            else if ( (LA6_0=='a') ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:160:13: 'or'
                    {
                    match("or"); 


                    }
                    break;
                case 2 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:160:20: 'argent'
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
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:163:9: ( 'ermine' | 'ermines' | 'erminois' | 'pean' | 'vair' | 'counter-vair' | 'vair-en-pale' | 'vair-en-point' | 'potent' | 'counter-potent' | 'potent-en-pale' | 'potent-en-point' )
            int alt7=12;
            alt7 = dfa7.predict(input);
            switch (alt7) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:163:13: 'ermine'
                    {
                    match("ermine"); 


                    }
                    break;
                case 2 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:163:24: 'ermines'
                    {
                    match("ermines"); 


                    }
                    break;
                case 3 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:163:36: 'erminois'
                    {
                    match("erminois"); 


                    }
                    break;
                case 4 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:163:49: 'pean'
                    {
                    match("pean"); 


                    }
                    break;
                case 5 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:164:13: 'vair'
                    {
                    match("vair"); 


                    }
                    break;
                case 6 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:164:22: 'counter-vair'
                    {
                    match("counter-vair"); 


                    }
                    break;
                case 7 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:164:39: 'vair-en-pale'
                    {
                    match("vair-en-pale"); 


                    }
                    break;
                case 8 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:164:56: 'vair-en-point'
                    {
                    match("vair-en-point"); 


                    }
                    break;
                case 9 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:165:13: 'potent'
                    {
                    match("potent"); 


                    }
                    break;
                case 10 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:165:24: 'counter-potent'
                    {
                    match("counter-potent"); 


                    }
                    break;
                case 11 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:165:43: 'potent-en-pale'
                    {
                    match("potent-en-pale"); 


                    }
                    break;
                case 12 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:165:62: 'potent-en-point'
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
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:168:9: ( ( '0' .. '9' )+ )
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:168:13: ( '0' .. '9' )+
            {
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:168:13: ( '0' .. '9' )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='0' && LA8_0<='9')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:168:14: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
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
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:171:9: ( 'and' )
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:171:13: 'and'
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
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:174:9: ( 'of' )
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:174:13: 'of'
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
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:177:9: ( 'plain' )
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:177:13: 'plain'
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
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:181:9: ( 'one' | 'eleven' | 'two' | 'twelve' | 'three' | 'thirteen' | 'four' ( 'teen' )? | 'five' | 'fifteen' | 'six' ( 'teen' )? | 'seven' ( 'teen' )? | 'eight' ( 'een' )? | 'nine' ( 'teen' )? | 'twenty' | 'thirty' | 'fourty' | 'fifty' | 'sixty' | 'seventy' | 'eighty' | 'ninety' | 'hundred' | 'thousand' | 'million' | 'billion' )
            int alt14=25;
            alt14 = dfa14.predict(input);
            switch (alt14) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:181:13: 'one'
                    {
                    match("one"); 


                    }
                    break;
                case 2 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:181:21: 'eleven'
                    {
                    match("eleven"); 


                    }
                    break;
                case 3 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:181:32: 'two'
                    {
                    match("two"); 


                    }
                    break;
                case 4 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:181:40: 'twelve'
                    {
                    match("twelve"); 


                    }
                    break;
                case 5 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:181:51: 'three'
                    {
                    match("three"); 


                    }
                    break;
                case 6 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:181:61: 'thirteen'
                    {
                    match("thirteen"); 


                    }
                    break;
                case 7 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:182:13: 'four' ( 'teen' )?
                    {
                    match("four"); 

                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:182:19: ( 'teen' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='t') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:182:19: 'teen'
                            {
                            match("teen"); 


                            }
                            break;

                    }


                    }
                    break;
                case 8 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:182:29: 'five'
                    {
                    match("five"); 


                    }
                    break;
                case 9 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:182:38: 'fifteen'
                    {
                    match("fifteen"); 


                    }
                    break;
                case 10 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:182:50: 'six' ( 'teen' )?
                    {
                    match("six"); 

                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:182:55: ( 'teen' )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0=='t') ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:182:55: 'teen'
                            {
                            match("teen"); 


                            }
                            break;

                    }


                    }
                    break;
                case 11 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:182:65: 'seven' ( 'teen' )?
                    {
                    match("seven"); 

                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:182:72: ( 'teen' )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0=='t') ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:182:72: 'teen'
                            {
                            match("teen"); 


                            }
                            break;

                    }


                    }
                    break;
                case 12 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:183:13: 'eight' ( 'een' )?
                    {
                    match("eight"); 

                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:183:20: ( 'een' )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0=='e') ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:183:20: 'een'
                            {
                            match("een"); 


                            }
                            break;

                    }


                    }
                    break;
                case 13 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:183:29: 'nine' ( 'teen' )?
                    {
                    match("nine"); 

                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:183:35: ( 'teen' )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0=='t') ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:183:35: 'teen'
                            {
                            match("teen"); 


                            }
                            break;

                    }


                    }
                    break;
                case 14 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:183:45: 'twenty'
                    {
                    match("twenty"); 


                    }
                    break;
                case 15 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:183:56: 'thirty'
                    {
                    match("thirty"); 


                    }
                    break;
                case 16 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:183:67: 'fourty'
                    {
                    match("fourty"); 


                    }
                    break;
                case 17 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:184:13: 'fifty'
                    {
                    match("fifty"); 


                    }
                    break;
                case 18 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:184:23: 'sixty'
                    {
                    match("sixty"); 


                    }
                    break;
                case 19 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:184:33: 'seventy'
                    {
                    match("seventy"); 


                    }
                    break;
                case 20 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:184:45: 'eighty'
                    {
                    match("eighty"); 


                    }
                    break;
                case 21 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:184:56: 'ninety'
                    {
                    match("ninety"); 


                    }
                    break;
                case 22 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:184:67: 'hundred'
                    {
                    match("hundred"); 


                    }
                    break;
                case 23 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:185:13: 'thousand'
                    {
                    match("thousand"); 


                    }
                    break;
                case 24 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:185:26: 'million'
                    {
                    match("million"); 


                    }
                    break;
                case 25 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:185:38: 'billion'
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
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:188:9: ( ( ' ' | '\\t' )+ )
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:188:13: ( ' ' | '\\t' )+
            {
            // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:188:13: ( ' ' | '\\t' )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0=='\t'||LA15_0==' ') ) {
                    alt15=1;
                }


                switch (alt15) {
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
            	    if ( cnt15 >= 1 ) break loop15;
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
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
        // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:1:8: ( MODIFIER | DIV | GYRONNY | PARTYPER | COLOUR | METAL | FUR | DIGITS | AND | OF | PLAIN | NUMWORDS | WS )
        int alt16=13;
        alt16 = dfa16.predict(input);
        switch (alt16) {
            case 1 :
                // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:1:10: MODIFIER
                {
                mMODIFIER(); 

                }
                break;
            case 2 :
                // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:1:19: DIV
                {
                mDIV(); 

                }
                break;
            case 3 :
                // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:1:23: GYRONNY
                {
                mGYRONNY(); 

                }
                break;
            case 4 :
                // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:1:31: PARTYPER
                {
                mPARTYPER(); 

                }
                break;
            case 5 :
                // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:1:40: COLOUR
                {
                mCOLOUR(); 

                }
                break;
            case 6 :
                // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:1:47: METAL
                {
                mMETAL(); 

                }
                break;
            case 7 :
                // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:1:53: FUR
                {
                mFUR(); 

                }
                break;
            case 8 :
                // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:1:57: DIGITS
                {
                mDIGITS(); 

                }
                break;
            case 9 :
                // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:1:64: AND
                {
                mAND(); 

                }
                break;
            case 10 :
                // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:1:68: OF
                {
                mOF(); 

                }
                break;
            case 11 :
                // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:1:71: PLAIN
                {
                mPLAIN(); 

                }
                break;
            case 12 :
                // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:1:77: NUMWORDS
                {
                mNUMWORDS(); 

                }
                break;
            case 13 :
                // C:\\Users\\Luke\\Dropbox\\project\\workspace\\BlazonGrammar\\grammar\\Blazon.g:1:86: WS
                {
                mWS(); 

                }
                break;

        }

    }


    protected DFA2 dfa2 = new DFA2(this);
    protected DFA7 dfa7 = new DFA7(this);
    protected DFA14 dfa14 = new DFA14(this);
    protected DFA16 dfa16 = new DFA16(this);
    static final String DFA2_eotS =
        "\14\uffff";
    static final String DFA2_eofS =
        "\14\uffff";
    static final String DFA2_minS =
        "\1\142\1\uffff\1\141\1\uffff\1\150\1\uffff\1\154\2\uffff\1\145"+
        "\2\uffff";
    static final String DFA2_maxS =
        "\1\163\1\uffff\1\141\1\uffff\1\162\1\uffff\1\154\2\uffff\1\154"+
        "\2\uffff";
    static final String DFA2_acceptS =
        "\1\uffff\1\1\1\uffff\1\3\1\uffff\1\5\1\uffff\1\4\1\6\1\uffff\1"+
        "\2\1\7";
    static final String DFA2_specialS =
        "\14\uffff}>";
    static final String[] DFA2_transitionS = {
            "\1\3\1\4\2\uffff\1\1\11\uffff\1\2\2\uffff\1\5",
            "",
            "\1\6",
            "",
            "\1\10\11\uffff\1\7",
            "",
            "\1\11",
            "",
            "",
            "\1\12\6\uffff\1\13",
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
            return "147:1: DIV : ( 'fess' | 'pale' | 'bend' | 'cross' | 'saltire' | 'chevron' | 'pall' );";
        }
    }
    static final String DFA7_eotS =
        "\20\uffff\1\25\6\uffff\1\35\1\uffff\1\37\25\uffff";
    static final String DFA7_eofS =
        "\57\uffff";
    static final String DFA7_minS =
        "\1\143\1\162\1\145\1\141\1\157\1\155\1\uffff\1\164\1\151\1\165"+
        "\1\151\1\145\1\162\3\156\1\55\1\164\1\145\1\164\1\145\1\uffff\1"+
        "\145\1\163\1\uffff\1\55\1\156\1\162\2\uffff\1\145\1\uffff\2\55\1"+
        "\156\2\160\1\55\1\141\2\uffff\1\160\2\uffff\1\141\2\uffff";
    static final String DFA7_maxS =
        "\1\166\1\162\1\157\1\141\1\157\1\155\1\uffff\1\164\1\151\1\165"+
        "\1\151\1\145\1\162\3\156\1\55\1\164\1\157\1\164\1\145\1\uffff\1"+
        "\145\1\163\1\uffff\1\55\1\156\1\162\2\uffff\1\145\1\uffff\2\55\1"+
        "\156\1\160\1\166\1\55\1\157\2\uffff\1\160\2\uffff\1\157\2\uffff";
    static final String DFA7_acceptS =
        "\6\uffff\1\4\16\uffff\1\5\2\uffff\1\3\3\uffff\1\2\1\1\1\uffff\1"+
        "\11\7\uffff\1\6\1\12\1\uffff\1\7\1\10\1\uffff\1\13\1\14";
    static final String DFA7_specialS =
        "\57\uffff}>";
    static final String[] DFA7_transitionS = {
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

    static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
    static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
    static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
    static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
    static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
    static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
    static final short[][] DFA7_transition;

    static {
        int numStates = DFA7_transitionS.length;
        DFA7_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
        }
    }

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = DFA7_eot;
            this.eof = DFA7_eof;
            this.min = DFA7_min;
            this.max = DFA7_max;
            this.accept = DFA7_accept;
            this.special = DFA7_special;
            this.transition = DFA7_transition;
        }
        public String getDescription() {
            return "163:1: FUR : ( 'ermine' | 'ermines' | 'erminois' | 'pean' | 'vair' | 'counter-vair' | 'vair-en-pale' | 'vair-en-point' | 'potent' | 'counter-potent' | 'potent-en-pale' | 'potent-en-point' );";
        }
    }
    static final String DFA14_eotS =
        "\34\uffff\1\46\6\uffff\1\54\4\uffff\1\62\1\64\6\uffff\1\71\13\uffff";
    static final String DFA14_eofS =
        "\74\uffff";
    static final String DFA14_minS =
        "\1\142\1\uffff\1\151\1\150\1\151\1\145\1\151\4\uffff\1\147\1\145"+
        "\1\151\1\165\1\146\1\170\1\166\1\156\1\150\1\uffff\1\154\1\uffff"+
        "\1\162\1\uffff\1\162\1\uffff\2\164\2\145\1\164\2\uffff\2\164\2\145"+
        "\1\uffff\1\156\1\164\1\171\2\145\4\uffff\1\164\1\145\6\uffff\1\145"+
        "\3\uffff";
    static final String DFA14_maxS =
        "\1\164\1\uffff\1\154\1\167\1\157\2\151\4\uffff\1\147\1\157\1\162"+
        "\1\165\1\166\1\170\1\166\1\156\1\150\1\uffff\1\156\1\uffff\1\162"+
        "\1\uffff\1\162\1\uffff\2\164\2\145\1\164\2\uffff\2\164\2\171\1\uffff"+
        "\1\156\1\164\3\171\4\uffff\1\164\1\171\6\uffff\1\171\3\uffff";
    static final String DFA14_acceptS =
        "\1\uffff\1\1\5\uffff\1\26\1\30\1\31\1\2\11\uffff\1\3\1\uffff\1"+
        "\5\1\uffff\1\27\1\uffff\1\10\5\uffff\1\4\1\16\4\uffff\1\12\5\uffff"+
        "\1\7\1\11\1\21\1\22\2\uffff\1\15\1\24\1\14\1\6\1\17\1\20\1\uffff"+
        "\1\13\1\25\1\23";
    static final String DFA14_specialS =
        "\74\uffff}>";
    static final String[] DFA14_transitionS = {
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

    static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
    static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
    static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
    static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
    static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
    static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
    static final short[][] DFA14_transition;

    static {
        int numStates = DFA14_transitionS.length;
        DFA14_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
        }
    }

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = DFA14_eot;
            this.eof = DFA14_eof;
            this.min = DFA14_min;
            this.max = DFA14_max;
            this.accept = DFA14_accept;
            this.special = DFA14_special;
            this.transition = DFA14_transition;
        }
        public String getDescription() {
            return "180:1: NUMWORDS : ( 'one' | 'eleven' | 'two' | 'twelve' | 'three' | 'thirteen' | 'four' ( 'teen' )? | 'five' | 'fifteen' | 'six' ( 'teen' )? | 'seven' ( 'teen' )? | 'eight' ( 'een' )? | 'nine' ( 'teen' )? | 'twenty' | 'thirty' | 'fourty' | 'fifty' | 'sixty' | 'seventy' | 'eighty' | 'ninety' | 'hundred' | 'thousand' | 'million' | 'billion' );";
        }
    }
    static final String DFA16_eotS =
        "\34\uffff";
    static final String DFA16_eofS =
        "\34\uffff";
    static final String DFA16_minS =
        "\1\11\1\uffff\1\141\1\145\1\141\1\145\1\150\1\165\1\156\1\141\1"+
        "\146\1\151\3\uffff\1\156\1\142\1\uffff\1\154\1\141\10\uffff";
    static final String DFA16_maxS =
        "\1\166\1\uffff\1\151\1\157\1\165\1\151\1\162\1\171\1\172\1\145"+
        "\2\162\3\uffff\1\170\1\154\1\uffff\2\162\10\uffff";
    static final String DFA16_acceptS =
        "\1\uffff\1\1\12\uffff\1\10\1\14\1\15\2\uffff\1\2\2\uffff\1\5\1"+
        "\7\1\13\1\3\1\6\1\11\1\12\1\4";
    static final String DFA16_specialS =
        "\34\uffff}>";
    static final String[] DFA16_transitionS = {
            "\1\16\26\uffff\1\16\17\uffff\12\14\47\uffff\1\10\1\5\1\6\1"+
            "\uffff\1\13\1\3\1\7\1\15\4\uffff\2\15\1\12\1\4\1\uffff\1\1\1"+
            "\2\1\15\1\uffff\1\11",
            "",
            "\1\20\3\uffff\1\15\3\uffff\1\17",
            "\1\21\3\uffff\1\15\5\uffff\1\15",
            "\1\22\3\uffff\1\23\6\uffff\1\26\2\uffff\1\25\5\uffff\1\24",
            "\1\21\3\uffff\1\15",
            "\1\21\6\uffff\1\25\2\uffff\1\21",
            "\1\24\3\uffff\1\27",
            "\1\31\3\uffff\1\30\7\uffff\1\24",
            "\1\25\3\uffff\1\24",
            "\1\32\7\uffff\1\15\3\uffff\1\30",
            "\1\15\2\uffff\1\15\5\uffff\1\25",
            "",
            "",
            "",
            "\1\1\11\uffff\1\15",
            "\1\24\11\uffff\1\21",
            "",
            "\1\21\5\uffff\1\33",
            "\1\25\20\uffff\1\33",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA16_eot = DFA.unpackEncodedString(DFA16_eotS);
    static final short[] DFA16_eof = DFA.unpackEncodedString(DFA16_eofS);
    static final char[] DFA16_min = DFA.unpackEncodedStringToUnsignedChars(DFA16_minS);
    static final char[] DFA16_max = DFA.unpackEncodedStringToUnsignedChars(DFA16_maxS);
    static final short[] DFA16_accept = DFA.unpackEncodedString(DFA16_acceptS);
    static final short[] DFA16_special = DFA.unpackEncodedString(DFA16_specialS);
    static final short[][] DFA16_transition;

    static {
        int numStates = DFA16_transitionS.length;
        DFA16_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA16_transition[i] = DFA.unpackEncodedString(DFA16_transitionS[i]);
        }
    }

    class DFA16 extends DFA {

        public DFA16(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 16;
            this.eot = DFA16_eot;
            this.eof = DFA16_eof;
            this.min = DFA16_min;
            this.max = DFA16_max;
            this.accept = DFA16_accept;
            this.special = DFA16_special;
            this.transition = DFA16_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( MODIFIER | DIV | GYRONNY | PARTYPER | COLOUR | METAL | FUR | DIGITS | AND | OF | PLAIN | NUMWORDS | WS );";
        }
    }
 

}