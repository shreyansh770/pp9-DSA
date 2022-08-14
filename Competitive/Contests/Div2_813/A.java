import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A {
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

            PriorityQueue<Integer> pq = new PriorityQueue<>();
            int[] inc = new int[n + 1];
            int[] f = new int[101];
            boolean check = false;
            for (int i = 0; i < n; i++) {
                arr[i] = fs.nextInt();
                f[arr[i]]++;
                if (arr[i] > n || f[arr[i]] > 1) {
                    System.out.println(0);
                    check = true;
                    break;
                }
                inc[arr[i]] = i;
                pq.add(arr[i]);
            }

            if(check){
                System.out.println(0);
            }
            else if (k == n) {
                System.out.println(0);
            } else {

                // find k smallest elements

                int K = k;
                int swap = 0;
                while (K-- > 0) {

                    int top = pq.remove();

                    if (inc[top] > k - 1)
                        swap++;
                }

                System.out.println(swap);

            }
        }
    }
}