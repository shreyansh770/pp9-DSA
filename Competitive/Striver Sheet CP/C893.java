import java.util.*;

public class C893 {

    static int[] par;

    public static int findPar(int u) {

        if (par[u] == u)
            return u;

        return par[u] = findPar(par[u]);
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int m = scn.nextInt();

        long[] g = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            g[i] = scn.nextInt();
        }

        par = new int[n+1];

        for(int i=1;i<=n;i++){
            par[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int u = scn.nextInt();
            int v = scn.nextInt();

            int p1 = findPar(u);
            int p2 = findPar(v);
            if (p1 != p2) {
                if (g[p1] <= g[p2]) {
                    par[p2] = p1;
                } else {
                    par[p1] = p2;
                }
            }
        }

        long c = 0;

        for(int i=1;i<=n;i++){
            int p1 = findPar(i);
            if(p1==i) c+=g[i];
        }

        System.out.println(c);
    }
}
