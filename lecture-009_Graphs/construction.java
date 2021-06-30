import java.util.*;

public class construction {

    public static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static void addEdge(ArrayList<Edge>[] graph, int u, int v, int w) {
        graph[u].add(new Edge(u, v, w));
        graph[v].add(new Edge(v, u, w));
    }

    public static void display(ArrayList<Edge>[] graph, int N) {

        for (int i = 0; i < N; i++) {

            System.out.print(i + "->");

            for (Edge e : graph[i]) {
                System.out.print("(" + e.nbr + "," + e.wt + ")");
            }
        }

    }

    public static int findEdge(ArrayList<Edge>[] graph, int u, int v) {

        ArrayList<Edge> list = graph[u];
        for (int i = 0; i < list.size(); i++) {
            Edge e = list.get(i);
            if (e.nbr == v)
                return i;
        }
        return -1;
    }

    public static void removeEdge(ArrayList<Edge>[] graph, int u, int v) {

        int i1 = findEdge(graph, u, v);
        int i2 = findEdge(graph, v, u);

        graph[u].remove(i1);
        graph[v].remove(i2);

    }

    public static void removeVtx(ArrayList<Edge>[] graph, int u) {
        ArrayList<Edge> list = graph[u];
        for (int i = list.size() - 1; i >= 0; i--) {
            Edge e = list.get(i);
            removeEdge(graph, e.src, e.nbr);
        }
    }

    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int des, boolean[] vis) {
        if (src == des)
            return true;

        vis[src] = true;
        boolean res = false;
        for (Edge e : graph[src]) {
            if (!vis[e.nbr])
                res = res || hasPath(graph, e.nbr, des, vis);
        }

        return res;
    }

    public static int printAllPath(ArrayList<Edge>[] graph, int src, int des, boolean[] vis, String psf) {

        if (src == des) {
            System.out.println(psf + des);
            return 1;
        }

        vis[src] = true;
        int count = 0;
        for (Edge e : graph[src]) {
            if (!vis[e.nbr]) {
                count += printAllPath(graph, e.nbr, des, vis, psf + src);
            }
        }

        vis[src] = false;

        return count;
    }

    public static void preOrder(ArrayList<Edge>[] graph, int src, int des, boolean[] vis, int wsf, String psf) {

        System.out.println(src + " -> " + psf + " @ " + wsf);

        vis[src] = true;
        for (Edge e : graph[src]) {
            if (!vis[e.nbr]) {
                preOrder(graph, e.nbr, des, vis, wsf + e.wt, psf + e.nbr);
            }
        }

        vis[src] = false;

    }

    public static void postOrder(ArrayList<Edge>[] graph, int src, int des, boolean[] vis, int wsf, String psf) {

        vis[src] = true;
        for (Edge e : graph[src]) {
            if (!vis[e.nbr]) {
                postOrder(graph, e.nbr, des, vis, wsf + e.wt, psf + e.nbr);
            }
        }

        System.out.println(src + " -> " + psf + " @ " + wsf);
        vis[src] = false;
    }

    public static void lighestPath(ArrayList<Edge>[] graph, int src, int des){
        
    }

    public static class pathPair{
          
       String psf = "";
       int wsf = 0;

    }


    public static pathPair heaviestPath(ArrayList<Edge>[] graph, int src, int des){

       if(src == des){
           pathPair base = new pathPair();
           base.psf += src;

           return base;
       }


    }


    public static void construct() {
        int N = 7;
        ArrayList<Edge>[] graph = new ArrayList[N];
        for (int i = 0; i < N; i++)
            graph[i] = new ArrayList<>();

        addEdge(graph, 0, 1, 10);
        addEdge(graph, 0, 3, 10);
        addEdge(graph, 1, 2, 10);
        addEdge(graph, 2, 3, 40);
        addEdge(graph, 3, 4, 2);
        addEdge(graph, 4, 5, 2);
        addEdge(graph, 4, 6, 8);
        addEdge(graph, 5, 6, 3);

        boolean[] vis = new boolean[N];
        // System.out.println(printAllPath(graph, 0,6,vis,""));
        postOrder(graph, 0, 6, vis, 0, "0");

    }

    public static void main(String[] args) {
        construct();
    }

}
