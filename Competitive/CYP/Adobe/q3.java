import java.util.Arrays;
import java.util.Scanner;

public class q3 {

    static int mod = (int) 1e9 + 7;
    static int[][] dp;

    static int subsequenceCount(String s, String p, int i, int j) {

        if (j == p.length())
            return 1;
        if (i == s.length())
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        int inc = 0;
        if (s.charAt(i) == p.charAt(j)) {
            inc = subsequenceCount(s, p, i + 1, j + 1);
        }

        int ninc = subsequenceCount(s, p, i + 1, j);

        return dp[i][j] = (inc + ninc) % mod;

    }

    static int subsequenceCount(String S, String T) {

        dp = new int[S.length() + 1][T.length() + 1];

        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return subsequenceCount(S, T, 0, 0);
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        String s = scn.next();
        String t = scn.next();

        System.out.println(subsequenceCount(s, t));
    }
}
