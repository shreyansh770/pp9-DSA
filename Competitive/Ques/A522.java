import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A522 {
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

    static boolean vis[] ;
    public static int dfs(int src ,ArrayList<ArrayList<Integer>> graph){
 
        vis[src] = true;

        int level = 0;
        for(int nbr : graph.get(src)){
            if(!vis[nbr]){
                level = dfs(nbr,graph);
            }
        }


        return level +1;
    }

    public static void main(String[] args) {

        FastReader scn = new FastReader();

        int n = scn.nextInt();
        HashMap<String, Integer> map = new HashMap<>(); // name vs id
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        map.put("polycarp", 0);
        int idx = 1;
        vis = new boolean[n+1];
        // scn.nextLine();
        for (int i = 0; i < n ; i++) {
            String p1 = scn.next().toLowerCase();
            String r = scn.next();
            String p2 = scn.next().toLowerCase();
            map.put(p1, idx);
            int id = map.get(p2);
            graph.get(id).add(idx);
            idx++;
        }

        System.out.println(dfs(0,graph));
    }
}
