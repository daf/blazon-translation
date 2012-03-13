package blazon.server.grammar;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.RecognitionException;
import org.junit.Test;

import org.antlr.runtime.NoViableAltException;
import blazon.shared.shield.charges.GeometricCharge;
import blazon.shared.shield.charges.GeometricChargeNames;
import blazon.shared.shield.diagnostic.ShieldDiagnostic;
import blazon.shared.shield.diagnostic.ShieldDiagnostic.LogLevel;
import blazon.shared.shield.tinctures.TinctureType;
import blazon.shared.shield.tinctures.Tinctures;
import blazon.shared.shield.tinctures.UnknownTinctureException;

public class GrammarSingleGeometricChargeTest {
	@Test
	public void testThatChiefGulesReturnsAnObjectRepresentingALayerWithChiefColouredGules() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("chief gules");
		Tinctures tinctures = new Tinctures(); 
		GeometricCharge ordinary = parser.single_geometric_charge(tinctures, TinctureType.OTHER);
		assertThat(ordinary.getType(), is(equalTo(GeometricChargeNames.CHIEF)));
		assertThat(ordinary.getTincture(), is(equalTo(tinctures.getTincture("gules"))));
	}
	
	@Test
	public void testThatBaseOrReturnsAnObjectRepresentingALayerWithBaseColouredOr() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("base or");
		Tinctures tinctures = new Tinctures(); 
		GeometricCharge ordinary = parser.single_geometric_charge(tinctures, TinctureType.OTHER);
		assertThat(ordinary.getType(), is(equalTo(GeometricChargeNames.BASE)));
		assertThat(ordinary.getTincture(), is(equalTo(tinctures.getTincture("or"))));
	}
	
	@Test
	public void testThatBendGulesReturnsAnObjectRepresentingALayerWithBendColouredGules() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("bend gules");
		Tinctures tinctures = new Tinctures(); 
		GeometricCharge ordinary = parser.single_geometric_charge(tinctures, TinctureType.OTHER);
		assertThat(ordinary.getType(), is(equalTo(GeometricChargeNames.BEND)));
		assertThat(ordinary.getTincture(), is(equalTo(tinctures.getTincture("gules"))));
	}
	
	@Test
	public void testThatBendGulesOnColourFieldReturnsCorrectObjectButGivesWarningAboutNotFollowingRuleOfTincture() throws RecognitionException, UnknownTinctureException {
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		BlazonParser parser = new ParserCreator().createParser("bend gules", diags );
		Tinctures tinctures = new Tinctures(); 
		GeometricCharge ordinary = parser.single_geometric_charge(tinctures, TinctureType.COLOUR);
		assertThat(ordinary.getType(), is(equalTo(GeometricChargeNames.BEND)));
		assertThat(ordinary.getTincture(), is(equalTo(tinctures.getTincture("gules"))));
		assertThat(diags.size(), is(1));
		assertThat(diags.get(0).getSeverity(), is(LogLevel.WARNING));
		assertThat(diags.get(0).getMessage(), is("You are not obeying the rule of tincture. You can not put a colour on a colour, or a metal on a metal"));
	}
	
	@Test
	public void testThatBendOrOnMetalFieldReturnsCorrectObjectButGivesWarningAboutNotFollowingRuleOfTincture() throws RecognitionException, UnknownTinctureException {
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		BlazonParser parser = new ParserCreator().createParser("bend or", diags );
		Tinctures tinctures = new Tinctures(); 
		GeometricCharge ordinary = parser.single_geometric_charge(tinctures, TinctureType.METAL);
		assertThat(ordinary.getType(), is(equalTo(GeometricChargeNames.BEND)));
		assertThat(ordinary.getTincture(), is(equalTo(tinctures.getTincture("or"))));
		assertThat(diags.size(), is(1));
		assertThat(diags.get(0).getSeverity(), is(LogLevel.WARNING));
		assertThat(diags.get(0).getMessage(), is(equalTo("You are not obeying the rule of tincture. You can not put a colour on a colour, or a metal on a metal")));
	}
	
	@Test
	public void testThatPallVairOnOtherFieldReturnsCorrectObjectAndGivesNoWarningAboutNotFollowingRuleOfTincture() throws RecognitionException, UnknownTinctureException {
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		BlazonParser parser = new ParserCreator().createParser("pall vair", diags );
		Tinctures tinctures = new Tinctures(); 
		GeometricCharge ordinary = parser.single_geometric_charge(tinctures, TinctureType.OTHER);
		assertThat(ordinary.getType(), is(equalTo(GeometricChargeNames.PALL)));
		assertThat(ordinary.getTincture(), is(equalTo(tinctures.getTincture("vair"))));
		assertThat(diags.size(), is(0));
	}
	
	@Test
	public void testThatPileReversedGulesReturnsAnObjectRepresentingPileReversedColouredGules() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("pile reversed gules");
		Tinctures tinctures = new Tinctures(); 
		GeometricCharge ordinary = parser.single_geometric_charge(tinctures, TinctureType.OTHER);
		assertThat(ordinary.getType(), is(equalTo(GeometricChargeNames.PILE_REVERSED)));
		assertThat(ordinary.getTincture(), is(equalTo(tinctures.getTincture("gules"))));
	}
		
	@Test
	public void testThatOrleGulesReturnsTheCorrectObject() throws RecognitionException, UnknownTinctureException {
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		BlazonParser parser = new ParserCreator().createParser("orle gules", diags);
		Tinctures tinctures = new Tinctures(); 
		GeometricCharge ordinary = parser.single_geometric_charge(tinctures, TinctureType.OTHER);
		assertThat(ordinary.getType(), is(equalTo(GeometricChargeNames.ORLE)));
		assertThat(ordinary.getTincture(), is(equalTo(tinctures.getTincture("gules"))));
		assertThat(diags.size(), is(0));
	}
	
	@Test(expected=MismatchedSetException.class)
	public void testThatBlahGulesThrowsAMismatchedSetException() throws RecognitionException {
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		BlazonParser parser = new ParserCreator().createParser("blah gules", diags);
		parser.single_geometric_charge(new Tinctures(), TinctureType.OTHER);
	}
	
	@Test(expected=NoViableAltException.class)
	public void testThatBendBlahGulesThrowsNoViableAltException() throws RecognitionException, UnknownTinctureException {
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		BlazonParser parser = new ParserCreator().createParser("bend blah", diags);
		parser.single_geometric_charge(new Tinctures(), TinctureType.OTHER);
	}
}
