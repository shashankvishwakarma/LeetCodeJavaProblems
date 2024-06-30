package leetcode.easy;

import java.util.Map;

/**
 * https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [12,345,2,6,7896]
 * Output: 2
 * Explanation:
 * 12 contains 2 digits (even number of digits).
 * 345 contains 3 digits (odd number of digits).
 * 2 contains 1 digit (odd number of digits).
 * 6 contains 1 digit (odd number of digits).
 * 7896 contains 4 digits (even number of digits).
 * Therefore only 12 and 7896 contain an even number of digits.
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [555,901,482,1771]
 * Output: 1
 * Explanation:
 * Only 1771 contains an even number of digits.
 */
public class FindNumbersWithEvenNumberOfDigits {
    public static void main(String[] args) {
        int[] nums = {12, 345, 2, 6, 7896};
        int ans = findNumbersWithBruteForce(nums);
        System.out.println("Solution using brute force:"+ans);
        ans = findNumbersOptimization(nums);
        System.out.println("Solution with optimization:"+ans);
    }

    private static int findNumbersOptimization(int[] nums) {
        int count = 0;

        for (int num : nums) {
            int noOfDigit = (int) (Math.log10(num) + 1);
            if (noOfDigit % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    private static int findNumbersWithBruteForce(int[] nums) {
        int count = 0;

        for (int num : nums) {
            int noOfDigit = getNoOfDigit(num);
            if (noOfDigit % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    private static int getNoOfDigit(int num) {
        int count = 0;
        if (num < 0) {
            num = num * -1;
        }
        while (num > 0) {
            count++;
            num = num / 10;
        }
        return count;
    }
}
