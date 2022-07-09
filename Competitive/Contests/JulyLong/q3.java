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

                int x1 = fs.nextInt();
                int y1 = fs.nextInt();

                int x2 = fs.nextInt();
                int y2 = fs.nextInt();

                int start = (x1 + y1);

                int end = (x2 + y2);

                if( (start & 1) == (end&1) ){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }

            }
        }
}
