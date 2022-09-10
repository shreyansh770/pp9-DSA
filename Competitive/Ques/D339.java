import java.util.*;

public class D339 {

    static int[] arr;
    static int[] seg;

    public static void buildSegTree(int idx, int s, int e, boolean orr) {

        if (s == e) {
            seg[idx] = arr[s];
            return;
        }

        int mid = (s + e) / 2;
        int lc = 2 * idx;
        int rc = 2 * idx + 1;

        buildSegTree(lc, s, mid, !orr);
        buildSegTree(rc, mid + 1, e, !orr);

        if (orr)
            seg[idx] = seg[lc] ^ seg[rc];
        else
            seg[idx] = seg[lc] | seg[rc];
    }

    public static void update(int idx, int s, int e, int i, int val, boolean orr) {

        if (s == e) {
            arr[s] = val;
            seg[idx] = val;
        } else {
            int mid = (s + e) / 2;

            if (s <= i && i <= mid) {
                update(2 * idx, s, mid, i, val, !orr);
            } else {
                update(2 * idx + 1, mid + 1, e, i, val, !orr);
            }
        }
        if (orr)
            seg[idx] = seg[2 * idx] ^ seg[2 * idx + 1];
        else
            seg[idx] = seg[2 * idx] | seg[2 * idx + 1];
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int q = scn.nextInt();

        int noe = (int) Math.pow(2, n);
        arr = new int[noe];

        for (int i = 0; i < noe; i++) {
            arr[i] = scn.nextInt();
        }

        seg = new int[4 * noe];
        if (n % 2 == 0) {

            buildSegTree(1, 0, arr.length - 1, false);
        } else {
            buildSegTree(1, 0, arr.length - 1, true);
        }

        while (q-- > 0) {
            int i = scn.nextInt();
            int val = scn.nextInt();

            if (n % 2 == 0) {

                update(1, 0, arr.length - 1, i, val, false);
            } else {
                update(1, 0, arr.length - 1, i, val, true);
            }

            System.out.println(seg[1]);

        }

    }

}
