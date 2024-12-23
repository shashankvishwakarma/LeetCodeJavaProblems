package misc.recursions;

public class PrintFibonacciSequence {

  public static void main(String[] args) {
    int n = 5; // Number of terms in a Fibonacci sequence
    printFibonacci(0, 1, n);// print fibonacci till nth terms.
  }

  private static void printFibonacci(int a, int b, int n) {
    if (n == 0) {
      return;
    }
    System.out.println(a);
    printFibonacci(b, a + b, n - 1);
  }
}
