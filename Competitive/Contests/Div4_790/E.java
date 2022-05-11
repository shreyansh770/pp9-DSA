import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class E {

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

    public static boolean check(int k, int q, Integer[] arr,int[] psum) {

        int sum = psum[k-1];

        return sum>=q;
    }

    public static void main(String[] args) {

        FastReader fs = new FastReader();

        int t = fs.nextInt();

        while (t-- > 0) {

            int n = fs.nextInt();
            int q = fs.nextInt();

            Integer[] arr = new Integer[n];

            for (int i = 0; i < n; i++) {
                arr[i] = fs.nextInt();
            }

            Arrays.sort(arr, Collections.reverseOrder());

            int[] psum = new int[n];
            psum[0] = arr[0];

            for(int i=1;i<n;i++){
                psum[i] = psum[i-1] + arr[i];
            }

            while (q-- > 0) {
                int sugar = fs.nextInt();

                int si = 1;
                int ei = n;

                int ans = -1;
                while (si <= ei) {
                    int mid = (si + ei) / 2;

                    if (check(mid, sugar, arr,psum)) {
                        ans = mid;
                        ei = mid - 1;
                    } else {
                        si = mid + 1;
                    }
                }

                System.out.println(ans);

            }

        }
    }
}
