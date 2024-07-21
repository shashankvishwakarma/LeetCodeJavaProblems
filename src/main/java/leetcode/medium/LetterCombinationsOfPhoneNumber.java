package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 */
public class LetterCombinationsOfPhoneNumber {

    public static void main(String[] args) {
        String digits1 = "23";
        List<String> result1 = letterCombinations(digits1);
        System.out.println("Letter combinations for " + digits1 + ": " + result1);

        String digits2 = "";
        List<String> result2 = letterCombinations(digits2);
        System.out.println("Letter combinations for " + digits2 + ": " + result2);

        String digits3 = "2";
        List<String> result3 = letterCombinations(digits3);
        System.out.println("Letter combinations for " + digits3 + ": " + result3);
    }

    public static List<String> letterCombinationsOptimized(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return result;
        }
        StringBuilder sb = new StringBuilder();
        backtrack(digits, 0, sb, result);
        return result;
    }

    private static void backtrack(String digits, int index, StringBuilder sb, List<String> result) {
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }

        char digitChar = digits.charAt(index);
        int digit = digitChar - '0';

        // Calculate the range of letters corresponding to the current digit
        int start = (digit - 2) * 3 + (digit >= 8 ? 1 : 0); // Adjust for '7' and '9' which have 4 letters
        int end = start + 3 + (digit == 7 || digit == 9 ? 1 : 0); // Adjust for '7' and '9' which have 4 letters

        for (int i = start; i < end; i++) {
            char letter = (char) ('a' + i);
            sb.append(letter);
            backtrack(digits, index + 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    //--------------------- solution 1 -------------------
    public static List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        return padRet("", digits);
    }

    static List<String> padRet(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        int digit = up.charAt(0) - '0'; // this will convert '2' into 2

        ArrayList<String> list = new ArrayList<>();
        int start = (digit - 2) * 3 + (digit >= 8 ? 1 : 0); // Adjust for '7' and '9' which have 4 letters
        int end = start + 3 + (digit == 7 || digit == 9 ? 1 : 0); // Adjust for '7' and '9' which have 4 letters

        for (int i = start; i < end; i++) {
            char ch = (char) ('a' + i);
            list.addAll(padRet(p + ch, up.substring(1)));
        }
        return list;
    }
}
