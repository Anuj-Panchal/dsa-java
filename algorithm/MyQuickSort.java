package algorithm;

public class MyQuickSort <T extends Comparable<T>>{
    private T[] a;

    MyQuickSort(T[] a) {
        this.a = a;
    }

    public MyQuickSort() {}

    public void lomutoSort() {
        lomutoSort(this.a, 0, this.a.length - 1);
    }

    public void lomutoSort(T[] a) {
        lomutoSort(a, 0, a.length - 1);
    }

    public void lomutoSort(T[] a, int left, int right) {
        if(left < right) {
            int p = lomutoPartition(a, left, right);
            lomutoSort(a, left, p-1);
            lomutoSort(a, p+1, right);
        }
    }

    private int lomutoPartition(T[] a, int left, int right) {
        T pivot = a[right];
        int i = left - 1;
        for(int j=left;j <= right - 1;j++) {
            if(a[j].compareTo(pivot) < 0) {
                i++;
                swap(a, i, j);
            }
        }
        swap(a, i+1, right);
        return i+1;
    }

    public void hoareSort() {
        hoareSort(this.a, 0, this.a.length - 1);
    }

    public void hoareSort(T[] a) {
        hoareSort(a, 0, a.length - 1);
    }

    public void hoareSort(T[] a, int left, int right) {
        if(left < right) {
            int p = hoarePartition(a, left, right);
            hoareSort(a, left, p);
            hoareSort(a, p+1, right);
        }
    }

    private int hoarePartition(T[] a, int left, int right) {
        T pivot = a[left];
        int i = left - 1;
        int j = right + 1;
        while(i < j) {
            do{
                i++;
            }while(a[i].compareTo(pivot) < 0);

            do {
                j--;
            }while (a[j].compareTo(pivot) > 0);

            if(i >= j)
                break;
            swap(a, i, j);
        }
        return j;
    }

    private void swap(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
