import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Codechef {
    
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

        public static void main(String[] args) throws java.lang.Exception {
            
            FastReader fs = new FastReader();

            int t = fs.nextInt();

            while(t-->0){

                int n = fs.nextInt();

                int[] arr = new int[n];

                for(int i=0;i<n;i++){
                    arr[i]  =fs.nextInt();
                }

                int count=0;

                boolean[] vis = new boolean[n];
                for(int i=0;i<n;i++){

                    if(i-1>=0 && arr[i]==arr[i-1] && !vis[i-1]){
                        vis[i] = true;
                        count++;
                        continue;
                    }

                    if(i+1<n && arr[i] == arr[i+1] && !vis[i+1]){
                        vis[i] = true;
                        count++;
                        continue;
                    }
                }

                System.out.println(n-count);

            }
        }
}
