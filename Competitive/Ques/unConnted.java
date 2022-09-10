import java.util.*;

public class unConnted {

    static int[] par;
    static int[] size;

    public static int findPar(int u) {
        if (par[u] == u) {
            return u;
        }

        return par[u] = findPar(par[u]);
    }

    public static void merge(int p1, int p2) {
        if (size[p1] > size[p2]) {
            par[p2] = p1;
            size[p1] += size[p2];
        } else {
            par[p1] = p2;
            size[p2] += size[p1];
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int V = scn.nextInt();
        int e = scn.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        par = new int[V+1];

        for(int i=0;i<=V;i++){
            par[i] = i;
        }

        for (int i = 0; i < e; i++) {
            int u = scn.nextInt();
            int v = scn.nextInt();

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // for (int i = 1; i <= V; i++) {
        // System.out.print(graph.get(i)+" ");
        // }

        boolean[] vis = new boolean[V + 1];

        int comp = 0;
        for (int i = 1; i <= V; i++) {

            int u = i;
            int p1 = findPar(u);
            for (int nbr : graph.get(u)) {

                int p2 = findPar(nbr);

                if (p1 != p2) {
                    par[p2] = p1;
                }
            }
        }

        for(int i=1;i<=V;i++){
            if(par[i]==i){
                comp++;
            }
        }

        System.out.println(comp);

    }
}
