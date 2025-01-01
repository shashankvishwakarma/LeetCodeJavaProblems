package dsa.hashmap;

import java.util.ArrayList;
import java.util.LinkedList;

public class CustomHashMap {
    static class HashMap<K, V> { //generics
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int nodeLength; //nodeLength - nodes
        private int bucketSize = 4; //bucketSize - buckets
        private LinkedList<Node>[] buckets; //bucketSize = buckets.length

        @SuppressWarnings("unchecked")
        public HashMap() {
            this.buckets = new LinkedList[this.bucketSize];
            for (int i = 0; i < this.bucketSize; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key) {
            int bucketIndex = key.hashCode();
            return Math.abs(bucketIndex) % bucketSize;
        }

        private int searchInLinkedList(K key, int bucketIndex) {
            LinkedList<Node> ll = buckets[bucketIndex];

            for (int i = 0; i < ll.size(); i++) {
                if (ll.get(i).key == key) {
                    return i; //dataIndex
                }
            }

            return -1;
        }

        @SuppressWarnings("unchecked")
        private void rehash() {
            LinkedList<Node>[] oldBucket = buckets;
            bucketSize = bucketSize * 2;
            buckets = new LinkedList[bucketSize];
            for (int i = 0; i < bucketSize; i++) {
                buckets[i] = new LinkedList<>();
            }
            for (LinkedList<Node> ll : oldBucket) {
                for (Node node : ll) {
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value) {
            int bucketIndex = hashFunction(key);
            int dataIndex = searchInLinkedList(key, bucketIndex); //dataIndex = -1
            if (dataIndex == -1) { //key doesn't exist
                buckets[bucketIndex].add(new Node(key, value));
                nodeLength++;
            } else { //key exists
                Node node = buckets[bucketIndex].get(dataIndex);
                node.value = value;
            }
            double lambda = (double) nodeLength / bucketSize;

            if (lambda > 2.0) {
                rehash();
            }
        }

        public boolean containsKey(K key) {
            int bucketIndex = hashFunction(key);
            int dataIndex = searchInLinkedList(key, bucketIndex); //dataIndex = -1
            if (dataIndex == -1) { //key doesn't exist
                return false;
            } else { //key exists
                return true;
            }
        }

        public V remove(K key) {
            int bucketIndex = hashFunction(key);
            int dataIndex = searchInLinkedList(key, bucketIndex); //dataIndex = -1
            if (dataIndex == -1) { //key doesn't exist
                return null;
            } else { //key exists
                Node node = buckets[bucketIndex].remove(dataIndex);
                nodeLength--;
                return node.value;
            }
        }

        public V get(K key) {
            int bucketIndex = hashFunction(key);
            int dataIndex = searchInLinkedList(key, bucketIndex); //dataIndex = -1
            if (dataIndex == -1) { //key doesn't exist
                return null;
            } else { //key exists
                Node node = buckets[bucketIndex].get(dataIndex);
                return node.value;
            }
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();
            for (LinkedList<Node> ll : buckets) {
                for (Node node : ll) { //dataIndex
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty() {
            return nodeLength == 0;
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("India", 190);
        map.put("China", 200);
        map.put("US", 50);
        ArrayList<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(key + " " + map.get(key));
        }

        map.remove("India");
        System.out.println(map.get("India"));
    }
}