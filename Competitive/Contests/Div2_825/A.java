import java.util.*;

public class A {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int t = scn.nextInt();

        while (t-- > 0) {

            int n = scn.nextInt();

            int[] a = new int[n];
            int[] b = new int[n];

            int aoc = 0;
            int azc = 0;
            for (int i = 0; i < n; i++) {
                a[i] = scn.nextInt();

                if (a[i] == 1) {
                    aoc++;
                } else {
                    azc++;
                }
            }

            int boc = 0;
            int bzc = 0;
            for (int i = 0; i < n; i++) {
                b[i] = scn.nextInt();

                if (b[i] == 1) {
                    boc++;
                } else {
                    bzc++;
                }
            }

            int w = 0;
            int wc = 0; //
            int wo = 0; //
            for (int i = 0; i < n; i++) {
                if (a[i] != b[i]) {
                    w++;
                }
            }

            // int res = 0;

            // if (wc > 0 && wo > 0) {
            //     res += wc + wo;
            // }

            // int min = Math.min(wc, wo);

            // wc -= min;
            // wo -= min;
            // res += wc + wo;
            // System.out.println(res);

            int diff = Math.abs(aoc - boc)+1;
            System.out.println(Math.min(w,diff));
        }
    }
}