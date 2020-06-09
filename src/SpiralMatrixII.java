

/*
*
Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

Example:

Input: 3
Output:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
* */

public class SpiralMatrixII {

    public static int[][] generateMatrix(int n) {

        if (n == 0)
            return new int[0][0];

        int[][] res = new int[n][n];
        int r = 0, c = 0, j = 1;

        for (int k = 0; k <= n / 2; k++) {

            for (int i = c; i < n - c - 1; i++, j++)
                res[r][i] = j;

            for (int i = r; i < n - 1 - r; i++, j++)
                res[i][n - 1 - c] = j;

            for (int i = n - 1 - c; i > c; i--, j++)
                res[n - 1 - r][i] = j;

            for (int i = n - 1 - r; i > r; i--, j++)
                res[i][c] = j;

            r++;
            c++;
        }

        if(n%2 == 1)
            res[n/2][n/2] = n * n;

        return res;
    }

    public static void main(String args[]) {

        int[][] res = generateMatrix(5);

        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++)
                System.out.print(res[i][j] + "    ");
            System.out.println();
        }
    }
}
