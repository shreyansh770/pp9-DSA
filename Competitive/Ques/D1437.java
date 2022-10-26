import java.util.*;

public class D1437 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int t = scn.nextInt();
        while (t-- > 0) {

            int n = scn.nextInt();

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scn.nextInt();
            }

            int[] l = new int[n];

            l[0] = 0;
            int p = 0;

            for (int c = 1; c < n; c++) {

                if (a[c] > a[c - 1]) {
                    l[c] = l[p] + 1;
                } else {
                    p++;
                    l[c] = l[p] + 1;
                }
            }

            int max = 0;
            for(int i=0;i<n;i++){
                max = Math.max(max,l[i]);
            }

            System.out.println(max);
        }
    }
}
