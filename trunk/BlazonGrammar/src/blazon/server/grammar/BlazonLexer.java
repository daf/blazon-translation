// $ANTLR 3.3 Nov 30, 2010 12:50:56 C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g 2012-03-22 14:50:03

package blazon.server.grammar;

import blazon.shared.shield.diagnostic.ShieldDiagnostic;
import blazon.shared.shield.diagnostic.ShieldDiagnostic.LogLevel;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class BlazonLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__35=35;
    public static final int DETERMINER=4;
    public static final int ORDINARY_DIV=5;
    public static final int OTHER_ORDINARY=6;
    public static final int SUBORDINARY_DIV=7;
    public static final int SUBORDINARY=8;
    public static final int MODIFIER=9;
    public static final int SUBORDINARY_MULTIPLE=10;
    public static final int MOBILE_CHARGE=11;
    public static final int BEAST=12;
    public static final int WINGED_BEAST=13;
    public static final int ATTITUDE=14;
    public static final int BIRD_FLYING_INSECT=15;
    public static final int FLYING_ATTITUDE=16;
    public static final int SWIMMING_BEAST=17;
    public static final int SWIMMING_ATTITUDE=18;
    public static final int ATTITUDE_MODIFIER=19;
    public static final int BODY_PART=20;
    public static final int AND=21;
    public static final int TIERCED=22;
    public static final int PARTYPER=23;
    public static final int VARIABLE_DIV=24;
    public static final int OF=25;
    public static final int CONTINUOUS_DIV=26;
    public static final int QUARTER=27;
    public static final int COLOUR=28;
    public static final int METAL=29;
    public static final int FUR=30;
    public static final int PROPER=31;
    public static final int DIGITS=32;
    public static final int NUMWORDS=33;
    public static final int WS=34;

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
    	     int currentPosition = re.charPositionInLine;
          char charAtCurrentPosition = input.substring(currentPosition, currentPosition).toCharArray()[0];
          int valueOfCharacter = Character.getNumericValue(charAtCurrentPosition);
          while (--currentPosition >= 0 && valueOfCharacter != -1) {
            input.seek(currentPosition);
            charAtCurrentPosition = input.substring(currentPosition, currentPosition).toCharArray()[0];
              valueOfCharacter = Character.getNumericValue(charAtCurrentPosition);
          }
          currentPosition++;
          currentPosition++;
          StringBuilder sb = new StringBuilder();
          sb.append("The application does not recognise the word '");
          do {
            input.seek(currentPosition);
            charAtCurrentPosition = input.substring(currentPosition, currentPosition).toCharArray()[0];
            sb.append(charAtCurrentPosition);
            valueOfCharacter = Character.getNumericValue(charAtCurrentPosition);
          } while (++currentPosition < input.size() && valueOfCharacter != -1);
          sb.append("'");
          diags.add(ShieldDiagnostic.build(LogLevel.ERROR, sb.toString()));
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
    public String getGrammarFileName() { return "C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g"; }

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:52:7: ( 'plain' )
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:52:9: 'plain'
            {
            match("plain"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "MODIFIER"
    public final void mMODIFIER() throws RecognitionException {
        try {
            int _type = MODIFIER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:501:3: ( 'reversed' | 'sinister' )
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
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:502:3: 'reversed'
                    {
                    match("reversed"); 


                    }
                    break;
                case 2 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:503:5: 'sinister'
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
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:507:3: ( 'tierced' )
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:508:3: 'tierced'
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
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:512:3: ( 'fess' | 'pale' | 'bend' | 'cross' | 'saltire' | 'chevron' )
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
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:513:3: 'fess'
                    {
                    match("fess"); 


                    }
                    break;
                case 2 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:514:5: 'pale'
                    {
                    match("pale"); 


                    }
                    break;
                case 3 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:515:5: 'bend'
                    {
                    match("bend"); 


                    }
                    break;
                case 4 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:516:5: 'cross'
                    {
                    match("cross"); 


                    }
                    break;
                case 5 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:517:5: 'saltire'
                    {
                    match("saltire"); 


                    }
                    break;
                case 6 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:518:5: 'chevron'
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
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:522:3: ( 'pall' )
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:523:3: 'pall'
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
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:527:3: ( 'chief' | 'base' )
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
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:528:3: 'chief'
                    {
                    match("chief"); 


                    }
                    break;
                case 2 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:529:5: 'base'
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
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:533:3: ( 'pile' | 'quarter' | 'canton' | 'flaunches' | 'bordure' | 'orle' | 'tressure' | 'gyron' | 'fret' )
            int alt4=9;
            alt4 = dfa4.predict(input);
            switch (alt4) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:534:3: 'pile'
                    {
                    match("pile"); 


                    }
                    break;
                case 2 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:535:5: 'quarter'
                    {
                    match("quarter"); 


                    }
                    break;
                case 3 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:536:5: 'canton'
                    {
                    match("canton"); 


                    }
                    break;
                case 4 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:537:5: 'flaunches'
                    {
                    match("flaunches"); 


                    }
                    break;
                case 5 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:538:5: 'bordure'
                    {
                    match("bordure"); 


                    }
                    break;
                case 6 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:539:5: 'orle'
                    {
                    match("orle"); 


                    }
                    break;
                case 7 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:540:5: 'tressure'
                    {
                    match("tressure"); 


                    }
                    break;
                case 8 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:541:5: 'gyron'
                    {
                    match("gyron"); 


                    }
                    break;
                case 9 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:542:5: 'fret'
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
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:546:3: ( 'gyronny' | 'barry' | 'paly' | 'bendy' | 'chevronny' )
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
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:547:3: 'gyronny'
                    {
                    match("gyronny"); 


                    }
                    break;
                case 2 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:548:5: 'barry'
                    {
                    match("barry"); 


                    }
                    break;
                case 3 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:549:5: 'paly'
                    {
                    match("paly"); 


                    }
                    break;
                case 4 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:550:5: 'bendy'
                    {
                    match("bendy"); 


                    }
                    break;
                case 5 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:551:5: 'chevronny'
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
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:555:3: ( ( 'bar' | 'bendlet' | 'pallet' | 'chevronel' ) ( 's' )? )
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:556:3: ( 'bar' | 'bendlet' | 'pallet' | 'chevronel' ) ( 's' )?
            {
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:556:3: ( 'bar' | 'bendlet' | 'pallet' | 'chevronel' )
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
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:557:5: 'bar'
                    {
                    match("bar"); 


                    }
                    break;
                case 2 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:558:7: 'bendlet'
                    {
                    match("bendlet"); 


                    }
                    break;
                case 3 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:559:7: 'pallet'
                    {
                    match("pallet"); 


                    }
                    break;
                case 4 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:560:7: 'chevronel'
                    {
                    match("chevronel"); 


                    }
                    break;

            }

            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:562:3: ( 's' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='s') ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:562:3: 's'
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
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:566:3: ( ( ( 'in' )? 'escutcheon' | 'billet' | 'lozenge' | 'mascle' | 'fusil' | 'rustre' | 'roundel' | 'annulet' | 'mullet' | 'star' ) ( 's' )? )
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:567:3: ( ( 'in' )? 'escutcheon' | 'billet' | 'lozenge' | 'mascle' | 'fusil' | 'rustre' | 'roundel' | 'annulet' | 'mullet' | 'star' ) ( 's' )?
            {
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:567:3: ( ( 'in' )? 'escutcheon' | 'billet' | 'lozenge' | 'mascle' | 'fusil' | 'rustre' | 'roundel' | 'annulet' | 'mullet' | 'star' )
            int alt9=10;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:568:5: ( 'in' )? 'escutcheon'
                    {
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:568:5: ( 'in' )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0=='i') ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:568:5: 'in'
                            {
                            match("in"); 


                            }
                            break;

                    }

                    match("escutcheon"); 


                    }
                    break;
                case 2 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:569:7: 'billet'
                    {
                    match("billet"); 


                    }
                    break;
                case 3 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:570:7: 'lozenge'
                    {
                    match("lozenge"); 


                    }
                    break;
                case 4 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:571:7: 'mascle'
                    {
                    match("mascle"); 


                    }
                    break;
                case 5 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:572:7: 'fusil'
                    {
                    match("fusil"); 


                    }
                    break;
                case 6 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:573:7: 'rustre'
                    {
                    match("rustre"); 


                    }
                    break;
                case 7 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:574:7: 'roundel'
                    {
                    match("roundel"); 


                    }
                    break;
                case 8 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:575:7: 'annulet'
                    {
                    match("annulet"); 


                    }
                    break;
                case 9 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:576:7: 'mullet'
                    {
                    match("mullet"); 


                    }
                    break;
                case 10 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:577:7: 'star'
                    {
                    match("star"); 


                    }
                    break;

            }

            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:579:3: ( 's' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='s') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:579:3: 's'
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
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:583:3: ( ( 'lion' | 'bear' | 'wolf' | 'stag' | 'leopard' | 'horse' | 'unicorn' ) ( 's' )? )
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:584:3: ( 'lion' | 'bear' | 'wolf' | 'stag' | 'leopard' | 'horse' | 'unicorn' ) ( 's' )?
            {
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:584:3: ( 'lion' | 'bear' | 'wolf' | 'stag' | 'leopard' | 'horse' | 'unicorn' )
            int alt11=7;
            switch ( input.LA(1) ) {
            case 'l':
                {
                int LA11_1 = input.LA(2);

                if ( (LA11_1=='i') ) {
                    alt11=1;
                }
                else if ( (LA11_1=='e') ) {
                    alt11=5;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 1, input);

                    throw nvae;
                }
                }
                break;
            case 'b':
                {
                alt11=2;
                }
                break;
            case 'w':
                {
                alt11=3;
                }
                break;
            case 's':
                {
                alt11=4;
                }
                break;
            case 'h':
                {
                alt11=6;
                }
                break;
            case 'u':
                {
                alt11=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:585:5: 'lion'
                    {
                    match("lion"); 


                    }
                    break;
                case 2 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:586:6: 'bear'
                    {
                    match("bear"); 


                    }
                    break;
                case 3 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:587:6: 'wolf'
                    {
                    match("wolf"); 


                    }
                    break;
                case 4 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:588:6: 'stag'
                    {
                    match("stag"); 


                    }
                    break;
                case 5 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:589:6: 'leopard'
                    {
                    match("leopard"); 


                    }
                    break;
                case 6 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:590:5: 'horse'
                    {
                    match("horse"); 


                    }
                    break;
                case 7 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:591:6: 'unicorn'
                    {
                    match("unicorn"); 


                    }
                    break;

            }

            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:593:3: ( 's' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='s') ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:593:3: 's'
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

    // $ANTLR start "BIRD_FLYING_INSECT"
    public final void mBIRD_FLYING_INSECT() throws RecognitionException {
        try {
            int _type = BIRD_FLYING_INSECT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:597:3: ( ( 'owl' | 'peacock' | 'bee' ) ( 's' )? )
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:598:3: ( 'owl' | 'peacock' | 'bee' ) ( 's' )?
            {
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:598:3: ( 'owl' | 'peacock' | 'bee' )
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
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:599:5: 'owl'
                    {
                    match("owl"); 


                    }
                    break;
                case 2 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:600:7: 'peacock'
                    {
                    match("peacock"); 


                    }
                    break;
                case 3 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:601:7: 'bee'
                    {
                    match("bee"); 


                    }
                    break;

            }

            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:603:3: ( 's' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0=='s') ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:603:3: 's'
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
    // $ANTLR end "BIRD_FLYING_INSECT"

    // $ANTLR start "WINGED_BEAST"
    public final void mWINGED_BEAST() throws RecognitionException {
        try {
            int _type = WINGED_BEAST;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:607:3: ( ( 'griffin' | 'dragon' ) ( 's' )? )
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:608:3: ( 'griffin' | 'dragon' ) ( 's' )?
            {
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:608:3: ( 'griffin' | 'dragon' )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0=='g') ) {
                alt15=1;
            }
            else if ( (LA15_0=='d') ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:609:5: 'griffin'
                    {
                    match("griffin"); 


                    }
                    break;
                case 2 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:610:7: 'dragon'
                    {
                    match("dragon"); 


                    }
                    break;

            }

            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:612:3: ( 's' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0=='s') ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:612:3: 's'
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
    // $ANTLR end "WINGED_BEAST"

    // $ANTLR start "SWIMMING_BEAST"
    public final void mSWIMMING_BEAST() throws RecognitionException {
        try {
            int _type = SWIMMING_BEAST;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:616:3: ( ( 'fish' | 'dolphin' ) ( 's' )? )
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:617:3: ( 'fish' | 'dolphin' ) ( 's' )?
            {
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:617:3: ( 'fish' | 'dolphin' )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0=='f') ) {
                alt17=1;
            }
            else if ( (LA17_0=='d') ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:618:4: 'fish'
                    {
                    match("fish"); 


                    }
                    break;
                case 2 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:619:6: 'dolphin'
                    {
                    match("dolphin"); 


                    }
                    break;

            }

            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:621:3: ( 's' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0=='s') ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:621:3: 's'
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
    // $ANTLR end "SWIMMING_BEAST"

    // $ANTLR start "ATTITUDE"
    public final void mATTITUDE() throws RecognitionException {
        try {
            int _type = ATTITUDE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:625:3: ( 'rampant' | 'sejant' | 'passant' | 'couchant' | 'courant' | 'dormant' | 'salient' | 'statant' )
            int alt19=8;
            alt19 = dfa19.predict(input);
            switch (alt19) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:626:3: 'rampant'
                    {
                    match("rampant"); 


                    }
                    break;
                case 2 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:627:5: 'sejant'
                    {
                    match("sejant"); 


                    }
                    break;
                case 3 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:628:5: 'passant'
                    {
                    match("passant"); 


                    }
                    break;
                case 4 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:629:5: 'couchant'
                    {
                    match("couchant"); 


                    }
                    break;
                case 5 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:630:5: 'courant'
                    {
                    match("courant"); 


                    }
                    break;
                case 6 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:631:5: 'dormant'
                    {
                    match("dormant"); 


                    }
                    break;
                case 7 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:632:5: 'salient'
                    {
                    match("salient"); 


                    }
                    break;
                case 8 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:633:5: 'statant'
                    {
                    match("statant"); 


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
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:637:3: ( 'volant' | 'displayed' | 'trussed' | 'rising' | 'vigilant' )
            int alt20=5;
            switch ( input.LA(1) ) {
            case 'v':
                {
                int LA20_1 = input.LA(2);

                if ( (LA20_1=='o') ) {
                    alt20=1;
                }
                else if ( (LA20_1=='i') ) {
                    alt20=5;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 20, 1, input);

                    throw nvae;
                }
                }
                break;
            case 'd':
                {
                alt20=2;
                }
                break;
            case 't':
                {
                alt20=3;
                }
                break;
            case 'r':
                {
                alt20=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:638:3: 'volant'
                    {
                    match("volant"); 


                    }
                    break;
                case 2 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:639:5: 'displayed'
                    {
                    match("displayed"); 


                    }
                    break;
                case 3 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:640:5: 'trussed'
                    {
                    match("trussed"); 


                    }
                    break;
                case 4 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:641:5: 'rising'
                    {
                    match("rising"); 


                    }
                    break;
                case 5 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:642:5: 'vigilant'
                    {
                    match("vigilant"); 


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

    // $ANTLR start "SWIMMING_ATTITUDE"
    public final void mSWIMMING_ATTITUDE() throws RecognitionException {
        try {
            int _type = SWIMMING_ATTITUDE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:646:3: ( 'naiant' | 'hauriant' )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0=='n') ) {
                alt21=1;
            }
            else if ( (LA21_0=='h') ) {
                alt21=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:647:5: 'naiant'
                    {
                    match("naiant"); 


                    }
                    break;
                case 2 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:648:5: 'hauriant'
                    {
                    match("hauriant"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SWIMMING_ATTITUDE"

    // $ANTLR start "ATTITUDE_MODIFIER"
    public final void mATTITUDE_MODIFIER() throws RecognitionException {
        try {
            int _type = ATTITUDE_MODIFIER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:652:3: ( 'guardant' | 'reguardant' | 'affronty' )
            int alt22=3;
            switch ( input.LA(1) ) {
            case 'g':
                {
                alt22=1;
                }
                break;
            case 'r':
                {
                alt22=2;
                }
                break;
            case 'a':
                {
                alt22=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:653:3: 'guardant'
                    {
                    match("guardant"); 


                    }
                    break;
                case 2 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:654:5: 'reguardant'
                    {
                    match("reguardant"); 


                    }
                    break;
                case 3 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:655:5: 'affronty'
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
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:659:3: ( 'langued' | 'eyed' | 'armed' )
            int alt23=3;
            switch ( input.LA(1) ) {
            case 'l':
                {
                alt23=1;
                }
                break;
            case 'e':
                {
                alt23=2;
                }
                break;
            case 'a':
                {
                alt23=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:660:3: 'langued'
                    {
                    match("langued"); 


                    }
                    break;
                case 2 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:661:5: 'eyed'
                    {
                    match("eyed"); 


                    }
                    break;
                case 3 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:662:5: 'armed'
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
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:666:3: ( 'chequy' | 'lozengy' )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0=='c') ) {
                alt24=1;
            }
            else if ( (LA24_0=='l') ) {
                alt24=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:667:3: 'chequy'
                    {
                    match("chequy"); 


                    }
                    break;
                case 2 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:668:5: 'lozengy'
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
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:672:3: ( 'quarter' ( 'ed' | 'ly' ) )
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:673:3: 'quarter' ( 'ed' | 'ly' )
            {
            match("quarter"); 

            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:674:3: ( 'ed' | 'ly' )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0=='e') ) {
                alt25=1;
            }
            else if ( (LA25_0=='l') ) {
                alt25=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:675:5: 'ed'
                    {
                    match("ed"); 


                    }
                    break;
                case 2 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:676:7: 'ly'
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
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:681:3: ( ( 'part' ( 'ed' | 'y' ) ' ' )? 'per' )
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:682:3: ( 'part' ( 'ed' | 'y' ) ' ' )? 'per'
            {
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:682:3: ( 'part' ( 'ed' | 'y' ) ' ' )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0=='p') ) {
                int LA27_1 = input.LA(2);

                if ( (LA27_1=='a') ) {
                    alt27=1;
                }
            }
            switch (alt27) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:683:5: 'part' ( 'ed' | 'y' ) ' '
                    {
                    match("part"); 

                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:684:5: ( 'ed' | 'y' )
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0=='e') ) {
                        alt26=1;
                    }
                    else if ( (LA26_0=='y') ) {
                        alt26=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 26, 0, input);

                        throw nvae;
                    }
                    switch (alt26) {
                        case 1 :
                            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:685:7: 'ed'
                            {
                            match("ed"); 


                            }
                            break;
                        case 2 :
                            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:686:9: 'y'
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
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:694:3: ( 'proper' )
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:695:3: 'proper'
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
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:699:3: ( 'azure' | 'gules' | 'vert' | 'sable' | 'purpure' )
            int alt28=5;
            switch ( input.LA(1) ) {
            case 'a':
                {
                alt28=1;
                }
                break;
            case 'g':
                {
                alt28=2;
                }
                break;
            case 'v':
                {
                alt28=3;
                }
                break;
            case 's':
                {
                alt28=4;
                }
                break;
            case 'p':
                {
                alt28=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:700:3: 'azure'
                    {
                    match("azure"); 


                    }
                    break;
                case 2 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:701:5: 'gules'
                    {
                    match("gules"); 


                    }
                    break;
                case 3 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:702:5: 'vert'
                    {
                    match("vert"); 


                    }
                    break;
                case 4 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:703:5: 'sable'
                    {
                    match("sable"); 


                    }
                    break;
                case 5 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:704:5: 'purpure'
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
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:708:3: ( 'or' | 'argent' )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0=='o') ) {
                alt29=1;
            }
            else if ( (LA29_0=='a') ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:709:3: 'or'
                    {
                    match("or"); 


                    }
                    break;
                case 2 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:710:5: 'argent'
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
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:714:3: ( 'ermine' | 'ermines' | 'erminois' | 'pean' | 'vair' | 'counter-vair' | 'vair-en-pale' | 'vair-en-point' | 'potent' | 'counter-potent' | 'potent-en-pale' | 'potent-en-point' )
            int alt30=12;
            alt30 = dfa30.predict(input);
            switch (alt30) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:715:3: 'ermine'
                    {
                    match("ermine"); 


                    }
                    break;
                case 2 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:716:5: 'ermines'
                    {
                    match("ermines"); 


                    }
                    break;
                case 3 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:717:5: 'erminois'
                    {
                    match("erminois"); 


                    }
                    break;
                case 4 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:718:5: 'pean'
                    {
                    match("pean"); 


                    }
                    break;
                case 5 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:719:5: 'vair'
                    {
                    match("vair"); 


                    }
                    break;
                case 6 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:720:5: 'counter-vair'
                    {
                    match("counter-vair"); 


                    }
                    break;
                case 7 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:721:5: 'vair-en-pale'
                    {
                    match("vair-en-pale"); 


                    }
                    break;
                case 8 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:722:5: 'vair-en-point'
                    {
                    match("vair-en-point"); 


                    }
                    break;
                case 9 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:723:5: 'potent'
                    {
                    match("potent"); 


                    }
                    break;
                case 10 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:724:5: 'counter-potent'
                    {
                    match("counter-potent"); 


                    }
                    break;
                case 11 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:725:5: 'potent-en-pale'
                    {
                    match("potent-en-pale"); 


                    }
                    break;
                case 12 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:726:5: 'potent-en-point'
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
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:730:3: ( ( '0' .. '9' )+ )
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:731:3: ( '0' .. '9' )+
            {
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:731:3: ( '0' .. '9' )+
            int cnt31=0;
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( ((LA31_0>='0' && LA31_0<='9')) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:731:4: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt31 >= 1 ) break loop31;
                        EarlyExitException eee =
                            new EarlyExitException(31, input);
                        throw eee;
                }
                cnt31++;
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
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:735:3: ( 'one' | 'eleven' | 'two' | 'twelve' | 'three' | 'thirteen' | 'four' ( 'teen' )? | 'five' | 'fifteen' | 'six' ( 'teen' )? | 'seven' ( 'teen' )? | 'eight' ( 'een' )? | 'nine' ( 'teen' )? | 'twenty' | 'thirty' | 'fourty' | 'fifty' | 'sixty' | 'seventy' | 'eighty' | 'ninety' | 'hundred' | 'thousand' | 'million' | 'billion' )
            int alt37=25;
            alt37 = dfa37.predict(input);
            switch (alt37) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:736:3: 'one'
                    {
                    match("one"); 


                    }
                    break;
                case 2 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:737:5: 'eleven'
                    {
                    match("eleven"); 


                    }
                    break;
                case 3 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:738:5: 'two'
                    {
                    match("two"); 


                    }
                    break;
                case 4 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:739:5: 'twelve'
                    {
                    match("twelve"); 


                    }
                    break;
                case 5 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:740:5: 'three'
                    {
                    match("three"); 


                    }
                    break;
                case 6 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:741:5: 'thirteen'
                    {
                    match("thirteen"); 


                    }
                    break;
                case 7 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:742:5: 'four' ( 'teen' )?
                    {
                    match("four"); 

                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:742:12: ( 'teen' )?
                    int alt32=2;
                    int LA32_0 = input.LA(1);

                    if ( (LA32_0=='t') ) {
                        alt32=1;
                    }
                    switch (alt32) {
                        case 1 :
                            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:742:12: 'teen'
                            {
                            match("teen"); 


                            }
                            break;

                    }


                    }
                    break;
                case 8 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:743:5: 'five'
                    {
                    match("five"); 


                    }
                    break;
                case 9 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:744:5: 'fifteen'
                    {
                    match("fifteen"); 


                    }
                    break;
                case 10 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:745:5: 'six' ( 'teen' )?
                    {
                    match("six"); 

                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:745:11: ( 'teen' )?
                    int alt33=2;
                    int LA33_0 = input.LA(1);

                    if ( (LA33_0=='t') ) {
                        alt33=1;
                    }
                    switch (alt33) {
                        case 1 :
                            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:745:11: 'teen'
                            {
                            match("teen"); 


                            }
                            break;

                    }


                    }
                    break;
                case 11 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:746:5: 'seven' ( 'teen' )?
                    {
                    match("seven"); 

                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:746:13: ( 'teen' )?
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( (LA34_0=='t') ) {
                        alt34=1;
                    }
                    switch (alt34) {
                        case 1 :
                            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:746:13: 'teen'
                            {
                            match("teen"); 


                            }
                            break;

                    }


                    }
                    break;
                case 12 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:747:5: 'eight' ( 'een' )?
                    {
                    match("eight"); 

                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:747:13: ( 'een' )?
                    int alt35=2;
                    int LA35_0 = input.LA(1);

                    if ( (LA35_0=='e') ) {
                        alt35=1;
                    }
                    switch (alt35) {
                        case 1 :
                            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:747:13: 'een'
                            {
                            match("een"); 


                            }
                            break;

                    }


                    }
                    break;
                case 13 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:748:5: 'nine' ( 'teen' )?
                    {
                    match("nine"); 

                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:748:12: ( 'teen' )?
                    int alt36=2;
                    int LA36_0 = input.LA(1);

                    if ( (LA36_0=='t') ) {
                        alt36=1;
                    }
                    switch (alt36) {
                        case 1 :
                            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:748:12: 'teen'
                            {
                            match("teen"); 


                            }
                            break;

                    }


                    }
                    break;
                case 14 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:749:5: 'twenty'
                    {
                    match("twenty"); 


                    }
                    break;
                case 15 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:750:5: 'thirty'
                    {
                    match("thirty"); 


                    }
                    break;
                case 16 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:751:5: 'fourty'
                    {
                    match("fourty"); 


                    }
                    break;
                case 17 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:752:5: 'fifty'
                    {
                    match("fifty"); 


                    }
                    break;
                case 18 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:753:5: 'sixty'
                    {
                    match("sixty"); 


                    }
                    break;
                case 19 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:754:5: 'seventy'
                    {
                    match("seventy"); 


                    }
                    break;
                case 20 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:755:5: 'eighty'
                    {
                    match("eighty"); 


                    }
                    break;
                case 21 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:756:5: 'ninety'
                    {
                    match("ninety"); 


                    }
                    break;
                case 22 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:757:5: 'hundred'
                    {
                    match("hundred"); 


                    }
                    break;
                case 23 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:758:5: 'thousand'
                    {
                    match("thousand"); 


                    }
                    break;
                case 24 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:759:5: 'million'
                    {
                    match("million"); 


                    }
                    break;
                case 25 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:760:5: 'billion'
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
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:764:3: ( 'of' )
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:765:3: 'of'
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
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:769:3: ( 'and' )
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:770:3: 'and'
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
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:774:3: ( 'a' | 'an' )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0=='a') ) {
                int LA38_1 = input.LA(2);

                if ( (LA38_1=='n') ) {
                    alt38=2;
                }
                else {
                    alt38=1;}
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:775:3: 'a'
                    {
                    match('a'); 

                    }
                    break;
                case 2 :
                    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:776:5: 'an'
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
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:780:3: ( ( ' ' | '\\t' )+ )
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:781:3: ( ' ' | '\\t' )+
            {
            // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:781:3: ( ' ' | '\\t' )+
            int cnt39=0;
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0=='\t'||LA39_0==' ') ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:
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
            	    if ( cnt39 >= 1 ) break loop39;
                        EarlyExitException eee =
                            new EarlyExitException(39, input);
                        throw eee;
                }
                cnt39++;
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
        // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:1:8: ( T__35 | MODIFIER | TIERCED | ORDINARY_DIV | SUBORDINARY_DIV | OTHER_ORDINARY | SUBORDINARY | VARIABLE_DIV | SUBORDINARY_MULTIPLE | MOBILE_CHARGE | BEAST | BIRD_FLYING_INSECT | WINGED_BEAST | SWIMMING_BEAST | ATTITUDE | FLYING_ATTITUDE | SWIMMING_ATTITUDE | ATTITUDE_MODIFIER | BODY_PART | CONTINUOUS_DIV | QUARTER | PARTYPER | PROPER | COLOUR | METAL | FUR | DIGITS | NUMWORDS | OF | AND | DETERMINER | WS )
        int alt40=32;
        alt40 = dfa40.predict(input);
        switch (alt40) {
            case 1 :
                // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:1:10: T__35
                {
                mT__35(); 

                }
                break;
            case 2 :
                // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:1:16: MODIFIER
                {
                mMODIFIER(); 

                }
                break;
            case 3 :
                // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:1:25: TIERCED
                {
                mTIERCED(); 

                }
                break;
            case 4 :
                // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:1:33: ORDINARY_DIV
                {
                mORDINARY_DIV(); 

                }
                break;
            case 5 :
                // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:1:46: SUBORDINARY_DIV
                {
                mSUBORDINARY_DIV(); 

                }
                break;
            case 6 :
                // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:1:62: OTHER_ORDINARY
                {
                mOTHER_ORDINARY(); 

                }
                break;
            case 7 :
                // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:1:77: SUBORDINARY
                {
                mSUBORDINARY(); 

                }
                break;
            case 8 :
                // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:1:89: VARIABLE_DIV
                {
                mVARIABLE_DIV(); 

                }
                break;
            case 9 :
                // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:1:102: SUBORDINARY_MULTIPLE
                {
                mSUBORDINARY_MULTIPLE(); 

                }
                break;
            case 10 :
                // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:1:123: MOBILE_CHARGE
                {
                mMOBILE_CHARGE(); 

                }
                break;
            case 11 :
                // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:1:137: BEAST
                {
                mBEAST(); 

                }
                break;
            case 12 :
                // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:1:143: BIRD_FLYING_INSECT
                {
                mBIRD_FLYING_INSECT(); 

                }
                break;
            case 13 :
                // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:1:162: WINGED_BEAST
                {
                mWINGED_BEAST(); 

                }
                break;
            case 14 :
                // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:1:175: SWIMMING_BEAST
                {
                mSWIMMING_BEAST(); 

                }
                break;
            case 15 :
                // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:1:190: ATTITUDE
                {
                mATTITUDE(); 

                }
                break;
            case 16 :
                // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:1:199: FLYING_ATTITUDE
                {
                mFLYING_ATTITUDE(); 

                }
                break;
            case 17 :
                // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:1:215: SWIMMING_ATTITUDE
                {
                mSWIMMING_ATTITUDE(); 

                }
                break;
            case 18 :
                // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:1:233: ATTITUDE_MODIFIER
                {
                mATTITUDE_MODIFIER(); 

                }
                break;
            case 19 :
                // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:1:251: BODY_PART
                {
                mBODY_PART(); 

                }
                break;
            case 20 :
                // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:1:261: CONTINUOUS_DIV
                {
                mCONTINUOUS_DIV(); 

                }
                break;
            case 21 :
                // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:1:276: QUARTER
                {
                mQUARTER(); 

                }
                break;
            case 22 :
                // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:1:284: PARTYPER
                {
                mPARTYPER(); 

                }
                break;
            case 23 :
                // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:1:293: PROPER
                {
                mPROPER(); 

                }
                break;
            case 24 :
                // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:1:300: COLOUR
                {
                mCOLOUR(); 

                }
                break;
            case 25 :
                // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:1:307: METAL
                {
                mMETAL(); 

                }
                break;
            case 26 :
                // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:1:313: FUR
                {
                mFUR(); 

                }
                break;
            case 27 :
                // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:1:317: DIGITS
                {
                mDIGITS(); 

                }
                break;
            case 28 :
                // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:1:324: NUMWORDS
                {
                mNUMWORDS(); 

                }
                break;
            case 29 :
                // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:1:333: OF
                {
                mOF(); 

                }
                break;
            case 30 :
                // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:1:336: AND
                {
                mAND(); 

                }
                break;
            case 31 :
                // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:1:340: DETERMINER
                {
                mDETERMINER(); 

                }
                break;
            case 32 :
                // C:\\Users\\Luke\\Dropbox\\project\\workspace2\\BlazonGrammar\\grammar\\Blazon.g:1:351: WS
                {
                mWS(); 

                }
                break;

        }

    }


    protected DFA4 dfa4 = new DFA4(this);
    protected DFA9 dfa9 = new DFA9(this);
    protected DFA19 dfa19 = new DFA19(this);
    protected DFA30 dfa30 = new DFA30(this);
    protected DFA37 dfa37 = new DFA37(this);
    protected DFA40 dfa40 = new DFA40(this);
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
            return "532:1: SUBORDINARY : ( 'pile' | 'quarter' | 'canton' | 'flaunches' | 'bordure' | 'orle' | 'tressure' | 'gyron' | 'fret' );";
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
            return "567:3: ( ( 'in' )? 'escutcheon' | 'billet' | 'lozenge' | 'mascle' | 'fusil' | 'rustre' | 'roundel' | 'annulet' | 'mullet' | 'star' )";
        }
    }
    static final String DFA19_eotS =
        "\15\uffff";
    static final String DFA19_eofS =
        "\15\uffff";
    static final String DFA19_minS =
        "\1\143\1\uffff\1\141\1\uffff\1\157\4\uffff\1\165\1\143\2\uffff";
    static final String DFA19_maxS =
        "\1\163\1\uffff\1\164\1\uffff\1\157\4\uffff\1\165\1\162\2\uffff";
    static final String DFA19_acceptS =
        "\1\uffff\1\1\1\uffff\1\3\1\uffff\1\6\1\2\1\7\1\10\2\uffff\1\4\1"+
        "\5";
    static final String DFA19_specialS =
        "\15\uffff}>";
    static final String[] DFA19_transitionS = {
            "\1\4\1\5\13\uffff\1\3\1\uffff\1\1\1\2",
            "",
            "\1\7\3\uffff\1\6\16\uffff\1\10",
            "",
            "\1\11",
            "",
            "",
            "",
            "",
            "\1\12",
            "\1\13\16\uffff\1\14",
            "",
            ""
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
            return "624:1: ATTITUDE : ( 'rampant' | 'sejant' | 'passant' | 'couchant' | 'courant' | 'dormant' | 'salient' | 'statant' );";
        }
    }
    static final String DFA30_eotS =
        "\20\uffff\1\25\6\uffff\1\35\1\uffff\1\37\25\uffff";
    static final String DFA30_eofS =
        "\57\uffff";
    static final String DFA30_minS =
        "\1\143\1\162\1\145\1\141\1\157\1\155\1\uffff\1\164\1\151\1\165"+
        "\1\151\1\145\1\162\3\156\1\55\1\164\1\145\1\164\1\145\1\uffff\1"+
        "\145\1\163\1\uffff\1\55\1\156\1\162\2\uffff\1\145\1\uffff\2\55\1"+
        "\156\2\160\1\55\1\141\2\uffff\1\160\2\uffff\1\141\2\uffff";
    static final String DFA30_maxS =
        "\1\166\1\162\1\157\1\141\1\157\1\155\1\uffff\1\164\1\151\1\165"+
        "\1\151\1\145\1\162\3\156\1\55\1\164\1\157\1\164\1\145\1\uffff\1"+
        "\145\1\163\1\uffff\1\55\1\156\1\162\2\uffff\1\145\1\uffff\2\55\1"+
        "\156\1\160\1\166\1\55\1\157\2\uffff\1\160\2\uffff\1\157\2\uffff";
    static final String DFA30_acceptS =
        "\6\uffff\1\4\16\uffff\1\5\2\uffff\1\3\3\uffff\1\2\1\1\1\uffff\1"+
        "\11\7\uffff\1\6\1\12\1\uffff\1\7\1\10\1\uffff\1\13\1\14";
    static final String DFA30_specialS =
        "\57\uffff}>";
    static final String[] DFA30_transitionS = {
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

    static final short[] DFA30_eot = DFA.unpackEncodedString(DFA30_eotS);
    static final short[] DFA30_eof = DFA.unpackEncodedString(DFA30_eofS);
    static final char[] DFA30_min = DFA.unpackEncodedStringToUnsignedChars(DFA30_minS);
    static final char[] DFA30_max = DFA.unpackEncodedStringToUnsignedChars(DFA30_maxS);
    static final short[] DFA30_accept = DFA.unpackEncodedString(DFA30_acceptS);
    static final short[] DFA30_special = DFA.unpackEncodedString(DFA30_specialS);
    static final short[][] DFA30_transition;

    static {
        int numStates = DFA30_transitionS.length;
        DFA30_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA30_transition[i] = DFA.unpackEncodedString(DFA30_transitionS[i]);
        }
    }

    class DFA30 extends DFA {

        public DFA30(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 30;
            this.eot = DFA30_eot;
            this.eof = DFA30_eof;
            this.min = DFA30_min;
            this.max = DFA30_max;
            this.accept = DFA30_accept;
            this.special = DFA30_special;
            this.transition = DFA30_transition;
        }
        public String getDescription() {
            return "713:1: FUR : ( 'ermine' | 'ermines' | 'erminois' | 'pean' | 'vair' | 'counter-vair' | 'vair-en-pale' | 'vair-en-point' | 'potent' | 'counter-potent' | 'potent-en-pale' | 'potent-en-point' );";
        }
    }
    static final String DFA37_eotS =
        "\34\uffff\1\46\6\uffff\1\54\4\uffff\1\62\1\64\6\uffff\1\71\13\uffff";
    static final String DFA37_eofS =
        "\74\uffff";
    static final String DFA37_minS =
        "\1\142\1\uffff\1\151\1\150\1\151\1\145\1\151\4\uffff\1\147\1\145"+
        "\1\151\1\165\1\146\1\170\1\166\1\156\1\150\1\uffff\1\154\1\uffff"+
        "\1\162\1\uffff\1\162\1\uffff\2\164\2\145\1\164\2\uffff\2\164\2\145"+
        "\1\uffff\1\156\1\164\1\171\2\145\4\uffff\1\164\1\145\6\uffff\1\145"+
        "\3\uffff";
    static final String DFA37_maxS =
        "\1\164\1\uffff\1\154\1\167\1\157\2\151\4\uffff\1\147\1\157\1\162"+
        "\1\165\1\166\1\170\1\166\1\156\1\150\1\uffff\1\156\1\uffff\1\162"+
        "\1\uffff\1\162\1\uffff\2\164\2\145\1\164\2\uffff\2\164\2\171\1\uffff"+
        "\1\156\1\164\3\171\4\uffff\1\164\1\171\6\uffff\1\171\3\uffff";
    static final String DFA37_acceptS =
        "\1\uffff\1\1\5\uffff\1\26\1\30\1\31\1\2\11\uffff\1\3\1\uffff\1"+
        "\5\1\uffff\1\27\1\uffff\1\10\5\uffff\1\4\1\16\4\uffff\1\12\5\uffff"+
        "\1\7\1\11\1\21\1\22\2\uffff\1\15\1\24\1\14\1\6\1\17\1\20\1\uffff"+
        "\1\13\1\25\1\23";
    static final String DFA37_specialS =
        "\74\uffff}>";
    static final String[] DFA37_transitionS = {
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

    static final short[] DFA37_eot = DFA.unpackEncodedString(DFA37_eotS);
    static final short[] DFA37_eof = DFA.unpackEncodedString(DFA37_eofS);
    static final char[] DFA37_min = DFA.unpackEncodedStringToUnsignedChars(DFA37_minS);
    static final char[] DFA37_max = DFA.unpackEncodedStringToUnsignedChars(DFA37_maxS);
    static final short[] DFA37_accept = DFA.unpackEncodedString(DFA37_acceptS);
    static final short[] DFA37_special = DFA.unpackEncodedString(DFA37_specialS);
    static final short[][] DFA37_transition;

    static {
        int numStates = DFA37_transitionS.length;
        DFA37_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA37_transition[i] = DFA.unpackEncodedString(DFA37_transitionS[i]);
        }
    }

    class DFA37 extends DFA {

        public DFA37(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 37;
            this.eot = DFA37_eot;
            this.eof = DFA37_eof;
            this.min = DFA37_min;
            this.max = DFA37_max;
            this.accept = DFA37_accept;
            this.special = DFA37_special;
            this.transition = DFA37_transition;
        }
        public String getDescription() {
            return "734:1: NUMWORDS : ( 'one' | 'eleven' | 'two' | 'twelve' | 'three' | 'thirteen' | 'four' ( 'teen' )? | 'five' | 'fifteen' | 'six' ( 'teen' )? | 'seven' ( 'teen' )? | 'eight' ( 'een' )? | 'nine' ( 'teen' )? | 'twenty' | 'thirty' | 'fourty' | 'fifty' | 'sixty' | 'seventy' | 'eighty' | 'ninety' | 'hundred' | 'thousand' | 'million' | 'billion' );";
        }
    }
    static final String DFA40_eotS =
        "\17\uffff\1\73\40\uffff\1\114\7\uffff\1\73\16\uffff\1\123\10\uffff"+
        "\1\132\1\uffff\1\50\12\uffff\1\31\4\uffff\1\50\1\31\1\uffff";
    static final String DFA40_eofS =
        "\145\uffff";
    static final String DFA40_minS =
        "\1\11\3\141\1\150\1\145\2\141\1\165\1\146\1\162\1\uffff\1\151\2"+
        "\141\1\146\1\uffff\1\141\1\151\2\141\3\uffff\1\154\1\uffff\1\141"+
        "\3\uffff\1\147\2\uffff\1\156\1\142\1\141\1\152\1\uffff\1\145\2\uffff"+
        "\1\146\1\141\1\162\1\154\1\145\1\165\1\141\1\154\2\uffff\1\162\1"+
        "\uffff\1\141\1\uffff\1\172\1\144\1\uffff\1\147\2\uffff\1\154\1\145"+
        "\1\uffff\1\143\1\uffff\1\151\1\147\1\uffff\1\144\1\uffff\1\162\1"+
        "\154\1\161\1\143\1\162\1\uffff\1\157\1\145\1\uffff\1\145\1\uffff"+
        "\1\154\1\uffff\1\145\1\162\1\uffff\1\164\2\156\1\uffff\1\157\1\145"+
        "\1\156\1\147\1\156\1\162\3\145\1\uffff";
    static final String DFA40_maxS =
        "\1\167\2\165\1\164\1\167\1\165\1\157\1\162\1\165\1\167\1\171\1"+
        "\uffff\1\171\1\157\1\165\1\172\1\uffff\1\165\1\162\1\157\1\151\3"+
        "\uffff\1\163\1\uffff\1\162\3\uffff\1\166\2\uffff\1\170\1\154\1\141"+
        "\1\166\1\uffff\1\165\2\uffff\1\166\1\156\1\163\1\154\1\151\1\165"+
        "\1\141\1\154\2\uffff\1\162\1\uffff\1\154\1\uffff\1\172\1\156\1\uffff"+
        "\1\155\2\uffff\1\162\1\171\1\uffff\1\156\1\uffff\2\164\1\uffff\1"+
        "\144\1\uffff\1\162\1\154\1\166\2\162\1\uffff\1\157\1\145\1\uffff"+
        "\1\145\1\uffff\1\171\1\uffff\1\151\1\162\1\uffff\1\164\2\156\1\uffff"+
        "\1\157\1\145\1\156\1\147\1\156\1\162\1\171\1\156\1\154\1\uffff";
    static final String DFA40_acceptS =
        "\13\uffff\1\12\4\uffff\1\13\4\uffff\1\33\1\40\1\1\1\uffff\1\7\1"+
        "\uffff\1\27\1\30\1\32\1\uffff\1\17\1\20\4\uffff\1\3\1\uffff\1\34"+
        "\1\4\10\uffff\1\14\1\35\1\uffff\1\15\1\uffff\1\23\2\uffff\1\22\1"+
        "\uffff\1\37\1\21\2\uffff\1\26\1\uffff\1\2\2\uffff\1\16\1\uffff\1"+
        "\6\5\uffff\1\31\2\uffff\1\36\1\uffff\1\10\1\uffff\1\11\2\uffff\1"+
        "\24\3\uffff\1\5\11\uffff\1\25";
    static final String DFA40_specialS =
        "\145\uffff}>";
    static final String[] DFA40_transitionS = {
            "\1\26\26\uffff\1\26\17\uffff\12\25\47\uffff\1\17\1\6\1\7\1"+
            "\22\1\14\1\5\1\12\1\21\1\13\2\uffff\1\15\1\16\1\24\1\11\1\1"+
            "\1\10\1\2\1\3\1\4\1\20\1\23\1\20",
            "\1\30\3\uffff\1\32\3\uffff\1\31\2\uffff\1\27\2\uffff\1\35"+
            "\2\uffff\1\33\2\uffff\1\34",
            "\1\37\3\uffff\1\36\3\uffff\1\40\5\uffff\1\13\5\uffff\1\13",
            "\1\42\3\uffff\1\44\3\uffff\1\41\12\uffff\1\43",
            "\1\47\1\45\10\uffff\1\46\4\uffff\1\47",
            "\1\50\3\uffff\1\51\2\uffff\1\31\2\uffff\1\47\2\uffff\1\31"+
            "\2\uffff\1\13",
            "\1\53\3\uffff\1\52\3\uffff\1\54\5\uffff\1\31",
            "\1\31\6\uffff\1\55\6\uffff\1\56\2\uffff\1\50",
            "\1\57",
            "\1\62\7\uffff\1\47\3\uffff\1\60\4\uffff\1\61",
            "\1\64\2\uffff\1\65\3\uffff\1\63",
            "",
            "\1\47\2\uffff\1\47\5\uffff\1\35\1\13\5\uffff\1\66",
            "\1\66\3\uffff\1\20\3\uffff\1\20\5\uffff\1\67",
            "\1\13\7\uffff\1\47\13\uffff\1\13",
            "\1\71\7\uffff\1\70\3\uffff\1\72\7\uffff\1\34",
            "",
            "\1\74\15\uffff\1\20\5\uffff\1\47",
            "\1\40\5\uffff\1\75\2\uffff\1\64",
            "\1\35\3\uffff\1\34\3\uffff\1\40\5\uffff\1\40",
            "\1\74\7\uffff\1\47",
            "",
            "",
            "",
            "\1\76\5\uffff\1\77\1\37",
            "",
            "\1\100\20\uffff\1\77",
            "",
            "",
            "",
            "\1\71\16\uffff\1\101",
            "",
            "",
            "\1\101\11\uffff\1\47",
            "\1\34\11\uffff\1\102",
            "\1\103",
            "\1\37\13\uffff\1\47",
            "",
            "\1\31\17\uffff\1\40",
            "",
            "",
            "\1\47\14\uffff\1\104\2\uffff\1\47",
            "\1\20\3\uffff\1\61\10\uffff\1\105",
            "\1\107\1\106",
            "\1\110",
            "\1\111\3\uffff\1\106",
            "\1\112",
            "\1\113",
            "\1\31",
            "",
            "",
            "\1\115",
            "",
            "\1\71\12\uffff\1\34",
            "",
            "\1\116",
            "\1\117\11\uffff\1\13",
            "",
            "\1\114\5\uffff\1\66",
            "",
            "",
            "\1\104\5\uffff\1\37",
            "\1\50\6\uffff\1\120\14\uffff\1\121",
            "",
            "\1\61\12\uffff\1\35",
            "",
            "\1\37\12\uffff\1\50",
            "\1\20\12\uffff\1\13\1\uffff\1\37",
            "",
            "\1\122",
            "",
            "\1\121",
            "\1\124",
            "\1\126\4\uffff\1\125",
            "\1\37\12\uffff\1\35\3\uffff\1\37",
            "\1\127",
            "",
            "\1\130",
            "\1\131",
            "",
            "\1\123",
            "",
            "\1\123\14\uffff\1\121",
            "",
            "\1\13\3\uffff\1\47",
            "\1\133",
            "",
            "\1\134",
            "\1\135",
            "\1\136",
            "",
            "\1\137",
            "\1\140",
            "\1\121",
            "\1\141",
            "\1\142",
            "\1\143",
            "\1\13\23\uffff\1\126",
            "\1\123\10\uffff\1\121",
            "\1\144\6\uffff\1\144",
            ""
    };

    static final short[] DFA40_eot = DFA.unpackEncodedString(DFA40_eotS);
    static final short[] DFA40_eof = DFA.unpackEncodedString(DFA40_eofS);
    static final char[] DFA40_min = DFA.unpackEncodedStringToUnsignedChars(DFA40_minS);
    static final char[] DFA40_max = DFA.unpackEncodedStringToUnsignedChars(DFA40_maxS);
    static final short[] DFA40_accept = DFA.unpackEncodedString(DFA40_acceptS);
    static final short[] DFA40_special = DFA.unpackEncodedString(DFA40_specialS);
    static final short[][] DFA40_transition;

    static {
        int numStates = DFA40_transitionS.length;
        DFA40_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA40_transition[i] = DFA.unpackEncodedString(DFA40_transitionS[i]);
        }
    }

    class DFA40 extends DFA {

        public DFA40(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 40;
            this.eot = DFA40_eot;
            this.eof = DFA40_eof;
            this.min = DFA40_min;
            this.max = DFA40_max;
            this.accept = DFA40_accept;
            this.special = DFA40_special;
            this.transition = DFA40_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__35 | MODIFIER | TIERCED | ORDINARY_DIV | SUBORDINARY_DIV | OTHER_ORDINARY | SUBORDINARY | VARIABLE_DIV | SUBORDINARY_MULTIPLE | MOBILE_CHARGE | BEAST | BIRD_FLYING_INSECT | WINGED_BEAST | SWIMMING_BEAST | ATTITUDE | FLYING_ATTITUDE | SWIMMING_ATTITUDE | ATTITUDE_MODIFIER | BODY_PART | CONTINUOUS_DIV | QUARTER | PARTYPER | PROPER | COLOUR | METAL | FUR | DIGITS | NUMWORDS | OF | AND | DETERMINER | WS );";
        }
    }
 

}