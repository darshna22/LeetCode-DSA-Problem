package java_problem.twopointer;

import java.util.*;

public class ThreeSum15 {
    public static void main(String[] args) {
        int[] list = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> ls = threeSum(list);
//        for (List<Integer> l : ls)
            System.out.println(ls);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < n - 1; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                for (int k = j + 1; k < n; k++) {
                    if (k != j + 1 && nums[k] == nums[k - 1]) {
                        continue;
                    }
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == 0) {
                        ArrayList<Integer> list = new ArrayList<Integer>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        set.add(list);
                    }
                }
            }
        }
        List<List<Integer>> ls = new ArrayList<List<Integer>>();
        for (List<Integer> lis : set) {
            ls.add(lis);
        }
        return ls;
    }
}
