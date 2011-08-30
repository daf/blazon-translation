package blazon.server.grammar;

import org.antlr.runtime.RecognitionException;
import org.junit.Test;

public class GrammarDivTest {
	
	@Test
	public void testThatDivAcceptsPerBend() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("per bend");
		parser.div();
	}
	
	@Test
	public void testThatDivAcceptsPerChevron() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("per chevron");
		parser.div();
	}
	
	@Test
	public void testThatDivAcceptsPerBendSinister() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("per bend sinister");
		parser.div();
	}
	
	@Test
	public void testThatDivAcceptsPerChevronReversed() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("per chevron reversed");
		parser.div();
	}
	
	@Test
	public void testThatDivAcceptsTiercedPerPale()  throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("tierced per pale");
		parser.div();
	}
}
