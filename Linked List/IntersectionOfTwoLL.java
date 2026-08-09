public class IntersectionOfTwoLL {

    // --GFG code
    public static Node intersectPoint(Node head1, Node head2) {
        if (head1 == null || head2 == null)
            return null;

        // attach second list to the
        // end of the first
        Node temp = head1;
        while (temp.next != null)
            temp = temp.next;
        temp.next = head2;

        // detect cycle using Floyd’s algorithm
        Node slow = head1;
        Node fast = head1;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                slow = head1;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }

        return null;
    }

    // LEETCODE code
    public ListNode getIntersectionNode(ListNode head1, ListNode head2) {
        int len1 = 0;
        ListNode temp1 = head1;
        while (temp1 != null) {
            temp1 = temp1.next;
            len1++;
        }
        int len2 = 0;
        ListNode temp2 = head2;
        while (temp2 != null) {
            temp2 = temp2.next;
            len2++;
        }
        temp1 = head1;
        temp2 = head2;
        if (len1 > len2) { // move temp1 forward
            for (int i = 1; i <= len1 - len2; i++) {
                temp1 = temp1.next;
            }
        } else { //move temp2 forward
            for (int i = 1; i <= len2 - len1; i++) {
                temp2 = temp2.next;
            }
        }
        while (temp1 != temp2) {
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return temp1;
    }
}
