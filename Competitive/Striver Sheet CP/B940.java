import java.util.*;

public class B940 {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        long n = scn.nextLong();
        long k = scn.nextLong();
        long A = scn.nextLong();
        long B = scn.nextLong();

        if (k == 1) {
            System.out.println((n - 1) * A);
        } else {

            long cost = 0;
            while (n > 1) {

                long rem = n % k;
                n -= rem;

                // if(n==0) continue;
                cost += rem * A;
                long cA = (n - n / k) * A;

                if ( n > 1 && B < cA) {
                    // cost += cA;
                    cost += B;
                    n /= k;
                    
                } else {
                    cost += A*(n-1);
                    n=1;
                }

                
            }

            System.out.println(cost);
        }

    }
}