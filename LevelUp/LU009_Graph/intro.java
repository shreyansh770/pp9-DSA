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

    public void display(ArrayList<Edge>[] graph) {
        int V = graph.length;

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);

                System.out.print("( " + e.v + "," + e.w + " )");
            }

        }
    }

    public static void addEdge(int u, int v, int w, ArrayList<Edge>[] graph) {

        graph[u].add(new Edge(v, w));
        graph[v].add(new Edge(u, w));
    }

    public static int findEdge(int u , int v,ArrayList<Edge>[] graph ){

        for(int i=0;i<graph[u].size();i++){
            Edge e = graph[u].get(i);

            if(e.v == v) return i;
        }

        return -1;
    }

    public static void removeEdge(int u, int v, int w, ArrayList<Edge>[] graph) {

        int idx = findEdge(u,v,graph);
        graph[u].remove(idx);

        idx = findEdge(v,u,graph);
        graph[v].remove(idx);
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
        addEdge(2, 3, 5, graph);
        addEdge(2, 4, 7, graph);
        addEdge(4, 9, 8, graph);
        addEdge(4, 10, 10, graph);
        addEdge(9, 10, 8, graph);
        addEdge(4, 6, 11, graph);
        addEdge(5, 6, 2, graph);
        addEdge(6, 7, 3, graph);
        addEdge(5, 7, 3, graph);

    }

    public static void main(String[] args) {
        construct();
    }

}