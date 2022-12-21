package java_problem.dynamic_programming;

import java.util.*;

public class NumberPermutation {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        System.out.println(checkInclusion(nums));
    }

    public static List<List<Integer>> checkInclusion(int[] nums) {
        int n = nums.length;
        int totalPermutation = fact(n);
        List<Integer> ls = new ArrayList<>();
        for (int val : nums)
            ls.add(val);
        return findPermutation(totalPermutation, ls);
    }

    public static List<List<Integer>> findPermutation(int totalPermutation, List<Integer> ls) {
        Set<List<Integer>> permutations = new HashSet<>();
        for (int i = 0; i < totalPermutation; i++) {
            List<Integer> numbers = new ArrayList<Integer>(ls);
            int dividend = i;
            List<Integer> permutation = new ArrayList<Integer>();
            for (int divisor = ls.size(); divisor >= 1; divisor--) {
                int q = dividend / divisor;
                int r = dividend % divisor;
                permutation.add(numbers.get(r));
                numbers.remove(r);
                dividend = q;
            }
            permutations.add(permutation);
        }
        return new ArrayList<>(permutations);
    }

    public static int fact(int n) {
        if (n == 1) return n;
        return n * fact(n - 1);
    }
}
