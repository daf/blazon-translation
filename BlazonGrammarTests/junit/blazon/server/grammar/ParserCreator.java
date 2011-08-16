package blazon.server.grammar;

import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.TokenStream;

import blazon.server.grammar.ANTLRNoCaseStringStream;
import blazon.server.grammar.BlazonLexer;
import blazon.server.grammar.BlazonParser;

public class ParserCreator {
	
	public BlazonParser createParser(String blazon) {
		CharStream input = new ANTLRNoCaseStringStream(blazon);
		BlazonLexer lexer = new BlazonLexer(input);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		return new BlazonParser(tokenStream);
	}
}
