package dsa.sorting;

import java.util.Arrays;

public class MergeSortAlgorithm {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }

        int mid = arr.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    private static int[] merge(int[] first, int[] second) {
        int[] result = new int[first.length + second.length];

        int indexForFirst = 0;
        int indexForSecond = 0;
        int indexForResult = 0;

        while (indexForFirst < first.length && indexForSecond < second.length) {
            if (first[indexForFirst] < second[indexForSecond]) {
                result[indexForResult] = first[indexForFirst];
                indexForFirst++;
            } else {
                result[indexForResult] = second[indexForSecond];
                indexForSecond++;
            }
            indexForResult++;
        }

        while (indexForFirst < first.length) {
            result[indexForResult] = first[indexForFirst];
            indexForResult++;
            indexForFirst++;
        }

        while (indexForSecond < second.length) {
            result[indexForResult] = first[indexForSecond];
            indexForResult++;
            indexForSecond++;
        }

        return result;
    }

}
