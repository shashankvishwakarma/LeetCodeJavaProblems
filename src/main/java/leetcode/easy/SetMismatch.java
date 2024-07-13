package leetcode.easy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/set-mismatch/description/
 */
public class SetMismatch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 4};
        System.out.println(Arrays.toString(findErrorNums(arr)));
    }

    public static int[] findErrorNums(int[] nums) {
        cyclicSort(nums);

        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != index + 1) {
                return new int[]{nums[index], index + 1};
            }
        }
        return new int[]{-1, -1};
    }

    public static void cyclicSort(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correctIndex = nums[i] - 1;
            if (nums[i] != nums[correctIndex]) {
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            } else {
                i++;
            }
        }

    }
}
