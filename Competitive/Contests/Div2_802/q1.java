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

    public static int solve(int[][] arr , int n , int m){



        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int r1 = a / m;
            int c1 = a % m;

            int r2 = b / m;
            int c2 = b % m;

            return arr[r1][c1] - arr[r2][c2];
        });

        pq.add(0);

        int totalCost = 0;
        int[][] dir = { { 1, 0 }, { 0, 1 } };
        while (pq.size() != 0) {
            int s = pq.size();
            while (s-- > 0) {

                int idx = pq.remove();

                int r = idx / m;
                int c = idx % m;

                totalCost += arr[r][c];

                if (r == n - 1 && c == m - 1) {
                    return totalCost;
                }

                for (int[] d : dir) {

                    int nr = r + d[0];
                    int nc = c + d[1];

                    if (nr >= 0 && nc >= 0 && nr < n && nc < m) {
                        pq.add(nr * m + nc);
                    }

                }

            }
        }

        return totalCost;

    }

    public static void main(String[] args) {
        FastReader fs = new FastReader();

        int t = fs.nextInt();

        while (t-- > 0) {

            int n = fs.nextInt();
            int m = fs.nextInt();

            // int[][] arr = new int[n][m];

            // for (int i = 0; i < n; i++) {
            //     for (int j = 0; j < m; j++) {
            //         arr[i][j] = i * m + (j + 1);
            //     }
            // }

            // int ans =  solve(arr,n,m);

            long totalsum = 0;
            
            for(int i=0;i<m;i++){

                totalsum = totalsum + (i+1);
            }

            for(int i=1;i<n;i++){
               int toadd  =i*m+m;
               totalsum = totalsum + toadd;
            }

            System.out.println(totalsum);

        }
    }
}
