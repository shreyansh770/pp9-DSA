import java.util.*;

public class l001_twoPointerSet {
    // 1_Faith
    // 2_Recursive_Tree
    // 3_RecursiveCode->Memoization
    // 4_Observation
    // 5_Tabulation
    // 6_Optimization

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

    /*********************************************/

    public static int fibo_memo(int n, int[] dp) {
        if (n <= 1)
            return dp[n] = n;

        if (dp[n] != 0)
            return dp[n];

        int ans = fibo_memo(n - 1, dp) + fibo_memo(n - 2, dp);
        return dp[n] = ans;
    }

    public static int fibo_tabu(int N, int[] dp) {
        for (int n = 0; n <= N; n++) {
            if (n <= 1) {
                dp[n] = n;
                continue;
            }

            int ans = dp[n - 1] + dp[n - 2];// fibo_memo(n - 1, dp) + fibo_memo(n - 2, dp);
            dp[n] = ans;
        }

        return dp[N];
    }

    public static int fibo_opti(int N) {
        int a = 0, b = 1;
        for (int i = 2; i <= N; i++) {
            int sum = a + b;
            a = b;
            b = sum;
        }

        return b;
    }

    public static void fibo() {
        int n = 10;
        int[] dp = new int[n + 1];
        // System.out.println(fibo_memo(n, dp));
        // System.out.println(fibo_tabu(n, dp));
        System.out.println(fibo_opti(n));

        // display(dp);
    }

    /*********************************************/

    public static int mazePath_memo(int sr, int sc, int er, int ec, int[][] dp, int[][] dir) {
        if (er == sr && ec == sc) {
            return dp[sr][sc] = 1;
        }

        if (dp[sr][sc] != 0)
            return dp[sr][sc];

        int count = 0;
        for (int[] d : dir) {
            int r = sr + d[0], c = sc + d[1];
            if (r >= 0 && c >= 0 && r < dp.length && c < dp[0].length) {
                count += mazePath_memo(r, c, er, ec, dp, dir);
            }
        }

        return dp[sr][sc] = count;
    }

    public static int mazePath_tabu(int SR, int SC, int ER, int EC, int[][] dp, int[][] dir) {
        for (int sr = ER; sr >= SR; sr--) {
            for (int sc = EC; sc >= SC; sc--) {
                if (ER == sr && EC == sc) {
                    dp[sr][sc] = 1;
                    continue;
                }

                int count = 0;
                for (int[] d : dir) {
                    int r = sr + d[0], c = sc + d[1];
                    if (r >= 0 && c >= 0 && r < dp.length && c < dp[0].length) {
                        count += dp[r][c];// mazePath_memo(r, c, er, ec, dp, dir);
                    }
                }

                dp[sr][sc] = count;
            }
        }

        return dp[SR][SC];
    }

    public static int mazePathJump_tabu(int SR, int SC, int ER, int EC, int[][] dp, int[][] dir) {
        for (int sr = ER; sr >= SR; sr--) {
            for (int sc = EC; sc >= SC; sc--) {
                if (ER == sr && EC == sc) {
                    dp[sr][sc] = 1;
                    continue;
                }

                int count = 0;
                for (int[] d : dir) {
                    int r = sr + d[0], c = sc + d[1];
                    while (r >= 0 && c >= 0 && r < dp.length && c < dp[0].length) {
                        count += dp[r][c];// mazePath_memo(r, c, er, ec, dp, dir);
                        r += d[0];
                        c += d[1];
                    }
                }
                dp[sr][sc] = count;
            }
        }

        return dp[SR][SC];
    }

    public static void mazePath() {
        int sr = 0, sc = 0, er = 3, ec = 3;
        int[][] dp = new int[er + 1][ec + 1];

        int[][] dir = { { 1, 0 }, { 0, 1 }, { 1, 1 } };
        System.out.println(mazePathJump_tabu(sr, sc, er, ec, dp, dir));

        display2D(dp);
    }

    /*********************************************/

    public static int dice_memo(int sp, int ep, int[] dp) {

        if (sp == ep) {
            return dp[ep] = 1;
        }

        if (dp[sp] != 0)
            return dp[sp];

        int count = 0;
        for (int i = 1; i <= 6; i++) {
            count += dice_memo(sp + i, ep, dp);
        }

        return dp[sp] = count;

    }

