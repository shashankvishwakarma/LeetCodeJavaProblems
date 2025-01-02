package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/majority-element-ii/description/
 * <p>
 * Example 1:
 * Input: nums = [3,2,3]
 * Output: [3]
 * <p>
 * Example 2:
 * Input: nums = [1]
 * Output: [1]
 * <p>
 * Example 3:
 * Input: nums = [1,2]
 * Output: [1,2]
 */
class MajorityElement {
    public static void main(String[] args) {

        int[] nums1 = {3, 2, 3};
        System.out.println("Majority Element in [3, 2, 3]: " + majorityElement(nums1)); // Expected: 3

        int[] nums2 = {1, 2};
        System.out.println("Majority Element in [1, 2]: " + majorityElement(nums2)); // Expected: 2
    }

    public static List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int n = nums.length;

        // Populate the map with counts of each element
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Find the majority element (greater than n/3)
        for (int key : map.keySet()) {
            if (map.get(key) > n / 3) { // Fixed condition to be strictly greater
                result.add(key);
            }
        }

        // Since the problem guarantees a majority element, this line should not be reached
        return result;
    }
}