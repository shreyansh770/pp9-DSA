import java.util.*;
import java.io.*;

public class B {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int t = scn.nextInt();
        while (t-- > 0) {
            int n = scn.nextInt();

            char[] s = scn.next().toCharArray();

            long zc = 0;
            long oc = 0;
            long z = 0;
            long zero = 0;
            long one = 0;
            long count = 0;
            for (char c : s) {

                if (c == '1') {

                    count++;
                    one++;
                    z = 0;
                } else {

                    z++;
                    zero++;
                    count = 0;
                }

                zc = Math.max(zc,z);
                oc = Math.max(oc,count);
            }

            

            long res = Math.max(zc*zc,oc*oc);
            long ans = Math.max(res , one*zero);

            System.out.println(ans);
            


        }
    }
}
