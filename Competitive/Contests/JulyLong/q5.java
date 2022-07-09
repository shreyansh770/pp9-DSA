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

    public static void main(String[] args) {

        FastReader fs = new FastReader();

        int t = fs.nextInt();

        while (t-- > 0) {

            int n = fs.nextInt();

            long[] arr = new long[n];

            for (int i = 0; i < n; i++) {
                arr[i] = fs.nextLong();
            }

            long chefOdd = 0;

            boolean isPresent = false;
            for (int i = 0; i < n; i++) {
                chefOdd += Math.max(0, arr[i] - 2);
                if (arr[i] == 1)
                    isPresent = true;
            }

            // int check = Arrays.binarySearch(arr, 1);

            if (isPresent) {
                System.out.println("CHEF");
            } else {

                if (chefOdd % 2 == 1) {
                    System.out.println("CHEF");
                } else {
                    System.out.println("CHEFINA");
                }
            }
        }
    }
}
