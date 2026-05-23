package Queue;

// import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReversalInQueue {
    public void reverseQueue(Queue<Integer> q) {
        // code here
        Stack<Integer> st = new Stack<>();
        while (q.size() > 0) {
            st.push(q.remove());
        }
        while (st.size() > 0) {
            q.add(st.pop());
        } 
    }
}
