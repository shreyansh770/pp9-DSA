import java.util.*;

public class bfsQues {

    // initially we are adding all the rotten oranges into our que
    // this will rot all the fresh oranges in its neigbhour in 1st sec
    // now rotten neighbour will further rot its nearby fresh oranges so on and so
    // forth
    // unless the count of fresh oranges does'nt become zero

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int time = 0;
        LinkedList<Integer> que = new LinkedList<>();
        int freshOranges = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {

                    que.addLast(i * m + j); // indexes of all the rotten oranges

                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        if (freshOranges == 0)
            return 0; // if we have no fresh oranges

        int[][] dirs = { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } };

        while (que.size() != 0) {
            int s = que.size();

            while (s-- > 0) {
                int idx = que.removeFirst();

                int i = idx / m;
                int j = idx % m;

                for (int[] d : dirs) {
                    int r = i + d[0];
                    int c = j + d[1];

                    if (r >= 0 && c >= 0 && r < n && c < m && grid[r][c] == 1) {
                        grid[r][c] = 2;// rot it
                        que.addLast(r * m + c);
                        freshOranges--;

                        if (freshOranges == 0)
                            return time + 1;
                    }
                }
            }

            time++;
        }

        return -1;
    }

    // 785
    // colors[i] == 0 => blue
    // colors[i] == 1 => green

    // when we encounter a cycle at particular node if it has the same color as it
    // had before that means its level at which it is being encountered is same =>
    // it is an even node cycle hence bipartite else odd node cycle => non bipartite

    public boolean bfs_bipartite(int[][] graph, int src, int[] colors) {

        int c = 0; // starting with blue color

        LinkedList<Integer> que = new LinkedList<>();
        que.addLast(src);

        while (que.size() != 0) {
            int s = que.size();

            while (s-- > 0) {
                int u = que.removeFirst();

                if (colors[u] != -1) {
                    if (colors[u] != c)
                        return false; // odd cycle

                    continue;
                }

                colors[u] = c;

                for (int v : graph[u]) {
                    if (colors[v] == -1) {
                        que.addLast(v);
                    }
                }
            }
            c = (c + 1) % 2; // 0->1->0->1....

        }

        return true;

    }

    public boolean isBipartite(int[][] graph) {

        int n = graph.length;

        int[] colors = new int[n];
        Arrays.fill(colors, -1);

        for (int i = 0; i < n; i++) {
            if (colors[i] == -1) {
                boolean isBipartite = bfs_bipartite(graph, i, colors);

                if (isBipartite == false)
                    return false;
            }
        }

        return true;

    }

    // 1020 -> bfs (boundary to interior)

    int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public void bfs_convert(int[][] grid, int i, int j) {

        int n = grid.length;
        int m = grid[0].length;
        LinkedList<Integer> q = new LinkedList<>();
        q.addLast(i * m + j);

        grid[i][j] = 0;
        while (q.size() != 0) {
            int s = q.size();

            while (s-- > 0) {
                int idx = q.removeFirst();

                i = idx / m;
                j = idx % m;

                for (int[] d : dir) {
                    int r = i + d[0];
                    int c = j + d[1];

                    if (r >= 0 && c >= 0 && r < n && c < m && grid[r][c] == 1) {
                        grid[r][c] = 0;
                        q.addLast(r * m + c);
                    }
                }
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
                        bfs_convert(grid, i, j);
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

    // 1020 bfs interior to exterior

    public int bfs_count(int[][] grid, int i, int j) {

        int n = grid.length;
        int m = grid[0].length;
        LinkedList<Integer> q = new LinkedList<>();
        q.addLast(i * m + j);

        int count = 1;
        grid[i][j] = 0;
        boolean reached_boundary = false;
        while (q.size() != 0) {
            int s = q.size();

            while (s-- > 0) {
                int idx = q.removeFirst();

                int x = idx / m;
                int y = idx % m;

                for (int[] d : dir) {
                    int r = x + d[0];
                    int c = y + d[1];

                    // we have reached boundary
                    if (!(r >= 0 && c >= 0 && r < n && c < m)) {
                        reached_boundary = true;
                    }

                    else if (r >= 0 && c >= 0 && r < n && c < m && grid[r][c] == 1) {
                        grid[r][c] = 0;
                        count++;
                        q.addLast(r * m + c);
                    }
                }
            }
        }

        if (reached_boundary || i == 0 || j == 0 || i == n - 1 || j == m - 1) {
            return 0;
        } else {
            return count;
        }
    }

    public int numEnclaves_(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        // marking boundary islands with -1;

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1)
                    count += bfs_count(grid, i, j);
            }
        }

        return count;
    }

    // 542
    public int[][] updateMatrix(int[][] mat) {

        LinkedList<int[]> que = new LinkedList<>();
        int N = mat.length;
        int M = mat[0].length;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (mat[i][j] == 0) {
                    que.addLast(new int[] { i, j }); // adding multiple source for BFS
                } else {
                    mat[i][j] = -1;// not visited
                }
            }
        }

        int lvl = 0;

        int[][] dir = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

        while (que.size() != 0) {
            int qs = que.size();
            lvl++;
            while (qs-- > 0) {

                int[] cell = que.removeFirst();

                for (int[] d : dir) {

                    int r = cell[0] + d[0];
                    int c = cell[1] + d[1];

                    if (r >= 0 && c >= 0 && r <= N - 1 && c <= M - 1 && mat[r][c] == -1) {
                        mat[r][c] = lvl;
                        que.addLast(new int[] { r, c });
                    }
                }

            }

        }

        return mat;
    }

    // 207
    public boolean canFinish(int V, int[][] prerequisites) {

        int[] indeg = new int[V];
        ArrayList<Integer>[] graph = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] v : prerequisites) {

            indeg[v[1]]++;
            graph[v[0]].add(v[1]);
        }

        LinkedList<Integer> q = new LinkedList<>();
        ArrayList<Integer> topo = new ArrayList<>();

        for (int i = 0; i < indeg.length; i++) {
            // System.out.print(indeg[i]+" ");
            if (indeg[i] == 0) {
                q.addLast(i);
            }
        }

        while (q.size() > 0) {
            int ele = q.removeFirst();

            topo.add(ele);

            for (int nbr : graph[ele]) {
                indeg[nbr]--;
                if (indeg[nbr] == 0) {
                    q.addLast(nbr);
                }
            }

        }

        if (topo.size() != V)
            return false;

        return true;
    }

    // 210
    int[] reverse(int a[], int n) {
        int i, k, t;
        for (i = 0; i < n / 2; i++) {
            t = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = t;
        }

        return a;
    }

    public int[] findOrder(int V, int[][] prerequisites) {

        int[] indeg = new int[V];
        ArrayList<Integer>[] graph = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] v : prerequisites) {

            indeg[v[1]]++;
            graph[v[0]].add(v[1]);
        }

        LinkedList<Integer> q = new LinkedList<>();
        int[] topo = new int[V];

        for (int i = 0; i < indeg.length; i++) {

            if (indeg[i] == 0) {
                q.addLast(i);
            }
        }

        int idx = 0;
        while (q.size() > 0) {
            int ele = q.removeFirst();

            topo[idx++] = ele;

            for (int nbr : graph[ele]) {
                indeg[nbr]--;
                if (indeg[nbr] == 0) {
                    q.addLast(nbr);
                }
            }

        }

        if (idx != V)
            return new int[] {};

        return reverse(topo, V);
    }

    // 329

    // can also be done by memorization DP

    // here indeg[i][j] means how many elements are smaller than mat[i][j] in their adjacent 4 directions
    // all the indeg[i][j] == 0 means no one can come to them so they can be the starting points 
    // and once indeg[i][j] becomes 0 for any (i,j) that means we have covered all the possible (x,y) from where we can go to (i,j)=> now this can be added in que
    public int longestIncreasingPath(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        int[][] indeg = new int[n][m];

        int[][] dir = { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } };

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int[] d : dir) {
                    int x = i + d[0];
                    int y = j + d[1];

                    if (x >= 0 && y >= 0 && x < n && y < m && matrix[i][j] < matrix[x][y]) {
                        indeg[x][y]++;
                    }
                }
            }
        }

        LinkedList<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (indeg[i][j] == 0) {
                    q.addLast(i * m + j);
                }
            }
        }

        int level = 0;

        while (q.size() > 0) {
            int size = q.size();

            while (size-- > 0) {
                int idx = q.removeFirst();

                int i = idx / m;
                int j = idx % m;

                for (int[] d : dir) {
                    int x = i + d[0];
                    int y = j + d[1];

                    if (x >= 0 && y >= 0 && x < n && y < m && matrix[i][j] < matrix[x][y]) {
                        indeg[x][y]--;

                        // here we are adding (x,y) to the que that means all the point from which we could have reached (x,y) have been explored
                        if (indeg[x][y] == 0) {
                            q.addLast(x * m + y);
                        }
                    }
                }
            }

            level++;
        }

        return level;
    }


    
}
