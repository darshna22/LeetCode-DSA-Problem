package java_problem.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {
    public static void main(String args[]) {
        PalindromeSolution palindromeSolution = new PalindromeSolution();
        System.out.println(palindromeSolution.partition("aab"));
    }
}

class PalindromeSolution {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (s.equals("")) {
            res.add(new ArrayList<String>());
            return res;
        }
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s, i + 1)) {
                for (List<String> list : partition(s.substring(i + 1))) {
                    list.add(0, s.substring(0, i + 1));
                    res.add(list);
                }
            }
        }
        return res;
    }

    public boolean isPalindrome(String s, int n) {
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - i - 1)) return false;
        }
        return true;
    }
}

