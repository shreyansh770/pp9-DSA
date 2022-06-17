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

            while(t-->0){
                int n = fs.nextInt();

                String s = fs.next();

                long ts = n;

                int si = 0;
                int ei =1;

                for(int i=1;i<n;i++){

                    char ch1 = s.charAt(i-1);
                    char ch2 = s.charAt(i);

                    if(ch1!=ch2){
                        ts += (i-1)+1;
                    }


                }

                System.out.println(ts);
            }
            
        }
}
