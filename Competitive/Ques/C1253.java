import java.io.*;
import java.util.*;

public class C1253 extends PrintWriter {

    C1253() {
        super(System.out, true);
    }

    Scanner scn = new Scanner(System.in);

    public static void main(String[] $) {
        C1253 o = new C1253();
        o.main();
        o.flush();
    }

    public void main() {

        int n = scn.nextInt();
        int m = scn.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
        }

        Arrays.sort(a);

        long[] dp = new long[n + 1];
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += a[i - 1];
            dp[i] = sum;
            if (i >= m)
                dp[i] += dp[i - m];
        }

        for (int i = 1; i <= n; i++) {

            System.out.print(dp[i] + " ");
        }
    }
}
