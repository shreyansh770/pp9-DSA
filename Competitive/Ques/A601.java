import java.util.*;
public class A601{


    static int n;
    static boolean[][] rail ;
    public static int solve(boolean check){

        LinkedList<int[]> q = new LinkedList<>();
        boolean[] vis = new boolean[n+1];

        q.addLast(new int[]{1,0}); // dest time

        while(q.size()!=0){
            int[] top = q.removeFirst();

            if(top[0]==n) return top[1];

            if(!vis[top[0]]) vis[top[0]] = true;

            for(int i =1;i<=n;i++){
                if(!vis[i] && rail[top[0]][i]==check){
                    q.addLast(new int[]{i,top[1]+1});
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        n = scn.nextInt();
        int m = scn.nextInt();
        rail = new boolean[n+1][n+1];
        for(int i=0;i<m;i++){
            int u =scn.nextInt();
            int v = scn.nextInt();

            rail[u][v] = true;
            rail[v][u] = true;
        }

        int timeRail = solve(true);
        int timeBus = solve(false);

        if(timeBus==-1 || timeRail==-1){
            System.out.println("-1");
        }else{

            System.out.println(Math.max(timeBus,timeRail));
        }
    }
}