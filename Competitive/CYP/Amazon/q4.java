
//User function Template for Java

class Solution{

    public static String mcm_tabu_brackets(int arr[], int SI, int EI, int[][] dp) {
        int n = arr.length;

        String[][] sdp = new String[n][n];
        for (int g = 0; g < n; g++) {
            for (int si = SI, ei = g; ei < n; ei++, si++) {

                if (ei - si == 1) {
                    dp[si][ei] = 0;
                    sdp[si][ei] = (char)(si+'A') + "";
                    continue;
                }

                int minAns = (int) 1e9;
                String minStr = "";
                for (int cut = si + 1; cut < ei; cut++) {
                    int lh = dp[si][cut]; // mcm_memo(arr, si, cut, dp);
                    int rh = dp[cut][ei]; // mcm_memo(arr, cut, ei, dp);

                    if(lh + (arr[si] * arr[cut] * arr[ei]) + rh < minAns){
                       minAns =  lh + (arr[si] * arr[cut] * arr[ei]) + rh;

                       minStr = "(" + sdp[si][cut] + sdp[cut][ei] + ")";
                    }

                    
                }

                dp[si][ei] = minAns;
                sdp[si][ei] = minStr; 
            }
        }

        return sdp[SI][EI];
    }
    
    
    static String matrixChainOrder(int arr[], int N){
        int[][] dp = new int[N][N];

        return mcm_tabu_brackets(arr, 0, N - 1, dp);
    }