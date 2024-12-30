package dsa.queue;

import java.util.NoSuchElementException;

public class CustomQueue {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;

    int ptr = 0;

    public CustomQueue() {
        this(DEFAULT_SIZE);
    }

    public CustomQueue(int size) {
        data = new int[size];
    }

    public boolean insert(int item) {
        if (isFull()) {
            return false;
        }
        data[ptr++] = item;
        return true;
    }

    public int remove() throws Exception {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        int removed = data[0];

        // shift the elements to left
        for (int i = 1; i < ptr; i++) {
            data[i - 1] = data[i];
        }
        ptr--;
        return removed;
    }

    public void display() {
        for (int i = 0; i < ptr; i++) {
            System.out.print(data[i] + " <- ");
        }
        System.out.println("END");
    }

    public boolean isEmpty() {
        return ptr == 0;
    }

    public boolean isFull() {
        return ptr == data.length;
    }

    public static void main(String[] args) throws Exception {
        CustomQueue queue = new CustomQueue(5);

        queue.insert(3);
        queue.insert(6);
        queue.insert(5);
        queue.insert(19);
        queue.insert(1);

        queue.display();

        System.out.println(queue.remove());
        queue.insert(133);
        queue.display();

        System.out.println(queue.remove());
        queue.insert(99);
        queue.display();
    }
}
