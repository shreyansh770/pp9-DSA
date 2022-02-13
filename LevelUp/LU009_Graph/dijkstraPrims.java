import java.lang.reflect.Array;
import java.util.*;

public class dijkstraPrims {

    public static class Edge {
        int v;
        int w;

        Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }

        public String toString() {
            return this.v + ", " + this.w;
        }
    }

    public static class pair {
        int src = 0;
        int par = 0;
        int w = 0;
        int wsf = 0;

        pair(int src, int wsf) {
            this.src = src;
            this.wsf = wsf;
        }

        pair(int src, int par, int w, int wsf) {
            this.src = src;
            this.par = par;
            this.w = w;
            this.wsf = wsf;
        }
    }

    public static void addEdge(int u, int v, int w, ArrayList<Edge>[] graph) {
        graph[u].add(new Edge(v, w));
    }

    public static int findEdge(int u, int v, ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph[u].size(); i++) {
            Edge e = graph[u].get(i);

            if (e.v == v) {
                return i;
            }
        }

        return -1;
    }

    // works on directed graph

    // DIJKSTRA -> this give 'shortest path from source to every other vertex'-> this will not always give MST

    // DRY RUN BOTH THE METHOD TO CLEAR THINGS

    // marking vis after removing -> here we are keeping visited and priority is assuring tha
    // we reach any vertex with minimum possible weight bcoz we are sorting pq on the basis of wsf
    public static void dijkstra01(ArrayList<Edge>[] graph, int src) {

        int V = graph.length;

        ArrayList<Edge>[] myGraph = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            myGraph[i] = new ArrayList<>();
        }

        PriorityQueue<pair> pq = new PriorityQueue<>((a, b) -> {
            return a.wsf - b.wsf;
        });

        pq.add(new pair(src, -1, 0, 0));

        boolean[] vis = new boolean[V];

        while (pq.size() != 0) {

            pair t = pq.remove();

            if (vis[t.src])
                continue;

            if (t.par != -1) {
                addEdge(t.par, t.src, t.w, myGraph);
            }

            vis[t.src] = true;

            for (Edge nbr : graph[t.src]) {
                if (!vis[nbr.v]) {
                    pq.add(new pair(nbr.v, t.src, nbr.w, t.wsf + nbr.w));
                }
            }
        }

    }


    // marking while adding if we keep a vis here than it might be possible that we
    // could come
    // to vertex i will a less weighted path but our vis will not allow us to go
    // there
    public static void dijkstra02(ArrayList<Edge>[] graph, int src) {

        int V = graph.length;

        PriorityQueue<pair> pq = new PriorityQueue<>((a, b) -> {
            return a.wsf - b.wsf;
        });

        pq.add(new pair(src, 0));

        int[] dis = new int[V]; // dis array
        Arrays.fill(dis, (int) (1e8));

        dis[src] = 0;

        while (pq.size() != 0) {

            pair t = pq.remove();

            for (Edge nbr : graph[t.src]) {
                if (t.wsf + nbr.w < dis[nbr.v]) {
                    dis[nbr.v] = t.wsf + nbr.w;
                    pq.add(new pair(nbr.v, dis[nbr.v]));
                }
            }
        }
    }

     // prims -> this gives MST
     public static void prims(ArrayList<Edge>[] graph, int src) {

        int V = graph.length;

        ArrayList<Edge>[] myGraph = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            myGraph[i] = new ArrayList<>();
        }

        PriorityQueue<pair> pq = new PriorityQueue<>((a, b) -> {
            return a.w - b.w; // sorting on the basis of weight
        });

        pq.add(new pair(src, -1, 0, 0));

        boolean[] vis = new boolean[V];

        while (pq.size() != 0) {

            pair t = pq.remove();

            if (vis[t.src])
                continue;

            if (t.par != -1) {
                addEdge(t.par, t.src, t.w, myGraph);
            }

            vis[t.src] = true;

            for (Edge nbr : graph[t.src]) {
                if (!vis[nbr.v]) {
                    pq.add(new pair(nbr.v, t.src, nbr.w, t.wsf + nbr.w));
                }
            }
        }

    }




    public static void main(String[] args) {

    }
}