import java.util.*;

public class bfs {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public void level_order(TreeNode root) {
        LinkedList<TreeNode> q = new LinkedList<>();

        q.addLast(root);

        while (q.size() != 0) {

            TreeNode top = q.removeFirst();

            System.out.print(top.val + " ");

            if (top.left != null) {
                q.addLast(top.left);
            }

            if (top.right != null) {
                q.addLast(top.right);
            }
        }
    }

    public void level_order_2(TreeNode root) {
        LinkedList<TreeNode> q = new LinkedList<>();

        q.addLast(root);
        q.addLast(null);
        int level = 0;
        while (q.size() != 0) {

            TreeNode top = q.removeFirst();
            if (top == null) {
                System.out.println();
                level++;
                if (q.size() > 0)
                    q.addLast(null);
                continue;
            }

            System.out.print(top.val + " ");

            if (top.left != null) {
                q.addLast(top.left);
            }

            if (top.right != null) {
                q.addLast(top.right);
            }
        }
    }

    public void level_order_3(TreeNode root) {
        LinkedList<TreeNode> q = new LinkedList<>();

        q.addLast(root);
        q.addLast(null);
        int level = 0;
        while (q.size() != 0) {
            int size = q.size();
            while (size-- > 0) {
                TreeNode top = q.removeFirst();

                System.out.print(top.val + " ");

                if (top.left != null) {
                    q.addLast(top.left);
                }

                if (top.right != null) {
                    q.addLast(top.right);
                }
            }

            level++;
            System.out.println();

        }
    }

    // LEFT VIEW

    // level order ka 1st element would be the left view
    public ArrayList<Integer> leftView(TreeNode root) {

        ArrayList<Integer> ans = new ArrayList<>();

        LinkedList<TreeNode> q = new LinkedList<>();

        q.addLast(root);

        while (q.size() != 0) {
            int size = q.size();
            boolean first = true;
            while (size-- > 0) {
                TreeNode top = q.removeFirst();

                if (first) {
                    ans.add(top.val);
                    first = false;
                }

                if (top.left != null) {
                    q.addLast(top.left);
                }

                if (top.right != null) {
                    q.addLast(top.right);
                }
            }
        }

        return ans;

    }

    public void leftViewRecur(ArrayList<Integer> ans, TreeNode root, int level) {

        if (root == null)
            return;

        // first time visiting that root
        if (level == ans.size()) {
            ans.add(root.val);
        }

        leftViewRecur(ans, root.left, level + 1);
        leftViewRecur(ans, root.right, level + 1);
    }

    public ArrayList<Integer> leftViewRecur(TreeNode root) {

        ArrayList<Integer> ans = new ArrayList<>();
        leftViewRecur(ans, root, 0);
        return ans;
    }

    // RIGHT VIEW

    // level order traversal ka last element
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        LinkedList<TreeNode> q = new LinkedList<>();

        q.addLast(root);
        while (q.size() != 0) {
            int size = q.size();
            TreeNode top = null;
            while (size-- > 0) {

                top = q.removeFirst();

                if (top.left != null) {
                    q.addLast(top.left);
                }

                if (top.right != null) {
                    q.addLast(top.right);
                }
            }

            ans.add(top.val);
        }

