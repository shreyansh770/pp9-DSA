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

            String s = fs.next();

            int sum1=0;

            for(int i=0;i<3;i++){
                int n = s.charAt(i)-'0';
                sum1+=n;
            }

            int sum2 = 0;
            for(int i=s.length()-1;i>=3;i--){

                int n = s.charAt(i)-'0';
                sum2+=n;
            }

            if(sum1 == sum2){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }

        }

    }

    
}
