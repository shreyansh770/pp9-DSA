import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A {
    
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
                
                int x = fs.nextInt();
                int y = fs.nextInt();

                if(x==y){
                    System.out.println(1+" "+1);
                }else if(y>x){

                    if(y%x!=0){
                        System.out.println(0+" "+0);
                    }else{

                        int q = y/x;
                        System.out.println(1+" "+q);
                    }

                }else{
                    System.out.println(0+" "+0);
                }
            }
        }
    }
