package misc.recursions;

//Move all ‘x’ to the end of the string.
public class MoveXToEndOfString {
    public static void main(String[] args) {
        String str = "abcdefxghxixjxxxk";
        int count = 0;
        String newStr = "";
        newStr = moveAllX(str, 0, count, newStr);
        System.out.println(newStr); //abcdefghijkxxxxxx

    }

    private static String moveAllX(String str, int index, int count, String newStr) {
        if (str.length() == index) {
            for (int i = 0; i < count; i++) {
                newStr = newStr + 'x';
            }
            return newStr;
        }

        if (str.charAt(index) == 'x') {
            count++;
        } else {
            newStr = newStr + str.charAt(index);
        }
        return moveAllX(str, index + 1, count, newStr);
    }
}
