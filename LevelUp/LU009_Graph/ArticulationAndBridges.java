import java.lang.reflect.Array;
import java.util.*;

public class ArticulationAndBridges {

    // low[i] --> ignoring the current path followed to reach ith vertex is there
    // any other path
    // that connects ith vertex to some other vertex with lesser discovery value
    // which will mean that apart from the path from parent to nbr the nbr also has
    // some other path through
    // which it can connect to nodes above its parent

    static int[] par;
    static int[] disc; // discovery
    static int[] low;
    static int time;
    static boolean[] vis;
    static boolean[] ap; // articulation point
    List<List<Integer>> res;

    // articulation point
    public static void dfs(int src, ArrayList<ArrayList<Integer>> graph) {
        disc[src] = low[src] = time;
        time++;
        int count = 0; // to check for actual source
        vis[src] = true;

        ArrayList<Integer> nbrs = graph.get(src);

        for (int i = 0; i < nbrs.size(); i++) {
            int nbr = nbrs.get(i);

            if (par[src] == nbr)
                continue;
            else if (vis[nbr] == true) {
                low[src] = Math.min(low[src], disc[nbr]); // why not low[nbr] -> beacuse this may lead the node to cross
                                                          // the current followed path which does'nt follow the rule of
                                                          // low[i]
            } else {

                par[nbr] = src;
                count++;
                dfs(nbr, graph);

                low[src] = Math.min(low[src], low[nbr]);

                // check if articulation point or not

                // this is the starting point
                if (par[src] == -1) {

                    // if count == 1 => there is some other path that connect all the nodes
                    // hence remove starting source will not break the graph into
                    // two or more components

                    if (count >= 2) {
                        ap[src] = true;
                    }

                } else {

                    // that if there exist some other path also
                    // for src's nbr
                    // => if src get removed than also the graph would not
                    // be divided into two or more

                    // in '>=' : '=' means nbr can only reach till its source not beyound that

                    if (low[nbr] >= disc[src]) {
                        ap[src] = true;
                    }
                }
            }
        }
    }

    // bridges
    public void dfs_(int src, ArrayList<ArrayList<Integer>> graph) {
        disc[src] = low[src] = time;
        time++;
        vis[src] = true;

        ArrayList<Integer> nbrs = graph.get(src);

        for (int i = 0; i < nbrs.size(); i++) {
            int nbr = nbrs.get(i);

            if (par[src] == nbr)
                continue;
            else if (vis[nbr] == true) {
                low[src] = Math.min(low[src], disc[nbr]);
            } else {

                par[nbr] = src;
                dfs(nbr, graph);

                low[src] = Math.min(low[src], low[nbr]);

                if (low[nbr] > disc[src]) {
                    List<Integer> edge = new ArrayList<>();
                    edge.add(nbr);
                    edge.add(src);
                    res.add(edge);
                }

            }
        }
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int v = scn.nextInt();
        int e = scn.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int u1 = scn.nextInt() - 1;
            int u2 = scn.nextInt() - 1;

            graph.get(u1).add(u2);
            graph.get(u2).add(u1);
        }

        par = new int[v];
        disc = new int[v];
        low = new int[v];
        vis = new boolean[v];
        ap = new boolean[v];

        par[0] = -1;
        dfs(0, graph);

        int res = 0; // no of ap

        for (int i = 0; i < v; i++) {
            if (ap[i] == true)
                res++;
        }

        System.out.println(res);

    }
}
