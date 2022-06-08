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
            int n = fs.nextInt();

            int d = n / 3;
            int r = n % 3;

            if (n == 6) {

                System.out.println(2 + " " + 3 + " " + 1);
            } else if (n == 7) {
                System.out.println(2 + " " + 4 + " " + 1);

            } else if (n == 8) {
                System.out.println(3 + " " + 4 + " " + 1);

            } else if (d > 2 && r != 0) {

                if (r == 2) {
                    int l = d + 1;
                    int c = d + r;
                    int e = d - 1;
                    System.out.println(l + " " + c + " " + e);
                } else if (r == 1) {
                    int l = d +1;
                    int c = d +r+ 1;
                    int e = d - 2;
                    System.out.println(l + " " + c + " " + e);
                }

            } else if (d > 2 && r == 0) {
                int l = d;
                int c = d + 1;
                int e = d - 1;
                System.out.println(l + " " + c + " " + e);
            }
        }

    }
}
