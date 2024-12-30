package misc.stack;

import java.util.Stack;

import static misc.stack.PushElementAtBottomOfStack.pushAtBottom;

/**
 * Reverse a Stack
 */
public class ReverseStack {
    public static void main(String args[]) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    public static void reverse(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }

        int top = s.pop();
        reverse(s);
        pushAtBottom(s, top);
    }

}