package ds;

import java.util.ArrayList;
import java.util.List;

public class MyArrayQueue {
    private int[] queue;
    private final int capacity;
    private int front = 0;
    private int rear = -1;
    private int size = 0;


    public MyArrayQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
    }

    public void enqueue(int data) {
        if(isFull())
            throw new StackOverflowError();
        else {
            rear = (rear + 1) % capacity;
            queue[rear] = data;
            size++;
        }
    }

    public void dequeue() {
        if(isEmpty())
            throw new IndexOutOfBoundsException();
        else {
            front = (front + 1) % capacity;
            size--;
        }
    }

    public int getFront() {
        if(isEmpty())
            throw new IndexOutOfBoundsException();
        return queue[front];
    }

    public int getRear() {
        if(isEmpty())
            throw new IndexOutOfBoundsException();
        return queue[rear];
    }

    public void printQueue() {
        for(int i=front, j=1;j <= size;i = (i+1) % capacity, j++) {
            System.out.println(queue[i]);
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}
