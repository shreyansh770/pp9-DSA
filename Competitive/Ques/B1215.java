import java.util.*;
import java.io.*;

public class B1215 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = scn.nextInt();
        }

        int[] neg = new int[n + 1];

        long tp = (n * (n - 1) / 2) + n;
        neg[0] = 0;

        for (int i = 1; i <= n; i++) {
            if (a[i] < 0) {
                neg[i] = neg[i - 1] + 1;
            } else {
                neg[i] = neg[i - 1];
            }
        }

        long np = 0;
        for (int i = 1; i <= n; i++) {

                for (int j = i-1; j >= 0; j--) {
                    if ((neg[j] - neg[i]) % 2 != 0) {
                        np++;
                    }
                }
        }

        long pp = tp - np;

        System.out.println(np + " " + pp);
        // odd negative prod neg

        // even negtive prod pos
    }
}
