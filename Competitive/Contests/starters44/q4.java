import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q4 {
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
            int k = fs.nextInt();

            // int ls = ;
            int ls1 = (1 << n)- 1;

            // int rs = ;
            int rs2 = (1 << n) - 2;

            boolean flag = true;

            int[] res = new int[2];

            int finalans = ls1 * rs2;

            int[] arr = new int[2];

            arr[0] = finalans;
            arr[1] = 1;

            res[1] = finalans;

            if (flag)
                System.out.println(finalans);

        }
    }
}
