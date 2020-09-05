package hackerrank.practice.algorithms.implementation;

import java.io.IOException;
import java.util.Scanner;

public class FindDigits {
    // Complete the findDigits function below.
    static int findDigits(int n) {
        String numberString = String.valueOf(n);
        int numberInteger = Integer.parseInt(numberString);
        int evenlyDivisibleDigits = 0;

        for (int j = 0; j < numberString.length(); j++) {
            int digit = Character.getNumericValue(numberString.charAt(j));
            if (digit != 0 && numberInteger % digit == 0) {
                evenlyDivisibleDigits++;
            }
        }
        return evenlyDivisibleDigits;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            int result = findDigits(n);
        }
        scanner.close();
    }
}
