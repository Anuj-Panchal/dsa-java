package ds;

public class MyBST<T extends Comparable<T>> {
    static class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;

        Node(T data) {
            this.data = data;
        }
    }
    private Node<T> root;

    public void insertNode(T data) {
        root = insertNode(root, data);
    }

    private Node<T> insertNode(Node<T> root, T data) {
        if(root == null) {
            return new Node<T>(data);
        }
        if(root.data.compareTo(data) < 0) {
            root.right = insertNode(root.right, data);
        }else if(root.data.compareTo(data) > 0) {
            root.left = insertNode(root.left, data);
        }else {
            return root;
        }
        return root;
    }

    public boolean searchNode(T data) {
        return searchNode(root, data);
    }

    private boolean searchNode(Node<T> root, T data) {
        if(root == null)
            return false;
        if(root.data.compareTo(data) < 0)
            return searchNode(root.right, data);
        else if(root.data.compareTo(data) > 0)
            return searchNode(root.left, data);
        return true;
    }

    public void deleteNode(T data) {
        root = deleteNode(root, data);
    }

    private Node<T> deleteNode(Node<T> root, T data) {
        if(root == null)
            return null;
        if(root.data.compareTo(data) < 0)
            root.right = deleteNode(root.right, data);
        else if(root.data.compareTo(data) > 0)
            root.left = deleteNode(root.left, data);
        else {
            if(root.left == null)
                return root.right;
            if(root.right == null)
                return root.left;
            Node<T> temp = getS(root);
            root.data = temp.data;
            root.right = deleteNode(root.right, temp.data);
        }
        return root;
    }

    private Node<T> getS(Node<T> root) {
        Node<T> curr = root.right;
        while(curr != null && curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    public T floor(T data) {
        return floor(root, data);
    }

    private T floor(Node<T> root, T data) {
        if(root == null)
            return null;
        T ans;
        if(root.data.compareTo(data) > 0)
            return floor(root.left, data);
        else if(root.data.compareTo(data) < 0) {
            ans = floor(root.right, data);
            ans = (ans != null)? ans: root.data;
        }else {
            ans = root.data;
        }
        return ans;
    }
}
