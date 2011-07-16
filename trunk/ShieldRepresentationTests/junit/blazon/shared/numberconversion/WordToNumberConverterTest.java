package blazon.shared.numberconversion;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.Arrays;
import java.util.Collection;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.BeforeClass;
import org.junit.Test;

@RunWith(Parameterized.class)
public class WordToNumberConverterTest {

	private static WordToNumberConverter _converter;

	@BeforeClass
	public static void setUp() {
		_converter = new WordToNumberConverter();
	}

	private String _valueToConvert;
	private int _expectedResult;
	private String _exceptionMessage;

	public WordToNumberConverterTest(String value, int expected, String message) {
		_valueToConvert = value;
		_expectedResult = expected;
		_exceptionMessage = message;
	}

	@Parameters
	public static Collection<Object[]> parameters() {
		return Arrays.asList(new Object[][] {
				{"minus one", 0, "WordToNumberConverter can only convert positive numbers smaller than 1000."},
				{"minus thirty two", 0, "WordToNumberConverter can only convert positive numbers smaller than 1000."},
				{null, 0, "WordToNumberConverter can not convert 'null' or empty string."},
				{"", 0, "WordToNumberConverter can not convert 'null' or empty string."},
				{"0", 0, null},
				{"1", 1, null},
				{"12", 12, null},
				{"100", 100, null},
				{"105", 105, null},
				{"269", 269, null},
				{"zero", 0, null},
				{"one", 1, null},
				{"ONE", 1, null},
				{"sixteen ", 16, null},
				{"siXteEn", 16, null},
				{"hundred", 100, null},
				{"one  hundred", 100, null},
				{"one HunDred", 100, null},
				{"one hundred and eighteen", 118, null},
				{"two hundred", 200, null},
				{"two hundred and nineteen", 219, null},
				{"eight hundred", 800, null},
				{"eight HUNDRED", 800, null},
				{"eight hundred and one", 801, null},
				{"nine hundred and twenty four", 924, null},
				{"one thousand three hundred and sixteen", 0, "WordToNumberConverter can only convert positive numbers smaller than 1000."},
				{"eight hundred and thirty one thousand two hundred and seventy one", 0, "WordToNumberConverter can only convert positive numbers smaller than 1000."},
				{"four million", 0, "WordToNumberConverter can only convert positive numbers smaller than 1000."},
				{"five billion", 0, "WordToNumberConverter can only convert positive numbers smaller than 1000."},
				{"blah", 0, "Unknown token: 'blah'."},
		});
	}

	@Test
	public void convertToNumber() throws Exception {
		if (_exceptionMessage == null) {
			int actual = _converter.convert(_valueToConvert);
			assertThat(actual, is(equalTo(_expectedResult)));
		} else {
			try {
				_converter.convert(_valueToConvert);
				fail();
			} catch (Exception e) {
				assertThat(e.getMessage(), is(equalTo(_exceptionMessage)));
			}
		}
	}
	
}