import java.io.IOException;

import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;

import blazon.server.grammar.ANTLRNoCaseStringStream;
import blazon.server.grammar.BlazonLexer;
import blazon.server.grammar.BlazonParser;
import blazon.shared.shield.Shield;


public class Test {
	public static void main(String[] args) throws IOException, RecognitionException {
		CharStream input = new ANTLRNoCaseStringStream("gules");
		BlazonLexer lexer = new BlazonLexer(input);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		BlazonParser parser = new BlazonParser(tokenStream);
		Shield s = parser.shield();
		System.out.println(s);
	}
}
