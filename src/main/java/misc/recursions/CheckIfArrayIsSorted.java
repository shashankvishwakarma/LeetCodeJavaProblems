package misc.recursions;

//Check if an array is sorted (strictly increasing).
public class CheckIfArrayIsSorted {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 6, 3, 4, 5};

        if (isStrictlyIncreasing(arr1, 0)) {
            System.out.println("Array 1 is Strictly Increasing");
        } else {
            System.out.println("Array 1 is NOT Strictly Increasing");
        }

        if (isStrictlyIncreasing(arr2, 0)) {
            System.out.println("Array 2 is Strictly Increasing");
        } else {
            System.out.println("Array 2 is NOT Strictly Increasing");
        }
    }

    static boolean isStrictlyIncreasing(int[] arr, int index) {
        if (index == arr.length - 1)
            return true;

        return arr[index] < arr[index + 1] && isStrictlyIncreasing(arr, index + 1);
    }
}
