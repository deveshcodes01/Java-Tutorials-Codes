package BinaryTrees;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

public class treeTraversals {
    void preOrderIterative(Node root) {
        if (root == null)
            return;
        java.util.Stack<Node> stack = new java.util.Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.print(node.data + " ");
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }
    }

    void inOrderIterative(Node root) {
        java.util.Stack<Node> stack = new java.util.Stack<>();
        Node curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            System.out.print(curr.data + " ");
            curr = curr.right;
        }
    }

    void postOrderIterative(Node root) {
        if (root == null)
            return;
        java.util.Stack<Node> s1 = new java.util.Stack<>();
        java.util.Stack<Node> s2 = new java.util.Stack<>();
        s1.push(root);
        while (!s1.isEmpty()) {
            Node node = s1.pop();
            s2.push(node);
            if (node.left != null)
                s1.push(node.left);
            if (node.right != null)
                s1.push(node.right);
        }
        while (!s2.isEmpty()) {
            System.out.print(s2.pop().data + " ");
        }
    }

    // Traversal | Logic | Time Complexity | Space Complexity
    // Pre-order | Root → Left → Right | O(n) | O(h)
    // In-order | Left → Root → Right | O(n) | O(h)
    // Post-order | Left → Right → Root | O(n) | O(h)
}
