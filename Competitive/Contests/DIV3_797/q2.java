import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2 {
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

        int t = fs.nextInt();

        while (t-- > 0) {

            int n = fs.nextInt();

            long[] a = new long[n];
            long[] b = new long[n];

            boolean same = true;
            long[] diff = new long[n];
            long maxDiff = 0;
            for (int i = 0; i < n; i++) {
                a[i] = fs.nextLong();
            }

            for (int i = 0; i < n; i++) {
                b[i] = fs.nextLong();

                if (b[i] > a[i]) {
                    same = false;
                }

                diff[i] = a[i] - b[i];
                maxDiff = Math.max(maxDiff, diff[i]);
            }

            boolean pos = true;
            if (same == false) {
                System.out.println("NO");
                continue;
            }

            // System.out.println(maxDiff);
            for (int i = 0; i < n; i++) {
                a[i] = Math.max(0, a[i] - maxDiff);
            }

            for (int i = 0; i < n; i++) {
                if (a[i] != b[i])
                    pos = false;
            }

            if (pos) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }

    }
}
