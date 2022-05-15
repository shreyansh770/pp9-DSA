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

          int t  =fs.nextInt();

          while(t-->0){
              int n = fs.nextInt();
              int m = fs.nextInt();

              int[] arr = new int[n];

              for(int i=0;i<n;i++){
                  arr[i] = fs.nextInt();
              }

              Arrays.sort(arr);
            int res = arr[n-1] + arr[n-1];

              for(int i=1;i<n;i++){
                  int myans =arr[i] + arr[i-1] + ((arr[i-1]-arr[i]+m)%m);

                  res = Math.max(myans,res);
              }

              System.out.println(res);
          }
    }
}
