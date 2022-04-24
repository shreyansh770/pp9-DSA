public class lazyPropagation {

    public static class SegmentTree {

        int[] lazy;
        int[] arr;

        SegmentTree(int ar[]) {
            arr = ar;
            lazy = new int[ar.length * 4];
            build(1, 0, ar.length - 1);
        }

        private void build(int nodeIdx, int s, int e) {

            if (s == e) {
                lazy[nodeIdx] = arr[s];
            } else {

                int mid = (s + e) / 2;
                build(2 * nodeIdx, s, mid);
                build(2 * nodeIdx + 1, mid + 1, e);
            }
        }

        private void update(int nodeIdx, int s, int e, int l, int r, int val) {

            if (e < l || s > r)
                return;

            if (s == e) {
                lazy[nodeIdx] += val;
            } else if (l <= s && e <= r) {
                lazy[nodeIdx] += val;
            } else {
                int mid = (s + e) / 2;
                update(nodeIdx * 2, s, mid, l, r, val);
                update(nodeIdx * 2 + 1, mid + 1, e, l, r, val);
            }

        }

        private void propagate(int nodeIdx,int s , int e) {

            if(s==e) return; // leaf node can not be further propagated

            int left = nodeIdx * 2;
            int right = nodeIdx * 2 + 1;

            lazy[left] += lazy[nodeIdx];
            lazy[right] += lazy[nodeIdx];
            lazy[nodeIdx] = 0;
        }

        private int query(int nodeIdx, int s, int e, int idx) {

            propagate(nodeIdx,s,e);
            if (s == e) {
                return lazy[nodeIdx];
            } else {
                int mid = (s + e) / 2;

                if (s <= idx && idx <= mid) {
                    return query(nodeIdx * 2, s, mid, idx);
                } else {
                    return query(nodeIdx * 2 + 1, mid + 1, e, idx);
                }
            }

        }

        void update(int l, int r, int val) {

            update(1, 0, arr.length - 1, l, r, val);
        }

        // find value at idx
        int query(int idx) {

            return query(1, 0, arr.length - 1, idx);
        }

    }

}
