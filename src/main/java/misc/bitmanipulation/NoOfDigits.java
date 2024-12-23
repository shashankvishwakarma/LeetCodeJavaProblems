package misc.bitmanipulation;

/**
 * Find ith bit of the number
 */
public class NoOfDigits {
    public static void main(String[] args) {
        int num = 10;
        int base = 2;
        System.out.println("No Of Digits in Decimal representation:" + noOfDigits(num, 10));
        System.out.println("No Of Digits in binary representation:" + noOfDigits(num, base));
    }

    private static int noOfDigits(int num, int base) {
        return (int) (Math.log(num) / Math.log(base)) + 1;
    }
}
