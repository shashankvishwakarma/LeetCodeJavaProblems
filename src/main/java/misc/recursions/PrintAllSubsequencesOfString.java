package misc.recursions;

//Print all the subsequences of a string.
public class PrintAllSubsequencesOfString {

    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "aaa";
        printAllSubsequences(str1, 0, "");
    }

    private static void printAllSubsequences(String str, int index, String newStr) {
        if (index == str.length()) {
            System.out.println(newStr);
            return;
        }
        //choose
        printAllSubsequences(str, index + 1, newStr + str.charAt(index));

        //don't choose
        printAllSubsequences(str, index + 1, newStr);
    }
}
