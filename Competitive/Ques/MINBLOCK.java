import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MINBLOCK {

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

    static boolean[] vis;

    public static int dfs(List<List<int[]>> graph, int src, List<Integer> unifected, int[] infected) {

        vis[src] = true;

        int count = 1;
        for (int[] nbr : graph.get(src)) {
            int v = nbr[0];
            int w = nbr[1];

            // cannot be saved
            if (infected[src] == 1 && w == 0) {
                infected[v] = 1;
            }

            if (!vis[v]) {
                int childs = dfs(graph, v, unifected, infected);

                // can be saved
                if (infected[src] == 1 && w == 1) {
                    unifected.add(childs);
                }

                count += childs;
            }

        }

        return count;
    }

    public static void main(String[] args) {

        FastReader fs = new FastReader();

        int t = fs.nextInt();

        while (t-- > 0) {

            int V = fs.nextInt();
            int K = fs.nextInt();

            List<List<int[]>> graph = new ArrayList<>();

            for (int i = 0; i <= V; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < V - 1; i++) {
                int u = fs.nextInt();
                int v = fs.nextInt();
                int b = fs.nextInt();

                graph.get(u).add(new int[] { v, b });
                graph.get(v).add(new int[] { u, b });
            }

            int[] infected = new int[V + 1];
            infected[1] = 1;
            vis = new boolean[V + 1];
            List<Integer> unifected = new ArrayList<>();

            dfs(graph, 1, unifected, infected);

            int infectedforsure = 0;

            for(int i=0;i<=V;i++){
                infectedforsure+=infected[i];
            }


            int canstillbeallowedtobeinfected = K - infectedforsure;

            if(canstillbeallowedtobeinfected<0){
                System.out.println(-1);
            }else{

                int opencity = 0;

                int s = unifected.size();
                Collections.sort(unifected); // subtree with smallest size

                while(opencity<s && canstillbeallowedtobeinfected>=unifected.get(opencity)){
                    canstillbeallowedtobeinfected = canstillbeallowedtobeinfected-unifected.get(opencity);
                    // System.out.println(canstillbeallowedtobeinfected);

                    opencity++;

                }

                System.out.println(s-opencity);
            }

        }
    }

}
