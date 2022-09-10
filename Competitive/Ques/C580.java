import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C580 {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    // static boolean[] vis;

    public static int dfs(int src, int par, List<List<Integer>> graph, int[] mark, int cc, int m) {

        if (graph.get(src).size() == 1 && src!=1) {

            if (cc > m)
                return 0;

            if (cc <= m) {
                return 1;
            }
        }

        if (cc > m)
            return 0;
        int res = 0;
        for (int nbr : graph.get(src)) {

            if (nbr == par)
                continue;

            if (mark[nbr] == 1) {

                res += dfs(nbr, src, graph, mark, cc + 1, m);
            } else {

                res += dfs(nbr, src, graph, mark, 0, m);
            }
        }

        return res;
    }

    public static void main(String[] args) {

        FastReader fs = new FastReader();

        int n = fs.nextInt();
        int m = fs.nextInt();

        int[] mark = new int[n + 1];
        // vis = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            mark[i] = fs.nextInt();
        }

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            int u = fs.nextInt();
            int v = fs.nextInt();

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // if(graph.get(1).size()==0){
        // System.out.println(0);
        // return;
        // }

        if (mark[1] == 1) {

            System.out.println(dfs(1, -1, graph, mark, 1, m));

        } else {
            System.out.println(dfs(1, -1, graph, mark, 0, m));

        }
    }
}
