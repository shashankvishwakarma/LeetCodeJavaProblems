package hackerrank.problemsolving.practice;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class AVeryBigSum {

    // Complete the aVeryBigSum function below.
    static long aVeryBigSum(long[] ar) {
        return Arrays.stream(ar).sum();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int arCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long[] ar = new long[arCount];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < arCount; i++) {
            long arItem = Long.parseLong(arItems[i]);
            ar[i] = arItem;
        }

        long result = aVeryBigSum(ar);
        System.out.println(result);
        scanner.close();
    }
}

