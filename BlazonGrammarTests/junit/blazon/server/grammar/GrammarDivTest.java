package blazon.server.grammar;

import org.antlr.runtime.RecognitionException;
import org.junit.Test;

public class GrammarDivTest {
	
	@Test
	public void testThatDivAcceptsBend() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("bend");
		parser.div();
	}
	
	@Test
	public void testThatDivAcceptsChevron() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("chevron");
		parser.div();
	}
	
	@Test
	public void testThatDivAcceptsBendSinister() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("bend sinister");
		parser.div();
	}
	
	@Test
	public void testThatDivAcceptsChevronReversed() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("chevron reversed");
		parser.div();
	}
}
