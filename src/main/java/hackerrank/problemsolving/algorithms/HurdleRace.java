package hackerrank.problemsolving.algorithms;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class HurdleRace {
    // Complete the hurdleRace function below.
    static int hurdleRace(int k, int[] height) {
        int max = Arrays.stream(height).max().getAsInt();
        if(k-max < 0)
            return Math.abs(k-max);
        else
            return 0;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int[] height = new int[n];

        String[] heightItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int heightItem = Integer.parseInt(heightItems[i]);
            height[i] = heightItem;
        }

        int result = hurdleRace(k, height);
        scanner.close();
    }
}
