import java.util.Scanner;

public class C380 {

    public static class Node {
        int open;
        int close;
        int full;

        Node() {
            this.open = 0;
            this.close = 0;
            this.full = 0;
        }

        Node(int open, int close, int full) {

            this.open = open;
            this.close = close;
            this.full = full;
        }
    }

    public static Node merge(Node lc, Node rc) {
        Node node = new Node();

        node.full = lc.full + rc.full + Math.min(lc.open, rc.close);
        node.close = lc.close + rc.close - Math.min(lc.open, rc.close);
        node.open = lc.open + rc.open - Math.min(lc.open, rc.close);
        return node;
    }

    public static void build(int idx, int si, int ei, String s, Node[] seg) {

        if (si == ei) {
            int op = s.charAt(si) == '(' ? 1 : 0;
            int cl = s.charAt(si) == ')' ? 1 : 0;
            seg[idx] = new Node(op, cl, 0);
            return;

        }

        int mid = (si + ei) / 2;

        build(2 * idx, si, mid, s, seg);
        build(2 * idx + 1, mid + 1, ei, s, seg);

        seg[idx] = merge(seg[2 * idx], seg[2 * idx + 1]);
    }

    public static Node query(int idx, int si, int ei, int l, int r, Node[] seg) {
        if (ei < l || si > r) {
            return new Node();
        } else if (l <= si && ei <= r || si==ei) {
            return seg[idx];
        }

        int mid = (si + ei) / 2;
        Node lans = query(2 * idx, si, mid, l, r, seg);
        Node rans = query(2 * idx + 1, mid + 1, ei, l, r, seg);

        return merge(lans, rans);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String s = scn.next();
        int q = scn.nextInt();

        Node seg[] = new Node[4 * s.length()];

        build(1, 0, s.length() - 1, s, seg);
        while (q-- > 0) {
            int l = scn.nextInt();
            int r = scn.nextInt();

            l--;
            r--;
            Node res = query(1, 0, s.length() - 1, l, r, seg);
            System.out.println(res.full * 2);

        }

    }
}
