import java.util.*;

public class B996 {

    public static long check(long t, long[] a) {
        return a[(int)(t%a.length)] - t <= 0 ? t%a.length : -1;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        long[] arr = new long[n];

        long max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
            max = Math.max(max,arr[i]);
        }

        long si = 0;
        long ei = (long)1e9;

        long res = 0;
        while (si <= ei) {

            long t = (si + ei) / 2;
            long f = check(t, arr);

            if (f>=0) {
                ei = t - 1;
                res = f;
            } else {
                si = t + 1;
            }

        }
        System.out.println(res+1);
    }
}
