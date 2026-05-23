import java.util.Stack;

public class ReverseStack {
public static void reverseStack(Stack<Integer> st) {
    if (st.size() <= 1)
        return;

    int top = st.pop();

    reverseStack(st);
    pushAtBottom(st, top);
}

public static void pushAtBottom(Stack<Integer> st,int ele)
{
    if(st.size()==0)
    {
        st.push(ele);
        return;
    }
    int top=st.pop();
    pushAtBottom(st, ele);
    st.push(top);
}
}
