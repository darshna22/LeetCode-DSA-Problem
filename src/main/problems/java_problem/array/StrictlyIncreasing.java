package java_problem.array;

public class StrictlyIncreasing {
    public static void main(String[] args) {

        int[] nums = new int[]{1,2,3,4, 3 ,5
        };
        boolean b = solution(nums);
        System.out.println(b);
    }

    public static boolean solution(int[] sequence) {
        int n = sequence.length;
        if (n < 2) return true;
        int max = Integer.MIN_VALUE;
        int maxFalseCount = 0;
        for (int val : sequence) {
            if (val > max)
                max = val;
            else
                maxFalseCount++;
        }

        int min = Integer.MAX_VALUE;
        int minFalseCount = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (sequence[i] < min)
                min = sequence[i];
            else
                minFalseCount++;
        }
        return Math.min(minFalseCount,maxFalseCount)<=1;
    }

}
