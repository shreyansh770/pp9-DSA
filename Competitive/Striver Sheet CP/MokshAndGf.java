import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MokshAndGf {

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

    public static int[] getModifiedArray(int length, int[][] updates) {

        int[] res = new int[length + 2];
        for (int i = 0; i < updates.length; i++) {

            int si = updates[i][0];
            int ei = updates[i][1];
            int num = updates[i][2];

            res[si] += num;
            if (ei + 1 < length) {
                // this will help us to remove the effect of
                // all the num that have a range till ei
                res[ei + 1] -= (num);
            }
        }

        // prefix sum

        for (int i = 1; i < length; i++) {
            res[i] = res[i] + res[i - 1];
        }

        return res;
    }

    public static void main(String[] args) {

        FastReader scn = new FastReader();

        int n = scn.nextInt();
        int q = scn.nextInt();
        int m = scn.nextInt();

        int[][] updates = new int[q][3];

        for (int i = 0; i < q; i++) {
            updates[i][0] = scn.nextInt();
            updates[i][1] = scn.nextInt();
            updates[i][2] = 1;
        }

        int[] rangeUpArr = getModifiedArray(n, updates);

        int[] pcm = new int[rangeUpArr.length]; // prefix count of number ,

        int[] pcm1 = new int[rangeUpArr.length];// prefix count of m+1

        for (int i = 1; i < n; i++) {
            if (rangeUpArr[i] == m) {
                pcm[i] = pcm[i - 1] + 1;
            } else {
                pcm[i] = pcm[i - 1];
            }

            if (rangeUpArr[i] == m + 1) {
                pcm1[i] = pcm1[i - 1] + 1;
            } else {
                pcm1[i] = pcm1[i - 1];
            }
        }

        int totalm = pcm[n - 1];

        int max = 0;
        for (int i = 0; i < q; i++) {

            // if we remove this query
            int l = updates[i][0];
            int r = updates[i][1];

            int loss = pcm[r] - pcm[l - 1]; // after remove a query m will be converted to m-1
            int profit = pcm1[r] - pcm1[l - 1]; // after remove a query m+1 will be converted to m

            max = Math.max(max, totalm - loss + profit);
        }

        System.out.println(max);

    }

}
