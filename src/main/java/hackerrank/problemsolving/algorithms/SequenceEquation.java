package hackerrank.problemsolving.algorithms;

import java.io.IOException;
import java.util.Scanner;

public class SequenceEquation {

    // Complete the permutationEquation function below.
    static int[] permutationEquation(int[] p) {
        int len = p.length;
        int inum = 0;
        int result[] = new int[len];
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < len; j++) {
                if (p[j] == i) {
                    inum = j + 1;
                    break;
                }
            }
            for (int j = 0; j < len; j++) {
                if (p[j] == inum) {
                    inum = j + 1;
                    break;
                }
            }
            result[i - 1] = inum;
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] p = new int[n];

        String[] pItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pItem = Integer.parseInt(pItems[i]);
            p[i] = pItem;
        }

        int[] result = permutationEquation(p);
        scanner.close();
    }
}