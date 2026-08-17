import java.util.Stack; // Import Stack and other utility classes

public class EvalRevPolishNotation {
    public int evalRPN(String[] tokens) {

        // Create a stack to store numbers
        Stack<Integer> stack = new Stack<>();

        // Traverse each token in the given array
        for (String token : tokens) {

            // Check if the current token is an operator
            if (token.equals("+") ||
                    token.equals("-") ||
                    token.equals("*") ||
                    token.equals("/")) {

                // Pop the second operand from the stack
                int b = stack.pop();

                // Pop the first operand from the stack
                int a = stack.pop();

                // Variable to store the result of the operation
                int result = 0;

                // Perform the operation based on the operator
                switch (token) {

                    // If operator is +
                    case "+":
                        result = a + b;
                        break;

                    // If operator is -
                    case "-":
                        result = a - b;
                        break;

                    // If operator is *
                    case "*":
                        result = a * b;
                        break;

                    // If operator is /
                    case "/":
                        result = a / b;
                        break;
                }

                // Push the calculated result back into the stack
                stack.push(result);

            } else {

                // If token is a number, convert String to Integer
                int number = Integer.parseInt(token);

                // Push the number into the stack
                stack.push(number);
            }
        }

        // The final value remaining in the stack is the answer
        return stack.pop();
    }
}
