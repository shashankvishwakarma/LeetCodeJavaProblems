package hackerrank.practice.algorithms.implementation;

import java.io.IOException;
import java.util.Scanner;

public class CountingValleys {
    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        int level = 0; //Start at sea level
        int valleys = 0;
        boolean belowSea = false;

        for (int i = 0; i < n; i++) {
            char slope = s.charAt(i);
            if (slope == 'U')//Uphill
                level++;
            else//Downhill
                level--;

            //Handle transitions
            if (!belowSea && level < 0) {
                valleys++;
                belowSea = true;
            }

            if (level >= 0)//We are back above sea level
                belowSea = false;
        }
        return valleys;
    }


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);
        scanner.close();
    }
}
