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
            String s = fs.next();

            // twe have two cases here if
            // starting digit is 9
            // not 9

            // for not 9 we can simply subtract that number from 999..(length n eql to the
            // length of given input)

            if (s.charAt(0) != '9') {

                StringBuilder sb = new StringBuilder();

                for (int i = 0; i < s.length(); i++) {
                    sb.append('9');
                }

                StringBuilder res = new StringBuilder();
                String toSub = sb.toString();
                for (int i = 0; i < s.length(); i++) {

                    int num = (int) (toSub.charAt(i) - '0') - (int) (s.charAt(i) - '0');
                    res.append(num);
                }

                System.out.println(res.toString());
            } else {

                int[] arr = new int[n];

                // Arrays.fill(arr, 0);

                arr[n - 2] = 1;
                arr[0] = 11; // 11 should be given priority for 0th position
                arr[n - 1] = 1;



                for (int i = n - 1; i > 0; i--) {

                    int ch = (int) (s.charAt(i) - '0');
                    if (arr[i] >= ch) {
                        arr[i] = arr[i] - ch;
                    } else {
                        arr[i] = (arr[i]) - ch + 10;
                        arr[i - 1]--;
                    }

                }

                arr[0] = arr[0] - 9;
                for (int e : arr) {
                    System.out.print(e);
                }

                System.out.println();
            }

        }
    }
}
