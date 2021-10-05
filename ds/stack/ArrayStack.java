package ds;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class ArrayStack<T> {
    private List<T> stack;
    private int top = -1;
    private int capacity = 0;

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        stack = new ArrayList<>(capacity);
    }

    public ArrayStack() {
        stack = new ArrayList<>();
    }
    /**checks if the stack
     *is Empty
     * */
    public boolean isEmpty() {
        return top == -1;
    }

    public T push(T data) {
        top++;
        if(top >= capacity)
            throw new StackOverflowError();
        stack.add(top, data);
        return data;
    }

    public T peek() {
        if(isEmpty())
            throw new EmptyStackException();
        return stack.get(top);
    }

    public T pop() {
        if(isEmpty())
            throw new EmptyStackException();
        return stack.get(top--);
    }

    public void printStack() {
        if(isEmpty())
            throw new EmptyStackException();
        for(int i = top;i >= 0;i--) {
            System.out.println(stack.get(i));
        }
    }
}
