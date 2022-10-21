import java.util.*;
import java.io.*;

public class A1540 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int t = scn.nextInt();
        while (t-- > 0) {

            // to minimize positive sum draw indirect edges
            // to minimize negative sum draw direct edges
            int n = scn.nextInt();
            long[] a = new long[n];

            for (int i = 0; i < n; i++) {
                a[i] = scn.nextLong();
            }

            Arrays.sort(a);
            long sum = a[n-1];
            long[] back = new long[n];
            back[0] = 0;
            for(int i=1;i<n;i++){
                back[i] = back[i-1] + i*(a[i]-a[i-1]);
                sum-=back[i];
            }
            
            System.out.println(sum);

        }
    }
}
