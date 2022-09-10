import java.util.*;

public class B1282_1 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int t = scn.nextInt();

        while (t-- > 0) {
            int n = scn.nextInt();
            int p = scn.nextInt();
            int k = scn.nextInt();

            int[] prefix = new int[n];

            // atmost we can buy k-1 goods individually
            // if we are buying k goods it is better to pay for the most expensive of all of
            // them rather than paying for each of the individually

            for (int i = 0; i < n; i++) {
                prefix[i] = scn.nextInt();
            }

            Arrays.sort(prefix);

            

        }

    }
}
