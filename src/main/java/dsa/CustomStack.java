package dsa;

import java.util.EmptyStackException;

public class CustomStack {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;

    int ptr = -1;

    public CustomStack() {
        this(DEFAULT_SIZE);
    }

    public CustomStack(int size) {
        data = new int[size];
    }

    public void push(int item) {
        if (isFull()) {
            System.out.println("Stack is full!!");
            return;
        }
        ptr++;
        data[ptr] = item;
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return data[ptr--];
    }

    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return data[ptr];
    }

    private boolean isEmpty() {
        return ptr == -1;
    }

    private boolean isFull() {
        return ptr == data.length - 1;
    }

    public static void main(String[] args) {
        CustomStack stack = new CustomStack(5);

        stack.push(34);
        stack.push(45);
        stack.push(2);
        stack.push(9);
        stack.push(18);
        stack.push(89);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
