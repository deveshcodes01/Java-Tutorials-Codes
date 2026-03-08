import java.util.Stack;

public class BasicSTLofStacks {
    public static void main(String[] args) {
        Stack<String> st = new Stack<>();
        System.out.println(st.peek());
        st.pop(); // underflow
        st.push("khushi");
        st.push("preet");
        st.push("rishika");
        st.push("isha");
        st.push("prayas");
        System.out.println(st.size());
        System.out.println(st); // auxillary space = O(n)
        st.pop();
        System.out.println(st + " " + st.size());
        System.out.println(st.peek());
        System.out.println(st.pop()); // it returns the topmost element and removes it
        String s = st.pop(); 
    }
}
