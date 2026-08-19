package BinarySearchTrees;

public class InsertInAbst {
    void attach(Node root, int key) {
        if (root == null) {
            return;
        }
        if (root.data == key) {
            return;
        }
        if (root.data < key) {
            if (root.right == null) {
                root.right = new Node(key);
            } else
                attach(root.right, key);
        } else {
            if (root.left == null) {
                root.left = new Node(key);
            } else
                attach(root.left, key);
        }
    }

    Node insert(Node root, int key) {
        if (root == null)
            return new Node(key);
        if (root.data == key)
            return root;
        else if (root.data < key)
            root.right = insert(root.right, key);
        else
            root.left = insert(root.left, key);
        return root;
    }
}
