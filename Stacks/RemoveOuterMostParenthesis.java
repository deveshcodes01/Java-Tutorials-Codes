public class RemoveOuterMostParenthesis {
    public String removeOuterParentheses(String s) {
        StringBuilder res = new StringBuilder();
        int balance = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                // not an outermost '('
                if (balance > 0)
                    res.append(ch);
                balance++;

            } else {
                balance--;
                // Not an outermost ')'
                if (balance > 0)
                    res.append(ch);
            }
        }
        return res.toString();
    }
}
