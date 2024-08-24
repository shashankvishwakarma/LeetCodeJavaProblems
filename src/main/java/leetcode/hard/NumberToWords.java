package leetcode.hard;

/**
 * https://leetcode.com/problems/integer-to-english-words/
 */
public class NumberToWords {
    private final String[] LESS_THAN_TWENTY = {"", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine ",
            "Ten ", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ",
            "Seventeen ", "Eighteen ", "Nineteen "};
    private final String[] TWENTY_TO_NINETY = {"", "", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ",
            "Eighty ", "Ninety "};
    private final String[] THOUSANDS = {"", "Thousand ", "Million ", "Billion "};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";

        StringBuilder result = new StringBuilder();

        int i = 0;
        while (num > 0) {
            if (num % 1000 != 0) {
                result.insert(0, getSymbol(num % 1000) + THOUSANDS[i]);
            }
            num /= 1000;
            i++;
        }

        return result.toString().trim();
    }

    private String getSymbol(int num) {
        StringBuilder str = new StringBuilder();

        if (num >= 100) {
            str.append(LESS_THAN_TWENTY[num / 100]).append("Hundred ");
            num %= 100;
        }

        if (num >= 20) {
            str.append(TWENTY_TO_NINETY[num / 10]).append(LESS_THAN_TWENTY[num % 10]);
        } else {
            str.append(LESS_THAN_TWENTY[num]);
        }

        return str.toString();
    }

    public static void main(String[] args) {
        NumberToWords converter = new NumberToWords();

        System.out.println(converter.numberToWords(123));         // Output: "One Hundred Twenty Three"
        System.out.println(converter.numberToWords(12345));       // Output: "Twelve Thousand Three Hundred Forty Five"
        System.out.println(converter.numberToWords(1234567));     // Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
    }
}
