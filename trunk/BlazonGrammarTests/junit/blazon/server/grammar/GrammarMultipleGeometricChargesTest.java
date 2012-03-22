package blazon.server.grammar;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.RecognitionException;
import org.junit.Test;

import blazon.shared.shield.charges.Charge;
import blazon.shared.shield.charges.GeometricCharge;
import blazon.shared.shield.charges.GeometricChargeNames;
import blazon.shared.shield.diagnostic.ShieldDiagnostic;
import blazon.shared.shield.diagnostic.ShieldDiagnostic.LogLevel;
import blazon.shared.shield.tinctures.TinctureType;
import blazon.shared.shield.tinctures.Tinctures;
import blazon.shared.shield.tinctures.UnknownTinctureException;

public class GrammarMultipleGeometricChargesTest {

	@Test
	public void testThatChevronelGulesReturnsTheCorrectObject() throws RecognitionException, UnknownTinctureException {
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		BlazonParser parser = new ParserCreator().createParser("chevronel gules", diags);
		Tinctures tinctures = new Tinctures(); 
		List<Charge> charges = parser.multiple_geometric_charges(tinctures, TinctureType.OTHER, 1);
		assertThat(charges.size(), is(1));
		GeometricCharge ordinary = (GeometricCharge) charges.get(0);
		assertThat(ordinary.getType(), is(equalTo(GeometricChargeNames.CHEVRONEL)));
		assertThat(ordinary.getTincture(), is(equalTo(tinctures.getTincture("gules"))));
		assertThat(diags.size(), is(0));
	}
	
	@Test
	public void testThatChevronelsGulesReturnsTheCorrectObjectButGivesWarningAboutUsingPlural() throws RecognitionException, UnknownTinctureException {
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		BlazonParser parser = new ParserCreator().createParser("chevronels gules", diags);
		Tinctures tinctures = new Tinctures(); 
		List<Charge> charges = parser.multiple_geometric_charges(tinctures, TinctureType.OTHER, 1);
		assertThat(charges.size(), is(1));
		GeometricCharge ordinary = (GeometricCharge) charges.get(0);
		assertThat(ordinary.getType(), is(equalTo(GeometricChargeNames.CHEVRONEL)));
		assertThat(ordinary.getTincture(), is(equalTo(tinctures.getTincture("gules"))));
		assertThat(diags.size(), is(1));
		assertThat(diags.get(0).getSeverity(), is(LogLevel.WARNING));
		assertThat(diags.get(0).getMessage(), is(equalTo("You have specified that there is only one of a charge, but used the plural. Changing 'chevronels' to 'chevronel'.")));
	}
	
	@Test
	public void testThatBendletGulesReturnsTheCorrectObjectButGivesWarningAboutUsingPlural() throws RecognitionException, UnknownTinctureException {
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		BlazonParser parser = new ParserCreator().createParser("bendlet gules", diags);
		Tinctures tinctures = new Tinctures(); 
		List<Charge> charges = parser.multiple_geometric_charges(tinctures, TinctureType.OTHER, 2);
		assertThat(charges.size(), is(2));
		GeometricCharge ordinary = (GeometricCharge) charges.get(0);
		assertThat(ordinary.getType(), is(equalTo(GeometricChargeNames.BENDLET)));
		assertThat(ordinary.getTincture(), is(equalTo(tinctures.getTincture("gules"))));
		ordinary = (GeometricCharge) charges.get(1);
		assertThat(ordinary.getType(), is(equalTo(GeometricChargeNames.BENDLET)));
		assertThat(ordinary.getTincture(), is(equalTo(tinctures.getTincture("gules"))));
		assertThat(diags.size(), is(1));
		assertThat(diags.get(0).getSeverity(), is(LogLevel.WARNING));
		assertThat(diags.get(0).getMessage(), is(equalTo("You have specified that there is more than one of a charge, but not used the plural. Changing 'bendlet' to 'bendlets'.")));
	}
	
	@Test
	public void testThatBendletsGulesReturnsTheCorrectObject() throws RecognitionException, UnknownTinctureException {
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		BlazonParser parser = new ParserCreator().createParser("bendlets gules", diags);
		Tinctures tinctures = new Tinctures(); 
		List<Charge> charges = parser.multiple_geometric_charges(tinctures, TinctureType.OTHER, 2);
		assertThat(charges.size(), is(2));
		GeometricCharge ordinary = (GeometricCharge) charges.get(0);
		assertThat(ordinary.getType(), is(equalTo(GeometricChargeNames.BENDLET)));
		assertThat(ordinary.getTincture(), is(equalTo(tinctures.getTincture("gules"))));
		ordinary = (GeometricCharge) (GeometricCharge) charges.get(1);
		assertThat(ordinary.getType(), is(equalTo(GeometricChargeNames.BENDLET)));
		assertThat(ordinary.getTincture(), is(equalTo(tinctures.getTincture("gules"))));
		assertThat(diags.size(), is(0));
	}
	
	@Test
	public void testThatBendletSinisterGulesReturnsTheCorrectObject() throws RecognitionException, UnknownTinctureException {
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		BlazonParser parser = new ParserCreator().createParser("bendlet sinister gules", diags);
		Tinctures tinctures = new Tinctures(); 
		List<Charge> charges = parser.multiple_geometric_charges(tinctures, TinctureType.OTHER, 1);
		assertThat(charges.size(), is(1));
		GeometricCharge ordinary = (GeometricCharge) (GeometricCharge) charges.get(0);
		assertThat(ordinary.getType(), is(equalTo(GeometricChargeNames.BENDLET_SINISTER)));
		assertThat(ordinary.getTincture(), is(equalTo(tinctures.getTincture("gules"))));
		assertThat(diags.size(), is(0));
	}
	
	@Test
	public void testThatBendletsSinisterGulesReturnsTheCorrectObject() throws RecognitionException, UnknownTinctureException {
		List<ShieldDiagnostic> diags = new ArrayList<ShieldDiagnostic>();
		BlazonParser parser = new ParserCreator().createParser("bendlets sinister gules", diags);
		Tinctures tinctures = new Tinctures(); 
		List<Charge> charges = parser.multiple_geometric_charges(tinctures, TinctureType.OTHER, 2);
		assertThat(charges.size(), is(2));
		GeometricCharge ordinary = (GeometricCharge) (GeometricCharge) charges.get(0);
		assertThat(ordinary.getType(), is(equalTo(GeometricChargeNames.BENDLET_SINISTER)));
		assertThat(ordinary.getTincture(), is(equalTo(tinctures.getTincture("gules"))));
		ordinary = (GeometricCharge) (GeometricCharge) charges.get(1);
		assertThat(ordinary.getType(), is(equalTo(GeometricChargeNames.BENDLET_SINISTER)));
		assertThat(ordinary.getTincture(), is(equalTo(tinctures.getTincture("gules"))));
		assertThat(diags.size(), is(0));
	}
	
	@Test(expected=MismatchedSetException.class)
	public void testThatBlahIsRejected() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("blah", new ArrayList<ShieldDiagnostic>());
		parser.multiple_geometric_charges(new Tinctures(), TinctureType.OTHER, 2);
	}
	
	@Test(expected=MismatchedSetException.class)
	public void testThatABendIsRejected() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("a bend", new ArrayList<ShieldDiagnostic>());
		parser.multiple_geometric_charges(new Tinctures(), TinctureType.OTHER, 2);
	}
}
