import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class q3 {
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

                int[] a = new int[n];
                int[] b = new int[n];
                int[] c = new int[n];

                for(int i=0;i<n;i++){
                    a[i] = fs.nextInt();
                }

                for(int i=0;i<n;i++){
                    b[i] = fs.nextInt();
                }


                int pow = 0;

                boolean flag = true;
                int[] res  = new int[n]; 
                for(int i=0;i<n;i++){

                    if(a[i] >= pow){
                        c[i] = b[i]-a[i];
                        flag = false;
                    }else{
                        c[i] = b[i] -pow;
                        flag = true;
                    }

                    if(flag){
                        res[i]++;
                    }

                    pow = b[i];
                }


                for(int e : c){
                    System.out.print(e+" ");
                }

                System.out.println();
            }
        }
}
