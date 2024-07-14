package leetcode.easy;

/**
 * https://leetcode.com/problems/fibonacci-number/
 */
public class FibonacciNumber {
    public static void main(String[] args) {
        long ans = fib(50);
        System.out.println(ans);
    }

    public static long fib(int n) {
        if (n < 2) {
            return n;
        }

        long a = 0;
        long b = 1;
        long c = 0;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
