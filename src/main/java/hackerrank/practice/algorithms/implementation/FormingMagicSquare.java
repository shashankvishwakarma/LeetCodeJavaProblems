package hackerrank.practice.algorithms.implementation;

import java.io.IOException;
import java.util.Scanner;

public class FormingMagicSquare {
    // Complete the formingMagicSquare function below.
    static int formingMagicSquare(int[][] given) {
        int[][][] possiblePermutations = {
                {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},// 1
                {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},// 2
                {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}},// 3
                {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}},// 4
                {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},// 5
                {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}},// 6
                {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}},// 7
                {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}},// 8
        };

        int minCost = Integer.MAX_VALUE;
        for (int permutation = 0; permutation < 8; permutation++) {
            int permutationCost = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++)
                    permutationCost += Math.abs(given[i][j] - possiblePermutations[permutation][i][j]);
            }
            minCost = Math.min(minCost, permutationCost);
        }
        return minCost;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int[][] s = new int[3][3];

        for (int i = 0; i < 3; i++) {
            String[] sRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int sItem = Integer.parseInt(sRowItems[j]);
                s[i][j] = sItem;
            }
        }

        int result = formingMagicSquare(s);
        scanner.close();
    }
}
