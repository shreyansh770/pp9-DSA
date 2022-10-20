import java.util.*;
import java.io.*;

public class B {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int t = scn.nextInt();
        while (t-- > 0) {
            int n = scn.nextInt();

            int[] a = new int[n];

            System.out.print(1 + " ");
            for (int i = n; i > 1; i--) {
                System.out.print(i + " ");
            }

            System.out.println();
        }
    }
}
