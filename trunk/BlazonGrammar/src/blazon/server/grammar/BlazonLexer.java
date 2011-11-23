// $ANTLR 3.3 Nov 30, 2010 12:50:56 /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g 2011-11-23 15:07:54

package blazon.server.grammar;

import blazon.shared.shield.diagnostic.ShieldDiagnostic;
import blazon.shared.shield.diagnostic.ShieldDiagnostic.LogLevel;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class BlazonLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__25=25;
    public static final int DETERMINER=4;
    public static final int ORDINARY_DIV=5;
    public static final int OTHER_ORDINARY=6;
    public static final int SUBORDINARY_DIV=7;
    public static final int SUBORDINARY=8;
    public static final int MODIFIER=9;
    public static final int SUBORDINARY_MULTIPLE=10;
    public static final int MOBILE_CHARGE=11;
    public static final int TIERCED=12;
    public static final int PARTYPER=13;
    public static final int VARIABLE_DIV=14;
    public static final int OF=15;
    public static final int CONTINUOUS_DIV=16;
    public static final int QUARTER=17;
    public static final int AND=18;
    public static final int COLOUR=19;
    public static final int METAL=20;
    public static final int FUR=21;
    public static final int DIGITS=22;
    public static final int NUMWORDS=23;
    public static final int WS=24;

      
      public BlazonLexer(CharStream input, List<ShieldDiagnostic> diags) {
          this(input, new RecognizerSharedState(), diags);
      }
      
      public BlazonLexer(CharStream input, RecognizerSharedState state, List<ShieldDiagnostic> diags) {
          super(input,state);
          this.diags = diags;
      }
      
      private List<ShieldDiagnostic> diags;
      
      
      @Override
      public void recover(RecognitionException re) {
        diags.add(ShieldDiagnostic.build(LogLevel.ERROR, getErrorHeader(re) + ":" + getErrorMessage(re, getTokenNames())));
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

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:35:7: ( 'plain' )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:35:9: 'plain'
            {
            match("plain"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "MODIFIER"
    public final void mMODIFIER() throws RecognitionException {
        try {
            int _type = MODIFIER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:283:9: ( 'reversed' | 'sinister' )
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
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:283:13: 'reversed'
                    {
                    match("reversed"); 


                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:283:26: 'sinister'
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
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:287:9: ( 'tierced' )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:287:13: 'tierced'
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
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:291:9: ( 'fess' | 'pale' | 'bend' | 'cross' | 'saltire' | 'chevron' )
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
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:291:13: 'fess'
                    {
                    match("fess"); 


                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:291:22: 'pale'
                    {
                    match("pale"); 


                    }
                    break;
                case 3 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:291:31: 'bend'
                    {
                    match("bend"); 


                    }
                    break;
                case 4 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:291:40: 'cross'
                    {
                    match("cross"); 


                    }
                    break;
                case 5 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:291:50: 'saltire'
                    {
                    match("saltire"); 


                    }
                    break;
                case 6 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:291:62: 'chevron'
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
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:295:9: ( 'pall' )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:295:13: 'pall'
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
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:299:9: ( 'chief' | 'base' )
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
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:299:13: 'chief'
                    {
                    match("chief"); 


                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:299:23: 'base'
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
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:303:9: ( 'pile' | 'quarter' | 'canton' | 'flaunches' | 'bordure' | 'orle' | 'tressure' | 'gyron' | 'fret' )
            int alt4=9;
            alt4 = dfa4.predict(input);
            switch (alt4) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:303:13: 'pile'
                    {
                    match("pile"); 


                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:303:22: 'quarter'
                    {
                    match("quarter"); 


                    }
                    break;
                case 3 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:303:34: 'canton'
                    {
                    match("canton"); 


                    }
                    break;
                case 4 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:303:45: 'flaunches'
                    {
                    match("flaunches"); 


                    }
                    break;
                case 5 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:303:59: 'bordure'
                    {
                    match("bordure"); 


                    }
                    break;
                case 6 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:303:71: 'orle'
                    {
                    match("orle"); 


                    }
                    break;
                case 7 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:303:80: 'tressure'
                    {
                    match("tressure"); 


                    }
                    break;
                case 8 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:303:93: 'gyron'
                    {
                    match("gyron"); 


                    }
                    break;
                case 9 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:303:103: 'fret'
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
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:307:9: ( 'gyronny' | 'barry' | 'paly' | 'bendy' | 'chevronny' )
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
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:307:13: 'gyronny'
                    {
                    match("gyronny"); 


                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:307:25: 'barry'
                    {
                    match("barry"); 


                    }
                    break;
                case 3 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:307:35: 'paly'
                    {
                    match("paly"); 


                    }
                    break;
                case 4 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:307:44: 'bendy'
                    {
                    match("bendy"); 


                    }
                    break;
                case 5 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:307:54: 'chevronny'
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
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:311:9: ( ( 'bar' | 'bendlet' | 'pallet' | 'chevronel' ) ( 's' )? )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:311:13: ( 'bar' | 'bendlet' | 'pallet' | 'chevronel' ) ( 's' )?
            {
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:311:13: ( 'bar' | 'bendlet' | 'pallet' | 'chevronel' )
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
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:311:14: 'bar'
                    {
                    match("bar"); 


                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:311:20: 'bendlet'
                    {
                    match("bendlet"); 


                    }
                    break;
                case 3 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:311:30: 'pallet'
                    {
                    match("pallet"); 


                    }
                    break;
                case 4 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:311:39: 'chevronel'
                    {
                    match("chevronel"); 


                    }
                    break;

            }

            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:311:51: ( 's' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='s') ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:311:51: 's'
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
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:315:9: ( ( ( 'in' )? 'escutcheon' | 'billet' | 'lozenge' | 'mascle' | 'fusil' | 'rustre' | 'roundel' | 'annulet' | 'mullet' | 'star' ) ( 's' )? )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:315:13: ( ( 'in' )? 'escutcheon' | 'billet' | 'lozenge' | 'mascle' | 'fusil' | 'rustre' | 'roundel' | 'annulet' | 'mullet' | 'star' ) ( 's' )?
            {
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:315:13: ( ( 'in' )? 'escutcheon' | 'billet' | 'lozenge' | 'mascle' | 'fusil' | 'rustre' | 'roundel' | 'annulet' | 'mullet' | 'star' )
            int alt9=10;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:315:14: ( 'in' )? 'escutcheon'
                    {
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:315:14: ( 'in' )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0=='i') ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:315:14: 'in'
                            {
                            match("in"); 


                            }
                            break;

                    }

                    match("escutcheon"); 


                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:315:34: 'billet'
                    {
                    match("billet"); 


                    }
                    break;
                case 3 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:315:45: 'lozenge'
                    {
                    match("lozenge"); 


                    }
                    break;
                case 4 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:315:57: 'mascle'
                    {
                    match("mascle"); 


                    }
                    break;
                case 5 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:315:68: 'fusil'
                    {
                    match("fusil"); 


                    }
                    break;
                case 6 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:315:78: 'rustre'
                    {
                    match("rustre"); 


                    }
                    break;
                case 7 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:315:89: 'roundel'
                    {
                    match("roundel"); 


                    }
                    break;
                case 8 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:315:101: 'annulet'
                    {
                    match("annulet"); 


                    }
                    break;
                case 9 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:315:113: 'mullet'
                    {
                    match("mullet"); 


                    }
                    break;
                case 10 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:315:124: 'star'
                    {
                    match("star"); 


                    }
                    break;

            }

            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:315:131: ( 's' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='s') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:315:131: 's'
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

    // $ANTLR start "CONTINUOUS_DIV"
    public final void mCONTINUOUS_DIV() throws RecognitionException {
        try {
            int _type = CONTINUOUS_DIV;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:319:9: ( 'chequy' | 'lozengy' )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='c') ) {
                alt11=1;
            }
            else if ( (LA11_0=='l') ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:319:13: 'chequy'
                    {
                    match("chequy"); 


                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:319:24: 'lozengy'
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
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:322:9: ( 'quarter' ( 'ed' | 'ly' ) )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:322:13: 'quarter' ( 'ed' | 'ly' )
            {
            match("quarter"); 

            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:322:22: ( 'ed' | 'ly' )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='e') ) {
                alt12=1;
            }
            else if ( (LA12_0=='l') ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:322:23: 'ed'
                    {
                    match("ed"); 


                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:322:28: 'ly'
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
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:326:9: ( ( 'part' ( 'ed' | 'y' ) ' ' )? 'per' )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:326:13: ( 'part' ( 'ed' | 'y' ) ' ' )? 'per'
            {
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:326:13: ( 'part' ( 'ed' | 'y' ) ' ' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0=='p') ) {
                int LA14_1 = input.LA(2);

                if ( (LA14_1=='a') ) {
                    alt14=1;
                }
            }
            switch (alt14) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:326:14: 'part' ( 'ed' | 'y' ) ' '
                    {
                    match("part"); 

                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:326:20: ( 'ed' | 'y' )
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0=='e') ) {
                        alt13=1;
                    }
                    else if ( (LA13_0=='y') ) {
                        alt13=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 13, 0, input);

                        throw nvae;
                    }
                    switch (alt13) {
                        case 1 :
                            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:326:21: 'ed'
                            {
                            match("ed"); 


                            }
                            break;
                        case 2 :
                            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:326:26: 'y'
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
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:329:9: ( 'azure' | 'gules' | 'vert' | 'sable' | 'purpure' )
            int alt15=5;
            switch ( input.LA(1) ) {
            case 'a':
                {
                alt15=1;
                }
                break;
            case 'g':
                {
                alt15=2;
                }
                break;
            case 'v':
                {
                alt15=3;
                }
                break;
            case 's':
                {
                alt15=4;
                }
                break;
            case 'p':
                {
                alt15=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:329:13: 'azure'
                    {
                    match("azure"); 


                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:329:23: 'gules'
                    {
                    match("gules"); 


                    }
                    break;
                case 3 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:329:33: 'vert'
                    {
                    match("vert"); 


                    }
                    break;
                case 4 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:329:42: 'sable'
                    {
                    match("sable"); 


                    }
                    break;
                case 5 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:329:52: 'purpure'
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
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:332:9: ( 'or' | 'argent' )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0=='o') ) {
                alt16=1;
            }
            else if ( (LA16_0=='a') ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:332:13: 'or'
                    {
                    match("or"); 


                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:332:20: 'argent'
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
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:335:9: ( 'ermine' | 'ermines' | 'erminois' | 'pean' | 'vair' | 'counter-vair' | 'vair-en-pale' | 'vair-en-point' | 'potent' | 'counter-potent' | 'potent-en-pale' | 'potent-en-point' )
            int alt17=12;
            alt17 = dfa17.predict(input);
            switch (alt17) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:335:13: 'ermine'
                    {
                    match("ermine"); 


                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:335:24: 'ermines'
                    {
                    match("ermines"); 


                    }
                    break;
                case 3 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:335:36: 'erminois'
                    {
                    match("erminois"); 


                    }
                    break;
                case 4 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:335:49: 'pean'
                    {
                    match("pean"); 


                    }
                    break;
                case 5 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:336:13: 'vair'
                    {
                    match("vair"); 


                    }
                    break;
                case 6 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:336:22: 'counter-vair'
                    {
                    match("counter-vair"); 


                    }
                    break;
                case 7 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:336:39: 'vair-en-pale'
                    {
                    match("vair-en-pale"); 


                    }
                    break;
                case 8 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:336:56: 'vair-en-point'
                    {
                    match("vair-en-point"); 


                    }
                    break;
                case 9 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:337:13: 'potent'
                    {
                    match("potent"); 


                    }
                    break;
                case 10 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:337:24: 'counter-potent'
                    {
                    match("counter-potent"); 


                    }
                    break;
                case 11 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:337:43: 'potent-en-pale'
                    {
                    match("potent-en-pale"); 


                    }
                    break;
                case 12 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:337:62: 'potent-en-point'
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
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:340:9: ( ( '0' .. '9' )+ )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:340:13: ( '0' .. '9' )+
            {
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:340:13: ( '0' .. '9' )+
            int cnt18=0;
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>='0' && LA18_0<='9')) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:340:14: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

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
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:344:9: ( 'one' | 'eleven' | 'two' | 'twelve' | 'three' | 'thirteen' | 'four' ( 'teen' )? | 'five' | 'fifteen' | 'six' ( 'teen' )? | 'seven' ( 'teen' )? | 'eight' ( 'een' )? | 'nine' ( 'teen' )? | 'twenty' | 'thirty' | 'fourty' | 'fifty' | 'sixty' | 'seventy' | 'eighty' | 'ninety' | 'hundred' | 'thousand' | 'million' | 'billion' )
            int alt24=25;
            alt24 = dfa24.predict(input);
            switch (alt24) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:344:13: 'one'
                    {
                    match("one"); 


                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:344:21: 'eleven'
                    {
                    match("eleven"); 


                    }
                    break;
                case 3 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:344:32: 'two'
                    {
                    match("two"); 


                    }
                    break;
                case 4 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:344:40: 'twelve'
                    {
                    match("twelve"); 


                    }
                    break;
                case 5 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:344:51: 'three'
                    {
                    match("three"); 


                    }
                    break;
                case 6 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:344:61: 'thirteen'
                    {
                    match("thirteen"); 


                    }
                    break;
                case 7 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:345:13: 'four' ( 'teen' )?
                    {
                    match("four"); 

                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:345:19: ( 'teen' )?
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0=='t') ) {
                        alt19=1;
                    }
                    switch (alt19) {
                        case 1 :
                            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:345:19: 'teen'
                            {
                            match("teen"); 


                            }
                            break;

                    }


                    }
                    break;
                case 8 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:345:29: 'five'
                    {
                    match("five"); 


                    }
                    break;
                case 9 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:345:38: 'fifteen'
                    {
                    match("fifteen"); 


                    }
                    break;
                case 10 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:345:50: 'six' ( 'teen' )?
                    {
                    match("six"); 

                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:345:55: ( 'teen' )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0=='t') ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:345:55: 'teen'
                            {
                            match("teen"); 


                            }
                            break;

                    }


                    }
                    break;
                case 11 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:345:65: 'seven' ( 'teen' )?
                    {
                    match("seven"); 

                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:345:72: ( 'teen' )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0=='t') ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:345:72: 'teen'
                            {
                            match("teen"); 


                            }
                            break;

                    }


                    }
                    break;
                case 12 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:346:13: 'eight' ( 'een' )?
                    {
                    match("eight"); 

                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:346:20: ( 'een' )?
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0=='e') ) {
                        alt22=1;
                    }
                    switch (alt22) {
                        case 1 :
                            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:346:20: 'een'
                            {
                            match("een"); 


                            }
                            break;

                    }


                    }
                    break;
                case 13 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:346:29: 'nine' ( 'teen' )?
                    {
                    match("nine"); 

                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:346:35: ( 'teen' )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0=='t') ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:346:35: 'teen'
                            {
                            match("teen"); 


                            }
                            break;

                    }


                    }
                    break;
                case 14 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:346:45: 'twenty'
                    {
                    match("twenty"); 


                    }
                    break;
                case 15 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:346:56: 'thirty'
                    {
                    match("thirty"); 


                    }
                    break;
                case 16 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:346:67: 'fourty'
                    {
                    match("fourty"); 


                    }
                    break;
                case 17 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:347:13: 'fifty'
                    {
                    match("fifty"); 


                    }
                    break;
                case 18 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:347:23: 'sixty'
                    {
                    match("sixty"); 


                    }
                    break;
                case 19 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:347:33: 'seventy'
                    {
                    match("seventy"); 


                    }
                    break;
                case 20 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:347:45: 'eighty'
                    {
                    match("eighty"); 


                    }
                    break;
                case 21 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:347:56: 'ninety'
                    {
                    match("ninety"); 


                    }
                    break;
                case 22 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:347:67: 'hundred'
                    {
                    match("hundred"); 


                    }
                    break;
                case 23 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:348:13: 'thousand'
                    {
                    match("thousand"); 


                    }
                    break;
                case 24 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:348:26: 'million'
                    {
                    match("million"); 


                    }
                    break;
                case 25 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:348:38: 'billion'
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
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:351:9: ( 'of' )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:351:13: 'of'
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
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:354:9: ( 'and' )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:354:13: 'and'
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
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:358:9: ( 'a' | 'an' )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0=='a') ) {
                int LA25_1 = input.LA(2);

                if ( (LA25_1=='n') ) {
                    alt25=2;
                }
                else {
                    alt25=1;}
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:358:13: 'a'
                    {
                    match('a'); 

                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:358:19: 'an'
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
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:361:9: ( ( ' ' | '\\t' )+ )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:361:13: ( ' ' | '\\t' )+
            {
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:361:13: ( ' ' | '\\t' )+
            int cnt26=0;
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0=='\t'||LA26_0==' ') ) {
                    alt26=1;
                }


                switch (alt26) {
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
            	    if ( cnt26 >= 1 ) break loop26;
                        EarlyExitException eee =
                            new EarlyExitException(26, input);
                        throw eee;
                }
                cnt26++;
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
        // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:1:8: ( T__25 | MODIFIER | TIERCED | ORDINARY_DIV | SUBORDINARY_DIV | OTHER_ORDINARY | SUBORDINARY | VARIABLE_DIV | SUBORDINARY_MULTIPLE | MOBILE_CHARGE | CONTINUOUS_DIV | QUARTER | PARTYPER | COLOUR | METAL | FUR | DIGITS | NUMWORDS | OF | AND | DETERMINER | WS )
        int alt27=22;
        alt27 = dfa27.predict(input);
        switch (alt27) {
            case 1 :
                // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:1:10: T__25
                {
                mT__25(); 

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
                // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:1:137: CONTINUOUS_DIV
                {
                mCONTINUOUS_DIV(); 

                }
                break;
            case 12 :
                // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:1:152: QUARTER
                {
                mQUARTER(); 

                }
                break;
            case 13 :
                // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:1:160: PARTYPER
                {
                mPARTYPER(); 

                }
                break;
            case 14 :
                // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:1:169: COLOUR
                {
                mCOLOUR(); 

                }
                break;
            case 15 :
                // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:1:176: METAL
                {
                mMETAL(); 

                }
                break;
            case 16 :
                // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:1:182: FUR
                {
                mFUR(); 

                }
                break;
            case 17 :
                // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:1:186: DIGITS
                {
                mDIGITS(); 

                }
                break;
            case 18 :
                // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:1:193: NUMWORDS
                {
                mNUMWORDS(); 

                }
                break;
            case 19 :
                // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:1:202: OF
                {
                mOF(); 

                }
                break;
            case 20 :
                // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:1:205: AND
                {
                mAND(); 

                }
                break;
            case 21 :
                // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:1:209: DETERMINER
                {
                mDETERMINER(); 

                }
                break;
            case 22 :
                // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:1:220: WS
                {
                mWS(); 

                }
                break;

        }

    }


    protected DFA4 dfa4 = new DFA4(this);
    protected DFA9 dfa9 = new DFA9(this);
    protected DFA17 dfa17 = new DFA17(this);
    protected DFA24 dfa24 = new DFA24(this);
    protected DFA27 dfa27 = new DFA27(this);
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
            return "302:1: SUBORDINARY : ( 'pile' | 'quarter' | 'canton' | 'flaunches' | 'bordure' | 'orle' | 'tressure' | 'gyron' | 'fret' );";
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
            return "315:13: ( ( 'in' )? 'escutcheon' | 'billet' | 'lozenge' | 'mascle' | 'fusil' | 'rustre' | 'roundel' | 'annulet' | 'mullet' | 'star' )";
        }
    }
    static final String DFA17_eotS =
        "\20\uffff\1\25\6\uffff\1\35\1\uffff\1\37\25\uffff";
    static final String DFA17_eofS =
        "\57\uffff";
    static final String DFA17_minS =
        "\1\143\1\162\1\145\1\141\1\157\1\155\1\uffff\1\164\1\151\1\165\1"+
        "\151\1\145\1\162\3\156\1\55\1\164\1\145\1\164\1\145\1\uffff\1\145"+
        "\1\163\1\uffff\1\55\1\156\1\162\2\uffff\1\145\1\uffff\2\55\1\156"+
        "\2\160\1\55\1\141\2\uffff\1\160\2\uffff\1\141\2\uffff";
    static final String DFA17_maxS =
        "\1\166\1\162\1\157\1\141\1\157\1\155\1\uffff\1\164\1\151\1\165\1"+
        "\151\1\145\1\162\3\156\1\55\1\164\1\157\1\164\1\145\1\uffff\1\145"+
        "\1\163\1\uffff\1\55\1\156\1\162\2\uffff\1\145\1\uffff\2\55\1\156"+
        "\1\160\1\166\1\55\1\157\2\uffff\1\160\2\uffff\1\157\2\uffff";
    static final String DFA17_acceptS =
        "\6\uffff\1\4\16\uffff\1\5\2\uffff\1\3\3\uffff\1\2\1\1\1\uffff\1"+
        "\11\7\uffff\1\6\1\12\1\uffff\1\7\1\10\1\uffff\1\13\1\14";
    static final String DFA17_specialS =
        "\57\uffff}>";
    static final String[] DFA17_transitionS = {
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
            return "335:1: FUR : ( 'ermine' | 'ermines' | 'erminois' | 'pean' | 'vair' | 'counter-vair' | 'vair-en-pale' | 'vair-en-point' | 'potent' | 'counter-potent' | 'potent-en-pale' | 'potent-en-point' );";
        }
    }
    static final String DFA24_eotS =
        "\34\uffff\1\46\6\uffff\1\54\4\uffff\1\62\1\64\6\uffff\1\71\13\uffff";
    static final String DFA24_eofS =
        "\74\uffff";
    static final String DFA24_minS =
        "\1\142\1\uffff\1\151\1\150\1\151\1\145\1\151\4\uffff\1\147\1\145"+
        "\1\151\1\165\1\146\1\170\1\166\1\156\1\150\1\uffff\1\154\1\uffff"+
        "\1\162\1\uffff\1\162\1\uffff\2\164\2\145\1\164\2\uffff\2\164\2\145"+
        "\1\uffff\1\156\1\164\1\171\2\145\4\uffff\1\164\1\145\6\uffff\1\145"+
        "\3\uffff";
    static final String DFA24_maxS =
        "\1\164\1\uffff\1\154\1\167\1\157\2\151\4\uffff\1\147\1\157\1\162"+
        "\1\165\1\166\1\170\1\166\1\156\1\150\1\uffff\1\156\1\uffff\1\162"+
        "\1\uffff\1\162\1\uffff\2\164\2\145\1\164\2\uffff\2\164\2\171\1\uffff"+
        "\1\156\1\164\3\171\4\uffff\1\164\1\171\6\uffff\1\171\3\uffff";
    static final String DFA24_acceptS =
        "\1\uffff\1\1\5\uffff\1\26\1\30\1\31\1\2\11\uffff\1\3\1\uffff\1\5"+
        "\1\uffff\1\27\1\uffff\1\10\5\uffff\1\4\1\16\4\uffff\1\12\5\uffff"+
        "\1\7\1\11\1\21\1\22\2\uffff\1\15\1\24\1\14\1\6\1\17\1\20\1\uffff"+
        "\1\13\1\25\1\23";
    static final String DFA24_specialS =
        "\74\uffff}>";
    static final String[] DFA24_transitionS = {
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

    static final short[] DFA24_eot = DFA.unpackEncodedString(DFA24_eotS);
    static final short[] DFA24_eof = DFA.unpackEncodedString(DFA24_eofS);
    static final char[] DFA24_min = DFA.unpackEncodedStringToUnsignedChars(DFA24_minS);
    static final char[] DFA24_max = DFA.unpackEncodedStringToUnsignedChars(DFA24_maxS);
    static final short[] DFA24_accept = DFA.unpackEncodedString(DFA24_acceptS);
    static final short[] DFA24_special = DFA.unpackEncodedString(DFA24_specialS);
    static final short[][] DFA24_transition;

    static {
        int numStates = DFA24_transitionS.length;
        DFA24_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA24_transition[i] = DFA.unpackEncodedString(DFA24_transitionS[i]);
        }
    }

    class DFA24 extends DFA {

        public DFA24(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 24;
            this.eot = DFA24_eot;
            this.eof = DFA24_eof;
            this.min = DFA24_min;
            this.max = DFA24_max;
            this.accept = DFA24_accept;
            this.special = DFA24_special;
            this.transition = DFA24_transition;
        }
        public String getDescription() {
            return "343:1: NUMWORDS : ( 'one' | 'eleven' | 'two' | 'twelve' | 'three' | 'thirteen' | 'four' ( 'teen' )? | 'five' | 'fifteen' | 'six' ( 'teen' )? | 'seven' ( 'teen' )? | 'eight' ( 'een' )? | 'nine' ( 'teen' )? | 'twenty' | 'thirty' | 'fourty' | 'fifty' | 'sixty' | 'seventy' | 'eighty' | 'ninety' | 'hundred' | 'thousand' | 'million' | 'billion' );";
        }
    }
    static final String DFA27_eotS =
        "\17\uffff\1\52\24\uffff\1\51\3\uffff\1\52\6\uffff\1\71\6\uffff\1"+
        "\100\1\uffff\1\36\12\uffff\1\26\4\uffff\1\36\1\26\1\uffff";
    static final String DFA27_eofS =
        "\113\uffff";
    static final String DFA27_minS =
        "\1\11\1\141\1\145\1\141\1\150\1\145\2\141\1\165\1\146\1\165\1\uffff"+
        "\1\151\1\157\1\141\1\156\1\141\4\uffff\1\154\1\uffff\1\141\3\uffff"+
        "\1\156\1\142\2\uffff\1\156\1\162\1\154\1\145\1\141\1\154\1\uffff"+
        "\1\162\1\172\1\144\2\uffff\1\145\1\uffff\1\144\1\uffff\1\162\1\154"+
        "\1\161\1\162\1\157\1\145\1\uffff\1\145\1\uffff\1\154\1\uffff\1\145"+
        "\1\162\1\uffff\1\164\2\156\1\uffff\1\157\1\145\1\156\1\147\1\156"+
        "\1\162\3\145\1\uffff";
    static final String DFA27_maxS =
        "\1\166\2\165\1\164\1\167\1\165\1\157\1\162\1\165\1\162\1\171\1\uffff"+
        "\1\163\1\157\1\165\1\172\1\145\4\uffff\1\162\1\uffff\1\162\3\uffff"+
        "\1\170\1\154\2\uffff\1\156\1\163\1\154\1\151\1\141\1\154\1\uffff"+
        "\1\162\1\172\1\156\2\uffff\1\171\1\uffff\1\144\1\uffff\1\162\1\154"+
        "\1\166\1\162\1\157\1\145\1\uffff\1\145\1\uffff\1\171\1\uffff\1\151"+
        "\1\162\1\uffff\1\164\2\156\1\uffff\1\157\1\145\1\156\1\147\1\156"+
        "\1\162\1\171\1\156\1\154\1\uffff";
    static final String DFA27_acceptS =
        "\13\uffff\1\12\5\uffff\1\21\1\22\1\26\1\1\1\uffff\1\7\1\uffff\1"+
        "\16\1\20\1\2\2\uffff\1\3\1\4\6\uffff\1\23\3\uffff\1\17\1\25\1\uffff"+
        "\1\15\1\uffff\1\6\6\uffff\1\24\1\uffff\1\10\1\uffff\1\11\2\uffff"+
        "\1\13\3\uffff\1\5\11\uffff\1\14";
    static final String DFA27_specialS =
        "\113\uffff}>";
    static final String[] DFA27_transitionS = {
            "\1\23\26\uffff\1\23\17\uffff\12\21\47\uffff\1\17\1\6\1\7\1\uffff"+
            "\1\14\1\5\1\12\1\22\1\13\2\uffff\1\15\1\16\1\22\1\11\1\1\1\10"+
            "\1\2\1\3\1\4\1\uffff\1\20",
            "\1\25\3\uffff\1\27\3\uffff\1\26\2\uffff\1\24\2\uffff\1\31\5"+
            "\uffff\1\30",
            "\1\32\11\uffff\1\13\5\uffff\1\13",
            "\1\34\3\uffff\1\22\3\uffff\1\33\12\uffff\1\13",
            "\1\22\1\35\10\uffff\1\26\4\uffff\1\22",
            "\1\36\3\uffff\1\22\2\uffff\1\26\2\uffff\1\22\2\uffff\1\26\2"+
            "\uffff\1\13",
            "\1\40\3\uffff\1\37\3\uffff\1\41\5\uffff\1\26",
            "\1\26\6\uffff\1\42\6\uffff\1\31\2\uffff\1\36",
            "\1\43",
            "\1\45\7\uffff\1\22\3\uffff\1\44",
            "\1\30\3\uffff\1\46",
            "",
            "\1\22\2\uffff\1\22\5\uffff\1\31\1\13",
            "\1\47",
            "\1\13\7\uffff\1\22\13\uffff\1\13",
            "\1\50\3\uffff\1\51\7\uffff\1\30",
            "\1\31\3\uffff\1\30",
            "",
            "",
            "",
            "",
            "\1\53\5\uffff\1\54",
            "",
            "\1\31\20\uffff\1\54",
            "",
            "",
            "",
            "\1\32\11\uffff\1\22",
            "\1\30\11\uffff\1\36",
            "",
            "",
            "\1\55",
            "\1\57\1\56",
            "\1\60",
            "\1\61\3\uffff\1\56",
            "\1\62",
            "\1\26",
            "",
            "\1\63",
            "\1\64",
            "\1\65\11\uffff\1\13",
            "",
            "",
            "\1\36\6\uffff\1\66\14\uffff\1\67",
            "",
            "\1\70",
            "",
            "\1\67",
            "\1\72",
            "\1\74\4\uffff\1\73",
            "\1\75",
            "\1\76",
            "\1\77",
            "",
            "\1\71",
            "",
            "\1\71\14\uffff\1\67",
            "",
            "\1\13\3\uffff\1\22",
            "\1\101",
            "",
            "\1\102",
            "\1\103",
            "\1\104",
            "",
            "\1\105",
            "\1\106",
            "\1\67",
            "\1\107",
            "\1\110",
            "\1\111",
            "\1\13\23\uffff\1\74",
            "\1\71\10\uffff\1\67",
            "\1\112\6\uffff\1\112",
            ""
    };

    static final short[] DFA27_eot = DFA.unpackEncodedString(DFA27_eotS);
    static final short[] DFA27_eof = DFA.unpackEncodedString(DFA27_eofS);
    static final char[] DFA27_min = DFA.unpackEncodedStringToUnsignedChars(DFA27_minS);
    static final char[] DFA27_max = DFA.unpackEncodedStringToUnsignedChars(DFA27_maxS);
    static final short[] DFA27_accept = DFA.unpackEncodedString(DFA27_acceptS);
    static final short[] DFA27_special = DFA.unpackEncodedString(DFA27_specialS);
    static final short[][] DFA27_transition;

    static {
        int numStates = DFA27_transitionS.length;
        DFA27_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA27_transition[i] = DFA.unpackEncodedString(DFA27_transitionS[i]);
        }
    }

    class DFA27 extends DFA {

        public DFA27(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 27;
            this.eot = DFA27_eot;
            this.eof = DFA27_eof;
            this.min = DFA27_min;
            this.max = DFA27_max;
            this.accept = DFA27_accept;
            this.special = DFA27_special;
            this.transition = DFA27_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__25 | MODIFIER | TIERCED | ORDINARY_DIV | SUBORDINARY_DIV | OTHER_ORDINARY | SUBORDINARY | VARIABLE_DIV | SUBORDINARY_MULTIPLE | MOBILE_CHARGE | CONTINUOUS_DIV | QUARTER | PARTYPER | COLOUR | METAL | FUR | DIGITS | NUMWORDS | OF | AND | DETERMINER | WS );";
        }
    }
 

}