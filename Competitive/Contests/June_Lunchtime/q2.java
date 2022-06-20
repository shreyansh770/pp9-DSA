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

    public static void main(String[] args) {
        FastReader fs = new FastReader();
        int t = fs.nextInt();

        while (t-- > 0) {
            int n = fs.nextInt();

            if (n == 3) {
                System.out.println("010");
            } else {
                StringBuilder sb = new StringBuilder();

                sb.append('0');

                boolean flag = true;
                int[] arr = new int[2];
                for (int i = 1; i < n - 1; i++) {
                    sb.append('1');
                    if (flag)
                        arr[0]++;
                }

                arr[1]++;
                sb.append('0');
                flag = true;

                System.out.println(sb.toString());
            }
        }
    }
}
