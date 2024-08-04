package dsa.heap;

import java.util.ArrayList;

public class HeapSort extends MaxHeap<Integer> {

    public ArrayList<Integer> heapSort() throws Exception {
        ArrayList<Integer> data = new ArrayList<>();
        while (!this.list.isEmpty()) {
            data.add(this.remove());
        }
        return data;
    }

    public static void main(String[] args) throws Exception {
        HeapSort minHeap = new HeapSort();

        minHeap.insert(10);
        minHeap.insert(15);
        minHeap.insert(20);
        minHeap.insert(17);
        minHeap.insert(25);

        System.out.println(minHeap.heapSort()); // Output: [25, 20, 17, 15, 10]
    }
}
