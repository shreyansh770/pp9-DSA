public class q1 {
    static int maxProfit(int K, int N, int price[]) {
        // code here
        int[][][] dp = new int[N][K + 1][2]; // dp[days][transaction][state] -> state(0,1) -> 0 means no active stock on
                                             // ith day ; 1-> 1 active stock on ith day

        // dp[i][k][0] -> maximum profit made till ith day with k transaction w/o any
        // active stock
        // dp[i][k][1] -> maximum profit made till ith day with k transactions with 1
        // ative stock

        for (int i = 0; i < N; i++) {
            for (int k = 0; k <= K; k++) {
                for (int x = 0; x < 2; x++) {

                    if (k == 0) {
                        if (x == 0) {
                            dp[i][k][x] = 0;
                        } else {
                            dp[i][k][x] = -(int) 1e9; // we have made no transcation till now but we have 1 stock which is not possible
                        }

                    } else {

                        if (i == 0) {
                            // on 0th day
                            if (x == 0) {
                                dp[i][k][x] = 0;
                            } else {
                                dp[i][k][1] = - price[i];
                            }
                        } else {

                            if (x == 0) {
                                dp[i][k][x] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + price[i]); // (rest,sell)
                            } else {
                                dp[i][k][x] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - price[i]); // (rest,buy)
                            }
                        }

                    }

                }
            }
        }

        return dp[N - 1][K][0];//
    }
}
