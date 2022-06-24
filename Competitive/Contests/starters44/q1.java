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
        int t = fs.nextInt();
        while (t-- > 0) {
            int x1 = fs.nextInt();
            int y1 = fs.nextInt();

            int x2 = fs.nextInt();
            int y2 = fs.nextInt();

            x1--;
            x2--;
            y1--;
            y2--;

            int[][] dir = { { 2, 1 }, { 1, 2 }, { -1, 2 }, { -2, 1 }, { -2, -1 }, { -1, -2 }, { 1, -2 }, { 2, -1 } };

            boolean[][] arr = new boolean[8][8];

            boolean flag1 = false;
            boolean flag2 = false;
            for (int[] di : dir) {

                int sr = x1 + di[0];
                int sc = y1 + di[1];

                for (int[] dj : dir) {
                    int sjr = x2 + dj[0];
                    int sjc = y2 + dj[1];

                    if ((sjr >= 0 && sjr < 8) && (sjc >= 0 && sjc < 8) && sjr == sr && sjc == sc) {

                        flag1 = true;
                        flag2 = true;

                        arr[sjr][sjc] = true;
                        break;
                    }
                }
            }

            if (flag1 && flag2) {
                arr[7][7] = true;
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }
}
