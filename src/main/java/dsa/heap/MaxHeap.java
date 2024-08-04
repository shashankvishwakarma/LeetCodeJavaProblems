package dsa.heap;

import java.util.ArrayList;

public class MaxHeap<T extends Comparable<T>> {

    private ArrayList<T> list;

    public MaxHeap() {
        this.list = new ArrayList<>();
    }

    private void swap(int first, int second) {
        T value = list.get(first);
        list.set(first, list.get(second));
        list.set(second, value);
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int left(int index) {
        return index * 2 + 1;
    }

    private int right(int index) {
        return index * 2 + 2;
    }

    public void insert(T value) {
        list.add(value);
        upheap(list.size() - 1);
    }

    private void upheap(int index) {
        if (index == 0) {
            return;
        }

        int parent = parent(index);
        if (list.get(index).compareTo(list.get(parent)) > 0) {
            swap(index, parent);
            upheap(parent);
        }
    }

    public T remove() throws Exception {
        if (list.isEmpty()) {
            throw new Exception("Removing from an empty heap!");
        }

        T value = list.get(0);

        T last = list.remove(list.size() - 1);
        if (!list.isEmpty()) {
            list.set(0, last);
            downheap(0);
        }

        return value;

    }

    private void downheap(int index) {
        int min = index;
        int left = left(index);
        int right = right(index);

        if (left < list.size() && list.get(min).compareTo(list.get(left)) < 0) {
            min = left;
        }

        if (right < list.size() && list.get(min).compareTo(list.get(right)) < 0) {
            min = right;
        }

        if (min != index) {
            swap(min, index);
            downheap(min);
        }
    }

    public T getMax() {
        return list.getFirst();
    }

    public void printHeap() {
        System.out.println(list);
    }

    public static void main(String[] args) throws Exception {
        MaxHeap<Integer> maxHeap = new MaxHeap<>();

        maxHeap.insert(10);
        maxHeap.insert(15);
        maxHeap.insert(20);
        maxHeap.insert(17);
        maxHeap.insert(25);

        maxHeap.printHeap(); // Output: [25, 20, 15, 10, 17]
        System.out.println("Min value: " + maxHeap.getMax()); // Output: 25

        System.out.println("Remove value: " + maxHeap.remove()); // Output: 25
        maxHeap.printHeap(); // Output: [20, 17, 15, 10]

        System.out.println("Min value: " + maxHeap.getMax()); // Output: 20
    }
}
