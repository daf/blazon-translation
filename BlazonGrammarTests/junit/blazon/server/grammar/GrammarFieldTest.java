package blazon.server.grammar;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Iterator;

import org.antlr.runtime.MismatchedTokenException;
import org.antlr.runtime.RecognitionException;
import org.junit.Test;

import blazon.server.grammar.BlazonParser;
import blazon.shared.shield.ShieldDivision;
import blazon.shared.shield.ShieldLayer;
import blazon.shared.shield.ShieldDivision.ShieldDivisionType;
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
		ShieldDivisionType plain = new ShieldDivision().getDivisionType("none");
		
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
		ShieldDivisionType plain = new ShieldDivision().getDivisionType("none");
		
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
	
	@Test
	public void testThatPerBendGulesAndArgentGivesTheCorrectLayer() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("per bend gules and argent");
		ShieldLayer layer = parser.field();
		
		Tinctures tinctures = new Tinctures();
		Tincture gules = tinctures.getTincture("gules");
		Tincture argent = tinctures.getTincture("argent");
		ShieldDivisionType bend = new ShieldDivision().getDivisionType("bend");
		
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
		ShieldDivisionType bend = new ShieldDivision().getDivisionType("bend");
		
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
		ShieldDivisionType bend = new ShieldDivision().getDivisionType("bend");
		
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
		ShieldDivisionType bend = new ShieldDivision().getDivisionType("bend");
		
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
		ShieldDivisionType bendSinister = new ShieldDivision().getDivisionType("bend sinister");
		
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
		ShieldDivisionType gyronny = new ShieldDivision().getDivisionType("gyronny");
		
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
		ShieldDivisionType gyronny = new ShieldDivision().getDivisionType("gyronny of 16");
		
		assertThat(layer.getShieldDivision(), is(equalTo(gyronny)));
		Iterator<Tincture> tincturesOnLayer = layer.getTinctures().getTincturesOnLayer().iterator();
		assertThat(tincturesOnLayer.next(), is(equalTo(gules)));
		assertThat(tincturesOnLayer.next(), is(equalTo(argent)));
	}
	
	@Test(expected=MismatchedTokenException.class)
	public void testThatPerGyronnyGulesAndArgentThrowsMismatchedTokenException() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("per gyronny gules and argent");
		parser.field();
	}
}