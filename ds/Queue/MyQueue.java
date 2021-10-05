package ds;

import java.util.ArrayList;
import java.util.List;

public class MyQueue<T>{
    private List<T> queue;
    private final int capacity;
    private int front = 0;
    private int rear = -1;
    private int size = 0;


    public MyQueue(int capacity) {
        this.capacity = capacity;
        queue = new ArrayList<>(capacity);
    }

    public void enqueue(T data) {
        if(isFull())
            throw new StackOverflowError();
        else {
            rear++;
            queue.add(data);
            size++;
        }
    }

    public void dequeue() {
        if(isEmpty())
            throw new IndexOutOfBoundsException();
        else {
            front++;
            size--;
        }
    }

    public T getFront() {
        if(isEmpty())
            throw new IndexOutOfBoundsException();
        return queue.get(front);
    }

    public T getRear() {
        if(isEmpty())
            throw new IndexOutOfBoundsException();
        return queue.get(rear);
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
