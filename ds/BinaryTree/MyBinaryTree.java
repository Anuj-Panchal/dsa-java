package ds;

import java.util.ArrayDeque;

public class MyBinaryTree<T> {
    static class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;

        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> root;

    public void insert(T key) {
        ArrayDeque<Node<T>> ad = new ArrayDeque<>();

        Node<T> toAdd = new Node<>(key);

        if(root == null) {
            root = toAdd;
            return;
        }
        ad.offerLast(root);

        while(!ad.isEmpty()) {
            Node<T> temp = ad.pollFirst();
            if(temp.left == null) {
                temp.left = new Node<>(key);
                break;
            }else {
                ad.offerLast(temp.left);
            }

            if(temp.right == null) {
                temp.right = new Node<>(key);
                break;
            }else {
                ad.offerLast(temp.right);
            }
        }
    }

    public void printInOrder(Node<T> root) {
        if(root == null)
            return;

        printInOrder(root.left);
        System.out.println(root.data);
        printInOrder(root.right);
    }

    public  void printInOrderIterative(Node<T> root) {
        if(root == null)
            return;
        Node<T> current = root;
        ArrayDeque<Node<T>> ad = new ArrayDeque<>();

        while(current != null || !ad.isEmpty()) {
            while(current != null) {
                ad.push(current);
                current = current.left;
            }
            current = ad.pop();
            System.out.println(current.data);
            current = current.right;
        }
    }

    public void printPreOrder(Node<T> root) {
        if(root == null)
            return;

        System.out.println(root.data);
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    public void printPreOrderIterative(Node<T> root) {
        if(root == null)
            return;
        ArrayDeque<Node<T>> ad = new ArrayDeque<>();
        Node<T> current = root;

        while(current != null || !ad.isEmpty()) {
            while(current != null) {
                System.out.println(current.data);
                ad.push(current);
                current = current.left;
            }
            current = ad.pop();
            current = current.right;
        }
    }

    public void printPostOrder(Node<T> root) {
        if(root == null)
            return;

        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.println(root.data);
    }

    public void printPostOrderIterative(Node<T> root) {
        if(root == null)
            return;
        ArrayDeque<Node<T>> ad = new ArrayDeque<>();
        Node<T> current = root;
    }

    public int getMaxHeight(Node<T> root) {
        if(root == null)
            return 0;
        return ((Math.max(getMaxHeight(root.left), getMaxHeight(root.right))) + 1);
    }

    public void getNodesAtKDistance(Node<T> root, int k) {
        if(root == null) {
            return;
        }
        if(k == 0) {
            System.out.println(root.data);
            return;
        }
        getNodesAtKDistance(root.left, k-1);
        getNodesAtKDistance(root.right, k-1);
    }

    public void printBFS(Node<T> root) {
        if(root == null)
            return;
        ArrayDeque<Node<T>> ad = new ArrayDeque<>();
        ad.offerLast(root);

        while(!ad.isEmpty()) {
            Node<T> temp = ad.pollFirst();

            System.out.println(temp.data);
            if(temp.left != null)
                ad.offerLast(temp.left);
            if(temp.right != null)
                ad.offerLast(temp.right);
        }
    }

    public int sizeOfTree(Node<T> root) {
        if(root == null)
            return 0;
        return sizeOfTree(root.left) + sizeOfTree(root.right) + 1;
    }

    public int getMaxValue(Node<T> root) {
        if(root == null)
            return Integer.MIN_VALUE;
        return Math.max((int)root.data, Math.max(getMaxValue(root.left), getMaxValue(root.right)));
    }

    public Node<T> getRoot() {
        return root;
    }
}
