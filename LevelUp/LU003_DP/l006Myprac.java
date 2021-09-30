import java.util.*;

public class l006Myprac {

    public static int frog_I_DP(int n, int[] arr, int idx, int[] dp) {

        if (idx == 0)
            return dp[idx] = 0;

        if (dp[idx] != -1)
            return dp[idx];

        int oneJump = frog_I_DP(n, arr, idx -1, dp) + Math.abs(arr[idx] - arr[idx - 1]);
        if (idx - 2 >= 0) {
            int twoJump = frog_I_DP(n, arr, idx - 2, dp) + Math.abs(arr[idx] - arr[idx - 2]);
            oneJump = Math.min(oneJump, twoJump);
        }

        return dp[idx] = oneJump;

    }

    public static int frog_I(int n, int[] arr) {

        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return frog_I_DP(n, arr, n-1, dp);
    }

    public static void solve() {
        int[] arr = { 10,30,40,20 };
        int n = arr.length;

        System.out.println(frog_I(n, arr));
        
    }

    public static void main(String[] args) {

        solve();
    }
}
