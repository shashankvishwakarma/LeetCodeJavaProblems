package misc.recursions;

//Find the occurrence of the first and last occurrence of an element using recursion.
public class FirstAndLastOccurrence {

    static int first = -1;
    static int last = -1;

    public static void main(String[] args) {
        String str = "tabcdfghijakkk";
        char elementToSearch = 'a';
        findOccurrence(str, 0, elementToSearch);
        System.out.println("First occurrence : " + first); //output 1
        System.out.println("Last occurrence : " + last); //output 10
    }

    public static void findOccurrence(String str, int index, char elementToSearch) {

        if (str.length() == index) {
            return;
        }

        if (str.charAt(index) == elementToSearch) {
            if (first == -1) {
                first = index;
            } else {
                last = index;
            }
        }
        findOccurrence(str, index + 1, elementToSearch);
    }
}
