import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C479 {

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

        int n = fs.nextInt();

        int[][] exam_days = new int[n][2];

        for (int i = 0; i < n; i++) {
            exam_days[i][0] = fs.nextInt();
            exam_days[i][1] = fs.nextInt();
        }

        // at first the exam to attempt is the one with
        // earliest record date
        Arrays.sort(exam_days, (a, b) -> {
            return (a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        });

        // now we have to find the best day to give the last exam
        int best = exam_days[0][1];
        for (int i = 1; i < n; i++) {

            if (best <= exam_days[i][1]) {
                best = exam_days[i][1];
            } else {
                best = exam_days[i][0];
            }
        }

        System.out.println(best);
    }

}
