package leetcode.hard;

/**
 * https://leetcode.com/problems/find-in-mountain-array/description/
 */
interface MountainArray {
    int get(int index);

    int length();
}

class MountainArrayImpl implements MountainArray {
    int[] array;

    public MountainArrayImpl(int[] array) {
        this.array = array;
    }

    @Override
    public int get(int index) {
        return array[index];
    }

    @Override
    public int length() {
        return array.length;
    }
}

public class FindInMountainArray {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 3, 1};
        int target = 3;

        MountainArrayImpl mountainArr = new MountainArrayImpl(array);
        System.out.println(findInMountainArray(target, mountainArr));
    }

    public static int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = findPeakIndex(mountainArr);
        int result = binarySearch(mountainArr, target, 0, peak, true);
        if (result != -1) {
            return result;
        }
        return binarySearch(mountainArr, target, peak + 1, mountainArr.length() - 1, false);
    }

    private static int findPeakIndex(MountainArray mountainArr) {
        int start = 0;
        int end = mountainArr.length() - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    private static int binarySearch(MountainArray mountainArr, int target, int start, int end, boolean ascending) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int value = mountainArr.get(mid);

            if (value == target) {
                return mid;
            }

            if (ascending) {
                if (value < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (value > target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
