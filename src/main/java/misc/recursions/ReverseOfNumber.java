package misc;

public class ReverseOfNumber {
    static int sum = 0;

    public static void main(String[] args) {
        reverse(1342);
        System.out.println(sum);
    }

    static void reverse(int n) {
        if (n == 0) {
            return;
        }
        int rem = n % 10;
        sum = sum * 10 + rem;
        reverse(n / 10);
    }
}