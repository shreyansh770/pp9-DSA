import java.util.*;

public class q2 {

    public static class pair {
        double  p1;
        double p2;

        pair(double p1, double p2) {
            this.p1 = p1;
            this.p2 = p2;
        }
    }

    public static pair intersect(pair o, pair c) {

        if (c.p2 < o.p1 || c.p1 > o.p2)
            return new pair(-1, -1);

        return new pair(Math.max(c.p1, o.p1), Math.min(c.p2, o.p2));
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int t = scn.nextInt();

        while (t-- > 0) {

            int n = scn.nextInt();

            int[] points = new int[n];
            for (int i = 0; i < n; i++) {
                points[i] = scn.nextInt();
            }

            int[] time = new int[n];
            for (int i = 0; i < n; i++) {
                time[i] = scn.nextInt();
            }

            // if(n==1){
            //     System.out.println(points[0]*1.0);
            //     continue;
            // }

            double s = 0;
            double e = 2e8+5;
            double res = 0;

            int noi = 30;
            while (noi-->0) {

                long mt = (long)(s + e) / 2; // meeting time

                pair p = new pair(0, 1e8);

                boolean pos = true;
                for (int i = 0; i < n; i++) {

                    if (time[i] > mt) {
                        pos = false;
                        break;
                    }

                    double diff = mt - time[i];

                    pair range = new pair(points[i] - diff, points[i] + diff);

                    p = intersect(p, range);

                    if (p.p1 == -1) {
                        pos = false;
                        break;
                    }
                }


                if(pos){
                    res = (p.p1 + p.p2)/2;
                    e = mt-1;
                }else{
                    s = mt+1;
                }
            }

            System.out.println(res);

        }
    }
}
