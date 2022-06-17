import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1 {
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
                int a  =fs.nextInt();
                int b = fs.nextInt();

                StringBuilder sb = new StringBuilder();

                   int smaller = Math.min(a, b);

                    // int mid = a/2;
                    for(int i=0;i<smaller;i++){
                          sb.append('0');
                          sb.append('1');
                    }

                    int extrazeroes = a-smaller;

                    for(int i=0;i<extrazeroes;i++){
                        sb.append('0');
                    }

                    int extraones = b-smaller;

                    for(int i=0;i<extraones;i++){
                        sb.append('1');
                    }

                    System.out.println(sb.toString());
              
            }
        }
}
