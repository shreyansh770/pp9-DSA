
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

    public static int moves(String s1, String s2) {

        int mc = 0;

        for(int i=0;i<s1.length();i++){

            if(s1.charAt(i)!=s2.charAt(i)){
                mc = mc + Math.abs((s1.charAt(i)-'a'+1) - (s2.charAt(i)-'a'+1));
            }

        }

        return mc;

    }

    public static void main(String[] args) {

        FastReader fs = new FastReader();

        int t = fs.nextInt();

        while (t-->0) {

            int n = fs.nextInt();
            int m = fs.nextInt();

            List<String> list = new ArrayList<>();

            // fs.nextInt();

            for (int i = 0; i < n; i++) {
                String s = fs.next();
                list.add(s);
            }

            int min = (int) 1e9;
            for (int i = 0; i < n; i++) {
                String s1 = list.get(i);
                for (int j = i + 1; j < n; j++) {

                    min = Math.min(min, moves(s1, list.get(j)));
                }
            }

            System.out.println(min);

        }

    }
}
