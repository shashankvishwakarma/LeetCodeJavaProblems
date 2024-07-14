package leetcode.easy;

/**
 * https://leetcode.com/problems/fibonacci-number/
 */
public class FibonacciNumber {
    public static void main(String[] args) {
        int ans = fib(4);
        System.out.println(ans);
    }

    public static int fib(int n) {
        if (n < 2) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }
}
