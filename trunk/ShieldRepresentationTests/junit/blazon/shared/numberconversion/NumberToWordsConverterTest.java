package blazon.shared.numberconversion;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Collection;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.BeforeClass;
import org.junit.Test;

@RunWith(Parameterized.class)
public class NumberToWordsConverterTest {

	private static NumberToWordsConverter _converter;
	
	@BeforeClass
	public static void setUp() {
		_converter = new NumberToWordsConverter();
	}
	
	private long _valueToConvert;
	private String _expectedResult;
	
	public NumberToWordsConverterTest(long value, String expected) {
		_valueToConvert = value;
		_expectedResult = expected;
	}

	@Parameters
	public static Collection<Object[]> parameters() {
		return Arrays.asList(new Object[][] {
				{-1, "Can only convert positive numbers less than 1000000000000"},
				{-546423, "Can only convert positive numbers less than 1000000000000"},
				{0, "zero"},
				{1, "one"},
				{16, "sixteen"},
				{100, "one hundred"},
				{118, "one hundred and eighteen"},
				{200, "two hundred"},
				{219, "two hundred and nineteen"},
				{800, "eight hundred"},
				{801, "eight hundred and one"},
				{924, "nine hundred and twenty four"},
				{1316, "one thousand three hundred and sixteen"},
				{131000, "one hundred and thirty one thousand"},
				{731001, "seven hundred and thirty one thousand and one"},
				{831271, "eight hundred and thirty one thousand two hundred and seventy one"},
				{1000000, "one million"},
				{4000000, "four million"},
				{5000200, "five million two hundred"},
				{5000205, "five million two hundred and five"},
				{5000263, "five million two hundred and sixty three"},
				{123456789, "one hundred and twenty three million four hundred and fifty six thousand seven hundred and eighty nine"},
				{5000000000L, "five billion"},
				{5000000001L, "five billion and one"},
				{5000000023L, "five billion and twenty three"},
				{5000000300L, "five billion three hundred"},
				{5000006000L, "five billion six thousand"},
				{5000346000L, "five billion three hundred and forty six thousand"},
				{123456789123L, "one hundred and twenty three billion four hundred and fifty six million seven hundred and eighty nine thousand one hundred and twenty three"},
				{1000000000000L, "Can only convert positive numbers less than 1000000000000"},
				{4000000000000L, "Can only convert positive numbers less than 1000000000000"}
		});
	}

	@Test public void convertToWords() throws Exception {
		if (_valueToConvert < 0 || _valueToConvert >= 1000000000000L) {
			try {
				_converter.convert(_valueToConvert);
				fail();
			} catch (NumberConversionException e) {
				assertThat(e.getMessage(), is(equalTo(_expectedResult)));
			}
		} else {
			String actual = _converter.convert(_valueToConvert);
			assertThat(actual, is(equalTo(_expectedResult)));
		}
	}
}