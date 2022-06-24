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
        while (t-- > 0) {

            int marks = fs.nextInt();

            if (marks < 10) {
                System.out.println(marks);
            }

            else if (marks == 10 || marks == 1000) {
                System.out.println(10);
            } else {

                if (marks >= 100 && marks <= 109) {
                    int mark1 = marks % 10;
                    System.out.println(mark1 + 1);
                }

                else if (marks >= 200 && marks <= 208) {
                    int mark1 = marks % 10;

                    System.out.println(mark1 + 2);
                }

                else if (marks >= 300 && marks <= 307) {
                    int mark1 = marks % 10;

                    System.out.println(mark1 + 3);
                }

                else if (marks >= 400 && marks <= 406) {
                    int mark1 = marks % 10;

                    System.out.println(mark1 + 4);
                }

                else if (marks >= 500 && marks <= 505) {
                    int mark1 = marks % 10;

                    System.out.println(mark1 + 5);
                }

                else if (marks >= 600 && marks <= 604) {
                    int mark1 = marks % 10;

                    System.out.println(mark1 + 6);
                }

                else if (marks >= 700 && marks <= 703) {
                    int mark1 = marks % 10;

                    System.out.println(mark1 + 7);
                }

                else if (marks >= 800 && marks <= 802) {
                    int mark1 = marks % 10;

                    System.out.println(mark1 + 8);
                }

                else if (marks >= 900 && marks <= 901) {
                    int mark1 = marks % 10;

                    System.out.println(mark1 + 9);
                }

                else{
                    System.out.println(-1);
                }

            }

        }
    }

}
