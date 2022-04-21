import java.util.*;

public class sumOfIntervalST {
    public static class SegmentTree {

        static int[] tree;
        static int[] arr;

        SegmentTree(int ar[]) {
            arr = ar;
            tree = new int[4 * ar.length];
            buildSumTree(1, 0, ar.length - 1);

        }

        private void buildSumTree(int nodeIdx, int start, int end) {

            if (start == end) {
                tree[nodeIdx] = arr[start];
                return;
            }

            int lc = 2 * nodeIdx;
            int rc = 2 * nodeIdx + 1;

            int mid = (start + end) / 2;
            buildSumTree(lc, start, mid);
            buildSumTree(rc, mid + 1, end);

            tree[nodeIdx] = tree[lc] + tree[rc];

        }

        private void update(int nodeIdx, int s, int e, int pos, int val) {

            if (s == e) {
                arr[s] = val;
                tree[nodeIdx] = val;
            } else {

                int mid = (s + e) / 2;
                if (s <= pos && pos <= mid) {
                    update(nodeIdx * 2, s, mid, pos, val);
                } else {
                    update(nodeIdx * 2 + 1, mid + 1, e, pos, val);
                }

                tree[nodeIdx] = tree[nodeIdx * 2] + tree[nodeIdx * 2 + 1];
            }
        }

        void update(int pos, int val) {

            update(1, 0, arr.length - 1, pos, val);
        }

        private int query(int nodeIdx, int s, int e, int l, int r) {

            if (e < l || r < s) {
                return 0;
            }

            if (s == e) {
                return tree[nodeIdx];
            } else if (l <= s && e <= r) {
                return tree[nodeIdx];
            } else {
                int lc = 2 * nodeIdx;
                int rc = 2 * nodeIdx + 1;

                int mid = (s + e) / 2;
                int left = query(lc, s, mid,l,r);
                int right = query(rc, mid + 1, e,l,r);

                return left+right;
            }
        }

        int query(int l, int r) {
            return query(1,0,arr.length-1,l,r);
        }

    }
}
