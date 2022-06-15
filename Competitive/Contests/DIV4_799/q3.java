import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.swing.plaf.synth.SynthOptionPaneUI;

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

    public static void mark(int[][] ans, int i, int j) {

        if (i == 7 || j == 7 || i == 0 || j == 0)
            return;

        ans[i][j] += 1;

        mark(ans, i + 1, j - 1);
    }

    public static void mark_(int[][] ans, int i, int j) {

        if (i == 7 || j == 7 || i == 0 || j == 0)
            return;

        System.out.println("helo");
        ans[i][j] += 1;

        mark(ans, i + 1, j + 1);
    }

    public static void main(String[] args) {

        FastReader fs = new FastReader();

        int t = fs.nextInt();

        while (t-- > 0) {

            // fs.nextLine();

            char[][] board = new char[9][9];

            int[][] ans = new int[8][8];

            for (int i = 1; i <= 8; i++) {

                String s = fs.next();
                for (int j = 0; j< s.length(); j++) {

                    board[i][j] = s.charAt(j);
                }
                // System.out.println(board[i][j]+" "+i+" "+j);

            }

            for (int i = 2; i < 8; i++) {
                for (int j = 2; j < 8; j++) {

                    if (board[i - 1][j - 1] == '#' && board[i - 1][j + 1] == '#') {
                        System.out.println(i + " " + j);
                        break;
                    }

                }
            }

        }

    }
}
