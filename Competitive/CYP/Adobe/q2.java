import java.util.*;

public class q2 {

    int lengthOfLongestAP(int[] A, int n) {
        
        // dp[i][j] length of longest ap till i with diffrence d

        int[][] dp = new int[n+1][10005];

        int max = 0;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                int d = A[i] - A[j];
                dp[i][d] = Math.max(dp[j][d]+1,dp[i][d]);
                max = Math.max(max,dp[i][d]);
            }
        }

        return max+1;
    }

}
