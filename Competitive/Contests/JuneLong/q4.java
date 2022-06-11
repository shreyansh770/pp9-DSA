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

    



    public static void main(String[] args) {
        FastReader fs = new FastReader();

        int t = fs.nextInt();


        while (t-- > 0) {

            int n = fs.nextInt();


            int[] arr = new int[n+1];
            
            // solve(n, 1,1);

            int[] permu = new int[n];

            for(int i=0;i<n;i++){
                permu[i] = i+1;
            }

            for(int i=0;i<=(n/2);i++){

                // System.out.print(left+" ");
                arr[n - 2*i - 1] = permu[n - i - 1];
                arr[n - 2*i - 2] = permu[i];
           }

            for(int e : arr){
                System.out.print(e+" ");
            }

            System.out.println();
        }
    }
}
