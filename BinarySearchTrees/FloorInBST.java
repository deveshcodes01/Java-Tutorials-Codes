package BinarySearchTrees;

public class FloorInBST {
    public int FindMaxForK(Node root, int k) {
        int floor = -1;
        Node curr = root;
        while (root != null) {
            if (curr.data == k) {
                return curr.data;
            }
            if (curr.data > k) {
                curr = curr.left;
            } else {
                floor = curr.data;
                curr = curr.right;
            }
        }
        return floor;
    }
}
