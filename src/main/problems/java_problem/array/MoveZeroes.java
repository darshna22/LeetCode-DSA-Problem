package java_problem.array;

import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args){
        moveZeroes(new int[]{1,0,2,0,3,4});
    }

    public static void moveZeroes(int[] nums) {
        Arrays.sort(nums);
        if(nums.length>1){
            int zeroCount=0;
            for(int value:nums){
                if(value!=0){
                    break;
                }
                zeroCount++;
            }
            if(zeroCount>0){
                int k=0;
                int i=zeroCount;
                while(i<nums.length){
                    nums[k]=nums[i];
                    k++;
                    i++;
                }
                while(zeroCount>0){
                    nums[k]=0;
                    k++;
                    zeroCount--;
                }
            }
        }

    }
}
