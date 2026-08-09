class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class FloydsDetectionCycle {

    /**
     * Detects if a linked list contains a cycle.
     * 
     * @param head Head node of the linked list
     * @return true if a cycle exists, false otherwise
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next; // Move 1 step
            fast = fast.next.next; // Move 2 steps

            // If the two pointers meet, a cycle exists
            if (slow == fast) {
                return true;
            }
        }

        // Fast pointer reached the end, so no cycle exists
        return false;
    }

    public static void main(String[] args) {
        // Example setup: 1 -> 2 -> 3 -> 4 -> 2 (cycle back to node with value 2)
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        // Create a cycle (4 points back to node 2)
        head.next.next.next.next = head.next;

        boolean result = hasCycle(head);
        System.out.println("Cycle detected: " + result); // Output: true
    }
}