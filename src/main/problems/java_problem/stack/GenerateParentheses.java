package java_problem.stack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {
    static Stack<Character> stack = new Stack<>();
    static List<String> res = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }


    public static List<String> generateParenthesis(int n) {
        backtrack(0, 0, n);
        return res;
    }

    private static void backtrack(int openN, int closedN, int n) {
        if (openN == closedN && closedN == n) {
            Iterator vale = stack.iterator();
            String temp = "";
            while (vale.hasNext()) {
                temp = temp + vale.next();
            }
            res.add(temp);
            return;
        }
        if (openN < n) {
            stack.push('(');
            backtrack(openN + 1, closedN, n);
            stack.pop();
        }
        if (closedN < openN) {
            stack.push(')');
            backtrack(openN, closedN + 1, n);
            stack.pop();
        }
    }
}
