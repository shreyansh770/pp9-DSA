import java.util.*;
import java.io.*;

public class B797 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] a = new int[n];
        int ssf = 0;
        int smallestPos = (int) 1e9;
        int largestneg = -(int) 1e9;
        for (int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
            if (a[i] > 0) {
                ssf += a[i];
                if (a[i] % 2 == 1) {
                    smallestPos = Math.min(smallestPos, a[i]);
                }

            } else {

                if (Math.abs(a[i]) % 2 == 1) {
                    largestneg = Math.max(largestneg, a[i]);
                }

            }
        }

        if(ssf%2==1){
            System.out.println(ssf);
        }else{
            System.out.println(ssf + ((largestneg * -1 < smallestPos) ? largestneg : -smallestPos));
        }

    }
}