    public static int dice_tabul(int Sp, int ep, int[] dp) {

        for (int sp = ep; sp >= 0; sp--) {

            if (sp == ep) {
                dp[sp] = 1;
                continue;
            }

            int count = 0;
            for (int i = 1; i <= 6 && sp + i <= ep; i++) {
                count += dp[sp + i];
            }
            dp[sp] = count;
        }

        return dp[Sp];

    }

    /***********************************************************/

    /* LeetCode -91 */
    public static int decode_memo(String s, int idx, int[] dp) {

        if (idx == s.length()) {
            return dp[idx] = 1;
        }

        if (dp[idx] != -1)
            return dp[idx];

        char ch = s.charAt(idx);

        if (ch == '0')
            return dp[idx] = 0;

        int count = decode_memo(s, idx + 1, dp);

        if (idx < s.length() - 1) {
            char ch1 = s.charAt(idx + 1);
            int num = (ch - '0') * 10 + (ch1 - '0');
            if (num <= 26)
                count += decode_memo(s, idx + 2, dp);
        }

        return dp[idx] = count;

    }

    public static int decode_tabu(String s, int IDX, int[] dp) {

        for (int idx = s.length(); idx >= 0; idx--) {
            if (idx == s.length()) {
                dp[idx] = 1;
                continue;
            }

            char ch = s.charAt(idx);

            if (ch == '0') {
                dp[idx] = 0;
                continue;
            }

            int count = dp[idx + 1];// decode_memo(s,idx+1,dp);

            if (idx < s.length() - 1) {
                char ch1 = s.charAt(idx + 1);
                int num = (ch - '0') * 10 + (ch1 - '0');
                if (num <= 26)
                    count += dp[idx + 2]; // decode_memo(s,idx+2,dp);
            }

            dp[idx] = count;
        }

        return dp[IDX];

    }

    /* LeetCode -639 */
    static int mod = (int) 1e9 + 7;

    public static long decode02_memo(String str, int idx, long[] dp) {
        int n = str.length();
        if (idx == str.length()) {
            return dp[idx] = 1;
        }

        if (dp[idx] != -1)
            return dp[idx];

        char ch = str.charAt(idx);
        if (ch == '0') {
            return dp[idx] = 0;
        }

        long count = 0;
        if (ch == '*') {
            count = (count + 9 * decode02_memo(str, idx + 1, dp)) % mod;// * kuch bhi ho age same he string jygea
            if (idx < n - 1) {
                char ch1 = str.charAt(idx + 1);
                if (ch1 >= '0' && ch1 <= '6') {
                    count = (count + 2 * decode02_memo(str, idx + 2, dp)) % mod;
                } else if (ch1 >= '7' && ch1 <= '9') {
                    count = (count + decode02_memo(str, idx + 2, dp)) % mod;
                } else {
                    count = (count + 15 * decode02_memo(str, idx + 2, dp)) % mod;// 11
                                                                                 // ,12,13,14,15,16,17,18,19,21,22,23,24,25,26
                }
            }
        } else {
            count += decode02_memo(str, idx + 1, dp) % mod;
            // 2 digit
            if (idx < n - 1) {
                char ch1 = str.charAt(idx + 1);
                if (ch1 == '*' && ch == '1') {
                    count = (count + 9 * decode02_memo(str, idx + 1, dp)) % mod;
                } else if (ch1 == '*' && ch == '2') {
                    count = (count + 6 * decode02_memo(str, idx + 1, dp)) % mod;
                } else if (ch1 != '*') {
                    int num = (ch - '0') * 10 + (ch1 - '0');
                    if (num < 26)
                        count = (count + decode02_memo(str, idx + 2, dp)) % mod;
                }
            }
        }

        return dp[idx] = count;
    }

    public static long decode02_tabu(String s, int IDX, long[] dp) {
        for (int idx = s.length(); idx >= 0; idx--) {
            if (idx == s.length()) {
                dp[idx] = 1;
                continue;
            }

            if (s.charAt(idx) == '0') {
                dp[idx] = 0;
                continue;
            }

            long count = 0;

            char ch1 = s.charAt(idx);
            if (ch1 == '*') {
                count = (count + 9 * dp[idx + 1]) % mod;

                if (idx < s.length() - 1) {
                    if (s.charAt(idx + 1) == '*')
                        count = (count + 15 * dp[idx + 2]) % mod;
                    else if (s.charAt(idx + 1) >= '0' && s.charAt(idx + 1) <= '6')
                        count = (count + 2 * dp[idx + 2]) % mod;
                    else if (s.charAt(idx + 1) >= '7')
                        count = (count + dp[idx + 2]) % mod;
                }
            } else {
                count = (count + dp[idx + 1]) % mod;

                if (idx < s.length() - 1) {
                    if (s.charAt(idx + 1) != '*') {
                        int num = (s.charAt(idx) - '0') * 10 + (s.charAt(idx + 1) - '0');
                        if (num <= 26)
                            count = (count + 1 * dp[idx + 2]) % mod;
                    } else {
                        if (ch1 == '1')
                            count = (count + 9 * dp[idx + 2]) % mod;
                        else if (ch1 == '2')
                            count = (count + 6 * dp[idx + 2]) % mod;
                    }
                }
            }

            dp[idx] = count;
        }

        return dp[IDX];
    }

