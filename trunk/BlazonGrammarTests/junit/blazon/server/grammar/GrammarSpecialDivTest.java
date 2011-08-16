package blazon.server.grammar;

import org.antlr.runtime.RecognitionException;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

public class GrammarSpecialDivTest {

	@Test
	public void testThatSpecialDivReturnsStringMatchingGyronny() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("gyronny");
		String result = parser.special_div();
		assertThat(result, is(equalTo("gyronny")));
	}
	
	@Test
	public void testThatSpecialDivReturnsStringMatchingGyronnyOf8() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("gyronny of 8");
		String result = parser.special_div();
		assertThat(result, is(equalTo("gyronny of 8")));
	}
	
	@Test
	public void testThatSpecialDivReturnsStringMatchingGyronnyOf142() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("gyronny of 142");
		String result = parser.special_div();
		assertThat(result, is(equalTo("gyronny of 142")));
	}
	
	@Test
	public void testThatSpecialDivReturnsStringMatchingGyronnyOfEight() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("gyronny of eight");
		String result = parser.special_div();
		assertThat(result, is(equalTo("gyronny of 8")));
	}
	
	@Test
	public void testThatSpecialDivReturnsStringMatchingGyronnyOfThirtyTwo() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("gyronny of thirty two");
		String result = parser.special_div();
		assertThat(result, is(equalTo("gyronny of 32")));
	}
	
	@Test
	public void testThatSpecialDivReturnsStringMatchingGyronnyOfOneHundredAndFourtyTwo() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("gyronny of one hundred and fourty two");
		String result = parser.special_div();
		assertThat(result, is(equalTo("gyronny of 142")));
	}
	
	@Test
	public void testThatSpecialDivIncrementsOddNumbersAndReturnsGyronnyOf8() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("gyronny of seven");
		String result = parser.special_div();
		assertThat(result, is(equalTo("gyronny of 8")));
	}
	
	@Test
	public void testThatSpecialDivIncrementsOddNumbersAndReturnsGyronnyOf32() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("gyronny of thirty one");
		String result = parser.special_div();
		assertThat(result, is(equalTo("gyronny of 32")));
	}
	
	@Test
	public void testThatSpecialDivIncrementsOddNumbersAndReturnsGyronnyOf32DigitInput() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("gyronny of 31");
		String result = parser.special_div();
		assertThat(result, is(equalTo("gyronny of 32")));
	}
	
	@Test(expected=MyRecognitionException.class)
	public void testThatSpecialDivThrowsMyRecognitionExceptionForUnrecognisedNumbers() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("gyronny of one million million");
		parser.special_div();
	}
	
	@Test(expected=RecognitionException.class)
	public void testThatSpecialDivThrowsRecognitionExceptionForGyronnyOf() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("gyronny of");
		parser.special_div();
	}
}
