package hackerrank.problemsolving.algorithms;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class SockMerchant {
    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        Arrays.sort(ar);
        int total = 0;
        for (int i = 0; i < n - 1; i++) {
            if (i < n && ar[i] == ar[i + 1]) {
                total++;
                i = i + 1;
            }
        }
        return total;
    }



    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);
        scanner.close();
    }
}
