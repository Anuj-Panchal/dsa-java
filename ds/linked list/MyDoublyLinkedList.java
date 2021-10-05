package ds;

public class MyDoublyLinkedList<T> {
    static class Node<T> {
        T data;
        Node<T> next;
        Node<T> previous;

        Node(T data) {
            this.data = data;
            this.next = null;
            this.previous = null;
        }
    }

    Node<T> head;
    Node<T> tail;

    public void add(T data) {
        Node<T> toAdd = new Node<T>(data);
        if(head == null) {
            head = toAdd;
        }else {
            tail.next = toAdd;
        }
        tail = toAdd;
    }

    public void add(int index, T data) {
        if(index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> temp = head;
        Node<T> toAdd = new Node<T>(data);
        if(index == size()) {
            tail.next = toAdd;
            tail = toAdd;
        }else if(index == 0) {
            toAdd.next = head;
            head.previous = toAdd;
            head = toAdd;
        }else {
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            Node<T> Right = temp.next;
            temp.next = toAdd;
            toAdd.previous = temp;
            toAdd.next = Right;
            Right.previous = toAdd;
        }
    }

    public int size() {
        if(head == null)
            return 0;
        int count = 0;
        Node<T> temp = head;
        while(temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    public boolean contains(T data) {
        Node<T> temp = head;
        while(temp != null) {
            if(temp.data == data) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public boolean isEmpty() {
        return !(size() > 0);
    }

    public void printList() {
        Node<T> temp = head;
        System.out.print("null <- Head <=> ");
        while(temp != null) {
            if(temp != tail)
                System.out.print(temp.data + " <=> ");
            else
                System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("null");
    }

    public boolean addBefore(T data) {
        Node<T> toAdd = new Node<T>(data);
        Node<T> temp = head;
        while(temp != null) {
            if(temp.data == data) {
                Node<T> left = temp.previous;
                left.next = toAdd;
                toAdd.previous = left;
                toAdd.next = temp;
                temp.previous = toAdd;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
}
