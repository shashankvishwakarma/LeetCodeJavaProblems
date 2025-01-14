package leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
 * <p>
 * Example 1:
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * <p>
 * Example 2:
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 */
public class IntersectionOfTwoArraysII {

    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] result1 = intersect(nums1, nums2);
        System.out.print("Intersection of nums1 and nums2 is: ");
        for (int num : result1) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Test case 2
        int[] nums3 = {4, 9, 5};
        int[] nums4 = {9, 4, 9, 8, 4};
        int[] result2 = intersect(nums3, nums4);
        System.out.print("Intersection of nums3 and nums4 is: ");
        for (int num : result2) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> resultList = new ArrayList<>();

        // Count the frequency of each element in nums1
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Find intersection with nums2
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                resultList.add(num);
                map.put(num, map.get(num) - 1); // Decrease the count in the map
            }
        }

        // Convert ArrayList to an int array
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }
}
