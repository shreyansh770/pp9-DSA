import java.util.*;

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
}
