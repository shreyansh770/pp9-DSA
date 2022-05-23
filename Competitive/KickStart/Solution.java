import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

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

        int T = 0;
        while (T++ < t) {

            int n = fs.nextInt();

            String pass = fs.next();

            boolean[] checks = new boolean[5];

            if (n >= 7) {
                checks[0] = true;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {

                char ch = pass.charAt(i);
                sb.append(ch);
                if (Character.isUpperCase(ch)) {
                    checks[1] = true;
                } else if (Character.isLowerCase(ch)) {
                    checks[2] = true;
                } else if (Character.isDigit(ch)) {
                    checks[3] = true;
                } else if (ch == '#' || ch == '@' || ch == '*' || ch == '&') {
                    checks[4] = true;
                }
            }

            boolean done = false;
            if (!checks[0]) {
                int ml = 7 - n;
                int msc = 0;

                if (!checks[1]) {
                    sb.append('A');
                    msc++;
                }

                if (!checks[2]) {
                    sb.append('a');
                    msc++;
                }

                if (!checks[3]) {
                    sb.append('1');
                    msc++;
                }

                if (!checks[4]) {
                    sb.append('&');
                    msc++;
                }

                ml = ml - msc;

                if (ml > 0) {
                    while (ml-- > 0) {
                        sb.append('1');
                    }
                }

                done = true;

                System.out.println("Case" +" "+"#" + T + ":" +" "+ sb.toString());

            }

            if (!done && !checks[1]) {

                sb.append('A');

                if (!checks[2]) {
                    sb.append('a');
                    // msc++;
                }

                if (!checks[3]) {
                    sb.append('1');
                    // msc++;
                }

                if (!checks[4]) {
                    sb.append('&');
                    // msc++;
                }

                done = true;

                System.out.println("Case" +" "+"#" + T + ":" +" "+ sb.toString());

            }

            if (!done && !checks[2]) {

                sb.append('a');

                if (!checks[3]) {
                    sb.append('1');
                    // msc++;
                }

                if (!checks[4]) {
                    sb.append('&');
                    // msc++;
                }

                done = true;

                System.out.println("Case" +" "+"#" + T + ":" +" "+ sb.toString());
            }

            if (!done && !checks[3]) {
                sb.append('1');

                if (!checks[4]) {
                    sb.append('&');
                    // msc++;
                }

                done = true;

                System.out.println("Case" +" "+"#" + T + ":" +" "+ sb.toString());
            }

            if (!done && !checks[4]) {

                sb.append('*');

                done = true;

                System.out.println("Case" +" "+"#" + T + ":" +" "+ sb.toString());
            }

            if (!done) {
                System.out.println("Case" +" "+"#" + T + ":" +" "+ sb.toString());
            }

        }
    }
}
