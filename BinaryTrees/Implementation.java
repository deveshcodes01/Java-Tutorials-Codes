package BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    // constructor
    int val;
    // int data;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
    }

    // Node(int data) {
    // this.data = data;
    // }
}

class Pair {
    Node node;
    int level;

    Pair(Node node, int level) {
        this.node = node;
        this.level = level;
    }
}

class Twin {
    int max;
    int min;

    Twin(int max, int min) {
        this.max = max;
        this.min = min;
    }
}

public class Implementation {
    public static void main(String[] args) {
        // 3
        // / \
        // 4 2
        // / \ / \
        // -1 1 6 9
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
        // for (int i = 0; i < levels(a); i++) { //O(n^2)
        // KthLevel(a, 0, i);
        // System.out.println();
        // }
        KthLevel(a, 0, 2);
        levelOrderLineWise(a);
        levelOrder(a);
        preorder(a);
        System.out.println();
        inorder(a);
        System.out.println();
        postorder(a);
        System.out.println();

        display(a);
        System.out.println(size(a));
        System.out.println(sum(a));
        System.out.println(max(a));
        System.out.println(levels(a));
    }

    private static void KthLevel(Node root, int level, int k) {
        if (root == null)
            return;
        if (level == k)
            System.out.print(root.val + " ");
        KthLevel(root.left, level + 1, k);
        KthLevel(root.right, level + 1, k);
    }

    private static void levelOrderLineWise(Node root) {
        Queue<Pair> q = new LinkedList<>();
        int currLevel = 0;
        q.add(new Pair(root, 0));
        while (q.size() > 0) {
            Pair front = q.remove();
            Node node = front.node;
            int level = front.level;
            if (front.level != currLevel) {
                currLevel++;
                System.out.println();
            }
            System.out.print(front.node.val + " ");
            if (node.left != null)
                q.add(new Pair(node.left, level + 1));
            if (node.right != null)
                q.add(new Pair(node.right, level + 1));
        }
        System.out.println();
    }

    private static void display(Node root) {
        if (root == null)
            return;
        System.out.print(root.val + " ");
        display(root.left); // left ki saari values print kar dega ye
        display(root.right); // right ki saari values print kar dega ye

    }

    private static int size(Node root) {
        if (root.left == null && root.right == null)
            return 1;
        // if(root==null) return 0;
        int leftSize = size(root.left);
        int rightSize = size(root.right);
        return 1 + leftSize + rightSize;
        // return (root == null) ? 0 : (1 + size(root.left) + size(root.right));
    }

    private static int sum(Node root) {
        if (root == null)
            return 0; // here zero is working as an additive identity which means that it doesnt
                      // effect the result after addition
        return root.val + sum(root.left) + sum(root.right);
    }

    private static int max(Node root) {
        if (root == null)
            return Integer.MIN_VALUE;
        return Math.max(root.val, Math.max(max(root.left), max(root.right)));
    }

    private static int levels(Node root) {
        if (root == null)
            return 0;
        // if(root.left==null && root.right==null) return 1;
        return 1 + Math.max(levels(root.left), levels(root.right));
    }

    private static int max1(Node root) {
        if (root == null)
            return Integer.MIN_VALUE;
        int leftMax = max(root.left);
        int rightMax = max(root.right);
        return Math.max(root.val, Math.max(leftMax, rightMax));
    }

    private static int min1(Node root) {
        if (root == null)
            return Integer.MAX_VALUE;
        int leftMin = min1(root.left);
        int rightMin = min1(root.right);
        return Math.max(root.val, Math.max(leftMin, rightMin));
    }

    private static Twin maxMin(Node root) {
        if (root == null)
            return new Twin(Integer.MIN_VALUE, Integer.MAX_VALUE);
        Twin left = Math.max(root.val, Math.max(left.max, right.max));
        Twin right = Math.max(root.val, Math.min(left.min, right.min));
        return new Twin(max1(root), min1(root));
    }

    private static void preorder(Node root) {
        if (root == null)
            return;
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    private static void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    private static void postorder(Node root) {

        if (root == null)
            return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val + " ");
    }

    private static void levelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (q.size() > 0) {
            Node front = q.remove();
            System.out.print(front.val + " ");
            if (front.left != null)
                q.add(front.left);
            if (front.right != null)
                q.add(front.right);
        }
        System.out.println();
    }

    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        dfs(root, new ArrayList<>(), ans);
        return ans;
    }

    private static void dfs(Node root, ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> ans) {
        if(root==null) return;
        if(root.left==null && root.right==null)
        {
            arr.add(root.val);
            ArrayList<Integer> list = new ArrayList<>();
            list.addAll(arr);
            ans.add(list);
            arr.remove(arr.size()-1);
            return;

        }
        arr.add(root.val);
        dfs(root.left, arr, ans);
        dfs(root.right, arr, ans);
        arr.remove(arr.size()-1); //backtracking
    }

    Node lca(Node root, int p, int q) {
        if (root == null)
            return null;
        if (root.val == p || root.val == q)
            return root;
        boolean pLiesInLeft = exists(root.left, p);
        boolean qLiesInRight = exists(root.left, p);
        if (pLiesInLeft && !qLiesInRight)
            return lca(root.left, p, q);
        else if (!pLiesInLeft && qLiesInRight)
            return lca(root.right, p, q);
        else
            return root;
    }

    private boolean exists(Node root, int p) {
        if (root == null)
            return false;
        if (root.data == val)
            return true;
        return exists(root.left, val) || exists(root.right, val);

    }

}
