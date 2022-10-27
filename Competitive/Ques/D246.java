import java.util.*;
import java.io.*;

public class D246 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int m = scn.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
        }


        HashMap<Integer, HashSet<Integer>> ms = new HashMap<>(); // vertex vs neg_colors
        for (int i = 0; i <100006; i++) {
            ms.put(i, new HashSet<>());
        }


        for (int i = 0; i < m; i++) {
            int u = scn.nextInt()-1;
            int v = scn.nextInt()-1;
            int c1 = a[u];
            int c2 = a[v];

            if (c1 == c2)
                continue;
            ms.get(c1).add(c2);
            ms.get(c2).add(c1);

        }

        int max = a[0];


        for (int i = 0; i < n; i++) {

            int c1 = ms.get(a[i]).size();
            int r = ms.get(max).size();

            if(c1>r || (c1==r && max > a[i])) max = a[i];
        }

        System.out.println(max);

    }
}
