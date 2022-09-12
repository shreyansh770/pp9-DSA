import java.util.*;

public class A356 {

    static int[] par;

    public static int findpar(int u) {
        if (par[u] == u)
            return u;

        return par[u] = findpar(par[u]);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int m = scn.nextInt();

        par = new int[n+1];
        int[] res = new int[n];
        for (int i = 0; i <= n; i++)
            par[i] = i;

        while (m-- > 0) {

            int l = scn.nextInt();
            int r = scn.nextInt();
            int w = scn.nextInt();

            int cur = findpar(l);
            while(cur <= r){
                if(cur == w){
                    cur = cur + 1;
                }else{
                    res[cur-1] = w;
                    par[cur] = cur + 1;
                }
        
                if(cur>n) break;
                if(cur==n && cur!=w) {
                    res[cur-1] = w;
                }

                
                cur = findpar(cur);
            }
        }

        for(int i : res){
            System.out.print(i+" ");
        }
    }
}
