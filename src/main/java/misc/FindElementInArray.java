package misc;

import java.util.ArrayList;

public class FindElementInArray {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 4, 4, 5};
        System.out.println(find(arr, 4, 0));
        System.out.println(findFirstIndex(arr, 4, 0));
        System.out.println(findLastIndex(arr, 4, arr.length - 1));
        findAllIndex(arr, 4, 0);
        System.out.println(list);
    }

    static boolean find(int[] arr, int target, int index) {
        if (index == arr.length) {
            return false;
        }
        return target == arr[index] || find(arr, target, index + 1);
    }

    static int findFirstIndex(int[] arr, int target, int index) {
        if (index == arr.length) {
            return -1;
        }

        if (target == arr[index]) {
            return index;
        } else {
            return findFirstIndex(arr, target, index + 1);
        }
    }

    static int findLastIndex(int[] arr, int target, int index) {
        if (index == -1) {
            return -1;
        }

        if (target == arr[index]) {
            return index;
        } else {
            return findFirstIndex(arr, target, index - 1);
        }
    }

    static ArrayList<Integer> list = new ArrayList<>();

    static void findAllIndex(int[] arr, int target, int index) {
        if (index == arr.length - 1) {
            return;
        }

        if (target == arr[index]) {
            list.add(index);
        }
        findAllIndex(arr, target, index + 1);
    }
}
