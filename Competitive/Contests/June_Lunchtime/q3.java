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
            int a = fs.nextInt();
            int b = fs.nextInt();
            int n = fs.nextInt();

            if (a == b) {
                System.out.println(0);
            } else {

                boolean notsame = false;

                if (!notsame) {
                    int res = a ^ b;
                    if (res < n) {
                        System.out.println(1);
                    } else {

                        int[] bin = new int[2];
                        int base2 = (int) (Math.log(res) / Math.log(2));

                        int ans = (int) Math.pow(2, base2);

                        bin[1]++;

                        notsame = ans < n ? true : false;

                        bin[1]--;

                        if (notsame) {
                            System.out.println(2);
                        } else {
                            System.out.println(-1);
                        }

                    }
                }

            }
        }
    }
}
