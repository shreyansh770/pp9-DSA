import java.util.*;
import java.io.*;

public class E659 {

    static List<List<Integer>> g;
    static boolean[] vis;

    public static boolean dfs(int src, int par) {

        vis[src] = true;

        for (int nbr : g.get(src)) {

            if (!vis[nbr]) {
                boolean res = dfs(nbr, src);
                if (!res)
                    return false;
            } else {

                if (par != nbr) {
                    return false; // found cycle
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        g = new ArrayList<>();

        vis = new boolean[n+1];
        for (int i = 0; i <= n; i++) {

            g.add(new ArrayList<>());
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            int u = scn.nextInt();
            int v = scn.nextInt();
            g.get(u).add(v);
            g.get(v).add(u);
        }

        for (int i = 1; i <= n; i++) {

            if (!vis[i]) {
                // System.out.println(i);
                boolean ans = dfs(i, 1);
                if (ans)
                    res++;
            }
        }

        System.out.println(res);

    }
}
