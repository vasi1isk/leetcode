package tasks.roman;

import java.util.Map;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * <p>
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 * <p>
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 * <p>
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "III"
 * Output: 3
 * Explanation: III = 3.
 * Example 2:
 * <p>
 * Input: s = "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * Example 3:
 * <p>
 * Input: s = "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 15
 * s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
 * It is guaranteed that s is a valid roman numeral in the range [1, 3999].
 */
public class RomanNumbers {
    private final static Map<Character, Integer> conversionRules = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
    );

    public static void main(String[] args) {
        RomanNumbers romanNumber = new RomanNumbers();
        System.out.println(romanNumber.romanToInt("CMXIX"));
        System.out.println(romanNumber.romanToInt("III"));
        System.out.println(romanNumber.romanToInt("LVIII"));
        System.out.println(romanNumber.romanToInt("MCMXCIV"));
    }

    public int romanToInt(String s) {
        int result = 0;
        int i = 0;
        while (i <= s.length() - 1) {
            if (!isPenultimateSymbol(s, i)) {
                if (conversionRules.containsKey(s.charAt(i)) && conversionRules.containsKey(s.charAt(i + 1))) {
                    if (conversionRules.get(s.charAt(i)) < conversionRules.get(s.charAt(i + 1))) {
                        result = result + (conversionRules.get(s.charAt(i + 1)) - conversionRules.get(s.charAt(i)));
                        i++;
                    } else {
                        result = result + conversionRules.get(s.charAt(i));
                    }
                    i++;
                }
            } else {
                result = result + conversionRules.get(s.charAt(i));
                i++;
            }
        }
        return result;
    }

    private boolean isPenultimateSymbol(final String s, final int index) {
        return s.length() - 1 == index;
    }
}
