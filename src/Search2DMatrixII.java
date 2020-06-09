

/*
*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
Example:

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.

Given target = 20, return false.
*
* */

import java.util.HashMap;

public class Search2DMatrixII {

    public static boolean searchMatrix(int[][] matrix, int target) {

        int r = matrix.length-1;
        int c = 0;
        while (r>=0 && c<matrix[0].length){

            if (matrix[r][c] < target){
                c++;
            }
            else if (matrix[r][c] > target){
                r--;
            }
            else
                return true;

        }
        return false;
    }

    public static void main(String args[]) {

        int[][] arr = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(searchMatrix(arr, 11));
    }
}
