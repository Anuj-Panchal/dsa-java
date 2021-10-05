package ds;

public class MyLinkedList<T> {
    static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    Node<T> head;

    public void add(T data) {
        Node<T> toAdd = new Node<T>(data);
        if(head == null) {
            head = toAdd;
        }else {
            Node<T> temp = head;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = toAdd;
        }
    }

    public void add(int index, T data) {
        if(index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> temp = head;
        Node<T> toAdd = new Node<T>(data);
        for(int i=0;i<index-1;i++) {
            temp = temp.next;
        }
        Node<T> shiftToRight = temp.next;
        temp.next = toAdd;
        toAdd.next = shiftToRight;
    }

    public int size() {
        if(head == null)
            return 0;
        int count = 1;
        Node<T> temp = head;
        while(temp.next != null) {
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
        System.out.print("[");
        while(temp != null) {
            System.out.print(temp.data + ", ");
            temp = temp.next;
        }
        System.out.print("\b\b]");
    }
}
