package blazon.server.grammar;

import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.RecognitionException;
import org.junit.Test;

import blazon.shared.shield.charges.GeometricCharge;
import blazon.shared.shield.charges.GeometricChargeNames;
import blazon.shared.shield.diagnostic.ShieldDiagnostic;
import blazon.shared.shield.tinctures.TinctureType;
import blazon.shared.shield.tinctures.Tinctures;
import blazon.shared.shield.tinctures.UnknownTinctureException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class GrammarOrdinaryTest {

	@Test
	public void testThatChiefGulesReturnsAnObjectRepresentingAChiefColouredGules() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("chief gules");
		Tinctures tinctures = new Tinctures(); 
		GeometricCharge ordinary = parser.single_geometric_charge(tinctures, TinctureType.OTHER);
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.CHIEF)));
		assertThat(ordinary.getTincture(), is(equalTo(tinctures.getTincture("gules"))));
	}
	
	@Test
	public void testThatBaseOrReturnsAnObjectRepresentingABaseColouredOr() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("base or");
		Tinctures tinctures = new Tinctures(); 
		GeometricCharge ordinary = parser.single_geometric_charge(tinctures, TinctureType.OTHER);
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.BASE)));
		assertThat(ordinary.getTincture(), is(equalTo(tinctures.getTincture("or"))));
	}
	
	@Test
	public void testThatBendGulesReturnsAnObjectRepresentingABendColouredGules() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("bend gules");
		Tinctures tinctures = new Tinctures(); 
		GeometricCharge ordinary = parser.single_geometric_charge(tinctures, TinctureType.OTHER);
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.BEND)));
		assertThat(ordinary.getTincture(), is(equalTo(tinctures.getTincture("gules"))));
	}
	
	@Test
	public void testThatBendGulesOnColourFieldReturnsCorrectObjectButGivesWarningAboutNotFollowingRuleOfTincture() throws RecognitionException, UnknownTinctureException {
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		BlazonParser parser = new ParserCreator().createParser("bend gules", diags );
		Tinctures tinctures = new Tinctures(); 
		GeometricCharge ordinary = parser.single_geometric_charge(tinctures, TinctureType.COLOUR);
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.BEND)));
		assertThat(ordinary.getTincture(), is(equalTo(tinctures.getTincture("gules"))));
		assertThat(diags.size(), is(1));
		assertThat(diags.get(0).getSeverity(), is(ShieldDiagnostic.LogLevel.WARN));
		assertThat(diags.get(0).getMessage(), is("You are not obeying the rule of tincture. You can not put a colour on a colour, or a metal on a metal"));
	}
	
	@Test
	public void testThatBendOrOnMetalFieldReturnsCorrectObjectButGivesWarningAboutNotFollowingRuleOfTincture() throws RecognitionException, UnknownTinctureException {
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		BlazonParser parser = new ParserCreator().createParser("bend or", diags );
		Tinctures tinctures = new Tinctures(); 
		GeometricCharge ordinary = parser.single_geometric_charge(tinctures, TinctureType.METAL);
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.BEND)));
		assertThat(ordinary.getTincture(), is(equalTo(tinctures.getTincture("or"))));
		assertThat(diags.size(), is(1));
		assertThat(diags.get(0).getSeverity(), is(ShieldDiagnostic.LogLevel.WARN));
		assertThat(diags.get(0).getMessage(), is("You are not obeying the rule of tincture. You can not put a colour on a colour, or a metal on a metal"));
	}
	
	@Test
	public void testThatBendVairOnOtherFieldReturnsCorrectObjectAndGivesNoWarningAboutNotFollowingRuleOfTincture() throws RecognitionException, UnknownTinctureException {
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		BlazonParser parser = new ParserCreator().createParser("bend vair", diags );
		Tinctures tinctures = new Tinctures(); 
		GeometricCharge ordinary = parser.single_geometric_charge(tinctures, TinctureType.OTHER);
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.BEND)));
		assertThat(ordinary.getTincture(), is(equalTo(tinctures.getTincture("vair"))));
		assertThat(diags.size(), is(0));
	}
	
	@Test
	public void testThatBendSinisterGulesReturnsAnObjectRepresentingABendSinisterColouredGules() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("bend sinister gules");
		Tinctures tinctures = new Tinctures(); 
		GeometricCharge ordinary = parser.single_geometric_charge(tinctures, TinctureType.OTHER);
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.BEND_SINISTER)));
		assertThat(ordinary.getTincture(), is(equalTo(tinctures.getTincture("gules"))));
	}
	
	@Test(expected=MismatchedSetException.class)
	public void testThatBlahGulesThrowsAMismatchedSetException() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("blah gules");
		Tinctures tinctures = new Tinctures(); 
		parser.single_geometric_charge(tinctures, TinctureType.OTHER);
	}
	
	@Test
	public void testThatBendBlahGulesReturnsAnObjectRepresentingBend() throws RecognitionException, UnknownTinctureException {
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		BlazonParser parser = new ParserCreator().createParser("bend blah gules", diags);
		Tinctures tinctures = new Tinctures(); 
		GeometricCharge ordinary = parser.single_geometric_charge(tinctures, TinctureType.OTHER);
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.BEND)));
		assertThat(ordinary.getTincture(), is(tinctures.getTincture("gules")));
	}
}
