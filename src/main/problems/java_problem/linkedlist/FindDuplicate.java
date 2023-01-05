package java_problem.linkedlist;

public class FindDuplicate {
    public static void main(String[] args) {
        int[] nums= new int[]{1,1,4,3,2};
        System.out.println("duplicate no is :"+findDuplicate(nums));
    }

    public static int findDuplicate(int[] nums) {
        int n = nums.length;
        if (n <= 2) return nums[0];
        int slow = 0;
        int fast = slow+2;
        while (nums[slow]!=nums[fast]) {
            slow=(slow+1)%n;
            fast=(fast+2)%n;
        }
        return nums[slow];
    }
}
