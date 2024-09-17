package misc.recursions;

public class PowerCalculator {

  private static int power = 1;

  public static void main(String[] args) {
    int x = 2, n = 5;
    printPower(x, n);
    System.out.println(power); // Output will be 32 (2^5)
  }

  private static void printPower(int x, int n) {
    if (n == 0) {
      return;
    }
    power = power * x;
    printPower(x, n - 1);
  }
}
