import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q3 {
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
            String s = fs.next();

            int[] front = new int[n + 2];
            int[] back = new int[n + 2];

            if (s.charAt(0) == '(') {
                front[0] = 1;
            }

            if (s.charAt(n - 1) == ')') {
                back[n - 1] = 1;
            }

            for (int i = 1; i < n; i++) {
                if (s.charAt(i) == '(') {
                    front[i] = front[i] + front[i - 1] + 1;
                } else {
                    front[i] = front[i] + front[i - 1];
                }
            }

            for (int i = n - 2; i >= 0; i--) {

                if (s.charAt(i) == ')') {
                    back[i] = back[i] + 1 + back[i + 1];
                } else {
                    back[i] = back[i] + back[i + 1];
                }
            }

            int res = (int) 1e9;

            for (int i = 0; i < n; i++) {
                int min = Math.min(front[i], back[i + 1]);
                res = Math.min(res, n - 2 * min);
            }

            System.out.println(res);
        }
    }
}
