package java_problem.array;

/*
* There is a two-dimensional array A with n rows and n columns,
* each row of this two-dimensional array is an ordered array from smallest to largest,
*  please merge this two-dimensional array into a one-dimensional ordered array,
* pls write down the CODE SNIPPET.
e.g. 1 : [ [1 2 3] [4 5 6] [7 8 9] ]
e.g. 2 : [ [1 4 7] [2 5 8] [3 6 9] ]
*
*
*
* */

import java.util.Arrays;

public class CreateOneDArray {
    public static void main(String args[]) {
        int[][] twoDArray = new int[][]{{1, 2, 3}, {4, 6, 5}, {10, 8, 9}};
        int[] oneDArray = convert2DArrayTo1D(twoDArray);
        for (int val:oneDArray){
            System.out.print(val+" ");
        }

    }

    public static int[] convert2DArrayTo1D(int[][] twoDArray) {
        int row = twoDArray.length;
        int col = twoDArray[0].length;
        int[] oneDArray = new int[row * col];
        int k = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                oneDArray[k] = twoDArray[i][j];
                k++;
            }
        }

        Arrays.sort(oneDArray);
        return oneDArray;
    }
}
