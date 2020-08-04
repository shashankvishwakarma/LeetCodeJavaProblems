package hackerrank.problemsolving.algorithms;

import java.io.IOException;
import java.util.Scanner;

public class PageCount {
    /*
     * Complete the pageCount function below.
     */
    static int pageCount(int n, int p) {
        int beg = (p / 2);
        int end = 0;
        if (n % 2 == 1)
            end = (n - p) / 2;
        else
            end = (int) Math.ceil((n - p) / 2.0);

        return Math.min(beg, end);

    }


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int result = pageCount(n, p);
        scanner.close();
    }
}