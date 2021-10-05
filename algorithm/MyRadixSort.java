package algorithm;

public class MyRadixSort {
    public void sort(int[] a) {
        int max = a[0];
        for(int i=1;i<a.length;i++) {
            if(a[i] > max) {
                max = a[i];
            }
        }

        int ten = 1;
        while(max / ten > 0) {
            countSort(a, ten);
            ten *= 10;
        }
    }
    private void countSort(int[] a, int ten) {
        int[] count = new int[10];
        int[] temp = new int[a.length];

        for(int i=0;i<a.length;i++) {
            count[(a[i]/ten) % 10]++;
        }
        for(int i=1;i<10;i++) {
            count[i] += count[i-1];
        }

        for(int i=a.length-1;i>=0;i--) {
            temp[count[(a[i] / ten) % 10] - 1] = a[i];
            count[(a[i] / ten) % 10]--;
        }

        for(int i=0;i<a.length;i++) {
            a[i] = temp[i];
        }
    }
}
