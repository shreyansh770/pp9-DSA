import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B {
    
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

            while(t-->0){

                int n = fs.nextInt();

                int[] arr = new int[n];

                int min = (int)1e9;
                for(int i=0;i<n;i++){
                    arr[i] = fs.nextInt();
                    min = Math.min(min,arr[i]);
                }

                int total = 0;

                for(int i=0;i<n;i++){

                    if(arr[i]>min){
                        total = total + arr[i]-min;
                    }
                }

                System.out.println(total);

            }
        }
}
