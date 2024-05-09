package lab05;

import java.util.*;
public class StringParentheses {

    public static void main(String[] args) {
        String str;
        int i, length;
        char ch;
        Scanner s = new Scanner(System.in);

        System.out.print("Enter the String: ");
        str = s.next();

        Stack<Character> st = new Stack<Character>();
        length = str.length();

        for (i = 0; i < length; i++) {
            ch = str.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else if (ch == ')') {
                if (st.isEmpty() || st.pop() != '(') {
                    System.out.println("\nUnbalanced Parentheses!");
                    return;
                }
            } else if (ch == '}') {
                if (st.isEmpty() || st.pop() != '{') {
                    System.out.println("\nUnbalanced Parentheses!");
                    return;
                }
            } else if (ch == ']') {
                if (st.isEmpty() || st.pop() != '[') {
                    System.out.println("\nUnbalanced Parentheses!");
                    return;
                }
            }
        }
        if (st.isEmpty())
            System.out.println("\nBalanced Parentheses.");
    }
}
