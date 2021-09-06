import java.util.*;

public class l002_stringSet {

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

    // Longest Palidromic Subsequence

    public static int lpss(String str, int[][] dp, int i, int j) {

        if (i >= j) {

            return dp[i][j] = (i == j ? 1 : 0);

        }

        if (dp[i][j] != 0)
            return dp[i][j];

        if (str.charAt(i) == str.charAt(j)) {
            return dp[i][j] = lpss(str, dp, i + 1, j - 1) + 2;
        } else {
            return dp[i][j] = Math.max(lpss(str, dp, i + 1, j), lpss(str, dp, i, j - 1));
        }

    }

    public static int lpss_tabu(String str, int[][] dp, int I, int J) {
        int n = str.length();
        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                if (i >= j) {

                    dp[i][j] = (i == j ? 1 : 0);
                    continue;

                }

                if (str.charAt(i) == str.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2; // lpss(str, dp, i + 1, j - 1)+2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]); // Math.max(lpss(str, dp, i + 1, j), lpss(str, dp,
                                                                     // i, j - 1));
                }
            }
        }

        return dp[I][J];

    }

    public static int longestPalindromeSubseq() {
        String s = " bbbab";
        int n = s.length();
        int[][] dp = new int[n][n];

        int x = lpss(s, dp, 0, n - 1);
        display2D(dp);
        return x;

    }

    // Longest common Subsequence

    public static int lcss(String str1, String str2, int n, int m, int[][] dp) {

        if (n == 0 || m == 0) {
            return dp[n][m] = 0;
        }

        if (dp[n][m] != -1)
            return dp[n][m];

        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
            return dp[n][m] = lcss(str1, str2, n - 1, m - 1, dp) + 1;
        } else {
            return dp[n][m] = Math.max(lcss(str1, str2, n - 1, m, dp), lcss(str1, str2, n, m - 1, dp));
        }
    }

    public static int lcss_DP(String str1, String str2, int N, int M, int[][] dp) {
        for (int n = 0; n <= N; n++) {
            for (int m = 0; m <= M; m++) {
                if (n == 0 || m == 0) {
                    dp[n][m] = 0;
                    continue;
                }

                if (str1.charAt(n - 1) == str2.charAt(m - 1))
                    dp[n][m] = dp[n - 1][m - 1] + 1;// lcss(str1, str2, n - 1, m - 1, dp) + 1;
                else
                    dp[n][m] = Math.max(dp[n - 1][m], dp[n][m - 1]);
            }
        }

        return dp[N][M];
    }

    public static int lcss() {
        String text1 = "abcde", text2 = "ace";
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int[] d : dp)
            Arrays.fill(d, -1);

        int n = lcss(text1, text2, text1.length(), text2.length(), dp);
        display2D(dp);
        return n;
    }

    // distinct subsequences

    public static int numDistance(String s, String t, int[][] dp, int n, int m) {

        if (n < m) {
            return dp[n][m] = 0;
        } else if (m == 0) {
            return dp[n][m] = 1;
        }

        if (dp[n][m] != -1)
            return dp[n][m];

        if (s.charAt(n - 1) == t.charAt(m - 1)) {
            dp[n][m] = numDistance(s, t, dp, n - 1, m - 1) + numDistance(s, t, dp, n - 1, m);
        } else {
            dp[n][m] = numDistance(s, t, dp, n - 1, m);
        }

        return dp[n][m];

    }

    public static int numDistance_tabu(String s, String t, int[][] dp, int N, int M) {

        for (int n = 0; n <= N; n++) {
            for (int m = 0; m <= M; m++) {
                if (n < m) {
                    dp[n][m] = 0;
                    continue;
                } else if (m == 0) {
                    dp[n][m] = 1;
                    continue;
                }

                if (s.charAt(n - 1) == t.charAt(m - 1)) {
                    dp[n][m] = dp[n - 1][m - 1] + dp[n - 1][m];// numDistance(s, t, dp, n - 1, m - 1) + numDistance(s,
                                                               // t, dp, n - 1, m);
                } else {
                    dp[n][m] = dp[n - 1][m];// numDistance(s, t, dp, n - 1, m);
                }
            }
        }

        return dp[N][M];

    }

    public static int numDistinct() {
        String s = "rabbbit", t = "rabbit";
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int[] d : dp)
            Arrays.fill(d, -1);

        int x = numDistance(s, t, dp, n, m);

        display2D(dp);
        return x;
    }

    // edit distance

    public static int minDistance(String word1, String word2, int n, int m, int[][] dp) {

        if (n == 0 || m == 0) {
            return dp[n][m] = (n == 0 ? m : m);
        }

        if (word1.charAt(n - 1) == word2.charAt(m - 1)) {
            return dp[n][m] = minDistance(word1, word2, n - 1, m - 1, dp);
        } else {
            int insert = minDistance(word1, word2, n, m - 1, dp);// virtually add
            int delete = minDistance(word1, word2, n - 1, m, dp);
            int replace = minDistance(word1, word2, n - 1, m - 1, dp);
            return dp[n][m] = Math.min(Math.min(insert, delete), replace) + 1;
        }
    }

    // follow up ques
    // q1->what if insert has a cost of p ,delete has a cost of q,replace has a cost
    // of r

    public static int minDistance_f1(String word1, String word2, int n, int m, int[][] dp, int[] cost) {

        if (n == 0 || m == 0) {
            if (m == 0) {
                return dp[n][m] = cost[2] * n;// delete
            } else if (n == 0) {
                return dp[n][m] = m * cost[0];// insert
            }

            return dp[n][m] = 0;

        }

        if (word1.charAt(n - 1) == word2.charAt(m - 1)) {
            return dp[n][m] = minDistance_f1(word1, word2, n - 1, m - 1, dp, cost);
        } else {
            int insert = minDistance_f1(word1, word2, n, m - 1, dp, cost) + cost[0];
            int delete = minDistance_f1(word1, word2, n - 1, m, dp, cost) + cost[1];
            int replace = minDistance_f1(word1, word2, n - 1, m - 1, dp, cost) + cost[2];
            return dp[n][m] = Math.min(Math.min(insert, delete), replace);
        }
    }
    
    // q2-> we have been given three arrays -> insert, delete,replace -> with the
    // cost of inserting ,deleting & replacing any char from a to z

    
    //Wildcard Matching
    public String removeStars(String str){
        if(str.length() == 0) return str;

            StringBuilder sb = new StringBuilder();
            sb.append(str.charAt(0));
            int i  = 1;
            while(i<str.length()){
                while(i<str.length() && sb.charAt(sb.length()-1) == '*' && str.charAt(i)=='*'){
                    i++;
                }

                sb.append(str.charAt(i));
                i++;

            }

            return sb.toString();
    }


    public static void main(String[] args) {

        numDistinct();

    }

}
