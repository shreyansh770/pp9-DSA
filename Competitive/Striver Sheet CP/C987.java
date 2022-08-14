import java.util.*;

public class C987 {

    // static long[][] dp;

    // public static long minCost(long[] size, long[] cost, int idx, int ssf, long
    // lp) {

    // if (ssf == 3 )
    // return 0;

    // if(idx==size.length) return (long) 1e18;

    // if (dp[idx][ssf] !=-1)
    // return dp[idx][ssf];

    // if (size[idx] > lp) {

    // long inc = cost[idx] + minCost(size, cost, idx + 1, ssf + 1, size[idx]);
    // long ninc = minCost(size, cost, idx + 1, ssf, lp);

    // return dp[idx][ssf] = Math.min(inc, ninc);
    // } else {
    // return dp[idx][ssf] = minCost(size, cost, idx + 1, ssf, lp);
    // }
    // }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        long[] size = new long[n];

        for (int i = 0; i < n; i++) {
            size[i] = scn.nextLong();
        }

        long[] cost = new long[n];

        for (int i = 0; i < n; i++) {
            cost[i] = scn.nextLong();
        }

        // dp = new long[n + 1][4];

        // for (long[] d : dp) {
        // Arrays.fill(d, -1);
        // }

        // long res = minCost(size, cost, 0, 0, 0);

        // if(res==(long)1e18){
        // System.out.println(-1);
        // }else{
        // System.out.println(res);
        // }

        long[][] csf = new long[n + 1][3]; // csf[i][j] it we are picking ith element and it is the jth(1,2,3) elemt of
                                           // our series

        // csf[i][0] -> this means i is the first element in series => cost[i]
        // csf[i][1] -> it i the scd ele => min(csf[i][1] , cost[i] + csf[j][0]) where
        // 0<=j<i
        // csf[i][2] -> it i the third ele => min(csf[i][2] , cost[i] + csf[j][1]) where
        // 0<=j<i
        for(long[] cf : csf){
            Arrays.fill(cf, (long) 1e18);

        }

        long mn = (long) 1e18;

        for (int i = 0; i < n; i++) {

            csf[i][0] = cost[i];

            for (int j = 0; j < i; j++) {
                if (size[i] > size[j]) {
                    csf[i][1] = Math.min(csf[i][1], cost[i] + csf[j][0]);
                    csf[i][2] = Math.min(csf[i][2], cost[i] + csf[j][1]);
                }
            }

            mn = Math.min(mn, csf[i][2]); // valid only if ith ele contributes in being the third element of the seq
        }

        if (mn == (long) 1e18) {
            System.out.println(-1);
        } else
            System.out.println(mn);

    }
}
