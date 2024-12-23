package misc.recursions;

public class PrintFactorialOfNumber {

  private static int factorial = 1;

  public static void main(String[] args) {
    printFactorial(5);// To calculate factorial of 5
    System.out.println(factorial);// Output will be 120 for 5!
  }

  private static void printFactorial(int n) {
    if (n == 0 || n == 1) {
      return;
    }
    factorial *= n;
    printFactorial(n - 1);
  }
}
