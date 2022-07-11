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

    public static int genMask(int mask){
        return mask;
    }

    public static void main(String[] args) {

        FastReader fs = new FastReader();

        int t = fs.nextInt();

        while (t-- > 0) {

            int n = fs.nextInt();
            int[] arr = new int[n + 1];

            for (int i = 0; i <= n; i++) {
                arr[i] = fs.nextInt();
            }

            // now we have 3 set bits condition

            // int bitcount = 0;
            int[] res = new int[3];

            int bitrate = 1;

            while (bitrate <= n)
                bitrate *= 2;

            bitrate /= 2;

            for (int i = 0; bitrate > 0; i++) {

                // int genMask 
                int bitmask = genMask(bitrate);

                // get setbit

                int bits = (arr[bitrate] - arr[0]) + 3 * bitrate;
                int bit = bits / (2 * bitrate);
                int onBits = 3 - bit;

                // sort
                Arrays.sort(res);

                boolean flag = (onBits == 1 ? true : false);

                if (flag) {

                    int idx = 0;
                    while (idx <= 2) {

                        boolean check = (res[idx] + bitmask <= n ? true : false);

                        if (check) {
                            // count[0]++;
                            res[idx] = res[idx] + bitmask;
                            break;
                            // if (count[0] == 2)
                            // break;
                        }

                        idx++;
                    }

                }
                if (onBits == 2 && !flag) {

                    int[] count = new int[1];

                    int idx = 0;
                    while (idx <= 2) {

                        boolean check = (res[idx] + bitmask <= n ? true : false);

                        if (check) {
                            count[0]++;
                            res[idx] = res[idx] + bitmask;
                            int rep = count[0];
                            if (rep == 2)
                                break;
                        }

                        idx++;
                    }

                }
                if (onBits == 3 && !flag) {
                    int idx = 2;
                    while (idx >= 0) {
                        res[idx] = res[idx] + bitmask;
                        idx--;
                    }
                }

                bitrate /= 2;

            }

            System.out.println(res[0] + " " + res[1] + " " + res[2]);
        }
    }
}
