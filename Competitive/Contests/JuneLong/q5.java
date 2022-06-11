import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q5 {

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

    public static long solve(long num) {

        int fac = 0;
        long[] res = new long[100001];
        int idx = 0;
        for (int d = 1; d<= Math.sqrt(num); d++) {
            long rem = num % d;
            if (rem==0) {

                long div = num / d;
                boolean flag = div==d? true : false;
                if(flag){
                    fac++;
                    if(idx<100001) idx++;
                }else if(!flag){
                    fac = fac+2;
                    res[idx]++;
                }

            }
        }

        return fac;

    }

    public static void main(String[] args) throws java.lang.Exception {

        FastReader fs = new FastReader();

        int t = fs.nextInt();

        while (t-- > 0) {
            long a = fs.nextInt();
            long b = fs.nextInt();
            long diff = Math.abs(a - b);

            System.out.println((int) solve(diff));

        }
    }
}
