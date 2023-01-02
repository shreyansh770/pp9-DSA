import java.util.*;
import java.io.*;

public class C982 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {

            int u = scn.nextInt();
            int v = scn.nextInt();
            g.get(u).add(v);
            g.get(v).add(u);

        }
    }
}
