package misc.recursions;

//Check if an array is sorted (strictly increasing).
public class CheckIfArrayIsSorted {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 16, 8};
        System.out.println(isSortedArray(arr, 0));
    }

    static boolean isSortedArray(int[] arr, int index) {
        if (index == arr.length - 1)
            return true;

        return arr[index] < arr[index + 1] && isSortedArray(arr, index + 1);
    }
}
