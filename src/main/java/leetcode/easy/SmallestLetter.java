package leetcode.easy;

/**
 * https://leetcode.com/problems/find-smallest-letter-greater-than-target/
 * <p>
 * Example 1:
 * <p>
 * Input: letters = ["c","f","j"], target = "a"
 * Output: "c"
 * Explanation: The smallest character that is lexicographically greater than 'a' in letters is 'c'.
 * Example 2:
 * <p>
 * Input: letters = ["c","f","j"], target = "c"
 * Output: "f"
 * Explanation: The smallest character that is lexicographically greater than 'c' in letters is 'f'.
 * Example 3:
 * <p>
 * Input: letters = ["x","x","y","y"], target = "z"
 * Output: "x"
 * Explanation: There are no characters in letters that is lexicographically greater than 'z' so we return letters[0].
 */
public class SmallestLetter {
    public static void main(String[] args) {
        char[] letters = {'c', 'f', 'j'};
        //char target = 'a';
        char target = 'c';

        /*char[] letters = {'x','x','y','y'};
        char target = 'z';*/

        char ans = nextGreatestLetter(letters, target);
        System.out.println(ans);

    }

    public static char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target < letters[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return letters[start % letters.length];
    }
}
