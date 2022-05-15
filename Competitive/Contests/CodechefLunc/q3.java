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

            int  n =fs.nextInt();

            long[] arr = new long[n];

            arr[0] = fs.nextLong();

            long myans = arr[0];

            for(int i=1;i<n;i++){
                arr[i] = fs.nextLong(); // 
                myans = (myans & arr[i]); // and of complete array
            }

            int res = 0; // no of elements equal to myans

            for(int i=0;i<n;i++){
                if(arr[i]==myans) res++;
            }


            res = n - res; // 6 2 4

            int ans = 0;

            // i & j == myans j j+1

            for(int i=0;i<n;i++){
                if(arr[i]==myans) continue; //  kuch nhi karna

                if(i==(n-1)){ // last i+1 doest'nt exist 
                    ans++;
                    continue;
                }

                arr[i+1] = arr[i] & arr[i+1]; //
                ans++;
            }


            System.out.println(ans); // bodams
        
        }

        }
    }
