import java.util.*;

public class l003_LIS {

    // Longest Increasing Sequence

    public int LIS_memo(int[] arr, int ei, int[] dp) {

        if (dp[ei] != 0)
            return dp[ei];

        int maxLen = 1;

        for (int i = ei - 1; i >= 0; i++) {
            if (arr[i] < arr[ei]) {
                int recAns = LIS_memo(arr, i, dp) + 1;
                maxLen = Math.max(maxLen, recAns);
            }
        }

        return dp[ei] = maxLen;
    }

    public int LIS(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];

        int max = 0;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, LIS_memo(arr, i, dp));
        }

        return max;
    }

    public int LIS_LR(int[] nums, int[] dp) {

        // dp ka index represent kr raha hai uspe khtm hone vala longest inc sequence
        int n = nums.length, maxL = 0;
        for (int i = 0; i < n; i++) {

            dp[i] = 1; // by default 1 length to hogi he
            for (int j = i - 1; j >= 0; j--) {

                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            maxL = Math.max(dp[i], maxL);
        }

        return maxL;
    }

    public int LIS_RL(int[] nums, int[] dp) {

        int n = nums.length, maxL = 0;
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            maxL = Math.max(dp[i], maxL);
        }

        return maxL;
    }

    // Longest Decreasing Sequence

    public int LDS_LR(int[] nums, int[] dp) {
        int n = nums.length, maxL = 0;
        for (int i = 0; i < n; i++) {

            dp[i] = 1; // by default 1 length to hogi he
            for (int j = i - 1; j >= 0; j--) {

                if (nums[i] < nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            maxL = Math.max(dp[i], maxL);
        }

        return maxL;
    }

    public int LDS_RL(int[] nums, int[] dp) {
        int n = nums.length, maxL = 0;
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (nums[i] < nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            maxL = Math.max(dp[i], maxL);
        }

        return maxL;

    }

    // Longest Bitonic Sequence

    public int LongestBitonicSequence(int[] nums) {

        int n = nums.length, maxL = 0;
        int[] LIS_LR_DP = new int[n];
        int[] LIR_RL_DP = new int[n];

        LIS_LR(nums, LIS_LR_DP);
        LIS_RL(nums, LIR_RL_DP);

        for (int i = 0; i < n; i++) {

            maxL = Math.max(maxL, LIR_RL_DP[i] + LIS_LR_DP[i] - 1);

        }

        return maxL;

    }

    // Maximum Sum Increasing Sub-Sequence

    public static int LIS_SUM_LR(int[] arr, int n, int[] dp) {

        int maxSum = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = arr[i];
            for (int j = i - 1; j >= 0; j--) {

                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }

            maxSum = Math.max(maxSum, dp[i]);
        }

        return maxSum;
    }

    public static int LIS_SUM_RL(int[] arr, int n, int[] dp) {
        int maxSum = 0;
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = arr[i];
            for (int j = i + 1; j < n; j++) {

                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }

            maxSum = Math.max(maxSum, dp[i]);
        }

        return maxSum;
    }

    public static int maxSumIS(int arr[], int n) {
        int[] dp = new int[n];

        return LIS_SUM_LR(arr, n, dp);
    }

    // Maximum Sum Bitonic SubSequence

    public static int maxSumBS(int arr[], int n) {
        int maxsum = 0;
        int[] LIS_LR_DP = new int[n];
        int[] LIR_RL_DP = new int[n];

        LIS_SUM_LR(arr, n, LIS_LR_DP);
        LIS_SUM_RL(arr, n, LIR_RL_DP);

        for (int i = 0; i < n; i++) {

            maxsum = Math.max(maxsum, LIR_RL_DP[i] + LIS_LR_DP[i] - arr[i]);

        }

        return maxsum;
    }

    // Minimum deletetion required to make array sorted

    public static int LIS_sort(int[] arr, int[] dp) {
        int n = arr.length, maxL = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] >= arr[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }

            maxL = Math.max(maxL, dp[i]);
        }

        return maxL;
    }

    public static int minDele(int[] arr) {
        int[] dp = new int[arr.length];

        return arr.length - LIS_sort(arr, dp);
    }

    // Leetcode 673

    public static int findNumberOfLIS(int[] nums) {

        int n = nums.length;
        int[] dp = new int[n];
        int[] count = new int[n];
        int maxL = 0, maxCount = 0;
        for (int i = 0; i < n; i++) {

            dp[i] = 1;
            count[i] = 1;
            for (int j = i - 1; j >= 0; j--) {

                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        count[i] += count[j];
                    }
                }

            }

            if (dp[i] > maxL) {
                maxL = dp[i];
                maxCount = count[i];
            } else if (dp[i] == maxL) {
                maxCount += count[i];
            }
        }

        return maxCount;
    }

    // Building Bridges

    public int buildingBridges(int[][] arr) {

        Arrays.sort(arr, (a, b) -> {
            return a[1] - b[1];
        });

        int n = arr.length;
        int[] dp = new int[n];
        int maxBridges = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i][0] > arr[j][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            maxBridges = Math.max(maxBridges, dp[i]);
        }

        return maxBridges;
    }


    //354

    public int maxEnvelopes(int[][] envelopes) {
        
        Arrays.sort(envelopes,(a,b)->{
            return a[1] - b[1];
        });
        
        // nlogn
        
        int n = envelopes.length;
        int[] dp = new int[n];
        int max = 0;
        
        // n^2
        for(int i=0;i<n;i++){
            dp[i] = 1;
            for(int j=i-1;j>=0;j--){
                if(envelopes[i][0]>envelopes[j][0] && envelopes[i][1] > envelopes[j][1] ){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            
            max = Math.max(max,dp[i]);
        }
        
        return max;
    }

    public static void main(String[] args) {

    }
}
