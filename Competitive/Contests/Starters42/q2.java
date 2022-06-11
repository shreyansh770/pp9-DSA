import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.lang.model.util.ElementScanner6;

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

                String str = fs.next();

                int res = 0;

                boolean letsCheck = false;

                // if(str.length()==1){
                //     System.out.println(1);
                //     continue;
                // }

                if(str.charAt(0)=='1') {
                    letsCheck = true;
                    res++;
                }


                for(int i=1;i<n-1;i++){
                    int prev = str.charAt(i);
                    int next = str.charAt(i-1);

                    if(prev!=next) res++;
                }

                System.out.println(res);
            }
        }
}
