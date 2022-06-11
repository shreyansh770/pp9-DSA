public class q7 {

    static Integer[][] dp;
    public static int rec(int[] A, int n, int si, int ei) {

        if(si>ei) return 0;

        if(si==ei) return dp[si][ei] = A[ei];

        if(dp[si][ei]!=null) return dp[si][ei];

        // if bob take ith pot
        int ith = A[si] + Math.min(rec(A, n, si + 2, ei), rec(A, n, si + 1, ei - 1));

        // if bob take jth pot

        int jth = A[ei] + Math.min(rec(A, n, si + 1, ei-1), rec(A, n, si , ei - 2));

        return dp[si][ei] =  Math.max(ith, jth);

    }

    public static int maxCoins(int A[], int n) {

        dp = new Integer[n+1][n+1];
        return rec(A,n,0,A.length-1);
    }
}
