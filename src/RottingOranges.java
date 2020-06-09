

/*
*
In a given grid, each cell can have one of three values:

the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.

Example 1:

Input: [[2,1,1],[1,1,0],[0,1,1]]
Output: 4

Example 2:

Input: [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.

Example 3:

Input: [[0,2]]
Output: 0
Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.


Note:

1 <= grid.length <= 10
1 <= grid[0].length <= 10
grid[i][j] is only 0, 1, or 2.

*
* */

import java.util.HashMap;

public class RottingOranges {

    public static int orangesRotting(int[][] grid) {

        if (grid.length == 0)
            return 0;

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int minutes = 0;

        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2){
                    minutes = bfs(grid, i, j, minutes, visited);
                }
            }

        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] == 1)
                    return -1;

        return minutes;
    }

    public static int bfs(int[][] grid, int r, int c, int minutes, boolean[][] visited) {


        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == 0 || visited[r][c] == true)
            return minutes;

        visited[r][c] = true;

        if (grid[r][c] == 1) {
            grid[r][c] = 2;
            ++minutes;
        }

        minutes = bfs(grid, r - 1, c, minutes, visited);
        minutes = bfs(grid, r + 1, c, minutes, visited);
        minutes = bfs(grid, r, c - 1, minutes, visited);
        minutes = bfs(grid, r, c + 1, minutes, visited);

        return minutes;
    }

    public static void main(String args[]) {

        int[][] arr = new int[][]{
                {2},
                {1},
                {1},
                {2}
        };
        System.out.println(orangesRotting(arr));
    }
}
