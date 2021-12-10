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


    
}
