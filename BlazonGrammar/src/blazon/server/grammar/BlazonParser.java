// $ANTLR 3.3 Nov 30, 2010 12:50:56 /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g 2011-10-27 19:14:42

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "DETERMINER", "ORDINARY_DIV", "OTHER_ORDINARY", "SUBORDINARY_DIV", "SUBORDINARY", "MODIFIER", "TIERCED", "PARTYPER", "VARIABLE_DIV", "OF", "CONTINUOUS_DIV", "QUARTER", "AND", "COLOUR", "METAL", "FUR", "DIGITS", "NUMWORDS", "SUBORDINARY_MULTIPLE", "WS", "'plain'"
    };
    public static final int EOF=-1;
    public static final int T__24=24;
    public static final int DETERMINER=4;
    public static final int ORDINARY_DIV=5;
    public static final int OTHER_ORDINARY=6;
    public static final int SUBORDINARY_DIV=7;
    public static final int SUBORDINARY=8;
    public static final int MODIFIER=9;
    public static final int TIERCED=10;
    public static final int PARTYPER=11;
    public static final int VARIABLE_DIV=12;
    public static final int OF=13;
    public static final int CONTINUOUS_DIV=14;
    public static final int QUARTER=15;
    public static final int AND=16;
    public static final int COLOUR=17;
    public static final int METAL=18;
    public static final int FUR=19;
    public static final int DIGITS=20;
    public static final int NUMWORDS=21;
    public static final int SUBORDINARY_MULTIPLE=22;
    public static final int WS=23;

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
    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:73:1: shield returns [Shield s] : field ( charges[$field.field.getTinctureTypeOfLayer()] )? ;
    public final Shield shield() throws RecognitionException {
        Shield s = null;

        Field field1 = null;

        List<GeometricCharge> charges2 = null;


        try {
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:74:7: ( field ( charges[$field.field.getTinctureTypeOfLayer()] )? )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:74:11: field ( charges[$field.field.getTinctureTypeOfLayer()] )?
            {
             String blazon = input.toString(); 
            pushFollow(FOLLOW_field_in_shield82);
            field1=field();

            state._fsp--;

             s = ShieldImpl.build(field1, blazon); 
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:76:7: ( charges[$field.field.getTinctureTypeOfLayer()] )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==DETERMINER||(LA1_0>=DIGITS && LA1_0<=NUMWORDS)) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:76:9: charges[$field.field.getTinctureTypeOfLayer()]
                    {
                    pushFollow(FOLLOW_charges_in_shield94);
                    charges2=charges(field1.getTinctureTypeOfLayer());

                    state._fsp--;

                     s.addCharges(charges2); 

                    }
                    break;

            }


            		        //LATER make HTML pretty
            				    //TODO multiple geometric charges
            				    //TODO advanced charges
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
    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:89:1: field returns [Field field] : ( div some_tinctures[tinctures, division] | tincture[tinctures] ( 'plain' )? ) ;
    public final Field field() throws RecognitionException {
        Field field = null;

        ShieldDivisionType div3 = null;

        Field some_tinctures4 = null;


        try {
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:90:7: ( ( div some_tinctures[tinctures, division] | tincture[tinctures] ( 'plain' )? ) )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:90:11: ( div some_tinctures[tinctures, division] | tincture[tinctures] ( 'plain' )? )
            {
             Tinctures tinctures = new Tinctures(); 
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:91:7: ( div some_tinctures[tinctures, division] | tincture[tinctures] ( 'plain' )? )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>=TIERCED && LA3_0<=VARIABLE_DIV)||(LA3_0>=CONTINUOUS_DIV && LA3_0<=QUARTER)) ) {
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

                     field = some_tinctures4; 

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

                    if ( (LA2_0==24) ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:95:33: 'plain'
                            {
                            match(input,24,FOLLOW_24_in_field212); 

                            }
                            break;

                    }


                                    field = Field.buildUndividedShieldLayer(tinctures);
                                

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
        return field;
    }
    // $ANTLR end "field"


    // $ANTLR start "charges"
    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:101:1: charges[TinctureType underLayerTinctureType] returns [List<GeometricCharge> charges] : ( DETERMINER gc1= geometric_charge[tinctures, underLayerTinctureType] | number_digits_or_words gc2= geometric_charge[tinctures, underLayerTinctureType] ) ;
    public final List<GeometricCharge> charges(TinctureType underLayerTinctureType) throws RecognitionException {
        List<GeometricCharge> charges = null;

        Token DETERMINER5=null;
        GeometricCharge gc1 = null;

        GeometricCharge gc2 = null;


        try {
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:102:9: ( ( DETERMINER gc1= geometric_charge[tinctures, underLayerTinctureType] | number_digits_or_words gc2= geometric_charge[tinctures, underLayerTinctureType] ) )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:102:13: ( DETERMINER gc1= geometric_charge[tinctures, underLayerTinctureType] | number_digits_or_words gc2= geometric_charge[tinctures, underLayerTinctureType] )
            {
             
                          Tinctures tinctures = new Tinctures();
                          charges = new ArrayList<GeometricCharge>();
                        
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:106:13: ( DETERMINER gc1= geometric_charge[tinctures, underLayerTinctureType] | number_digits_or_words gc2= geometric_charge[tinctures, underLayerTinctureType] )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==DETERMINER) ) {
                alt4=1;
            }
            else if ( ((LA4_0>=DIGITS && LA4_0<=NUMWORDS)) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:107:17: DETERMINER gc1= geometric_charge[tinctures, underLayerTinctureType]
                    {
                    DETERMINER5=(Token)match(input,DETERMINER,FOLLOW_DETERMINER_in_charges288); 
                    pushFollow(FOLLOW_geometric_charge_in_charges292);
                    gc1=geometric_charge(tinctures, underLayerTinctureType);

                    state._fsp--;

                     
                                        if (gc1 != null) {
                                            charges.add(gc1);
                                            if ("a".equals((DETERMINER5!=null?DETERMINER5.getText():null))) {
                                                String chargeName = gc1.getName().toString().toLowerCase();
                                                if (chargeName.startsWith("a") || chargeName.startsWith("e") || chargeName.startsWith("i") || chargeName.startsWith("o") || chargeName.startsWith("u")) {
                                                    diags.add(ShieldDiagnostic.build(LogLevel.WARN, "You have asked for the charge '" + (DETERMINER5!=null?DETERMINER5.getText():null) + " " + chargeName 
                                                        + "'. A charge starting with a vowel should be preceded by 'an' i.e. 'an " + chargeName + "'."));
                                                }
                                            } else if ("an".equals((DETERMINER5!=null?DETERMINER5.getText():null))) {
                                                String chargeName = gc1.getName().toString().toLowerCase();
                                                if (!(chargeName.startsWith("a") || chargeName.startsWith("e") || chargeName.startsWith("i") || chargeName.startsWith("o") || chargeName.startsWith("u"))) {
                                                    diags.add(ShieldDiagnostic.build(LogLevel.WARN, "You have asked for the charge '" + (DETERMINER5!=null?DETERMINER5.getText():null) + " " + chargeName 
                                                        + "'. A charge starting with a consonants should be preceded by 'a' i.e. 'a " + chargeName + "'."));
                                                }
                                           }
                                       }
                                    

                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:127:17: number_digits_or_words gc2= geometric_charge[tinctures, underLayerTinctureType]
                    {
                    pushFollow(FOLLOW_number_digits_or_words_in_charges343);
                    number_digits_or_words();

                    state._fsp--;

                    pushFollow(FOLLOW_geometric_charge_in_charges347);
                    gc2=geometric_charge(tinctures, underLayerTinctureType);

                    state._fsp--;


                                        if (gc2 != null) {
                                            charges.add(gc2);
                                        }
                                    

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
        return charges;
    }
    // $ANTLR end "charges"


    // $ANTLR start "geometric_charge"
    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:139:1: geometric_charge[Tinctures tinctures, TinctureType underLayerTinctureType] returns [GeometricCharge charge] : ord= ( ORDINARY_DIV | OTHER_ORDINARY | SUBORDINARY_DIV | SUBORDINARY ) ( MODIFIER )? t= tincture[tinctures] ;
    public final GeometricCharge geometric_charge(Tinctures tinctures, TinctureType underLayerTinctureType) throws RecognitionException {
        GeometricCharge charge = null;

        Token ord=null;
        Token MODIFIER6=null;
        Tincture t = null;


        try {
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:140:9: (ord= ( ORDINARY_DIV | OTHER_ORDINARY | SUBORDINARY_DIV | SUBORDINARY ) ( MODIFIER )? t= tincture[tinctures] )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:140:13: ord= ( ORDINARY_DIV | OTHER_ORDINARY | SUBORDINARY_DIV | SUBORDINARY ) ( MODIFIER )? t= tincture[tinctures]
            {
            ord=(Token)input.LT(1);
            if ( (input.LA(1)>=ORDINARY_DIV && input.LA(1)<=SUBORDINARY) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

             String text = (ord!=null?ord.getText():null); 
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:141:13: ( MODIFIER )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==MODIFIER) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:141:15: MODIFIER
                    {
                    MODIFIER6=(Token)match(input,MODIFIER,FOLLOW_MODIFIER_in_geometric_charge464); 
                     text += "_" + (MODIFIER6!=null?MODIFIER6.getText():null); 

                    }
                    break;

            }

            pushFollow(FOLLOW_tincture_in_geometric_charge485);
            t=tincture(tinctures);

            state._fsp--;

             
                            TinctureType thisTinctureType = t.getTinctureType();
                            if (underLayerTinctureType == thisTinctureType) {
                                if (thisTinctureType == TinctureType.COLOUR || thisTinctureType == TinctureType.METAL) {
                                    diags.add(ShieldDiagnostic.build(LogLevel.WARN, "You are not obeying the rule of tincture. You can not put a colour on a colour, or a metal on a metal"));
                                }
                            }              
                            charge = GeometricCharge.build(text, t, diags);
                        

            }

        }

            catch (RecognitionException re) {
                throw re;
            }
        finally {
        }
        return charge;
    }
    // $ANTLR end "geometric_charge"


    // $ANTLR start "div"
    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:154:1: div returns [ShieldDivisionType division] : ( ( TIERCED )? PARTYPER divType= ( ORDINARY_DIV | SUBORDINARY_DIV ) (divModifier1= MODIFIER )? | VARIABLE_DIV (divModifier2= MODIFIER )? ( OF number_digits_or_words )? | CONTINUOUS_DIV | QUARTER ) ;
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
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:155:9: ( ( ( TIERCED )? PARTYPER divType= ( ORDINARY_DIV | SUBORDINARY_DIV ) (divModifier1= MODIFIER )? | VARIABLE_DIV (divModifier2= MODIFIER )? ( OF number_digits_or_words )? | CONTINUOUS_DIV | QUARTER ) )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:155:13: ( ( TIERCED )? PARTYPER divType= ( ORDINARY_DIV | SUBORDINARY_DIV ) (divModifier1= MODIFIER )? | VARIABLE_DIV (divModifier2= MODIFIER )? ( OF number_digits_or_words )? | CONTINUOUS_DIV | QUARTER )
            {
             String text = ""; 
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:156:9: ( ( TIERCED )? PARTYPER divType= ( ORDINARY_DIV | SUBORDINARY_DIV ) (divModifier1= MODIFIER )? | VARIABLE_DIV (divModifier2= MODIFIER )? ( OF number_digits_or_words )? | CONTINUOUS_DIV | QUARTER )
            int alt10=4;
            switch ( input.LA(1) ) {
            case TIERCED:
            case PARTYPER:
                {
                alt10=1;
                }
                break;
            case VARIABLE_DIV:
                {
                alt10=2;
                }
                break;
            case CONTINUOUS_DIV:
                {
                alt10=3;
                }
                break;
            case QUARTER:
                {
                alt10=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:157:13: ( TIERCED )? PARTYPER divType= ( ORDINARY_DIV | SUBORDINARY_DIV ) (divModifier1= MODIFIER )?
                    {
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:157:13: ( TIERCED )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==TIERCED) ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:158:17: TIERCED
                            {
                            TIERCED7=(Token)match(input,TIERCED,FOLLOW_TIERCED_in_div577); 
                             text = (TIERCED7!=null?TIERCED7.getText():null) + " "; 

                            }
                            break;

                    }

                    match(input,PARTYPER,FOLLOW_PARTYPER_in_div608); 
                    divType=(Token)input.LT(1);
                    if ( input.LA(1)==ORDINARY_DIV||input.LA(1)==SUBORDINARY_DIV ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                     text += (divType!=null?divType.getText():null); 
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:162:13: (divModifier1= MODIFIER )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==MODIFIER) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:163:17: divModifier1= MODIFIER
                            {
                            divModifier1=(Token)match(input,MODIFIER,FOLLOW_MODIFIER_in_div670); 
                             text += " " + (divModifier1!=null?divModifier1.getText():null); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:166:13: VARIABLE_DIV (divModifier2= MODIFIER )? ( OF number_digits_or_words )?
                    {
                    VARIABLE_DIV8=(Token)match(input,VARIABLE_DIV,FOLLOW_VARIABLE_DIV_in_div711); 
                     text = (VARIABLE_DIV8!=null?VARIABLE_DIV8.getText():null); 
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:167:13: (divModifier2= MODIFIER )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==MODIFIER) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:168:17: divModifier2= MODIFIER
                            {
                            divModifier2=(Token)match(input,MODIFIER,FOLLOW_MODIFIER_in_div749); 
                             text += " " + (divModifier2!=null?divModifier2.getText():null); 

                            }
                            break;

                    }

                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:170:13: ( OF number_digits_or_words )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==OF) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:171:17: OF number_digits_or_words
                            {
                            OF9=(Token)match(input,OF,FOLLOW_OF_in_div798); 
                             text += " " + (OF9!=null?OF9.getText():null); 
                            pushFollow(FOLLOW_number_digits_or_words_in_div818);
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
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:190:13: CONTINUOUS_DIV
                    {
                    CONTINUOUS_DIV11=(Token)match(input,CONTINUOUS_DIV,FOLLOW_CONTINUOUS_DIV_in_div875); 
                     text = (CONTINUOUS_DIV11!=null?CONTINUOUS_DIV11.getText():null); 

                    }
                    break;
                case 4 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:192:13: QUARTER
                    {
                    QUARTER12=(Token)match(input,QUARTER,FOLLOW_QUARTER_in_div901); 
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
    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:203:1: some_tinctures[Tinctures tinctures, ShieldDivisionType division] returns [Field layer] : ( tincture[tinctures] )+ AND tincture[tinctures] ;
    public final Field some_tinctures(Tinctures tinctures, ShieldDivisionType division) throws RecognitionException {
        Field layer = null;

        try {
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:204:9: ( ( tincture[tinctures] )+ AND tincture[tinctures] )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:204:13: ( tincture[tinctures] )+ AND tincture[tinctures]
            {
             int count = 0; 
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:205:13: ( tincture[tinctures] )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>=COLOUR && LA11_0<=FUR)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:206:17: tincture[tinctures]
            	    {
            	    pushFollow(FOLLOW_tincture_in_some_tinctures1000);
            	    tincture(tinctures);

            	    state._fsp--;

            	     count++; 

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

            match(input,AND,FOLLOW_AND_in_some_tinctures1049); 
            pushFollow(FOLLOW_tincture_in_some_tinctures1063);
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
                            layer = Field.buildDividedShieldLayer(tinctures, division);
                        

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
    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:224:1: tincture[Tinctures tinctures] returns [Tincture tincture] : ( COLOUR | METAL | FUR ) ;
    public final Tincture tincture(Tinctures tinctures) throws RecognitionException {
        Tincture tincture = null;

        Token COLOUR13=null;
        Token METAL14=null;
        Token FUR15=null;

        try {
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:225:9: ( ( COLOUR | METAL | FUR ) )
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:225:13: ( COLOUR | METAL | FUR )
            {
             String tinctureName = ""; 
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:226:9: ( COLOUR | METAL | FUR )
            int alt12=3;
            switch ( input.LA(1) ) {
            case COLOUR:
                {
                alt12=1;
                }
                break;
            case METAL:
                {
                alt12=2;
                }
                break;
            case FUR:
                {
                alt12=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:226:13: COLOUR
                    {
                    COLOUR13=(Token)match(input,COLOUR,FOLLOW_COLOUR_in_tincture1128); 
                     tinctureName = (COLOUR13!=null?COLOUR13.getText():null); 

                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:227:13: METAL
                    {
                    METAL14=(Token)match(input,METAL,FOLLOW_METAL_in_tincture1144); 
                     tinctureName = (METAL14!=null?METAL14.getText():null); 

                    }
                    break;
                case 3 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:228:13: FUR
                    {
                    FUR15=(Token)match(input,FUR,FOLLOW_FUR_in_tincture1161); 
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
    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:240:1: number_digits_or_words : ( DIGITS | NUMWORDS ( ( AND )? NUMWORDS )* );
    public final BlazonParser.number_digits_or_words_return number_digits_or_words() throws RecognitionException {
        BlazonParser.number_digits_or_words_return retval = new BlazonParser.number_digits_or_words_return();
        retval.start = input.LT(1);

        try {
            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:241:9: ( DIGITS | NUMWORDS ( ( AND )? NUMWORDS )* )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==DIGITS) ) {
                alt15=1;
            }
            else if ( (LA15_0==NUMWORDS) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:241:13: DIGITS
                    {
                    match(input,DIGITS,FOLLOW_DIGITS_in_number_digits_or_words1213); 

                    }
                    break;
                case 2 :
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:242:13: NUMWORDS ( ( AND )? NUMWORDS )*
                    {
                    match(input,NUMWORDS,FOLLOW_NUMWORDS_in_number_digits_or_words1227); 
                    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:242:22: ( ( AND )? NUMWORDS )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==AND||LA14_0==NUMWORDS) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:242:23: ( AND )? NUMWORDS
                    	    {
                    	    // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:242:23: ( AND )?
                    	    int alt13=2;
                    	    int LA13_0 = input.LA(1);

                    	    if ( (LA13_0==AND) ) {
                    	        alt13=1;
                    	    }
                    	    switch (alt13) {
                    	        case 1 :
                    	            // /Users/luketorjussen/Documents/workspace2/BlazonGrammar/grammar/Blazon.g:242:23: AND
                    	            {
                    	            match(input,AND,FOLLOW_AND_in_number_digits_or_words1230); 

                    	            }
                    	            break;

                    	    }

                    	    match(input,NUMWORDS,FOLLOW_NUMWORDS_in_number_digits_or_words1233); 

                    	    }
                    	    break;

                    	default :
                    	    break loop14;
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


 

    public static final BitSet FOLLOW_field_in_shield82 = new BitSet(new long[]{0x0000000000300012L});
    public static final BitSet FOLLOW_charges_in_shield94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_div_in_field166 = new BitSet(new long[]{0x00000000000E0000L});
    public static final BitSet FOLLOW_some_tinctures_in_field182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tincture_in_field209 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_field212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DETERMINER_in_charges288 = new BitSet(new long[]{0x00000000000001E0L});
    public static final BitSet FOLLOW_geometric_charge_in_charges292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_number_digits_or_words_in_charges343 = new BitSet(new long[]{0x00000000000001E0L});
    public static final BitSet FOLLOW_geometric_charge_in_charges347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_geometric_charge431 = new BitSet(new long[]{0x00000000000E0200L});
    public static final BitSet FOLLOW_MODIFIER_in_geometric_charge464 = new BitSet(new long[]{0x00000000000E0000L});
    public static final BitSet FOLLOW_tincture_in_geometric_charge485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TIERCED_in_div577 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_PARTYPER_in_div608 = new BitSet(new long[]{0x00000000000000A0L});
    public static final BitSet FOLLOW_set_in_div626 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_MODIFIER_in_div670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_DIV_in_div711 = new BitSet(new long[]{0x0000000000002202L});
    public static final BitSet FOLLOW_MODIFIER_in_div749 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_OF_in_div798 = new BitSet(new long[]{0x0000000000300010L});
    public static final BitSet FOLLOW_number_digits_or_words_in_div818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONTINUOUS_DIV_in_div875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUARTER_in_div901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tincture_in_some_tinctures1000 = new BitSet(new long[]{0x00000000000F0000L});
    public static final BitSet FOLLOW_AND_in_some_tinctures1049 = new BitSet(new long[]{0x00000000000E0000L});
    public static final BitSet FOLLOW_tincture_in_some_tinctures1063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COLOUR_in_tincture1128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_METAL_in_tincture1144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUR_in_tincture1161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DIGITS_in_number_digits_or_words1213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMWORDS_in_number_digits_or_words1227 = new BitSet(new long[]{0x0000000000210002L});
    public static final BitSet FOLLOW_AND_in_number_digits_or_words1230 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_NUMWORDS_in_number_digits_or_words1233 = new BitSet(new long[]{0x0000000000210002L});

}