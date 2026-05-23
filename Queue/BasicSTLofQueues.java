package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class BasicSTLofQueues {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(10); // front
        q.add(20);
        q.add(30); // rear
        System.out.println(q + " " + q.peek()); // peek will show front element
        q.remove();
        System.out.println(q + " " + q.size());
        System.out.println(q.remove() + " " + q.size());
    }
}
