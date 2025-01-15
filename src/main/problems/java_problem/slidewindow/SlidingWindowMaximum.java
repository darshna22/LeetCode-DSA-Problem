package java_problem.slidewindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SlidingWindowMaximum {
    public static void main(String args[]) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int r = 0;
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        List<Integer> list = new ArrayList<>();
        while (r <= n - k) {
            for (int i = 0; i < k; i++) {
                max = Math.max(max, nums[r + i]);
            }
            list.add(max);
            r++;
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

}
