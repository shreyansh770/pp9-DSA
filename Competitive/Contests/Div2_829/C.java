import java.util.*;
import java.io.*;

public class C {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int t = scn.nextInt();
        while (t-- > 0) {
            int n = scn.nextInt();

            int[] a = new int[n];
            int sum = 0;
            for (int i = 0; i < n; i++) {
                a[i] = scn.nextInt();
                sum += a[i];
            }

            List<int[]> res = new ArrayList<>();
            int seg = 0;
            for (int i = 0; i < n - 1; i++) {

                if (a[i] == a[i + 1]) {

                    res.add(new int[] { i, i + 1 });
                    i++;

                } else {

                    seg++;
                    res.add(new int[] { i, i });
                    res.add(new int[] { i + 1, i + 1 });
                    i++;
                }
            }

            if ((sum & 1) == 1) {
                System.out.println(-1);
            } else {
                System.out.println(res.size());

                for (int[] r : res) {
                    int idx1 = r[0]+1;
                    int idx2 = r[1] +1;
                    System.out.print(idx1 + " " + idx2);
                    System.out.println();
                }
            }
        }

    }
}
