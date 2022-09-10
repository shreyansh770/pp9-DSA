import java.util.*;

public class NumberTheory {

    // https://practice.geeksforgeeks.org/problems/required-rooms3939/1/

    // to minimize the rooms we have to maximize the number of people staying the
    // room
    // since we have to keep equal no of people in a room
    // we have to find the gcd of two groups
    // gcd(n,m) = max no of people we can put in a group
    // if gdc(n,m) == 1 => we can put only person in a room

    static int gcd(int N, int M) {

        if (M == 0)
            return N;

        return gcd(M, N % M);
    }

    static int rooms(int N, int M) {

        int sum = N + M;
        int ans = gcd(N, M);
        if (ans == 1)
            return sum;
        else
            return sum / ans;
    }

    // https://practice.geeksforgeeks.org/problems/mathematical-manipulation2005/1/

    // Euler Totient equation
    public static int noOfCoprimes(int n) {

        int count = n;

        // finding prime factors
        for (int i = 2; i * i <= n; i++) {

            if (n % i == 0) {

                count = count - count / i; // n(1-1/p1)(1-1/p2)....(1-1/p3) -> p1,p2 etc are prime factors of n
                // since all the powers of i has to be included we are doing the same here
                while (n % i == 0) {
                    n = n / i;
                }
            }
        }

        // ex n = 26
        if (n > 1) {
            count = count - count / n;
        }

        return count;
    }

    public int CommonFactor(int n) {
        // Code here

        int N = n;
        return n - noOfCoprimes(N);
    }

    // Modular exponentation
    long mod = (long) 1e9 + 7;

    public long PowMod(long x, long n, long m) {
        // Code here
        long ans = 1; // if power is odd

        while (n > 0) {

            if (n % 2 == 0) {
                // storing one extra x that is making power odd
                ans = ((ans % m) * (x % m)) % m;
                n--;
            }

            x = ((x % m) * (x % m)) % m;
            n = n/2;

        }

        return ans;

    }


    // nCr

    public int ncr(int n , int r){


        int[][] dp = new int[n+1][r+1];

        for(int i=0;i<=n;i++){
            dp[i][0] = 1;
        }

        for(int i=0;i<=r;i++){
            dp[0][i] = 0;
        }


        for(int i=1;i<=n;i++){
            for(int j=1;j<=r;j++){
                if(i == 1&& j==1){
                    dp[i][j]=1;
                    continue;
                }

                // nCr = n-1Cr + n-1Cr-1
                dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
            }
        }

        return dp[n][r];

    }

}
