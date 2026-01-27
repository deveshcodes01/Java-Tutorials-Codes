class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }
}

public class DisplayList {
    public static void display(Node head) { // BY USING WHILE LOOP (MAJORLY WE WILL USE WHILE LOOP)
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.val + " ");
            temp = temp.next; // VERY IMPORTANT
        }
        System.out.println();
    }

    // BY USING FOR LOOP
    // for(Node temp = head;temp != null;temp = temp.next)
    // {
    // System.out.println(temp.val+" ");
    // }
    public static void main(String[] args) {
        Node a = new Node(10); // head node
        Node b = new Node(200);
        Node c = new Node(30);
        Node d = new Node(40);
        Node e = new Node(50);
        Node f = new Node(5);
        // Connect krenge (link krenge)
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        display(a);
    }
}
