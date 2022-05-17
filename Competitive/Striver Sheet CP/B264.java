import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B264 {

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

    public static int gcd(int a, int b) {

        if (b == 0)
            return a;

        return gcd(b, a % b);
    }

    public static void main(String[] args) {

        FastReader fs = new FastReader();

        int n = fs.nextInt();

        int[] arr = new int[n];

        int[] div = new int[100001];
        int[] dp = new int[100001];


        // dp[a] longest sequence ending at number 6
        // div[i] number of elements that are divisible by i



        int max = 1;

        for (int i = 0; i < n; i++) {
            arr[i] = fs.nextInt();
            int a = arr[i];
            dp[a] = 1;
            div[a] = 1;
            for (int j = 2; j * j <= a; j++) {

                if (a % j == 0) {

                    dp[a] = Math.max(dp[a], div[j] + 1);
                    dp[a] = Math.max(dp[a], div[a / j] + 1);
                }
            }

            for (int j = 2; j * j <= a; j++) {
                if (a % j == 0) {
                    div[j] = dp[a]; // updating the count of j and a/j
                    div[a / j] = dp[a];
                }
            }

            max = Math.max(max, dp[a]);
        }

        System.out.println(max);

    }
}