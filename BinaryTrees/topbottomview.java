package BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class CustomNode {
    Node node;
    int col;

    CustomNode(Node node, int col) {
        this.node = node;
        this.col = col;
    }
}

public class topbottomview {

    public ArrayList<Integer> bottomView(Node root) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null)
            return res;

        Queue<CustomNode> q = new LinkedList<>();
        q.offer(new CustomNode(root, 0));
        TreeMap<Integer, Integer> map = new TreeMap<>();
        while (!q.isEmpty()) {
            CustomNode customNode = q.poll();
            Node node = customNode.node;
            int col = customNode.col;
            // if (!map.containsKey(col))
            // {
            map.put(col, node.data);
            // }
            if (node.left != null) {
                q.offer(new CustomNode(node.left, col - 1));
            }
            if (node.right != null) {
                q.offer(new CustomNode(node.right, col + 1));
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }

    public ArrayList<Integer> topView(Node root) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null)
            return res;

        Queue<CustomNode> q = new LinkedList<>();
        q.offer(new CustomNode(root, 0));
        TreeMap<Integer, Integer> map = new TreeMap<>();
        while (!q.isEmpty()) {
            CustomNode customNode = q.poll();
            Node node = customNode.node;
            int col = customNode.col;
            if (!map.containsKey(col)) {
                map.put(col, node.data);
            }
            if (node.left != null) {
                q.offer(new CustomNode(node.left, col - 1));
            }
            if (node.right != null) {
                q.offer(new CustomNode(node.right, col + 1));
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }

}
