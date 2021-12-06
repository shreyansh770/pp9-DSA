import java.util.*;

public class bss {

    // 121
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int dpi0 = 0; // at ith day with 0 transaction
        int dpi1 = -(int) 1e9; // at ith day with 1 transaction

        for (int i = 0; i < n; i++) {
            dpi0 = Math.max(dpi0, dpi1 + prices[i]); // max(rest,sell)
            dpi1 = Math.max(dpi1, 0 - prices[i]); // max(res,buy)
        }

        return dpi0;
    }

    // 122

    public int maxProfit_(int[] prices) {
        // no of transaction allowed are infinte
        int n = prices.length;

        int dpi0 = 0; // at ith day with 0 stock
        int dpi1 = -(int) 1e9; // at ith day with 1 stock

        for (int i = 0; i < n; i++) {

            int dpi_0 = dpi0; // dp[i-1][0]

            dpi0 = Math.max(dpi_0, dpi1 + prices[i]); // max(rest,sell)
            dpi1 = Math.max(dpi1, dpi_0 - prices[i]); // max(res,buy)
        }

        return dpi0;
    }

    // 714
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;

        int dpi0 = 0; // at ith day with 0 stock
        int dpi1 = -(int) 1e9; // at ith day with 1 stock

        for (int i = 0; i < n; i++) {

            int dpi_0 = dpi0; // dp[i-1][0]

            dpi0 = Math.max(dpi_0, dpi1 + prices[i]); // max(rest,sell)
            dpi1 = Math.max(dpi1, dpi_0 - (prices[i] + fee)); // max(res,buy)
        }

        return dpi0;
    }

    // 309
    public int maxProfit__(int[] prices) {

        int n = prices.length;

        int dpi0 = 0; // at ith day with 0 stock
        int dpi0prev = 0;
        int dpi1 = -(int) 1e9; // at ith day with 1 stock

        for (int i = 0; i < n; i++) {

            int dpi_0 = dpi0; // dp[i-1][0]

            dpi0 = Math.max(dpi_0, dpi1 + prices[i]); // max(rest,sell)

            // buy krte time we put cooldown -> i.e rather than checking for 1 day back we
            // are going back 2 days
            dpi1 = Math.max(dpi1, dpi0prev - prices[i]); // max(res,buy)

            dpi0prev = dpi_0;// dp[i-2][0]
        }

        return dpi0;
    }

    // 123
    public int maxProfitk2(int[] prices) {

        int n = prices.length;
        int[][][] dp = new int[n][3][2];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < 3; k++) {
                for (int x = 0; x < 2; x++) {

                    if (k == 0) {

                        if (x == 0) {
                            dp[i][k][x] = 0;
                        } else {
                            dp[i][k][x] = -(int) 1e9;
                        }

                    } else {

                        if (i == 0) {

                            if (x == 0) {
                                dp[i][k][x] = Math.max(0, -(int) 1e9 + prices[i]);
                            } else {
                                dp[i][k][x] = Math.max(-(int) 1e9, 0 - prices[i]);
                            }

                        } else {

                            if (x == 0) {
                                dp[i][k][x] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                            } else {
                                dp[i][k][x] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
                            }
                        }

                    }

                }
            }
        }

        return dp[n - 1][2][0];

    }

    public int maxProfit_ON(int[] prices) {
        // generic form dpikx
        
        int dpi10 = 0;
        int dpi11 = -(int)1e9; 
        
        int dpi20 = 0;
        int dpi21 = -(int)1e9;
         
        // o(n) , O(1)->space
        for(int p : prices){
            
            dpi10 = Math.max(dpi10,dpi11+p); // [rest,sell];
            dpi11 = Math.max(dpi11 , 0-p); // [rest,buy]
                
            dpi20 = Math.max(dpi20,dpi21+p);
            dpi21 = Math.max(dpi21 , dpi10 - p);
            
        }
        
        return Math.max(dpi10,dpi20); // atmost 2 transaction so we can also make profit with 1 transaction
    }

    // 188
    public int maxProfit(int K, int[] prices) {
        int n = prices.length;
        if (n == 0)
            return 0;
        int[][][] dp = new int[n][K + 1][2];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k <= K; k++) {
                for (int x = 0; x < 2; x++) {

                    if (k == 0) {

                        if (x == 0) {
                            dp[i][k][x] = 0;
                        } else {
                            dp[i][k][x] = -(int) 1e9;
                        }

                    } else {

                        if (i == 0) {

                            if (x == 0) {
                                dp[i][k][x] = Math.max(0, -(int) 1e9 + prices[i]);
                            } else {
                                dp[i][k][x] = Math.max(-(int) 1e9, 0 - prices[i]);
                            }

                        } else {

                            if (x == 0) {
                                dp[i][k][x] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                            } else {
                                dp[i][k][x] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
                            }
                        }

                    }

                }
            }
        }

        return dp[n - 1][K][0];
    }



    public static void main(String[] args) {

    }
}
