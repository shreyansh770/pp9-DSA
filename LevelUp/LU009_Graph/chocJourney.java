import java.util.*;

public class chocJourney {

    public static void dijkstra(int[] dist, int src, ArrayList<int[]>[] graph) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });

        dist[src] = 0;

        pq.add(new int[] { src, 0 }); // src ,dest

        while (pq.size() != 0) {
            int[] pair = pq.remove();

            int u = pair[0];
            int dis = pair[1];

            for (int[] nbr : graph[u]) {
                int dsf = nbr[1] + dis;

                if (dist[nbr[0]] > dsf) {
                    dist[nbr[0]] = dsf;
                    pq.add(new int[] { nbr[0], dist[nbr[0]] });
                }
            }
        }
    }

    // solution is correct have to improve fast I/O
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int m = scn.nextInt();
        int k = scn.nextInt();
        int x = scn.nextInt();

        int[] chocCity = new int[n + 1];

        for (int i = 0; i < k; i++) {
            int city = scn.nextInt();
            chocCity[city] = 1;
        }

        ArrayList<int[]>[] graph = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {

            int u = scn.nextInt();
            int v = scn.nextInt();
            int w = scn.nextInt();

            graph[u].add(new int[] { v, w });
            graph[v].add(new int[] { u, w });

        }

        int src = scn.nextInt();
        int dest = scn.nextInt();

        int[] srcDis = new int[n + 1];
        int[] destDis = new int[n + 1];

        Arrays.fill(srcDis, (int) (1e8));
        Arrays.fill(destDis, (int) (1e8));

        dijkstra(srcDis, src, graph); // friend to all cities
        dijkstra(destDis, dest, graph); // me to all cities

        int ans = (int) (1e8);

        for (int i = 0; i <= n; i++) {
            if (chocCity[i] == 1) {
                if (destDis[i] < x && srcDis[i] != (int) (1e8)) { // the dist between my city and chocity should be
                                                                  // alteast less than expiry time
                    ans = Math.min(ans, destDis[i] + srcDis[i]);
                }
            }
        }

        if (ans == (int) (1e8)) {
            System.out.println(-1);
            return;
        }

        System.out.println(ans);

    }

}
