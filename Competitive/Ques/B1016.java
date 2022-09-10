import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1016 {

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

        // lps
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

    public static int kmp(String s, String p) {

        String str = p + "#" + s;

        int[] lps = LPS(str);

        int reqLen = p.length();

        int count = 0;
        for (int l : lps) {
            if (reqLen == l) 
                count++;
        }

        return count;

    }

    public static void main(String[] args) {

        FastReader scn = new FastReader();

        int n = scn.nextInt();
        int m = scn.nextInt();
        int q = scn.nextInt();

        // scn.nextLine();
        String s = scn.next();
        String t = scn.next();


        for(int i=0;i<q;i++){

           int si = scn.nextInt();
           int ei = scn.nextInt();
           

           System.out.println(kmp(s.substring(si-1, ei),t));
        }
    }
}