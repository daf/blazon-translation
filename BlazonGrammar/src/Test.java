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
		String[] strings = new String[] { "gyronny gules and or",
				"gyronny of 5 gules and or",
				"gyronny of 524 gules and or",
				"gyronny of five gules and or",
				"gyronny of fifty two gules and or",
				"gyronny of one hundred and two gules and or",
		};
		for (String string : strings) {
			CharStream input = new ANTLRNoCaseStringStream(string);
			BlazonLexer lexer = new BlazonLexer(input);
			TokenStream tokenStream = new CommonTokenStream(lexer);
			BlazonParser parser = new BlazonParser(tokenStream);
			Shield s = parser.shield();
			System.out.println(s);
		}

	}
}
