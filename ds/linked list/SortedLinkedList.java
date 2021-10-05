package ds;

public class SortedLinkedList<T extends Comparable<T>> {
    static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    Node<T> head;

    public void insert(T data) {
        Node<T> toAdd = new Node<>(data);
        if(head == null) {
            head = toAdd;
            return;
        }
        Node<T> temp = head;
        if (head.next == null && ((head.data).compareTo(data) > 0)){
            toAdd.next = head;
            head = toAdd;
            return;
        }
        while(temp.next != null) {
            if((temp.next.data).compareTo(data) < 0) {
                temp = temp.next;
            }else {
                Node<T> right = temp.next;
                temp.next = toAdd;
                toAdd.next = right;
                return;
            }
        }
        temp.next = toAdd;
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
