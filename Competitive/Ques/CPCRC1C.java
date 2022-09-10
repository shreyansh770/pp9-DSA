import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CPCRC1C {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static String s = "";
    static long[][][] dp;
    static int mod = (int) 1e9 + 7;

    public static long solve(int pos, boolean bound, int sum) {

        if (pos == s.length())
            return sum;

        int maxDigit = -1;

        if (dp[pos][(bound == true) ? 1 : 0][sum] != -1) {
            return dp[pos][(bound == true) ? 1 : 0][sum];
        }

        if (bound) {
            maxDigit = s.charAt(pos) - '0';
        } else {
            maxDigit = 9;
        }

        // int sum = 0;
        int res = 0;
        for (int i = 0; i <= maxDigit; i++) {
            res += solve(pos + 1, bound & (i == (s.charAt(pos) - '0')), sum + i);
        }

        return dp[pos][(bound == true) ? 1 : 0][sum] = res;

    }

    public static void main(String[] args) {

        FastReader fs = new FastReader();

        long a = fs.nextLong();

        long b = fs.nextLong();

        if (a == -1 && b == -1)
            return;

        s = b + "";
        dp = new long[20][2][170];
        for (long[][] dd : dp) {
            for (long[] d : dd) {
                Arrays.fill(d, -1);
            }
        }
        long rans = solve(0, true, 0);

        s = (a - 1) + "";
        dp = new long[20][2][170];

        for (long[][] dd : dp) {
            for (long[] d : dd) {
                Arrays.fill(d, -1);
            }
        }

        long lans = solve(0, true, 0);
        System.out.println(rans - lans);

    }
}
