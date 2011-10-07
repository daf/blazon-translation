package blazon.server.grammar;

import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.TokenStream;

import blazon.server.grammar.ANTLRNoCaseStringStream;
import blazon.server.grammar.BlazonLexer;
import blazon.server.grammar.BlazonParser;
import blazon.shared.shield.diagnostic.ShieldDiagnostic;

public class ParserCreator {
	
	public BlazonParser createParser(String blazon) {
		return createParser(blazon, new ArrayList<ShieldDiagnostic>());
	}
	
	public BlazonParser createParser(String blazon, List<ShieldDiagnostic> diags) {
		CharStream input = new ANTLRNoCaseStringStream(blazon);
		BlazonLexer lexer = new BlazonLexer(input, diags);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		return new BlazonParser(tokenStream, diags);
	}
}
