package BinarySearchTrees;

// -- TIME COMPLEXITY--  
// * O(levels)=O(logn) BEST CASE*
// * O(levels)=O(n) WORST CASE*
public class SearchInBST {
    boolean search(Node root, int x) {
        if (root == null) {
            return false;
        }
        if (root.data == x) {
            return true;
        } else if (root.data > x) {
            return search(root.left, x);
        } else
            return search(root.right, x);
    }
}
