import java.util.*;

public class B {

    static Scanner scn = new Scanner(System.in);

    public static long solve(long m, long a) {

        long v = (long)Math.floor((m / a)) + (m-(m/a)*a);

        return v;
    }

    public static void main(String[] args) {

        long t = scn.nextInt();

        while (t-- > 0) {

            long l = scn.nextInt();
            long r = scn.nextInt();
            long a = scn.nextInt();

            long p = 0;

            // long x = l;
            while (l <= r) {
                long m = (l + r) / 2;

                long v = solve(m, a);
                if (p <= v) {
                    // x = m;
                    p = v;
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }

            // System.out.println(x);
            System.out.println(p);

        }
    }

}
