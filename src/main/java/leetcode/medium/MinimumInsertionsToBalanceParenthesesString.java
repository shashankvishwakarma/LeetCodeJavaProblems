package leetcode.medium;

import java.util.Stack;

/**
 * https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/description/
 */
public class MinimumInsertionsToBalanceParenthesesString {
    public static void main(String[] args) {
        System.out.println(minInsertions("(()))")); // Output: 1
        //System.out.println(minInsertions("())")); // Output: 0
        //System.out.println(minInsertions("))())(")); // Output: 3
    }

    public static int minInsertions(String s) {
        Stack<Character> stack = new Stack<>();
        int insertions = 0; // To count the number of insertions needed

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(c);
            } else {
                // Handle right parenthesis ')'
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    // Case of '))'
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop(); // Match with a previous '('
                    } else {
                        insertions++; // Insert a '(' to match this '))'
                    }
                    i++; // Skip the next ')'
                } else {
                    // Case of single ')'
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop(); // Match with a previous '('
                        insertions++; // Insert an additional ')' to complete the pair
                    } else {
                        insertions += 2; // Insert '(' and an additional ')'
                    }
                }
            }
        }

        // After processing all characters, if there are any unmatched '('
        while (!stack.isEmpty()) {
            stack.pop();
            insertions += 2; // Each '(' needs two ')'
        }

        return insertions;
    }
}
