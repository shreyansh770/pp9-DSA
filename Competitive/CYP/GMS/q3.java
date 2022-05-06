import java.util.*;

public class q3 {

    public int countSubArrayProductLessThanK(long a[], long n, long k) {

        int si = 0;
        int ei = 0;

        long psf = 1;

        int count = 0;
        while (ei < n) {
            psf = psf * a[ei];

            while (si<=ei && psf >= k) {
                psf = psf / a[si];
                si++;
            }

            count += (ei - si + 1);
            ei++;
        }

        return count;

    }

}
