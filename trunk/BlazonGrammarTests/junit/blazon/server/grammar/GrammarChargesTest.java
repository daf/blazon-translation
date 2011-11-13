package blazon.server.grammar;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.junit.Test;

import blazon.shared.shield.charges.GeometricCharge;
import blazon.shared.shield.charges.GeometricChargeNames;
import blazon.shared.shield.diagnostic.ShieldDiagnostic;
import blazon.shared.shield.diagnostic.ShieldDiagnostic.LogLevel;
import blazon.shared.shield.tinctures.TinctureType;
import blazon.shared.shield.tinctures.Tinctures;
import blazon.shared.shield.tinctures.UnknownTinctureException;

public class GrammarChargesTest {

	@Test
	public void testThatAChiefGulesReturnsAnObjectRepresentingALayerWithAChiefColouredGules() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("a chief gules");
		Tinctures tinctures = new Tinctures(); 
		List<GeometricCharge> charges = parser.charges(TinctureType.OTHER);
		GeometricCharge ordinary = charges.get(0);
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.CHIEF)));
		assertThat(ordinary.getTincture(), is(equalTo(tinctures.getTincture("gules"))));
	}
	
	@Test
	public void testThatABaseOrReturnsAnObjectRepresentingALayerWithABaseColouredOr() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("a base or");
		Tinctures tinctures = new Tinctures(); 
		List<GeometricCharge> charges = parser.charges(TinctureType.OTHER);
		GeometricCharge ordinary = charges.get(0);
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.BASE)));
		assertThat(ordinary.getTincture(), is(equalTo(tinctures.getTincture("or"))));
	}
	
	@Test
	public void testThatABendGulesReturnsAnObjectRepresentingALayerWithABendColouredGules() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("a bend gules");
		Tinctures tinctures = new Tinctures(); 
		List<GeometricCharge> charges = parser.charges(TinctureType.OTHER);
		GeometricCharge ordinary = charges.get(0);
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.BEND)));
		assertThat(ordinary.getTincture(), is(equalTo(tinctures.getTincture("gules"))));
	}
	
	@Test
	public void testThatABendGulesOnColourFieldReturnsCorrectObjectButGivesWarningAboutNotFollowingRuleOfTincture() throws RecognitionException, UnknownTinctureException {
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		BlazonParser parser = new ParserCreator().createParser("a bend gules", diags );
		Tinctures tinctures = new Tinctures(); 
		List<GeometricCharge> charges = parser.charges(TinctureType.COLOUR);
		GeometricCharge ordinary = charges.get(0);
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.BEND)));
		assertThat(ordinary.getTincture(), is(equalTo(tinctures.getTincture("gules"))));
		assertThat(diags.size(), is(1));
		assertThat(diags.get(0).getSeverity(), is(LogLevel.WARN));
		assertThat(diags.get(0).getMessage(), is("You are not obeying the rule of tincture. You can not put a colour on a colour, or a metal on a metal"));
	}
	
	@Test
	public void testThatABendOrOnMetalFieldReturnsCorrectObjectButGivesWarningAboutNotFollowingRuleOfTincture() throws RecognitionException, UnknownTinctureException {
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		BlazonParser parser = new ParserCreator().createParser("a bend or", diags );
		Tinctures tinctures = new Tinctures(); 
		List<GeometricCharge> charges = parser.charges(TinctureType.METAL);
		GeometricCharge ordinary = charges.get(0);
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.BEND)));
		assertThat(ordinary.getTincture(), is(equalTo(tinctures.getTincture("or"))));
		assertThat(diags.size(), is(1));
		assertThat(diags.get(0).getSeverity(), is(LogLevel.WARN));
		assertThat(diags.get(0).getMessage(), is(equalTo("You are not obeying the rule of tincture. You can not put a colour on a colour, or a metal on a metal")));
	}
	
	@Test
	public void testThatAPallVairOnOtherFieldReturnsCorrectObjectAndGivesNoWarningAboutNotFollowingRuleOfTincture() throws RecognitionException, UnknownTinctureException {
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		BlazonParser parser = new ParserCreator().createParser("a pall vair", diags );
		Tinctures tinctures = new Tinctures(); 
		List<GeometricCharge> charges = parser.charges(TinctureType.OTHER);
		GeometricCharge ordinary = charges.get(0);
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.PALL)));
		assertThat(ordinary.getTincture(), is(equalTo(tinctures.getTincture("vair"))));
		assertThat(diags.size(), is(0));
	}
	
	@Test
	public void testThatAPileReversedGulesReturnsAnObjectRepresentingAPileReversedColouredGules() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("a pile reversed gules");
		Tinctures tinctures = new Tinctures(); 
		List<GeometricCharge> charges = parser.charges(TinctureType.OTHER);
		GeometricCharge ordinary = charges.get(0);
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.PILE_REVERSED)));
		assertThat(ordinary.getTincture(), is(equalTo(tinctures.getTincture("gules"))));
	}
	
	@Test
	public void testThatAOrleGulesReturnsTheCorrectObjectButGivesAWarningAboutUsingWrongDeterminer() throws RecognitionException, UnknownTinctureException {
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		BlazonParser parser = new ParserCreator().createParser("a orle gules", diags);
		Tinctures tinctures = new Tinctures(); 
		List<GeometricCharge> charges = parser.charges(TinctureType.OTHER);
		GeometricCharge ordinary = charges.get(0);
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.ORLE)));
		assertThat(ordinary.getTincture(), is(equalTo(tinctures.getTincture("gules"))));
		assertThat(diags.size(), is(1));
		assertThat(diags.get(0).getSeverity(), is(LogLevel.WARN));
		assertThat(diags.get(0).getMessage(), is(equalTo("You have asked for the charge 'a orle'. A charge starting with a vowel should be preceded by 'an' i.e. 'an orle'.")));
	}
	
	@Test
	public void testThatAnBendGulesReturnsTheCorrectObjectButGivesAWarningAboutUsingWrongDeterminer() throws RecognitionException, UnknownTinctureException {
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		BlazonParser parser = new ParserCreator().createParser("an bend gules", diags);
		Tinctures tinctures = new Tinctures(); 
		List<GeometricCharge> charges = parser.charges(TinctureType.OTHER);
		GeometricCharge ordinary = charges.get(0);
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.BEND)));
		assertThat(ordinary.getTincture(), is(equalTo(tinctures.getTincture("gules"))));
		assertThat(diags.size(), is(1));
		assertThat(diags.get(0).getSeverity(), is(LogLevel.WARN));
		assertThat(diags.get(0).getMessage(), is(equalTo("You have asked for the charge 'an bend'. A charge starting with a consonants should be preceded by 'a' i.e. 'a bend'.")));
	}
	
	@Test
	public void testThatAOrleGulesReturnsTheCorrectObject() throws RecognitionException, UnknownTinctureException {
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		BlazonParser parser = new ParserCreator().createParser("an orle gules", diags);
		Tinctures tinctures = new Tinctures(); 
		List<GeometricCharge> charges = parser.charges(TinctureType.OTHER);
		GeometricCharge ordinary = charges.get(0);
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.ORLE)));
		assertThat(ordinary.getTincture(), is(equalTo(tinctures.getTincture("gules"))));
		assertThat(diags.size(), is(0));
	}

	@Test
	public void testThatAChevronelGulesReturnsTheCorrectObject() throws RecognitionException, UnknownTinctureException {
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		BlazonParser parser = new ParserCreator().createParser("a chevronel gules", diags);
		Tinctures tinctures = new Tinctures(); 
		List<GeometricCharge> charges = parser.charges(TinctureType.OTHER);
		assertThat(charges.size(), is(1));
		GeometricCharge ordinary = charges.get(0);
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.CHEVRONEL)));
		assertThat(ordinary.getTincture(), is(equalTo(tinctures.getTincture("gules"))));
		assertThat(diags.size(), is(0));
	}
	
	@Test
	public void testThatAChevronelsGulesReturnsTheCorrectObjectButGivesWarningAboutUsingPlural() throws RecognitionException, UnknownTinctureException {
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		BlazonParser parser = new ParserCreator().createParser("a chevronels gules", diags);
		Tinctures tinctures = new Tinctures(); 
		List<GeometricCharge> charges = parser.charges(TinctureType.OTHER);
		assertThat(charges.size(), is(1));
		GeometricCharge ordinary = charges.get(0);
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.CHEVRONEL)));
		assertThat(ordinary.getTincture(), is(equalTo(tinctures.getTincture("gules"))));
		assertThat(diags.size(), is(1));
		assertThat(diags.get(0).getSeverity(), is(LogLevel.WARN));
		assertThat(diags.get(0).getMessage(), is(equalTo("You have specified that there is only one of a charge, but used the plural. Changing 'chevronels' to 'chevronel'.")));
	}
	
	@Test
	public void testThat2BendletGulesReturnsTheCorrectObjectButGivesWarningAboutUsingPlural() throws RecognitionException, UnknownTinctureException {
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		BlazonParser parser = new ParserCreator().createParser("2 bendlet gules", diags);
		Tinctures tinctures = new Tinctures(); 
		List<GeometricCharge> charges = parser.charges(TinctureType.OTHER);
		assertThat(charges.size(), is(2));
		GeometricCharge ordinary = charges.get(0);
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.BENDLET)));
		assertThat(ordinary.getTincture(), is(equalTo(tinctures.getTincture("gules"))));
		ordinary = charges.get(1);
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.BENDLET)));
		assertThat(ordinary.getTincture(), is(equalTo(tinctures.getTincture("gules"))));
		assertThat(diags.size(), is(1));
		assertThat(diags.get(0).getSeverity(), is(LogLevel.WARN));
		assertThat(diags.get(0).getMessage(), is(equalTo("You have specified that there is more than one of a charge, but not used the plural. Changing 'bendlet' to 'bendlets'.")));
	}
	
	@Test
	public void testThat2BendletsGulesReturnsTheCorrectObject() throws RecognitionException, UnknownTinctureException {
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		BlazonParser parser = new ParserCreator().createParser("2 bendlets gules", diags);
		Tinctures tinctures = new Tinctures(); 
		List<GeometricCharge> charges = parser.charges(TinctureType.OTHER);
		assertThat(charges.size(), is(2));
		GeometricCharge ordinary = charges.get(0);
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.BENDLET)));
		assertThat(ordinary.getTincture(), is(equalTo(tinctures.getTincture("gules"))));
		ordinary = charges.get(1);
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.BENDLET)));
		assertThat(ordinary.getTincture(), is(equalTo(tinctures.getTincture("gules"))));
		assertThat(diags.size(), is(0));
	}
	
	@Test
	public void testThatTwoBendletsGulesReturnsTheCorrectObject() throws RecognitionException, UnknownTinctureException {
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		BlazonParser parser = new ParserCreator().createParser("Two bendlets gules", diags);
		Tinctures tinctures = new Tinctures(); 
		List<GeometricCharge> charges = parser.charges(TinctureType.OTHER);
		assertThat(charges.size(), is(2));
		GeometricCharge ordinary = charges.get(0);
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.BENDLET)));
		assertThat(ordinary.getTincture(), is(equalTo(tinctures.getTincture("gules"))));
		ordinary = charges.get(1);
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.BENDLET)));
		assertThat(ordinary.getTincture(), is(equalTo(tinctures.getTincture("gules"))));
		assertThat(diags.size(), is(0));
	}
	
	@Test
	public void testThat1BendletSinisterGulesReturnsTheCorrectObject() throws RecognitionException, UnknownTinctureException {
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		BlazonParser parser = new ParserCreator().createParser("1 bendlet sinister gules", diags);
		Tinctures tinctures = new Tinctures(); 
		List<GeometricCharge> charges = parser.charges(TinctureType.OTHER);
		assertThat(charges.size(), is(1));
		GeometricCharge ordinary = charges.get(0);
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.BENDLET_SINISTER)));
		assertThat(ordinary.getTincture(), is(equalTo(tinctures.getTincture("gules"))));
		assertThat(diags.size(), is(0));
	}
	
	@Test
	public void testThatTwoBendletsSinisterGulesReturnsTheCorrectObject() throws RecognitionException, UnknownTinctureException {
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		BlazonParser parser = new ParserCreator().createParser("Two bendlets sinister gules", diags);
		Tinctures tinctures = new Tinctures(); 
		List<GeometricCharge> charges = parser.charges(TinctureType.OTHER);
		assertThat(charges.size(), is(2));
		GeometricCharge ordinary = charges.get(0);
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.BENDLET_SINISTER)));
		assertThat(ordinary.getTincture(), is(equalTo(tinctures.getTincture("gules"))));
		ordinary = charges.get(1);
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.BENDLET_SINISTER)));
		assertThat(ordinary.getTincture(), is(equalTo(tinctures.getTincture("gules"))));
		assertThat(diags.size(), is(0));
	}
	
	@Test(expected=NoViableAltException.class)
	public void testThatBlahBendletsGulesThrowsANoViableAltException() throws RecognitionException {
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		BlazonParser parser = new ParserCreator().createParser("blah bendlets gules", diags);
		parser.charges(TinctureType.OTHER);
	}
	
	@Test(expected=NoViableAltException.class)
	public void testThatABlahGulesThrowsAMismatchedSetException() throws RecognitionException {
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		BlazonParser parser = new ParserCreator().createParser("a blah gules", diags);
		parser.charges(TinctureType.OTHER);
	}
	
	@Test(expected=NoViableAltException.class)
	public void testThatBendGulesGivesErrorStatingThatAIsMissing() throws RecognitionException {
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		BlazonParser parser = new ParserCreator().createParser("bend gules", diags);
		parser.charges(TinctureType.OTHER);
	}
	
	@Test
	public void testThatABendBlahGulesReturnsAnObjectRepresentingBend() throws RecognitionException, UnknownTinctureException {
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		BlazonParser parser = new ParserCreator().createParser("a bend blah gules", diags);
		Tinctures tinctures = new Tinctures(); 
		List<GeometricCharge> charges = parser.charges(TinctureType.OTHER);
		GeometricCharge ordinary = charges.get(0);
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.BEND)));
		assertThat(ordinary.getTincture(), is(tinctures.getTincture("gules")));
	}
}
