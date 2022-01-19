import java.util.*;

public class bst {

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

    public int height(TreeNode root) {

        return root == null ? -1 : Math.max(root.left, root.right) + 1;
    }

    public int min_(TreeNode root) {

        if (root.left == null)
            return root.val;

        return min_(root.left);
    }

    public int max_(TreeNode root) {
        if (root.right == null)
            return root.val;

        return max_(root.right);
    }

    public int size(TreeNode root) {
        return root == null ? -1 : size(root.left) + size(root.right) + 1;
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {

        if (root == null)
            return new TreeNode(val);

        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);

        }

        else {
            root.right = insertIntoBST(root.right, val);
        }

        return root;
    }

    public int rightMost(TreeNode root) {

        if (root.right == null)
            return root.val;

        return rightMost(root.right);
    }

    public int leftMost(TreeNode root) {
        if (root.left == null)
            return root.val;

        return leftMost(root.left);
    }

    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null)
            return null;

        if (root.val == key) {

            // this will be the point of del node
            if (root.left == null && root.right == null) {
                return null;
            }

            if (root.left != null) {

                int justSmaller = rightMost(root.left);

                root.val = justSmaller;

                root.left = deleteNode(root.left, justSmaller);

            } else {

                int justLarger = leftMost(root.right);

                root.val = justLarger;

                root.right = deleteNode(root.right, justLarger);
            }
        }

        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            root.left = deleteNode(root.left, key);
        }

        return root;

    }

    public TreeNode leftMost_(TreeNode root) {
        if (root.left == null)
            return root;

        return leftMost_(root.left);
    }
    
    
    // returns the inorder successor of the Node x in BST (rooted at 'root')
	public TreeNode inorderSuccessor(TreeNode root,TreeNode x)
         {
            if(root == null) return null;
            
            if(root.val == x.val){
                
                if(root.right!=null) return leftMost_(root.right);
                
                return null;
            }
            
            
            if(root.val <  x.val){
                return inorderSuccessor(root.right,x); // if by any chance we are getting null from right someone above us will be successor
            }else{
                TreeNode left = inorderSuccessor(root.left,x);
                
                if(left == null) return root; // if we are getting null from out left then we are succ
                
                return left; 
            }
         }

    

}
