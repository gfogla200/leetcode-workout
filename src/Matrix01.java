

/*
*
Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.



Example 1:

Input:
[[0,0,0],
 [0,1,0],
 [0,0,0]]

Output:
[[0,0,0],
 [0,1,0],
 [0,0,0]]
Example 2:

Input:
[[0,0,0],
 [0,1,0],
 [1,1,1]]

Output:
[[0,0,0],
 [0,1,0],
 [1,2,1]]


Note:

The number of elements of the given matrix will not exceed 10,000.
There are at least one 0 in the given matrix.
The cells are adjacent in only four directions: up, down, left and right.
*
* */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {

    static class Position {
        int x;
        int y;
        int dist;

        Position(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public static int[][] updateMatrix(int[][] matrix) {

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int[][] res = new int[matrix.length][matrix[0].length];
        Queue<Position> q = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    res[i][j] = 0;
                    visited[i][j] = true;
                    q.offer(new Position(i, j, 0));
                }
            }
        }


        while (!q.isEmpty()) {
            Position p = q.poll();
            int x = p.x;
            int y = p.y;
            int dist = p.dist + 1;

            if (x - 1 >= 0 && !visited[x - 1][y] && matrix[x - 1][y] != 0) {
                visited[x - 1][y] = true;
                res[x - 1][y] = dist;
                q.offer(new Position(x - 1, y, dist));
            }

            if (y - 1 >= 0 && !visited[x][y - 1] && matrix[x][y - 1] != 0) {
                visited[x][y - 1] = true;
                res[x][y - 1] = dist;
                q.offer(new Position(x, y - 1, dist));
            }

            if (x + 1 < matrix.length && !visited[x + 1][y] && matrix[x + 1][y] != 0) {
                visited[x + 1][y] = true;
                res[x + 1][y] = dist;
                q.offer(new Position(x + 1, y, dist));
            }

            if (y + 1 < matrix[0].length && !visited[x][y + 1] && matrix[x][y + 1] != 0) {
                visited[x][y + 1] = true;
                res[x][y + 1] = dist;
                q.offer(new Position(x, y + 1, dist));
            }

        }

        return res;
    }

    public static void main(String args[]) {

        int[][] arr = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}};
        int[][] res = updateMatrix(arr);
        for (int i = 0; i < res.length; i++){
            for (int j = 0; j < res[0].length; j++)
                System.out.print(res[i][j]+" ");
            System.out.println();
        }
    }
}
