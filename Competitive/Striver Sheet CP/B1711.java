import java.util.*;

public class B1711 {

    public static void main(String[] args) {

        // remove odd connection
        Scanner scn = new Scanner(System.in);

        int t = scn.nextInt();

        while (t-- > 0) {
            int n = scn.nextInt();
            int m = scn.nextInt();

            int[] uv = new int[n];
            int[] deg = new int[n];

            for (int i = 0; i < n; i++) {
                uv[i] = scn.nextInt();
            }

            List<Integer>[] g = new ArrayList[n];
            for (int i = 0; i < m; i++) {
                int u = scn.nextInt() - 1;
                int v = scn.nextInt() - 1;

                g[u].add(v);
                g[v].add(u);

                deg[u]++;
                deg[v]++;
            }

            if (m % 2 == 0) {
                System.out.println(0);
            } else {

                int rv = (int) 1e9; // removing vertex with odd no of pairs
                int re = (int) 1e9; // removing edge between two vertex if they have even number of connections

                for (int i = 0; i < n; i++) {
                    int d = deg[i];

                    if (d % 2 == 1) {
                        rv = Math.min(rv, uv[i]);
                    } else {

                        if (d % 2 == 0) {
                            for (int j = 0; j < d; j++) {

                                if (deg[g[i].get(j)] % 2 == 0) {
                                    re = Math.min(re, uv[i] + uv[j]);
                                }
                            }
                        }
                    }
                }

                System.out.println(Math.min(rv,re));
            }
        }
    }
}
