import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C {
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

            int q = fs.nextInt();

            while(q-->0){

                String s = fs.next();
                String t = fs.next();

 

                if(t.length()==1 && t.charAt(0)=='a'){
                    System.out.println(1);
                }else if(t.indexOf("a")!=-1){
                    System.out.println(-1);
                }else{
                    int n = s.length();

                    // int res = ();
                    System.out.println(1L<<n);
                }

            }
        }

    }
