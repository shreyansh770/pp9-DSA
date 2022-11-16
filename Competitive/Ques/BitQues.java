import java.util.*;
import java.io.*;

public class BitQues {

    static int[][] dp;
    static int[][] cost;

    // i -> job
    public static int solve(int i, int mask, int n) {

        
        if (i == n){
            return 0;
        }
            // return 0;

        if (dp[i][mask] != -1){
            
            return dp[i][mask];
        }
            

        int res = (int) 1e9;
        for (int j = 0; j < n; j++) {  
            // System.out.println(i);
          if ((mask & (1 << j)) !=0) { // checking if jth person is available
                res = Math.min(res, cost[j][i] + solve(i + 1, (mask ^ (1 << j)), n));
            }
        }

        

        return dp[i][mask] = res;

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt(); // number of people
        cost = new int[n][n]; // cost[i][j] -> cost ith person will take for jth job
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = scn.nextInt();
            }
        }
        dp = new int[n][(1 << n)];
        for (int[] d : dp)
            Arrays.fill(d, -1);

        System.out.println(solve(0, (1<<n) - 1, n));

    }
}
