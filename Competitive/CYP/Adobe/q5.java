import java.util.*;

public class q5 {

    static int mod = (int) 1e9 + 7;

    static int rec(int N,int n, int x, int si) {


        if(si*si>N) return 0;

        if (n == 0)
            return 1;

        int ans = 0;
        for (int i = si; i * i <= n; i++) {

            int newN = n - (int)Math.pow(i, x);
            ans = (ans + rec(n,newN, x, si + 1)) % mod;
        }

        return ans;
    }

    static int numOfWays(int n, int x) {

        return rec(n,n, x, 1);

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int x = scn.nextInt();

        System.out.println(numOfWays(n, x));
    }
}
