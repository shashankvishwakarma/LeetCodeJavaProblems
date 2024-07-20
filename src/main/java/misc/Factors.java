package misc;

public class Factors {
    public static void main(String[] args) {
        System.out.println("\n------------- Brute force -------------");
        factorsBruteForce(20);
        System.out.println("\n------------- Optimized solution -------------");
        factorsOptimized(20);
    }

    static void factorsBruteForce(int n) {
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
            }
        }
    }

    static void factorsOptimized(int n) {
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (n / i == i) {
                    System.out.print(i + " ");
                } else {
                    System.out.print(i + " " + n / i + " ");
                }
            }
        }
    }

}