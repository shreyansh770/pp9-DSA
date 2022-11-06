import java.util.*;
import java.io.*;

public class A {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int t = scn.nextInt();

        while (t-- > 0) {
            int n = scn.nextInt();

            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = scn.nextInt();
            }


            if (a[0] == 1) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
            // System.out.println();
        }
    }
}