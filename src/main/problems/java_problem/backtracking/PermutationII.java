package java_problem.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationII {
    public static void main(String args[]) {
        int[] nums = new int[]{1,2,2};
        System.out.println(new SolutionII().subsetsWithDup(nums));
    }
}

class SolutionII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
//        for (int i = 0; i < nums.length; i++) {
//            List<Integer> list = new ArrayList<>();
//            subSet(nums, i, ans, list);
//        }
        subSet(nums, 0, ans, new ArrayList<>());


        return ans;
    }

    public void subSet(
            int[] nums,
            int idx,
            List<List<Integer>> ans,
            List<Integer> list
    ) {
        ans.add(new ArrayList<>(list));

        for (int i = idx; i < nums.length; i++) {
            //skip the duplicate elements
            if (i > idx && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
            subSet(nums, i + 1, ans, list);
            list.remove(list.size() - 1);
        }

//        if (idx >= nums.length) {
//            if (!ans.contains(list)) {
//                ans.add(new ArrayList<>(list));
//            }
//
//            return;
//        }
//
//        list.add(nums[idx]);
//        if (!ans.contains(list)) {
//            ans.add(new ArrayList<>(list));
//        }
//
//        subSet(nums, idx + 1, ans, list);
//        list.remove(list.size() - 1);
//        subSet(nums, idx + 1, ans, list);
    }
}
