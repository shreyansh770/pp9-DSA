import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.youtube.com/watch?v=nGhE4Ekmzbc
// and in brown note book

public class TreeDisatance2 {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static long[] subTreeSizes;
    static long[] subTreeNode; // sum of distance of ith node from every other node in its tree

    public static void generateSubtreeInfo(int src, int par, List<List<Integer>> graph) {

        int no_of_nodes = 1;
        int ans_for_subTree = 0;
        for (int child : graph.get(src)) {

            if (child != par) {
                generateSubtreeInfo(child, src, graph);

                no_of_nodes += subTreeSizes[child];
                ans_for_subTree += subTreeNode[child] + subTreeSizes[child];
            }
        }

        subTreeNode[src] = ans_for_subTree;
        subTreeSizes[src] = no_of_nodes;

    }

    static long[] ans;

    public static void getDistSumforallNodes(int src, long par_ans, int par, int N, List<List<Integer>> graph) {

        long res = par_ans + subTreeNode[src] + (N - subTreeSizes[src]);
        ans[src] = res;
        for (int child : graph.get(src)) {

            if (child != par) {
                par_ans = ans[src] - (subTreeNode[child]+ subTreeSizes[child]);
                getDistSumforallNodes(child, par_ans, src, N, graph);
            }
        }
    }

    public static void main(String[] args) {

        FastReader fs = new FastReader();

        int n = fs.nextInt();

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            int u = fs.nextInt();
            int v = fs.nextInt();

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        subTreeSizes = new long[200001];
        subTreeNode = new long[200001];

        ans = new long[200001];

        generateSubtreeInfo(1, 0, graph);
        getDistSumforallNodes(1, 0, 0, n, graph);

        for (int i = 1; i <= n; i++) {
            System.out.print(ans[i] + " ");
        }

    }
}
