package misc.recursions;

//Remove duplicates in a string.
public class RemoveDuplicatesString {
    public static void main(String[] args) {
        String str = "abcadbcefghabi";
        boolean[] present = new boolean[str.length()];
        System.out.println(removeDuplicates(str, 0, present)); // abcdefghi
    }

    public static String removeDuplicates(String str, int idx, boolean[] present) {
        if (idx == str.length()) {
            return "";
        }
        char curr = str.charAt(idx);
        if (present[curr - 'a']) {
            return removeDuplicates(str, idx + 1, present);
        } else {
            present[curr - 'a'] = true;
            return curr + removeDuplicates(str, idx + 1, present);
        }
    }
}
