import java.util.*;
import java.io.*;

public class E1490 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int t = scn.nextInt();
        while (t-- > 0) {
            int n = scn.nextInt();
            int[][] a = new int[n][2];
            for (int i = 0; i < n; i++) {
                a[i][0] = scn.nextInt();
                a[i][1] = i;
            }

            Arrays.sort(a, (i, j) -> {
                return i[0] - j[0];
            });
            // if ith person along with all the person he has won from
            long[] psum = new long[n];
            psum[0] = a[0][0];

            for (int i = 1; i < n; i++) {
                psum[i] = psum[i - 1] + a[i][0];
            }

            // a[i]>=a[i+1] => a[i-1]+a[i]>a[i+1];

            List<Integer> res = new ArrayList<>();
            int idx = n-2;

            while(idx>=0 && psum[idx]>=a[idx+1][0]) {res.add(a[idx][1]);idx--;}

            res.add(a[n-1][1]);
            Collections.sort(res);

            System.out.println(res.size());

            for(int i : res){
                int tp = i+1;
                System.out.print(tp+" ");
            }

            System.out.println();


        }
    }
}
