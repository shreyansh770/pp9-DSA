import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TDPRIMES {

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
        boolean[] primes = new boolean[(int) 1e8 + 1];

        for (int p = 2; p * p <= (int) 1e8; p++) {

            if (primes[p] == false) {
                for (int i = p * p; i <= (int) 1e8; i += p) {
                    primes[i] = true;
                }
            }
        }

        // int[] ans = new int[(int)1e8+1];
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=2;i<=(int)1e8;i++){
            if(primes[i]==false){
                res.add(i);
            }
        }

        // System.out.println(res.size());
        for(int i=1;i<res.size();i+=100){
            System.out.println(res.get(i-1));
        }

    }
}
