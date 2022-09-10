import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.KeyStore.Entry;
import java.util.StringTokenizer;

public class B126 {

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

    public static int[] LPS(String s) {

        int n = s.length();
        int[] lps = new int[n];
        int len = 0;
        int idx = 1;
        while (idx < n) {

            if (s.charAt(idx) == s.charAt(len)) {
                len++;
                lps[idx] = len;
                idx++;
            } else {

                if (len > 0) {
                    len = lps[len - 1];
                } else {
                    lps[idx] = 0;
                    idx++;
                }
            }
        }

        return lps;

    }

    public static void main(String[] args) {

        FastReader scn = new FastReader();

        String s = scn.next();

        int[] lps = LPS(s);


        int len = lps[lps.length-1];
        boolean found = false;
        if(len!=0){
            for(int j=0;j<2;j++){
                for(int i=1;i<s.length()-1;i++){
                    if(len == lps[i]){
                        found = true;
                        break;
                    }

                }

                if(!found){
                    len = lps[len-1]; // doubt
                    if(len == 0){
                        break;
                    }
                }else{
                    break;
                }
            }
        }


        if(!found && len == 0){
            System.out.println("Just a legend");
        }else{
            System.out.println(s.substring(0,len));
        }
    }

}
