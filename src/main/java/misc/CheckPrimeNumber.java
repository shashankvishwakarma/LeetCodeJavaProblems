package misc;

public class CheckPrimeNumber {

    public static void main(String[] args) {
        int n = 40;
        //checkPrimeNumber(n);
        checkPrimeNumberOptimized(n);
    }

    private static void checkPrimeNumberOptimized(int n) {
        boolean[] primes = new boolean[n + 1];
        sieve(n, primes);
    }

    static void sieve(int n, boolean[] primes) {
        for (int i = 2; i * i <= n; i++) {
            if (!primes[i]) {
                for (int j = i * 2; j <= n; j += i) {
                    primes[j] = true;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (!primes[i]) {
                System.out.print(i + " ");
            }
        }
    }

    private static void checkPrimeNumber(int n) {
        for (int i = 2; i <= n; i++) {
            System.out.println(i + " " + isPrime(i));
        }
    }

    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        int c = 2;
        while (c * c <= n) {
            if (n % c == 0) {
                return false;
            }
            c++;
        }
        return true;
    }
}