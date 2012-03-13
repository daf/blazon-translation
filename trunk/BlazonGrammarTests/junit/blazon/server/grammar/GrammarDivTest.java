package blazon.server.grammar;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.junit.Test;

import blazon.shared.shield.ShieldDivision.ShieldDivisionType;

public class GrammarDivTest {
	
	@Test
	public void testThatDivCreatesPerCross() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("per cross");
		ShieldDivisionType result = parser.div();
		assertThat(result.getName(), is(equalTo("CROSS")));
		assertThat(result.getNumberOfSections(), is(4));
		assertThat(result.getNumberOfTinctures(), is(2));
	}
	
	@Test
	public void testThatDivCreatesCrossFromQuarterly() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("quarterly");
		ShieldDivisionType result = parser.div();
		assertThat(result.getName(), is(equalTo("CROSS")));
		assertThat(result.getNumberOfSections(), is(4));
		assertThat(result.getNumberOfTinctures(), is(2));
	}	
	
	@Test
	public void testThatDivCreatesCrossFromQuartered() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("quartered");
		ShieldDivisionType result = parser.div();
		assertThat(result.getName(), is(equalTo("CROSS")));
		assertThat(result.getNumberOfSections(), is(4));
		assertThat(result.getNumberOfTinctures(), is(2));
	}

	@Test
	public void testThatDivCreatesPerBend() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("per bend");
		ShieldDivisionType result = parser.div();
		assertThat(result.getName(), is(equalTo("BEND")));
		assertThat(result.getNumberOfSections(), is(2));
		assertThat(result.getNumberOfTinctures(), is(2));
	}
	
	@Test
	public void testThatDivCreatesBendy() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("bendy");
		ShieldDivisionType result = parser.div();
		assertThat(result.getName(), is(equalTo("BENDY")));
		assertThat(result.getNumberOfSections(), is(6));
		assertThat(result.getNumberOfTinctures(), is(2));
	}

	@Test
	public void testThatDivAcceptsPerChevron() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("per chevron");
		ShieldDivisionType result = parser.div();
		assertThat(result.getName(), is(equalTo("CHEVRON")));
		assertThat(result.getNumberOfSections(), is(2));
		assertThat(result.getNumberOfTinctures(), is(2));
	}
	
	@Test
	public void testThatDivAcceptsChevronny() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("chevronny");
		ShieldDivisionType result = parser.div();
		assertThat(result.getName(), is(equalTo("CHEVRONNY")));
		assertThat(result.getNumberOfSections(), is(6));
		assertThat(result.getNumberOfTinctures(), is(2));
	}
	
	@Test
	public void testThatDivAcceptsPerBendSinister() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("per bend sinister");
		ShieldDivisionType result = parser.div();
		assertThat(result.getName(), is(equalTo("BEND_SINISTER")));
		assertThat(result.getNumberOfSections(), is(2));
		assertThat(result.getNumberOfTinctures(), is(2));
	}
	
	@Test
	public void testThatDivAcceptsBendySinister() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("bendy sinister");
		ShieldDivisionType result = parser.div();
		assertThat(result.getName(), is(equalTo("BENDY_SINISTER")));
		assertThat(result.getNumberOfSections(), is(6));
		assertThat(result.getNumberOfTinctures(), is(2));
	}
	
	@Test
	public void testThatDivAcceptsPerChevronReversed() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("per chevron reversed");
		ShieldDivisionType result = parser.div();
		assertThat(result.getName(), is(equalTo("CHEVRON_REVERSED")));
		assertThat(result.getNumberOfSections(), is(2));
		assertThat(result.getNumberOfTinctures(), is(2));
	}
	
	@Test
	public void testThatDivAcceptsChevronnyReversed() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("chevronny reversed");
		ShieldDivisionType result = parser.div();
		assertThat(result.getName(), is(equalTo("CHEVRONNY_REVERSED")));
		assertThat(result.getNumberOfSections(), is(6));
		assertThat(result.getNumberOfTinctures(), is(2));
	}
	
	@Test
	public void testThatDivAcceptsTiercedPerPale()  throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("tierced per pale");
		ShieldDivisionType result = parser.div();
		assertThat(result.getName(), is(equalTo("TIERCED_PALE")));
		assertThat(result.getNumberOfSections(), is(3));
		assertThat(result.getNumberOfTinctures(), is(3));
	}
	
	@Test
	public void testThatDivAcceptsPerPall()  throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("per pall");
		ShieldDivisionType result = parser.div();
		assertThat(result.getName(), is(equalTo("PALL")));
		assertThat(result.getNumberOfSections(), is(3));
		assertThat(result.getNumberOfTinctures(), is(3));
	}
	
	@Test
	public void testThatDivAcceptsChequy()  throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("chequy");
		ShieldDivisionType result = parser.div();
		assertThat(result.getName(), is(equalTo("CHEQUY")));
		assertThat(result.getNumberOfSections(), is(36));
		assertThat(result.getNumberOfTinctures(), is(2));
	}
	
	@Test
	public void testThatDivAcceptsLozengy()  throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("lozengy");
		ShieldDivisionType result = parser.div();
		assertThat(result.getName(), is(equalTo("LOZENGY")));
		assertThat(result.getNumberOfSections(), is(36));
		assertThat(result.getNumberOfTinctures(), is(2));
	}
	
	@Test
	public void testThatDivReturnsStringMatchingGyronny() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("gyronny");
		ShieldDivisionType result = parser.div();
		assertThat(result.getName(), is(equalTo("GYRONNY")));
		assertThat(result.getNumberOfSections(), is(8));
		assertThat(result.getNumberOfTinctures(), is(2));
	}
	
	@Test
	public void testThatDivReturnsStringMatchingGyronnyOf8() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("gyronny of 8");
		ShieldDivisionType result = parser.div();
		assertThat(result.getName(), is(equalTo("GYRONNY_OF_8")));
		assertThat(result.getNumberOfSections(), is(8));
		assertThat(result.getNumberOfTinctures(), is(2));
	}
	
	@Test
	public void testThatDivReturnsStringMatchingGyronnyOf142() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("gyronny of 142");
		ShieldDivisionType result = parser.div();
		assertThat(result.getName(), is(equalTo("GYRONNY_OF_142")));
		assertThat(result.getNumberOfSections(), is(142));
		assertThat(result.getNumberOfTinctures(), is(2));
	}
	
	@Test
	public void testThatDivReturnsStringMatchingGyronnyOfEight() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("gyronny of eight");
		ShieldDivisionType result = parser.div();
		assertThat(result.getName(), is(equalTo("GYRONNY_OF_8")));
		assertThat(result.getNumberOfSections(), is(8));
		assertThat(result.getNumberOfTinctures(), is(2));
	}
	
	@Test
	public void testThatDivReturnsStringMatchingGyronnyOfThirtyTwo() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("gyronny of thirty two");
		ShieldDivisionType result = parser.div();
		assertThat(result.getName(), is(equalTo("GYRONNY_OF_32")));
		assertThat(result.getNumberOfSections(), is(32));
		assertThat(result.getNumberOfTinctures(), is(2));
	}
	
	@Test
	public void testThatDivReturnsStringMatchingGyronnyOfOneHundredAndFourtyTwo() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("gyronny of one hundred and fourty two");
		ShieldDivisionType result = parser.div();
		assertThat(result.getName(), is(equalTo("GYRONNY_OF_142")));
		assertThat(result.getNumberOfSections(), is(142));
		assertThat(result.getNumberOfTinctures(), is(2));
	}
	
	@Test
	public void testThatDivIncrementsOddNumbersAndReturnsGyronnyOf8() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("gyronny of seven");
		ShieldDivisionType result = parser.div();
		assertThat(result.getName(), is(equalTo("GYRONNY_OF_8")));
		assertThat(result.getNumberOfSections(), is(8));
		assertThat(result.getNumberOfTinctures(), is(2));	}
	
	@Test
	public void testThatDivIncrementsOddNumbersAndReturnsGyronnyOf32() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("gyronny of thirty one");
		ShieldDivisionType result = parser.div();
		assertThat(result.getName(), is(equalTo("GYRONNY_OF_32")));
		assertThat(result.getNumberOfSections(), is(32));
		assertThat(result.getNumberOfTinctures(), is(2));
	}
	
	@Test
	public void testThatDivIncrementsOddNumbersAndReturnsGyronnyOf32DigitInput() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("gyronny of 31");
		ShieldDivisionType result = parser.div();
		assertThat(result.getName(), is(equalTo("GYRONNY_OF_32")));
		assertThat(result.getNumberOfSections(), is(32));
		assertThat(result.getNumberOfTinctures(), is(2));
	}
	
	@Test(expected=RecognitionException.class)
	public void testThatDivThrowsMyRecognitionExceptionForUnrecognisedNumbers() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("gyronny of one million million");
		parser.div();
	}
	
	@Test(expected=RecognitionException.class)
	public void testThatDivThrowsRecognitionExceptionForGyronnyOf() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("gyronny of");
		parser.div();
	}
	
	@Test(expected=RecognitionException.class)
	public void testThatDivThrowsRecognitionExceptionForPerGyronnyGulesAndOr() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("per gyronny gules and or");
		parser.div();
	}
	
	@Test(expected=NoViableAltException.class)
	public void testThatDivThrowsNoViableAltExceptionForBlah() throws RecognitionException {
		BlazonParser parser = new ParserCreator().createParser("blah");
		parser.div();
	}
}