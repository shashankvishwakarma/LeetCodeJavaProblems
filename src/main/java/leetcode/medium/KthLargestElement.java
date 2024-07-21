package leetcode.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 */
public class KthLargestElement {

  /*
    Input: nums = [3,2,1,5,6,4], k = 2
    Output: 5
    */
  public static void main(String[] args) {
    int[] nums = new int[] {3,2,1,5,6,4};
    int k = 2;

    int kthLargest = findKthLargest(nums, k);
    System.out.println("The " + k + "th largest element is: " + kthLargest);
  }

  public static int findKthLargest(int[] nums, int k) {
    Arrays.sort(nums);
    return nums[nums.length - k];
  }

}
