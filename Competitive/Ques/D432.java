import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D432 {

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

    public static void main(String[] args) {

        FastReader fs = new FastReader();

        String s = fs.next();

        // int k=0;
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {

            String sub = s.substring(0, i + 1);

            String ns = sub + "#" + s;

            // System.out.println(ns+" ");
            int reqL = sub.length();
            int[] lps = LPS(ns);

            if (lps[ns.length() - 1] != reqL)
                continue;

            int count = 0;
            for (int l : lps) {
                if (l == reqL) {
                    count++;
                }
            }

            if (count > 0)
                res.add(new int[] { reqL, count });
        }

        System.out.println(res.size());

        for (int[] r : res) {
            System.out.println(r[0] + " " + r[1] + " ");
        }
    }
}