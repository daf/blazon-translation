package blazon.shared.numberconversion;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Converts word representation of a number into the corresponding digits.
 * 
 * @author Luke Torjussen
 * 
 */
public class WordToNumberConverter {

    private static final Map<String, Integer> wordToNumberMap;
    static {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        map.put("ten", 10);
        map.put("eleven", 11);
        map.put("twelve", 12);
        map.put("thirteen", 13);
        map.put("fourteen", 14);
        map.put("fifteen", 15);
        map.put("sixteen", 16);
        map.put("seventeen", 17);
        map.put("eighteen", 18);
        map.put("nineteen", 19);
        map.put("twenty", 20);
        map.put("thirty", 30);
        map.put("fourty", 40);
        map.put("fifty", 50);
        map.put("sixty", 60);
        map.put("seventy", 70);
        map.put("eighty", 80);
        map.put("ninety", 90);
        map.put("hundred", 100);
        wordToNumberMap = Collections.unmodifiableMap(map);
    }

    private static final String[] UNACCEPTED = { "minus", "thousand",
            "million", "billion" };

    /**
     * Convert the word representation of as number into the corresponding
     * digits.
     * 
     * @param text
     *            The string to convert into a number.
     * @return The integer represented by the given input string.
     * @throws IllegalArgumentException
     *             If the input was null or empty.
     * @throws NumberConversionException
     *             If the input contains an unknown token.
     */
    public int convert(String text) throws IllegalArgumentException,
            NumberConversionException {
        if (text == null || text.trim().isEmpty()) { throw new IllegalArgumentException(
                "WordToNumberConverter can not convert 'null' or empty string."); }

        // remove "-" and "and" and put in spaces
        String stripped = text.trim().toLowerCase().replaceAll("[\\-,_]", " ")
                .replaceAll(" and ", " ");
        if (stringContainsMinusOrWordLargerThanHundred(text)) { throw new IllegalArgumentException(
                "WordToNumberConverter can only convert positive numbers smaller than 1000."); }
        String[] words = stripped.split("\\s+");

        if (words.length == 1 && isMadeUpOfDigits(words[0])) { return Integer
                .parseInt(words[0]); }

        int value = 0;
        for (String word : words) {
            if (!wordToNumberMap.containsKey(word)) { throw new NumberConversionException(
                    "Unknown token: '" + word + "'."); }
            int subval = wordToNumberMap.get(word);
            if (subval == 100) {
                if (value == 0) {
                    value = 100;
                } else {
                    value *= 100;
                }
            } else {
                value += subval;
            }
        }
        return value;
    }

    /**
     * Checks whether a given string contains an unaccepted word.
     * 
     * @param text
     *            The string to check.
     * @return true if the input contains an unaccepted word; false otherwise.
     */
    private boolean stringContainsMinusOrWordLargerThanHundred(String text) {
        for (String s : UNACCEPTED) {
            if (text.contains(s)) { return true; }
        }
        return false;
    }

    /**
     * Checks whether a string is entirely made up of digits.
     * 
     * @param string
     *            The string to check that it only contains digits.
     * @return returns true if string contains only digits; false otherwise.
     */
    private boolean isMadeUpOfDigits(String string) {
        for (char c : string.toCharArray()) {
            if (!Character.isDigit(c)) { return false; }
        }
        return true;
    }

}