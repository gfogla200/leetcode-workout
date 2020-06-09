

/*
*
You have a map that marks the location of a treasure island. Some of the map area has jagged rocks and dangerous reefs. Other areas are safe to sail in. There are other explorers trying to find the treasure. So you must figure out a shortest route to the treasure island.

Assume the map area is a two dimensional grid, represented by a matrix of characters. You must start from the top-left corner of the map and can move one block up, down, left or right at a time. The treasure island is marked as X in a block of the matrix. X will not be at the top-left corner. Any block with dangerous rocks or reefs will be marked as D. You must not enter dangerous blocks. You cannot leave the map area. Other areas O are safe to sail in. The top-left corner is always safe. Output the minimum number of steps to get to the treasure.

Example:

Input:
[['O', 'O', 'O', 'O'],
 ['D', 'O', 'D', 'O'],
 ['O', 'O', 'O', 'O'],
 ['X', 'D', 'D', 'O']]

Output: 5
Explanation: Route is (0, 0), (0, 1), (1, 1), (2, 1), (2, 0), (3, 0) The minimum route takes 5 steps.
* */

import java.util.HashMap;

public class TreasureIsland {

    public static int TI(char[][] map) {

        boolean[][] visited = new boolean[map.length][map[0].length];
        return bfs(map, 0, 0, 0, visited);
    }

    public static int bfs(char[][] map, int r, int c, int steps, boolean[][] visited) {

        int nr = map.length;
        int nc = map[0].length;

        if (r < 0 || c < 0 || r >= nr || c >= nc || visited[r][c] || map[r][c] == 'D')
            return Integer.MAX_VALUE;

        visited[r][c] = true;

        if (map[r][c] == 'X')
            return steps;

        steps++;

        int dir1 = bfs(map, r + 1, c, steps, visited);
        int dir2 = bfs(map, r - 1, c, steps, visited);
        int dir3 = bfs(map, r, c + 1, steps, visited);
        int dir4 = bfs(map, r, c - 1, steps, visited);

        return Math.min(Math.min(dir1, dir2), Math.min(dir3, dir4));
    }

    public static void main(String args[]) {

        char[][] arr = new char[][]{
                {'O', 'O', 'O', 'O'},
                {'D', 'O', 'D', 'O'},
                {'O', 'O', 'O', 'O'},
                {'X', 'D', 'D', 'O'}};
        System.out.println(TI(arr));
    }
}
