import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q3 {
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

            
            int top = (int) Math.ceil(n / 2) + (n%2==1 ? 1 : 0);

            // System.out.println(top);

            if (k > top) {

                System.out.println(-1);
                continue;
            }
            if (n == 1) {
                System.out.println('z');
                continue;
            }

            StringBuilder sb = new StringBuilder();

            char start = 'a';

            int modVal = n % 2==1?1:0;

            if (modVal==1 && k == top) {



                int si = 0;
                int ei = k - 1;

                for (int i = si; i < ei; i++) {
                    char to = (char) (start + i);
                    sb.append(to);
                }

                StringBuilder nstr = new StringBuilder(sb.toString());

                // reverse

                nstr.reverse();

                char startappend = (char) (start + k - 1); // since it is odd length
                sb.append(startappend);
                sb.append(nstr.toString());

                System.out.println(sb.toString());
                continue;

            }


            for (int i = 0; i < k; i++) {
                char to = (char) (start + i);
                sb.append(to);
            }

            boolean res = false;
            for (int i = k; i < n / 2; i++) {
                res = true;
                sb.append('a');
            }

            StringBuilder nstr = new StringBuilder(sb.toString());

            // reverse
            nstr.reverse();

            boolean flag = (n % 2 == 0) ? false : true;
            if (flag) {
                int[] ans = new int[k];

                if (modVal == 1) {
                    ans[k - 1]++;
                }
                sb.append('a');
            }

            sb.append(nstr.toString());

            System.out.println(sb.toString());

        }

    }

}
