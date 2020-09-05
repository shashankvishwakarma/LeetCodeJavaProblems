package hackerrank.practice.algorithms.implementation;

import java.io.IOException;
import java.util.Scanner;

public class ViralAdvertising {
    static int viralAdvertising(int n) {
        int peopleReached = 2, peopleSharing = 2;
        for (int i = 1; i < n; i++) {
            peopleReached += (peopleSharing * 3) / 2;
            peopleSharing = (peopleSharing * 3) / 2;
        }
        return peopleReached;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = viralAdvertising(n);
        scanner.close();
    }
}

