package leetcode.easy;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/majority-element/description/
 * <p>
 * Example 1:
 * Input: nums = [3,2,3]
 * Output: 3
 * <p>
 * Example 2:
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 */
class MajorityElement {
    public static void main(String[] args) {

        int[] nums1 = {3, 2, 3};
        System.out.println("Majority Element in [3, 2, 3]: " + majorityElement(nums1)); // Expected: 3

        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println("Majority Element in [2, 2, 1, 1, 1, 2, 2]: " + majorityElement(nums2)); // Expected: 2
    }

    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        // Populate the map with counts of each element
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Find the majority element (greater than n/2)
        for (int key : map.keySet()) {
            if (map.get(key) > n / 2) { // Fixed condition to be strictly greater
                return key;
            }
        }

        // Since the problem guarantees a majority element, this line should not be reached
        return -1;
    }
}