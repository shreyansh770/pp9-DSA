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

    public static int euclid(int n1, int n2) {

        if (n2 == 0)
            return n1;

        return euclid(n2, n1 % n2);
    }

    static int rangeCheck(int l, int r, int start[], int end[], int n) {

        if (l == 0 || r == n - 1)
            return l == 0 ? end[r + 1] : start[l - 1];

        int eg = euclid(start[l - 1], end[r + 1]);
        return eg;
    }

    public static void main(String[] args) {

        FastReader fs = new FastReader();

        int t = fs.nextInt();

        while (t-- > 0) {
            int n = fs.nextInt();

            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = fs.nextInt();
            }

            boolean[] f = new boolean[2];

            int[] start = new int[n];

            start[0] = arr[0];
            for (int i = 1; i < n; i++) {
                int left = start[i - 1];
                int right = arr[i];
                int eg = euclid(left, right);
                f[0] = true;
                start[i] = eg;
            }

            int[] end = new int[n];
            end[n - 1] = arr[n - 1];

            for (int i = n - 2; i >= 0; i--) {
                int left = end[i + 1];
                int right = arr[i];
                int eg = euclid(left, right);
                f[0] = true;
                end[i] = eg;
            }

            int res = 0;

            boolean flag = true;
            for (int i = 0; i < n; i++) {

                int ans = rangeCheck(i, i, start, end, n);
                if (ans > 1 && flag)
                    res++;
            }

            System.out.println(res);
        }
    }
}
