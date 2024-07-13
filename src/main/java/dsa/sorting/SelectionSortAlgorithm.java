package dsa.sorting;

import java.util.Arrays;

public class SelectionSortAlgorithm {
    public static void main(String[] args) {
        int[] arr = {5, 3, 4, 1, 2};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void selectionSort(int[] arr) {
        int start = 0;
        for (int i = 0; i < arr.length; i++) {
            int last = arr.length - i - 1;
            int maxIndex = getMaxIndex(arr, start, last);
            swap(arr, maxIndex, last);
        }
    }

    private static int getMaxIndex(int[] arr, int start, int last) {
        int max = start;
        for (int i = start; i < last; i++) {
            if (arr[max] < arr[i]) {
                max = i;
            }
        }
        return max;
    }

    private static void swap(int[] arr, int maxIndex, int last) {
        int temp = arr[maxIndex];
        arr[maxIndex] = arr[last];
        arr[last] = temp;
    }
}
