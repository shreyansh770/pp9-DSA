import java.util.*;

import javax.lang.model.type.ReferenceType;

public class algoQues {

    public class pair {
        int v = -1;
        int w = 0;

        pair(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    // 743
    // we need time from source to every other node
    // which will give

    public int dijkstra(List<pair>[] graph, int src, int n) {

        int[] dis = new int[n];
        Arrays.fill(dis, (int) (1e8));

        PriorityQueue<pair> pq = new PriorityQueue<>((a, b) -> {
            return a.w - b.w;
        });

        pq.add(new pair(src, 0));
        dis[src] = 0;

        while (pq.size() != 0) {
            pair top = pq.remove();

            int u = top.v;
            int wsf = top.w;

            for (pair nbr : graph[u]) {
                if (nbr.w + wsf < dis[nbr.v]) {
                    dis[nbr.v] = nbr.w + wsf;
                    pq.add(new pair(nbr.v, dis[nbr.v]));
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (dis[i] == (int) (1e8))
                return -1;
            ans = Math.max(ans, dis[i]);
        }

        return ans;

    }

    public int networkDelayTime(int[][] times, int n, int k) {
        List<pair>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] time : times) {
            int u = time[0] - 1, v = time[1] - 1, w = time[2]; // one base indexing
            pair p = new pair(v, w);

            // u -> v,w
            graph[u].add(p);
        }

        // for(int i=0;i<n;i++){
        // for(pair nbr :graph[i]){
        // System.out.print(i+" "+nbr.v+" "+nbr.w);
        // }
        // System.out.println();
        // }

        return dijkstra(graph, k - 1, n);
    }

    // 787

    // dijkstra will give TLE coz one point might get visited multiple times
    public class pair_ {
        int v;
        int w;
        int stops;

        pair_(int v, int w, int stops) {
            this.v = v;
            this.w = w;
            this.stops = stops;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        PriorityQueue<pair_> pq = new PriorityQueue<>((a, b) -> {
            if (a.w == b.w) {
                return a.stops - b.stops;
            }
            return a.w - b.w;
        });

        ArrayList<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] nbr : flights) {
            int u = nbr[0];
            int v = nbr[1];
            int w = nbr[2];

            graph[u].add(new int[] { v, w });
        }

        pq.add(new pair_(src, 0, 0));

        while (pq.size() != 0) {
            pair_ top = pq.remove();

            int sr = top.v;
            int level = top.stops;
            int wsf = top.w;

            if (sr == dst)
                return wsf;

            if (level >= k + 1)
                continue;

            for (int[] nbr : graph[sr]) {
                pq.add(new pair_(nbr[0], wsf + nbr[1], level + 1));
            }
        }

        return -1;

    }

    // bellam ford

    public int bellamFord(int n, int[][] edges, int src, int dest) {
        int[] dis = new int[n];

        Arrays.fill(dis, (int) (1e8));
        dis[src] = 0;

        boolean negCycle = false;

        for (int i = 1; i <= n; i++) {
            int[] ndis = new int[n];
            for (int j = 0; j < n; j++) {
                ndis[j] = dis[j];
            }

            boolean isUpdate = false;

            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];

                if (dis[u] + w < ndis[v]) {
                    ndis[v] = dis[u] + w;
                    isUpdate = true;
                }
            }

            if (isUpdate == false)
                break;

            if (i == n && isUpdate) {
                // negative cycle
                negCycle = true;
            }

            dis = ndis;
        }

        return dis[dest];
    }

    // 787 using bellam ford

    public int findCheapestPrice_(int n, int[][] flights, int src, int dest, int k) {
        int[] dis = new int[n];

        Arrays.fill(dis, (int) 1e8);
        dis[src] = 0;

        boolean negCycle = false;

        for (int i = 1; i <= k + 1; i++) {
            int[] ndis = new int[n];
            for (int j = 0; j < n; j++) {
                ndis[j] = dis[j];
            }

            boolean isUpdate = false;

            for (int[] edge : flights) {
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];

                if (dis[u] + w < ndis[v]) {
                    ndis[v] = dis[u] + w;
                    isUpdate = true;
                }
            }

            if (isUpdate == false)
                break;

            if (i == n && isUpdate) {
                // negative cycle
                negCycle = true;
            }

            dis = ndis;
        }

        return dis[dest] == (int) (1e8) ? -1 : dis[dest];

    }

}
