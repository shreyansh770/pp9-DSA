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

    static int mod = (int) 1e9 + 7;

    public static void main(String[] args) {
        FastReader fs = new FastReader();
        int t = fs.nextInt();
        while (t-- > 0) {
            long n = fs.nextInt();
            long x = fs.nextInt();

            boolean br = (n == 1) ? true : false;
            if (n == 1 && br) {
                System.out.println(x);
            }

            if (!br) {

                // calculating power

                long letans = 1;

                long k = 2;
                k = k % mod;

                boolean xres = (k == 0) ? true : false;

                if (xres) {
                    letans = 0;
                }

                if (!xres) {
                    long neg = n - 1;

                    while (neg > 0) {

                        boolean yres = (neg % 2 == 1) ? true : false;

                        if (yres == true) {

                            letans = (letans * k) % mod;
                        }

                        neg = neg / 2;

                        k = (k * k) % mod;

                    }
                }

                // letans*
                letans *= x;

                letans %= mod;

                System.out.println(letans);

            }
        }
    }
}
