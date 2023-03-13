package java_problem.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class Palindrom {
    // Online Java Compiler
// Use this editor to write, compile and run your Java code online
    public static void main(String[] args) {
        HashSet<List<String>> res = new HashSet<List<String>>();
        SolutionPalindrome solutionPalindrome=new SolutionPalindrome();
        String s = "cdd";
        solutionPalindrome.partition(s, res);
        System.out.println(res);
    }


}
class SolutionPalindrome {

    public List<List<String>> partition(String s,HashSet<List<String>> res) {
        int n = s.length();
        if(n==0) return new ArrayList<List<String>>();
        partition(s, 0, new ArrayList<String>(),res);
        return new ArrayList(res);
    }

    public void partition(String s, int start, List<String> ls,HashSet<List<String>> res) {

        if (start == s.length())  {
            res.add(new ArrayList<String>(ls));
        };

        for (int end = start; end < s.length(); end++) {
            if(isPalindrome(s, start, end)) {
                ls.add(s.substring(start, end+1));
                partition(s, end+1, ls,res);
                ls.remove(ls.size()-1);
            }
        }

    }

    public boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}


