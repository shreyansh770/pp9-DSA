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
            long x = fs.nextLong();
            long y = fs.nextLong();

            if (x == y) {
                System.out.println(0);
            } else {

                if (x > y) {

                    Long diff = x - y;

                    if (diff % 2 == 0) {
                        System.out.println(diff / 2);
                    } else {
                        // int ans = (int)Math.ceil(diff/2) +1;
                        double div = diff*1.0/2;
                        int res = (int)Math.ceil(div);
                        System.out.println(res+1);
                        // System.out.println(ans)
                    }

                } else {

                    long diff = y - x;

                    System.out.println(diff);

                }
            }
        }

    }
}
