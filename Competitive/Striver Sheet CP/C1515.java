import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C1515 {

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

    static class pair {
        int h;
        int id;

        pair(int h , int id){
            this.h = h;
            this.id = id;
        }
    }

    public static void main(String[] args) {

        FastReader fs = new FastReader();

        int t = fs.nextInt();

        while (t-- > 0) {
            int n = fs.nextInt();
            int m = fs.nextInt();
            int x = fs.nextInt();

            int[] height = new int[n];
            for(int i=0;i<n;i++){
                height[i] = fs.nextInt();
            }

            PriorityQueue<pair> pq = new PriorityQueue<>((a, b) -> {

                return a.h - b.h;
            });

            for (int i = 1; i<= m; i++) {
                pq.add(new pair(0, i)); // initially each building with height 0
            }

            System.out.println("YES");
            for(int i=0;i<n;i++){
                pair p = pq.remove();

                System.out.print(p.id+" ");
                pq.add(new pair(p.h+height[i],p.id));
            }

            System.out.println();
        }
    }
}