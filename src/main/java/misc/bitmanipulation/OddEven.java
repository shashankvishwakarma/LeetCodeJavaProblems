package misc.bitmanipulation;

public class OddEven {
    public static void main(String[] args) {
        int num = 66;
        System.out.println(isOdd(num));
    }

    private static boolean isOdd(int n) {
        return (n & 1) == 1;
    }
}
