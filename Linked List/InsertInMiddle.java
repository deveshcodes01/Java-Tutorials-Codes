public class InsertInMiddle {
    public Node insertMid(Node head, int x) {
        if (head == null)
            return new Node(x);
        Node slow = head; // slow pointer
        Node fast = head; // fast pointer
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next; // move slow one step
            fast = fast.next.next; // move fast two step
        }
        // create a newNode with value x
        Node newNode = new Node(x);
        newNode.next = slow.next;
        slow.next = newNode;
        return head;
    }
}
