import java.sql.Array;
import java.util.Arrays;

public class q8 {

    long[][] dp;

    Long rec(int M, int m, int i) {

        // if(si>m) return (long)0;

        if (m == 0 || i > 2)
            return (m == 0 ? (long) 1 : (long) 0);

        if (dp[m][i] != -1)
            return dp[m][i];

        // take one step
        long count = 0;
        if (m - i >= 0) {
            count += rec(M, m - i, i);
        }

        count += rec(M, m, i + 1);

        return dp[m][i] = count;

    }

    Long countWays(int m) {

        dp = new long[m + 1][3];

        for (long[] d : dp)
            Arrays.fill(d, (long) -1);

        // int[] jump = new int[]{1,2};
        return rec(m, m, 1);
    }
}
