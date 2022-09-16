import java.util.*;

public class B534 {

    public static class pair {
        int s;
        long t;

        pair(int s, long t) {
            this.s = s;
            this.t = t;
        }
    }

    static HashMap<String, Long> dp;

    public static long rec(int s, int v2, int D, long ic) {

        if (ic == 0) {
            return s == v2 ? 0 : -5000000;
        }
        // pair p = new pair(s,ic);
        String r = s+"->"+ic;
        if (dp.containsKey(r)) return dp.get(r);
        long ans = -5000000;
        for (int i = 0; i <= D; i++) {
            ans = Math.max(ans, rec(s + i, v2, D,ic - 1) + s + i);
            ans = Math.max(ans, rec(s - i, v2,D, ic - 1) + s - i);

        }
        dp.put(r, ans);
        return ans;
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int v1 = scn.nextInt();
        int v2 = scn.nextInt();

        long t = scn.nextLong();
        int d = scn.nextInt();
        if (d == 0) {
            System.out.println(v1 * t);
            return;
        }

        dp = new HashMap<>();
        long res = rec(v1, v2, d, t - 1);
        System.out.println(res + v1);

    }
}
