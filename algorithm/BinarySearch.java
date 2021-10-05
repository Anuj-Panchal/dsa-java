package algorithm;

public class BinarySearch {
    public static int BinarySearchIterator(int[] a, int key) {
        int left = 0;
        int right = a.length-1;

        while(left <= right) {
            int mid = left + (right - left)/2;
            if(a[mid] == key) {
                return mid;
            }else if(a[mid] > key) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static int BinarySearchRecursive(int[] a, int key, int left, int right) {
        if(left > right)
            return -1;
        int mid = left + (right - left)/2;
        if(a[mid] == key)
            return mid;
        else if(a[mid] > key)
            return BinarySearchRecursive(a, key, left, mid - 1);
        else
            return BinarySearchRecursive(a, key, mid + 1, right);
    }

    public static int BinarySearchRecursive(int[] a, int key) {
        int n = a.length;
        return BinarySearchRecursive(a, key, 0, n-1);
    }
}
