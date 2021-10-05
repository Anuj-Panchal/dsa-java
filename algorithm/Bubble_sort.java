package algorithm;

public class Bubble_sort<T extends Comparable<T>> {
    private T[] a;

    public Bubble_sort(T[] b) {
        a = b;
    }

    public Bubble_sort() {
    }

    public T[] sort() {
        return sort(a);
    }

    public T[] sort(T[] a) {
        for(int i=0;i<a.length-1;i++) {
            boolean isSorted = true;
            for(int j=0;j<a.length-1-i;j++) {
                if(a[j].compareTo(a[j+1]) > 0) {
                    swap(a, j, j+1);
                    if(isSorted) {
                        isSorted = false;
                    }
                }
            }
            if(isSorted) {
                break;
            }
        }
        return a;
    }

    private void swap(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
