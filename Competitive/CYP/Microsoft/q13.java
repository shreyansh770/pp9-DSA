import java.util.*;

public class q13 {

    static boolean[] vis;

    public static void cc(ArrayList<ArrayList<Integer>> adj, int src) {

        vis[src] = true;
        for (int nbr : adj.get(src)) {

            if (!vis[nbr]) {
                cc(adj, nbr);
            }
        }

    }

    static int findEdge(ArrayList<ArrayList<Integer>> graph, int u, int v) {
        for (int i = 0; i < graph.get(u).size(); i++) {
            int e = graph.get(u).get(i);
            if (e == v)
                return i;
        }
        return -1;
    }

    static int isBridge(int V, ArrayList<ArrayList<Integer>> adj, int c, int d) {


        vis = new boolean[V];

        int ocomp = 0;
        for (int i = 0; i < V; i++) {

            if (!vis[i]) {
                ocomp++;
                cc(adj, i);
            }
        }
        

        adj.get(c).remove(Integer.valueOf(d));
        adj.get(d).remove(Integer.valueOf(c));

        vis = new boolean[V];

        int comp = 0;
        for (int i = 0; i < V; i++) {

            if (!vis[i]) {
                comp++;
                cc(adj, i);
            }
        }

        // System.out.println(comp);

        return ocomp!=comp ? 1 : 0;
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int V = scn.nextInt();
        int E = scn.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            int u = scn.nextInt();
            int v = scn.nextInt();

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int c = scn.nextInt();
        int d = scn.nextInt();

        // isBridge(V, adj, c, d);
        System.out.println(isBridge(V, adj, c, d));

    }
}
