package leetcode.easy;

import java.util.Stack;

/**
 * https://leetcode.com/problems/implement-queue-using-stacks/description/
 */
class ImplementQueueUsingStacks {

    private Stack<Integer> first;
    private Stack<Integer> second;

    public ImplementQueueUsingStacks() {
        first = new Stack<>();
        second = new Stack<>();
    }

    public void push(int x) {
        first.push(x);
    }

    public int pop() {
        while (!first.isEmpty()) {
            second.push(first.pop());
        }
        int removed = second.pop();

        while (!second.isEmpty()) {
            first.push(second.pop());
        }
        return removed;
    }

    public int peek() {
        while (!first.isEmpty()) {
            second.push(first.pop());
        }

        int peeked = second.peek();

        while (!second.isEmpty()) {
            first.push(second.pop());
        }
        return peeked;
    }

    public boolean empty() {
        return first.isEmpty();
    }

    public static void main(String[] args) {
        ImplementQueueUsingStacks obj = new ImplementQueueUsingStacks();
        obj.push(5);
        System.out.println("Pop element " + obj.pop());
        //System.out.println("Peek element "+obj.peek());
        System.out.println("Is Queue element empty " + obj.empty());
    }
}
