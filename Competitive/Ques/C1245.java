import java.util.*;
import java.io.*;

public class C1245 {

    static int mod = (int) 1e9 + 7;
    static int[] dp;

    public static int rec(char[] c, int idx, int n) {

        if (idx >= n)
            return 1;

        if (c[idx] == 'm' || c[idx] == 'w')
            return 0;
        if (dp[idx] != -1)
            return dp[idx];
        int count = 0;
        if (idx + 1 < n && ((c[idx] == 'u' && c[idx + 1] == 'u') || (c[idx] == 'n' && c[idx + 1] == 'n'))) {
            count = (count + rec(c, idx + 2, n)) % mod;
        }

        count = (count + rec(c, idx + 1, n)) % mod;

        return dp[idx] = count;

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        char[] s = scn.next().toCharArray();

        int n = s.length;
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(rec(s, 0, n));
    }
}
