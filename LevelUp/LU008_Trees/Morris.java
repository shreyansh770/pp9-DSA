import java.util.*;

public class Morris {

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

    
    public TreeNode getRightMost(TreeNode leftNode, TreeNode curr) {

        // leftNode.right == curr -> this means thread has already been constructed
        while (leftNode.right != null && leftNode.right != curr) {

            leftNode = leftNode.right;
        }

        return leftNode;
    }
    
    public List<Integer> morris_InOrder(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        TreeNode curr = root;
        while (curr != null) {

            TreeNode left = curr.left;

            if (left == null) {
                ans.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode rm = getRightMost(left, curr);

                if (rm.right == null) { // make thread
                    rm.right = curr;
                    curr = curr.left;
                } else if (rm.right == curr) { // thread already exist destruct and add

                    ans.add(curr.val);
                    rm.right = null; // delete thread
                    curr = curr.right;
                }
            }
        }

        return ans;
    }


    public List<Integer> morris_preOrder(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        TreeNode curr = root;
        while (curr != null) {

            TreeNode left = curr.left;

            if (left == null) {
                ans.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode rm = getRightMost(left, curr);

                if (rm.right == null) { // make thread and add
                    ans.add(curr.val);
                    rm.right = curr;
                    curr = curr.left;
                } else if (rm.right == curr) { // thread already exist destruct 
                    rm.right = null; // delete thread
                    curr = curr.right;
                }
            }
        }

        return ans;
    }

}
