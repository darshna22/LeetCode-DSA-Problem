package java_problem.string;

public class LongestConsecutive {
    static int[] b;

    public static void main(String args[]) {
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive(nums));
    }


    public static int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 1) return 1;
        b = new int[n];
        mergeSort(nums, 0, n - 1);
        int pre = nums[0];
        int count = 0;
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            if (pre == nums[i])
                continue;
            else if ((pre + 1) == nums[i]) {
                count++;
                max = Math.max(max, count);

            } else {

                count = 0;
            }
            pre = nums[i];
        }
        return max+1;

    }

    public static void mergeSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            merge(nums, left, right, mid);
        }
    }

    public static void merge(int nums[], int left, int right, int mid) {
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) {
                b[k] = nums[i];
                i++;
            } else {
                b[k] = nums[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            b[k] = nums[i];
            i++;
            k++;
        }

        while (j <= right) {
            b[k] = nums[j];
            j++;
            k++;
        }

        while (left <= right) {
            nums[left] = b[left];
            left++;
        }


    }
}
