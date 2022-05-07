import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B229 {
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

    static HashSet<Long>[] visitor;
    static boolean[] vis;

    public static class Edge {
        int v;
        int t;

        Edge(int v, int t) {
            this.v = v;
            this.t = t;
        }
    }

    public static class pair {
        int sr;
        int f;
        int td;
        long tsf;

        pair(int sr, int f, int td, long tsf) {
            this.sr = sr;
            this.f = f;
            this.td = td;
            this.tsf = tsf;
        }
    }

    // public static int timetoWait(int rt,int vr){

    // }

    public static long dijkstra(List<List<Edge>> graph,int n) {

        PriorityQueue<pair> pq = new PriorityQueue<>((a,b)->{
            return Long.compare(a.tsf, b.tsf);
        });

        pq.add(new pair(1, -1, 0,0));

        while(pq.size()!=0){
            pair top = pq.remove();

            if(top.sr == n) return top.tsf;

            if(vis[top.sr]) continue;

            vis[top.sr] = true;

            // waiting time at a planet
            long tr = top.tsf;
            while(visitor[top.sr-1].contains(tr)){
                tr++;
            }

            for(Edge nbr : graph.get(top.sr)){

                if(!vis[nbr.v]){
                    
                    long tt = tr + nbr.t; // time we reached nbr.v
                    pq.add(new pair(nbr.v, top.sr, nbr.t, tt));

                }

            }
        }

        return -1;
    }

    public static void main(String[] args) {

        FastReader fs = new FastReader();

        int n = fs.nextInt();
        int m = fs.nextInt();

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= m; i++) {

            int u = fs.nextInt();
            int v = fs.nextInt();
            int t = fs.nextInt();

            graph.get(u).add(new Edge(v, t));
            graph.get(v).add(new Edge(u, t));
        }

        visitor = new HashSet[n];

        for (int i = 0; i < n; i++) {
            visitor[i] = new HashSet<>();
        }

        for (int i = 0; i < n; i++) {
            int k = fs.nextInt();

            for (int j = 0; j < k; j++) {
                long vt = fs.nextInt();
                visitor[i].add(vt);
            }
        }

        vis = new boolean[n+1];

        System.out.println(dijkstra(graph, n));

    }
}
