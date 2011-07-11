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
public class NumberToOrdinalConverterTest {

	private static NumberToOrdinalConverter _converter;
	
	@BeforeClass
	public static void setUp() {
		_converter = new NumberToOrdinalConverter();
	}
	
	private long _valueToConvert;
	private String _expectedResult;
	
	public NumberToOrdinalConverterTest(long value, String expected) {
		_valueToConvert = value;
		_expectedResult = expected;
	}
	
	@Parameters
	public static Collection<Object[]> parameters() {
		return Arrays.asList(new Object[][] {
				{-1, "Can only convert positive numbers less than 1000000000000"},
				{-546423, "Can only convert positive numbers less than 1000000000000"},
				{0, "Can only convert positive numbers less than 1000000000000"},
				{1, "first"},
				{16, "sixteenth"},
				{100, "one hundredth"},
				{118, "one hundred and eighteenth"},
				{200, "two hundredth"},
				{219, "two hundred and nineteenth"},
				{800, "eight hundredth"},
				{801, "eight hundred and first"},
				{924, "nine hundred and twenty forth"},
				{1316, "one thousand three hundred and sixteenth"},
				{131000, "one hundred and thirty one thousandth"},
				{731001, "seven hundred and thirty one thousand and first"},
				{831271, "eight hundred and thirty one thousand two hundred and seventy first"},
				{1000000, "one millionth"},
				{4000000, "four millionth"},
				{5000200, "five million two hundredth"},
				{5000205, "five million two hundred and fifth"},
				{5000263, "five million two hundred and sixty third"},
				{123456789, "one hundred and twenty three million four hundred and fifty six thousand seven hundred and eighty ninth"},
				{5000000000L, "five billionth"},
				{5000000001L, "five billion and first"},
				{5000000023L, "five billion and twenty third"},
				{5000000300L, "five billion three hundredth"},
				{5000006000L, "five billion six thousandth"},
				{5000346000L, "five billion three hundred and forty six thousandth"},
				{123456789123L, "one hundred and twenty three billion four hundred and fifty six million seven hundred and eighty nine thousand one hundred and twenty third"},
				{1000000000000L, "Can only convert positive numbers less than 1000000000000"},
				{4000000000000L, "Can only convert positive numbers less than 1000000000000"}
		});
	}

	@Test public void convertToOrdinal() throws Exception {
		if (_valueToConvert <= 0 || _valueToConvert > 999999999999L) {
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