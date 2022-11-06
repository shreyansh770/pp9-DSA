import java.util.*;
import java.io.*;

public class D954 {

    static List<List<Integer>> g;
    static boolean[][] e;

    public static void bfs(int src, int[] d, int n) {
        LinkedList<Integer> q = new LinkedList<>();

        q.addLast(src);
        boolean[] vis = new boolean[n];

        vis[src] = true;
        while (q.size() != 0) {

            int top = q.removeFirst();
            for (int nbr : g.get(top)) {
                if (!vis[nbr]) {
                    d[nbr] = d[top] + 1;
                    // System.out.println(d[nbr]);
                    vis[nbr] = true;
                    q.addLast(nbr);
                }
            }

            // level++;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int m = scn.nextInt();
        int s = scn.nextInt() - 1;
        int t = scn.nextInt() - 1;

        e = new boolean[n][n];

        g = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = scn.nextInt() - 1;
            int v = scn.nextInt() - 1;

            g.get(u).add(v);
            g.get(v).add(u);

            e[u][v] = e[v][u] = true;
        }

        int[] ds = new int[n];
        int[] dt = new int[n];
        bfs(s, ds, n);
        bfs(t, dt, n);

        int d = ds[t];
        int res = 0;
        // System.out.println(d);
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){

                if(!e[i][j]){

                    int mn = Math.min(ds[i]+dt[j]+1,ds[j]+dt[i]+1);
                    if(mn>=d)res++;
                }
            }
        }

        System.out.println(res);
    }
}
