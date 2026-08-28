package BinarySearchTrees;

import java.util.ArrayList;

public class kthLargestInBST {
    public void inorder(Node root, ArrayList<Integer> arr) {
        if (root == null)
            return;
        inorder(root.left, arr);
        arr.add(root.data);
        inorder(root.right, arr);
    }

    public int kthLargest(Node root, int k) {
        // code here
        ArrayList<Integer> arr = new ArrayList<>();
        inorder(root, arr);
        if (arr.size() < k) {
            return -1;
        }
        return arr.get(arr.size() - k);
    }
}