    public static int numDecodings(String s) {
        int n = s.length();
        long[] dp = new long[n + 1];

        Arrays.fill(dp, -1);

        int ans = (int) decode02_memo(s, 0, dp);
        // display(dp);

        return ans;
    }

    public static int gold(int n, int m, int sr, int sc, int arr[][], int[][] dp, int[][] dir) {

        if (sc == m - 1) {
            return dp[sr][sc] = arr[sr][sc];
        }

        int maxVal = 0;
        if (dp[sr][sc] != -1)
            return dp[sr][sc];

        for (int[] d : dir) {
            int r = sr + d[0];
            int c = sc + d[1];

            if (r >= 0 && c >= 0 && r < n && c < m) {
                maxVal = Math.max(gold(n, m, r, c, arr, dp, dir) + arr[sr][sc], maxVal);
            }
        }

        return dp[sr][sc] = maxVal;
    }

    public static int maxGold(int n, int m, int M[][]) {
        int[][] dir = { { 0, 1 }, { -1, 1 }, { 1, 1 } };
        int[][] dp = new int[n][m];

        for (int[] d : dp)
            Arrays.fill(d, -1);
        int gold = 0;
        for (int r = 0; r < n; r++) {
            gold = Math.max(gold, gold(n, m, r, 0, M, dp, dir));
        }

        display2D(M);
        System.out.println();
        display2D(dp);
        return gold;

    }


    public long countFriendsPairing_memo(int n,long[] dp){
        
        if(n == 0){
            return dp[n] = 1;
        }

        if(dp[n]!=-1) return dp[n];

        long single = countFriendsPairing_memo(n-1,dp);
        long pairUp = n-2>=0 ?countFriendsPairing_memo(n-2,dp)*(n-1) : 0;

        return dp[n] = (single + pairUp)%mod;
    }


    public long countFriendsPairing_tabu(int n,long[] dp){

        for(int i=0;i<=n;i++){
            if(n <= 1){
                 dp[n] = 1;
                 continue;
            }

            dp[i] = (dp[i-1] + (dp[i-2]*(i-1))%mod)%mod;
        }
        
        return dp[n];

       
    }

    // top down
    public static int divideInKGroup(int n, int k, int[][] dp) {
        if (n == k || k == 1) {
            return dp[n][k] = 1;
        }

        if (dp[n][k] != 0)
            return dp[n][k];

        int selfGroup = divideInKGroup(n - 1, k - 1, dp);
        int partOfGroup = divideInKGroup(n - 1, k, dp) * k;// usne kaha ke tum apne grps bna lo mai kisi ke sath bhi a jauga

        return dp[n][k] = selfGroup + partOfGroup;
    }

    // bottom top
    public static int divideInKGroup_tabu(int N, int K, int[][] dp) {

        // n != 0 && k!=0
        for(int n =1;n<=N;n++){
            for(int k=1;k<=K;k++){
                if (n == k || k == 1) {
                    dp[n][k] = 1;
                    continue;
                }

                dp[n][k] = dp[n-1][k-1] + dp[n-1][k]*k;
            }
        }

        return dp[N][K];
    }

    

    public static void divideInKGroup() {
        int n = 5;
        int k = 3;

        int[][] dp = new int[n + 1][k + 1];
        System.out.println(divideInKGroup(n, k, dp));
        display2D(dp);
    }



    public static void main(String[] args) {
        // fibo();
        int[][] arr = { { 10, 33, 13, 15 }, { 22, 21, 04, 1 }, { 5, 0, 2, 3 }, { 0, 6, 14, 2 } };
        // maxGold(arr.length, arr[0].length, arr);
        divideInKGroup();
    }

}