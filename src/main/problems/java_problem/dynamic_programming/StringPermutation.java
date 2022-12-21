package java_problem.dynamic_programming;

import java.util.ArrayList;
import java.util.List;

public class StringPermutation {
    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));
    }

    //return true if s2 contains permutation of s1
    public static boolean checkInclusion(String s1, String s2) {
        int n2 = s2.length();
        int totalPermutation = fact(n2);
        List<String> permutations = findPermutation(totalPermutation, s2);
        return permutations.contains(s1);
    }

    public static List<String> findPermutation(int totalPermutation, String s) {
        List<String> permutations = new ArrayList<>();
        for (int i = 0; i < totalPermutation; i++) {
            StringBuilder sb = new StringBuilder(s);
            int dividend = i;
            StringBuilder permutation = new StringBuilder();
            for (int divisor = s.length(); divisor >= 1; divisor--) {
                int q = dividend / divisor;
                int r = dividend % divisor;
                permutation.append(sb.charAt(r));
                sb.deleteCharAt(r);
                dividend = q;
            }
            permutations.add(String.valueOf(permutation));
        }
        return permutations;
    }

    public static int fact(int n) {
        if (n == 1) return n;
        return n * fact(n - 1);
    }
}
