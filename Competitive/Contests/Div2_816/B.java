import java.util.*;

public class B {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int t = scn.nextInt();

        while (t-- > 0) {
            int n = scn.nextInt();
            long k= scn.nextLong();
            long b = scn.nextLong();
            long s = scn.nextLong();

            // min value b.k
            // max value b.k + k-1 + k-1 + k-1 +.....=b.k+(n-1)(k-1)
            long[] res = new long[n];
            if (s < b * k || s > (b * k + (n - 1) * (k - 1))) {
                System.out.println(-1);
            } else {

                res[0] = k * b;
                s -= res[0];
                for (int i = 1; i < n; i++) {
                    if (s > 0) {
                        res[i] = Math.min(s, k - 1);
                        s -= res[i];
                    } else {
                        res[i] = 0;
                    }
                }
                for (int i = 0; i < n; i++) {
                    System.out.print(res[i] + " ");
                }
    
                System.out.println();
            }


        }
    }
}
