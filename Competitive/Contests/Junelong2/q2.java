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

            int[] arr = new int[n];

            HashMap<Integer, Integer> set = new HashMap<>();
            for (int i = 0; i < n; i++) {
                arr[i] = fs.nextInt();
                // set.add(arr[i]);
                set.put(arr[i], set.getOrDefault(arr[i], 0) + 1);
            }

            if (set.size() == 1) {
                System.out.println(0);
            } else if (set.size() == n) {
                System.out.println(n - 1);
            } else {
                // System.out.println(set.size());
                int max = 0;
                for (Map.Entry<Integer, Integer> m : set.entrySet()) {

                    max = Math.max(max, m.getValue());
                }

                System.out.println(n - max);
            }

        }
    }

}
