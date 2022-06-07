import java.util.*;

public class q5 {

    static int mod = (int) 1e9 + 7;

    static int rec(int n, int x,int si) {

        if (n < 0)
            return 0;

        if (n == 0)
            return 1;

        int ans = 0;
        for (int i = si; i * i <= n; i++) {

            int newN = n - Math.pow(i, x);
            ans = (ans + rec(newN, x,si+1)) % mod;
        }

        return ans;
    }

    static int numOfWays(int n, int x) {

        Scanner scn = new Scanner(System.in);

        return rec(n, x,1);

    }
}
