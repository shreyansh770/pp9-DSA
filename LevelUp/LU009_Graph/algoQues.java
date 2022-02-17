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

        // we are calculating shortest dist with atmost 1 edge to atmost n edges
        // here we are also checking for nth time to make sure the dis array don't get
        // updated
        // nth time if it is getting updated it means we have negative cycle

        // now why on n times not more not else bcoz at max in n vertex graph we can
        // have a maximum
        // length between two edges to be (n-1) so after (n-1) iteration we can be sure
        // that we can explored
        // all the edges and come up with minimum weighted path
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

            // if for there are no changes in the ndis array => we have already find the
            // possible path and further it wont get any better
            if (isUpdate == false)
                break;

            // if dis array is even gettig updated till nth edge that means there is a
            // negative cycle
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

    // 788 lintcode

    public class spair {
        int idx;
        int dist;

        spair(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {

        int n = maze.length;
        int m = maze[0].length;

        PriorityQueue<spair> pq = new PriorityQueue<>((a, b) -> {
            return a.dist - b.dist;
        });

        pq.add(new spair(start[0] * m + start[1], 0));

        int[][] vis = new int[n][m];
        for (int[] v : vis) {
            Arrays.fill(v, (int) (1e8));
        }
        vis[start[0]][start[1]] = 0;

        int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

        while (pq.size() != 0) {

            spair i = pq.remove();

            int sr = (i.idx) / m;
            int sc = (i.idx) % m;

            int dist = i.dist;
            if (sr == destination[0] && sc == destination[1]) {
                // System.out.print("hello");
                return dist;
            }

            for (int[] d : dir) {
                int r = sr + d[0];
                int c = sc + d[1];

                int curr = 1; // bcoz we are already starting from with one step (r,c)
                while (r >= 0 && c >= 0 && r < n && c < m && maze[r][c] != 1) {
                    r += d[0];
                    c += d[1];
                    curr++;
                }

                // we would have move one extra step
                r -= d[0];
                c -= d[1];
                curr--;

                if (vis[r][c] <= curr + dist)
                    continue;

                vis[r][c] = curr + dist;

                pq.add(new spair(r * m + c, curr + dist));

            }
        }

        return -1;

    }

    // 789 lintcode 

    public class tuple {

        String psf;
        int idx;
        int dsf;

        tuple(String psf, int idx, int dsf) {
            this.psf = psf;
            this.idx = idx;
            this.dsf = dsf;
        }

    }

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {

        int n = maze.length;
        int m = maze[0].length;

        PriorityQueue<tuple> pq = new PriorityQueue<>((a, b) -> {
            if (a.dsf == b.dsf) {
                return a.psf.compareTo(b.psf);
            }
            return a.dsf - b.dsf;
        });

        tuple[][] vis = new tuple[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                vis[i][j] = new tuple("", i * m + j, (int) (1e8));
            }
        }

        char[] dstr = { 'r', 'u', 'l', 'd' };
        int[][] dir = { { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } }; // d r l u

        vis[ball[0]][ball[1]] = new tuple("", ball[0] * m + ball[1], 0);
        pq.add(new tuple("", ball[0] * m + ball[1], 0));

        while (pq.size() != 0) {
            tuple t = pq.remove();

            int sr = (t.idx) / m;
            int sc = (t.idx) % m;
            int d = t.dsf;

            if (sr == hole[0] && sc == hole[1]) {
                return t.psf;
            }

            for (int i = 0; i < 4; i++) {

                int r = sr + dir[i][0];
                int c = sc + dir[i][1];

                int len = 1;
                while (r >= 0 && c >= 0 && r < n && c < m && maze[r][c] == 0 && !(r == hole[0] && c == hole[1])) {
                    r += dir[i][0];
                    c += dir[i][1];
                    len++;
                }

                // not encountered a hole
                if (!(r == hole[0] && c == hole[1])) {

                    r -= dir[i][0];
                    c -= dir[i][1];
                    len--;
                }

                if (vis[r][c].dsf < d + len)
                    continue;

                if (d + len == vis[r][c].dsf && (vis[r][c].psf.compareTo(t.psf + dstr[i]) < 0))
                    continue;

                vis[r][c] = new tuple(t.psf + dstr[i], r * m + c, d + len);
                pq.add(new tuple(t.psf + dstr[i], r * m + c, d + len));

            }
        }

        return "impossible";

    }

}
