import java.util.*;

public class B1594 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int t = scn.nextInt();

        while (t-- > 0) {
            int n = scn.nextInt();
            int k = scn.nextInt();

            int mod = 1000000007;
            // for any base the number of set bits will be same for all only the
            // multiplication base will change

            // ex k=5(0101)
            // for base 2 5th number will be 2^2+2^0
            // for base 6 it will be 6^2 + 6^0

            long res = 0;
            long p = 1;
            for (int i = 0; i < 32; i++) {
                if ((k & (1 << i)) != 0) {
                    res = (res + p)%mod;
                }

                p *= n;
                p %= mod;
            }

            System.out.println(res);
        }
    }
}
