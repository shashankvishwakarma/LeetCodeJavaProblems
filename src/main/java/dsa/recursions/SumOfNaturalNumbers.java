package dsa.recursions;

//Print the sum of first n natural numbers.
public class SumOfNaturalNumbers {
    public static void main(String[] args) {
        int num = 5, sum = 0;
        sum = printSumOfNaturalNumber(num, sum);
        System.out.println(sum);
    }

    public static int printSumOfNaturalNumber(int num, int sum) {
        if (num == 0) {
            return sum;
        }
        sum = sum + num;
        return printSumOfNaturalNumber(num - 1, sum);
    }
}
