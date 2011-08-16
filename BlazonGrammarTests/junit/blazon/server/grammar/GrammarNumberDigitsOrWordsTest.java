package blazon.server.grammar;

import org.antlr.runtime.RecognitionException;
import org.junit.Test;

public class GrammarNumberDigitsOrWordsTest {

	@Test public void testThatNumberDigitsOrWordsAccepts1() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("1");
		parser.number_digits_or_words();
	}
	
	@Test public void testThatNumberDigitsOrWordsAccepts13() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("13");
		parser.number_digits_or_words();
	}
	
	@Test public void testThatNumberDigitsOrWordsAccepts1345() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("1345");
		parser.number_digits_or_words();
	}
	
	@Test public void testThatNumberDigitsOrWordsAcceptsOne() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("one");
		parser.number_digits_or_words();
	}

	@Test public void testThatNumberDigitsOrWordsAcceptsTwo() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("two");
		parser.number_digits_or_words();
	}
	
	@Test public void testThatNumberDigitsOrWordsAcceptsOneHundred() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("one hundred");
		parser.number_digits_or_words();
	}
	
	@Test public void testThatNumberDigitsOrWordsAcceptsOneHundredAndTwo() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("one hundred and two");
		parser.number_digits_or_words();
	}
	
	@Test public void testThatNumberDigitsOrWordsAcceptsFourteenThousand() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("fourteen thousand");
		parser.number_digits_or_words();
	}
	
	@Test public void testThatNumberDigitsOrWordsAcceptsTwoHundredAndThreeThousandSixHundredAndFourtyTwo() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("two hundred and three thousand six hundred and fourty two");
		parser.number_digits_or_words();
	}
	
	@Test(expected=RecognitionException.class)
	public void testThatNumberOfDigitsOrWordsDoesNotAcceptBlah() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("blah");
		parser.number_digits_or_words();
	}
	
	@Test(expected=RecognitionException.class)
	public void testThatNumberOfDigitsOrWordsDoesNotAcceptVert() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("vert");
		parser.number_digits_or_words();
	}
	
	@Test(expected=RecognitionException.class)
	public void testThatNumberOfDigitsOrWordsDoesNotAcceptAnd() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("and");
		parser.number_digits_or_words();
	}
}
