package BinarySearchTrees;

public class inorderSuccessor {
    public int inOrderSuccessor(Node root, Node k) {
        Node succ = null;
        Node curr = root;
        while (curr != null) {
            if (curr.data > k.data) {
                succ = curr;
                curr = curr.left;
            } else
                curr = curr.right;
        }
        return (succ != null) ? succ.data : -1;
    }
}
