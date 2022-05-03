import java.util.java;

public class largestBST {

    static class Node {
        int data;
        Node left, right;

        public Node(int d) {
            data = d;
            left = right = null;
        }
    }

    public class pair {
        // boolean isBST;
        int min;
        int max;
        int size;
        Node root;

        pair(int min, int max, int size, Node root) {

            this.min = min;
            this.max = max;
            this.size = size;
            this.root = root;
        }
    }


    static int maxSize = 0;

    public static pair isBST(Node root) {

        if (root == null)
            return new pair((int) 1e9, -(int) 1e9, 0, null);

        pair l = isBST(root.left);
        pair r = isBST(root.right);

        if((l!=null && r!=null && root.data>l.max && root.data<r.min)==false){
            return null; // not bst;
        }

        int size = l.size+r.size+1;//+1 for the root

        maxSize = Math.max(size, maxSize);

        if(root.left==null||root.right==null){
            int min = Math.min(root.val,l.min);
            int max = Math.max(root.val,r.max);

            return new pair(min, max, size, root);
        }

        return new pair(l.min,r.max,size,root);

    }
}
