package ds;

import java.util.Arrays;

public class MyArrayDeque {

    private final int[] a;
    private int front = 0;
    private int rear = -1;
    private final int capacity;
    private int size;

    public MyArrayDeque(int capacity) {
        this.capacity = capacity;
        a = new int[capacity];
        size = 0;
    }

    public void insertFront(int data) {
        if(isFull())
            return;
        front = (front - 1 + capacity) % capacity;
        a[front] = data;
        size++;
    }

    public void insertRear(int data) {
        if(isFull())
            return;
        rear = (rear + 1) % capacity;
        a[rear] = data;
        size++;
    }

    public int getFront() {
        if(isEmpty())
            throw new IllegalStateException();
        return a[front];
    }

    public int getRear() {
        if(isEmpty())
            throw new IllegalStateException();
        return a[rear];
    }

    public void deleteRear() {
        if(isEmpty())
            throw new IllegalStateException();
        rear = (rear - 1 + capacity) % capacity;
        size--;
    }

    public void deleteFront() {
        if(isEmpty())
            throw new IllegalStateException();
        front = (front + 1) % capacity;
        size--;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void print() {
        System.out.println(Arrays.toString(a));
    }
}
