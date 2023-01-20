package java_problem.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generateParenthesis(3));
    }

}

class Solution {
    private final List<String> ls = new ArrayList<>();
    private final StringBuilder sb = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        getGenerateString(n, 1, 1);
        return ls;
    }

    public void getGenerateString(int n, int open, int close) {
        if (sb.length() == 2 * n) {
            ls.add(sb.toString());
            return;
        }

        if (open <= n) {
            sb.append("(");
            getGenerateString(n, open + 1, close);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (close < open) {
            sb.append(")");
            getGenerateString(n, open, close + 1);
            sb.deleteCharAt(sb.length() - 1);
            return;
        }

    }
}
