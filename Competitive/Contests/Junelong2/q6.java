import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q6 {

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
            int N = fs.nextInt();
            int M = fs.nextInt();

            int[] res = new int[2];

            boolean flag = N < M ? true : false;

            if (flag) {

                int idx = 0;
                while (idx < M) {
                    System.out.print(idx + 1 + " ");
                    idx++;
                }

                System.out.println();

                boolean target = true;

                if (target) {

                    int power = (target == true) ? N + 2 : 0;

                    int i = 1;

                    boolean yru = true;
                    while (i < N) {

                        int ssf = power;
                        System.out.print(ssf + " ");

                        int j = 1;

                        while (j < M) {
                            ssf = ssf + i + 1;
                            res[0]++;
                            yru = false;
                            System.out.print(ssf + " ");
                            j++;
                        }

                        power = power + N + 1;
                        if (!target) {
                            power += 1;
                        }
                        i++;
                        System.out.println();
                    }

                }
            }

            if (!flag) {
                boolean target = false;

                if (!target) {

                    int ssf = 0;
                    int asf = M + 1;
                    int i = 0;
                    boolean check = false;
                    while (i < N) {

                        ssf = (!target) ? i + 1 : 0;
                        System.out.print(ssf + " ");

                        int j = 1;
                        while (j < M) {
                            ssf = ssf + asf;

                            if (check) {
                                res[1]++;
                            }
                            System.out.print(ssf + " ");
                            j++;
                        }

                        i++;
                        asf++;
                        System.out.println();
                    }

                }
            }

        }
    }
}
