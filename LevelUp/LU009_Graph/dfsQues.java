import java.util.*;

public class dfsQues {


    // cycle detection dfs in undireted graph
    public boolean dfs(int src , boolean[] vis,ArrayList<ArrayList<Integer>> adj,int parent ){
        
        vis[src] = true;
        
        for(int nbr : adj.get(src)){
            
            if(!vis[nbr]){
                if(dfs(nbr,vis,adj,src)) return true;
            }
            
           else if(parent!=nbr) return true; // if parent == nbr => this is the node we came from our previous node
        }
        
        return false;
    }
    
    
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        
        boolean[] vis = new boolean[V];
        
        for(int i=0;i<V;i++){
            if(!vis[i]){
                boolean flag = dfs(i,vis,adj,-1);
                
                if(flag == true) return true;
            }
        }
        
        return false;
    }

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
    // here we will start from boundary of the grid so that all connected O's
    // forming a component from boundary will be marked as 'B'
    // now all the remaning O's component are fully covered by X hence they will be
    // converted into X and 'B's would aging be turned to O
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

    public boolean dfs2(int[][] grid1, int[][] grid2, int i, int j, int n, int m) {

        boolean ans = (grid1[i][j] == grid2[i][j]);

        grid2[i][j] = 0;
        for (int[] d : dirs) {
            int r = i + d[0];
            int c = j + d[1];

            if (r >= 0 && c >= 0 && r < n && c < m && grid2[r][c] == 1) {
                ans = dfs2(grid1, grid2, r, c, n, m) && ans;
            }
        }

        return ans;
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {

        int count = 0;
        int n = grid1.length;
        int m = grid1[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid2[i][j] == 1) {
                    boolean isSub = dfs2(grid1, grid2, i, j, n, m);
                    if (isSub)
                        count++;
                }
            }
        }

        return count;

    }

    // 1020

    // here we are moving from boundary to interior

    int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public void dfs03(int[][] grid, int i, int j) {

        grid[i][j] = -1;
        for (int[] d : dir) {
            int r = i + d[0];
            int c = j + d[1];

            if (r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == 1) {
                dfs03(grid, r, c);
            }
        }
    }

    public int numEnclaves(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        // marking boundary islands with -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                        dfs03(grid, i, j);
                    }
                }

            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1)
                    count++;
            }
        }

        return count;
    }

    // https://www.hackerrank.com/challenges/journey-to-the-moon/problem?isFullScreen=true

    public static long dfs_size(int src, List<List<Integer>> graph, boolean[] vis) {

        int size = 0;
        vis[src] = true;
        for (int nbr : graph.get(src)) {
            if (!vis[nbr]) {
                size += dfs_size(nbr, graph, vis);
            }
        }

        return size + 1;
    }

    public static long journeyToMoon(int n, List<List<Integer>> astronaut) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(i, new ArrayList<>());
        }

        for (List<Integer> edges : astronaut) {

            graph.get(edges.get(0)).add(edges.get(1));
            graph.get(edges.get(1)).add(edges.get(0));

        }

        boolean[] vis = new boolean[n];

        long total_size = 0;
        long ans = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {

                long size = dfs_size(i, graph, vis);
                // maths -> let say we have 4 components of size 4 3 3 2 -> so total possible
                // ways = 4*3 + (4*3 + 3*3) + (4*2 +3*2 +3*2)=>4*3 +(4+3)*3 + (4+3+3)*2
                ans = ans + total_size * size;
                total_size += size;
            }
        }

        return ans;

    }

    // 207

    public boolean dfs_topo(int[] vis , ArrayList<Integer>[] graph,int src){
        vis[src] = 1;

        for(int nbr : graph[src]){
            if(vis[nbr] == 0){
                boolean cycle = dfs_topo(vis, graph, nbr);
                if(cycle) return true;
            }else if(vis[nbr] == 1){
                return true ; // cycle
            }
        }

        // we are marking 2 bcoz this will not give the cycle but from here on all vertices are already added in topological order
        vis[src] = 2; // that means we have found the path from this point
        return false;
    }

    public boolean canFinish(int V, int[][] prerequisites) {

        ArrayList<Integer>[] graph = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] v : prerequisites) {
            graph[v[0]].add(v[1]);
        }

        int[] vis = new int[V];

        for(int i=0;i<V;i++){
            if(vis[i]==0){
               boolean isCycle = dfs_topo(vis,graph,i);
               if(isCycle) return false;
            }
        }

        return true;
    }

}
