

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

import javafx.geometry.Pos;

import java.util.LinkedList;
import java.util.Queue;

public class TreasureIslandII {
    static class Position {
        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static int TI(char[][] map) {

        Queue<Position> q = new LinkedList<>();
        boolean[][] visited = new boolean[map.length][map[0].length];
        int[][] currentMap = new int[map.length][map[0].length];

        for (int i=0;i<map.length;i++){
            for (int j =0;j<map[0].length;j++){
                if(map[i][j] == 'S'){
                    visited[i][j] = true;
                    q.offer(new Position(i, j));
                }
            }
        }
        int res = Integer.MAX_VALUE;
        while (!q.isEmpty()){
            Position p = q.poll();
            int pathLength = Math.min(
                    Math.min(bfs(map, p.x+1, p.y, 1, visited, currentMap), bfs(map, p.x-1, p.y, 1, visited, currentMap)),
                    Math.min(bfs(map, p.x, p.y+1, 1, visited, currentMap), bfs(map, p.x, p.y+1, 1, visited, currentMap)));

            res = Math.min(res, pathLength);
        }

        return res;
    }

    public static int bfs(char[][] map, int r, int c, int steps, boolean[][] visited, int[][] currentMap) {

        int nr = map.length;
        int nc = map[0].length;

        if (r < 0 || c < 0 || r >= nr || c >= nc || map[r][c] == 'D' || map[r][c] == 'S')
            return Integer.MAX_VALUE;

        if (!visited[r][c]){
            visited[r][c] = true;
            currentMap[r][c] = steps;
        }
        else {
            if (steps > currentMap[r][c])
                return Integer.MAX_VALUE;
            else
                currentMap[r][c] = steps;
        }

        if (map[r][c] == 'X')
            return steps;

        steps++;

        int dir1 = bfs(map, r + 1, c, steps, visited, currentMap);
        int dir2 = bfs(map, r - 1, c, steps, visited, currentMap);
        int dir3 = bfs(map, r, c + 1, steps, visited, currentMap);
        int dir4 = bfs(map, r, c - 1, steps, visited, currentMap);

        return Math.min(Math.min(dir1, dir2), Math.min(dir3, dir4));
    }

    public static void main(String args[]) {

        char[][] arr = new char[][]{
                {'S', 'O', 'O', 'S', 'S'},
                {'D', 'O', 'D', 'O', 'D'},
                {'O', 'O', 'X', 'O', 'O'},
                {'X', 'D', 'D', 'S', 'O'},
                {'X', 'D', 'D', 'D', 'O'}};
        System.out.println(TI(arr));
    }
}
