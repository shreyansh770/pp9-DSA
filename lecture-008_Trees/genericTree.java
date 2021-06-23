import java.util.*;

public class genericTree {

    public static class Node {
        int data = 0;
        ArrayList<Node> childs;

        Node(int data) {
            this.data = data;
            this.childs = new ArrayList<>();
        }
    }

    public static int height(Node node) {

        int h = -1;

        for (Node child : node.childs) {
            int childh = height(child);
            h = Math.max(h, childh);
        }

        return h + 1;
    }

    public static int size(Node node) {

        int sum = 0;

        for (Node child : node.childs) {
            int childSize = size(child);
            sum = sum + childSize;
        }
        sum += 1;
        return sum;
    }

    public static int maximum(Node node) {
        int m = node.data;
        for (Node child : node.childs) {
            m = Math.max(child.data, m);
        }

        return m;
    }

    public static int sum(Node node) {
        int s = 0;

        for (int i = 0; i < node.childs.size(); i++) {
            int cs = sum(node.childs.get(i));
            s += cs;
        }

        s += node.data;
        return s;
    }

    public static boolean find(Node node, int data) {
        if (node.data == data)
            return true;

        for (int i = 0; i < node.childs.size(); i++) {
            boolean f = find(node.childs.get(i), data);
            if (f)
                return true;
        }

        return false;

    }

    public static boolean find_02(Node node, int data) {
        if (node.data == data) {
            return true;
        }

        boolean flag = false;
        for (Node child : node.childs) {
            flag = flag || find_02(child, data);
        }

        return flag;

    }

    /*****************************/
    public static boolean nodeToRootPath_(Node node, int data, ArrayList<Node> ans) {

        if (node.data == data) {
            ans.add(node);
            return true;
        }

        for (Node child : node.childs) {
            boolean b = nodeToRootPath_(child, data, ans);
            if (b) {
                ans.add(node);
                return b;
            }
        }

        return false;
    }

    public static ArrayList<Node> nodeToRootPath(Node node, int data) {
        ArrayList<Node> ans = new ArrayList<>();
        nodeToRootPath_(node, data, ans);
        return ans;
    }

    public static ArrayList<Node> nodeToRootPath_02(Node node, int data) {
        if (node.data == data) {
            ArrayList<Node> base = new ArrayList<>();
            base.add(node);
            return base;
        }

        for (Node child : node.childs) {
            ArrayList<Node> ans = nodeToRootPath_02(child, data);
            if (ans.size() > 0) {
                ans.add(node);
                return ans;
            }
        }

        return new ArrayList<>();
    }

    public static boolean nodeToRootPath_03(Node node, int data, ArrayList<Node> ans) {
        if (node.data == data) {
            ans.add(node);
            return true;
        }

        boolean res = false;
        for (Node child : node.childs) {
            res = res || nodeToRootPath_03(child, data, ans);
        }
        if (res)
            ans.add(node);

        return res;
    }

    /*****************************/

    public static int countLeaves(Node root) {

        if (root.childs.size() == 0)
            return 1;

        int count = 0;
        for (Node node : root.childs) {

            count += countLeaves(node);
        }

        return count;
    }

    /*****************************/

    public static int lca(Node node, int d1, int d2) {

        ArrayList<Node> p1 = nodeToRootPath(node, d1);
        ArrayList<Node> p2 = nodeToRootPath(node, d2);

        int i = p1.size() - 1;
        int j = p2.size() - 1;

        while (i >= 0 && j >= 0 && p1.get(i) == p2.get(j)) {
            i--;
            j--;
        }

        return p1.get(i + 1).data;
    }

    /*****************************/

    public static boolean areSimilar(Node n1, Node n2) {
        if (n1.childs.size() != n2.childs.size()) {
            return false;
        }

        for (int i = 0; i < n1.childs.size(); i++) {

            if (!areSimilar(n1.childs.get(i), n2.childs.get(i))) {
                return false;
            }

        }

        return true;
    }

    /*****************************/

    static int ceil = Integer.MAX_VALUE;
    static int floor = Integer.MIN_VALUE;

    public static void ceilAndFloor(Node node, int data) {
        if (node.data > data && node.data < ceil)
            ceil = node.data;

        if (node.data < data && node.data > floor)
            floor = node.data;

        for (Node child : node.childs) {
            ceilAndFloor(child, data);
        }
    }

    /*************************/

    public static boolean areMirror(Node n1, Node n2) {
        if (n1.childs.size() != n2.childs.size()) {
            return false;
        }

        for (int i = 0; i < n1.childs.size(); i++) {
            Node c1 = n1.childs.get(i);
            Node c2 = n2.childs.get(n2.childs.size() - 1 - i);
            if (areMirror(c1, c2) == false) {
                return false;
            }
        }

        return true;
    }

    /*************************/

    // upBound se chota apno me sbse bara
    public static int kthLargest(Node node, int k, int upBound) {

        int maxRes = -(int) 1e9;
        for (Node child : node.childs) {
            int recAns = kthLargest(child, k, upBound);
            maxRes = Math.max(maxRes, recAns);
        }

        return node.data < upBound ? Math.max(node.data, maxRes) : maxRes;

    }

    public static int kthLargest(Node node, int k) {

        int upb = (int) 1e9;

        for (int i = 0; i < k; i++) {
            upb = kthLargest(node, k, upb); // upB se just chota value ayega
        }

        return upb;

    }

    /**************************************************/

   /*IMP*/ public static Node getTail(Node node) {

        while (node.childs.size() != 0) {
            node = node.childs.get(0);
        }

        return node;
    }

    public static void linearize(Node node) {

        for (Node child : node.childs) {
            linearize(child);
        }

        for (int i = node.childs.size() - 1; i > 0; i--) {
            Node tail = getTail(node.childs.get(i - 1));
            tail.childs.add(node.childs.get(i));

            node.childs.remove(i);
        }
    }
}
