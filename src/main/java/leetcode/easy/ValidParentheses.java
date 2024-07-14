package leetcode.easy;

import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/description/
 */
public class ValidParentheses {
    public static void main(String[] args) {
        String input = "([])[]{}";
        System.out.println(isValid(input));
    }

    private static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
