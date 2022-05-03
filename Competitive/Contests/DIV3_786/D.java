import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D {

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

            int[] a = new int[n];

            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = fs.nextInt();
                b[i] = a[i];
            }

            Arrays.sort(b);

            for (int i = n - 1; i >= 1; i-=2) {
                if (i-1>=0 && a[i] < a[i - 1]) {

                    int tp = a[i - 1];
                    a[i - 1] = a[i];
                    a[i] = tp;
                }
            }

            boolean flag = true;
            for(int i=0;i<n;i++){
                if(a[i]!=b[i]){
                    System.out.println("NO");
                    flag = false;
                    break;
                }
            }

            if(flag){
              System.out.println("YES");
            }

        }
    }

}
