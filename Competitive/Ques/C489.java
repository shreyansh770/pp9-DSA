import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C489 {
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

    static StringBuilder max = new StringBuilder();

    public static void solve(int m, int[] s) {

        for (int i = 0; i < m; i++) {
            int min = Math.min(9, s[0]);
            max.append((char) (min + '0'));
            s[0] -= min;
        }

    }

    public static void main(String[] args) {
        FastReader fs = new FastReader();

        int n = fs.nextInt();
        int[] s = new int[1];
        s[0] = fs.nextInt();

        if (n == 1 && s[0] == 0) {
            System.out.println("0 0");
        }

        else if (n > 1 && s[0] == 0) {
            System.out.println("-1 -1");
        } else {

            solve(n, s);

            if (s[0] > 0) {
                System.out.println("-1 -1");
            } else {

                StringBuilder min = new StringBuilder();

                min.append(max.reverse().toString());

                // removing starting zeroe

                int idx = 0;
                while (min.charAt(idx) == '0') {
                    idx++;
                }

                if (idx != 0) {
                    min.setCharAt(0, '1');
                    int ch = (int) min.charAt(idx) - '0';
                    min.setCharAt(idx, (char) (ch - 1 + '0'));
                }

                System.out.println(min.toString() + " " + max.reverse().toString());
            }

        }

    }
}