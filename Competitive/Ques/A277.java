import java.util.*;

public class A277 {

    static int[] par;
    static int[] size;

    public static int findPar(int u) {

        if (par[u] == u)
            return u;

        return par[u] = findPar(par[u]);
    }

    public static void union(int x, int y) {

        int p1 = findPar(x);
        int p2 = findPar(x);

        if (size[p1] >= size[p2]) {
            par[p2] = p1;
            size[p1] += size[p2];
        } else {
            par[p1] = p2;
            size[p2] += size[p1];
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int m = scn.nextInt();
        par = new int[m + 1]; // par of language

        int[] freq = new int[m + 1]; // par of language

        for (int i = 0; i <= m; i++) {
            par[i] = i;
        }

        int noc = 0;
        for (int i = 0; i < n; i++) {
            int l = scn.nextInt();
            if (l == 0) {
                noc++;
                continue;
            }
            int pl = scn.nextInt();
            freq[pl]++;
            for (int j = 1; j < l; j++) {
                int c = scn.nextInt();
                freq[pl]++;
                union(pl, c);
            }

        }

    }
}