package misc.recursions;

import java.util.HashSet;

//Print all unique subsequences of a string.
public class PrintAllUniqueSubsequencesOfString {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "aaa";
        HashSet<String> allSubseq = new HashSet<>();
        printAllSubsequences(str2, 0, "", allSubseq);
    }

    private static void printAllSubsequences(String str, int index, String newStr, HashSet<String>
            allSubseq) {
        if (index == str.length()) {
            if (allSubseq.contains(newStr)) {
                return;
            }
            allSubseq.add(newStr);
            System.out.println(newStr);
            return;
        }
        //choose
        printAllSubsequences(str, index + 1, newStr + str.charAt(index), allSubseq);

        //don't choose
        printAllSubsequences(str, index + 1, newStr, allSubseq);
    }
}
