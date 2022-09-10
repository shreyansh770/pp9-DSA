import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1266 {

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

    public static void main(String[] args) {
        FastReader fs = new FastReader();

        // int t = fs.nextInt();
        int t = 1;

        while (t-- > 0) {

            // 1266B
            // long fn = fs.nextLong();
            // boolean flag = false;

            // for (int i = 1; i <= 6; i++) {

            //     if (fn < 15) {
            //         break;
            //     }
            //     long d = (fn - i) % 14;
            //     if (d == 0) {
            //         System.out.println("YES");
            //         flag = true;
            //         break;
            //     }
            // }

            // if (!flag)
            //     System.out.println("NO");

            // 1107B
            // long k = fs.nextLong();
            // long x = fs.nextLong();

            // System.out.println(x+9*(k-1));

            //630C

            // int n = fs.nextInt();

            // long[] dp = new long[n+1];
            // dp[0] = 0;

            // for(int i=1;i<=n;i++){
            //     dp[i] = dp[i-1] + (long)Math.pow(2, i);
            // }

            // System.out.println(dp[n]);

            // 630D

            long n = fs.nextInt();

            System.out.println(1 + 3*n*(n+1));
        }
    }
}
