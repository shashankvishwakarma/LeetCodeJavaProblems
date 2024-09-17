package misc.recursions;

public class PrintSumOfFirstNNaturalNumbers {

  private static int sum = 0;

  public static void main(String[] args) {
    printSum(5);
    System.out.println(sum);
  }

  private static void printSum(int n) {
    if (n == 0) {
      return;
    }
    sum += n;
    printSum(n - 1);
  }
}
