import java.util.*;

public class C120 {

    static long INF = Long.MAX_VALUE;
    public static class Node {
        int v;
        String psf;
        long wsf;

        Node(int v, String psf, long wsf) {
            this.v = v;
            this.wsf = wsf;
            this.psf = psf;
        }
    }

    public static String dj(ArrayList<int[]>[] graph, int src, int dest) {

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            return (int)a.wsf - (int)b.wsf;
        });

        long[] dist = new long[graph.length + 1];
        Arrays.fill(dist, INF);

        pq.add(new Node(src, src + "", 0));

        while (pq.size() != 0) {
            Node top = pq.remove();

            int v = top.v;
            String p = top.psf;
            long w = top.wsf;

            if (v == dest) {
                return p;
            }

            for (int[] nbr : graph[v]) {

                int nv = nbr[0];
                int nw = nbr[1];

                if (dist[nv] > nw + w) {
                    dist[nv] = nw + w;
                    String npsf = p + " " + nv;
                    pq.add(new Node(nv, npsf, dist[nv]));
                }
            }

        }

        return "";

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int V = scn.nextInt();
        int E = scn.nextInt();

        ArrayList<int[]>[] graph = new ArrayList[V + 1];

        for (int i = 0; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            int u = scn.nextInt();
            int v = scn.nextInt();
            int w = scn.nextInt();

            graph[u].add(new int[] { v, w });
            graph[v].add(new int[] { u, w });
        }

        String res = dj(graph, 1, V);
        if (res.equals("")) {
            System.out.println(-1);
        } else {
            System.out.println(res);
        }
    }

}
