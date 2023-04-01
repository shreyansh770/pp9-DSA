import java.util.*;

public class LC_1135 {
    static int[] par;

    public static int findPar(int u){
        if(par[u]==u) return u;

        return par[u] = findPar(par[u]);
    }

    public static int dsu(List<int[]> connections , int n){
           
        Collections.sort(connections,(int[] a , int[] b)->{
            return a[2]-b[2];
        });

        int cost = 0;
        for(int[] c : connections){
            int u = c[0];
            int v = c[1];
            int x = c[2];

            int p1 = findPar(u);
            int p2 = findPar(v);

            if(p1!=p2){
                par[p2] = p1;
                cost+=x;
            }
        }

        return cost;

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int e = scn.nextInt();
        par = new int[n+1];
        for(int i=0;i<=n;i++){
            par[i] = i;
        }
        List<int[]> connections = new ArrayList<>();

        for (int i = 0; i < e; i++) {
            int u = scn.nextInt();
            int v = scn.nextInt();
            int c = scn.nextInt();
            connections.add(new int[] { u, v, c });
        }

        System.out.println(dsu(connections,n));
        
    }
}
