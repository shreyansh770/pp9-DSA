public class q5 {
    // well after seeing discussion i came to know about binary search is also a
    // possible solution
    // but to be fair dynamic programming is the solution is the one which i would
    // be able to come up
    // with in the interviews

    // It is a typical cut stratergy question

    // in which dp[i][m] would min possible sum for subarray from ith index with m
    // parts remaining

    int[][] dp;
    int[] pefixArray;

    public int memo(int[] nums, int si, int ei, int m) {

        // if there is only one split left
        if (m == 1) {
            return si == 0 ? pefixArray[ei] : pefixArray[ei] - pefixArray[si - 1];
        }

        if (dp[si][m] != -1)
            return dp[si][m];

        int minMax = (int) 1e9;
        for (int cut = si; cut < ei; cut++) {

            int mySum = si == 0 ? pefixArray[cut] : pefixArray[cut] - pefixArray[si - 1];

            int recAns = memo(nums, cut + 1, ei, m - 1);
            minMax = Math.min(minMax, Math.max(mySum, recAns));

        }

        dp[si][m] = minMax;
        return minMax;
    }

    public int splitArray(int[] nums, int m) {

        int n = nums.length;

        dp = new int[n][m + 1];
        pefixArray = new int[n];

        pefixArray[0] = nums[0];

        for (int i = 1; i < n; i++) {
            pefixArray[i] = pefixArray[i - 1] + nums[i];
        }

        for (int[] d : dp)
            Arrays.fill(d, -1);

        return memo(nums, 0, n - 1, m);

    }
}
