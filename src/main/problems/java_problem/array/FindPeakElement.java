package java_problem.array;

/*
 * Write a code snippet to find a peak element from array.
 * The peak element in an array is an array element which is not smaller than it's neighbors.
 *  For example, given an array of [6,7,10,12,9] 12 is the peak element of the array.
 * Another example is an array of [8,15,9,2,23,5] in this case, there are two peak elements:15 and 23.
 *
 *
 * */

public class FindPeakElement {
    public static void main(String args[]) {
        int[] array = new int[]{8,15,9,2,23,5};
        findPeakElement(array);
    }

    public static void findPeakElement(int[] array) {
        if (array.length == 0) return;
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;
        boolean leftStop = false;
        boolean rightStop = false;
        int left = 0;
        int right = array.length - 1;
        int n = array.length;
        while (left < n && right >= 0) {
            if (array[left] > leftMax && !leftStop) {
                leftMax = array[left];
            } else {
                leftStop = true;
            }
            if (array[right] > rightMax && !rightStop) {
                rightMax = array[right];
            } else {
                rightStop = true;
            }
            left++;
            right--;
        }
        if (leftMax == rightMax) {
            System.out.println("peak element is " + leftMax);
        } else {
            System.out.println("peak elements are " + leftMax + " " + rightMax);
        }

    }

}
