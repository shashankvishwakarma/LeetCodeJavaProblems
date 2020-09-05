package hackerrank.practice.algorithms.implementation;

import java.io.IOException;
import java.util.Scanner;

public class BeautifulDaysAtTheMovies {
    // Complete the beautifulDays function below.
    static int beautifulDays(int i, int j, int k) {
        int numberOfBeautifulDays = 0;
        for (int day = i; day <= j; day++) {
            if (isBeautiful(day, k)) numberOfBeautifulDays++;
        }
        return numberOfBeautifulDays;
    }

    static boolean isBeautiful(int day, int divisor) {
        int reverseDay = getReverseNumber(day);
        if (Math.abs((day - reverseDay)%divisor) == 0) return true;
        return false;
    }

    static int getReverseNumber(int number) {
        StringBuilder reverseString = new StringBuilder();
        reverseString.append(number);
        reverseString = reverseString.reverse();
        int reverseNumber = Integer.parseInt(reverseString.toString());
        return reverseNumber;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] ijk = scanner.nextLine().split(" ");
        int i = Integer.parseInt(ijk[0]);
        int j = Integer.parseInt(ijk[1]);
        int k = Integer.parseInt(ijk[2]);
        int result = beautifulDays(i, j, k);
        scanner.close();
    }
}
