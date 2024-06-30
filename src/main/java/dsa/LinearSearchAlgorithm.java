package dsa;

public class LinearSearchAlgorithm {

    public static void main(String[] args) {
        int[] nums = {23, 45, 1, 2, 8, 19, -3, 16, -11, 28};
        int target = 19;
        int ans = linearSearch(nums, target);
        System.out.println(ans);
    }

    private static int linearSearch(int[] nums, int target) {

        if(nums.length == 0)
            return -1;

        for(int index=0; index < nums.length; index++) {
            if(nums[index] == target)
                return index;
        }

        return -1;

    }
}
