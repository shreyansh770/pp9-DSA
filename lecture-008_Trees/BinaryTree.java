import java.util.*;

public class BinaryTree {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        Node(int data) {
            this(data, null, null);// apne he class ke constructor ko call karega jo 3 args leta h
        }
    }

    public static void preOrder(Node root, ArrayList<Integer> ans) {
        if (root == null)
            return;

        ans.add(root.data);
        preOrder(root.left, ans);
        preOrder(root.right, ans);
    }

    public static void postOrder(Node root, ArrayList<Integer> ans) {
        if (root == null)
            return;
        preOrder(root.right, ans);
        preOrder(root.left, ans);
        ans.add(root.data);
    }

    public static void inOrder(Node root, ArrayList<Integer> ans) {
        if (root == null)
            return;

        preOrder(root.right, ans);
        ans.add(root.data);
        preOrder(root.left, ans);

    }

    public static int size(Node root) {
        if (root == null)
            return 0;

        return size(root.left) + size(root.right) + 1;
    }

    public static int sum(Node root) {
        if (root == null)
            return 0;

        return sum(root.left) + sum(root.right) + root.data;
    }

    public static int max(Node root) {
        return root == null ? -(int) 1e9 : Math.max(root.data, Math.max(max(root.left), max(root.right)));
    }

    public static int min(Node root) {
        return root == null ? (int) 1e9 : Math.min(root.data, Math.min(min(root.left), min(root.right)));
    }

    // height in terms of edges
    public static int height(Node root) {
        return root == null ? -1 : Math.max(height(root.left), height(root.right)) + 1;
    }

    public static int heightInTermsOfNodes(Node root) {
        return root == null ? 0 : Math.max(heightInTermsOfNodes(root.left), heightInTermsOfNodes(root.right)) + 1;
    }

    /* https://practice.geeksforgeeks.org/problems/count-leaves-in-binary-tree/1# */
    public static int countLeaves(Node root) {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null)
            return 1;

        return countLeaves(root.left) + countLeaves(root.right);
    }

    public static void countExactlyOneChild(Node root, ArrayList<Integer> ans) {
        if (root == null)
            return;

        if (root.left == null && root.right != null || root.left != null && root.right == null) {
            ans.add(root.data);
        }

        countExactlyOneChild(root.left, ans);
        countExactlyOneChild(root.right, ans);

    }

    public static int countExactlyOneChild(Node root) {
        if (root == null || root.left == null && root.right == null)
            return 0;

        int leftCount = countExactlyOneChild(root.left);
        int rightCount = countExactlyOneChild(root.right);
        int sum = leftCount + rightCount;
        if (root.left == null || root.right == null)
            return sum + 1;

        return sum;
    }

}
