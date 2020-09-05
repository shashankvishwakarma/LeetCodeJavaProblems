package hackerrank.practice.algorithms.implementation;

import java.io.IOException;
import java.util.Scanner;

public class JumpingOnClouds {
    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c, int k) {
        int energy = 100;
        int cloud = 0;
        do {
            energy--; //You performed a jump
            cloud = (cloud + k) % c.length;
            if(c[cloud] == 1) {
                energy -= 2;//You landed on a thundercloud
            }
        }
        while(cloud != 0);
        return energy;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c, k);

        scanner.close();
    }
}

