import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class classyNumber {
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
    static Long[][][] dp;

    public static long solve(int pos, boolean bound, int cnt) {

        if (pos == s.length()) {
            return 1; // at every pos a valid number has been placed hence found 1 ans
        }

        int maxDigit = -1;
        if (bound) {
            maxDigit = s.charAt(pos) - '0';
        } else {
            maxDigit = 9;
        }

        if (dp[pos][(bound == true) ? 1 : 0][cnt] != null) {
            return dp[pos][(bound == true) ? 1 : 0][cnt];
        }

        long res = 0;
        for (int i = 0; i <= maxDigit; i++) {

            int constCount = cnt + (i > 0 ? 1 : 0); // as per question we can have only 3 non zero digit

            if (constCount <= 3) {
                res += solve(pos + 1, bound & (i == (s.charAt(pos) - '0')), constCount);
            }

        }

        dp[pos][(bound == true) ? 1 : 0][cnt] = res;
        return res;
    }

    public static void main(String[] args) {

        FastReader fs = new FastReader();

        int t = fs.nextInt();
        while (t-- > 0) {

            long l = fs.nextLong();
            long r = fs.nextLong();

            s = r + "";

            dp = new Long[20][2][4]; // pos,bound,cnt

            long rans = solve(0, true, 0);

            dp = new Long[20][2][4];

            s = (l - 1) + "";

            long lans = solve(0, true, 0);

            System.out.println(rans - lans);

        }

    }

}