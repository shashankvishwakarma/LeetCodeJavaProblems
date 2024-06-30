package leetcode.easy;

/**
 * https://leetcode.com/problems/richest-customer-wealth/
 * Example 1:
 * <p>
 * Input: accounts = [[1,2,3],[3,2,1]]
 * Output: 6
 * Explanation:
 * 1st customer has wealth = 1 + 2 + 3 = 6
 * 2nd customer has wealth = 3 + 2 + 1 = 6
 * Both customers are considered the richest with a wealth of 6 each, so return 6.
 * Example 2:
 * <p>
 * Input: accounts = [[1,5],[7,3],[3,5]]
 * Output: 10
 * Explanation:
 * 1st customer has wealth = 6
 * 2nd customer has wealth = 10
 * 3rd customer has wealth = 8
 * The 2nd customer is the richest with a wealth of 10.
 * Example 3:
 * <p>
 * Input: accounts = [[2,8,7],[7,1,3],[1,9,5]]
 * Output: 17
 */
public class RichestCustomerWealth {
    public static void main(String[] args) {
        int[][] accounts = {
                {1, 5},
                {7, 3},
                {3, 5},
        };
        int ans = maximumWealth(accounts);
        System.out.println(ans);
    }

    public static int maximumWealth(int[][] accounts) {
        int maximumWealth = 0;
        for (int i = 0; i < accounts.length; i++) {
            int totalWealth = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                totalWealth = totalWealth + accounts[i][j];
            }
            if (maximumWealth < totalWealth) {
                maximumWealth = totalWealth;
            }
        }
        return maximumWealth;
    }
}
