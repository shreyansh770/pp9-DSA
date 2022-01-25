import java.util.*;

public class balaceBST {

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

    // 1387

    TreeNode rightRotate(TreeNode A) {

        TreeNode B = A.left;

        TreeNode right_of_B = B.right;

        B.right = A;
        A.left = right_of_B;

        B.right = rotate(A);
        return rotate(B);

    }

    TreeNode leftRotate(TreeNode A) {
        TreeNode B = A.right;
        TreeNode left_of_B = B.left;

        B.left = A;
        A.right = left_of_B;

        B.left = rotate(A);
        return rotate(B);

    }

    // balancing the root;
    TreeNode rotate(TreeNode root) {

        // updateHeightBf_(root);
        updateHeightBf_(root);

        if (getBf(root) >= 2) {

            if (getBf(root.left) >= 1) {

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

        } else if (getBf(root) <= -2) {

            if (getBf(root.right) <= -1) {

                /* A(right)->B(right)->C */
                // left rotation
                return leftRotate(root);

            } else {

                // A(right)->B(left)->C

                // right rotation
                root.right = rightRotate(root.right);

                // left rotation
                return leftRotate(root);

            }
        }

        return root;

    }

    int[] height = new int[100001];

    public void updateHeightBf_(TreeNode root) {

        int lh = root.left == null ? -1 : height[root.left.val];
        int rh = root.right == null ? -1 : height[root.right.val];

        height[root.val] = Math.max(lh, rh) + 1;
    }

    public int getBf(TreeNode root) {
        int lh = root.left == null ? -1 : height[root.left.val];
        int rh = root.right == null ? -1 : height[root.right.val];

        return lh - rh;
    }

    public TreeNode constructTree(TreeNode root) {
        if (root == null)
            return null;

        root.left = constructTree(root.left);
        root.right = constructTree(root.right);

        return rotate(root);
    }

    public TreeNode balanceBST(TreeNode root) {

        Arrays.fill(height, -1);

        return constructTree(root);

    }

}
