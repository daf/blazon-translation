// $ANTLR 3.3 Nov 30, 2010 12:50:56 /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g 2011-10-07 10:25:07

package blazon.server.grammar;
import blazon.shared.shield.*;
import blazon.shared.shield.charges.*;
import blazon.shared.shield.charges.Ordinary.OrdinaryType;
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


      
      public BlazonParser(TokenStream input, List<ShieldDiagnostic> diags) {
          this(input, new RecognizerSharedState(), diags);
      }
      
      public BlazonParser(TokenStream input, RecognizerSharedState state, List<ShieldDiagnostic> diags) {
          super(input, state);
          this.diags = diags;
      }
      
      private WordToNumberConverter converter = new WordToNumberConverter();
      private List<ShieldDiagnostic> diags;
      
      @Override
      public void emitErrorMessage(String msg) {
        diags.add(ShieldDiagnostic.build(LogLevel.ERROR, msg));
      }



    // $ANTLR start "shield"
    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:74:1: shield returns [Shield s] : field ( charges[$field.layer.getTinctureTypeOfLayer()] )? ;
    public final Shield shield() throws RecognitionException {
        Shield s = null;

        ShieldLayer field1 = null;

        ChargedShieldLayer charges2 = null;


        try {
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:75:7: ( field ( charges[$field.layer.getTinctureTypeOfLayer()] )? )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:75:11: field ( charges[$field.layer.getTinctureTypeOfLayer()] )?
            {
             String blazon = input.toString(); 
            pushFollow(FOLLOW_field_in_shield82);
            field1=field();

            state._fsp--;

             s = ShieldImpl.build(field1, blazon); 
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:77:7: ( charges[$field.layer.getTinctureTypeOfLayer()] )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==A) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:77:9: charges[$field.layer.getTinctureTypeOfLayer()]
                    {
                    pushFollow(FOLLOW_charges_in_shield94);
                    charges2=charges(field1.getTinctureTypeOfLayer());

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
    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:89:1: field returns [ShieldLayer layer] : ( div some_tinctures[tinctures, division] | tincture[tinctures] ( 'plain' )? ) ;
    public final ShieldLayer field() throws RecognitionException {
        ShieldLayer layer = null;

        ShieldDivisionType div3 = null;

        ShieldLayer some_tinctures4 = null;


        try {
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:90:7: ( ( div some_tinctures[tinctures, division] | tincture[tinctures] ( 'plain' )? ) )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:90:11: ( div some_tinctures[tinctures, division] | tincture[tinctures] ( 'plain' )? )
            {
             Tinctures tinctures = new Tinctures(); 
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:91:7: ( div some_tinctures[tinctures, division] | tincture[tinctures] ( 'plain' )? )
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
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:92:11: div some_tinctures[tinctures, division]
                    {
                    pushFollow(FOLLOW_div_in_field166);
                    div3=div();

                    state._fsp--;

                     ShieldDivisionType division = div3; 
                    pushFollow(FOLLOW_some_tinctures_in_field182);
                    some_tinctures4=some_tinctures(tinctures, division);

                    state._fsp--;

                     layer = some_tinctures4; 

                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:95:13: tincture[tinctures] ( 'plain' )?
                    {
                    pushFollow(FOLLOW_tincture_in_field209);
                    tincture(tinctures);

                    state._fsp--;

                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:95:33: ( 'plain' )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==22) ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:95:33: 'plain'
                            {
                            match(input,22,FOLLOW_22_in_field212); 

                            }
                            break;

                    }


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
    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:101:1: charges[TinctureType underLayerTinctureType] returns [ChargedShieldLayer layer] : A ordinary[tinctures, underLayerTinctureType] ;
    public final ChargedShieldLayer charges(TinctureType underLayerTinctureType) throws RecognitionException {
        ChargedShieldLayer layer = null;

        OrdinaryType ordinary5 = null;


        try {
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:102:9: ( A ordinary[tinctures, underLayerTinctureType] )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:102:13: A ordinary[tinctures, underLayerTinctureType]
            {
             Tinctures tinctures = new Tinctures(); 
            match(input,A,FOLLOW_A_in_charges270); 
            pushFollow(FOLLOW_ordinary_in_charges272);
            ordinary5=ordinary(tinctures, underLayerTinctureType);

            state._fsp--;


                            layer = ChargedShieldLayer.build(tinctures, ordinary5);
                        

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
    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:109:1: ordinary[Tinctures tinctures, TinctureType underLayerTinctureType] returns [OrdinaryType ordinary] : ord= ( ORDINARY | OTHER_ORDINARY ) ( MODIFIER )? t= tincture[tinctures] ;
    public final OrdinaryType ordinary(Tinctures tinctures, TinctureType underLayerTinctureType) throws RecognitionException {
        OrdinaryType ordinary = null;

        Token ord=null;
        Token MODIFIER6=null;
        Tincture t = null;


        try {
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:110:9: (ord= ( ORDINARY | OTHER_ORDINARY ) ( MODIFIER )? t= tincture[tinctures] )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:110:13: ord= ( ORDINARY | OTHER_ORDINARY ) ( MODIFIER )? t= tincture[tinctures]
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
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:111:13: ( MODIFIER )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==MODIFIER) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:111:15: MODIFIER
                    {
                    MODIFIER6=(Token)match(input,MODIFIER,FOLLOW_MODIFIER_in_ordinary349); 
                     text += "_" + (MODIFIER6!=null?MODIFIER6.getText():null); 

                    }
                    break;

            }

            pushFollow(FOLLOW_tincture_in_ordinary370);
            t=tincture(tinctures);

            state._fsp--;

             
                            TinctureType thisTinctureType = t.getTinctureType();
                            if (underLayerTinctureType == thisTinctureType) {
                                if (thisTinctureType == TinctureType.COLOUR || thisTinctureType == TinctureType.METAL) {
                                    diags.add(ShieldDiagnostic.build(LogLevel.WARN, "You are not obeying the rule of tincture. You can not put a colour on a colour, or a metal on a metal"));
                                }
                            }              
                            ordinary = new Ordinary().getOrdinaryType(text, t, diags);
                        

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
    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:124:1: div returns [ShieldDivisionType division] : ( ( TIERCED )? PARTYPER divType= ( ORDINARY | OTHER_DIV ) (divModifier1= MODIFIER )? | VARIABLE_DIV (divModifier2= MODIFIER )? ( OF number_digits_or_words )? | CONTINUOUS_DIV | QUARTER ) ;
    public final ShieldDivisionType div() throws RecognitionException {
        ShieldDivisionType division = null;

        Token divType=null;
        Token divModifier1=null;
        Token divModifier2=null;
        Token TIERCED7=null;
        Token VARIABLE_DIV8=null;
        Token OF9=null;
        Token CONTINUOUS_DIV11=null;
        Token QUARTER12=null;
        BlazonParser.number_digits_or_words_return number_digits_or_words10 = null;


        try {
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:125:9: ( ( ( TIERCED )? PARTYPER divType= ( ORDINARY | OTHER_DIV ) (divModifier1= MODIFIER )? | VARIABLE_DIV (divModifier2= MODIFIER )? ( OF number_digits_or_words )? | CONTINUOUS_DIV | QUARTER ) )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:125:13: ( ( TIERCED )? PARTYPER divType= ( ORDINARY | OTHER_DIV ) (divModifier1= MODIFIER )? | VARIABLE_DIV (divModifier2= MODIFIER )? ( OF number_digits_or_words )? | CONTINUOUS_DIV | QUARTER )
            {
             String text = ""; 
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:126:9: ( ( TIERCED )? PARTYPER divType= ( ORDINARY | OTHER_DIV ) (divModifier1= MODIFIER )? | VARIABLE_DIV (divModifier2= MODIFIER )? ( OF number_digits_or_words )? | CONTINUOUS_DIV | QUARTER )
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
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:127:13: ( TIERCED )? PARTYPER divType= ( ORDINARY | OTHER_DIV ) (divModifier1= MODIFIER )?
                    {
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:127:13: ( TIERCED )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==TIERCED) ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:128:17: TIERCED
                            {
                            TIERCED7=(Token)match(input,TIERCED,FOLLOW_TIERCED_in_div462); 
                             text = (TIERCED7!=null?TIERCED7.getText():null) + " "; 

                            }
                            break;

                    }

                    match(input,PARTYPER,FOLLOW_PARTYPER_in_div493); 
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
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:132:13: (divModifier1= MODIFIER )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==MODIFIER) ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:133:17: divModifier1= MODIFIER
                            {
                            divModifier1=(Token)match(input,MODIFIER,FOLLOW_MODIFIER_in_div555); 
                             text += " " + (divModifier1!=null?divModifier1.getText():null); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:136:13: VARIABLE_DIV (divModifier2= MODIFIER )? ( OF number_digits_or_words )?
                    {
                    VARIABLE_DIV8=(Token)match(input,VARIABLE_DIV,FOLLOW_VARIABLE_DIV_in_div596); 
                     text = (VARIABLE_DIV8!=null?VARIABLE_DIV8.getText():null); 
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:137:13: (divModifier2= MODIFIER )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==MODIFIER) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:138:17: divModifier2= MODIFIER
                            {
                            divModifier2=(Token)match(input,MODIFIER,FOLLOW_MODIFIER_in_div634); 
                             text += " " + (divModifier2!=null?divModifier2.getText():null); 

                            }
                            break;

                    }

                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:140:13: ( OF number_digits_or_words )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==OF) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:141:17: OF number_digits_or_words
                            {
                            OF9=(Token)match(input,OF,FOLLOW_OF_in_div683); 
                             text += " " + (OF9!=null?OF9.getText():null); 
                            pushFollow(FOLLOW_number_digits_or_words_in_div703);
                            number_digits_or_words10=number_digits_or_words();

                            state._fsp--;


                                                try {
                                                    int gyronnyOf = converter.convert((number_digits_or_words10!=null?input.toString(number_digits_or_words10.start,number_digits_or_words10.stop):null));
                                                    if (gyronnyOf % 2 != 0) {
                                                        gyronnyOf++;
                                                        diags.add(ShieldDiagnostic.build(LogLevel.WARN, "Parsing rule 'div'.  '" + (VARIABLE_DIV8!=null?VARIABLE_DIV8.getText():null) 
                                                                + "' can only be of an even number; incremented number of sections to " + gyronnyOf));
                                                    }
                                                    text += " " + gyronnyOf;
                                                } catch (Exception e) {
                                                    diags.add(ShieldDiagnostic.build(LogLevel.ERROR, "Unable to convert '" + (number_digits_or_words10!=null?input.toString(number_digits_or_words10.start,number_digits_or_words10.stop):null) 
                                                        + "' into an integer. Caught: " +  e));
                                                    throw new RecognitionException(this.input);
                                                }
                                            

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:160:13: CONTINUOUS_DIV
                    {
                    CONTINUOUS_DIV11=(Token)match(input,CONTINUOUS_DIV,FOLLOW_CONTINUOUS_DIV_in_div760); 
                     text = (CONTINUOUS_DIV11!=null?CONTINUOUS_DIV11.getText():null); 

                    }
                    break;
                case 4 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:162:13: QUARTER
                    {
                    QUARTER12=(Token)match(input,QUARTER,FOLLOW_QUARTER_in_div786); 
                     text = (QUARTER12!=null?QUARTER12.getText():null); 

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
    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:173:1: some_tinctures[Tinctures tinctures, ShieldDivisionType division] returns [ShieldLayer layer] : ( tincture[tinctures] )+ AND tincture[tinctures] ;
    public final ShieldLayer some_tinctures(Tinctures tinctures, ShieldDivisionType division) throws RecognitionException {
        ShieldLayer layer = null;

        try {
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:174:9: ( ( tincture[tinctures] )+ AND tincture[tinctures] )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:174:13: ( tincture[tinctures] )+ AND tincture[tinctures]
            {
             int count = 0; 
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:175:13: ( tincture[tinctures] )+
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
            	    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:176:17: tincture[tinctures]
            	    {
            	    pushFollow(FOLLOW_tincture_in_some_tinctures885);
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

            match(input,AND,FOLLOW_AND_in_some_tinctures934); 
            pushFollow(FOLLOW_tincture_in_some_tinctures948);
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
    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:194:1: tincture[Tinctures tinctures] returns [Tincture tincture] : ( COLOUR | METAL | FUR ) ;
    public final Tincture tincture(Tinctures tinctures) throws RecognitionException {
        Tincture tincture = null;

        Token COLOUR13=null;
        Token METAL14=null;
        Token FUR15=null;

        try {
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:195:9: ( ( COLOUR | METAL | FUR ) )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:195:13: ( COLOUR | METAL | FUR )
            {
             String tinctureName = ""; 
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:196:9: ( COLOUR | METAL | FUR )
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
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:196:13: COLOUR
                    {
                    COLOUR13=(Token)match(input,COLOUR,FOLLOW_COLOUR_in_tincture1013); 
                     tinctureName = (COLOUR13!=null?COLOUR13.getText():null); 

                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:197:13: METAL
                    {
                    METAL14=(Token)match(input,METAL,FOLLOW_METAL_in_tincture1029); 
                     tinctureName = (METAL14!=null?METAL14.getText():null); 

                    }
                    break;
                case 3 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:198:13: FUR
                    {
                    FUR15=(Token)match(input,FUR,FOLLOW_FUR_in_tincture1046); 
                     tinctureName = (FUR15!=null?FUR15.getText():null); 

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
    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:210:1: number_digits_or_words : ( DIGITS | NUMWORDS ( ( AND )? NUMWORDS )* );
    public final BlazonParser.number_digits_or_words_return number_digits_or_words() throws RecognitionException {
        BlazonParser.number_digits_or_words_return retval = new BlazonParser.number_digits_or_words_return();
        retval.start = input.LT(1);

        try {
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:211:9: ( DIGITS | NUMWORDS ( ( AND )? NUMWORDS )* )
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
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:211:13: DIGITS
                    {
                    match(input,DIGITS,FOLLOW_DIGITS_in_number_digits_or_words1098); 

                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:212:13: NUMWORDS ( ( AND )? NUMWORDS )*
                    {
                    match(input,NUMWORDS,FOLLOW_NUMWORDS_in_number_digits_or_words1112); 
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:212:22: ( ( AND )? NUMWORDS )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==AND||LA13_0==NUMWORDS) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:212:23: ( AND )? NUMWORDS
                    	    {
                    	    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:212:23: ( AND )?
                    	    int alt12=2;
                    	    int LA12_0 = input.LA(1);

                    	    if ( (LA12_0==AND) ) {
                    	        alt12=1;
                    	    }
                    	    switch (alt12) {
                    	        case 1 :
                    	            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:212:23: AND
                    	            {
                    	            match(input,AND,FOLLOW_AND_in_number_digits_or_words1115); 

                    	            }
                    	            break;

                    	    }

                    	    match(input,NUMWORDS,FOLLOW_NUMWORDS_in_number_digits_or_words1118); 

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


 

    public static final BitSet FOLLOW_field_in_shield82 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_charges_in_shield94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_div_in_field166 = new BitSet(new long[]{0x0000000000070000L});
    public static final BitSet FOLLOW_some_tinctures_in_field182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tincture_in_field209 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_22_in_field212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_A_in_charges270 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_ordinary_in_charges272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_ordinary324 = new BitSet(new long[]{0x0000000000070080L});
    public static final BitSet FOLLOW_MODIFIER_in_ordinary349 = new BitSet(new long[]{0x0000000000070000L});
    public static final BitSet FOLLOW_tincture_in_ordinary370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TIERCED_in_div462 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_PARTYPER_in_div493 = new BitSet(new long[]{0x0000000000000420L});
    public static final BitSet FOLLOW_set_in_div511 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_MODIFIER_in_div555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_DIV_in_div596 = new BitSet(new long[]{0x0000000000001082L});
    public static final BitSet FOLLOW_MODIFIER_in_div634 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_OF_in_div683 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_number_digits_or_words_in_div703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONTINUOUS_DIV_in_div760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUARTER_in_div786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tincture_in_some_tinctures885 = new BitSet(new long[]{0x0000000000078000L});
    public static final BitSet FOLLOW_AND_in_some_tinctures934 = new BitSet(new long[]{0x0000000000070000L});
    public static final BitSet FOLLOW_tincture_in_some_tinctures948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COLOUR_in_tincture1013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_METAL_in_tincture1029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUR_in_tincture1046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DIGITS_in_number_digits_or_words1098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMWORDS_in_number_digits_or_words1112 = new BitSet(new long[]{0x0000000000108002L});
    public static final BitSet FOLLOW_AND_in_number_digits_or_words1115 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_NUMWORDS_in_number_digits_or_words1118 = new BitSet(new long[]{0x0000000000108002L});

}