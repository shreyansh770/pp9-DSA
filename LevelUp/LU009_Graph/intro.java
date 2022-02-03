import java.lang.module.FindException;
import java.util.*;

public class intro {

    public static class Edge {
        int v;
        int w;

        Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }

        public String toString() {
            return this.v + "->" + this.w;
        }
    }

    // public void display(ArrayList<Edge>[] graph) {
    // int V = graph.length;

    // for (int i = 0; i < V; i++) {
    // for (int j = 0; j < graph[i].size(); j++) {
    // Edge e = graph[i].get(j);

    // System.out.print("( " + e.v + "," + e.w + " )");
    // }

    // }
    // }

    public static void addEdge(int u, int v, int w, ArrayList<Edge>[] graph) {

        graph[u].add(new Edge(v, w));
        graph[v].add(new Edge(u, w));
    }

    public static int findEdge(int u, int v, ArrayList<Edge>[] graph) {

        for (int i = 0; i < graph[u].size(); i++) {
            Edge e = graph[u].get(i);

            if (e.v == v)
                return i;
        }

        return -1;
    }

    public static void removeEdge(int u, int v, ArrayList<Edge>[] graph) {

        int idx = findEdge(u, v, graph);
        graph[u].remove(idx);

        idx = findEdge(v, u, graph);
        graph[v].remove(idx);
    }

    private static boolean hasPath_(int src, int dest, ArrayList<Edge>[] graph, boolean[] vis) {

        if (src == dest)
            return true;
        vis[src] = true;

        for (Edge nbr : graph[src]) {
            if (vis[nbr.v])
                continue;

            return hasPath_(nbr.v, dest, graph, vis);
        }

        return false;

    }

    public static boolean hasPath(int src, int dest, ArrayList<Edge>[] graph) {

        int V = graph.length;
        boolean[] vis = new boolean[V];
        return hasPath_(src, dest, graph, vis);
    }

    private static int countAllPath_(int src, int dest, ArrayList<Edge>[] graph, boolean[] vis) {
        if (src == dest)
            return 1;
        vis[src] = true;

        int paths = 0;
        for (Edge nbr : graph[src]) {
            if (vis[nbr.v])
                continue;

            paths += countAllPath_(nbr.v, dest, graph, vis);
        }
        vis[src] = false;

        return paths;
    }

    public int countAllPath(int src, int dest, ArrayList<Edge>[] graph) {
        int V = graph.length;
        boolean[] vis = new boolean[V];
        return countAllPath_(src, dest, graph, vis);
    }

    // maximum weight path and give that path

    private static class pair {
        int wsf;
        String psf;

        pair(int wsf, String psf) {
            this.wsf = wsf;
            this.psf = psf;
        }
    }

    private static pair maxWeightedPath_(int src, int dest, ArrayList<Edge>[] graph, boolean[] vis) {

        if (src == dest) {
            return new pair(0, dest + "");
        }

        vis[src] = true;

        pair myAns = new pair(-(int) 1e9, "");
        for (Edge nbr : graph[src]) {
            if (vis[nbr.v])
                continue;

            pair recAns = maxWeightedPath_(nbr.v, dest, graph, vis);

            if (recAns.wsf != -(int) 1e9 && recAns.wsf + nbr.w > myAns.wsf) {
                myAns.wsf = recAns.wsf + nbr.w;
                myAns.psf = src + "->" + recAns.psf;
            }

        }

        vis[src] = false;

        return myAns;
    }

    public static pair maxWeightedPath(int src, int dest, ArrayList<Edge>[] graph) {
        int V = graph.length;
        boolean[] vis = new boolean[V];
        return maxWeightedPath_(src, dest, graph, vis);
    }

    private static void getConnect_(int sr ,List<Integer> ans,ArrayList<Edge>[] graph,boolean[] vis){

        vis[sr] = true;

        for(Edge nbr : graph[sr]){
            if(vis[nbr.v]) continue;

            ans.add(nbr.v);
            getConnect_(sr,ans ,graph, vis);
        }
    }

    public static List<List<Integer>> getConnectedComponents(ArrayList<Edge>[] graph,int V){

        boolean[] vis = new boolean[V];
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i=0;i<V;i++){
            if(vis[i]) continue;
            List<Integer> ans = new ArrayList<>();
            getConnect_(i, ans, graph, vis);
            res.add(ans);
        }

        return res;
    }

    public static void construct() {

        int V = 11;
        ArrayList<Edge>[] graph = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        addEdge(0, 1, 2, graph);
        addEdge(1, 3, 4, graph);
        addEdge(1, 2, 3, graph);
        addEdge(3, 4, 5, graph);
        addEdge(2, 4, 7, graph);
        addEdge(4, 9, 8, graph);
        addEdge(4, 10, 10, graph);
        addEdge(9, 10, 8, graph);
        addEdge(4, 6, 11, graph);
        addEdge(5, 6, 2, graph);
        addEdge(6, 7, 3, graph);
        addEdge(5, 7, 3, graph);

        removeEdge(4,9, graph);
        removeEdge(4,10, graph);
        removeEdge(4,5, graph);
        removeEdge(4,2, graph);

        // pair p = maxWeightedPath(0,7,graph);
        // System.out.println(p.psf+" "+p.wsf);

    }

    public static void main(String[] args) {
        construct();
    }

}