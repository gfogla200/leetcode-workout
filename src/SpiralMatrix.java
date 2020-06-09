

/*
*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
* 0,2
* 1,1
Example 2:

* [
*   [1,2,3]
*
* ]
*
Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
0,3
* 1,2
*
*
* [
* [1,   2,   3,   4,   5,   6,   7],
* [24,  25,  26,  27,  28,  29,  8],
* [23,  40,  41,  42,  43,  30,  9],
* [22,  39,  48,  49,  44,  31,  10],
* [21,  38,  47,  46,  45,  32,  11],
* [20,  37,  36,  35,  34,  33,  12],
* [19,  18,  17,  16,  15,  14,  13]
* ]
* 0,6
* 1,5
* 2,4
* 3,3
*
* */

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0)
            return null;

        int r = 0, c = 0;

        while (matrix.length - (2 * r) > 1 && matrix[0].length - (2 * c) > 1) {

            for (int i = c; i < matrix[0].length - c - 1; i++)
                res.add(matrix[r][i]);

            for (int i = r; i < matrix.length - 1 - r; i++)
                res.add(matrix[i][matrix[0].length-1-c]);

            for (int i = matrix[0].length - 1 - c; i > c; i--)
                res.add(matrix[matrix.length - 1 - r][i]);

            for (int i = matrix.length - 1 - r; i > r; i--)
                res.add(matrix[i][c]);

            r++;
            c++;
        }

        if (matrix.length - (2 * r) == 1) {
            for (int i = c; i < matrix[0].length - c; i++)
                res.add(matrix[r][i]);
        } else if (matrix[0].length - (2 * c) == 1) {
            for (int i = r; i < matrix.length - r; i++)
                res.add(matrix[i][c]);
        }

        return res;
    }

    public static void main(String args[]) {

        int[][] arr = new int[][]{
                {6, 9, 2}};
        System.out.println(spiralOrder(arr));
    }
}
