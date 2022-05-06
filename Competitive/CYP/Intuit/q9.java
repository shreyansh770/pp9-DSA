public class q9 {

    int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    List<List<Integer>> res;
    boolean[][] at, pf;

    public void dfs(int[][] heights, int sr, int sc, boolean[][] vis) {

        if (vis[sr][sc])
            return;

        vis[sr][sc] = true;

        if (at[sr][sc] && pf[sr][sc]) {
            List<Integer> bans = new ArrayList<>();
            bans.add(sr);
            bans.add(sc);
            res.add(bans);
        }

        for (int[] d : dir) {

            int r = sr + d[0];
            int c = sc + d[1];

            if (r >= 0 && c >= 0 && r < heights.length && c < heights[0].length && heights[r][c] >= heights[sr][sc]
                    && !vis[r][c]) {
                dfs(heights, r, c, vis);
            }

        }

    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;

        res = new ArrayList<>();
        at = new boolean[n][m];
        pf = new boolean[n][m];

        // horizontal

        for (int i = 0; i < m; i++) {
            dfs(heights, 0, i, pf);
            dfs(heights, n - 1, i, at);
        }

        // vertical
        for (int i = 0; i < n; i++) {
            dfs(heights, i, 0, pf);
            dfs(heights, i, m - 1, at);
        }

        return res;
    }
}
