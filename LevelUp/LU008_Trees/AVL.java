import java.util.*;

public class AVL {

    public class TreeNode {
        TreeNode left;
        TreeNode right;

        int val;
        int height;
        int bf; // balancing factor => lh - rh

        public TreeNode(int val) {
            this.val = val;
        }

    }

    public TreeNode rightMost(TreeNode root) {

        if (root.right == null)
            return root;

        return rightMost(root.right);
    }

    public void updateHeightBf(TreeNode root) {

        int lh = root.left == null ? -1 : root.left.height;
        int rh = root.right == null ? -1 : root.right.height;

        root.height = Math.max(lh, rh) + 1;
        root.bf = (lh - rh);

    }

    TreeNode rightRotate(TreeNode A) {

        TreeNode B = A.left;

        TreeNode right_of_B = B.right;

        B.right = A;
        A.left = right_of_B;

        updateHeightBf(A);
        updateHeightBf(B);

        return B;
    }

    TreeNode leftRotate(TreeNode A) {
        TreeNode B = A.right;
        TreeNode left_of_B = B.left;

        B.left = A;
        A.right = left_of_B;

        updateHeightBf(A);
        updateHeightBf(B);

        return B;
    }

    // balancing the root;
    TreeNode rotate(TreeNode root) {

        updateHeightBf(root);

        if (root.bf == 2) {

            if (root.left.bf == 1) {

                /* A(left)->B(left)->C */
                // right rotation
                return rightRotate(root);

            } else {

                /* A(left)->B(right)->C */

                // left rotation
                root.left = leftRotate(root.left);

                // right rotation

                return rightRotate(root);

            }

        } else if (root.bf == -2) {

            if (root.right.bf == -1) {

                /* A(right)->B(right)->C */
                // left rotation
                return leftRotate(root);

            } else {

                // A(right)->B(left)->C

                // right rotation
                root.right = rightRotate(root.left);

                // left rotation
                return leftRotate(root);

            }
        }

        return root;

    }

    TreeNode insert(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);

        if (root.val < val) {
            root.right = insert(root.right, val);
        } else {
            root.left = insert(root.left, val);
        }

        return rotate(root);
    }

    TreeNode delete(TreeNode root, int val) {
        if (root == null)
            return null;

        if (root.val == val) {

            if (root.left == null) {
                return root.left;
            }

            if (root.left == null) {
                return root.right;
            }

            TreeNode rm = rightMost(root.left);

            root.val = rm.val;

            root.right = delete(root.right, rm.val);

        }

        if (root.val < val) {
            root.right = delete(root.right, val);
        } else {
            root.left = delete(root.left, val);
        }

        return rotate(root);
    }

    public  void main(String[] args) {

        TreeNode root = null;

        for(int i=0;i<=10;i++){
            insert(root, i);
        }
    }
}
