package leetcode.medium;

/**
 * https://leetcode.com/problems/peak-index-in-a-mountain-array/description/
 * https://leetcode.com/problems/find-peak-element/description/
 * <p>
 * Example 1:
 * Input: arr = [0,1,0]
 * Output: 1
 * <p>
 * Example 2:
 * Input: arr = [0,2,1,0]
 * Output: 1
 * <p>
 * Example 3:
 * Input: arr = [0,10,5,2]
 * Output: 1
 */
public class PeakIndexInAMountainArray {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0};
        int ans = peakIndexInMountainArray(arr);
        System.out.println(ans);
    }

    public static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                // you are in dec part of array
                end = mid;
            } else {
                // you are in asc part of array
                start = mid + 1;
            }
        }
        return start;
    }
}
