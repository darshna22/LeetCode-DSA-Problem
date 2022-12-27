package java_problem.stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static void main(String args[]) {
        String[] tokens = new String[]{"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        int n = tokens.length;
        Stack<Integer> st = new Stack<Integer>();
        int i = 0;
        while (i < n) {
            switch (tokens[i]) {
                case "+" -> {
                    int val1 = st.pop();
                    int val2 = st.pop();
                    int result = val2 + val1;
                    st.push(result);
                    break;
                }
                case "-" -> {
                    int val1 = st.pop();
                    int val2 = st.pop();
                    int result = val2 - val1;
                    st.push(result);
                    break;
                }
                case "/" -> {
                    int val1 = st.pop();
                    int val2 = st.pop();
                    int result = val2 / val1;
                    st.push(result);
                    break;
                }
                case "*" -> {
                    int val1 = st.pop();
                    int val2 = st.pop();
                    int result = val2 * val1;
                    st.push(result);
                    break;
                }
                default -> {
                    int val = Integer.parseInt(tokens[i]);
                    st.push(val);
                }
            }
            i++;
        }
        return st.pop();
    }
}
