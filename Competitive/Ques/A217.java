import java.util.*;

public class A217 {

    public static void dfs(int src,int[][] graph,int[] vis,int n){

        vis[src] = 1;
        for(int i=0;i<n;i++){
            if((graph[i][0] == graph[src][0] || graph[i][1] == graph[src][1] )&& (vis[i]==0)){
                 dfs(i, graph, vis, n);
            }
        }

    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[][] graph = new int[1001][2];
        for (int i = 0; i < n; i++) {

            graph[i][0] = scn.nextInt();
            graph[i][1] = scn.nextInt();

        }

        int[] vis = new int[1001];

        // for(int i=0;i<n;i++){
        //     vis[i] = -1;
        // }

        int component = 0;

        for(int i=0;i<n;i++){

            if(vis[i]==0){
                dfs(i,graph,vis,n);
                component++;
            }
        }

        System.out.println(component-1);
    }
}
