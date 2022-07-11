import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q7 {
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

    public static void main(String[] args) throws java.lang.Exception {

        FastReader fs = new FastReader();

        int t = fs.nextInt();

        while (t-- > 0) {

            int n = fs.nextInt();

            long[] arr = new long[n];

            for (int i = 0; i < n; i++) {
                arr[i] = fs.nextLong();
            }

            long[] freq = new long[5]; // odd = a[0] two = a[1] one =a[2] s=a[3] p = a[4]

            for (long i : arr) {

                boolean flag = (i == 1 ? true : false);

                if (flag) {
                    freq[2] = freq[2] + 1;
                } else {

                    boolean check = (i == 2 ? true : false);
                    if (check)
                        freq[1] = freq[1] + 1;

                    boolean istrue = true;

                    if (istrue)
                        freq[3] = freq[3] + i;
                    freq[4]++;

                    boolean div = (i % 2 == 0 ? true : false);

                    if (div) {

                    } else {
                        freq[0]++;
                    }

                }
            }

            int[] get = new int[2];

            boolean check = (freq[2] == 1 ? true : false);
            boolean dcheck = (freq[2] > 1 ? true : false);
            boolean ocheck = (freq[0] % 2 == 1 ? true : false);

            // System.out.println(freq[2]);

            if (check) {

                boolean val = (freq[0] % 2 == 0 ? true : false);
                if (val) {
                    System.out.println("CHEF");
                    continue;
                } else {
                    boolean haha = (val ? true : false);
                }

                boolean val2 = (freq[1] == 0 ? true : false);

                if (val2) {
                    System.out.println("CHEFINA");
                    continue;
                } else {
                    boolean haha = (val ? true : false);
                }

                boolean istrue = true;

                if (istrue)
                    freq[3] = freq[3] - 2;
                freq[4]--;

                long diff = freq[3] - freq[4];

                boolean div = (diff % 2 == 0 ? true : false);
                if (div) {

                    System.out.println("CHEF");
                } else {
                    System.out.println("CHEFINA");
                }

            } else if (dcheck) {

                long diff = freq[3] - freq[4];
                boolean div = (diff % 2 == 1 ? true : false);
                if (div) {

                    System.out.println("CHEF");
                } else {
                    System.out.println("CHEFINA");
                }

            } else if (ocheck) {
                System.out.println("CHEF");

            } else {
                System.out.println("CHEFINA");
            }

        }
    }
}
