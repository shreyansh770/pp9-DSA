import java.util.*;

public class Ques {
    static int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public static int dfs(int sr, int sc, int er, int ec, boolean[][] vis, int[][] heights) {

        if (sr == er && sc == ec) {
            return 0;
        }

        vis[sr][sc] = true;
        int effort = (int) 1e9;
        for (int[] d : dir) {
            int r = sr + d[0];
            int c = sc + d[1];

            if (r >= 0 && c >= 0 && r <= er && c <= ec && !vis[r][c]) {
                System.out.print(r + " " + c);
                effort = Math.min(effort,
                        Math.max(dfs(r, c, er, ec, vis, heights), Math.abs(heights[sr][sc] - heights[r][c])));
            }
        }

        vis[sr][sc] = false;

        return effort;
    }

    public static int minimumEffortPath(int[][] heights) {

        // src 0,0
        int n = heights.length;
        int m = heights[0].length;

        boolean[][] vis = new boolean[n][m];

        long start = System.nanoTime();
        int ans = dfs(0, 0, n - 1, m - 1, vis, heights);
        long end = System.nanoTime();
        long elapsedTime = end - start;
        System.out.print(elapsedTime);
        return ans;
    }

    public double frogPosition(int n, int[][] edges, int t, int target) {

        // graph
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // for(ArrayList<Integer> list : graph){
        // System.out.println(list);
        // }

        double prob = 1.0;
        LinkedList<Integer> q = new LinkedList<>();
        q.addLast(1);

        while (q.size() != 0) {
            int size = q.size();
            t--;
            prob /= size;
            while (size-- > 0) {

                int top = q.removeFirst();

                if (top == target)
                    return prob;

                for (int v : graph.get(top)) {
                    q.addLast(v);
                }

            }

        }

        return 0.00000;

    }

    public static void main(String[] args) {
        int[][] heights = { { 8, 3, 2, 5, 2, 10, 7, 1, 8, 9 }, { 1, 4, 9, 1, 10, 2, 4, 10, 3, 5 },
                { 4, 10, 10, 3, 6, 1, 3, 9, 8, 8 }, { 4, 4, 6, 10, 10, 10, 2, 10, 8, 8 },
                { 9, 10, 2, 4, 1, 2, 2, 6, 5, 7 }, { 2, 9, 2, 6, 1, 4, 7, 6, 10, 9 }, { 8, 8, 2, 10, 8, 2, 3, 9, 5, 3 },
                { 2, 10, 9, 3, 5, 1, 7, 4, 5, 6 }, { 2, 3, 9, 2, 5, 10, 2, 7, 1, 8 },
                { 9, 10, 4, 10, 7, 4, 9, 3, 1, 6 } };

        minimumEffortPath(heights);
    }
}
