package misc.recursions;

public class PrintSumOfFirstNNaturalNumbers {

  private static int sum = 0;

  public static void main(String[] args) {
    printSum(5);
    System.out.println(sum);
    printSum1(5, 0);
  }

  private static void printSum(int n) {
    if (n == 0) {
      return;
    }
    sum += n;
    printSum(n - 1);
  }

  private static void printSum1(int n, int sum) {
    if (n == 0) {
      System.out.println(sum);
      return;
    }
    sum += n;
    printSum1(n - 1, sum);
  }
}
