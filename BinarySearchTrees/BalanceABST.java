package BinarySearchTrees;

import java.util.ArrayList;
// LEETCODE 1382
public class BalanceABST {
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        inorder(root, arr);
        return convert(arr, 0, arr.size() - 1);
    }

    public void inorder(TreeNode root, ArrayList<Integer> arr) {
        if (root == null)
            return;
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
    }

    public TreeNode convert(ArrayList<Integer> arr, int lo, int hi) {
        if (lo > hi) {
            return null;
        }
        int mid = (lo + hi) / 2;
        TreeNode root = new TreeNode(arr.get(mid));
        root.left = convert(arr, lo, mid - 1);
        root.right = convert(arr, mid + 1, hi);
        return root;
    }
}
