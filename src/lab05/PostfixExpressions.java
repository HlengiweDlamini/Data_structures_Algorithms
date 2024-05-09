package lab05;

import java.util.Stack;

public class PostfixExpressions {
    public static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (Character.isDigit(ch)) {

                stack.push(ch - '0');
            } else {

                int operand2 = stack.pop();
                int operand1 = stack.pop();

                switch (ch) {
                    case '+':
                        stack.push(operand1 + operand2);
                        break;
                    case '-':
                        stack.push(operand1 - operand2);
                        break;
                    case '*':
                        stack.push(operand1 * operand2);
                        break;
                    case '/':
                        stack.push(operand1 / operand2);
                        break;
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {

        String postfixExpression = "12*7+";
        System.out.println("Result of " + postfixExpression + ": " + evaluatePostfix(postfixExpression));
    }
}
