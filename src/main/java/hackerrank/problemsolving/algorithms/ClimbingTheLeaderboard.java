package hackerrank.problemsolving.algorithms;

import java.io.IOException;
import java.util.Scanner;

public class ClimbingTheLeaderboard {
    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int si = 0; // score index
        int rank = 1;

        for (int x = alice.length - 1; x >= 0; x--) {
            if (si == scores.length) {
                rank++;
                si++;
            }
            while (si < scores.length && scores[si] > alice[x]) {
                if (!(si < scores.length - 1 && scores[si] == scores[si + 1])) {
                    rank++;
                }
                si++;
            }
            alice[x] = rank;
        }
        return alice;
    }


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);
        scanner.close();
    }
}
