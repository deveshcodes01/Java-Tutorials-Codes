import java.util.Scanner;

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }
}

public class DisplayList {
    public static void displayRec(Node head) {
        if (head == null)
            return;
        System.out.println(head.val + " ");
        displayRec(head.next);
    }
    // --PRINTING A LL IN REVERSE--
    // public static void displayRec(Node head)
    // {
    // if(head == null)return;
    // displayRec(head.next);
    // System.out.println(head.val+" ");

    // }
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
        Scanner sc = new Scanner(System.in);
        Node a = new Node(sc.nextInt()); // head node
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
        // display(a);
        displayRec(a);

        // private static int get(Node head,int idx)
        // {
        // Node temp = head;
        // for(int i=1;i<=idx;i++)
        // {
        // temp=temp.next;
        // }
        // return temp.val;

        // }
        sc.close();
    }
}
