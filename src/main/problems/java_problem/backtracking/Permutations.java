package java_problem.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String args[]) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        if (n == 0) return result;
        for (int i = 0; i < n; i++)
            generatePermutation(nums, result, i, new ArrayList<>(), n);
        return result;
    }

    public static void generatePermutation(int[] nums, List<List<Integer>> result, int index, List<Integer> ls, int n) {
        if (index == n && result.contains(ls)) return;
        if (index == n) {

            if (ls.size() == n) {
                result.add(new ArrayList<>(ls));
                ls.remove(ls.size() - 1);
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!ls.contains(nums[i])) {
                ls.add(nums[i]);
                generatePermutation(nums, result, index + 1, ls, n);
            }
        }

        if (ls.size() > 0)
            ls.remove(ls.size() - 1);
    }

}
