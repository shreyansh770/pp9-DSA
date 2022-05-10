import java.util.*;

public class q1 {

    public class Edge {
        int v;
        double p;

        Edge(int v, double p) {
            this.v = v;
            this.p = p;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {

        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < edges.length; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {

            int u = edges[i][0];
            int v = edges[i][1];
            double p = succProb[i];

            graph(u).add(new Edge(v, p));
            graph(v).add(new Edge(u, p));

        }

        boolean[] vis = new boolean[n];

        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> {
            return Double.compare(b.p, a.p);
        });

        pq.add(new Edge(start, 1.0));

        while(pq.size()!=0){

            Edge top = pq.remove();

            if(end == top.v) return top.p;

            if(vis[top.v]) continue;

            vis[top.v] = true;

            for(Edge nbr : graph.get(top.v)){

                if(!vis[nbr.v]){

                    double np = (nbr.p * top.p);

                    pq.add(new Edge(nbr.v, np));
                }
            }

        }

        return 0.0;

    }
}
