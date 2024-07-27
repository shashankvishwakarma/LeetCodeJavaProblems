package leetcode.medium;

import java.util.Stack;

/**
 * https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/description/
 */
public class MinimumInsertionToMakeParenthesesValid {
    public static void main(String[] args) {
        String input = "()))((";
        System.out.println(minAddToMakeValid(input));
    }

    public static int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
        }
        return stack.size();
    }
}
