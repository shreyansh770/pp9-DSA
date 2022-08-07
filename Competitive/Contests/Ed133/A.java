import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A{
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

                if(n==1){
                    System.out.println(2);
                }

                else {

                    int rem = n%6;
                    int q = n/6;
                    if(rem==0){
                        
                        System.out.println(2*q);
                    }else {
                        if(rem == 3){
                            System.out.println(2*q+1);
                        }else if(rem<=2){
                            int f = (q-1);
                            System.out.println(2*f+3);
                        }else{
                            System.out.println(2*q+2);
                        }
                    }
                }
            }
        }
}