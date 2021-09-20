public class l005CutSet {

    public static void display(int[] dp) {
        for (int ele : dp) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    public static void display2D(int[][] dp) {
        for (int[] d : dp) {
            display(d);
        }
        System.out.println();
    }

    public static int mcm_memo(int arr[], int si, int ei, int[][] dp) {

        if (ei - si == 1) {
            return dp[si][ei] = 0;
        }

        if (dp[si][ei] != 0)
            return dp[si][ei];

        int minAns = (int) 1e9;
        for (int cut = si + 1; cut < ei; cut++) {
            int lh = mcm_memo(arr, si, cut, dp);
            int rh = mcm_memo(arr, cut, ei, dp);

            minAns = Math.min(minAns, lh + (arr[si] * arr[cut] * arr[ei]) + rh);
        }

        return dp[si][ei] = minAns;
    }

    public static int mcm_tabu(int arr[], int SI, int EI, int[][] dp) {
        int n = arr.length;

        
        for (int g = 0; g < n; g++) {
            for (int si = SI, ei = g; ei < n; ei++, si++) {

                if (ei - si == 1) {
                    dp[si][ei] = 0;
                    continue;
                }
                int minAns = (int) 1e9;
                for (int cut = si + 1; cut < ei; cut++) {
                    int lh = dp[si][cut]; // mcm_memo(arr, si, cut, dp);
                    int rh = dp[cut][ei]; // mcm_memo(arr, cut, ei, dp);

                    minAns = Math.min(minAns, lh + (arr[si] * arr[cut] * arr[ei]) + rh);
                }

                dp[si][ei] = minAns;
            }
        }

        return dp[SI][EI];
    }


    public static int mcm_tabu_brackets(int arr[], int SI, int EI, int[][] dp) {
        int n = arr.length;

        String[][] sdp = new String[n][n];
        for (int g = 0; g < n; g++) {
            for (int si = SI, ei = g; ei < n; ei++, si++) {

                if (ei - si == 1) {
                    dp[si][ei] = 0;
                    // sdp[si][ei] = (char)()
                    continue;
                }
                int minAns = (int) 1e9;
                for (int cut = si + 1; cut < ei; cut++) {
                    int lh = dp[si][cut]; // mcm_memo(arr, si, cut, dp);
                    int rh = dp[cut][ei]; // mcm_memo(arr, cut, ei, dp);

                    minAns = Math.min(minAns, lh + (arr[si] * arr[cut] * arr[ei]) + rh);
                }

                dp[si][ei] = minAns;
            }
        }

        return dp[SI][EI];
    }

    static int matrixMultiplication(int N, int arr[]) {
        int[][] dp = new int[N][N];

        int ans = mcm_tabu(arr, 0, N - 1, dp);
        display2D(dp);
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 40, 20, 30, 10, 30 };

        matrixMultiplication(arr.length, arr);

    }

}
