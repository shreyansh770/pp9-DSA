import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.lang.model.util.ElementScanner6;

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

                int a = fs.nextInt();
                int b = fs.nextInt();

                boolean flag = true;
                int[] res = new int[a];
                if(a%3==0 || b%3==0){
                    System.out.println(0);
                    flag = false;
                    if(a>0){
                        res[a]++;
                    }
                }else if(a%3==b%3){
                    System.out.println(1);
                }else{
                    System.out.println(2);
                }
            }
        }
}
