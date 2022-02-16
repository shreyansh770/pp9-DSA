import java.util.*;

public class directed {
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

    public static void display(ArrayList<Edge>[] graph) {
        int V = graph.length;

        for (int i = 0; i < V; i++) {
            System.out.print(i + " ->");

            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                // System.out.println(e)
                System.out.print("{ " + e.v + ", " + e.w + " }");
            }

            System.out.println();
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

    public static void removeEdge(int u, int v, ArrayList<Edge>[] graph) {
        int idx = findEdge(u, v, graph);
        graph[u].remove(idx);
    }

    // Topological sorting(source -> wiki)

    public void dfs_topo(int src, ArrayList<Edge>[] graph, boolean[] vis, ArrayList<Integer> topo) {

        vis[src] = true;

        for (Edge nbr : graph[src]) {
            if (!vis[nbr.v]) {
                dfs_topo(nbr.v, graph, vis, topo);
            }
        }

        topo.add(src);
    }

    void topological_sort(ArrayList<Edge>[] graph) {
        int V = graph.length;

        boolean[] vis = new boolean[V];
        ArrayList<Integer> topo = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs_topo(i, graph, vis, topo);
            }
        }

        for (int i = topo.size() - 1; i >= 0; i++) {
            System.out.print(topo.get(i) + " ");
        }
    }

    // kahn's algo ==============================

    ArrayList<Integer> topological_order_bfs_(ArrayList<Edge>[] graph) {

        int V = graph.length;

        int[] indegree = new int[V]; // this store for any vertex v how many u are there

        for (int i = 0; i < V; i++) {
            for (Edge e : graph[i]) {
                indegree[e.v]++;
            }
        }

        LinkedList<Integer> q = new LinkedList<>();
        ArrayList<Integer> topo = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.addLast(i);
            }
        }

        while (q.size() > 0) {
            int ele = q.removeFirst();

            topo.add(ele);

            for (Edge e : graph[ele]) {
                indegree[e.v]--;
                if (indegree[e.v] == 0) {
                    q.addLast(e.v);
                }
            }
        }

        // CYCLE EXISTS
        if (topo.size() != V) {
            return new ArrayList<>();
        }

        return topo;

    }

    // level wise

    ArrayList<ArrayList<Integer>> topological_order_bfs(ArrayList<Edge>[] graph) {
        int V = graph.length;

        int[] indegree = new int[V];

        for (int i = 0; i < V; i++) {
            for (Edge e : graph[i]) {
                indegree[e.v]++;
            }
        }

        LinkedList<Integer> que = new LinkedList<>();
        ArrayList<ArrayList<Integer>> topo_order = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                que.addLast(i);
            }
        }

        while (que.size() > 0) {
            int size = que.size();
            ArrayList<Integer> smallAns = new ArrayList<>();
            while (size-- > 0) {
                int ele = que.removeFirst();
                smallAns.add(ele);

                for (Edge e : graph[ele]) {
                    indegree[e.v]--;
                    if (indegree[e.v] == 0) {
                        que.addLast(e.v);
                    }
                }
            }
            topo_order.add(smallAns);
        }

        return topo_order;
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

        // bfs
        removeEdge(4, 6, graph);
    }

    // kosaraju algo

    public void dfs_01(int src, ArrayList<Edge>[] graph, boolean[] vis, List<Integer> st) {

        vis[src] = true;

        for (Edge nbr : graph[src]) {
            if (!vis[src]) {
                dfs_01(nbr.v, graph, vis, st);
            }
        }

        st.add(src);
    }

    public void dfs_02(int src, ArrayList<Edge>[] graph, boolean[] vis, ArrayList<Integer> comp) {

        vis[src] = true;
        comp.add(src);
        for (Edge nbr : graph[src]) {
            if (!vis[src]) {
                dfs_01(nbr.v, graph, vis, comp);
            }
        }

    }

    public List<List<Integer>> kosaraju(ArrayList<Edge>[] graph) {
        int V = graph.length;

        boolean[] vis = new boolean[V];

        List<Integer> st = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs_01(i, graph, vis, st);
            }
        }

        ArrayList<Edge>[] rgraph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int u = 0; u < V; u++) {
            ArrayList<Edge> al = graph[u];
            for (int j = 0; j < al.size(); j++) {
                int v = al.get(j).v;
                int w = al.get(j).w;

                rgraph[v].add(new Edge(u, w));
            }
        }

        List<List<Integer>> scc = new ArrayList<>();
        ArrayList<Integer> comp = new ArrayList<>();
        int noOfConComp = 0;
        vis = new boolean[V];
        for (int i = st.size() - 1; i >= 0; i--) {
            if (!vis[i]) {
                dfs_02(i, rgraph, vis, comp);
                noOfConComp++;
                scc.add(comp);
            }
        }

        System.out.println(noOfConComp);
        return scc;
    }

    // kruskal algo
    int[] par;

    public int findPar(int u) {
        if (par[u] == u) {
            return u;
        }

        int ans = findPar(par[u]);

        par[u] = ans;

        return ans;
    }

    public static void addEdge_(int u, int v, int w, ArrayList<Edge>[] graph) {
        graph[u].add(new Edge(v, w));
        graph[v].add(new Edge(u, w));
    }

    public ArrayList<Edge>[] kruskal(int[][] edges, int N) {

        // sorting on the basis of weight of edges
        Arrays.sort(edges, (int[] a, int[] b) -> {
            return a[2] - b[2];
        });

        ArrayList<Edge>[] mst = new ArrayList[N];

        par = new int[N];

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];

            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            int p1 = findPar(u);
            int p2 = findPar(v);

            if (p1 != p2) {
                addEdge_(u, v, w, mst);
                par[p2] = p1;
            }
        }

        return mst;
    }

    // CYCLE DETECTION USING DFS IN DIRECTED GRAPH
    public boolean dfs(int src, ArrayList<ArrayList<Integer>> adj, int[] vis) {
        vis[src] = 1;

        for (int nbr : adj.get(src)) {

            if (vis[nbr] == 0) {
                if (dfs(nbr, adj, vis))
                    return true;
            } else if (vis[nbr] == 1)
                return true;
        }

        vis[src] = 2; // if we encounter thsi src again we can be sure that we wont

        return false;
    }

    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {

        int[] vis = new int[V];

        for (int i = 0; i < V; i++) {
            if (vis[i] != 1 && vis[i] != 2) {
                if (dfs(i, adj, vis))
                    return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        construct();
    }
}
