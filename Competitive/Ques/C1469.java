import java.util.*;
import java.io.*;

public class C1469 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int t = scn.nextInt();
        while (t-- > 0) {

            int n = scn.nextInt();
            int k = scn.nextInt();

            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = scn.nextInt();
            }

            int minh = a[0];
            int maxh = a[0] + k;

            boolean flag = true;
            for (int i = 1; i < n - 1; i++) {

                int d = a[i];
                int u = a[i] + 2 * k - 1;

                // if previous lies outside the extremities 
                if (minh >= u || maxh <= d) {
                    flag = false;
                    break;
                }
                minh = Math.max(d, minh - (k - 1));
                maxh = Math.min(u, maxh + k - 1); // 2*k coz we have to bring the lowest point upto that
                                                                 // height
            }

            if (!flag) {
                System.out.println("NO");
            } else if (minh >= k + a[n - 1] || maxh <= a[n - 1]) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }

        }
    }
}
