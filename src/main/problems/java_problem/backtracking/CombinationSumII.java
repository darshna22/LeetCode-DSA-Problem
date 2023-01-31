package java_problem.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public static void main(String args[]) {
        int[] nums = new int[]{10, 1, 2, 7, 6, 1, 5};
        System.out.println(new SolutionCom().combinationSum2(nums, 8));
    }
}

class SolutionCom {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        findCombiantions(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }

    void findCombiantions(int ind, int[] nums, int target, List<List<Integer>> ans, ArrayList<Integer> ds) {
        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        for (int i = ind; i < nums.length; i++) {
            if (i > ind && nums[i] == nums[i - 1]) continue;
            if (nums[i] > target) break;
            ds.add(nums[i]);
            findCombiantions(i + 1, nums, target - nums[i], ans, ds);
            ds.remove(ds.size() - 1);
        }
    }
}
