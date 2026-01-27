class Node {
    int val;
    Node next; // null

    Node(int val) {
        this.val = val;
    }
}

public class NodeOfLinkedList {
    public static void main(String[] args) {
        // 10 20 30 40 50
        Node a = new Node(10); // Node@28a418fc
        Node b = new Node(20);
        Node c = new Node(30);
        Node d = new Node(40);
        Node e = new Node(50);
        // Connect krenge (link krenge)
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        // e.next = null; not required as e's next is null by default
        System.out.println(a);
        System.out.println(b);
        System.out.println(a.next);

        System.out.println(a.next.next.next.val);
        System.out.println(c);
        System.out.println(b.next);
        System.out.println(a.next.next);
    }
}
