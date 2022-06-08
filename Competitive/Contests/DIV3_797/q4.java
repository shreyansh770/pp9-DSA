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
            int x = fs.nextInt();

            int[] arr = new int[n + 1];

            String s = fs.next();

            boolean flag = false;
            for (int i = 0; i < n; i++) {
                // if (s.charAt(i) == 'B') {
                //     flag = true;
                //     arr[i + 1] = arr[i] + 1;
                // } else {
                //     flag = false;
                //     arr[i + 1] = arr[i];
                // }

                arr[i+1] = arr[i] + (s.charAt(i)=='B' ? 1 : 0);
            }

            int res = n;

            // int[] ans = new int[n];
            for (int i = x; i <= n; i++) {

                // if(flag){
                //    ans[i]++;
                // }

                int reqDiff = x - (arr[i] - arr[i - x]);
                res = Math.min(res, reqDiff);

            }
            System.out.println(res);

        }
    }
}
