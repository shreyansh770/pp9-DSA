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
        if(root == null )return 0;

        return size(root.left) + size(root.right) + 1;
    }

    public static int sum(Node root) {
        if(root == null )return 0;

        return sum(root.left) + sum(root.right) + root.data;  
    }

    public static int max(Node root) {
        return root == null ? -(int)1e9 : Math.max(root.data,Math.max(max(root.left),max(root.right)));
    }

    public static int min(Node root) {
        return root == null ? (int)1e9 : Math.min(root.data,Math. min( min(root.left), min(root.right)));
    }

    // height in terms of edges
    public static int height(Node root) {
        return root == null ? -1 : Math.max(height(root.left) , height(root.right)) + 1;
    }

    public static int heightInTermsOfNodes(Node root) {
        return root == null ? 0 : Math.max(heightInTermsOfNodes(root.left) , heightInTermsOfNodes(root.right)) + 1;
    }

}
