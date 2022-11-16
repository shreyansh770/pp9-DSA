import java.util.*;
import java.io.*;

public class TravellingSalesman {

    static int[][] cost;
    static int[][] dp;

    public static int solve(int i, int mask, int n) {

        if (mask==1) {
            return  cost[i][0];
        }

        if(dp[i][mask]!=-1) return dp[i][mask];

        int ans = (int)1e9;
        for (int j = 1; j <= n; j++) {

            if ((mask & (1 << j)) != 0) {
                ans = Math.min(ans, cost[i][j] + solve(j, (mask ^ (1 << j)), n));
            }
        }

        return dp[i][mask] = ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        dp = new int[n][(1 << n)];

        for(int[] d : dp){
            Arrays.fill(d,-1);
        }

        cost = new int[n+1][n+1];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                cost[i][j] = scn.nextInt();
            }
        }

        System.out.println(solve(1, (1<<n)-1, n) );
        //1111
        scn.close();
    }
}
