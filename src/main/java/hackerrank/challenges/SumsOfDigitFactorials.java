package hackerrank.challenges;

import java.util.Scanner;
import java.util.stream.IntStream;

public class SumsOfDigitFactorials {

    public static int factorial(int number) {
        if (number == 0 || number == 1) return 1;
        return IntStream.rangeClosed(2, number).reduce(1, (x, y) -> x * y);
    }

    public static int factorialOfDigit(int number) {
        int sum = 0;
        int digit = 0;
        while (number != 0) {
            digit = number % 10;
            number = number / 10;
            sum += factorial(digit);
        }
        return sum;
    }

    public static int sumOfDigit(int number) {
        int sum = 0;
        int digit = factorialOfDigit(number);
        while (digit != 0) {
            sum += digit % 10;
            digit /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*System.out.println("enter a number:");*/
        int a = scanner.nextInt();
        /*System.out.println();*/
        System.out.println(sumOfDigit(a));
    }
}
