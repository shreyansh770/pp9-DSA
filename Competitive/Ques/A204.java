import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A204 {

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

    static String s;
    static StringBuilder sb;
    static long fd;
    static long ld;
    static Long[][] dp;

    public static long solve(int pos, boolean bound) {

        if (pos == s.length()) {
            // System.out.println(fd + " " + ld);
            // System.out.println(sb.toString());
            return sb.charAt(0) == sb.charAt(sb.length() - 1) ? 1 : 0;
            // return fd == ld ? 1 : 0;
        }

        if (dp[pos][(bound == true) ? 1 : 0] != null) {
            return dp[pos][(bound == true) ? 1 : 0];
        }

        int maxDigit = -1;

        if (bound) {
            maxDigit = s.charAt(pos) - '0';
        } else {
            maxDigit = 9;
        }

        long ans = 0;
        for (int i = 0; i <= maxDigit; i++) {

            sb.append(i + "");
            // if (pos == 0) {
            //     fd = i;
            // }

            // if (pos == s.length() - 1) {
            //     ld = i;
            // }
            ans += solve(pos + 1, bound & (i == (s.charAt(pos) - '0')));

            sb.deleteCharAt(sb.length() - 1);

        }

        dp[pos][(bound == true) ? 1 : 0] = ans;
        return ans;
    }

    public static void main(String[] args) {

        FastReader fs = new FastReader();

        long l = fs.nextLong();
        long r = fs.nextLong();

        s = r + "";
        dp = new Long[20][2];
        sb = new StringBuilder();
        long rans = solve(0, true);

        s = (l - 1) + "";
        sb = new StringBuilder();
        dp = new Long[20][2];

        long lans = solve(0, true);
        if (l < 9 && r > 9) {
            System.out.println(rans - lans + 9);

        } else {
            System.out.println(rans - lans);

        }
    }
}
