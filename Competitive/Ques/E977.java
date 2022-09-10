import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E977 {

    static boolean[] vis;
    static List<List<Integer>> graph;

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

    static void dfs(int src , List<Integer> comp){

        comp.add(src);
        vis[src] = true;
        for(int nbr : graph.get(src)){
            if(!vis[nbr]){
              dfs(nbr,comp);
            }
        }
    }

    public static void main(String[] args) {

        FastReader fs = new FastReader();

        int n = fs.nextInt();
        int m = fs.nextInt();

        graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        int[] deg = new int[n + 1];
        vis = new boolean[n + 1];
        for (int i = 1; i <= m; i++) {

            int u = fs.nextInt();
            int v = fs.nextInt();

            graph.get(u).add(v);
            graph.get(v).add(u);

            deg[u]++;
            deg[v]++;
        }

        List<Integer> comp = new ArrayList<>();

        int res = 0;
        for (int i = 1; i <= n; i++) {

            if (!vis[i]) {
                comp.clear();
                dfs(i, comp);
                boolean flag = true;
                for(int c : comp){
                     
                    if(deg[c]!=2) flag = false;
                }

                if(flag) res++;
            }
        }

        System.out.println(res);
    }
}
