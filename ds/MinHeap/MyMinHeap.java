package ds;

import java.util.Arrays;

public class MyMinHeap {
    private int[] a;
    private int size;
    private final int capacity;

    public MyMinHeap(int c) {
        this.size = 0;
        this.capacity = c;
        a = new int[c];
    }

    public MyMinHeap(int[] a) {
        this.capacity = a.length;
        this.size = a.length;
        this.a = a;
        buildHeap();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    private int getParent(int i) {
        return (i - 1)/2;
    }

    private int getLeftChild(int i) {
        return (2*i) + 1;
    }

    private int getRightChild(int i) {
        return (2*i) + 2;
    }

    private void swap(int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public void offer(int data) {
        if(isFull())
            throw new IllegalStateException();
        size++;
        a[size - 1] = data;
        int i = size - 1;
        while(i > 0) {
            int temp = getParent(i);
            if(a[temp] > a[i]) {
                swap(i, temp);
            }else {
                break;
            }
            i = temp;
        }
    }

    public int peek() {
        return a[0];
    }

    public int poll() {
        if(isEmpty())
            throw new IllegalStateException();
        int temp = a[0];
        swap(0, size - 1);
        size--;
        heapify(0);
        return temp;
    }

    private void heapify(int index) {
        int left = getLeftChild(index);
        int right = getRightChild(index);
        int smallest = index;

        if(left < size && a[left] < a[index])
            smallest = left;
        if(right < size && a[right] < a[smallest])
            smallest = right;
        if(smallest != index) {
            swap(index, smallest);
            heapify(smallest);
        }
    }

    public void decreaseKey(int i, int key) {
        a[i] = key;
        while(i > 0) {
            int temp = getParent(i);
            if(a[temp] > a[i]) {
                swap(i, temp);
            }else {
                break;
            }
            i = temp;
        }
    }

    public void deleteKey(int i) {
        decreaseKey(i, Integer.MIN_VALUE);
        poll();
    }

    private void buildHeap() {
        for(int i=getParent(size - 1);i >= 0;i--) {
            heapify(i);
        }
    }
}
