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
import blazon.shared.shield.ShieldLayer;
import blazon.shared.shield.ShieldDivision.ShieldDivisionType;
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
