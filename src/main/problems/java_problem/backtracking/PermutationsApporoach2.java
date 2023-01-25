package java_problem.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PermutationsApporoach2 {
    public static void main(String args[]) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(new PermutationsSolution().permute(nums));
    }
}

class PermutationsSolution {

    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        int totalPermutation = fact(n);
        List<Integer> ls = new ArrayList<>();
        for (int val : nums)
            ls.add(val);
        return findPermutation(totalPermutation, ls);
    }

    public List<List<Integer>> findPermutation(int totalPermutation, List<Integer> ls) {
        List<List<Integer>> permutations = new ArrayList<>();
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
        return permutations;
    }

    public static int fact(int n) {
        if (n == 1) return n;
        return n * fact(n - 1);
    }
}
