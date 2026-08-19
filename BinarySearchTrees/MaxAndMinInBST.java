package BinarySearchTrees;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class MaxAndMinInBST {
    /*
     * Definition for Node
     */

    class Solution {
        public int minValue(Node root) {
            // code here
            Node temp = root;
            while (temp.left != null)
                temp = temp.left;
            return temp.data;
        }

        int maxValue(Node root) {
            Node temp = root;
            while (temp.right != null)
                temp = temp.right;
            return temp.data;
        }
    }

}
