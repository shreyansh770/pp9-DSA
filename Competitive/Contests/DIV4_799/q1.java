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
                int n = fs.nextInt();

                int[] arr = new int[n];

                // int[] frq = new int[10001];
                HashSet<Integer> set = new HashSet<>();

                for(int i=0;i<n;i++){
                    arr[i] = fs.nextInt();
                    set.add(arr[i]);
                }


                int unique = set.size();

                boolean flag  = (n-unique)%2==0 ? true :false;

                if(flag){
                    System.out.println(unique);
                }else{
                    System.out.println(unique-1);
                }


                // System.out.println(n-rem);


            }
        }
}
