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
            int k = fs.nextInt();

            int fiveSet = n/5;

            int remp = n%5;

            int totaldays = fiveSet + (remp==0 ? 0 : 1);

            int grak = (k/5);
            int grarem = (k%5);

            int grp = grak + (grarem ==0 ? 0 :1);

            System.out.println(totaldays-grp);
            

        }
    }
}
