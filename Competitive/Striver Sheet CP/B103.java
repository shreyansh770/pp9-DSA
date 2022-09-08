import java.util.*;

public class B103 {

    static int cycle = 0;
    static List<List<Integer>> graph;
    static boolean[] vis;
    static int[] par;

    public static void dfs(int src){
       
        vis[src] = true;

        for(int child : graph.get(src)){

            if(!vis[child]){
                par[child] = src;
                dfs(child);
            }else if(par[src]!=child){
                cycle++;
            }
        }
        
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int m = scn.nextInt();

        if (n != m) {
            System.out.println("NO");
            return;
        }

        graph = new ArrayList<>();
        vis = new boolean[n+1];
        par = new int[n+1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= m; i++) {
            int u = scn.nextInt();
            int v = scn.nextInt();

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int cnt = 0;
        par[1]=-1;
        for(int i=1;i<=n;i++){
            if(!vis[i]){
                dfs(i);
                cnt++;
            }
        }

        // System.out.println(cycle);
        if(cnt==1 && cycle==2){
            System.out.println("FHTAGN!");
        }else{
            System.out.println("NO");
        }

    }
}
