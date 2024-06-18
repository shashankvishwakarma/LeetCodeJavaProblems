package leetcode.medium;

/**
 * https://leetcode.com/problems/sum-of-square-numbers/description/?envType=daily-question&envId=2024-06-17
 * <p>
 * Example 1:
 * <p>
 * Input: c = 5 Output: true Explanation: 1 * 1 + 2 * 2 = 5 Example 2:
 * <p>
 * Input: c = 3 Output: false
 */
public class SumOfSquareNumbers {

  public boolean judgeSquareSum(int c) {

    for (int a = 0; a * a <= c; a++) {
      int b = c - a * a;

      if (isPerfectSquare(b)) {
        return true;
      }
    }
    return false;
  }

  private static boolean isPerfectSquare(int b) {
    long sqrt = (long) Math.sqrt(b);
    return sqrt * sqrt == b;
  }

  public boolean judgeSquareSumOptimized(int c) {
    long left = 0;
    long right = (long) Math.sqrt(c);

    while (left <= right) {
      long sum = left * left + right * right;
      if (sum == c) {
        return true;
      } else if (sum < c) {
        left++;
      } else {
        right--;
      }
    }

    return false;
  }

  public static void main(String[] args) {
    SumOfSquareNumbers solution = new SumOfSquareNumbers();

    // Test cases
    int num1 = 5;
    int num2 = 13;
    int num3 = 3;

    System.out.println(
        num1 + " can be expressed as the sum of two squares: " + solution.judgeSquareSumOptimized(
            num1));
    System.out.println(
        num2 + " can be expressed as the sum of two squares: " + solution.judgeSquareSumOptimized(
            num2));
    System.out.println(
        num3 + " can be expressed as the sum of two squares: " + solution.judgeSquareSumOptimized(
            num3));
  }
}
