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

    // Wildcard Matching
    public String removeStars(String str) {
        if (str.length() == 0)
            return str;

        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0));

        int i = 1;
        while (i < str.length()) {
            while (i < str.length() && sb.charAt(sb.length() - 1) == '*' && str.charAt(i) == '*')
                i++;

            if (i < str.length())
                sb.append(str.charAt(i));
            i++;
        }

        return sb.toString();
    }

    public int isMatch(String s, String p, int n, int m, int[][] dp) {
        if (n == 0 || m == 0) {
            if (n == 0 && m == 0)
                return dp[n][m] = 1; // true
            else if (m == 1 && p.charAt(m - 1) == '*')
                return dp[n][m] = 1;
            else
                return dp[n][m] = 0;
        }

        if (dp[n][m] != -1)
            return dp[n][m];

        char ch1 = s.charAt(n - 1);
        char ch2 = p.charAt(m - 1);

        if (ch1 == ch2 || ch2 == '?') {
            return dp[n][m] = isMatch(s, p, n - 1, m - 1, dp);
        } else if (ch2 == '*') {
            boolean res = false;
            res = res || isMatch(s, p, n - 1, m, dp) == 1; // sequnence of character
            res = res || isMatch(s, p, n, m - 1, dp) == 1; // empty string

            return dp[n][m] = res ? 1 : 0;

        } else
            return dp[n][m] = 0;
    }

    public boolean isMatch(String s, String p) {
        p = removeStars(p);
        int n = s.length(), m = p.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int[] d : dp)
            Arrays.fill(d, -1);

        int ans = isMatch(s, p, n, m, dp);

        return ans == 1;
    }

    // REGEX
    public int isMatch_(String s, String p, int n, int m, int[][] dp) {
        if (n == 0 && m == 0)
            return dp[n][m] = 1;
        if (m == 0)
            return dp[n][m] = 0;

        if (dp[n][m] != -1)
            return dp[n][m];

        char ch1 = n > 0 ? s.charAt(n - 1) : '$';
        char ch2 = p.charAt(m - 1);

        if (ch1 != '$' && (ch1 == ch2 || ch2 == '.'))
            return dp[n][m] = isMatch_(s, p, n - 1, m - 1, dp);
        else if (ch2 == '*') {
            boolean res = false;

            if (n > 0 && m > 1 && (p.charAt(m - 2) == '.' || p.charAt(m - 2) == ch1))
                res = res || isMatch_(s, p, n - 1, m, dp) == 1;
            res = res || isMatch_(s, p, n, m - 2, dp) == 1;

            return dp[n][m] = res ? 1 : 0;
        } else
            return dp[n][m] = 0;
    }

    public boolean isMatch_(String s, String p) {
        p = removeStars(p);
        int n = s.length(), m = p.length();

        int[][] dp = new int[n + 1][m + 1];
        for (int[] d : dp)
            Arrays.fill(d, -1);

        return isMatch_(s, p, n, m, dp) == 1;
    }
    // Uncrossed lines

    public int unCrossed(int[] nums1, int[] nums2, int n, int m, int[][] dp) {

        if (n == 0 || m == 0) {
            return dp[n][m] = 0;
        }

        if (dp[n][m] != -1)
            return dp[n][m];

        if (nums1[n - 1] == nums2[m - 1]) {
            return dp[n][m] = unCrossed(nums1, nums2, n - 1, m - 1, dp) + 1;
        } else {
            return dp[n][m] = Math.max(unCrossed(nums1, nums2, n - 1, m, dp), unCrossed(nums1, nums2, n, m - 1, dp));
        }

    }

    public int maxUncrossedLines(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int m = nums2.length;

        int[][] dp = new int[n + 1][m + 1];

        for (int[] d : dp)
            Arrays.fill(d, -1);

        return unCrossed(nums1, nums2, n, m, dp);
    }

    // Max dot product

    public int helper(int[] nums1, int[] nums2, int n, int m, int[][] dp) {

        if (n == 0 || m == 0)
            return dp[n][m] = -(int) 1e8;// res

        if (dp[n][m] != -(int) 1e9)
            return dp[n][m];

        int prod = nums1[n - 1] * nums2[m - 1];

        int yes = helper(nums1, nums2, n - 1, m - 1, dp) + prod; // yesall

        int no = Math.max(helper(nums1, nums2, n, m - 1, dp), helper(nums1, nums2, n - 1, m, dp));// kisi ek ko hata
                                                                                                  // diya

        return dp[n][m] = Math.max(Math.max(yes, no), prod);

    }

    public int maxDotProduct(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int m = nums2.length;

        int[][] dp = new int[n + 1][m + 1];

        for (int[] d : dp)
            Arrays.fill(d, -(int) 1e9);

        return helper(nums1, nums2, n, m, dp);
    }

    // Longest Common Substring
    public int longestCommonSubstr_DP(String s1, String s2, int n, int m, int[][] dp) {
        int len = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    len = Math.max(len, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return len;

    }

    public int longestCommonSubstr(String S1, String S2, int n, int m) {
        // code here

        int[][] dp = new int[n + 1][m + 1];

        return longestCommonSubstr_DP(S1, S2, n, m, dp);
    }

    // https://practice.geeksforgeeks.org/problems/count-subsequences-of-type-ai-bj-ck4425/1
    public int fun(String s) {
        int n = s.length();

        // aCount-> a^i , bCount->a^i b^j , cCount->a^i b^j c^k
        int aCount = 0, bCount = 0, cCount = 0, emptyStr = 1;
        int mod = (int) 1e9 + 7;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == 'a') {
                aCount = (aCount + (emptyStr + aCount) % mod) % mod;
            } else if (ch == 'b') {
                bCount = (bCount + (aCount + bCount) % mod) % mod;
            } else if (ch == 'c') {
                cCount = (cCount + (bCount + cCount) % mod) % mod;
            }
        }

        return cCount;
    }

    // Longest Palindromic Subsequence
    public String longestPalindrome(String s) {

        int count = 0;
        int len = 0;
        int si = 0;

        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for (int g = 0; g < n; g++) {

            for (int i = 0, j = g; j < n; i++, j++) {
                if (g == 0) {
                    dp[i][j] = true;
                } else if (g == 1 && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];

                }
                if (dp[i][j]) {
                    if (j - i + 1 > len) {
                        len = j - i + 1;
                        si = i;
                    }
                    count++;
                }
            }

        }
        return s.substring(si, si + len);

    }

    // Word Break

    public boolean wordBreak(String str, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        int len = 0; // len of lrgest wrd in dict
        int n = str.length();
        for (String s : wordDict) {
            set.add(s);
            len = Math.max(s.length(), len);
        }

        boolean[] dp = new boolean[n + 1];
        dp[0] = true; //

        // dp[k] = true means vaha tak ke string space seperated sequence me break kr
        // skte hai
        for (int i = 0; i <= n; i++) {
            if (!dp[i])
                continue;

            for (int l = 1; l <= len && i + l <= n; l++) {
                String substr = str.substring(i, i + l);
                if (set.contains(substr)) {
                    dp[i + l] = true;
                }

            }
        }

        return dp[n];
    }

    public static String lpss_backEngg(String str, int si, int ei, int[][] dp) {

        if (si >= ei) {
            return si == ei ? str.charAt(si) + " " : "";
        }

        if (str.charAt(si) == str.charAt(ei)) {

            return str.charAt(si) + lpss_backEngg(str, si + 1, ei - 1, dp) + str.charAt(ei);
        } else if (dp[si + 1][ei] > dp[si + 1][ei - 1]) {
            return lpss_backEngg(str, si + 1, ei, dp);
        } else {
            return lpss_backEngg(str, si, ei - 1, dp);
        }
    }

    /*******************************************/

    public void wordBreak_backEngg(String s, int idx, boolean[] dp, int maxLen, List<String> wordDict,
            HashSet<String> set, String ssf, List<String> ans) {
        if (idx >= s.length()) {
            ans.add(ssf.substring(0, ssf.length() - 1));
            return;
        }

        for (int l = 1; l <= maxLen && idx + l <= s.length(); l++) {
            if (dp[idx + l]) {
                String substr = s.substring(idx, idx + l);
                if (set.contains(substr)) {
                    wordBreak_backEngg(s, idx + l, dp, maxLen, wordDict, set, ssf + substr + " ", ans);
                }
            }
        }
    }

    public List<String> wordBreak_(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        int len = 0, n = s.length();
        for (String ss : wordDict) {
            set.add(ss);
            len = Math.max(ss.length(), len);
        }

        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 0; i <= n; i++) {
            if (!dp[i])
                continue;

            for (int l = 1; l <= len && i + l <= n; l++) {
                String substr = s.substring(i, i + l);
                if (set.contains(substr)) {
                    dp[i + l] = true;
                }
            }
        }

        List<String> ans = new ArrayList<>();
        if (dp[n])
            wordBreak_backEngg(s, 0, dp, len, wordDict, set, "", ans);

        return ans;
    }

    /*******************************************/

    // House robber - II

    public int houseRobber(int[] arr, int si, int ei, int[] dp) {

        if (si > ei)
            return 0;

        if (dp[si] != -1)
            return dp[si];

        int rob = houseRobber(arr, si + 2, ei, dp) + arr[si];
        int notRob = houseRobber(arr, si + 1, ei, dp);

        return dp[si] = Math.max(rob, notRob);
    }

    public int rob(int[] nums) {

        int n = nums.length;
        if (n == 0 || n == 1) {
            return n == 1 ? nums[0] : 0;
        }
        int[] dp1 = new int[n];
        Arrays.fill(dp1, -1);

        int[] dp2 = new int[n];
        Arrays.fill(dp2, -1);

        return Math.max(houseRobber(nums, 0, n - 2, dp1), houseRobber(nums, 1, n - 1, dp2));
    }

    public int houseRobber(int[] nums, int[] dp, int n) {

        if (n <= 0)
            return 0;

        if (dp[n] != -1)
            return dp[n];

        int rob = houseRobber(nums, dp, n - 2) + nums[n - 1];

        int notRob = houseRobber(nums, dp, n - 1);

        return dp[n] = Math.max(rob, notRob);
    }

    public int robI(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return houseRobber(nums, dp, n);

    }

    public static void main(String[] args) {

        longestPalindromeSubseq();

    }

}
