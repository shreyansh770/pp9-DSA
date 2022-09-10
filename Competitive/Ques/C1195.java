import java.util.*;

public class C1195 {

    

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[] row1 = new int[n];
        int[] row2 = new int[n];

        for (int i = 0; i < n; i++) {
            row1[i] = scn.nextInt();
        }

        for (int i = 0; i < n; i++) {
            row2[i] = scn.nextInt();
        }

        long[][] dp = new long[n][2];

        // dp[i][0] --> max if we choose from row1 ith col
        // dp[i][1] --> max if we choose from row2 ith col

        dp[0][0] = row1[0];
        dp[0][1] = row2[0];

        for(int i=1;i<n;i++){

            dp[i][0] = Math.max(dp[i-1][0] , dp[i-1][1]+row1[i]);
            dp[i][1] = Math.max(dp[i-1][1] , dp[i-1][0]+row2[i]);
        }

        System.out.println(Math.max(dp[n-1][0],dp[n-1][1]));

    }
}
