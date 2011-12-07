package blazon.server.grammar;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.antlr.runtime.RecognitionException;
import org.junit.Test;

import blazon.server.grammar.BlazonParser;
import blazon.shared.shield.Shield;
import blazon.shared.shield.ShieldImpl;
import blazon.shared.shield.ShieldDivision;
import blazon.shared.shield.ShieldDivision.ShieldDivisionType;
import blazon.shared.shield.ShieldLayer;
import blazon.shared.shield.charges.Charge;
import blazon.shared.shield.charges.GeometricCharge;
import blazon.shared.shield.charges.GeometricChargeNames;
import blazon.shared.shield.diagnostic.ShieldDiagnostic;
import blazon.shared.shield.tinctures.Tincture;
import blazon.shared.shield.tinctures.Tinctures;
import blazon.shared.shield.tinctures.UnknownTinctureException;


public class GrammarShieldTest {

	@Test
	public void testThatGulesReturnsTheCorrectLayer() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("gules");
		ShieldImpl shield = (ShieldImpl) parser.shield();
		
		Tinctures tinctures = new Tinctures();
		Tincture gules = tinctures.getTincture("gules");
		ShieldDivisionType plain = new ShieldDivision().getDivisionType("none", new ArrayList<ShieldDiagnostic>());
		
		assertThat(shield.getField(), is(notNullValue()));
		
