import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1 {
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

            int N = fs.nextInt();

            String s = fs.next();

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < N; i += 2) {

                char ch1 = s.charAt(i);
                char ch2 = s.charAt(i + 1);

                if (ch1 == '0' && ch2 == '0') {
                    sb.append('A');
                }

                else if (ch1 == '0' && ch2 == '1') {
                    sb.append('T');

                }

                else if (ch1 == '1' && ch2 == '0') {
                    sb.append('C');

                }

                else if (ch1 == '1' && ch2 == '1') {
                    sb.append('G');

                }
            }

            System.out.println(sb.toString());

        }
    }
}
