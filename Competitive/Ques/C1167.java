import java.util.*;
import java.io.*;

public class C1167 {

    static int[] par;
    static int[] size;

    public static int findPar(int u) {
        if (par[u] == u)
            return u;

        return par[u] = findPar(par[u]);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

        par = new int[n+1];
        size = new int[n+1];

        for (int i = 0; i < n; i++) {
            par[i] = i;
            size[i] = 1;
        }

        for (int i = 1; i <= m; i++) {
        
            st = new StringTokenizer(br.readLine());
			int noe = Integer.parseInt(st.nextToken());
            int[] nbr = new int[noe];
            for (int j = 0; j < noe; j++) {

                nbr[j] = Integer.parseInt(st.nextToken());

                if (j > 0) {

                    int p1 = findPar(nbr[j]);
                    int p2 = findPar(nbr[j - 1]);

                    if (p1 != p2) {

                        if (size[p1] >= size[p2]) {
                            par[p2] = p1;
                            size[p1] += size[p2];
                        } else {
                            par[p1] = p2;
                            size[p2] += size[p1];
                        }
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {

            int p = findPar(i);
            
            System.out.print(size[p] + " ");
            
        }

    }
}
