package blazon.server.grammar;
import java.util.ArrayList;

import org.antlr.runtime.RecognitionException;
import org.junit.Test;

import blazon.server.grammar.BlazonParser;
import blazon.shared.shield.ShieldDivision;
import blazon.shared.shield.ShieldDivision.ShieldDivisionType;
import blazon.shared.shield.ShieldLayer;
import blazon.shared.shield.diagnostic.ShieldDiagnostic;
import blazon.shared.shield.tinctures.Tincture;
import blazon.shared.shield.tinctures.Tinctures;
import blazon.shared.shield.tinctures.UnknownTinctureException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class GrammarPlainFieldTest {
	
	@Test
	public void testThatGulesReturnsTheCorrectLayer() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("gules");
		ShieldLayer layer = parser.plain_field();
		
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
		ShieldLayer layer = parser.plain_field();
		
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
		ShieldLayer gulesLayer = gulesParser.plain_field();
		ShieldLayer gulesPlainLayer = gulesPlainParser.plain_field();
		assertThat(gulesLayer, is(equalTo(gulesPlainLayer)));
	}
	
}
