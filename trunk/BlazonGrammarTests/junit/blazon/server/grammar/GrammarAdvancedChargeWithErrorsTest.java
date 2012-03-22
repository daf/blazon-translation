package blazon.server.grammar;

import java.util.List;

import org.antlr.runtime.MismatchedTokenException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.junit.Test;

import blazon.shared.shield.charges.AdvancedCharge;
import blazon.shared.shield.diagnostic.ShieldDiagnostic;
import blazon.shared.shield.tinctures.TinctureType;
import blazon.shared.shield.tinctures.Tinctures;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class GrammarAdvancedChargeWithErrorsTest {
	
	@Test(expected=NoViableAltException.class)
	public void testThatBlahThrowsException() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("blah");
		Tinctures tinctures = new Tinctures();
		parser.advanced_charge(tinctures, TinctureType.OTHER, 1);
	}
	
	@Test(expected=MismatchedTokenException.class)
	public void testThatLionBlahThrowsException() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("lion blah");
		Tinctures tinctures = new Tinctures();
		parser.advanced_charge(tinctures, TinctureType.OTHER, 1);
	}
	
	@Test(expected=NoViableAltException.class)
	public void testThatGriffinBlahThrowsException() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("griffin blah");
		Tinctures tinctures = new Tinctures();
		parser.advanced_charge(tinctures, TinctureType.OTHER, 1);
	}
	
	@Test
	public void testThatDragonsPassantWith1OccurrenceGivesWarning() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("dragons passant gules");
		Tinctures tinctures = new Tinctures();
		List<AdvancedCharge> advancedCharges = parser.advanced_charge(tinctures, TinctureType.OTHER, 1);
		assertThat(advancedCharges.size(), is(1));
		assertThat(advancedCharges.get(0).getTextDescription(), is("'dragon passant gules'"));
		List<ShieldDiagnostic> diagnostics = parser.getDiagnostics();
		assertThat(diagnostics.size(), is(1));
		assertThat(diagnostics.get(0).getSeverity(), is(equalTo(ShieldDiagnostic.LogLevel.WARNING)));
		assertThat(diagnostics.get(0).getMessage(), is(equalTo("You have specified that there is only one of a charge, but used the plural. Changing 'dragons' to 'dragon'.")));
	}
	
	@Test
	public void testThatDragonsPassantGulesOnColourOccurrenceGivesWarning() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("dragon passant gules");
		Tinctures tinctures = new Tinctures();
		List<AdvancedCharge> advancedCharges = parser.advanced_charge(tinctures, TinctureType.COLOUR, 1);
		assertThat(advancedCharges.size(), is(1));
		assertThat(advancedCharges.get(0).getTextDescription(), is("'dragon passant gules'"));
		List<ShieldDiagnostic> diagnostics = parser.getDiagnostics();
		assertThat(diagnostics.size(), is(1));
		assertThat(diagnostics.get(0).getSeverity(), is(equalTo(ShieldDiagnostic.LogLevel.WARNING)));
		assertThat(diagnostics.get(0).getMessage(), is(equalTo("You are not obeying the rule of tincture. You can not put a colour on a colour, or a metal on a metal")));
	}
}
