import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class segmentTree {

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

    static int[] tree;
    static int[] arr;

    private static void buildSegTree(int nodeIdx, int start, int end) {

        if (start == end) {
            tree[nodeIdx] = arr[start];
            return;
        }

        int mid = (start + end) / 2;
        int lc = nodeIdx * 2; // since we have taken 1 based indexing for tree
        int rc = nodeIdx * 2 + 1;
        buildSegTree(lc, start, mid);
        buildSegTree(rc, mid + 1, end);

        tree[nodeIdx] = Math.max(tree[lc], tree[rc]);

    }

    private int solveQuery(int nodeIdx, int s, int e, int l, int r) {

        if (e < l || s > r) {
            return -(int) 1e9;
        } else if (l <= s && e <= r) {
            return tree[nodeIdx];
        } else if (s == e) {
            return tree[nodeIdx];
        } else {

            int mid = (s + e) / 2;
            int left = solveQuery(nodeIdx * 2, s, mid, l, r);
            int right = solveQuery(nodeIdx * 2 + 1, mid + 1, e, l, r);

            return Math.max(left, right);
        }
    }

    private void update(int nodeIdx, int start, int end, int pos, int val) {

        if (start == end) {
            arr[start] = val;
            tree[nodeIdx] = val;
        } else {

            int mid = (start + end) / 2;

            // pos lies in left child
            if (start <= pos && pos <= mid) {

                update(nodeIdx * 2, start, mid, pos, val);

            } else {
                update(nodeIdx * 2 + 1, mid + 1, end, pos, val);
            }

            tree[nodeIdx] = Math.max(tree[nodeIdx * 2], tree[nodeIdx * 2 + 1]);

        }
    }

    void update(int pos, int val) {

        update(1, 0, arr.length - 1, pos, val);
    }

    // query is finding max for the range [l,r] in arr
    public int query(int l, int r) {

        return solveQuery(1, 0, arr.length - 1, l, r);
    }

    segmentTree(int[] ar) {

        arr = ar;
        tree = new int[4 * arr.length];
        buildSegTree(1, 0, arr.length - 1);
    }

    public static void main(String[] args) {

    }
}
