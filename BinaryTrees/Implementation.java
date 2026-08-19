package BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// Node of Binary Tree
class Node {
    int val;
    Node left;
    Node right;
    public Integer data;

    Node(int val) {
        this.val = val;
    }
}

// Used for level-order traversal with level information
class Pair {
    Node node;
    int level;

    Pair(Node node, int level) {
        this.node = node;
        this.level = level;
    }
}

// Stores maximum and minimum value
class Twin {
    int max;
    int min;

    Twin(int max, int min) {
        this.max = max;
        this.min = min;
    }
}

class Quad {
    int max;
    int min;
    int size;
    int sum;

    Quad(int max, int min, int size, int sum) {
        this.max = max;
        this.min = min;
        this.size = size;
        this.sum = sum;
    }

    void display() {
        System.out.println(max + " " + min + " " + size + " " + sum);
    }
}

public class Implementation {
    public static Quad maxMinSizeSum(Node root) {
        if (root == null) {
            return new Quad(Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
        }
        Quad lst = maxMinSizeSum(root.left);
        Quad rst = maxMinSizeSum(root.right);
        int max = Math.max(root.val, Math.max(lst.max, rst.max));
        int min = Math.min(root.val, Math.min(lst.min, rst.min));
        int size = 1 + lst.size + rst.size;
        int sum = root.val + lst.sum + rst.sum;
        return new Quad(max, min, size, sum);
    }

    public static void main(String[] args) {

        /*
         * 3
         * / \
         * 4 2
         * / \ / \
         * -1 1 6 9
         */

        Node a = new Node(3);
        Node b = new Node(4);
        Node c = new Node(2);
        Node d = new Node(-1);
        Node e = new Node(1);
        Node f = new Node(6);
        Node g = new Node(9);

        a.left = b;
        a.right = c;

        b.left = d;
        b.right = e;

        c.left = f;
        c.right = g;

        // Print nodes at kth level
        System.out.println("Kth Level:");
        KthLevel(a, 0, 2);
        System.out.println();

        // Level order line-wise
        System.out.println("Level Order Line Wise:");
        levelOrderLineWise(a);

        // Level order
        System.out.println("Level Order:");
        levelOrder(a);

        // Preorder
        System.out.println("Preorder:");
        preorder(a);
        System.out.println();

        // Inorder
        System.out.println("Inorder:");
        inorder(a);
        System.out.println();

        // Postorder
        System.out.println("Postorder:");
        postorder(a);
        System.out.println();

        // Display
        System.out.println("Display:");
        display(a);
        System.out.println();

        // Size
        System.out.println("Size: " + size(a));

        // Sum
        System.out.println("Sum: " + sum(a));

        // Maximum
        System.out.println("Maximum: " + max(a));

        // Minimum
        System.out.println("Minimum: " + min1(a));

        // Number of levels
        System.out.println("Levels: " + levels(a));

        // Maximum and minimum together
        Twin result = maxMin(a);
        System.out.println("Maximum using Twin: " + result.max);
        System.out.println("Minimum using Twin: " + result.min);

        // Root-to-leaf paths
        System.out.println("Root-to-Leaf Paths:");
        ArrayList<ArrayList<Integer>> paths = Paths(a);

        for (ArrayList<Integer> path : paths) {
            System.out.println(path);
        }

        // LCA
        Node lcaNode = lca(a, -1, 1);

        if (lcaNode != null) {
            System.out.println("LCA of -1 and 1: " + lcaNode.val);
        } else {
            System.out.println("LCA does not exist.");
        }
        maxMinSizeSum(a).display();

    }

    // ---------------------------------------------------------
    // Kth Level
    // ---------------------------------------------------------

    private static void KthLevel(Node root, int level, int k) {

        if (root == null)
            return;

        if (level == k) {
            System.out.print(root.val + " ");
            return;
        }

        KthLevel(root.left, level + 1, k);
        KthLevel(root.right, level + 1, k);
    }

    // ---------------------------------------------------------
    // Level Order Line Wise
    // ---------------------------------------------------------

    private static void levelOrderLineWise(Node root) {

        if (root == null)
            return;

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root, 0));

        int currLevel = 0;

        while (!q.isEmpty()) {

            Pair front = q.remove();

            Node node = front.node;
            int level = front.level;

            if (level != currLevel) {
                System.out.println();
                currLevel = level;
            }

            System.out.print(node.val + " ");

            if (node.left != null) {
                q.add(new Pair(node.left, level + 1));
            }

            if (node.right != null) {
                q.add(new Pair(node.right, level + 1));
            }
        }

