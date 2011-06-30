package blazon.shared.numberconversion;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Converts an integer representation of a number into the corresponding English
 * words for the ordinal of that number.
 * 
 * @author Luke Torjussen
 * 
 */
public class NumberToOrdinalConverter {
	private static final Map<String, String> ORDINAL_MAP;
    static {
        Map<String, String> map = new HashMap<String, String>();
        map.put("one", "first");
        map.put("two", "second");
        map.put("three", "third");
        map.put("four", "forth");
        map.put("five", "fifth");
        map.put("six", "sixth");
        map.put("seven", "seventh");
        map.put("eight", "eighth");
        map.put("nine", "ninth");
        map.put("ten", "tenth");
        map.put("eleven", "eleventh");
        map.put("twelve", "twelfth");
        map.put("thirteen", "thirteenth");
        map.put("fourteen", "fourteenth");
        map.put("fifteen", "fifteenth");
        map.put("sixteen", "sixteenth");
        map.put("seventeen", "seventeenth");
        map.put("eighteen", "eighteenth");
        map.put("nineteen", "nineteenth");
        map.put("twenty", "twentieth");
        map.put("thirty", "thirtieth");
        map.put("fourty", "fortieth");
        map.put("fifty", "fiftieth");
        map.put("sixty", "sixtieth");
        map.put("seventy", "seventieth");
        map.put("eighty", "eightieth");
        map.put("ninety", "ninetieth");
        map.put("hundred", "hundredth");
        map.put("thousand", "thousandth");
        map.put("million", "millionth");
        map.put("billion", "billionth");
        ORDINAL_MAP = Collections.unmodifiableMap(map);
    }

    private NumberToWordsConverter numberToWordsConverter = new NumberToWordsConverter();

    /**
     * Converts a number that is less than 999999999 into the corresponding
     * English words for the ordinal of that number.
     * 
     * @param number
     *            The number to be converted (must be less than 999999999).
     * @return A sentence describing the ordinal of the input number.
     * @throws NumberConversionException
     *             Thrown if method could not convert number.
     */
    public String convert(long number)
            throws NumberConversionException {
        if (number >= 999999999999L || number <= 0) { throw new NumberConversionException(
                "Can only convert positive numbers less than 1000000000000"); }
        String words = numberToWordsConverter.convert(number);
        words = replaceLastWordWithOrdinal(words);
        return words;
    }

    /**
     * Replaces the last word in the string (characters found after last " ")
     * with its ordinal equivalent.
     * 
     * @param words
     *            The string to be converted to the ordinal representation.
     * @return The ordinal representation of the input string.
     */
    private static String replaceLastWordWithOrdinal(String words) {
        int lastIndex = words.lastIndexOf(" ");
        StringBuilder sb = new StringBuilder(words.length() + 3);
        if (lastIndex > -1) {
            sb.append(words.substring(0, lastIndex + 1));
        }
        String lastWord = words.substring(lastIndex + 1);
        String ordinalLastWord = ORDINAL_MAP.get(lastWord);
        sb.append(ordinalLastWord);
        return sb.toString();
    }
}
