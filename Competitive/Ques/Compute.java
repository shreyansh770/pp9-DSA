import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Compute {

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

        int n = fs.nextInt();

        long[] a = new long[n];

        for (int i = 0; i < n; i++) {
            a[i] = fs.nextLong();
        }

        int k = fs.nextInt();

        // printFirstNegativeInteger(a, n, k);
        long[] ans = printFirstNegativeInteger(a, n, k);

        for (long r : ans) {
            System.out.print(r + " ");
        }
    }

    public static long[] printFirstNegativeInteger(long A[], int N, int K) {
        LinkedList<Long> q = new LinkedList<>();

        int si = 0;
        int ei = 0;
        long[] res = new long[N - K + 1];
        // for(long a : A){
        //     if(a<0) q.addLast(a);
        // }
        int idx = 0;
        while (ei < N) {
            // System.out.println(A[ei]);

            if (A[ei] < 0)
                q.addLast(A[ei]);


            if (ei - si + 1 < K)
                ei++;
            else if (ei - si + 1 == K) {

                if (q.size() == 0) {
                    res[idx++] = 0;
                    // continue;
                }else{
                    res[idx++] = q.getFirst();

                    if (A[si] ==q.getFirst())
                        q.removeFirst();
                }

                si++;
                ei++;
            }
        }

        return res;
    }
}