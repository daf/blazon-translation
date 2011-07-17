package blazon.shared.numberconversion;

/**
 * Converts an integer representation of a number into the corresponding English
 * words. Amended code from http://www.rgagnon.com/javadetails/java-0426.html
 * 
 * @author Luke Torjussen
 * 
 */
public class NumberToWordsConverter {

	private static final String[] TENS_NAMES = { "", "ten", "twenty", "thirty",
			"forty", "fifty", "sixty", "seventy", "eighty", "ninety" };

	private static final String[] NUM_NAMES = { "", "one", "two", "three",
			"four", "five", "six", "seven", "eight", "nine", "ten", "eleven",
			"twelve", "thirteen", "fourteen", "fifteen", "sixteen",
			"seventeen", "eighteen", "nineteen" };

	/**
	 * Converts a number that is less than 1000 into the corresponding English
	 * words.
	 * 
	 * @param number
	 *            The number to be converted (must be less than 1000).
	 * @return A sentence describing the input number.
	 * @throws NumberConversionException
	 *             Thrown if method is called with an input of >= 1000.
	 */
	private StringBuilder convertLessThanOneThousand(int number)
			throws NumberConversionException {

		StringBuilder hundredsTensAndUnits = new StringBuilder();
		StringBuilder tensAndUnits = new StringBuilder();

		if (number % 100 < 20) {
			// last 2 digits represent 20 or less.
			String unit = NUM_NAMES[number % 100];
			// don't want to add empty string.
			if (!unit.isEmpty()) {
				tensAndUnits.append(unit);
			}
			number /= 100;
		} else {
			tensAndUnits.append(NUM_NAMES[number % 10]);
			number /= 10;
			tensAndUnits.insert(0, " ");
			tensAndUnits.insert(0, TENS_NAMES[number % 10]);
			number /= 10;
		}

		// no hundreds.
		if (number == 0) {
			return tensAndUnits;
		}

		// find how many hundreds.
		hundredsTensAndUnits.append(NUM_NAMES[number]);
		hundredsTensAndUnits.append(" hundred");

		// if no tens and units, can just return hundreds.
		if (tensAndUnits.length() == 0) {
			return hundredsTensAndUnits;
		}
		hundredsTensAndUnits.append(" and ");
		hundredsTensAndUnits.append(tensAndUnits);

		return hundredsTensAndUnits;
	}

	/**
	 * Converts a number up to 999999999999 into the corresponding English
	 * words.
	 * 
	 * @param number
	 *            The number to be converted (must be less than 999999999999).
	 * @return A sentence describing the input number.
	 * @throws NumberConversionException
	 *             Thrown if method was unable to convert the number.
	 */
	public String convert(long number) throws NumberConversionException {
		if (number >= 999999999999L || number < 0) {
			throw new NumberConversionException(
					"Can only convert positive numbers less than 1000000000000");
		}
		if (number == 0) {
			return "zero";
		}

		String snumber = padNumberToTwelveDigits(number);

		// XXXnnnnnnnnn
		int billions = Integer.parseInt(snumber.substring(0, 3));
		// nnnXXXnnnnnn
		int millions = Integer.parseInt(snumber.substring(3, 6));
		// nnnnnnXXXnnn
		int hundredThousands = Integer.parseInt(snumber.substring(6, 9));
		// nnnnnnnnnXXX
		int thousands = Integer.parseInt(snumber.substring(9, 12));

		StringBuilder result = new StringBuilder();
		// number of billions
		switch (billions) {
		case 0:
			break;
		default:
			result.append(convertLessThanOneThousand(billions));
			result.append(" billion");
		}

		// number of millions
		switch (millions) {
		case 0:
			break;
		default:
			if (result.length() != 0) {
				result.append(" ");
			}
			result.append(convertLessThanOneThousand(millions));
			result.append(" million");
		}

		// number of hundred thousand
		switch (hundredThousands) {
		case 0:
			break;
		default:
			if (result.length() != 0) {
				result.append(" ");
			}
			result.append(convertLessThanOneThousand(hundredThousands));
			result.append(" thousand");
		}

		// words for 1000 or less.
		StringBuilder tradThousand = convertLessThanOneThousand(thousands);

		if (tradThousand.length() == 0) {
			return result.toString();
		}

		// we may need to add the word "and".
		if (result.length() > 0) {
			if (thousands < 100) {
				result.append(" and");
			}
			result.append(" ");
		}
		result.append(tradThousand);
		return result.toString();
	}

	/**
	 * Takes a long and returns a 12 character representation which has been
	 * padded with 0's.
	 * 
	 * @param number
	 *            The number to be padded.
	 * @return The padded String representation of the input.
	 */
	private String padNumberToTwelveDigits(long number) {
		String snumber = Long.toString(number);
		int counter = snumber.length();
		StringBuilder sb = new StringBuilder();
		while (counter++ < 12) {
			sb.append("0");
		}
		sb.append(snumber);
		return sb.toString();
	}
}
