import java.util.*;
import java.io.*;

public class D1475 {

    public static boolean isPos(){
        
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int t = scn.nextInt();

        while (t-- > 0) {

            int n = scn.nextInt();
            int m = scn.nextInt();

            int[][] a = new int[n][2];

            for (int i = 0; i < n; i++) {

                a[i][0] = scn.nextInt();
            }

            for (int i = 0; i < n; i++) {

                a[i][1] = scn.nextInt();
            }
        }
    }
}
