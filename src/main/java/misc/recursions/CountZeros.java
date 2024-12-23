package misc.recursions;

public class CountZeros {

    static int counter = 0;

    public static void main(String[] args) {
        countZeros(30210004);
        System.out.println(counter);
    }

    private static int countZeros(int n) {
        if (n == 0) {
            return counter;
        }

        int rem = n % 10;
        if (rem == 0) {
            counter++;
        }
        return countZeros(n / 10);
    }
}