import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C1638 {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static int[] par;

    public static int findPar(int u) {
        if (par[u] == u)
            return u;

        return par[u] = findPar(par[u]);

    }

    public static void main(String[] args) {

        FastReader fs = new FastReader();

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();

            int[] perm = new int[n];

            par = new int[n + 1];
            for (int i = 0; i < n; i++) {
                perm[i] = fs.nextInt();
            }

            for (int i = 0; i <= n; i++) {
                par[i] = i;
            }

            for (int i = 0; i < n; i++) {
                int u = perm[i];

                for (int j = i + 1; j < n; j++) {

                    int v = perm[j];

                    if (u > v) {
                        int p1 = findPar(u);
                        int p2 = findPar(v);

                        if (p1 != p2) {
                            par[p2] = p1;
                        }
                    }
                }
            }

            int comp = 0;
            for (int i = 0; i < n; i++) {
                int p = findPar(i);
                if (p == i) {
                    comp++;
                }
            }

            System.out.println(comp);

        }
    }
}
