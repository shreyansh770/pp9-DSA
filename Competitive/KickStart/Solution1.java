import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1 {

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

    public static boolean solve(int[] arr, int idx, int sum, int tar, List<Integer> res) {

        // if(idx==arr.length) return ;
        if (sum == tar) {
            return true;
        }

        boolean flag = false;
        if (sum < tar && idx < arr.length) {
            res.add(arr[idx]);
            flag = flag || solve(arr, idx + 1, sum + arr[idx], tar, res);
            if (!flag)
                res.remove(res.size() - 1);
            flag = flag || solve(arr, idx + 1, sum, tar, res);
        }

        return flag;

    }

    public static void main(String[] args) {

        FastReader fs = new FastReader();

        int t = fs.nextInt();

        int T = 0;

        while (T++ < t) {
            int n = fs.nextInt();

            int x = fs.nextInt();
            int y = fs.nextInt();

            HashSet<Integer> set = new HashSet<>();
            int[] psum = new int[n];

            psum[0] = 1;
            int[] arr = new int[n];
           
            for (int i = 0; i < n; i++) {
                arr[i] = i+1;
            }

            for(int i=0;i<n;i++){
                int sum = arr[0];
                set.add(sum);
                for(int j=i+1;j<n;j++){
                    set.add(sum+arr[j]);
                }
            }

            int qsum = (psum[n - 1] * x) / (x + y);

            // System.out.println(qsum);

            if (!set.contains(qsum) || !set.contains(psum[n - 1] - qsum)) {
                System.out.println("Case" + " " + "#" + T + ":" + " " + "IMPOSSIBLE");
            }

            System.out.println(qsum);
            // finding subset with qsum and sum-qsum

            List<Integer> first = new ArrayList<>();
            solve(arr, 0, 0, qsum, first);

            List<Integer> sec = new ArrayList<>();
            solve(arr, 0, 0, psum[n - 1] - qsum, sec);

            if (first.size() == 0 || sec.size() == 0) {
                System.out.println("Case" + " " + "#" + T + ":" + " " + "IMPOSSIBLE");
            } else {
                if (first.size() == 0) {
                    System.out.println("Case" + " " + "#" + T + ":" + " " + "POSSIBLE");

                    for (int f : first) {
                        System.out.print(f + " ");
                    }

                    for (int s : sec) {
                        System.out.println(s + " ");
                    }
                }
            }

        }
    }
}