		ShieldLayer layer = shield.getField();
		assertThat(layer.getShieldDivision(), is(equalTo(plain)));
		Tincture tinctureOnLayer = layer.getTinctures().getTincturesOnLayer().iterator().next();
		assertThat(tinctureOnLayer, is(equalTo(gules)));
	}
	
	@Test
	public void testThatGulesPlainReturnsTheCorrectLayer() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("gules plain");
		ShieldImpl shield = (ShieldImpl) parser.shield();
		
		Tinctures tinctures = new Tinctures();
		Tincture gules = tinctures.getTincture("gules");
		ShieldDivisionType plain = new ShieldDivision().getDivisionType("none", new ArrayList<ShieldDiagnostic>());
		
		assertThat(shield.getField(), is(notNullValue()));
		
		ShieldLayer layer = shield.getField();
		assertThat(layer.getShieldDivision(), is(equalTo(plain)));
		Tincture tinctureOnLayer = layer.getTinctures().getTincturesOnLayer().iterator().next();
		assertThat(tinctureOnLayer, is(equalTo(gules)));
	}
	
	
	@Test
	public void testThatGulesIsEqualToGulesPlain() throws RecognitionException {
		BlazonParser gulesPlainParser = new ParserCreator().createParser("gules plain");
		BlazonParser gulesParser = new ParserCreator().createParser("gules");
		
		ShieldImpl gulesShield = (ShieldImpl) gulesParser.shield();
		ShieldImpl gulesPlainShield = (ShieldImpl) gulesPlainParser.shield();
		assertThat(gulesShield, is(equalTo(gulesPlainShield)));
	}
	
	@Test
	public void testThatPerBendGulesAndArgentGivesTheCorrectLayer() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("per bend gules and argent");
		ShieldImpl shield = (ShieldImpl) parser.shield();
		
		Tinctures tinctures = new Tinctures();
		Tincture gules = tinctures.getTincture("gules");
		Tincture argent = tinctures.getTincture("argent");
		ShieldDivisionType bend = new ShieldDivision().getDivisionType("bend", new ArrayList<ShieldDiagnostic>());
		
		assertThat(shield.getField(), is(notNullValue()));
		
		ShieldLayer layer = shield.getField();
		assertThat(layer.getShieldDivision(), is(equalTo(bend)));
		Iterator<Tincture> tincturesOnLayer = layer.getTinctures().getTincturesOnLayer().iterator();
		assertThat(tincturesOnLayer.next(), is(equalTo(gules)));
		assertThat(tincturesOnLayer.next(), is(equalTo(argent)));
	}
	
	@Test
	public void testThatPerBendArgentAndGulesGivesTheCorrectLayer() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("per bend argent and gules");
		ShieldImpl shield = (ShieldImpl) parser.shield();
		
		Tinctures tinctures = new Tinctures();
		Tincture gules = tinctures.getTincture("gules");
		Tincture argent = tinctures.getTincture("argent");
		ShieldDivisionType bend = new ShieldDivision().getDivisionType("bend", new ArrayList<ShieldDiagnostic>());
		
		assertThat(shield.getField(), is(notNullValue()));
		
		ShieldLayer layer = shield.getField();
		assertThat(layer.getShieldDivision(), is(equalTo(bend)));
		Iterator<Tincture> tincturesOnLayer = layer.getTinctures().getTincturesOnLayer().iterator();
		assertThat(tincturesOnLayer.next(), is(equalTo(argent)));
		assertThat(tincturesOnLayer.next(), is(equalTo(gules)));
	}
	
	@Test
	public void testThatPartyPerBendGulesAndArgentGivesTheCorrectLayer() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("party per bend gules and argent");
		ShieldImpl shield = (ShieldImpl) parser.shield();
		
		Tinctures tinctures = new Tinctures();
		Tincture gules = tinctures.getTincture("gules");
		Tincture argent = tinctures.getTincture("argent");
		ShieldDivisionType bend = new ShieldDivision().getDivisionType("bend", new ArrayList<ShieldDiagnostic>());
		
		assertThat(shield.getField(), is(notNullValue()));
		
		ShieldLayer layer = shield.getField();
		assertThat(layer.getShieldDivision(), is(equalTo(bend)));
		Iterator<Tincture> tincturesOnLayer = layer.getTinctures().getTincturesOnLayer().iterator();
		assertThat(tincturesOnLayer.next(), is(equalTo(gules)));
		assertThat(tincturesOnLayer.next(), is(equalTo(argent)));
	}
	
	@Test
	public void testThatPartedPerBendGulesAndArgentGivesTheCorrectLayer() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("parted per bend gules and argent");
		ShieldImpl shield = (ShieldImpl) parser.shield();
		
		Tinctures tinctures = new Tinctures();
		Tincture gules = tinctures.getTincture("gules");
		Tincture argent = tinctures.getTincture("argent");
		ShieldDivisionType bend = new ShieldDivision().getDivisionType("bend", new ArrayList<ShieldDiagnostic>());
		
		assertThat(shield.getField(), is(notNullValue()));
		
		ShieldLayer layer = shield.getField();
		assertThat(layer.getShieldDivision(), is(equalTo(bend)));
		Iterator<Tincture> tincturesOnLayer = layer.getTinctures().getTincturesOnLayer().iterator();
		assertThat(tincturesOnLayer.next(), is(equalTo(gules)));
		assertThat(tincturesOnLayer.next(), is(equalTo(argent)));
	}
	
	@Test
	public void testThatPartedPerBendPartyPerBendAndPerBendAreEqual() throws RecognitionException, UnknownTinctureException {
		BlazonParser partedParser = new ParserCreator().createParser("parted per bend gules and argent");
		BlazonParser partyParser = new ParserCreator().createParser("party per bend gules and argent");
		BlazonParser perParser = new ParserCreator().createParser("per bend gules and argent");
		
		ShieldImpl partedShield = (ShieldImpl) partedParser.shield();
		ShieldImpl partyShield = (ShieldImpl) partyParser.shield();
		ShieldImpl perShield = (ShieldImpl) perParser.shield();
		
		assertThat(partedShield, is(equalTo(partyShield)));
		assertThat(partyShield, is(equalTo(perShield)));
		assertThat(partedShield, is(equalTo(perShield)));
	}
	
	@Test
	public void testThatPerBendSinisterGulesAndArgentGivesTheCorrectLayer() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("per bend sinister gules and argent");
		ShieldImpl shield = (ShieldImpl) parser.shield();
		
		Tinctures tinctures = new Tinctures();
		Tincture gules = tinctures.getTincture("gules");
		Tincture argent = tinctures.getTincture("argent");
		ShieldDivisionType bendSinister = new ShieldDivision().getDivisionType("bend sinister", new ArrayList<ShieldDiagnostic>());

		assertThat(shield.getField(), is(notNullValue()));
		
		ShieldLayer layer = shield.getField();
		assertThat(layer.getShieldDivision(), is(equalTo(bendSinister)));
		Iterator<Tincture> tincturesOnLayer = layer.getTinctures().getTincturesOnLayer().iterator();
		assertThat(tincturesOnLayer.next(), is(equalTo(gules)));
		assertThat(tincturesOnLayer.next(), is(equalTo(argent)));
	}
	
	@Test
	public void testThatGyronnyGulesAndArgentGivesTheCorrectLayer() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("gyronny gules and argent");
		ShieldImpl shield = (ShieldImpl) parser.shield();
		
		Tinctures tinctures = new Tinctures();
		Tincture gules = tinctures.getTincture("gules");
		Tincture argent = tinctures.getTincture("argent");
		ShieldDivisionType gyronny = new ShieldDivision().getDivisionType("gyronny", new ArrayList<ShieldDiagnostic>());
		
		assertThat(shield.getField(), is(notNullValue()));
		
		ShieldLayer layer = shield.getField();
		assertThat(layer.getShieldDivision(), is(equalTo(gyronny)));
		Iterator<Tincture> tincturesOnLayer = layer.getTinctures().getTincturesOnLayer().iterator();
		assertThat(tincturesOnLayer.next(), is(equalTo(gules)));
		assertThat(tincturesOnLayer.next(), is(equalTo(argent)));
	}
	
	@Test
	public void testThatGyronnyOfSixteenGulesAndArgentGivesTheCorrectShield() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("gyronny of sixteen gules and argent");
		ShieldImpl shield = (ShieldImpl) parser.shield();
		
		Tinctures tinctures = new Tinctures();
		Tincture gules = tinctures.getTincture("gules");
		Tincture argent = tinctures.getTincture("argent");
		ShieldDivisionType gyronny = new ShieldDivision().getDivisionType("gyronny of 16", new ArrayList<ShieldDiagnostic>());
		
		assertThat(shield.getField(), is(notNullValue()));
		
		ShieldLayer layer = shield.getField();
		assertThat(layer.getShieldDivision(), is(equalTo(gyronny)));
		Iterator<Tincture> tincturesOnLayer = layer.getTinctures().getTincturesOnLayer().iterator();
		assertThat(tincturesOnLayer.next(), is(equalTo(gules)));
		assertThat(tincturesOnLayer.next(), is(equalTo(argent)));
	}
	
	//CHARGED TESTS START HERE
	
	@Test
	public void testThatOrACrossGulesGivesTheCorrectShield() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("or a cross gules");
		ShieldImpl shield = (ShieldImpl) parser.shield();
		
		Tinctures tinctures = new Tinctures();
		Tincture gules = tinctures.getTincture("gules");
		Tincture or = tinctures.getTincture("or");
		ShieldDivisionType none = new ShieldDivision().getDivisionType("none", new ArrayList<ShieldDiagnostic>());
		
		assertThat(shield.getField(), is(notNullValue()));
		ShieldLayer layer = shield.getField();
		assertThat(layer.getShieldDivision(), is(equalTo(none)));
		assertThat(layer.getTinctures().getTincturesOnLayer().size(), is(1));
		assertThat(layer.getTinctures().getTincturesOnLayer().iterator().next(), is(equalTo(or)));
		assertThat(shield.getCharges(), is(notNullValue()));
		List<Charge> charges = shield.getCharges();
		assertThat((GeometricCharge) (GeometricCharge) charges.get(0), is(notNullValue()));
		GeometricCharge ordinary = (GeometricCharge) (GeometricCharge) charges.get(0);
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.CROSS)));
		assertThat(ordinary.getTincture(), is(equalTo(gules)));
		assertThat(shield.getShieldDiagnostics().size(), is(0));
	}
	
	@Test
	public void testThatVairACrossGulesGivesTheCorrectShield() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("vair a cross gules");
		ShieldImpl shield = (ShieldImpl) parser.shield();
		
		Tinctures tinctures = new Tinctures();
		Tincture vair = tinctures.getTincture("vair");
		Tincture gules = tinctures.getTincture("gules");
		ShieldDivisionType none = new ShieldDivision().getDivisionType("none", new ArrayList<ShieldDiagnostic>());
		
		assertThat(shield.getField(), is(notNullValue()));
		ShieldLayer layer = shield.getField();
		assertThat(layer.getShieldDivision(), is(equalTo(none)));
		assertThat(layer.getTinctures().getTincturesOnLayer().size(), is(1));
		assertThat(layer.getTinctures().getTincturesOnLayer().iterator().next(), is(equalTo(vair)));
		assertThat(shield.getCharges(), is(notNullValue()));
		List<Charge> charges = shield.getCharges();
		assertThat((GeometricCharge) (GeometricCharge) charges.get(0), is(notNullValue()));
		GeometricCharge ordinary = (GeometricCharge) (GeometricCharge) charges.get(0);
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.CROSS)));
		assertThat(ordinary.getTincture(), is(equalTo(gules)));
		assertThat(shield.getShieldDiagnostics().size(), is(0));
	}
	
	@Test
	public void testThatSableACrossGulesGivesTheCorrectShieldButHasWarningAboutRuleOfTincture() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("sable a cross gules");
		ShieldImpl shield = (ShieldImpl) parser.shield();
		
		Tinctures tinctures = new Tinctures();
		Tincture sable = tinctures.getTincture("sable");
		Tincture gules = tinctures.getTincture("gules");
		ShieldDivisionType none = new ShieldDivision().getDivisionType("none", new ArrayList<ShieldDiagnostic>());
		
		assertThat(shield.getField(), is(notNullValue()));
		ShieldLayer layer = shield.getField();
		assertThat(layer.getShieldDivision(), is(equalTo(none)));
		assertThat(layer.getTinctures().getTincturesOnLayer().size(), is(1));
		assertThat(layer.getTinctures().getTincturesOnLayer().iterator().next(), is(equalTo(sable)));
		assertThat(shield.getCharges(), is(notNullValue()));
		List<Charge> charges = shield.getCharges();
		assertThat((GeometricCharge) (GeometricCharge) charges.get(0), is(notNullValue()));
		GeometricCharge ordinary = (GeometricCharge) (GeometricCharge) charges.get(0);
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.CROSS)));
		assertThat(ordinary.getTincture(), is(equalTo(gules)));
		assertThat(shield.getShieldDiagnostics().size(), is(1));
		assertThat(shield.getShieldDiagnostics().get(0).getSeverity(), is(ShieldDiagnostic.LogLevel.WARN));
		assertThat(shield.getShieldDiagnostics().get(0).getMessage(), is(equalTo("You are not obeying the rule of tincture. You can not put a colour on a colour, or a metal on a metal")));
	}
	
	@Test
	public void testThatGulesACrossOrGivesTheCorrectShield() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("gules a cross or");
		ShieldImpl shield = (ShieldImpl) parser.shield();
		
		Tinctures tinctures = new Tinctures();
		Tincture gules = tinctures.getTincture("gules");
		Tincture or = tinctures.getTincture("or");
		ShieldDivisionType none = new ShieldDivision().getDivisionType("none", new ArrayList<ShieldDiagnostic>());
		
		assertThat(shield.getField(), is(notNullValue()));
		ShieldLayer layer = shield.getField();
		assertThat(layer.getShieldDivision(), is(equalTo(none)));
		assertThat(layer.getTinctures().getTincturesOnLayer().size(), is(1));
		assertThat(layer.getTinctures().getTincturesOnLayer().iterator().next(), is(equalTo(gules)));
		assertThat(shield.getCharges(), is(notNullValue()));
		List<Charge> charges = shield.getCharges();
		assertThat((GeometricCharge) (GeometricCharge) charges.get(0), is(notNullValue()));
		GeometricCharge ordinary = (GeometricCharge) (GeometricCharge) charges.get(0);
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.CROSS)));
		assertThat(ordinary.getTincture(), is(equalTo(or)));
		assertThat(shield.getShieldDiagnostics().size(), is(0));
	}
	
	@Test
	public void testThatVairACrossOrGivesTheCorrectShield() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("vair a cross or");
		ShieldImpl shield = (ShieldImpl) parser.shield();
		
		Tinctures tinctures = new Tinctures();
		Tincture vair = tinctures.getTincture("vair");
		Tincture or = tinctures.getTincture("or");
		ShieldDivisionType none = new ShieldDivision().getDivisionType("none", new ArrayList<ShieldDiagnostic>());
		
		assertThat(shield.getField(), is(notNullValue()));
		ShieldLayer layer = shield.getField();
		assertThat(layer.getShieldDivision(), is(equalTo(none)));
		assertThat(layer.getTinctures().getTincturesOnLayer().size(), is(1));
		assertThat(layer.getTinctures().getTincturesOnLayer().iterator().next(), is(equalTo(vair)));
		assertThat(shield.getCharges(), is(notNullValue()));
		List<Charge> charges = shield.getCharges();
		assertThat((GeometricCharge) (GeometricCharge) charges.get(0), is(notNullValue()));
		GeometricCharge ordinary = (GeometricCharge) (GeometricCharge) charges.get(0);
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.CROSS)));
		assertThat(ordinary.getTincture(), is(equalTo(or)));
		assertThat(shield.getShieldDiagnostics().size(), is(0));
	}
	
	@Test
	public void testThatOrACrossArgentGivesTheCorrectShieldButHasWarningAboutRuleOfTincture() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("or a cross argent");
		ShieldImpl shield = (ShieldImpl) parser.shield();
		
		Tinctures tinctures = new Tinctures();
		Tincture or = tinctures.getTincture("or");
		Tincture argent = tinctures.getTincture("argent");
		ShieldDivisionType none = new ShieldDivision().getDivisionType("none", new ArrayList<ShieldDiagnostic>());
		
		assertThat(shield.getField(), is(notNullValue()));
		ShieldLayer layer = shield.getField();
		assertThat(layer.getShieldDivision(), is(equalTo(none)));
		assertThat(layer.getTinctures().getTincturesOnLayer().size(), is(1));
		assertThat(layer.getTinctures().getTincturesOnLayer().iterator().next(), is(equalTo(or)));
		assertThat(shield.getCharges(), is(notNullValue()));
		List<Charge> charges = shield.getCharges();
		assertThat((GeometricCharge) (GeometricCharge) charges.get(0), is(notNullValue()));
		GeometricCharge ordinary = (GeometricCharge) (GeometricCharge) charges.get(0);
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.CROSS)));
		assertThat(ordinary.getTincture(), is(equalTo(argent)));
		assertThat(shield.getShieldDiagnostics().size(), is(1));
		assertThat(shield.getShieldDiagnostics().get(0).getSeverity(), is(ShieldDiagnostic.LogLevel.WARN));
		assertThat(shield.getShieldDiagnostics().get(0).getMessage(), is(equalTo("You are not obeying the rule of tincture. You can not put a colour on a colour, or a metal on a metal")));
	}
	
	@Test
	public void testThatGulesACrossVairGivesTheCorrectShield() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("gules a cross vair");
		ShieldImpl shield = (ShieldImpl) parser.shield();
		
		Tinctures tinctures = new Tinctures();
		Tincture gules = tinctures.getTincture("gules");
		Tincture vair = tinctures.getTincture("vair");
		ShieldDivisionType none = new ShieldDivision().getDivisionType("none", new ArrayList<ShieldDiagnostic>());
		
		assertThat(shield.getField(), is(notNullValue()));
		ShieldLayer layer = shield.getField();
		assertThat(layer.getShieldDivision(), is(equalTo(none)));
		assertThat(layer.getTinctures().getTincturesOnLayer().size(), is(1));
		assertThat(layer.getTinctures().getTincturesOnLayer().iterator().next(), is(equalTo(gules)));
		assertThat(shield.getCharges(), is(notNullValue()));
		List<Charge> charges = shield.getCharges();
		assertThat((GeometricCharge) (GeometricCharge) charges.get(0), is(notNullValue()));
		GeometricCharge ordinary = (GeometricCharge) (GeometricCharge) charges.get(0);
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.CROSS)));
		assertThat(ordinary.getTincture(), is(equalTo(vair)));
		assertThat(shield.getShieldDiagnostics().size(), is(0));
	}
	
	@Test
	public void testThatPotentACrossVairGivesTheCorrectShield() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("potent a cross vair");
		ShieldImpl shield = (ShieldImpl) parser.shield();
		
		Tinctures tinctures = new Tinctures();
		Tincture vair = tinctures.getTincture("vair");
		Tincture potent = tinctures.getTincture("potent");
		ShieldDivisionType none = new ShieldDivision().getDivisionType("none", new ArrayList<ShieldDiagnostic>());
		
		assertThat(shield.getField(), is(notNullValue()));
		ShieldLayer layer = shield.getField();
		assertThat(layer.getShieldDivision(), is(equalTo(none)));
		assertThat(layer.getTinctures().getTincturesOnLayer().size(), is(1));
		assertThat(layer.getTinctures().getTincturesOnLayer().iterator().next(), is(equalTo(potent)));
		assertThat(shield.getCharges(), is(notNullValue()));
		List<Charge> charges = shield.getCharges();
		assertThat((GeometricCharge) (GeometricCharge) charges.get(0), is(notNullValue()));
		GeometricCharge ordinary = (GeometricCharge) (GeometricCharge) charges.get(0);
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.CROSS)));
		assertThat(ordinary.getTincture(), is(equalTo(vair)));
		assertThat(shield.getShieldDiagnostics().size(), is(0));
	}
	
	@Test
	public void testThatOrACrossVairGivesTheCorrectShield() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("or a cross vair");
		ShieldImpl shield = (ShieldImpl) parser.shield();
		
		Tinctures tinctures = new Tinctures();
		Tincture vair = tinctures.getTincture("vair");
		Tincture or = tinctures.getTincture("or");
		ShieldDivisionType none = new ShieldDivision().getDivisionType("none", new ArrayList<ShieldDiagnostic>());
		
		assertThat(shield.getField(), is(notNullValue()));
		ShieldLayer layer = shield.getField();
		assertThat(layer.getShieldDivision(), is(equalTo(none)));
		assertThat(layer.getTinctures().getTincturesOnLayer().size(), is(1));
		assertThat(layer.getTinctures().getTincturesOnLayer().iterator().next(), is(equalTo(or)));
		assertThat(shield.getCharges(), is(notNullValue()));
		List<Charge> charges = shield.getCharges();
		assertThat((GeometricCharge) (GeometricCharge) charges.get(0), is(notNullValue()));
		GeometricCharge ordinary = (GeometricCharge) (GeometricCharge) charges.get(0);
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.CROSS)));
		assertThat(ordinary.getTincture(), is(equalTo(vair)));
		assertThat(shield.getShieldDiagnostics().size(), is(0));
	}
	
	@Test
	public void testThatPerCrossGulesAndSableACrossVairGivesTheCorrectShield() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("per cross gules and sable a cross vair");
		ShieldImpl shield = (ShieldImpl) parser.shield();
		
		Tinctures tinctures = new Tinctures();
		Tincture vair = tinctures.getTincture("vair");
		Tincture gules = tinctures.getTincture("gules");
		Tincture sable = tinctures.getTincture("sable");

		ShieldDivisionType cross = new ShieldDivision().getDivisionType("CROSS", new ArrayList<ShieldDiagnostic>());
		
		assertThat(shield.getField(), is(notNullValue()));
		ShieldLayer layer = shield.getField();
		assertThat(layer.getShieldDivision(), is(equalTo(cross)));
		assertThat(layer.getTinctures().getTincturesOnLayer().size(), is(2));
		Iterator<Tincture> it = layer.getTinctures().getTincturesOnLayer().iterator();
		assertThat(it.next(), is(equalTo(gules)));
		assertThat(it.next(), is(equalTo(sable)));
		assertThat(shield.getCharges(), is(notNullValue()));
		List<Charge> charges = shield.getCharges();
		assertThat((GeometricCharge) (GeometricCharge) charges.get(0), is(notNullValue()));
		GeometricCharge ordinary = (GeometricCharge) (GeometricCharge) charges.get(0);
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.CROSS)));
		assertThat(ordinary.getTincture(), is(equalTo(vair)));
		assertThat(shield.getShieldDiagnostics().size(), is(0));
	}
	
	@Test
	public void testThatPerCrossGulesAndSableACrossOrGivesTheCorrectShield() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("per cross gules and sable a cross or");
		ShieldImpl shield = (ShieldImpl) parser.shield();
		
		Tinctures tinctures = new Tinctures();
		Tincture or = tinctures.getTincture("or");
		Tincture gules = tinctures.getTincture("gules");
		Tincture sable = tinctures.getTincture("sable");

		ShieldDivisionType cross = new ShieldDivision().getDivisionType("CROSS", new ArrayList<ShieldDiagnostic>());
		
		assertThat(shield.getField(), is(notNullValue()));
		ShieldLayer layer = shield.getField();
		assertThat(layer.getShieldDivision(), is(equalTo(cross)));
		assertThat(layer.getTinctures().getTincturesOnLayer().size(), is(2));
		Iterator<Tincture> it = layer.getTinctures().getTincturesOnLayer().iterator();
		assertThat(it.next(), is(equalTo(gules)));
		assertThat(it.next(), is(equalTo(sable)));
		assertThat(shield.getCharges(), is(notNullValue()));
		List<Charge> charges = shield.getCharges();
		assertThat((GeometricCharge) (GeometricCharge) charges.get(0), is(notNullValue()));
		GeometricCharge ordinary = (GeometricCharge) (GeometricCharge) charges.get(0);
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.CROSS)));
		assertThat(ordinary.getTincture(), is(equalTo(or)));
		assertThat(shield.getShieldDiagnostics().size(), is(0));
	}
	
	@Test
	public void testThatPerCrossGulesAndSableACrossAzureGivesTheCorrectShield() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("per cross gules and sable a cross azure");
		ShieldImpl shield = (ShieldImpl) parser.shield();
		
		Tinctures tinctures = new Tinctures();
		Tincture azure = tinctures.getTincture("azure");
		Tincture gules = tinctures.getTincture("gules");
		Tincture sable = tinctures.getTincture("sable");

		ShieldDivisionType cross = new ShieldDivision().getDivisionType("CROSS", new ArrayList<ShieldDiagnostic>());
		
		assertThat(shield.getField(), is(notNullValue()));
		ShieldLayer layer = shield.getField();
		assertThat(layer.getShieldDivision(), is(equalTo(cross)));
		assertThat(layer.getTinctures().getTincturesOnLayer().size(), is(2));
		Iterator<Tincture> it = layer.getTinctures().getTincturesOnLayer().iterator();
		assertThat(it.next(), is(equalTo(gules)));
		assertThat(it.next(), is(equalTo(sable)));
		assertThat(shield.getCharges(), is(notNullValue()));
		List<Charge> charges = shield.getCharges();
		assertThat((GeometricCharge) (GeometricCharge) charges.get(0), is(notNullValue()));
		GeometricCharge ordinary = (GeometricCharge) (GeometricCharge) charges.get(0);
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.CROSS)));
		assertThat(ordinary.getTincture(), is(equalTo(azure)));
		assertThat(shield.getShieldDiagnostics().size(), is(1));
		assertThat(shield.getShieldDiagnostics().get(0).getSeverity(), is(ShieldDiagnostic.LogLevel.WARN));
		assertThat(shield.getShieldDiagnostics().get(0).getMessage(), is(equalTo("You are not obeying the rule of tincture. You can not put a colour on a colour, or a metal on a metal")));
	}
	
	@Test
	public void testThatPerCrossOrAndArgentACrossVairGivesTheCorrectShield() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("per cross or and argent a cross vair");
		ShieldImpl shield = (ShieldImpl) parser.shield();
		
		Tinctures tinctures = new Tinctures();
		Tincture vair = tinctures.getTincture("vair");
		Tincture or = tinctures.getTincture("or");
		Tincture argent = tinctures.getTincture("argent");

		ShieldDivisionType cross = new ShieldDivision().getDivisionType("CROSS", new ArrayList<ShieldDiagnostic>());
		
		assertThat(shield.getField(), is(notNullValue()));
		ShieldLayer layer = shield.getField();
		assertThat(layer.getShieldDivision(), is(equalTo(cross)));
		assertThat(layer.getTinctures().getTincturesOnLayer().size(), is(2));
		Iterator<Tincture> it = layer.getTinctures().getTincturesOnLayer().iterator();
		assertThat(it.next(), is(equalTo(or)));
		assertThat(it.next(), is(equalTo(argent)));
		assertThat(shield.getCharges(), is(notNullValue()));
		List<Charge> charges = shield.getCharges();
		assertThat((GeometricCharge) (GeometricCharge) charges.get(0), is(notNullValue()));
		GeometricCharge ordinary = (GeometricCharge) (GeometricCharge) charges.get(0);
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.CROSS)));
		assertThat(ordinary.getTincture(), is(equalTo(vair)));
		assertThat(shield.getShieldDiagnostics().size(), is(0));
	}
	
	@Test
	public void testThatPerCrossOrAndArgentACrossGulesGivesTheCorrectShield() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("per cross or and argent a cross gules");
		ShieldImpl shield = (ShieldImpl) parser.shield();
		
		Tinctures tinctures = new Tinctures();
		Tincture gules = tinctures.getTincture("gules");
		Tincture or = tinctures.getTincture("or");
		Tincture argent = tinctures.getTincture("argent");

		ShieldDivisionType cross = new ShieldDivision().getDivisionType("CROSS", new ArrayList<ShieldDiagnostic>());
		
		assertThat(shield.getField(), is(notNullValue()));
		ShieldLayer layer = shield.getField();
		assertThat(layer.getShieldDivision(), is(equalTo(cross)));
		assertThat(layer.getTinctures().getTincturesOnLayer().size(), is(2));
		Iterator<Tincture> it = layer.getTinctures().getTincturesOnLayer().iterator();
		assertThat(it.next(), is(equalTo(or)));
		assertThat(it.next(), is(equalTo(argent)));
		assertThat(shield.getCharges(), is(notNullValue()));
		List<Charge> charges = shield.getCharges();
		assertThat((GeometricCharge) (GeometricCharge) charges.get(0), is(notNullValue()));
		GeometricCharge ordinary = (GeometricCharge) (GeometricCharge) charges.get(0);
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.CROSS)));
		assertThat(ordinary.getTincture(), is(equalTo(gules)));
		assertThat(shield.getShieldDiagnostics().size(), is(0));
	}
	
	@Test
	public void testThatPerCrossOrAndArgentACrossOrGivesTheCorrectShield() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("per cross or and argent a cross or");
		ShieldImpl shield = (ShieldImpl) parser.shield();
		
		Tinctures tinctures = new Tinctures();
		Tincture or = tinctures.getTincture("or");
		Tincture argent = tinctures.getTincture("argent");

		ShieldDivisionType cross = new ShieldDivision().getDivisionType("CROSS", new ArrayList<ShieldDiagnostic>());
		
		assertThat(shield.getField(), is(notNullValue()));
		ShieldLayer layer = shield.getField();
		assertThat(layer.getShieldDivision(), is(equalTo(cross)));
		assertThat(layer.getTinctures().getTincturesOnLayer().size(), is(2));
		Iterator<Tincture> it = layer.getTinctures().getTincturesOnLayer().iterator();
		assertThat(it.next(), is(equalTo(or)));
		assertThat(it.next(), is(equalTo(argent)));
		assertThat(shield.getCharges(), is(notNullValue()));
		List<Charge> charges = shield.getCharges();
		assertThat((GeometricCharge) (GeometricCharge) charges.get(0), is(notNullValue()));
		GeometricCharge ordinary = (GeometricCharge) (GeometricCharge) charges.get(0);
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.CROSS)));
		assertThat(ordinary.getTincture(), is(equalTo(or)));
		assertThat(shield.getShieldDiagnostics().size(), is(1));
		assertThat(shield.getShieldDiagnostics().get(0).getSeverity(), is(ShieldDiagnostic.LogLevel.WARN));
		assertThat(shield.getShieldDiagnostics().get(0).getMessage(), is(equalTo("You are not obeying the rule of tincture. You can not put a colour on a colour, or a metal on a metal")));
	}
	
	@Test
	public void testThatPerCrossVairAndPotentACrossVairEnPaleGivesTheCorrectShield() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("per cross vair and potent a cross vair-en-pale");
		ShieldImpl shield = (ShieldImpl) parser.shield();
		
		Tinctures tinctures = new Tinctures();
		Tincture vair = tinctures.getTincture("vair");
		Tincture potent = tinctures.getTincture("potent");
		Tincture vairEnPale = tinctures.getTincture("vair-en-pale");

		ShieldDivisionType cross = new ShieldDivision().getDivisionType("CROSS", new ArrayList<ShieldDiagnostic>());
		
		assertThat(shield.getField(), is(notNullValue()));
		ShieldLayer layer = shield.getField();
		assertThat(layer.getShieldDivision(), is(equalTo(cross)));
		assertThat(layer.getTinctures().getTincturesOnLayer().size(), is(2));
		Iterator<Tincture> it = layer.getTinctures().getTincturesOnLayer().iterator();
		assertThat(it.next(), is(equalTo(vair)));
		assertThat(it.next(), is(equalTo(potent)));
		assertThat(shield.getCharges(), is(notNullValue()));
		List<Charge> charges = shield.getCharges();
		assertThat((GeometricCharge) (GeometricCharge) charges.get(0), is(notNullValue()));
		GeometricCharge ordinary = (GeometricCharge) (GeometricCharge) charges.get(0);
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.CROSS)));
		assertThat(ordinary.getTincture(), is(equalTo(vairEnPale)));
		assertThat(shield.getShieldDiagnostics().size(), is(0));
	}
	
	@Test
	public void testThatPerCrossVairAndPotentACrossGulesGivesTheCorrectShield() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("per cross vair and potent a cross gules");
		ShieldImpl shield = (ShieldImpl) parser.shield();
		
		Tinctures tinctures = new Tinctures();
		Tincture vair = tinctures.getTincture("vair");
		Tincture potent = tinctures.getTincture("potent");
		Tincture gules = tinctures.getTincture("gules");

		ShieldDivisionType cross = new ShieldDivision().getDivisionType("CROSS", new ArrayList<ShieldDiagnostic>());
		
		assertThat(shield.getField(), is(notNullValue()));
		ShieldLayer layer = shield.getField();
		assertThat(layer.getShieldDivision(), is(equalTo(cross)));
		assertThat(layer.getTinctures().getTincturesOnLayer().size(), is(2));
		Iterator<Tincture> it = layer.getTinctures().getTincturesOnLayer().iterator();
		assertThat(it.next(), is(equalTo(vair)));
		assertThat(it.next(), is(equalTo(potent)));
		assertThat(shield.getCharges(), is(notNullValue()));
		List<Charge> charges = shield.getCharges();
		assertThat((GeometricCharge) (GeometricCharge) charges.get(0), is(notNullValue()));
		GeometricCharge ordinary = (GeometricCharge) (GeometricCharge) charges.get(0);
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.CROSS)));
		assertThat(ordinary.getTincture(), is(equalTo(gules)));
		assertThat(shield.getShieldDiagnostics().size(), is(0));
	}
	
	@Test
	public void testThatPerCrossVairAndPotentACrossOrGivesTheCorrectShield() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("per cross vair and potent a cross or");
		ShieldImpl shield = (ShieldImpl) parser.shield();
		
		Tinctures tinctures = new Tinctures();
		Tincture vair = tinctures.getTincture("vair");
		Tincture potent = tinctures.getTincture("potent");
		Tincture or = tinctures.getTincture("or");

		ShieldDivisionType cross = new ShieldDivision().getDivisionType("CROSS", new ArrayList<ShieldDiagnostic>());
		
		assertThat(shield.getField(), is(notNullValue()));
		ShieldLayer layer = shield.getField();
		assertThat(layer.getShieldDivision(), is(equalTo(cross)));
		assertThat(layer.getTinctures().getTincturesOnLayer().size(), is(2));
		Iterator<Tincture> it = layer.getTinctures().getTincturesOnLayer().iterator();
		assertThat(it.next(), is(equalTo(vair)));
		assertThat(it.next(), is(equalTo(potent)));
		assertThat(shield.getCharges(), is(notNullValue()));
		List<Charge> charges = shield.getCharges();
		assertThat((GeometricCharge) charges.get(0), is(notNullValue()));
		GeometricCharge ordinary = (GeometricCharge) charges.get(0);
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.CROSS)));
		assertThat(ordinary.getTincture(), is(equalTo(or)));
		assertThat(shield.getShieldDiagnostics().size(), is(0));
	}
	
	@Test
	public void testThatPerCrossVairAndGulesACrossOrGivesTheCorrectShield() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("per cross vair and gules a cross or");
		ShieldImpl shield = (ShieldImpl) parser.shield();
		
		Tinctures tinctures = new Tinctures();
		Tincture vair = tinctures.getTincture("vair");
		Tincture gules = tinctures.getTincture("gules");
		Tincture or = tinctures.getTincture("or");

		ShieldDivisionType cross = new ShieldDivision().getDivisionType("CROSS", new ArrayList<ShieldDiagnostic>());
		
		assertThat(shield.getField(), is(notNullValue()));
		ShieldLayer layer = shield.getField();
		assertThat(layer.getShieldDivision(), is(equalTo(cross)));
		assertThat(layer.getTinctures().getTincturesOnLayer().size(), is(2));
		Iterator<Tincture> it = layer.getTinctures().getTincturesOnLayer().iterator();
		assertThat(it.next(), is(equalTo(vair)));
		assertThat(it.next(), is(equalTo(gules)));
		assertThat(shield.getCharges(), is(notNullValue()));
		List<Charge> charges = shield.getCharges();
		assertThat((GeometricCharge) charges.get(0), is(notNullValue()));
		GeometricCharge ordinary = (GeometricCharge) charges.get(0);
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.CROSS)));
		assertThat(ordinary.getTincture(), is(equalTo(or)));
		assertThat(shield.getShieldDiagnostics().size(), is(0));
	}
	
	@Test
	public void testThatPerCrossVairAndGulesACrossSableGivesTheCorrectShield() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("per cross vair and gules a cross sable");
		ShieldImpl shield = (ShieldImpl) parser.shield();
		
		Tinctures tinctures = new Tinctures();
		Tincture vair = tinctures.getTincture("vair");
		Tincture gules = tinctures.getTincture("gules");
		Tincture sable = tinctures.getTincture("sable");

		ShieldDivisionType cross = new ShieldDivision().getDivisionType("CROSS", new ArrayList<ShieldDiagnostic>());
		
		assertThat(shield.getField(), is(notNullValue()));
		ShieldLayer layer = shield.getField();
		assertThat(layer.getShieldDivision(), is(equalTo(cross)));
		assertThat(layer.getTinctures().getTincturesOnLayer().size(), is(2));
		Iterator<Tincture> it = layer.getTinctures().getTincturesOnLayer().iterator();
		assertThat(it.next(), is(equalTo(vair)));
		assertThat(it.next(), is(equalTo(gules)));
		assertThat(shield.getCharges(), is(notNullValue()));
		List<Charge> charges = shield.getCharges();
		assertThat((GeometricCharge) charges.get(0), is(notNullValue()));
		GeometricCharge ordinary = (GeometricCharge) charges.get(0);
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.CROSS)));
		assertThat(ordinary.getTincture(), is(equalTo(sable)));
		assertThat(shield.getShieldDiagnostics().size(), is(0));
	}
	
	@Test
	public void testThatPerCrossVairAndGulesACrossPotentGivesTheCorrectShield() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("per cross vair and gules a cross potent");
		ShieldImpl shield = (ShieldImpl) parser.shield();
		
		Tinctures tinctures = new Tinctures();
		Tincture vair = tinctures.getTincture("vair");
		Tincture gules = tinctures.getTincture("gules");
		Tincture potent = tinctures.getTincture("potent");

		ShieldDivisionType cross = new ShieldDivision().getDivisionType("CROSS", new ArrayList<ShieldDiagnostic>());
		
		assertThat(shield.getField(), is(notNullValue()));
		ShieldLayer layer = shield.getField();
		assertThat(layer.getShieldDivision(), is(equalTo(cross)));
		assertThat(layer.getTinctures().getTincturesOnLayer().size(), is(2));
		Iterator<Tincture> it = layer.getTinctures().getTincturesOnLayer().iterator();
		assertThat(it.next(), is(equalTo(vair)));
		assertThat(it.next(), is(equalTo(gules)));
		assertThat(shield.getCharges(), is(notNullValue()));
		List<Charge> charges = shield.getCharges();
		assertThat((GeometricCharge) charges.get(0), is(notNullValue()));
		GeometricCharge ordinary = (GeometricCharge) charges.get(0);
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.CROSS)));
		assertThat(ordinary.getTincture(), is(equalTo(potent)));
		assertThat(shield.getShieldDiagnostics().size(), is(0));
	}
	
	@Test
	public void testThatPerCrossVairAndArgentACrossOrGivesTheCorrectShield() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("per cross vair and argent a cross or");
		ShieldImpl shield = (ShieldImpl) parser.shield();
		
		Tinctures tinctures = new Tinctures();
		Tincture vair = tinctures.getTincture("vair");
		Tincture argent = tinctures.getTincture("argent");
		Tincture or = tinctures.getTincture("or");

		ShieldDivisionType cross = new ShieldDivision().getDivisionType("CROSS", new ArrayList<ShieldDiagnostic>());
		
		assertThat(shield.getField(), is(notNullValue()));
		ShieldLayer layer = shield.getField();
		assertThat(layer.getShieldDivision(), is(equalTo(cross)));
		assertThat(layer.getTinctures().getTincturesOnLayer().size(), is(2));
		Iterator<Tincture> it = layer.getTinctures().getTincturesOnLayer().iterator();
		assertThat(it.next(), is(equalTo(vair)));
		assertThat(it.next(), is(equalTo(argent)));
		assertThat(shield.getCharges(), is(notNullValue()));
		List<Charge> charges = shield.getCharges();
		assertThat((GeometricCharge) charges.get(0), is(notNullValue()));
		GeometricCharge ordinary = (GeometricCharge) charges.get(0);
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.CROSS)));
		assertThat(ordinary.getTincture(), is(equalTo(or)));
		assertThat(shield.getShieldDiagnostics().size(), is(0));
	}
	
	@Test
	public void testThatPerCrossVairAndArgentACrossSableGivesTheCorrectShield() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("per cross vair and argent a cross sable");
		ShieldImpl shield = (ShieldImpl) parser.shield();
		
		Tinctures tinctures = new Tinctures();
		Tincture vair = tinctures.getTincture("vair");
		Tincture argent = tinctures.getTincture("argent");
		Tincture sable = tinctures.getTincture("sable");

		ShieldDivisionType cross = new ShieldDivision().getDivisionType("CROSS", new ArrayList<ShieldDiagnostic>());
		
		assertThat(shield.getField(), is(notNullValue()));
		ShieldLayer layer = shield.getField();
		assertThat(layer.getShieldDivision(), is(equalTo(cross)));
		assertThat(layer.getTinctures().getTincturesOnLayer().size(), is(2));
		Iterator<Tincture> it = layer.getTinctures().getTincturesOnLayer().iterator();
		assertThat(it.next(), is(equalTo(vair)));
		assertThat(it.next(), is(equalTo(argent)));
		assertThat(shield.getCharges(), is(notNullValue()));
		List<Charge> charges = shield.getCharges();
		assertThat((GeometricCharge) charges.get(0), is(notNullValue()));
		GeometricCharge ordinary = (GeometricCharge) charges.get(0);
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.CROSS)));
		assertThat(ordinary.getTincture(), is(equalTo(sable)));
		assertThat(shield.getShieldDiagnostics().size(), is(0));
	}
	
	@Test
	public void testThatPerCrossVairAndArgentACrossPotentGivesTheCorrectShield() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("per cross vair and argent a cross potent");
		ShieldImpl shield = (ShieldImpl) parser.shield();
		
		Tinctures tinctures = new Tinctures();
		Tincture vair = tinctures.getTincture("vair");
		Tincture argent = tinctures.getTincture("argent");
		Tincture potent = tinctures.getTincture("potent");

		ShieldDivisionType cross = new ShieldDivision().getDivisionType("CROSS", new ArrayList<ShieldDiagnostic>());
		
		assertThat(shield.getField(), is(notNullValue()));
		ShieldLayer layer = shield.getField();
		assertThat(layer.getShieldDivision(), is(equalTo(cross)));
		assertThat(layer.getTinctures().getTincturesOnLayer().size(), is(2));
		Iterator<Tincture> it = layer.getTinctures().getTincturesOnLayer().iterator();
		assertThat(it.next(), is(equalTo(vair)));
		assertThat(it.next(), is(equalTo(argent)));
		assertThat(shield.getCharges(), is(notNullValue()));
		List<Charge> charges = shield.getCharges();
		assertThat((GeometricCharge) charges.get(0), is(notNullValue()));
		GeometricCharge ordinary = (GeometricCharge) charges.get(0);
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.CROSS)));
		assertThat(ordinary.getTincture(), is(equalTo(potent)));
		assertThat(shield.getShieldDiagnostics().size(), is(0));
	}
	
	@Test
	public void testThatPerCrossGulesAndArgentACrossOrGivesTheCorrectShield() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("per cross gules and argent a cross or");
		ShieldImpl shield = (ShieldImpl) parser.shield();
		
		Tinctures tinctures = new Tinctures();
		Tincture gules = tinctures.getTincture("gules");
		Tincture argent = tinctures.getTincture("argent");
		Tincture or = tinctures.getTincture("or");

		ShieldDivisionType cross = new ShieldDivision().getDivisionType("CROSS", new ArrayList<ShieldDiagnostic>());
		
		assertThat(shield.getField(), is(notNullValue()));
		ShieldLayer layer = shield.getField();
		assertThat(layer.getShieldDivision(), is(equalTo(cross)));
		assertThat(layer.getTinctures().getTincturesOnLayer().size(), is(2));
		Iterator<Tincture> it = layer.getTinctures().getTincturesOnLayer().iterator();
		assertThat(it.next(), is(equalTo(gules)));
		assertThat(it.next(), is(equalTo(argent)));
		assertThat(shield.getCharges(), is(notNullValue()));
		List<Charge> charges = shield.getCharges();
		assertThat((GeometricCharge) charges.get(0), is(notNullValue()));
		GeometricCharge ordinary = (GeometricCharge) charges.get(0);
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.CROSS)));
		assertThat(ordinary.getTincture(), is(equalTo(or)));
		assertThat(shield.getShieldDiagnostics().size(), is(0));
	}
	
	@Test
	public void testThatPerCrossGulesAndArgentACrossSableGivesTheCorrectShield() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("per cross gules and argent a cross sable");
		ShieldImpl shield = (ShieldImpl) parser.shield();
		
		Tinctures tinctures = new Tinctures();
		Tincture gules = tinctures.getTincture("gules");
		Tincture argent = tinctures.getTincture("argent");
		Tincture sable = tinctures.getTincture("sable");

		ShieldDivisionType cross = new ShieldDivision().getDivisionType("CROSS", new ArrayList<ShieldDiagnostic>());
		
		assertThat(shield.getField(), is(notNullValue()));
		ShieldLayer layer = shield.getField();
		assertThat(layer.getShieldDivision(), is(equalTo(cross)));
		assertThat(layer.getTinctures().getTincturesOnLayer().size(), is(2));
		Iterator<Tincture> it = layer.getTinctures().getTincturesOnLayer().iterator();
		assertThat(it.next(), is(equalTo(gules)));
		assertThat(it.next(), is(equalTo(argent)));
		assertThat(shield.getCharges(), is(notNullValue()));
		List<Charge> charges = shield.getCharges();
		assertThat((GeometricCharge) charges.get(0), is(notNullValue()));
		GeometricCharge ordinary = (GeometricCharge) charges.get(0);
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.CROSS)));
		assertThat(ordinary.getTincture(), is(equalTo(sable)));
		assertThat(shield.getShieldDiagnostics().size(), is(0));
	}
	
	@Test
	public void testThatPerCrossGulesAndArgentACrossPotentGivesTheCorrectShield() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("per cross gules and argent a cross potent");
		ShieldImpl shield = (ShieldImpl) parser.shield();
		
		Tinctures tinctures = new Tinctures();
		Tincture gules = tinctures.getTincture("gules");
		Tincture argent = tinctures.getTincture("argent");
		Tincture potent = tinctures.getTincture("potent");

		ShieldDivisionType cross = new ShieldDivision().getDivisionType("CROSS", new ArrayList<ShieldDiagnostic>());
		
		assertThat(shield.getField(), is(notNullValue()));
		ShieldLayer layer = shield.getField();
		assertThat(layer.getShieldDivision(), is(equalTo(cross)));
		assertThat(layer.getTinctures().getTincturesOnLayer().size(), is(2));
		Iterator<Tincture> it = layer.getTinctures().getTincturesOnLayer().iterator();
		assertThat(it.next(), is(equalTo(gules)));
		assertThat(it.next(), is(equalTo(argent)));
		assertThat(shield.getCharges(), is(notNullValue()));
		List<Charge> charges = shield.getCharges();
		assertThat((GeometricCharge) charges.get(0), is(notNullValue()));
		GeometricCharge ordinary = (GeometricCharge) charges.get(0);
		assertThat(ordinary.getName(), is(equalTo(GeometricChargeNames.CROSS)));
		assertThat(ordinary.getTincture(), is(equalTo(potent)));
		assertThat(shield.getShieldDiagnostics().size(), is(0));
	}
	//CHARGED TESTS END HERE
	
	@Test
	public void testThatPerGyronnyGulesAndArgentReturnsInvalidShieldContainingMismatchedTokenException() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("per gyronny gules and argent");
		Shield s = parser.shield();
		List<ShieldDiagnostic> diags = s.getShieldDiagnostics();
		assertThat(diags.size(), is(equalTo(1)));
		ShieldDiagnostic diag = diags.iterator().next();
		assertThat(diag.getMessage(), is(equalTo("line 1:4 mismatched input 'gyronny' expecting set null")));
		
	}
}