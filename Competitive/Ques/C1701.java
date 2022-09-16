import java.util.*;

public class C1701 {

    public static boolean check(int time, int[] timings) {
        long leftover = 0;

        for (int i = 0; i < timings.length; i++) {
            if (timings[i] <= time - 2)
                leftover -= (time - timings[i]) / 2;
            else if (timings[i] > time)
                leftover += timings[i] - time;
        }
        return leftover <= 0 ? true : false;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int t = scn.nextInt();

        while (t-- > 0) {
            int n = scn.nextInt();
            int m = scn.nextInt();

            int[] a = new int[n];
            for (int i = 0; i < m; i++)
                a[scn.nextInt()-1]++;

            int si = 0;
            int ei = 2 * m;

            int res = 1;
            while (si < ei) {

                int mid = (si + ei) / 2;

                if (check(mid, a)) {
                    ei = mid ;
                    res = mid;
                } else {
                    si = mid + 1;
                }

            }

            System.out.println(si);
        }
    }
}
