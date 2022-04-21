import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PRIME1 {

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
            int m = fs.nextInt();

            // seive of erothesis

            boolean[] primes = new boolean[m + 1];

            for (int p = 2; p * p <= m; p++) {

                if (primes[p] == false) {
                    for (int i = p* p; i <= m; i+=p) {

                        primes[i] = true;
                    }
                }
            }

            for (int i = n; i <= m; i++) {

                if (primes[i] == false && i!=1) {
                    System.out.println(i);
                }
            }

            System.out.println();

        }
    }

}
