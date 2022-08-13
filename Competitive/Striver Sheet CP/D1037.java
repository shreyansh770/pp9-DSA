import java.util.*;

public class D1037 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        List<Integer>[] list = new ArrayList[n + 1];

        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            int u = scn.nextInt() - 1;
            int v = scn.nextInt() - 1;

            list[u].add(v);
            list[v].add(u);
        }

        // sorting nbr for each source in the order of the req array

        int[] order = new int[n];

        for (int i = 0; i < n; i++) {
            order[scn.nextInt() - 1] = i; // position of the node in res
        }

        for (int i = 0; i < n; i++) {
            Collections.sort(list[i], (a, b) -> {
                return order[a] - order[b];
            });
        }

        LinkedList<Integer> q = new LinkedList<>();
        q.add(0);
        boolean[] vis = new boolean[n];
        vis[0] = true;
        int ourOrder = 0;
        int[] ourbfs = new int[n];
        while (q.size() != 0) {

            int top = q.removeFirst();

            ourbfs[top] = ourOrder++;

            for (int nbr : list[top]) {
                if (!vis[nbr]) {
                    vis[nbr] = true;
                    q.add(nbr);
                }
            }

        }

        for (int i = 0; i < n; i++) {
            if (ourbfs[i] != order[i]) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}
