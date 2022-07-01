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
            int k = fs.nextInt();

            int[] arr = new int[n];

            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                arr[i] = fs.nextInt();

                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            }

            boolean[] flag = new boolean[1];

            flag[0] = true;

            boolean res = true;

            int idx = 0;
            while (idx < n - 1) {

                int i = map.get(arr[idx]);
                if (i > 0) {
                    flag[0] = true;
                }

                int left_ele = arr[idx];
                int right_ele = arr[idx + 1];

                if (left_ele > right_ele) {

                    // check swap

                    int sum = left_ele + right_ele;
                    boolean sumres = sum <= k ? true : false;
                    if (sumres) {
                        arr[idx + 1] = left_ele;
                        arr[idx] = right_ele;

                    } else {

                        // not possible

                        flag[0] = false;
                        res = false;
                        break;
                    }

                }

                idx++;

            }

            boolean output = flag[0];

            if (output == true && res) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }
}