        System.out.println();
    }

    // ---------------------------------------------------------
    // Display
    // ---------------------------------------------------------

    private static void display(Node root) {

        if (root == null)
            return;

        System.out.print(root.val + " ");

        display(root.left);
        display(root.right);
    }

    // ---------------------------------------------------------
    // Size of Binary Tree
    // ---------------------------------------------------------

    private static int size(Node root) {

        if (root == null)
            return 0;

        return 1 + size(root.left) + size(root.right);
    }

    // ---------------------------------------------------------
    // Sum of Binary Tree
    // ---------------------------------------------------------

    private static int sum(Node root) {

        if (root == null)
            return 0;

        return root.val + sum(root.left) + sum(root.right);
    }

    // ---------------------------------------------------------
    // Maximum Value
    // ---------------------------------------------------------

    private static int max(Node root) {

        if (root == null)
            return Integer.MIN_VALUE;

        int leftMax = max(root.left);
        int rightMax = max(root.right);

        return Math.max(root.val, Math.max(leftMax, rightMax));
    }

    // ---------------------------------------------------------
    // Minimum Value
    // ---------------------------------------------------------

    private static int min1(Node root) {

        if (root == null)
            return Integer.MAX_VALUE;

        int leftMin = min1(root.left);
        int rightMin = min1(root.right);

        return Math.min(root.val, Math.min(leftMin, rightMin));
    }

    // ---------------------------------------------------------
    // Maximum and Minimum Together
    // ---------------------------------------------------------

    private static Twin maxMin(Node root) {

        if (root == null) {
            return new Twin(
                    Integer.MIN_VALUE,
                    Integer.MAX_VALUE);
        }

        Twin left = maxMin(root.left);
        Twin right = maxMin(root.right);

        int maximum = Math.max(
                root.val,
                Math.max(left.max, right.max));

        int minimum = Math.min(
                root.val,
                Math.min(left.min, right.min));

        return new Twin(maximum, minimum);
    }

    // ---------------------------------------------------------
    // Alternative Maximum Function
    // ---------------------------------------------------------

    private static int max1(Node root) {

        if (root == null)
            return Integer.MIN_VALUE;

        int leftMax = max1(root.left);
        int rightMax = max1(root.right);

        return Math.max(
                root.val,
                Math.max(leftMax, rightMax));
    }

    // ---------------------------------------------------------
    // Number of Levels / Height
    // ---------------------------------------------------------

    private static int levels(Node root) {

        if (root == null)
            return 0;

        return 1 + Math.max(
                levels(root.left),
                levels(root.right));
    }

    // ---------------------------------------------------------
    // Preorder Traversal
    // Root -> Left -> Right
    // ---------------------------------------------------------

    private static void preorder(Node root) {

        if (root == null)
            return;

        System.out.print(root.val + " ");

        preorder(root.left);
        preorder(root.right);
    }

    // ---------------------------------------------------------
    // Inorder Traversal
    // Left -> Root -> Right
    // ---------------------------------------------------------

    private static void inorder(Node root) {

        if (root == null)
            return;

        inorder(root.left);

        System.out.print(root.val + " ");

        inorder(root.right);
    }

    // ---------------------------------------------------------
    // Postorder Traversal
    // Left -> Right -> Root
    // ---------------------------------------------------------

    private static void postorder(Node root) {

        if (root == null)
            return;

        postorder(root.left);
        postorder(root.right);

        System.out.print(root.val + " ");
    }

    // ---------------------------------------------------------
    // Level Order Traversal
    // ---------------------------------------------------------

    private static void levelOrder(Node root) {

        if (root == null)
            return;

        Queue<Node> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {

            Node front = q.remove();

            System.out.print(front.val + " ");

            if (front.left != null) {
                q.add(front.left);
            }

            if (front.right != null) {
                q.add(front.right);
            }
        }

        System.out.println();
    }

    // ---------------------------------------------------------
    // Root-to-Leaf Paths
    // ---------------------------------------------------------

    public static ArrayList<ArrayList<Integer>> Paths(Node root) {

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        dfs(root, new ArrayList<>(), ans);

        return ans;
    }

    private static void dfs(
            Node root,
            ArrayList<Integer> arr,
            ArrayList<ArrayList<Integer>> ans) {

        if (root == null)
            return;

        // Add current node
        arr.add(root.val);

        // If leaf node, store the path
        if (root.left == null && root.right == null) {

            ans.add(new ArrayList<>(arr));

            // Backtracking
            arr.remove(arr.size() - 1);

            return;
        }

        // Visit left subtree
        dfs(root.left, arr, ans);

        // Visit right subtree
        dfs(root.right, arr, ans);

        // Backtracking
        arr.remove(arr.size() - 1);
    }

    // ---------------------------------------------------------
    // Lowest Common Ancestor
    // ---------------------------------------------------------

    private static Node lca(Node root, int p, int q) {

        if (root == null)
            return null;

        // If current node is either p or q
        if (root.val == p || root.val == q)
            return root;

        boolean pLiesInLeft = exists(root.left, p);
        boolean qLiesInLeft = exists(root.left, q);

        // Both nodes are in left subtree
        if (pLiesInLeft && qLiesInLeft) {
            return lca(root.left, p, q);
        }

        // Both nodes are in right subtree
        else if (!pLiesInLeft && !qLiesInLeft) {
            return lca(root.right, p, q);
        }

        // Nodes are on different sides
        else {
            return root;
        }
    }

    // ---------------------------------------------------------
    // Check if a value exists in the tree
    // ---------------------------------------------------------

    private static boolean exists(Node root, int value) {

        if (root == null)
            return false;

        if (root.val == value)
            return true;

        return exists(root.left, value)
                || exists(root.right, value);
    }
}