        return ans;
    }

    // phle left na jake right side jaenge
    public void rightViewRecur(ArrayList<Integer> ans, TreeNode root, int level) {

        if (root == null)
            return;

        // first time visiting that root
        if (level == ans.size()) {
            ans.add(root.val);
        }

        rightViewRecur(ans, root.right, level + 1);
        rightViewRecur(ans, root.left, level + 1);
    }

    public ArrayList<Integer> rightViewRecur(TreeNode root) {

        ArrayList<Integer> ans = new ArrayList<>();
        rightViewRecur(ans, root, 0);
        return ans;
    }

    // Vertical Level Order Traversal

    static class pair {
        TreeNode node;
        int vl;

        pair(TreeNode node, int vl) {
            this.node = node;
            this.vl = vl;
        }
    }

    public static void findWidth(TreeNode root, int[] minMax, int vl) {

        if (root == null)
            return;
        minMax[0] = Math.min(minMax[0], vl);
        minMax[1] = Math.max(minMax[1], vl);

        findWidth(root.left, minMax, vl - 1);
        findWidth(root.right, minMax, vl + 1);
    }

    public static void verticalRecur(TreeNode root, ArrayList<ArrayList<Integer>> ans, int vl, int shift) {

        if (root == null)
            return;

        ans.get(vl + shift).add(root.val);

        verticalRecur(root.left, ans, vl - 1, shift);
        verticalRecur(root.right, ans, vl + 1, shift);
    }

    public static ArrayList<ArrayList<Integer>> vlot(TreeNode root) {

        int[] minMax = new int[2]; // -> this is stroring the min and max on left and right rep of tree

        findWidth(root, minMax, 0);

        int widthoFTree = minMax[1] - minMax[0] + 1;

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < widthoFTree; i++) {
            ans.add(new ArrayList<>());
        }

        // recursively
        // verticalRecur(root, ans, 0, Math.abs(minMax[0]));

        // w/o recursion

        LinkedList<pair> q = new LinkedList<>();
        int shift = Math.abs(minMax[0]);
        q.addLast(new pair(root, 0));

        while (q.size() != 0) {
            int size = q.size();

            while (size-- > 0) {

                pair top = q.removeFirst();

                ans.get(top.vl + shift).add(top.node.val);

                if (top.node.left != null) {
                    q.addLast(new pair(top.node.left, top.vl - 1));
                }

                if (top.node.right != null) {
                    q.addLast(new pair(top.node.right, top.vl + 1));
                }
            }
        }

        // System.out.println(ans);
        return ans;
    }

    // Top view

    public ArrayList<Integer> topView_01(TreeNode root) {

        ArrayList<ArrayList<Integer>> ans = vlot(root);
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < ans.size(); i++) {
            res.add(ans.get(i).get(0));
        }

        return res;
    }

    public class treePair {
        TreeNode node;
        int hl; // -> horizontal level

        treePair(TreeNode node, int hl) {
            this.node = node;
            this.hl = hl;
        }
    }

    public void rec(TreeNode root, int vl, int hl, HashMap<Integer, treePair> m) {

        if (root == null)
            return;

        if (!m.containsKey(vl)) {
            m.put(vl, new treePair(root, hl));
        } else {
            if (m.get(vl).hl > hl) { // jiksa hl chota hoga vo phle aya hoga kyuki usne niche vale ko chupa liya hoga
                                     // islea vo top viw me nhi ayega
                m.put(vl, new pair(root, hl));
            }
        }

        rec(root.left, vl - 1, hl + 1, m);
        rec(root.left, vl + 1, hl + 1, m);
    }

    public ArrayList<Integer> topView_02(TreeNode root) {

        HashMap<Integer, treePair> m = new HashMap<>();// vl vs treepair

        rec(root, 0, 0, m);

        ArrayList<Integer> ans = new ArrayList<>();

        for (Integer key : m.keySet()) {
            ans.add(m.get(key).node.val);
        }

        return ans;
    }

    // bottom view

    static class bpair {
        TreeNode node;
        int vl;

        bpair(TreeNode node, int vl) {
            this.node = node;
            this.vl = vl;
        }
    }

    public static ArrayList<Integer> bottomView(TreeNode root) {

        LinkedList<bpair> q = new LinkedList<>();

        int[] minMax = new int[2];

        minMax[0] = (int) 1e9;
        minMax[1] = -(int) 1e9;
        findWidth(root, minMax, 0);

        int width = minMax[1] - minMax[0] + 1;
        int shift = -(minMax[0]);

        q.addLast(new bpair(root, shift));
        // HashMap<Integer,Integer> ans = new HashMap(); -> do it will map arraylist se
        // java me nhi ho raha
        ArrayList<Integer> ans = new ArrayList<>();

        while (q.size() != 0) {
            bpair top = q.removeFirst();

            TreeNode node = top.node;
            int vl = top.vl;

            ans.add(vl, node.val); // not vl+shift bcoz we have added shift intinally in the queue

            if (node.left != null) {
                q.addLast(new bpair(node.left, vl - 1));
            }

            if (node.right != null) {
                q.addLast(new bpair(node.right, vl + 1));
            }

        }

        return ans;
    }

    // diagonal traversal

    public void rec_d(TreeNode root, ArrayList<ArrayList<Integer>> diag, int dl) {

        if (root == null)
            return;

        if (dl == diag.size()) {
            diag.add(new ArrayList<>());
        }

        diag.get(dl).add(root.val);

        // on left we +1 in out dl
        rec_d(root.left, diag, dl + 1);

        // on right we have stay on same dl
        rec_d(root.right, diag, dl);
    }

    public ArrayList<Integer> diagonal(TreeNode root) {
        ArrayList<ArrayList<Integer>> diag = new ArrayList<>();

        rec_d(root, diag, 0);

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < diag.size(); i++) {
            for (int j = 0; j < diag.get(i).size(); j++) {
                ans.add(diag.get(i).get(j));
            }
        }

        return ans;
    }
}
