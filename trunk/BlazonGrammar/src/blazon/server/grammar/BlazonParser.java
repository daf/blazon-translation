// $ANTLR 3.3 Nov 30, 2010 12:50:56 /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g 2011-10-02 21:10:26

package blazon.server.grammar;
import blazon.shared.shield.*;
import blazon.shared.shield.charges.*;
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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "A", "ORDINARY", "OTHER_ORDINARY", "MODIFIER", "TIERCED", "PARTYPER", "OTHER_DIV", "VARIABLE_DIV", "OF", "CONTINUOUS_DIV", "QUARTER", "AND", "COLOUR", "METAL", "FUR", "DIGITS", "NUMWORDS", "WS", "'plain'"
    };
    public static final int EOF=-1;
    public static final int T__22=22;
    public static final int A=4;
    public static final int ORDINARY=5;
    public static final int OTHER_ORDINARY=6;
    public static final int MODIFIER=7;
    public static final int TIERCED=8;
    public static final int PARTYPER=9;
    public static final int OTHER_DIV=10;
    public static final int VARIABLE_DIV=11;
    public static final int OF=12;
    public static final int CONTINUOUS_DIV=13;
    public static final int QUARTER=14;
    public static final int AND=15;
    public static final int COLOUR=16;
    public static final int METAL=17;
    public static final int FUR=18;
    public static final int DIGITS=19;
    public static final int NUMWORDS=20;
    public static final int WS=21;

    // delegates
    // delegators


        public BlazonParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public BlazonParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return BlazonParser.tokenNames; }
    public String getGrammarFileName() { return "/Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g"; }


      private WordToNumberConverter converter = new WordToNumberConverter();
      private List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
      
      @Override
      public void emitErrorMessage(String msg) {
        diags.add(ShieldDiagnostic.build(LogLevel.ERROR, msg));
      }



    // $ANTLR start "shield"
    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:38:1: shield returns [Shield s] : field ( charges )? ;
    public final Shield shield() throws RecognitionException {
        Shield s = null;

        ShieldLayer field1 = null;

        ShieldLayer charges2 = null;


        try {
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:39:7: ( field ( charges )? )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:39:11: field ( charges )?
            {
             String blazon = input.toString(); 
            pushFollow(FOLLOW_field_in_shield73);
            field1=field();

            state._fsp--;

             s = ShieldImpl.build(field1, blazon); 
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:41:7: ( charges )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==A) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:41:9: charges
                    {
                    pushFollow(FOLLOW_charges_in_shield85);
                    charges2=charges();

                    state._fsp--;

                     s.getField().addNextLayer(charges2); 

                    }
                    break;

            }

             //LATER make HTML pretty
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
    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:52:1: field returns [ShieldLayer layer] : ( div some_tinctures[tinctures, division] | tincture[tinctures] ( 'plain' )? ) ;
    public final ShieldLayer field() throws RecognitionException {
        ShieldLayer layer = null;

        ShieldDivisionType div3 = null;

        ShieldLayer some_tinctures4 = null;

        Tincture tincture5 = null;


        try {
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:53:7: ( ( div some_tinctures[tinctures, division] | tincture[tinctures] ( 'plain' )? ) )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:53:11: ( div some_tinctures[tinctures, division] | tincture[tinctures] ( 'plain' )? )
            {
             Tinctures tinctures = new Tinctures(); 
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:54:7: ( div some_tinctures[tinctures, division] | tincture[tinctures] ( 'plain' )? )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>=TIERCED && LA3_0<=PARTYPER)||LA3_0==VARIABLE_DIV||(LA3_0>=CONTINUOUS_DIV && LA3_0<=QUARTER)) ) {
                alt3=1;
            }
            else if ( ((LA3_0>=COLOUR && LA3_0<=FUR)) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:55:11: div some_tinctures[tinctures, division]
                    {
                    pushFollow(FOLLOW_div_in_field156);
                    div3=div();

                    state._fsp--;

                     ShieldDivisionType division = div3; 
                    pushFollow(FOLLOW_some_tinctures_in_field172);
                    some_tinctures4=some_tinctures(tinctures, division);

                    state._fsp--;

                     layer = some_tinctures4; 

                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:58:13: tincture[tinctures] ( 'plain' )?
                    {
                    pushFollow(FOLLOW_tincture_in_field199);
                    tincture5=tincture(tinctures);

                    state._fsp--;

                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:58:33: ( 'plain' )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==22) ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:58:33: 'plain'
                            {
                            match(input,22,FOLLOW_22_in_field202); 

                            }
                            break;

                    }


                                    tinctures.addTincture(tincture5);
                                    layer = ShieldLayer.buildUndividedShieldLayer(tinctures);
                                

                    }
                    break;

            }


            }

        }

            catch (RecognitionException re) {
                throw re;
            }
        finally {
        }
        return layer;
    }
    // $ANTLR end "field"


    // $ANTLR start "charges"
    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:65:1: charges returns [ShieldLayer layer] : A ordinary[tinctures] ;
    public final ShieldLayer charges() throws RecognitionException {
        ShieldLayer layer = null;

        Ordinary ordinary6 = null;


        try {
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:66:9: ( A ordinary[tinctures] )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:66:13: A ordinary[tinctures]
            {
             Tinctures tinctures = new Tinctures(); 
            match(input,A,FOLLOW_A_in_charges258); 
            pushFollow(FOLLOW_ordinary_in_charges260);
            ordinary6=ordinary(tinctures);

            state._fsp--;


                            layer = ChargedShieldLayer.build(tinctures, ordinary6);
                        

            }

        }

            catch (RecognitionException re) {
                throw re;
            }
        finally {
        }
        return layer;
    }
    // $ANTLR end "charges"


    // $ANTLR start "ordinary"
    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:73:1: ordinary[Tinctures tinctures] returns [Ordinary ordinary] : ord= ( ORDINARY | OTHER_ORDINARY ) ( MODIFIER )? t= tincture[tinctures] ;
    public final Ordinary ordinary(Tinctures tinctures) throws RecognitionException {
        Ordinary ordinary = null;

        Token ord=null;
        Token MODIFIER7=null;
        Tincture t = null;


        try {
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:74:9: (ord= ( ORDINARY | OTHER_ORDINARY ) ( MODIFIER )? t= tincture[tinctures] )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:74:13: ord= ( ORDINARY | OTHER_ORDINARY ) ( MODIFIER )? t= tincture[tinctures]
            {
            ord=(Token)input.LT(1);
            if ( (input.LA(1)>=ORDINARY && input.LA(1)<=OTHER_ORDINARY) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

             String text = (ord!=null?ord.getText():null); 
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:75:13: ( MODIFIER )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==MODIFIER) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:75:15: MODIFIER
                    {
                    MODIFIER7=(Token)match(input,MODIFIER,FOLLOW_MODIFIER_in_ordinary337); 
                     text += "_" + (MODIFIER7!=null?MODIFIER7.getText():null); 

                    }
                    break;

            }

            pushFollow(FOLLOW_tincture_in_ordinary358);
            t=tincture(tinctures);

            state._fsp--;

             ordinary = Ordinary.build(text, t); 

            }

        }

            catch (RecognitionException re) {
                throw re;
            }
        finally {
        }
        return ordinary;
    }
    // $ANTLR end "ordinary"


    // $ANTLR start "div"
    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:80:1: div returns [ShieldDivisionType division] : ( ( TIERCED )? PARTYPER divType= ( ORDINARY | OTHER_DIV ) (divModifier1= MODIFIER )? | VARIABLE_DIV (divModifier2= MODIFIER )? ( OF number_digits_or_words )? | CONTINUOUS_DIV | QUARTER ) ;
    public final ShieldDivisionType div() throws RecognitionException {
        ShieldDivisionType division = null;

        Token divType=null;
        Token divModifier1=null;
        Token divModifier2=null;
        Token TIERCED8=null;
        Token VARIABLE_DIV9=null;
        Token OF10=null;
        Token CONTINUOUS_DIV12=null;
        Token QUARTER13=null;
        BlazonParser.number_digits_or_words_return number_digits_or_words11 = null;


        try {
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:81:9: ( ( ( TIERCED )? PARTYPER divType= ( ORDINARY | OTHER_DIV ) (divModifier1= MODIFIER )? | VARIABLE_DIV (divModifier2= MODIFIER )? ( OF number_digits_or_words )? | CONTINUOUS_DIV | QUARTER ) )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:81:13: ( ( TIERCED )? PARTYPER divType= ( ORDINARY | OTHER_DIV ) (divModifier1= MODIFIER )? | VARIABLE_DIV (divModifier2= MODIFIER )? ( OF number_digits_or_words )? | CONTINUOUS_DIV | QUARTER )
            {
             String text = ""; 
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:82:9: ( ( TIERCED )? PARTYPER divType= ( ORDINARY | OTHER_DIV ) (divModifier1= MODIFIER )? | VARIABLE_DIV (divModifier2= MODIFIER )? ( OF number_digits_or_words )? | CONTINUOUS_DIV | QUARTER )
            int alt9=4;
            switch ( input.LA(1) ) {
            case TIERCED:
            case PARTYPER:
                {
                alt9=1;
                }
                break;
            case VARIABLE_DIV:
                {
                alt9=2;
                }
                break;
            case CONTINUOUS_DIV:
                {
                alt9=3;
                }
                break;
            case QUARTER:
                {
                alt9=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:83:13: ( TIERCED )? PARTYPER divType= ( ORDINARY | OTHER_DIV ) (divModifier1= MODIFIER )?
                    {
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:83:13: ( TIERCED )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==TIERCED) ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:84:17: TIERCED
                            {
                            TIERCED8=(Token)match(input,TIERCED,FOLLOW_TIERCED_in_div450); 
                             text = (TIERCED8!=null?TIERCED8.getText():null) + " "; 

                            }
                            break;

                    }

                    match(input,PARTYPER,FOLLOW_PARTYPER_in_div481); 
                    divType=(Token)input.LT(1);
                    if ( input.LA(1)==ORDINARY||input.LA(1)==OTHER_DIV ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                     text += (divType!=null?divType.getText():null); 
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:88:13: (divModifier1= MODIFIER )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==MODIFIER) ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:89:17: divModifier1= MODIFIER
                            {
                            divModifier1=(Token)match(input,MODIFIER,FOLLOW_MODIFIER_in_div543); 
                             text += " " + (divModifier1!=null?divModifier1.getText():null); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:92:13: VARIABLE_DIV (divModifier2= MODIFIER )? ( OF number_digits_or_words )?
                    {
                    VARIABLE_DIV9=(Token)match(input,VARIABLE_DIV,FOLLOW_VARIABLE_DIV_in_div584); 
                     text = (VARIABLE_DIV9!=null?VARIABLE_DIV9.getText():null); 
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:93:13: (divModifier2= MODIFIER )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==MODIFIER) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:94:17: divModifier2= MODIFIER
                            {
                            divModifier2=(Token)match(input,MODIFIER,FOLLOW_MODIFIER_in_div622); 
                             text += " " + (divModifier2!=null?divModifier2.getText():null); 

                            }
                            break;

                    }

                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:96:13: ( OF number_digits_or_words )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==OF) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:97:17: OF number_digits_or_words
                            {
                            OF10=(Token)match(input,OF,FOLLOW_OF_in_div671); 
                             text += " " + (OF10!=null?OF10.getText():null); 
                            pushFollow(FOLLOW_number_digits_or_words_in_div691);
                            number_digits_or_words11=number_digits_or_words();

                            state._fsp--;


                                                try {
                                                    int gyronnyOf = converter.convert((number_digits_or_words11!=null?input.toString(number_digits_or_words11.start,number_digits_or_words11.stop):null));
                                                    if (gyronnyOf % 2 != 0) {
                                                        gyronnyOf++;
                                                        diags.add(ShieldDiagnostic.build(LogLevel.WARN, "Parsing rule 'div'.  '" + (VARIABLE_DIV9!=null?VARIABLE_DIV9.getText():null) 
                                                                + "' can only be of an even number; incremented number of sections to " + gyronnyOf));
                                                    }
                                                    text += " " + gyronnyOf;
                                                } catch (Exception e) {
                                                    diags.add(ShieldDiagnostic.build(LogLevel.ERROR, "Unable to convert '" + (number_digits_or_words11!=null?input.toString(number_digits_or_words11.start,number_digits_or_words11.stop):null) 
                                                        + "' into an integer. Caught: " +  e));
                                                    throw new RecognitionException(this.input);
                                                }
                                            

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:116:13: CONTINUOUS_DIV
                    {
                    CONTINUOUS_DIV12=(Token)match(input,CONTINUOUS_DIV,FOLLOW_CONTINUOUS_DIV_in_div748); 
                     text = (CONTINUOUS_DIV12!=null?CONTINUOUS_DIV12.getText():null); 

                    }
                    break;
                case 4 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:118:13: QUARTER
                    {
                    QUARTER13=(Token)match(input,QUARTER,FOLLOW_QUARTER_in_div774); 
                     text = (QUARTER13!=null?QUARTER13.getText():null); 

                    }
                    break;

            }


                        if (state.errorRecovery) {
                            throw new RecognitionException(this.input);
                        }
                        ShieldDivision divisions = new ShieldDivision();
                        division = divisions.getDivisionType(text, diags);
                    

            }

        }

            catch (RecognitionException re) {
                throw re;
            }
        finally {
        }
        return division;
    }
    // $ANTLR end "div"


    // $ANTLR start "some_tinctures"
    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:129:1: some_tinctures[Tinctures tinctures, ShieldDivisionType division] returns [ShieldLayer layer] : ( tincture[tinctures] )+ AND tincture[tinctures] ;
    public final ShieldLayer some_tinctures(Tinctures tinctures, ShieldDivisionType division) throws RecognitionException {
        ShieldLayer layer = null;

        try {
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:130:9: ( ( tincture[tinctures] )+ AND tincture[tinctures] )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:130:13: ( tincture[tinctures] )+ AND tincture[tinctures]
            {
             int count = 0; 
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:131:13: ( tincture[tinctures] )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>=COLOUR && LA10_0<=FUR)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:132:17: tincture[tinctures]
            	    {
            	    pushFollow(FOLLOW_tincture_in_some_tinctures873);
            	    tincture(tinctures);

            	    state._fsp--;

            	     count++; 

            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);

            match(input,AND,FOLLOW_AND_in_some_tinctures922); 
            pushFollow(FOLLOW_tincture_in_some_tinctures936);
            tincture(tinctures);

            state._fsp--;


                            count++;
                            int numberOfTinctures = division.getNumberOfTinctures();
                            if (numberOfTinctures != count) {
                                diags.add(ShieldDiagnostic.build(LogLevel.ERROR, "Incorrect number of tinctures specified." +
                                    "  The '" + division + "' division type only allows the following number of tinctures: "
                                    + numberOfTinctures + " but found " + count));
                                throw new RecognitionException(this.input);
                            }
                            layer = ShieldLayer.buildDividedShieldLayer(tinctures, division);
                        

            }

        }

            catch (RecognitionException re) {
                throw re;
            }
        finally {
        }
        return layer;
    }
    // $ANTLR end "some_tinctures"


    // $ANTLR start "tincture"
    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:150:1: tincture[Tinctures tinctures] returns [Tincture tincture] : ( COLOUR | METAL | FUR ) ;
    public final Tincture tincture(Tinctures tinctures) throws RecognitionException {
        Tincture tincture = null;

        Token COLOUR14=null;
        Token METAL15=null;
        Token FUR16=null;

        try {
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:151:9: ( ( COLOUR | METAL | FUR ) )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:151:13: ( COLOUR | METAL | FUR )
            {
             String tinctureName = ""; 
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:152:9: ( COLOUR | METAL | FUR )
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
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:152:13: COLOUR
                    {
                    COLOUR14=(Token)match(input,COLOUR,FOLLOW_COLOUR_in_tincture1001); 
                     tinctureName = (COLOUR14!=null?COLOUR14.getText():null); 

                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:153:13: METAL
                    {
                    METAL15=(Token)match(input,METAL,FOLLOW_METAL_in_tincture1017); 
                     tinctureName = (METAL15!=null?METAL15.getText():null); 

                    }
                    break;
                case 3 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:154:13: FUR
                    {
                    FUR16=(Token)match(input,FUR,FOLLOW_FUR_in_tincture1034); 
                     tinctureName = (FUR16!=null?FUR16.getText():null); 

                    }
                    break;

            }

               try {
                            tincture = tinctures.getTincture(tinctureName);
                            tinctures.addTincture(tincture);
                        } catch (UnknownTinctureException e) {
                            diags.add(ShieldDiagnostic.build(LogLevel.ERROR, "Unknown tincture found. Caught: " + e));
                            throw new RecognitionException(this.input);
                        }
                    

            }

        }

            catch (RecognitionException re) {
                throw re;
            }
        finally {
        }
        return tincture;
    }
    // $ANTLR end "tincture"

    public static class number_digits_or_words_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "number_digits_or_words"
    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:166:1: number_digits_or_words : ( DIGITS | NUMWORDS ( ( AND )? NUMWORDS )* );
    public final BlazonParser.number_digits_or_words_return number_digits_or_words() throws RecognitionException {
        BlazonParser.number_digits_or_words_return retval = new BlazonParser.number_digits_or_words_return();
        retval.start = input.LT(1);

        try {
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:167:9: ( DIGITS | NUMWORDS ( ( AND )? NUMWORDS )* )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==DIGITS) ) {
                alt14=1;
            }
            else if ( (LA14_0==NUMWORDS) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:167:13: DIGITS
                    {
                    match(input,DIGITS,FOLLOW_DIGITS_in_number_digits_or_words1086); 

                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:168:13: NUMWORDS ( ( AND )? NUMWORDS )*
                    {
                    match(input,NUMWORDS,FOLLOW_NUMWORDS_in_number_digits_or_words1100); 
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:168:22: ( ( AND )? NUMWORDS )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==AND||LA13_0==NUMWORDS) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:168:23: ( AND )? NUMWORDS
                    	    {
                    	    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:168:23: ( AND )?
                    	    int alt12=2;
                    	    int LA12_0 = input.LA(1);

                    	    if ( (LA12_0==AND) ) {
                    	        alt12=1;
                    	    }
                    	    switch (alt12) {
                    	        case 1 :
                    	            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:168:23: AND
                    	            {
                    	            match(input,AND,FOLLOW_AND_in_number_digits_or_words1103); 

                    	            }
                    	            break;

                    	    }

                    	    match(input,NUMWORDS,FOLLOW_NUMWORDS_in_number_digits_or_words1106); 

                    	    }
                    	    break;

                    	default :
                    	    break loop13;
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
        finally {
        }
        return retval;
    }
    // $ANTLR end "number_digits_or_words"

    // Delegated rules


 

    public static final BitSet FOLLOW_field_in_shield73 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_charges_in_shield85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_div_in_field156 = new BitSet(new long[]{0x0000000000070000L});
    public static final BitSet FOLLOW_some_tinctures_in_field172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tincture_in_field199 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_22_in_field202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_A_in_charges258 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_ordinary_in_charges260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_ordinary312 = new BitSet(new long[]{0x0000000000070080L});
    public static final BitSet FOLLOW_MODIFIER_in_ordinary337 = new BitSet(new long[]{0x0000000000070000L});
    public static final BitSet FOLLOW_tincture_in_ordinary358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TIERCED_in_div450 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_PARTYPER_in_div481 = new BitSet(new long[]{0x0000000000000420L});
    public static final BitSet FOLLOW_set_in_div499 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_MODIFIER_in_div543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_DIV_in_div584 = new BitSet(new long[]{0x0000000000001082L});
    public static final BitSet FOLLOW_MODIFIER_in_div622 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_OF_in_div671 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_number_digits_or_words_in_div691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONTINUOUS_DIV_in_div748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUARTER_in_div774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tincture_in_some_tinctures873 = new BitSet(new long[]{0x0000000000078000L});
    public static final BitSet FOLLOW_AND_in_some_tinctures922 = new BitSet(new long[]{0x0000000000070000L});
    public static final BitSet FOLLOW_tincture_in_some_tinctures936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COLOUR_in_tincture1001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_METAL_in_tincture1017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUR_in_tincture1034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DIGITS_in_number_digits_or_words1086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMWORDS_in_number_digits_or_words1100 = new BitSet(new long[]{0x0000000000108002L});
    public static final BitSet FOLLOW_AND_in_number_digits_or_words1103 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_NUMWORDS_in_number_digits_or_words1106 = new BitSet(new long[]{0x0000000000108002L});

}