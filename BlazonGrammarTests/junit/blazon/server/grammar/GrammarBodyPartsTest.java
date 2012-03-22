package blazon.server.grammar;

import java.util.Map;

import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.MismatchedTokenException;
import org.junit.Test;

import blazon.shared.shield.tinctures.Tincture;
import blazon.shared.shield.tinctures.Tinctures;
import blazon.shared.shield.tinctures.UnknownTinctureException;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;

public class GrammarBodyPartsTest {

	@Test
	public void testThatArmedArgentReturnsCorrectMapAndAddsArgentToTinctures() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("armed argent");
		Tinctures tinctures = new Tinctures();
		Tincture argent = tinctures.getTincture("argent");
		Map<String, Tincture> bodyParts = parser.body_parts(tinctures);
		assertThat(bodyParts.size(), is(1));
		assertTrue(bodyParts.containsKey("armed"));
		assertThat(bodyParts.get("armed"), is(equalTo(argent)));
		assertTrue(tinctures.getTincturesOnLayer().contains(argent));
	}
	
	@Test
	public void testThatArmedGulesReturnsCorrectMapAndAddsGulesToTinctures() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("armed gules");
		Tinctures tinctures = new Tinctures();
		Tincture gules = tinctures.getTincture("gules");
		Map<String, Tincture> bodyParts = parser.body_parts(tinctures);
		assertThat(bodyParts.size(), is(1));
		assertTrue(bodyParts.containsKey("armed"));
		assertThat(bodyParts.get("armed"), is(equalTo(gules)));
		assertTrue(tinctures.getTincturesOnLayer().contains(gules));
	}
	
	@Test
	public void testThatLanguedArgentReturnsCorrectMapAndAddsArgentToTinctures() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("langued argent");
		Tinctures tinctures = new Tinctures();
		Tincture argent = tinctures.getTincture("argent");
		Map<String, Tincture> bodyParts = parser.body_parts(tinctures);
		assertThat(bodyParts.size(), is(1));
		assertTrue(bodyParts.containsKey("langued"));
		assertThat(bodyParts.get("langued"), is(equalTo(argent)));
		assertTrue(tinctures.getTincturesOnLayer().contains(argent));
	}
	
	@Test
	public void testThatLanguedGulesReturnsCorrectMapAndAddsGulesToTinctures() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("langued gules");
		Tinctures tinctures = new Tinctures();
		Tincture gules = tinctures.getTincture("gules");
		Map<String, Tincture> bodyParts = parser.body_parts(tinctures);
		assertThat(bodyParts.size(), is(1));
		assertTrue(bodyParts.containsKey("langued"));
		assertThat(bodyParts.get("langued"), is(equalTo(gules)));
		assertTrue(tinctures.getTincturesOnLayer().contains(gules));
	}
	
	@Test
	public void testThatLanguedGulesAndArmedArgentReturnsCorrectMapAndAddsGulesAndArgentToTinctures() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("langued gules and armed argent");
		Tinctures tinctures = new Tinctures();
		Tincture gules = tinctures.getTincture("gules");
		Tincture argent = tinctures.getTincture("argent");

		Map<String, Tincture> bodyParts = parser.body_parts(tinctures);
		assertThat(bodyParts.size(), is(2));
		assertTrue(bodyParts.containsKey("langued"));
		assertThat(bodyParts.get("langued"), is(equalTo(gules)));
		assertTrue(bodyParts.containsKey("armed"));
		assertThat(bodyParts.get("armed"), is(equalTo(argent)));
		assertTrue(tinctures.getTincturesOnLayer().contains(argent));
		assertTrue(tinctures.getTincturesOnLayer().contains(gules));
	}
	
	@Test
	public void testThatLanguedArgentAndArmedGulesReturnsCorrectMapAndAddsGulesAndArgentToTinctures() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("langued argent and armed gules");
		Tinctures tinctures = new Tinctures();
		Tincture gules = tinctures.getTincture("gules");
		Tincture argent = tinctures.getTincture("argent");

		Map<String, Tincture> bodyParts = parser.body_parts(tinctures);
		assertThat(bodyParts.size(), is(2));
		assertTrue(bodyParts.containsKey("langued"));
		assertThat(bodyParts.get("langued"), is(equalTo(argent)));
		assertTrue(bodyParts.containsKey("armed"));
		assertThat(bodyParts.get("armed"), is(equalTo(gules)));
		assertTrue(tinctures.getTincturesOnLayer().contains(argent));
		assertTrue(tinctures.getTincturesOnLayer().contains(gules));
	}
	
	@Test
	public void testThatLanguedArgentEyedSableAndArmedGulesReturnsCorrectMapAndAddsGulesAndArgentToTinctures() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("langued argent eyed sable and armed gules");
		Tinctures tinctures = new Tinctures();
		Tincture gules = tinctures.getTincture("gules");
		Tincture argent = tinctures.getTincture("argent");
		Tincture sable = tinctures.getTincture("sable");

		Map<String, Tincture> bodyParts = parser.body_parts(tinctures);
		assertThat(bodyParts.size(), is(3));
		assertTrue(bodyParts.containsKey("langued"));
		assertThat(bodyParts.get("langued"), is(equalTo(argent)));
		assertTrue(bodyParts.containsKey("armed"));
		assertThat(bodyParts.get("armed"), is(equalTo(gules)));
		assertTrue(bodyParts.containsKey("eyed"));
		assertThat(bodyParts.get("eyed"), is(equalTo(sable)));
		assertTrue(tinctures.getTincturesOnLayer().contains(argent));
		assertTrue(tinctures.getTincturesOnLayer().contains(gules));
		assertTrue(tinctures.getTincturesOnLayer().contains(sable));
	}
	
	@Test
	public void testThatEyedSableLanguedArgentAndArmedGulesReturnsCorrectMapAndAddsGulesAndArgentToTinctures() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("eyed sable langued argent and armed gules");
		Tinctures tinctures = new Tinctures();
		Tincture gules = tinctures.getTincture("gules");
		Tincture argent = tinctures.getTincture("argent");
		Tincture sable = tinctures.getTincture("sable");

		Map<String, Tincture> bodyParts = parser.body_parts(tinctures);
		assertThat(bodyParts.size(), is(3));
		assertTrue(bodyParts.containsKey("langued"));
		assertThat(bodyParts.get("langued"), is(equalTo(argent)));
		assertTrue(bodyParts.containsKey("armed"));
		assertThat(bodyParts.get("armed"), is(equalTo(gules)));
		assertTrue(bodyParts.containsKey("eyed"));
		assertThat(bodyParts.get("eyed"), is(equalTo(sable)));
		assertTrue(tinctures.getTincturesOnLayer().contains(argent));
		assertTrue(tinctures.getTincturesOnLayer().contains(gules));
		assertTrue(tinctures.getTincturesOnLayer().contains(sable));
	}
	
	@Test(expected=MismatchedTokenException.class)
	public void testThatLanguedArgentArmedGulesThrowsException() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("langued argent armed gules");
		Tinctures tinctures = new Tinctures();
		parser.body_parts(tinctures);
	}
	
	@Test(expected=NoViableAltException.class)
	public void testThatLanguedArgentLionRampantOrThrowsException() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("langued argent lion rampant or");
		Tinctures tinctures = new Tinctures();
		parser.body_parts(tinctures);
	}
	
	@Test(expected=NoViableAltException.class)
	public void testThatLanguedGulesLionRampantOrThrowsException() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("langued gules lion rampant or");
		Tinctures tinctures = new Tinctures();
		parser.body_parts(tinctures);
	}
	
	@Test(expected=NoViableAltException.class)
	public void testThatArmedAndThrowsException() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("armed and");
		Tinctures tinctures = new Tinctures();
		parser.body_parts(tinctures);
	}
	
	@Test(expected=MismatchedTokenException.class)
	public void testThatAndThrowsException() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("and");
		Tinctures tinctures = new Tinctures();
		parser.body_parts(tinctures);
	}
	
	@Test(expected=NoViableAltException.class)
	public void testThatLionRampantOrThrowsException() throws RecognitionException, UnknownTinctureException {
		BlazonParser parser = new ParserCreator().createParser("lion rampant or");
		Tinctures tinctures = new Tinctures();
		parser.body_parts(tinctures);
	}
}
