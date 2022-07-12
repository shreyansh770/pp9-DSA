import java.util.*;

public class q1 {

    static int[][] dp;

    public static int memo(String s, int idx, int m, int k) {

        // if(idx>s.length()) return 0;

        if (idx == s.length()) {
            return k == 0 ? 1 : 0;
        }

        int d = s.charAt(idx) - '0';
        if (d % 2 != 0)
            return 0; // starting is odd not possible to cut;

        if (dp[idx][k] != -1)
            return dp[idx][k];
        int count = 0;
        // generate substrings
        for (int i = m; i < s.length() && idx + i <= s.length(); i++) {
            int cIdx = idx + i; // cut
            int cDig = s.charAt(cIdx - 1) - '0';

            if (cDig % 2 == 0)
                continue;
            count += memo(s, idx + i, m, k - 1);
        }

        return dp[idx][k] = count;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int m = scn.nextInt();
        int k = scn.nextInt();

        String num = scn.next();

        dp = new int[n + 1][k + 1];

        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }

        int ans = memo(num, 0, m, k);

        System.out.println(ans);

    }
}