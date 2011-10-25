package blazon.server.grammar;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.RecognitionException;
import org.junit.Test;

import blazon.shared.shield.ChargedShieldLayer;
import blazon.shared.shield.charges.GeometricCharge;
import blazon.shared.shield.charges.GeometricChargeNames;
import blazon.shared.shield.diagnostic.ShieldDiagnostic;
import blazon.shared.shield.tinctures.TinctureType;
import blazon.shared.shield.tinctures.Tinctures;
import blazon.shared.shield.tinctures.UnknownTinctureException;

public class GrammarChargesTest {

	@Test
	public void testThatAChiefGulesReturnsAnObjectRepresentingALayerWithAChiefColouredGules() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("a chief gules");
		Tinctures tinctures = new Tinctures(); 
		ChargedShieldLayer chargedLayer = parser.charges(TinctureType.OTHER);
		GeometricCharge ordinary = chargedLayer.getOrdinary();
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.CHIEF)));
		assertThat(ordinary.getTincture(), is(equalTo(tinctures.getTincture("gules"))));
	}
	
	@Test
	public void testThatABaseOrReturnsAnObjectRepresentingALayerWithABaseColouredOr() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("a base or");
		Tinctures tinctures = new Tinctures(); 
		ChargedShieldLayer chargedLayer = parser.charges(TinctureType.OTHER);
		GeometricCharge ordinary = chargedLayer.getOrdinary();
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.BASE)));
		assertThat(ordinary.getTincture(), is(equalTo(tinctures.getTincture("or"))));
	}
	
	@Test
	public void testThatABendGulesReturnsAnObjectRepresentingALayerWithABendColouredGules() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("a bend gules");
		Tinctures tinctures = new Tinctures(); 
		ChargedShieldLayer chargedLayer = parser.charges(TinctureType.OTHER);
		GeometricCharge ordinary = chargedLayer.getOrdinary();
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.BEND)));
		assertThat(ordinary.getTincture(), is(equalTo(tinctures.getTincture("gules"))));
	}
	
	@Test
	public void testThatABendGulesOnColourFieldReturnsCorrectObjectButGivesWarningAboutNotFollowingRuleOfTincture() throws RecognitionException, UnknownTinctureException {
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		BlazonParser parser = new ParserCreator().createParser("a bend gules", diags );
		Tinctures tinctures = new Tinctures(); 
		ChargedShieldLayer chargedLayer = parser.charges(TinctureType.COLOUR);
		GeometricCharge ordinary = chargedLayer.getOrdinary();
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.BEND)));
		assertThat(ordinary.getTincture(), is(equalTo(tinctures.getTincture("gules"))));
		assertThat(diags.size(), is(1));
		assertThat(diags.get(0).getSeverity(), is(ShieldDiagnostic.LogLevel.WARN));
		assertThat(diags.get(0).getMessage(), is("You are not obeying the rule of tincture. You can not put a colour on a colour, or a metal on a metal"));
	}
	
	@Test
	public void testThatABendOrOnMetalFieldReturnsCorrectObjectButGivesWarningAboutNotFollowingRuleOfTincture() throws RecognitionException, UnknownTinctureException {
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		BlazonParser parser = new ParserCreator().createParser("a bend or", diags );
		Tinctures tinctures = new Tinctures(); 
		ChargedShieldLayer chargedLayer = parser.charges(TinctureType.METAL);
		GeometricCharge ordinary = chargedLayer.getOrdinary();
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.BEND)));
		assertThat(ordinary.getTincture(), is(equalTo(tinctures.getTincture("or"))));
		assertThat(diags.size(), is(1));
		assertThat(diags.get(0).getSeverity(), is(ShieldDiagnostic.LogLevel.WARN));
		assertThat(diags.get(0).getMessage(), is(equalTo("You are not obeying the rule of tincture. You can not put a colour on a colour, or a metal on a metal")));
	}
	
	@Test
	public void testThatAPallVairOnOtherFieldReturnsCorrectObjectAndGivesNoWarningAboutNotFollowingRuleOfTincture() throws RecognitionException, UnknownTinctureException {
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		BlazonParser parser = new ParserCreator().createParser("a pall vair", diags );
		Tinctures tinctures = new Tinctures(); 
		ChargedShieldLayer chargedLayer = parser.charges(TinctureType.OTHER);
		GeometricCharge ordinary = chargedLayer.getOrdinary();
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.PALL)));
		assertThat(ordinary.getTincture(), is(equalTo(tinctures.getTincture("vair"))));
		assertThat(diags.size(), is(0));
	}
	
	@Test
	public void testThatAPileReversedGulesReturnsAnObjectRepresentingAPileReversedColouredGules() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("a pile reversed gules");
		Tinctures tinctures = new Tinctures(); 
		ChargedShieldLayer chargedLayer = parser.charges(TinctureType.OTHER);
		GeometricCharge ordinary = chargedLayer.getOrdinary();
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.PILE_REVERSED)));
		assertThat(ordinary.getTincture(), is(equalTo(tinctures.getTincture("gules"))));
	}
	
	@Test(expected=MismatchedSetException.class)
	public void testThatABlahGulesThrowsAMismatchedSetException() throws RecognitionException {
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		BlazonParser parser = new ParserCreator().createParser("a blah gules", diags);
		parser.charges(TinctureType.OTHER);
	}
	
	@Test
	public void testThatBendGulesGivesErrorStatingThatAIsMissing() throws RecognitionException {
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		BlazonParser parser = new ParserCreator().createParser("bend gules", diags);
		parser.charges(TinctureType.OTHER);
		assertThat(diags.size(), is(1));
		assertThat(diags.get(0).getSeverity(), is(ShieldDiagnostic.LogLevel.ERROR));
		assertThat(diags.get(0).getMessage(), is(equalTo("line 1:0 missing A at 'bend'")));
	}
	
	@Test
	public void testThatABendBlahGulesReturnsAnObjectRepresentingBend() throws RecognitionException, UnknownTinctureException {
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		BlazonParser parser = new ParserCreator().createParser("a bend blah gules", diags);
		Tinctures tinctures = new Tinctures(); 
		ChargedShieldLayer chargedLayer = parser.charges(TinctureType.OTHER);
		GeometricCharge ordinary = chargedLayer.getOrdinary();
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.BEND)));
		assertThat(ordinary.getTincture(), is(tinctures.getTincture("gules")));
	}
}
