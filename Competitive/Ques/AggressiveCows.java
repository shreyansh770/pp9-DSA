import java.util.*;

public class AggressiveCows {

    // is it possible to place all the cows with atleast a distance of 'dist'
    public static boolean isPos(long dist, long[] location, int cows, int stalls) {

        long init = location[0];
        int cnt = 1;
        for (int i = 1; i < stalls; i++) {

            if (location[i] - init >= dist) {
                cnt++;
                init = location[i];
            }

            if (cows == cnt)
                return true;
        }

        return false;

    }

    public static void main(String[] args) throws java.lang.Exception {

        Scanner scn = new Scanner(System.in);
        long t = scn.nextLong();

        while (t-- > 0) {
            int n = scn.nextInt(); // no of stalls;
            int cows = scn.nextInt();
            long[] location = new long[n]; // location of stalls

            for (int i = 0; i < n; i++) {
                location[i] = scn.nextInt();
            }

            Arrays.sort(location);

            long si = 1;
            long ei = location[n - 1];

            long res = 1;

            while (si <= ei) {
                long mid = (si + ei) / 2;

                if (isPos(mid, location, cows, n)) {

                    res = mid;
                    si = mid + 1;
                } else {
                    ei = mid - 1;
                }
            }

            System.out.println(res);

        }

    }

}