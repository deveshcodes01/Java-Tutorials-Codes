package Queue;

import java.util.Queue;

public class ReverseKQueueElements {
    // Complexity: Runs in O(N) time and uses O(k) auxiliary space on the recursion
    // call stack.
    public Queue<Integer> reverseFirstK(Queue<Integer> q, int k) {
        // Base validation: If k is invalid or greater than the queue size, return queue
        // as-is
        if (k <= 0 || k > q.size()) {
            return q;
        }

        // Step 1: Use the call stack via recursion to reverse the first k elements
        // and place them at the back of the queue
        moveKToEnd(q, k);

        // Step 2: The remaining (size - k) elements are now at the front in original
        // order.
        // Move them one by one to the back so the reversed k elements return to the
        // front.
        int remaining = q.size() - k;
        while (remaining-- > 0) {
            int x = q.poll(); // Remove front element
            q.add(x); // Re-insert it at the rear
        }

        return q;
    }

    // Helper method: Reverses the first k elements by leveraging the recursion
    // stack
    static void moveKToEnd(Queue<Integer> q, int k) {
        // Base case: Stop when all k elements have been popped off
        if (k == 0) {
            return;
        }

        // Dequeue the front element and hold it in the current stack frame
        int e = q.poll();

        // Recursively process the remaining (k - 1) elements
        moveKToEnd(q, k - 1);

        // On the unwind phase (LIFO order), push the held element to the back of the
        // queue
        q.add(e);
    }
}
