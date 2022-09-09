import java.util.*;

public class B424 {

    static List<double[]> city;

    public static double getDistance(double x, double y) {
        double dx = (double) x;
        double dy = (double) y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public static boolean popCount(double radii, int target) {

        for (double[] c : city) {

            double dist = getDistance(c[0], c[1]);

            if (dist <= radii)
                target -= c[2];

            if (target <= 0)
                return true;
        }

        return target <= 0;

    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int s = scn.nextInt();

        city = new ArrayList<>();
        // double[] dist = new double[n];
        for (int i = 0; i < n; i++) {
            int x = scn.nextInt();
            int y = scn.nextInt();
            int p = scn.nextInt();

            city.add(new double[] { x*1.0, y*1.0, p*1.0 });
        }

        double sx = 0;
        double sy = 0;
        double ex = 100000;
        double ey = 100000;

        int target = 1000000 - s;

        boolean res = false;
        double ans = 0.0;
        while (sx <= ex) {

            double smid = (sx + ex) / 2;
            double ymid = (sy + ey) / 2;

            double radi = getDistance(smid, ymid);

            // System.out.println(radi);

            if (popCount(radi, target)) {

                ex = smid - 0.0000001;
                ey = ymid - 0.0000001;

                ans = radi;
                res = true;

            } else {

                sx = smid + 0.0000001;
             
                sy = ymid + 0.0000001;
            }

        }

        if (!res) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }

    }
}
