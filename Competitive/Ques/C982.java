import java.util.*;
import java.io.*;

public class C982 {

    static List<List<Integer>> g;
    static int ec = 0;

    public static int dfs(int node, int p) {
        int count = 1;
        for (int child : g.get(node)) {
            if (child != p) {
                count += dfs(child, node);
            }
        }

        if (count % 2 == 0) {
            ec++;
        }

        return count;

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {

            int u = scn.nextInt();
            int v = scn.nextInt();
            g.get(u).add(v);
            g.get(v).add(u);

        }

        dfs(1, 1);

        System.out.println(ec-1);
    }
}
