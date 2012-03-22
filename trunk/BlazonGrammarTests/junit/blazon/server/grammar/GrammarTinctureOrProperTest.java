package blazon.server.grammar;

import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.junit.Test;

import blazon.shared.shield.tinctures.Colour;
import blazon.shared.shield.tinctures.Metal;
import blazon.shared.shield.tinctures.Proper;
import blazon.shared.shield.tinctures.Tincture;
import blazon.shared.shield.tinctures.Tinctures;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.instanceOf;

public class GrammarTinctureOrProperTest {
	
	@Test public void testThatCreatedTinctureIsMetalOrAndIsAddedToTinctures() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("or");
		Tinctures tinctures = new Tinctures();
		assertThat(tinctures.getTincturesOnLayer().size(), is(0));

		Tincture tincture = parser.tincture_or_proper(tinctures);
		assertThat(tincture, is(instanceOf(Metal.class)));
		assertThat(tincture.getName(), is(equalTo("or")));
		assertThat(tinctures.getTincturesOnLayer().size(), is(1));
	}
	
	@Test public void testThatCreatedTinctureIsMetalArgentAndIsAddedToTinctures() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("argent");
		Tinctures tinctures = new Tinctures();
		assertThat(tinctures.getTincturesOnLayer().size(), is(0));

		Tincture tincture = parser.tincture_or_proper(tinctures);
		assertThat(tincture, is(instanceOf(Metal.class)));
		assertThat(tincture.getName(), is(equalTo("argent")));
		assertThat(tinctures.getTincturesOnLayer().size(), is(1));
	}
	
	@Test public void testThatCreatedTinctureIsColourAzureAndIsAddedToTinctures() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("azure");
		Tinctures tinctures = new Tinctures();
		assertThat(tinctures.getTincturesOnLayer().size(), is(0));

		Tincture tincture = parser.tincture_or_proper(tinctures);
		assertThat(tincture, is(instanceOf(Colour.class)));
		assertThat(tincture.getName(), is(equalTo("azure")));
		assertThat(tinctures.getTincturesOnLayer().size(), is(1));
	}
	
	@Test public void testThatCreatedTinctureIsColourVertAndIsAddedToTinctures() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("vert");
		Tinctures tinctures = new Tinctures();
		assertThat(tinctures.getTincturesOnLayer().size(), is(0));

		Tincture tincture = parser.tincture_or_proper(tinctures);
		assertThat(tincture, is(instanceOf(Colour.class)));
		assertThat(tincture.getName(), is(equalTo("vert")));
		assertThat(tinctures.getTincturesOnLayer().size(), is(1));
	}
	
	@Test(expected=NoViableAltException.class)
	public void testThatCreatedTinctureIsFurVairAndIsAddedToTinctures() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("vair");
		Tinctures tinctures = new Tinctures();
		parser.tincture_or_proper(tinctures);
	}
	
	@Test(expected=NoViableAltException.class)
	public void testThatCreatedTinctureIsFurCounterPotentAndIsAddedToTinctures() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("counter-potent");
		Tinctures tinctures = new Tinctures();
		parser.tincture_or_proper(tinctures);
	}
	
	@Test
	public void testThatCreatedTinctureIsProperAndIsAddedToTinctures() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("proper");
		Tinctures tinctures = new Tinctures();
		assertThat(tinctures.getTincturesOnLayer().size(), is(0));
		Tincture tincture = parser.tincture_or_proper(tinctures);
		assertThat(tincture, is(instanceOf(Proper.class)));
		assertThat(tincture.getName(), is(equalTo("proper")));
		assertThat(tinctures.getTincturesOnLayer().size(), is(1));
	}
	
	@Test(expected=RecognitionException.class)
	public void testThatRecognitionExceptionIsThrownForUnrecognisedTinctureWhichIsALexicon() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("parted per");
		Tinctures tinctures = new Tinctures();
		parser.tincture_or_proper(tinctures);
	}
	
	@Test(expected=RecognitionException.class)
	public void testThatRecognitionExceptionIsThrownForUnrecognisedTinctureWhichIsNotALexicon() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("blah");
		Tinctures tinctures = new Tinctures();
		parser.tincture_or_proper(tinctures);
	}

}
