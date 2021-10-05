package ds;

public class MyDs {
    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    Node head;
    Node tail;

    public void insertMin(int n) {
        Node toAdd = new Node(n);
        if(head == null) {
            head = toAdd;
            tail = toAdd;
            return;
        }
        toAdd.next = head;
        head = toAdd;
    }

    public void insertMax(int n) {
        Node toAdd = new Node(n);
        if(head == null) {
            head = toAdd;
            tail = toAdd;
            return;
        }
        tail.next = toAdd;
        tail = toAdd;
    }

    public int getMin() throws IllegalAccessException {
        if(head == null)
            throw new IllegalAccessException();
        return head.data;
    }

    public int getMax() throws IllegalAccessException {
        if(head == null)
            throw new IllegalAccessException();
        return tail.data;
    }

    public void extractMin() throws IllegalAccessException {
        if(head == null)
            throw new IllegalAccessException();
        head = head.next;
    }

    public void extractMax() throws IllegalAccessException {
        if(head == null)
            throw new IllegalAccessException();
        tail = tail.prev;
    }
}
