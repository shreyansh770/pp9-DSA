import java.util.*;

public class dfsQues {

    // 200
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int islandCount = 0;

        int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && visited[i][j] == false) {
                    countIsLand(grid, i, j, visited, dir);
                    islandCount++;
                }
            }
        }

        return islandCount;
    }

    public void countIsLand(char[][] grid, int i, int j, boolean[][] visited, int[][] dir) {
        visited[i][j] = true;

        for (int d = 0; d < dir.length; d++) {
            int r = i + dir[d][0];
            int c = j + dir[d][1];

            if (r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == '1'
                    && visited[r][c] == false) {
                countIsLand(grid, r, c, visited, dir);
            }
        }
    }

    // 695
    public int countIsLand(int[][] grid, int i, int j, boolean[][] visited, int[][] dir) {
        visited[i][j] = true;
        int size = 0;
        for (int d = 0; d < dir.length; d++) {
            int r = i + dir[d][0];
            int c = j + dir[d][1];

            if (r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == 1
                    && visited[r][c] == false) {
                size += countIsLand(grid, r, c, visited, dir);
            }
        }

        return size + 1;
    }

    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int maxSize = 0;

        int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && visited[i][j] == false) {
                    int s = countIsLand(grid, i, j, visited, dir);
                    maxSize = Math.max(s, maxSize);
                }
            }
        }

        return maxSize;
    }

    // 463
    public int islandPerimeter(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int count = 0;
        int[][] dir = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    for (int[] d : dir) {
                        int x = i + d[0], y = j + d[1];
                        if (x < 0 || y < 0 || x == m || y == n || grid[x][y] == 0) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    // 130
    // here we will start from boundary of the grid so that all connected O's forming a component from boundary will be marked as 'B'
    // now all the remaning O's component are fully covered by X hence they will be converted into X and 'B's would aging be turned to O
    public void dfs(int sr, int sc, char[][] board) {

        board[sr][sc] = 'B';

        int[][] dirs = { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } };
        for (int[] d : dirs) {
            int r = sr + d[0];
            int c = sc + d[1];

            if (r >= 0 && c >= 0 && r < board.length && c < board[0].length && board[r][c] == 'O') {
                dfs(r, c, board);
            }
        }
    }

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                    if (board[i][j] == 'O') {
                        dfs(i, j, board);
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'B') {
                    board[i][j] = 'O';
                }
            }
        }

    }


    // 1905

    int[][] dirs = { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } };
    public boolean dfs2(int[][] grid1, int[][] grid2,int i , int j , int n , int  m){

        boolean ans = (grid1[i][j] == grid2[i][j]);

        
        grid2[i][j] = 0;
        for (int[] d : dirs) {
            int r = i + d[0];
            int c = j + d[1];

            if (r >= 0 && c >= 0 && r < n && c < m && grid2[r][c] == 1 ) {
              ans = dfs2(grid1, grid2, r, c, n, m) && ans;
            }
        }

        return ans;
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        
        int count = 0;
        int n = grid1.length;
        int m = grid1[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid2[i][j] == 1){
                    boolean isSub = dfs2(grid1, grid2, i, j, n, m);
                    if(isSub) count++;
                }
            }
        }

        return count;

    }

}
