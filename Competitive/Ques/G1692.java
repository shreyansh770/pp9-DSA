import java.util.*;

public class G1692 {

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

            int[] psum = new int[n];

            psum[0] = 0;
            for (int i = n - 1; i > 0; i--) {
                psum[i] = (a[i - 1] < a[i] * 2 ? 1 : 0);
            }

            for (int i = 1; i < n; i++) {
                psum[i] += psum[i - 1];
            }


            int res = 0;

            for (int i = k; i < n; i++) {

                if (psum[i] - psum[i - k] == k) {
                    res++;
                }

            }

            System.out.println(res);
        }
    }
}