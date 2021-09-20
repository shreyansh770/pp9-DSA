import java.util.*;

public class l004targetSet {

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

    public static void fill(int[] dp) {
        Arrays.fill(dp, -1);
    }

    public static void fill2D(int[][] dp) {
        for (int[] d : dp)
            fill(d);
    }

    /******************************************************************* */

    public static int permutation(int[] arr, int tar, int[] dp) {
        if (tar == 0)
            return dp[tar] = 1;
        if (dp[tar] != -1)
            return dp[tar];
        int count = 0;
        for (int ele : arr) {
            if (tar - ele >= 0)
                count += permutation(arr, tar - ele, dp);
        }

        return dp[tar] = count;
    }

    public static int permutation_DP(int[] arr, int Tar, int[] dp) {
        dp[0] = 1;
        for (int tar = 1; tar <= Tar; tar++) {
            int count = 0;
            for (int ele : arr) {
                if (tar - ele >= 0)
                    count += dp[tar - ele];
            }
            dp[tar] = count;
        }
        return dp[Tar];
    }


    /******************************************************************* */

    // n and tar dono vary kar rahe hai
    public static int combination_memo(int[] arr, int n, int tar, int[][] dp) {
        if (tar == 0)
            return dp[n][tar] = 1;
        if (dp[n][tar] != -1)
            return dp[n][tar];
        int count = 0;
        for (int i = n; i > 0; i--) {
            if (tar - arr[i - 1] >= 0)
                count += combination_memo(arr, i, tar - arr[i - 1], dp);
        }

        return dp[n][tar] = count;
    }

    public static int combination_DP(int[] arr, int Tar, int[] dp) {
        dp[0] = 1;

        // har ek coin ke liye sare possibble target dekhenge
        for (int ele : arr) {
            for (int tar = ele; tar <= Tar; tar++) {
                if (tar - ele >= 0)
                    dp[tar] += dp[tar - ele];
            }
        }
        return dp[Tar];
    }

    public int combination(int[] nums , int target , int idx,int[] dp){
        
        if(target==0) return dp[target] =1;
        
        if(dp[target]!=-1) return dp[target];
        
        
        int count = 0;
        for(int i=idx-1;i>=0;i--){
            if(target - nums[i]>=0){
                count+=combination(nums,target-nums[i],nums.length,dp);
            }
        }
        
        return dp[target] = count;

    }
    
    public int combinationSum4(int[] nums, int target) {
        
        int[] dp = new int[target+1];
        Arrays.fill(dp,-1);
        return combination(nums,target,nums.length,dp);
    }

    // Coin Change
    public int coinChange(int[] arr, int Tar) {
        int[] dp = new int[Tar + 1];
        Arrays.fill(dp, (int) 1e9);
        dp[0] = 0;
        for (int tar = 1; tar <= Tar; tar++) {
            for (int ele : arr) {
                if (tar - ele >= 0)
                    dp[tar] = Math.min(dp[tar - ele] + 1, dp[tar]);
            }
        }
        return dp[Tar] != (int) 1e9 ? dp[Tar] : -1;
    }

    /******************************************************* */


    public static void target() {
        int[] arr = { 2, 3, 5, 7 };
        int tar = 10;
        int[] dp = new int[tar + 1];
        // fill(dp); // dont fill for combi tabu

        // int[][] dp = new int[arr.length + 1][tar + 1];
        // fill2D(dp);

        // System.out.println(permutation(arr, tar, dp));
        System.out.println(combination_DP(arr, tar,dp));
        // display2D(dp);

        display(dp);
    }


    /******************************************************* */

    public static int targetSum(int[] arr, int n, int tar, int[][] dp) {
        if (n == 0 || tar == 0) {
            return dp[n][tar] = (tar == 0 ? 1 : 0);
        }

        if (dp[n][tar] != -1)
            return dp[n][tar];

        boolean res = false;
        if (tar - arr[n - 1] >= 0)
            res = res || targetSum(arr, n - 1, tar - arr[n - 1], dp) == 1;
        res = res || targetSum(arr, n - 1, tar, dp) == 1;

        return dp[n][tar] = res ? 1 : 0;
    }


    public static boolean targetSum_DP(int[] arr,int N,int Tar,boolean[][] dp){
        for(int n=0;n<=N;n++){
             for(int tar=0;tar<=Tar;tar++){
                if (n == 0 || tar == 0) {
                    dp[n][tar] = (tar == 0 ? true : false);
                    continue;
                } 

                if(tar-arr[n-1]>=0)
                     dp[n][tar] = dp[n][tar] || dp[n-1][tar-arr[n-1]];
                     
                dp[n][tar] = dp[n][tar] || dp[n - 1][tar];   
             }
        }

        return dp[N][Tar];
    }

    public static int targetSum_path(int[] arr, int N, boolean[][] dp, int tar, String psf) {

        if(N==0 || tar == 0){
            if(tar == 0){

                System.out.println(psf +" ");
                return 1;
            }

            return 0;
        }


        int count=0;
        if(tar-arr[N-1] >=0 && dp[N-1][tar-arr[N-1]]){
            count += targetSum_path(arr, N-1, dp, tar-arr[N-1], psf+""+arr[N-1]+" ");
        }

        if(dp[N-1][tar]){
            count+= targetSum_path(arr, N-1, dp, tar, psf+""+arr[N-1]+" ");
        }

        return count;
    }


    public static void targetSum_backEngg() {
        int[] arr = { 2, 3, 5, 7 };
        int tar = 10, N = 4;
        boolean[][] dp = new boolean[N + 1][tar + 1];
        System.out.println(targetSum_DP(arr, N, tar, dp));
        System.out.println(targetSum_path(arr, N, dp, tar, ""));
    }

    public static Boolean isSubsetSum(int N, int arr[], int sum) {
        int[][] dp = new int[N + 1][sum + 1];
        
        for (int[] d : dp)
            Arrays.fill(d, -1);

        int ans = targetSum(arr, N, sum, dp);

        display2D(dp);
        return ans == 1;
    }



    /************************************************************/

    public static int knapSack(int W, int wt[], int val[], int n,int[][] dp) { 
         
        if(n==0 || W == 0) return dp[n][W] = 0;

        if(dp[n][W]!=-1) return dp[n][W];

        int maxAns = -(int)1e9;
        if(W - wt[n-1]>=0){
            maxAns = Math.max(maxAns , knapSack(W-wt[n-1],wt,val,n-1,dp) + val[n-1]);
        }

        maxAns = Math.max(maxAns , knapSack(W,wt,val,n-1,dp));


        return dp[n][W] = maxAns;
    }



    /************************************************************/
     
    // Find number of solutions of a linear equation of n variables

    public static int countSol(int[] coeff , int rhs , int idx,int[] dp){
 
        if(rhs == 0){

            return dp[idx] = 1;
        }

        int count = 0;
        for(int i=idx;i<coeff.length;i++){

            if(rhs - coeff[i]>=0){
               count+= countSol(coeff, rhs-coeff[i], 0, dp);
            }
        }

        return dp[rhs] =count;

    }

    /*************************************************************** */

    // Unbounded knapsack

    public static void main(String[] args) {

       int N = 4;
       int arr[] = {2,3,5,7};
       int sum = 10  ;    

        isSubsetSum(N,arr,sum);

    }

}
