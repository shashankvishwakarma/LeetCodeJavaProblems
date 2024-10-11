package misc.recursions;

public class PrintStringReverse {

  public static void main(String[] args) {
    String initialStr = "abcd", reverseStr = "";
    //reverseStr = printStringReverseApproach1(initialStr, initialStr.length()-1, reverseStr);
    //System.out.println(reverseStr);
    System.out.println(printStringReverseApproach2(initialStr));
  }

  private static String printStringReverseApproach1(String initialStr, int index,
      String reverseStr) {
    if (initialStr.isEmpty()) {
      return reverseStr;
    }
    reverseStr = reverseStr + initialStr.charAt(index);
    return printStringReverseApproach1(initialStr.substring(0, index), index - 1, reverseStr);
  }

  private static String printStringReverseApproach2(String initialStr) {
    if (initialStr.isEmpty()) {
      return initialStr;
    }
    char currChar = initialStr.charAt(0);
    String nextString = printStringReverseApproach2(initialStr.substring(1));
    return nextString + currChar;
  }
}
