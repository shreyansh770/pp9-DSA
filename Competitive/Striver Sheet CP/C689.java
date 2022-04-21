import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C689 {
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

    public static long cap(long n, long m) {
        long res = 0;
        for (long k = 2; k * k * k <= n; k++)
            res += n / (k * k * k);
        return res;
    }

    public static void main(String[] args) {
        FastReader fs = new FastReader();

        long m = fs.nextLong();

        long si = 1;
        long ei = (long) 1e18;
        long res = -1;
        while (si <= ei) {
            long mid = (si + ei) / 2;


            long ans = cap(mid,m);

            if (ans == m) 
                res = mid;
            if (ans >= m) {
                ei = mid - 1;
            } else {
                si = mid + 1;
            }
        }

        System.out.println(res);

    }
}
