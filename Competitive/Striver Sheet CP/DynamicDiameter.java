import java.util.*;

public class DynamicDiameter {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        if (n == 1) {
            System.out.println(1);
            return;
        }
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i < n - 1; i++) {
            int u = scn.nextInt();
            int v = scn.nextInt();

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

    }
}
