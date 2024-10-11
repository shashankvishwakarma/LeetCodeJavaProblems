package misc.bitmanipulation;

public class GetBitOperation {

  /**
   * Steps
   * 1. Left shift by position
   * 2. BitMasked number AND with original number
   * @param args
   */
  public static void main(String args[]) {
    int n = 5; //0101
    int pos = 2;
    int bitMask = 1<<pos;


    if((bitMask & n) == 0) {
      System.out.println("bit was zero");
    } else {
      System.out.println("bit was one");
    }
  }

}
