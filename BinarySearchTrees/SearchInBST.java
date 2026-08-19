package BinarySearchTrees;

// -- TIME COMPLEXITY--  
// * O(levels)=O(logn) BEST CASE*
// * O(levels)=O(n) WORST CASE*
public class SearchInBST {
    boolean serach(Node root, int x) {
        if (root == null) {
            return false;
        }
        if (root.data == x) {
            return true;
        } else if (root.data > x) {
            return serach(root.left, x);
        } else
            return serach(root.right, x);
    }
}
