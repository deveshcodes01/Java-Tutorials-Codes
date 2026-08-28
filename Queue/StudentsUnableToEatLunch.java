package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StudentsUnableToEatLunch {
    // METHOD 1
    public int countStudents(int[] students, int[] sandwiches) {
        // int[] count=new int[2];
        // for(int student:students)
        // {
        // count[student]++;
        // }
        // for(int sandwich:sandwiches)
        // {
        // if(count[sandwich]==0) break;
        // count[sandwich]--;
        // }

        // return count[0]+count[1];
        // METHOD 2
        Stack<Integer> st = new Stack<>();
        int n1 = sandwiches.length;
        for (int i = n1 - 1; i >= 0; i--) {
            st.push(sandwiches[i]);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int s : students) {
            q.add(s);
        }
        int rotations = 0;
        while (!q.isEmpty() && rotations < q.size()) {
            if (q.peek().equals(st.peek())) {
                q.poll();
                st.pop();
                rotations = 0;
            } else {
                q.add(q.poll());
                rotations++;
            }
        }
        return q.size();
    }

}
