// $ANTLR 3.3 Nov 30, 2010 12:50:56 /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g 2012-03-04 19:34:49

package blazon.server.grammar;

import blazon.shared.shield.diagnostic.ShieldDiagnostic;
import blazon.shared.shield.diagnostic.ShieldDiagnostic.LogLevel;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class BlazonLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__32=32;
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
    public static final int PROPER=28;
    public static final int DIGITS=29;
    public static final int NUMWORDS=30;
    public static final int WS=31;

    public BlazonLexer(CharStream input, List<ShieldDiagnostic> diags) {
    	this(input, new RecognizerSharedState(), diags);
    }

    public BlazonLexer(CharStream input, RecognizerSharedState state,
    		List<ShieldDiagnostic> diags) {
    	super(input, state);
    	this.diags = diags;
    }

    private List<ShieldDiagnostic> diags;

    @Override
    public void recover(RecognitionException re) {
    	diags.add(ShieldDiagnostic.build(LogLevel.ERROR, getErrorHeader(re) + ":"
    			+ getErrorMessage(re, getTokenNames())));
    	input.consume();
    }


    // delegates
    // delegators

    public BlazonLexer() {;} 
    public BlazonLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public BlazonLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "/Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g"; }

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:34:7: ( 'plain' )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:34:9: 'plain'
            {
            match("plain"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "MODIFIER"
    public final void mMODIFIER() throws RecognitionException {
        try {
            int _type = MODIFIER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:430:3: ( 'reversed' | 'sinister' )
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
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:431:3: 'reversed'
                    {
                    match("reversed"); 


                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:432:5: 'sinister'
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

    // $ANTLR start "TIERCED"
    public final void mTIERCED() throws RecognitionException {
        try {
            int _type = TIERCED;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:436:3: ( 'tierced' )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:437:3: 'tierced'
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

    // $ANTLR start "ORDINARY_DIV"
    public final void mORDINARY_DIV() throws RecognitionException {
        try {
            int _type = ORDINARY_DIV;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:441:3: ( 'fess' | 'pale' | 'bend' | 'cross' | 'saltire' | 'chevron' )
            int alt2=6;
            switch ( input.LA(1) ) {
            case 'f':
                {
                alt2=1;
                }
                break;
            case 'p':
                {
                alt2=2;
                }
                break;
            case 'b':
                {
                alt2=3;
                }
                break;
            case 'c':
                {
                int LA2_4 = input.LA(2);

                if ( (LA2_4=='r') ) {
                    alt2=4;
                }
                else if ( (LA2_4=='h') ) {
                    alt2=6;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 4, input);

                    throw nvae;
                }
                }
                break;
            case 's':
                {
                alt2=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:442:3: 'fess'
                    {
                    match("fess"); 


                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:443:5: 'pale'
                    {
                    match("pale"); 


                    }
                    break;
                case 3 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:444:5: 'bend'
                    {
                    match("bend"); 


                    }
                    break;
                case 4 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:445:5: 'cross'
                    {
                    match("cross"); 


                    }
                    break;
                case 5 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:446:5: 'saltire'
                    {
                    match("saltire"); 


                    }
                    break;
                case 6 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:447:5: 'chevron'
                    {
                    match("chevron"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ORDINARY_DIV"

    // $ANTLR start "SUBORDINARY_DIV"
    public final void mSUBORDINARY_DIV() throws RecognitionException {
        try {
            int _type = SUBORDINARY_DIV;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:451:3: ( 'pall' )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:452:3: 'pall'
            {
            match("pall"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SUBORDINARY_DIV"

    // $ANTLR start "OTHER_ORDINARY"
    public final void mOTHER_ORDINARY() throws RecognitionException {
        try {
            int _type = OTHER_ORDINARY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:456:3: ( 'chief' | 'base' )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='c') ) {
                alt3=1;
            }
            else if ( (LA3_0=='b') ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:457:3: 'chief'
                    {
                    match("chief"); 


                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:458:5: 'base'
                    {
                    match("base"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OTHER_ORDINARY"

    // $ANTLR start "SUBORDINARY"
    public final void mSUBORDINARY() throws RecognitionException {
        try {
            int _type = SUBORDINARY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:462:3: ( 'pile' | 'quarter' | 'canton' | 'flaunches' | 'bordure' | 'orle' | 'tressure' | 'gyron' | 'fret' )
            int alt4=9;
            alt4 = dfa4.predict(input);
            switch (alt4) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:463:3: 'pile'
                    {
                    match("pile"); 


                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:464:5: 'quarter'
                    {
                    match("quarter"); 


                    }
                    break;
                case 3 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:465:5: 'canton'
                    {
                    match("canton"); 


                    }
                    break;
                case 4 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:466:5: 'flaunches'
                    {
                    match("flaunches"); 


                    }
                    break;
                case 5 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:467:5: 'bordure'
                    {
                    match("bordure"); 


                    }
                    break;
                case 6 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:468:5: 'orle'
                    {
                    match("orle"); 


                    }
                    break;
                case 7 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:469:5: 'tressure'
                    {
                    match("tressure"); 


                    }
                    break;
                case 8 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:470:5: 'gyron'
                    {
                    match("gyron"); 


                    }
                    break;
                case 9 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:471:5: 'fret'
                    {
                    match("fret"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SUBORDINARY"

    // $ANTLR start "VARIABLE_DIV"
    public final void mVARIABLE_DIV() throws RecognitionException {
        try {
            int _type = VARIABLE_DIV;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:475:3: ( 'gyronny' | 'barry' | 'paly' | 'bendy' | 'chevronny' )
            int alt5=5;
            switch ( input.LA(1) ) {
            case 'g':
                {
                alt5=1;
                }
                break;
            case 'b':
                {
                int LA5_2 = input.LA(2);

                if ( (LA5_2=='a') ) {
                    alt5=2;
                }
                else if ( (LA5_2=='e') ) {
                    alt5=4;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 2, input);

                    throw nvae;
                }
                }
                break;
            case 'p':
                {
                alt5=3;
                }
                break;
            case 'c':
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
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:476:3: 'gyronny'
                    {
                    match("gyronny"); 


                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:477:5: 'barry'
                    {
                    match("barry"); 


                    }
                    break;
                case 3 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:478:5: 'paly'
                    {
                    match("paly"); 


                    }
                    break;
                case 4 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:479:5: 'bendy'
                    {
                    match("bendy"); 


                    }
                    break;
                case 5 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:480:5: 'chevronny'
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

    // $ANTLR start "SUBORDINARY_MULTIPLE"
    public final void mSUBORDINARY_MULTIPLE() throws RecognitionException {
        try {
            int _type = SUBORDINARY_MULTIPLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:484:3: ( ( 'bar' | 'bendlet' | 'pallet' | 'chevronel' ) ( 's' )? )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:485:3: ( 'bar' | 'bendlet' | 'pallet' | 'chevronel' ) ( 's' )?
            {
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:485:3: ( 'bar' | 'bendlet' | 'pallet' | 'chevronel' )
            int alt6=4;
            switch ( input.LA(1) ) {
            case 'b':
                {
                int LA6_1 = input.LA(2);

                if ( (LA6_1=='a') ) {
                    alt6=1;
                }
                else if ( (LA6_1=='e') ) {
                    alt6=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 1, input);

                    throw nvae;
                }
                }
                break;
            case 'p':
                {
                alt6=3;
                }
                break;
            case 'c':
                {
                alt6=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:486:5: 'bar'
                    {
                    match("bar"); 


                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:487:7: 'bendlet'
                    {
                    match("bendlet"); 


                    }
                    break;
                case 3 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:488:7: 'pallet'
                    {
                    match("pallet"); 


                    }
                    break;
                case 4 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:489:7: 'chevronel'
                    {
                    match("chevronel"); 


                    }
                    break;

            }

            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:491:3: ( 's' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='s') ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:491:3: 's'
                    {
                    match('s'); 

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
    // $ANTLR end "SUBORDINARY_MULTIPLE"

    // $ANTLR start "MOBILE_CHARGE"
    public final void mMOBILE_CHARGE() throws RecognitionException {
        try {
            int _type = MOBILE_CHARGE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:495:3: ( ( ( 'in' )? 'escutcheon' | 'billet' | 'lozenge' | 'mascle' | 'fusil' | 'rustre' | 'roundel' | 'annulet' | 'mullet' | 'star' ) ( 's' )? )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:496:3: ( ( 'in' )? 'escutcheon' | 'billet' | 'lozenge' | 'mascle' | 'fusil' | 'rustre' | 'roundel' | 'annulet' | 'mullet' | 'star' ) ( 's' )?
            {
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:496:3: ( ( 'in' )? 'escutcheon' | 'billet' | 'lozenge' | 'mascle' | 'fusil' | 'rustre' | 'roundel' | 'annulet' | 'mullet' | 'star' )
            int alt9=10;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:497:5: ( 'in' )? 'escutcheon'
                    {
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:497:5: ( 'in' )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0=='i') ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:497:5: 'in'
                            {
                            match("in"); 


                            }
                            break;

                    }

                    match("escutcheon"); 


                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:498:7: 'billet'
                    {
                    match("billet"); 


                    }
                    break;
                case 3 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:499:7: 'lozenge'
                    {
                    match("lozenge"); 


                    }
                    break;
                case 4 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:500:7: 'mascle'
                    {
                    match("mascle"); 


                    }
                    break;
                case 5 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:501:7: 'fusil'
                    {
                    match("fusil"); 


                    }
                    break;
                case 6 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:502:7: 'rustre'
                    {
                    match("rustre"); 


                    }
                    break;
                case 7 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:503:7: 'roundel'
                    {
                    match("roundel"); 


                    }
                    break;
                case 8 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:504:7: 'annulet'
                    {
                    match("annulet"); 


                    }
                    break;
                case 9 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:505:7: 'mullet'
                    {
                    match("mullet"); 


                    }
                    break;
                case 10 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:506:7: 'star'
                    {
                    match("star"); 


                    }
                    break;

            }

            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:508:3: ( 's' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='s') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:508:3: 's'
                    {
                    match('s'); 

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
    // $ANTLR end "MOBILE_CHARGE"

    // $ANTLR start "BEAST"
    public final void mBEAST() throws RecognitionException {
        try {
            int _type = BEAST;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:512:3: ( ( 'lion' | 'dragon' | 'bear' | 'wolf' | 'stag' | 'leopard' | 'horse' | 'unicorn' ) ( 's' )? )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:513:3: ( 'lion' | 'dragon' | 'bear' | 'wolf' | 'stag' | 'leopard' | 'horse' | 'unicorn' ) ( 's' )?
            {
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:513:3: ( 'lion' | 'dragon' | 'bear' | 'wolf' | 'stag' | 'leopard' | 'horse' | 'unicorn' )
            int alt11=8;
            alt11 = dfa11.predict(input);
            switch (alt11) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:514:5: 'lion'
                    {
                    match("lion"); 


                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:515:7: 'dragon'
                    {
                    match("dragon"); 


                    }
                    break;
                case 3 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:516:6: 'bear'
                    {
                    match("bear"); 


                    }
                    break;
                case 4 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:517:6: 'wolf'
                    {
                    match("wolf"); 


                    }
                    break;
                case 5 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:518:6: 'stag'
                    {
                    match("stag"); 


                    }
                    break;
                case 6 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:519:6: 'leopard'
                    {
                    match("leopard"); 


                    }
                    break;
                case 7 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:520:5: 'horse'
                    {
                    match("horse"); 


                    }
                    break;
                case 8 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:521:6: 'unicorn'
                    {
                    match("unicorn"); 


                    }
                    break;

            }

            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:523:3: ( 's' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='s') ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:523:3: 's'
                    {
                    match('s'); 

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
    // $ANTLR end "BEAST"

    // $ANTLR start "FLYING_BEAST"
    public final void mFLYING_BEAST() throws RecognitionException {
        try {
            int _type = FLYING_BEAST;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:527:3: ( ( 'owl' | 'peacock' | 'bee' ) ( 's' )? )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:528:3: ( 'owl' | 'peacock' | 'bee' ) ( 's' )?
            {
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:528:3: ( 'owl' | 'peacock' | 'bee' )
            int alt13=3;
            switch ( input.LA(1) ) {
            case 'o':
                {
                alt13=1;
                }
                break;
            case 'p':
                {
                alt13=2;
                }
                break;
            case 'b':
                {
                alt13=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:529:5: 'owl'
                    {
                    match("owl"); 


                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:530:7: 'peacock'
                    {
                    match("peacock"); 


                    }
                    break;
                case 3 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:531:7: 'bee'
                    {
                    match("bee"); 


                    }
                    break;

            }

            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:533:3: ( 's' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0=='s') ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:533:3: 's'
                    {
                    match('s'); 

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
    // $ANTLR end "FLYING_BEAST"

    // $ANTLR start "ATTITUDE"
    public final void mATTITUDE() throws RecognitionException {
        try {
            int _type = ATTITUDE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:537:3: ( 'rampant' | 'sejant' | 'passant' )
            int alt15=3;
            switch ( input.LA(1) ) {
            case 'r':
                {
                alt15=1;
                }
                break;
            case 's':
                {
                alt15=2;
                }
                break;
            case 'p':
                {
                alt15=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:538:3: 'rampant'
                    {
                    match("rampant"); 


                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:539:5: 'sejant'
                    {
                    match("sejant"); 


                    }
                    break;
                case 3 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:540:5: 'passant'
                    {
                    match("passant"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ATTITUDE"

    // $ANTLR start "FLYING_ATTITUDE"
    public final void mFLYING_ATTITUDE() throws RecognitionException {
        try {
            int _type = FLYING_ATTITUDE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:544:3: ( 'volant' | 'displayed' | 'trussed' )
            int alt16=3;
            switch ( input.LA(1) ) {
            case 'v':
                {
                alt16=1;
                }
                break;
            case 'd':
                {
                alt16=2;
                }
                break;
            case 't':
                {
                alt16=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:545:3: 'volant'
                    {
                    match("volant"); 


                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:546:5: 'displayed'
                    {
                    match("displayed"); 


                    }
                    break;
                case 3 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:547:5: 'trussed'
                    {
                    match("trussed"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FLYING_ATTITUDE"

    // $ANTLR start "ATTITUDE_MODIFIER"
    public final void mATTITUDE_MODIFIER() throws RecognitionException {
        try {
            int _type = ATTITUDE_MODIFIER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:551:3: ( 'guardant' | 'reguardant' | 'affronty' )
            int alt17=3;
            switch ( input.LA(1) ) {
            case 'g':
                {
                alt17=1;
                }
                break;
            case 'r':
                {
                alt17=2;
                }
                break;
            case 'a':
                {
                alt17=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:552:3: 'guardant'
                    {
                    match("guardant"); 


                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:553:5: 'reguardant'
                    {
                    match("reguardant"); 


                    }
                    break;
                case 3 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:554:5: 'affronty'
                    {
                    match("affronty"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ATTITUDE_MODIFIER"

    // $ANTLR start "BODY_PART"
    public final void mBODY_PART() throws RecognitionException {
        try {
            int _type = BODY_PART;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:558:3: ( 'langued' | 'eyed' | 'armed' )
            int alt18=3;
            switch ( input.LA(1) ) {
            case 'l':
                {
                alt18=1;
                }
                break;
            case 'e':
                {
                alt18=2;
                }
                break;
            case 'a':
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
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:559:3: 'langued'
                    {
                    match("langued"); 


                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:560:5: 'eyed'
                    {
                    match("eyed"); 


                    }
                    break;
                case 3 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:561:5: 'armed'
                    {
                    match("armed"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BODY_PART"

    // $ANTLR start "CONTINUOUS_DIV"
    public final void mCONTINUOUS_DIV() throws RecognitionException {
        try {
            int _type = CONTINUOUS_DIV;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:565:3: ( 'chequy' | 'lozengy' )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0=='c') ) {
                alt19=1;
            }
            else if ( (LA19_0=='l') ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:566:3: 'chequy'
                    {
                    match("chequy"); 


                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:567:5: 'lozengy'
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
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:571:3: ( 'quarter' ( 'ed' | 'ly' ) )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:572:3: 'quarter' ( 'ed' | 'ly' )
            {
            match("quarter"); 

            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:573:3: ( 'ed' | 'ly' )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0=='e') ) {
                alt20=1;
            }
            else if ( (LA20_0=='l') ) {
                alt20=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:574:5: 'ed'
                    {
                    match("ed"); 


                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:575:7: 'ly'
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
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:580:3: ( ( 'part' ( 'ed' | 'y' ) ' ' )? 'per' )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:581:3: ( 'part' ( 'ed' | 'y' ) ' ' )? 'per'
            {
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:581:3: ( 'part' ( 'ed' | 'y' ) ' ' )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0=='p') ) {
                int LA22_1 = input.LA(2);

                if ( (LA22_1=='a') ) {
                    alt22=1;
                }
            }
            switch (alt22) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:582:5: 'part' ( 'ed' | 'y' ) ' '
                    {
                    match("part"); 

                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:583:5: ( 'ed' | 'y' )
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0=='e') ) {
                        alt21=1;
                    }
                    else if ( (LA21_0=='y') ) {
                        alt21=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 21, 0, input);

                        throw nvae;
                    }
                    switch (alt21) {
                        case 1 :
                            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:584:7: 'ed'
                            {
                            match("ed"); 


                            }
                            break;
                        case 2 :
                            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:585:9: 'y'
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

    // $ANTLR start "PROPER"
    public final void mPROPER() throws RecognitionException {
        try {
            int _type = PROPER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:593:3: ( 'proper' )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:594:3: 'proper'
            {
            match("proper"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PROPER"

    // $ANTLR start "COLOUR"
    public final void mCOLOUR() throws RecognitionException {
        try {
            int _type = COLOUR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:598:3: ( 'azure' | 'gules' | 'vert' | 'sable' | 'purpure' )
            int alt23=5;
            switch ( input.LA(1) ) {
            case 'a':
                {
                alt23=1;
                }
                break;
            case 'g':
                {
                alt23=2;
                }
                break;
            case 'v':
                {
                alt23=3;
                }
                break;
            case 's':
                {
                alt23=4;
                }
                break;
            case 'p':
                {
                alt23=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:599:3: 'azure'
                    {
                    match("azure"); 


                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:600:5: 'gules'
                    {
                    match("gules"); 


                    }
                    break;
                case 3 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:601:5: 'vert'
                    {
                    match("vert"); 


                    }
                    break;
                case 4 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:602:5: 'sable'
                    {
                    match("sable"); 


                    }
                    break;
                case 5 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:603:5: 'purpure'
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
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:607:3: ( 'or' | 'argent' )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0=='o') ) {
                alt24=1;
            }
            else if ( (LA24_0=='a') ) {
                alt24=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:608:3: 'or'
                    {
                    match("or"); 


                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:609:5: 'argent'
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
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:613:3: ( 'ermine' | 'ermines' | 'erminois' | 'pean' | 'vair' | 'counter-vair' | 'vair-en-pale' | 'vair-en-point' | 'potent' | 'counter-potent' | 'potent-en-pale' | 'potent-en-point' )
            int alt25=12;
            alt25 = dfa25.predict(input);
            switch (alt25) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:614:3: 'ermine'
                    {
                    match("ermine"); 


                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:615:5: 'ermines'
                    {
                    match("ermines"); 


                    }
                    break;
                case 3 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:616:5: 'erminois'
                    {
                    match("erminois"); 


                    }
                    break;
                case 4 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:617:5: 'pean'
                    {
                    match("pean"); 


                    }
                    break;
                case 5 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:618:5: 'vair'
                    {
                    match("vair"); 


                    }
                    break;
                case 6 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:619:5: 'counter-vair'
                    {
                    match("counter-vair"); 


                    }
                    break;
                case 7 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:620:5: 'vair-en-pale'
                    {
                    match("vair-en-pale"); 


                    }
                    break;
                case 8 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:621:5: 'vair-en-point'
                    {
                    match("vair-en-point"); 


                    }
                    break;
                case 9 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:622:5: 'potent'
                    {
                    match("potent"); 


                    }
                    break;
                case 10 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:623:5: 'counter-potent'
                    {
                    match("counter-potent"); 


                    }
                    break;
                case 11 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:624:5: 'potent-en-pale'
                    {
                    match("potent-en-pale"); 


                    }
                    break;
                case 12 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:625:5: 'potent-en-point'
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
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:629:3: ( ( '0' .. '9' )+ )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:630:3: ( '0' .. '9' )+
            {
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:630:3: ( '0' .. '9' )+
            int cnt26=0;
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( ((LA26_0>='0' && LA26_0<='9')) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:630:4: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt26 >= 1 ) break loop26;
                        EarlyExitException eee =
                            new EarlyExitException(26, input);
                        throw eee;
                }
                cnt26++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DIGITS"

    // $ANTLR start "NUMWORDS"
    public final void mNUMWORDS() throws RecognitionException {
        try {
            int _type = NUMWORDS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:634:3: ( 'one' | 'eleven' | 'two' | 'twelve' | 'three' | 'thirteen' | 'four' ( 'teen' )? | 'five' | 'fifteen' | 'six' ( 'teen' )? | 'seven' ( 'teen' )? | 'eight' ( 'een' )? | 'nine' ( 'teen' )? | 'twenty' | 'thirty' | 'fourty' | 'fifty' | 'sixty' | 'seventy' | 'eighty' | 'ninety' | 'hundred' | 'thousand' | 'million' | 'billion' )
            int alt32=25;
            alt32 = dfa32.predict(input);
            switch (alt32) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:635:3: 'one'
                    {
                    match("one"); 


                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:636:5: 'eleven'
                    {
                    match("eleven"); 


                    }
                    break;
                case 3 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:637:5: 'two'
                    {
                    match("two"); 


                    }
                    break;
                case 4 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:638:5: 'twelve'
                    {
                    match("twelve"); 


                    }
                    break;
                case 5 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:639:5: 'three'
                    {
                    match("three"); 


                    }
                    break;
                case 6 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:640:5: 'thirteen'
                    {
                    match("thirteen"); 


                    }
                    break;
                case 7 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:641:5: 'four' ( 'teen' )?
                    {
                    match("four"); 

                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:641:12: ( 'teen' )?
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0=='t') ) {
                        alt27=1;
                    }
                    switch (alt27) {
                        case 1 :
                            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:641:12: 'teen'
                            {
                            match("teen"); 


                            }
                            break;

                    }


                    }
                    break;
                case 8 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:642:5: 'five'
                    {
                    match("five"); 


                    }
                    break;
                case 9 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:643:5: 'fifteen'
                    {
                    match("fifteen"); 


                    }
                    break;
                case 10 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:644:5: 'six' ( 'teen' )?
                    {
                    match("six"); 

                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:644:11: ( 'teen' )?
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0=='t') ) {
                        alt28=1;
                    }
                    switch (alt28) {
                        case 1 :
                            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:644:11: 'teen'
                            {
                            match("teen"); 


                            }
                            break;

                    }


                    }
                    break;
                case 11 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:645:5: 'seven' ( 'teen' )?
                    {
                    match("seven"); 

                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:645:13: ( 'teen' )?
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0=='t') ) {
                        alt29=1;
                    }
                    switch (alt29) {
                        case 1 :
                            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:645:13: 'teen'
                            {
                            match("teen"); 


                            }
                            break;

                    }


                    }
                    break;
                case 12 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:646:5: 'eight' ( 'een' )?
                    {
                    match("eight"); 

                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:646:13: ( 'een' )?
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0=='e') ) {
                        alt30=1;
                    }
                    switch (alt30) {
                        case 1 :
                            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:646:13: 'een'
                            {
                            match("een"); 


                            }
                            break;

                    }


                    }
                    break;
                case 13 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:647:5: 'nine' ( 'teen' )?
                    {
                    match("nine"); 

                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:647:12: ( 'teen' )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0=='t') ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:647:12: 'teen'
                            {
                            match("teen"); 


                            }
                            break;

                    }


                    }
                    break;
                case 14 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:648:5: 'twenty'
                    {
                    match("twenty"); 


                    }
                    break;
                case 15 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:649:5: 'thirty'
                    {
                    match("thirty"); 


                    }
                    break;
                case 16 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:650:5: 'fourty'
                    {
                    match("fourty"); 


                    }
                    break;
                case 17 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:651:5: 'fifty'
                    {
                    match("fifty"); 


                    }
                    break;
                case 18 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:652:5: 'sixty'
                    {
                    match("sixty"); 


                    }
                    break;
                case 19 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:653:5: 'seventy'
                    {
                    match("seventy"); 


                    }
                    break;
                case 20 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:654:5: 'eighty'
                    {
                    match("eighty"); 


                    }
                    break;
                case 21 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:655:5: 'ninety'
                    {
                    match("ninety"); 


                    }
                    break;
                case 22 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:656:5: 'hundred'
                    {
                    match("hundred"); 


                    }
                    break;
                case 23 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:657:5: 'thousand'
                    {
                    match("thousand"); 


                    }
                    break;
                case 24 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:658:5: 'million'
                    {
                    match("million"); 


                    }
                    break;
                case 25 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:659:5: 'billion'
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

    // $ANTLR start "OF"
    public final void mOF() throws RecognitionException {
        try {
            int _type = OF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:663:3: ( 'of' )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:664:3: 'of'
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

    // $ANTLR start "AND"
    public final void mAND() throws RecognitionException {
        try {
            int _type = AND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:668:3: ( 'and' )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:669:3: 'and'
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

    // $ANTLR start "DETERMINER"
    public final void mDETERMINER() throws RecognitionException {
        try {
            int _type = DETERMINER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:673:3: ( 'a' | 'an' )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0=='a') ) {
                int LA33_1 = input.LA(2);

                if ( (LA33_1=='n') ) {
                    alt33=2;
                }
                else {
                    alt33=1;}
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }
            switch (alt33) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:674:3: 'a'
                    {
                    match('a'); 

                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:675:5: 'an'
                    {
                    match("an"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DETERMINER"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:679:3: ( ( ' ' | '\\t' )+ )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:680:3: ( ' ' | '\\t' )+
            {
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:680:3: ( ' ' | '\\t' )+
            int cnt34=0;
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0=='\t'||LA34_0==' ') ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:
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
            	    if ( cnt34 >= 1 ) break loop34;
                        EarlyExitException eee =
                            new EarlyExitException(34, input);
                        throw eee;
                }
                cnt34++;
            } while (true);


                _channel = HIDDEN;
               

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    public void mTokens() throws RecognitionException {
        // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:1:8: ( T__32 | MODIFIER | TIERCED | ORDINARY_DIV | SUBORDINARY_DIV | OTHER_ORDINARY | SUBORDINARY | VARIABLE_DIV | SUBORDINARY_MULTIPLE | MOBILE_CHARGE | BEAST | FLYING_BEAST | ATTITUDE | FLYING_ATTITUDE | ATTITUDE_MODIFIER | BODY_PART | CONTINUOUS_DIV | QUARTER | PARTYPER | PROPER | COLOUR | METAL | FUR | DIGITS | NUMWORDS | OF | AND | DETERMINER | WS )
        int alt35=29;
        alt35 = dfa35.predict(input);
        switch (alt35) {
            case 1 :
                // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:1:10: T__32
                {
                mT__32(); 

                }
                break;
            case 2 :
                // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:1:16: MODIFIER
                {
                mMODIFIER(); 

                }
                break;
            case 3 :
                // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:1:25: TIERCED
                {
                mTIERCED(); 

                }
                break;
            case 4 :
                // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:1:33: ORDINARY_DIV
                {
                mORDINARY_DIV(); 

                }
                break;
            case 5 :
                // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:1:46: SUBORDINARY_DIV
                {
                mSUBORDINARY_DIV(); 

                }
                break;
            case 6 :
                // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:1:62: OTHER_ORDINARY
                {
                mOTHER_ORDINARY(); 

                }
                break;
            case 7 :
                // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:1:77: SUBORDINARY
                {
                mSUBORDINARY(); 

                }
                break;
            case 8 :
                // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:1:89: VARIABLE_DIV
                {
                mVARIABLE_DIV(); 

                }
                break;
            case 9 :
                // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:1:102: SUBORDINARY_MULTIPLE
                {
                mSUBORDINARY_MULTIPLE(); 

                }
                break;
            case 10 :
                // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:1:123: MOBILE_CHARGE
                {
                mMOBILE_CHARGE(); 

                }
                break;
            case 11 :
                // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:1:137: BEAST
                {
                mBEAST(); 

                }
                break;
            case 12 :
                // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:1:143: FLYING_BEAST
                {
                mFLYING_BEAST(); 

                }
                break;
            case 13 :
                // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:1:156: ATTITUDE
                {
                mATTITUDE(); 

                }
                break;
            case 14 :
                // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:1:165: FLYING_ATTITUDE
                {
                mFLYING_ATTITUDE(); 

                }
                break;
            case 15 :
                // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:1:181: ATTITUDE_MODIFIER
                {
                mATTITUDE_MODIFIER(); 

                }
                break;
            case 16 :
                // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:1:199: BODY_PART
                {
                mBODY_PART(); 

                }
                break;
            case 17 :
                // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:1:209: CONTINUOUS_DIV
                {
                mCONTINUOUS_DIV(); 

                }
                break;
            case 18 :
                // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:1:224: QUARTER
                {
                mQUARTER(); 

                }
                break;
            case 19 :
                // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:1:232: PARTYPER
                {
                mPARTYPER(); 

                }
                break;
            case 20 :
                // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:1:241: PROPER
                {
                mPROPER(); 

                }
                break;
            case 21 :
                // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:1:248: COLOUR
                {
                mCOLOUR(); 

                }
                break;
            case 22 :
                // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:1:255: METAL
                {
                mMETAL(); 

                }
                break;
            case 23 :
                // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:1:261: FUR
                {
                mFUR(); 

                }
                break;
            case 24 :
                // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:1:265: DIGITS
                {
                mDIGITS(); 

                }
                break;
            case 25 :
                // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:1:272: NUMWORDS
                {
                mNUMWORDS(); 

                }
                break;
            case 26 :
                // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:1:281: OF
                {
                mOF(); 

                }
                break;
            case 27 :
                // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:1:284: AND
                {
                mAND(); 

                }
                break;
            case 28 :
                // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:1:288: DETERMINER
                {
                mDETERMINER(); 

                }
                break;
            case 29 :
                // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:1:299: WS
                {
                mWS(); 

                }
                break;

        }

    }


    protected DFA4 dfa4 = new DFA4(this);
    protected DFA9 dfa9 = new DFA9(this);
    protected DFA11 dfa11 = new DFA11(this);
    protected DFA25 dfa25 = new DFA25(this);
    protected DFA32 dfa32 = new DFA32(this);
    protected DFA35 dfa35 = new DFA35(this);
    static final String DFA4_eotS =
        "\13\uffff";
    static final String DFA4_eofS =
        "\13\uffff";
    static final String DFA4_minS =
        "\1\142\3\uffff\1\154\6\uffff";
    static final String DFA4_maxS =
        "\1\164\3\uffff\1\162\6\uffff";
    static final String DFA4_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\uffff\1\5\1\6\1\7\1\10\1\4\1\11";
    static final String DFA4_specialS =
        "\13\uffff}>";
    static final String[] DFA4_transitionS = {
            "\1\5\1\3\2\uffff\1\4\1\10\7\uffff\1\6\1\1\1\2\2\uffff\1\7",
            "",
            "",
            "",
            "\1\11\5\uffff\1\12",
            "",
            "",
            "",
            "",
            "",
            ""
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
            return "461:1: SUBORDINARY : ( 'pile' | 'quarter' | 'canton' | 'flaunches' | 'bordure' | 'orle' | 'tressure' | 'gyron' | 'fret' );";
        }
    }
    static final String DFA9_eotS =
        "\15\uffff";
    static final String DFA9_eofS =
        "\15\uffff";
    static final String DFA9_minS =
        "\1\141\3\uffff\1\141\1\uffff\1\157\6\uffff";
    static final String DFA9_maxS =
        "\1\163\3\uffff\1\165\1\uffff\1\165\6\uffff";
    static final String DFA9_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\uffff\1\5\1\uffff\1\10\1\12\1\4\1\11\1\6"+
        "\1\7";
    static final String DFA9_specialS =
        "\15\uffff}>";
    static final String[] DFA9_transitionS = {
            "\1\7\1\2\2\uffff\1\1\1\5\2\uffff\1\1\2\uffff\1\3\1\4\4\uffff"+
            "\1\6\1\10",
            "",
            "",
            "",
            "\1\11\23\uffff\1\12",
            "",
            "\1\14\5\uffff\1\13",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
    static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
    static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
    static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
    static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
    static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
    static final short[][] DFA9_transition;

    static {
        int numStates = DFA9_transitionS.length;
        DFA9_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
        }
    }

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = DFA9_eot;
            this.eof = DFA9_eof;
            this.min = DFA9_min;
            this.max = DFA9_max;
            this.accept = DFA9_accept;
            this.special = DFA9_special;
            this.transition = DFA9_transition;
        }
        public String getDescription() {
            return "496:3: ( ( 'in' )? 'escutcheon' | 'billet' | 'lozenge' | 'mascle' | 'fusil' | 'rustre' | 'roundel' | 'annulet' | 'mullet' | 'star' )";
        }
    }
    static final String DFA11_eotS =
        "\12\uffff";
    static final String DFA11_eofS =
        "\12\uffff";
    static final String DFA11_minS =
        "\1\142\1\145\10\uffff";
    static final String DFA11_maxS =
        "\1\167\1\151\10\uffff";
    static final String DFA11_acceptS =
        "\2\uffff\1\2\1\3\1\4\1\5\1\7\1\10\1\1\1\6";
    static final String DFA11_specialS =
        "\12\uffff}>";
    static final String[] DFA11_transitionS = {
            "\1\3\1\uffff\1\2\3\uffff\1\6\3\uffff\1\1\6\uffff\1\5\1\uffff"+
            "\1\7\1\uffff\1\4",
            "\1\11\3\uffff\1\10",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA11_eot = DFA.unpackEncodedString(DFA11_eotS);
    static final short[] DFA11_eof = DFA.unpackEncodedString(DFA11_eofS);
    static final char[] DFA11_min = DFA.unpackEncodedStringToUnsignedChars(DFA11_minS);
    static final char[] DFA11_max = DFA.unpackEncodedStringToUnsignedChars(DFA11_maxS);
    static final short[] DFA11_accept = DFA.unpackEncodedString(DFA11_acceptS);
    static final short[] DFA11_special = DFA.unpackEncodedString(DFA11_specialS);
    static final short[][] DFA11_transition;

    static {
        int numStates = DFA11_transitionS.length;
        DFA11_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA11_transition[i] = DFA.unpackEncodedString(DFA11_transitionS[i]);
        }
    }

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = DFA11_eot;
            this.eof = DFA11_eof;
            this.min = DFA11_min;
            this.max = DFA11_max;
            this.accept = DFA11_accept;
            this.special = DFA11_special;
            this.transition = DFA11_transition;
        }
        public String getDescription() {
            return "513:3: ( 'lion' | 'dragon' | 'bear' | 'wolf' | 'stag' | 'leopard' | 'horse' | 'unicorn' )";
        }
    }
    static final String DFA25_eotS =
        "\20\uffff\1\25\6\uffff\1\35\1\uffff\1\37\25\uffff";
    static final String DFA25_eofS =
        "\57\uffff";
    static final String DFA25_minS =
        "\1\143\1\162\1\145\1\141\1\157\1\155\1\uffff\1\164\1\151\1\165\1"+
        "\151\1\145\1\162\3\156\1\55\1\164\1\145\1\164\1\145\1\uffff\1\145"+
        "\1\163\1\uffff\1\55\1\156\1\162\2\uffff\1\145\1\uffff\2\55\1\156"+
        "\2\160\1\55\1\141\2\uffff\1\160\2\uffff\1\141\2\uffff";
    static final String DFA25_maxS =
        "\1\166\1\162\1\157\1\141\1\157\1\155\1\uffff\1\164\1\151\1\165\1"+
        "\151\1\145\1\162\3\156\1\55\1\164\1\157\1\164\1\145\1\uffff\1\145"+
        "\1\163\1\uffff\1\55\1\156\1\162\2\uffff\1\145\1\uffff\2\55\1\156"+
        "\1\160\1\166\1\55\1\157\2\uffff\1\160\2\uffff\1\157\2\uffff";
    static final String DFA25_acceptS =
        "\6\uffff\1\4\16\uffff\1\5\2\uffff\1\3\3\uffff\1\2\1\1\1\uffff\1"+
        "\11\7\uffff\1\6\1\12\1\uffff\1\7\1\10\1\uffff\1\13\1\14";
    static final String DFA25_specialS =
        "\57\uffff}>";
    static final String[] DFA25_transitionS = {
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

    static final short[] DFA25_eot = DFA.unpackEncodedString(DFA25_eotS);
    static final short[] DFA25_eof = DFA.unpackEncodedString(DFA25_eofS);
    static final char[] DFA25_min = DFA.unpackEncodedStringToUnsignedChars(DFA25_minS);
    static final char[] DFA25_max = DFA.unpackEncodedStringToUnsignedChars(DFA25_maxS);
    static final short[] DFA25_accept = DFA.unpackEncodedString(DFA25_acceptS);
    static final short[] DFA25_special = DFA.unpackEncodedString(DFA25_specialS);
    static final short[][] DFA25_transition;

    static {
        int numStates = DFA25_transitionS.length;
        DFA25_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA25_transition[i] = DFA.unpackEncodedString(DFA25_transitionS[i]);
        }
    }

    class DFA25 extends DFA {

        public DFA25(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 25;
            this.eot = DFA25_eot;
            this.eof = DFA25_eof;
            this.min = DFA25_min;
            this.max = DFA25_max;
            this.accept = DFA25_accept;
            this.special = DFA25_special;
            this.transition = DFA25_transition;
        }
        public String getDescription() {
            return "612:1: FUR : ( 'ermine' | 'ermines' | 'erminois' | 'pean' | 'vair' | 'counter-vair' | 'vair-en-pale' | 'vair-en-point' | 'potent' | 'counter-potent' | 'potent-en-pale' | 'potent-en-point' );";
        }
    }
    static final String DFA32_eotS =
        "\34\uffff\1\46\6\uffff\1\54\4\uffff\1\62\1\64\6\uffff\1\71\13\uffff";
    static final String DFA32_eofS =
        "\74\uffff";
    static final String DFA32_minS =
        "\1\142\1\uffff\1\151\1\150\1\151\1\145\1\151\4\uffff\1\147\1\145"+
        "\1\151\1\165\1\146\1\170\1\166\1\156\1\150\1\uffff\1\154\1\uffff"+
        "\1\162\1\uffff\1\162\1\uffff\2\164\2\145\1\164\2\uffff\2\164\2\145"+
        "\1\uffff\1\156\1\164\1\171\2\145\4\uffff\1\164\1\145\6\uffff\1\145"+
        "\3\uffff";
    static final String DFA32_maxS =
        "\1\164\1\uffff\1\154\1\167\1\157\2\151\4\uffff\1\147\1\157\1\162"+
        "\1\165\1\166\1\170\1\166\1\156\1\150\1\uffff\1\156\1\uffff\1\162"+
        "\1\uffff\1\162\1\uffff\2\164\2\145\1\164\2\uffff\2\164\2\171\1\uffff"+
        "\1\156\1\164\3\171\4\uffff\1\164\1\171\6\uffff\1\171\3\uffff";
    static final String DFA32_acceptS =
        "\1\uffff\1\1\5\uffff\1\26\1\30\1\31\1\2\11\uffff\1\3\1\uffff\1\5"+
        "\1\uffff\1\27\1\uffff\1\10\5\uffff\1\4\1\16\4\uffff\1\12\5\uffff"+
        "\1\7\1\11\1\21\1\22\2\uffff\1\15\1\24\1\14\1\6\1\17\1\20\1\uffff"+
        "\1\13\1\25\1\23";
    static final String DFA32_specialS =
        "\74\uffff}>";
    static final String[] DFA32_transitionS = {
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

    static final short[] DFA32_eot = DFA.unpackEncodedString(DFA32_eotS);
    static final short[] DFA32_eof = DFA.unpackEncodedString(DFA32_eofS);
    static final char[] DFA32_min = DFA.unpackEncodedStringToUnsignedChars(DFA32_minS);
    static final char[] DFA32_max = DFA.unpackEncodedStringToUnsignedChars(DFA32_maxS);
    static final short[] DFA32_accept = DFA.unpackEncodedString(DFA32_acceptS);
    static final short[] DFA32_special = DFA.unpackEncodedString(DFA32_specialS);
    static final short[][] DFA32_transition;

    static {
        int numStates = DFA32_transitionS.length;
        DFA32_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA32_transition[i] = DFA.unpackEncodedString(DFA32_transitionS[i]);
        }
    }

    class DFA32 extends DFA {

        public DFA32(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 32;
            this.eot = DFA32_eot;
            this.eof = DFA32_eof;
            this.min = DFA32_min;
            this.max = DFA32_max;
            this.accept = DFA32_accept;
            this.special = DFA32_special;
            this.transition = DFA32_transition;
        }
        public String getDescription() {
            return "633:1: NUMWORDS : ( 'one' | 'eleven' | 'two' | 'twelve' | 'three' | 'thirteen' | 'four' ( 'teen' )? | 'five' | 'fifteen' | 'six' ( 'teen' )? | 'seven' ( 'teen' )? | 'eight' ( 'een' )? | 'nine' ( 'teen' )? | 'twenty' | 'thirty' | 'fourty' | 'fifty' | 'sixty' | 'seventy' | 'eighty' | 'ninety' | 'hundred' | 'thousand' | 'million' | 'billion' );";
        }
    }
    static final String DFA35_eotS =
        "\17\uffff\1\66\34\uffff\1\103\6\uffff\1\66\13\uffff\1\112\7\uffff"+
        "\1\121\1\uffff\1\46\12\uffff\1\31\4\uffff\1\46\1\31\1\uffff";
    static final String DFA35_eofS =
        "\134\uffff";
    static final String DFA35_minS =
        "\1\11\3\141\1\150\1\145\2\141\1\165\1\146\1\165\1\uffff\1\151\2"+
        "\141\1\146\1\151\1\uffff\1\157\1\141\4\uffff\1\154\1\uffff\1\141"+
        "\3\uffff\1\147\1\uffff\1\156\1\142\1\141\1\152\1\uffff\1\145\1\uffff"+
        "\1\141\1\162\1\154\1\145\1\141\1\154\2\uffff\1\162\1\141\1\uffff"+
        "\1\172\1\144\1\uffff\1\147\2\uffff\1\145\1\uffff\1\143\1\uffff\1"+
        "\147\1\144\1\uffff\1\162\1\154\1\161\1\162\1\uffff\1\157\1\145\1"+
        "\uffff\1\145\1\uffff\1\154\1\uffff\1\145\1\162\1\uffff\1\164\2\156"+
        "\1\uffff\1\157\1\145\1\156\1\147\1\156\1\162\3\145\1\uffff";
    static final String DFA35_maxS =
        "\1\167\2\165\1\164\1\167\1\165\1\157\1\162\1\165\1\167\1\171\1\uffff"+
        "\1\171\1\157\1\165\1\172\1\162\1\uffff\1\165\1\157\4\uffff\1\163"+
        "\1\uffff\1\162\3\uffff\1\166\1\uffff\1\170\1\154\1\141\1\166\1\uffff"+
        "\1\165\1\uffff\1\156\1\163\1\154\1\151\1\141\1\154\2\uffff\1\162"+
        "\1\154\1\uffff\1\172\1\156\1\uffff\1\155\2\uffff\1\171\1\uffff\1"+
        "\156\1\uffff\1\162\1\144\1\uffff\1\162\1\154\1\166\1\162\1\uffff"+
        "\1\157\1\145\1\uffff\1\145\1\uffff\1\171\1\uffff\1\151\1\162\1\uffff"+
        "\1\164\2\156\1\uffff\1\157\1\145\1\156\1\147\1\156\1\162\1\171\1"+
        "\156\1\154\1\uffff";
    static final String DFA35_acceptS =
        "\13\uffff\1\12\5\uffff\1\13\2\uffff\1\30\1\31\1\35\1\1\1\uffff\1"+
        "\7\1\uffff\1\24\1\25\1\27\1\uffff\1\15\4\uffff\1\3\1\uffff\1\4\6"+
        "\uffff\1\14\1\32\2\uffff\1\20\2\uffff\1\17\1\uffff\1\34\1\16\1\uffff"+
        "\1\23\1\uffff\1\2\2\uffff\1\6\4\uffff\1\26\2\uffff\1\33\1\uffff"+
        "\1\10\1\uffff\1\11\2\uffff\1\21\3\uffff\1\5\11\uffff\1\22";
    static final String DFA35_specialS =
        "\134\uffff}>";
    static final String[] DFA35_transitionS = {
            "\1\26\26\uffff\1\26\17\uffff\12\24\47\uffff\1\17\1\6\1\7\1\20"+
            "\1\14\1\5\1\12\1\22\1\13\2\uffff\1\15\1\16\1\25\1\11\1\1\1\10"+
            "\1\2\1\3\1\4\1\21\1\23\1\21",
            "\1\30\3\uffff\1\32\3\uffff\1\31\2\uffff\1\27\2\uffff\1\35\2"+
            "\uffff\1\33\2\uffff\1\34",
            "\1\37\3\uffff\1\36\11\uffff\1\13\5\uffff\1\13",
            "\1\41\3\uffff\1\43\3\uffff\1\40\12\uffff\1\42",
            "\1\25\1\44\10\uffff\1\45\4\uffff\1\25",
            "\1\46\3\uffff\1\25\2\uffff\1\31\2\uffff\1\25\2\uffff\1\31\2"+
            "\uffff\1\13",
            "\1\50\3\uffff\1\47\3\uffff\1\51\5\uffff\1\31",
            "\1\31\6\uffff\1\52\6\uffff\1\35\2\uffff\1\46",
            "\1\53",
            "\1\56\7\uffff\1\25\3\uffff\1\54\4\uffff\1\55",
            "\1\60\3\uffff\1\57",
            "",
            "\1\25\2\uffff\1\25\5\uffff\1\35\1\13\5\uffff\1\61",
            "\1\61\3\uffff\1\21\3\uffff\1\21\5\uffff\1\62",
            "\1\13\7\uffff\1\25\13\uffff\1\13",
            "\1\64\7\uffff\1\63\3\uffff\1\65\7\uffff\1\34",
            "\1\67\10\uffff\1\21",
            "",
            "\1\21\5\uffff\1\25",
            "\1\35\3\uffff\1\34\11\uffff\1\67",
            "",
            "",
            "",
            "",
            "\1\70\5\uffff\1\71\1\37",
            "",
            "\1\72\20\uffff\1\71",
            "",
            "",
            "",
            "\1\64\16\uffff\1\73",
            "",
            "\1\73\11\uffff\1\25",
            "\1\34\11\uffff\1\46",
            "\1\74",
            "\1\37\13\uffff\1\25",
            "",
            "\1\31\17\uffff\1\67",
            "",
            "\1\21\3\uffff\1\55\10\uffff\1\75",
            "\1\77\1\76",
            "\1\100",
            "\1\101\3\uffff\1\76",
            "\1\102",
            "\1\31",
            "",
            "",
            "\1\104",
            "\1\64\12\uffff\1\34",
            "",
            "\1\105",
            "\1\106\11\uffff\1\13",
            "",
            "\1\103\5\uffff\1\61",
            "",
            "",
            "\1\46\6\uffff\1\107\14\uffff\1\110",
            "",
            "\1\55\12\uffff\1\35",
            "",
            "\1\21\12\uffff\1\13",
            "\1\111",
            "",
            "\1\110",
            "\1\113",
            "\1\115\4\uffff\1\114",
            "\1\116",
            "",
            "\1\117",
            "\1\120",
            "",
            "\1\112",
            "",
            "\1\112\14\uffff\1\110",
            "",
            "\1\13\3\uffff\1\25",
            "\1\122",
            "",
            "\1\123",
            "\1\124",
            "\1\125",
            "",
            "\1\126",
            "\1\127",
            "\1\110",
            "\1\130",
            "\1\131",
            "\1\132",
            "\1\13\23\uffff\1\115",
            "\1\112\10\uffff\1\110",
            "\1\133\6\uffff\1\133",
            ""
    };

    static final short[] DFA35_eot = DFA.unpackEncodedString(DFA35_eotS);
    static final short[] DFA35_eof = DFA.unpackEncodedString(DFA35_eofS);
    static final char[] DFA35_min = DFA.unpackEncodedStringToUnsignedChars(DFA35_minS);
    static final char[] DFA35_max = DFA.unpackEncodedStringToUnsignedChars(DFA35_maxS);
    static final short[] DFA35_accept = DFA.unpackEncodedString(DFA35_acceptS);
    static final short[] DFA35_special = DFA.unpackEncodedString(DFA35_specialS);
    static final short[][] DFA35_transition;

    static {
        int numStates = DFA35_transitionS.length;
        DFA35_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA35_transition[i] = DFA.unpackEncodedString(DFA35_transitionS[i]);
        }
    }

    class DFA35 extends DFA {

        public DFA35(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 35;
            this.eot = DFA35_eot;
            this.eof = DFA35_eof;
            this.min = DFA35_min;
            this.max = DFA35_max;
            this.accept = DFA35_accept;
            this.special = DFA35_special;
            this.transition = DFA35_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__32 | MODIFIER | TIERCED | ORDINARY_DIV | SUBORDINARY_DIV | OTHER_ORDINARY | SUBORDINARY | VARIABLE_DIV | SUBORDINARY_MULTIPLE | MOBILE_CHARGE | BEAST | FLYING_BEAST | ATTITUDE | FLYING_ATTITUDE | ATTITUDE_MODIFIER | BODY_PART | CONTINUOUS_DIV | QUARTER | PARTYPER | PROPER | COLOUR | METAL | FUR | DIGITS | NUMWORDS | OF | AND | DETERMINER | WS );";
        }
    }
 

}