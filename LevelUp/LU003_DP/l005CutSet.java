
import java.util.*;

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

    static int matrixMultiplication(int N, int arr[]) {
        int[][] dp = new int[N][N];

        int ans = mcm_memo(arr, 0, N - 1, dp);
        display2D(dp);
        return ans;
    }


    // Minimum and Maximum values of an expression with * and +


    public static class pairmm {
        int min = (int) 1e9;
        int max = 0;

        pairmm() {

        }

        pairmm(int val) {
            this.min = this.max = val;
        }
    }

    public static pairmm evaluateMinMax(pairmm leftRes, pairmm rightRes, char operator) {
        pairmm pair = new pairmm();
        if (operator == '+') {
            pair.min = leftRes.min + rightRes.min;
            pair.max = leftRes.max + rightRes.max;
        } else if (operator == '*') {
            pair.min = leftRes.min * rightRes.min;
            pair.max = leftRes.max * rightRes.max;
        }
        return pair;
    }

    public static pairmm minMax(String str, int si, int ei, pairmm[][] dp) {
        if (si == ei) {
            return dp[si][ei] = new pairmm((str.charAt(si) - '0'));
        }

        if (dp[si][ei] != null)
            return dp[si][ei];

        pairmm myRes = new pairmm();
        for (int cut = si + 1; cut < ei; cut += 2) {
            pairmm leftRes = minMax(str, si, cut - 1, dp);
            pairmm rightRes = minMax(str, cut + 1, ei, dp);
            pairmm pair = evaluateMinMax(leftRes, rightRes, str.charAt(cut));

            myRes.min = Math.min(myRes.min, pair.min);
            myRes.max = Math.max(myRes.max, pair.max);
        }

        return dp[si][ei] = myRes;
    }

    public static void mmve() {
        String str = "1+2*3+4*5";
        int n = str.length();
        pairmm[][] dp = new pairmm[n][n];

        pairmm res = minMax(str, 0, n - 1, dp);

        System.out.println("Min value: " + res.min);
        System.out.println("Max value: " + res.max);
    }


    // burst ballons

    public int maxCoins(int[] arr, int si ,int ei ,int[][] dp){
        
        if(si > ei) return 0;
        
        if(si == ei){
            
            return dp[si][ei] = (si == 0 ? 1 : arr[si-1]) * arr[si] * (ei == arr.length-1 ? 1 :arr[ei+1]);
        }
        
        if(dp[si][ei]!=-1) return dp[si][ei];
        
        
        int maxAns = -(int)1e9;
        for(int bI = si;bI<=ei;bI++){
            
            int left = maxCoins(arr,si,bI-1,dp);
            int right = maxCoins(arr,bI+1,ei,dp);
            
            int myAns = (si==0 ? 1 : arr[si-1]) * (arr[bI]) * (ei==arr.length-1 ? 1 : arr[ei+1]);
            
            maxAns = Math.max(maxAns , left + myAns + right);
        }
        
        
        return dp[si][ei] = maxAns;
    }
    
    
    public int maxCoins(int[] nums) {
        
        
        int n = nums.length;
        
        int[][] dp = new int[n][n];
        
        for(int[] d : dp) Arrays.fill(d,-1);
        
        return maxCoins(nums,0,n-1,dp);
        
        
        
    }

    // boolean parenthesis

    public static class pairBoolen {
        long totalTrue = 0;
        long totalFalse = 0;

        pairBoolen(long totalTrue, long totalFalse) {
            this.totalFalse = totalFalse;
            this.totalTrue = totalTrue;
        }

        pairBoolen() {

        }
    }

    public static void evaluateTrue(pairBoolen left, pairBoolen right, pairBoolen res, char operator) {
        long mod = 1003;
        long totalTF = ((left.totalTrue + left.totalFalse) * (right.totalTrue + right.totalFalse)) % mod;
        long totalTrue = 0, totalFalse = 0;
        if (operator == '|') {
            totalFalse = (left.totalFalse * right.totalFalse) % mod;
            totalTrue = (totalTF - totalFalse + mod) % mod;
        } else if (operator == '^') {
            totalTrue = (left.totalFalse * right.totalTrue) % mod + (left.totalTrue * right.totalFalse) % mod;
            totalFalse = (totalTF - totalTrue + mod) % mod;

        } else if (operator == '&') {
            totalTrue = (left.totalTrue * right.totalTrue) % mod;
            totalFalse = (totalTF - totalTrue + mod) % mod;
        }

        res.totalFalse = (res.totalFalse + totalFalse) % mod;
        res.totalTrue = (res.totalTrue + totalTrue) % mod;
    }

    public static pairBoolen countWays(String S, int si, int ei, pairBoolen[][] dp) {
        if (si == ei) {
            char ch = S.charAt(si);
            int t = ch == 'T' ? 1 : 0;
            int f = ch == 'F' ? 1 : 0;
            return dp[si][ei] = new pairBoolen(t, f);
        }
        if (dp[si][ei] != null) {
            return dp[si][ei];
        }

        pairBoolen res = new pairBoolen();
        for (int cut = si + 1; cut < ei; cut += 2) {
            pairBoolen lres = countWays(S, si, cut - 1, dp);
            pairBoolen rres = countWays(S, cut + 1, ei, dp);

            evaluateTrue(lres, rres, res, S.charAt(cut));
        }

        return dp[si][ei] = res;
    }

    static int countWays(int N, String S) {
        pairBoolen[][] dp = new pairBoolen[N][N];
        return (int)countWays(S, 0, N - 1, dp).totalTrue;
    }


















    public static void main(String[] args) {
        int[] arr = { 40, 20, 30, 10, 30 };

        // matrixMultiplication(arr.length, arr);
        mmve();

    }

}
