import java.util.*;

public class B445 {

    static int[] par;
    static int[]  size;
    public static int find(int u) {

        if (par[u] == u)
            return u;

        return par[u] = find(par[u]);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int m = scn.nextInt();

        par = new int[n + 1];
        size = new int[n + 1];
        for (int i = 0; i <= n; i++) {

            par[i] = i;
            size[i] = 1;
        }

        for (int i = 1; i <= m; i++) {

            int u = scn.nextInt();
            int v = scn.nextInt();

            int p1 = find(u);

            int p2 = find(v);

            if (p1 != p2) {
                if(size[p1]>=size[p2]){
                    par[p2] = p1;
                    size[p1]+=size[p2]; 
                }else{
                    par[p1] = p2;
                    size[p2] += size[p1];
                }
            }
        }

        long res = 0;

        for(int i=1;i<=n;i++){
            int p = find(i);

            if(p == i){
                // System.out.println(i +" "+size[i]);
                int noe = size[i] -1;
                if(noe==0) continue;
                // System.out.print(noe);
                res+=noe;
            }
        }

        System.out.println((long)Math.pow(2, res));

        

    }
}
