package leetcode.easy;

import java.util.HashSet;

/**
 * https://leetcode.com/problems/contains-duplicate/description/
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (!seen.add(num)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate solution = new ContainsDuplicate();

        int[] nums1 = {1, 2, 3, 1};
        System.out.println(solution.containsDuplicate(nums1)); // Output: true

        int[] nums2 = {1, 2, 3, 4};
        System.out.println(solution.containsDuplicate(nums2)); // Output: false

        int[] nums3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println(solution.containsDuplicate(nums3)); // Output: true
    }
}
