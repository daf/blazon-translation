package blazon.server.grammar;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Iterator;

import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.MismatchedTokenException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.junit.Test;

import blazon.server.grammar.BlazonParser;
import blazon.shared.shield.ShieldDivision;
import blazon.shared.shield.ShieldLayer;
import blazon.shared.shield.ShieldDivision.ShieldDivisionType;
import blazon.shared.shield.diagnostic.ShieldDiagnostic;
import blazon.shared.shield.tinctures.Tincture;
import blazon.shared.shield.tinctures.Tinctures;
import blazon.shared.shield.tinctures.UnknownTinctureException;


public class GrammarFieldTest {

	@Test
	public void testThatGulesReturnsTheCorrectLayer() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("gules");
		ShieldLayer layer = parser.field();
		
		Tinctures tinctures = new Tinctures();
		Tincture gules = tinctures.getTincture("gules");
		ShieldDivisionType plain = new ShieldDivision().getDivisionType("none", new ArrayList<ShieldDiagnostic>());
		
		assertThat(layer.getShieldDivision(), is(equalTo(plain)));
		Tincture tinctureOnLayer = layer.getTinctures().getTincturesOnLayer().iterator().next();
		assertThat(tinctureOnLayer, is(equalTo(gules)));
	}
	
	@Test
	public void testThatGulesPlainReturnsTheCorrectLayer() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("gules plain");
		ShieldLayer layer = parser.field();
		
		Tinctures tinctures = new Tinctures();
		Tincture gules = tinctures.getTincture("gules");
		ShieldDivisionType plain = new ShieldDivision().getDivisionType("none", new ArrayList<ShieldDiagnostic>());
		
		assertThat(layer.getShieldDivision(), is(equalTo(plain)));
		Tincture tinctureOnLayer = layer.getTinctures().getTincturesOnLayer().iterator().next();
		assertThat(tinctureOnLayer, is(equalTo(gules)));
	}
	
	
	@Test
	public void testThatGulesIsEqualToGulesPlain() throws RecognitionException {
		BlazonParser gulesPlainParser = new ParserCreator().createParser("gules plain");
		BlazonParser gulesParser = new ParserCreator().createParser("gules");
		
		ShieldLayer gulesLayer = gulesParser.field();
		ShieldLayer gulesPlainLayer = gulesPlainParser.field();
		assertThat(gulesLayer, is(equalTo(gulesPlainLayer)));
	}
	
	@Test(expected=NoViableAltException.class)
	public void testThatBlahPlainGivesANoViableAltException() throws RecognitionException {
		BlazonParser gulesPlainParser = new ParserCreator().createParser("blah plain");
		gulesPlainParser.field();
	}
	
	@Test
	public void testThatPerBendGulesAndArgentGivesTheCorrectLayer() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("per bend gules and argent");
		ShieldLayer layer = parser.field();
		
		Tinctures tinctures = new Tinctures();
		Tincture gules = tinctures.getTincture("gules");
		Tincture argent = tinctures.getTincture("argent");
		ShieldDivisionType bend = new ShieldDivision().getDivisionType("bend", new ArrayList<ShieldDiagnostic>());
		
		assertThat(layer.getShieldDivision(), is(equalTo(bend)));
		Iterator<Tincture> tincturesOnLayer = layer.getTinctures().getTincturesOnLayer().iterator();
		assertThat(tincturesOnLayer.next(), is(equalTo(gules)));
		assertThat(tincturesOnLayer.next(), is(equalTo(argent)));
	}
	
	@Test
	public void testThatPerBendArgentAndGulesGivesTheCorrectLayer() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("per bend argent and gules");
		ShieldLayer layer = parser.field();
		
		Tinctures tinctures = new Tinctures();
		Tincture gules = tinctures.getTincture("gules");
		Tincture argent = tinctures.getTincture("argent");
		ShieldDivisionType bend = new ShieldDivision().getDivisionType("bend", new ArrayList<ShieldDiagnostic>());
		
		assertThat(layer.getShieldDivision(), is(equalTo(bend)));
		Iterator<Tincture> tincturesOnLayer = layer.getTinctures().getTincturesOnLayer().iterator();
		assertThat(tincturesOnLayer.next(), is(equalTo(argent)));
		assertThat(tincturesOnLayer.next(), is(equalTo(gules)));
	}
	
	@Test
	public void testThatPartyPerBendGulesAndArgentGivesTheCorrectLayer() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("party per bend gules and argent");
		ShieldLayer layer = parser.field();
		
		Tinctures tinctures = new Tinctures();
		Tincture gules = tinctures.getTincture("gules");
		Tincture argent = tinctures.getTincture("argent");
		ShieldDivisionType bend = new ShieldDivision().getDivisionType("bend", new ArrayList<ShieldDiagnostic>());
		
		assertThat(layer.getShieldDivision(), is(equalTo(bend)));
		Iterator<Tincture> tincturesOnLayer = layer.getTinctures().getTincturesOnLayer().iterator();
		assertThat(tincturesOnLayer.next(), is(equalTo(gules)));
		assertThat(tincturesOnLayer.next(), is(equalTo(argent)));
	}
	
	@Test
	public void testThatPartedPerBendGulesAndArgentGivesTheCorrectLayer() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("parted per bend gules and argent");
		ShieldLayer layer = parser.field();
		
		Tinctures tinctures = new Tinctures();
		Tincture gules = tinctures.getTincture("gules");
		Tincture argent = tinctures.getTincture("argent");
		ShieldDivisionType bend = new ShieldDivision().getDivisionType("bend", new ArrayList<ShieldDiagnostic>());
		
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
		
		ShieldLayer partedLayer = partedParser.field();
		ShieldLayer partyLayer = partyParser.field();
		ShieldLayer perLayer = perParser.field();
		
		assertThat(partedLayer, is(equalTo(partyLayer)));
		assertThat(partyLayer, is(equalTo(perLayer)));
		assertThat(partedLayer, is(equalTo(perLayer)));
	}
	
	@Test
	public void testThatPerBendSinisterGulesAndArgentGivesTheCorrectLayer() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("per bend sinister gules and argent");
		ShieldLayer layer = parser.field();
		
		Tinctures tinctures = new Tinctures();
		Tincture gules = tinctures.getTincture("gules");
		Tincture argent = tinctures.getTincture("argent");
		ShieldDivisionType bendSinister = new ShieldDivision().getDivisionType("bend sinister", new ArrayList<ShieldDiagnostic>());
		
		assertThat(layer.getShieldDivision(), is(equalTo(bendSinister)));
		Iterator<Tincture> tincturesOnLayer = layer.getTinctures().getTincturesOnLayer().iterator();
		assertThat(tincturesOnLayer.next(), is(equalTo(gules)));
		assertThat(tincturesOnLayer.next(), is(equalTo(argent)));
	}
	
	@Test
	public void testThatGyronnyGulesAndArgentGivesTheCorrectLayer() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("gyronny gules and argent");
		ShieldLayer layer = parser.field();
		
		Tinctures tinctures = new Tinctures();
		Tincture gules = tinctures.getTincture("gules");
		Tincture argent = tinctures.getTincture("argent");
		ShieldDivisionType gyronny = new ShieldDivision().getDivisionType("gyronny", new ArrayList<ShieldDiagnostic>());
		
		assertThat(layer.getShieldDivision(), is(equalTo(gyronny)));
		Iterator<Tincture> tincturesOnLayer = layer.getTinctures().getTincturesOnLayer().iterator();
		assertThat(tincturesOnLayer.next(), is(equalTo(gules)));
		assertThat(tincturesOnLayer.next(), is(equalTo(argent)));
	}
	
	@Test
	public void testThatGyronnyOfSixteenGulesAndArgentGivesTheCorrectLayer() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("gyronny of sixteen gules and argent");
		ShieldLayer layer = parser.field();
		
		Tinctures tinctures = new Tinctures();
		Tincture gules = tinctures.getTincture("gules");
		Tincture argent = tinctures.getTincture("argent");
		ShieldDivisionType gyronny = new ShieldDivision().getDivisionType("gyronny of 16", new ArrayList<ShieldDiagnostic>());
		
		assertThat(layer.getShieldDivision(), is(equalTo(gyronny)));
		Iterator<Tincture> tincturesOnLayer = layer.getTinctures().getTincturesOnLayer().iterator();
		assertThat(tincturesOnLayer.next(), is(equalTo(gules)));
		assertThat(tincturesOnLayer.next(), is(equalTo(argent)));
	}
	
	@Test(expected=MismatchedSetException.class)
	public void testThatPerGyronnyGulesAndArgentThrowsMismatchedSetException() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("per gyronny gules and argent");
		parser.field();
	}
	
	@Test(expected=NoViableAltException.class)
	public void testThatRandomThrowsNoViableAltException() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("random");
		parser.field();
	}
	
	@Test
	public void testThatPerBendVairEnPaleAndArgentGivesTheCorrectLayer() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("per bend vair-en-pale and argent");
		ShieldLayer layer = parser.field();
		
		Tinctures tinctures = new Tinctures();
		Tincture vairEnPale = tinctures.getTincture("vair-en-pale");
		Tincture argent = tinctures.getTincture("argent");
		ShieldDivisionType bend = new ShieldDivision().getDivisionType("bend", new ArrayList<ShieldDiagnostic>());
		
		assertThat(layer.getShieldDivision(), is(equalTo(bend)));
		Iterator<Tincture> tincturesOnLayer = layer.getTinctures().getTincturesOnLayer().iterator();
		assertThat(tincturesOnLayer.next(), is(equalTo(vairEnPale)));
		assertThat(tincturesOnLayer.next(), is(equalTo(argent)));
	}
	
	@Test
	public void testThatPerBendArgentAndVairEnPointGivesTheCorrectLayer() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("per bend argent and vair-en-point");
		ShieldLayer layer = parser.field();
		
		Tinctures tinctures = new Tinctures();
		Tincture vairEnPoint = tinctures.getTincture("vair-en-point");
		Tincture argent = tinctures.getTincture("argent");
		ShieldDivisionType bend = new ShieldDivision().getDivisionType("bend", new ArrayList<ShieldDiagnostic>());
		
		assertThat(layer.getShieldDivision(), is(equalTo(bend)));
		Iterator<Tincture> tincturesOnLayer = layer.getTinctures().getTincturesOnLayer().iterator();
		assertThat(tincturesOnLayer.next(), is(equalTo(argent)));
		assertThat(tincturesOnLayer.next(), is(equalTo(vairEnPoint)));
	}
	
	@Test
	public void testThatPartyPerBendPotentEnPaleAndArgentGivesTheCorrectLayer() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("party per bend potent-en-pale and argent");
		ShieldLayer layer = parser.field();
		
		Tinctures tinctures = new Tinctures();
		Tincture potentEnPale = tinctures.getTincture("potent-en-pale");
		Tincture argent = tinctures.getTincture("argent");
		ShieldDivisionType bend = new ShieldDivision().getDivisionType("bend", new ArrayList<ShieldDiagnostic>());
		
		assertThat(layer.getShieldDivision(), is(equalTo(bend)));
		Iterator<Tincture> tincturesOnLayer = layer.getTinctures().getTincturesOnLayer().iterator();
		assertThat(tincturesOnLayer.next(), is(equalTo(potentEnPale)));
		assertThat(tincturesOnLayer.next(), is(equalTo(argent)));
	}
	
	@Test
	public void testThatPartedPerBendPotentEnPointAndArgentGivesTheCorrectLayer() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("parted per bend potent-en-point and argent");
		ShieldLayer layer = parser.field();
		
		Tinctures tinctures = new Tinctures();
		Tincture potentEnPoint = tinctures.getTincture("potent-en-point");
		Tincture argent = tinctures.getTincture("argent");
		ShieldDivisionType bend = new ShieldDivision().getDivisionType("bend", new ArrayList<ShieldDiagnostic>());
		
		assertThat(layer.getShieldDivision(), is(equalTo(bend)));
		Iterator<Tincture> tincturesOnLayer = layer.getTinctures().getTincturesOnLayer().iterator();
		assertThat(tincturesOnLayer.next(), is(equalTo(potentEnPoint)));
		assertThat(tincturesOnLayer.next(), is(equalTo(argent)));
	}
	
	@Test
	public void testThatGyronnyCounterVairAndArgentGivesTheCorrectLayer() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("gyronny counter-vair and argent");
		ShieldLayer layer = parser.field();
		
		Tinctures tinctures = new Tinctures();
		Tincture counterVair = tinctures.getTincture("counter-vair");
		Tincture argent = tinctures.getTincture("argent");
		ShieldDivisionType gyronny = new ShieldDivision().getDivisionType("gyronny", new ArrayList<ShieldDiagnostic>());
		
		assertThat(layer.getShieldDivision(), is(equalTo(gyronny)));
		Iterator<Tincture> tincturesOnLayer = layer.getTinctures().getTincturesOnLayer().iterator();
		assertThat(tincturesOnLayer.next(), is(equalTo(counterVair)));
		assertThat(tincturesOnLayer.next(), is(equalTo(argent)));
	}
	
}
