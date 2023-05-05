public class lazyPropagation {

    public static class SegmentTree {
        int[] lazy;
        int[] seg;
        int[] arr;

        SegmentTree(int ar[]) {
            arr = ar;
            lazy = new int[ar.length * 4];
            seg = new int[ar.length * 4];
            build(1, 0, ar.length - 1);
        }

        private void build(int nodeIdx, int s, int e) {

            if (s == e) {
                lazy[nodeIdx] = arr[s];
            } else {

                int mid = (s + e) / 2;
                build(2 * nodeIdx, s, mid);
                build(2 * nodeIdx + 1, mid + 1, e);
                seg[nodeIdx] = seg[2 * nodeIdx] + seg[2 * nodeIdx + 1];

            }
        }

        private void update(int nodeIdx, int s, int e, int l, int r, int val) {

            // update the previous remaining updates in lazy
            // and propagate downwards

            if (lazy[nodeIdx] != 0) {
                seg[nodeIdx] += (r - l + 1) * lazy[nodeIdx];
                // propagate the lazy update downwards
                // for the remaining nodes to get updated
                if (s != e) {
                    lazy[2 * nodeIdx] += lazy[nodeIdx];
                    lazy[2 * nodeIdx + 1] += lazy[nodeIdx];
                }

                lazy[nodeIdx] = 0; // now update for lazy has been done
            }

            // if no overlap of intervals just return
            if (e < l || s > r)
                return;

            // complete overlap
            if (s <= l && r <= e) {
                seg[nodeIdx] = (r - l + 1) * val; // 5 nodes int the range each contribute +5 => 5*5
                if (s != e) {
                    lazy[2 * nodeIdx] += lazy[nodeIdx];
                    lazy[2 * nodeIdx + 1] += lazy[nodeIdx];
                }

                return;
            }

            // partial

            int mid = (s + e) / 2;
            update(nodeIdx * 2, s, mid, l, r, val);
            update(nodeIdx * 2 + 1, mid + 1, e, l, r, val);
            seg[nodeIdx] = seg[2 * nodeIdx] + seg[2 * nodeIdx + 1];

        }

        private int query(int nodeIdx, int s, int e, int l, int r) {

            // if any updates are remaining
            if (lazy[nodeIdx] != 0) {
                seg[nodeIdx] += (r - l + 1) * lazy[nodeIdx];
                // propagate the lazy update downwards
                // for the remaining nodes to get updated
                if (s != e) {
                    lazy[2 * nodeIdx] += lazy[nodeIdx];
                    lazy[2 * nodeIdx + 1] += lazy[nodeIdx];
                }

                lazy[nodeIdx] = 0; // now update for lazy has been done
            }

            // if no overlap of intervals just return
            if (e < l || s > r)
                return 0;

            // complete overlap
            if (s <= l && r <= e) {
                return seg[nodeIdx];
            }

            int mid = (s + e) / 2;
            int left = query(nodeIdx * 2, s, mid, l, r);
            int right = query(nodeIdx * 2 + 1, mid + 1, e, l, r);

            return left + right;
        }

        void update(int l, int r, int val) {

            update(1, 0, arr.length - 1, l, r, val);
        }

        // find value at idx
        int query(int l, int r) {

            return query(1, 0, arr.length - 1, l, r);
        }

    }

    public static void main(String[] args) {
        
    }
}
