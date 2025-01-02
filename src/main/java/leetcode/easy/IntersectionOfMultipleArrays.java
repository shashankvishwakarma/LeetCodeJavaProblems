package leetcode.easy;

import java.util.*;

/**
 * https://leetcode.com/problems/intersection-of-multiple-arrays/description/
 * <p>
 * Example 1:
 * Input: nums = [[3,1,2,4,5],[1,2,3,4],[3,4,5,6]]
 * Output: [3,4]
 * Explanation:
 * The only integers present in each of nums[0] = [3,1,2,4,5], nums[1] = [1,2,3,4], and nums[2] = [3,4,5,6] are 3 and 4, so we return [3,4].
 * <p>
 * Example 2:
 * Input: nums = [[1,2,3],[4,5,6]]
 * Output: []
 * Explanation:
 * There does not exist any integer present both in nums[0] and nums[1], so we return an empty list [].
 */
public class IntersectionOfMultipleArrays {
    public static void main(String[] args) {

        // Test case 1
        int[][] nums1 = {
                {3, 1, 2, 4, 5},
                {1, 2, 3, 4},
                {3, 4, 5, 6}
        };
        List<Integer> result1 = intersection(nums1);
        System.out.println("Intersection of nums1: " + result1);

        // Test case 2
        int[][] nums2 = {
                {1, 2, 3},
                {4, 5, 6}
        };
        List<Integer> result2 = intersection(nums2);
        System.out.println("Intersection of nums2: " + result2);
    }

    public static List<Integer> intersection(int[][] nums) {
        // Initialize a HashSet with the elements of the first array
        Set<Integer> resultSet = new HashSet<>();
        for (int num : nums[0]) {
            resultSet.add(num);
        }

        // Iterate through the rest of the arrays and keep only the common elements
        for (int i = 1; i < nums.length; i++) {
            Set<Integer> currentSet = new HashSet<>();
            for (int num : nums[i]) {
                if (resultSet.contains(num)) {
                    currentSet.add(num);
                }
            }
            resultSet = currentSet; // Update the result set to only contain common elements
        }

        // Convert the result set to a list, sort it, and return it
        List<Integer> resultList = new ArrayList<>(resultSet);
        Collections.sort(resultList); // Sort the result in ascending order
        return resultList;
    }


}
