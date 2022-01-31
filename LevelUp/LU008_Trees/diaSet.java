import java.util.*;

public class diaSet {

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

    // edge ke term -> time complexity -> O(N)
    public int height(TreeNode root) {

        if (root == null)
            return -1;

        int lh = height(root.left);
        int rh = height(root.right);

        return Math.max(lh, rh) + 1;
    }

    // -> O(N^2)
    public int diameter(TreeNode root) {

        if (root == null)
            return -1;

        int left_dia = diameter(root.left);
        int right_dia = diameter(root.right);

        int lh = height(root.left);
        int rh = height(root.right);

        int curr_dia = lh + rh + 2;

        int dia = Math.max(left_dia, Math.max(right_dia, curr_dia));

        return dia;

    }

    int dia = 0;

    public int diameter_02(TreeNode root) {
        if (root == null)
            return -1;

        int lh = diameter_02(root.left);
        int rh = diameter_02(root.right);

        // finding lh,rh at every point and calculating diameter then only
        int curr_dia = lh + rh + 2;

        dia = Math.max(dia, curr_dia);

        return Math.max(lh, rh) + 1;
    }

    // int[0] -> height
    // int[1] -> diameter
    public int[] diameter_03(TreeNode root) {
        if (root == null)
            return new int[] { -1, -1 };

        int[] ldh = diameter_03(root.left);
        int[] rdh = diameter_03(root.right);

        int lh = ldh[0];
        int rh = rdh[0];

        int ld = ldh[1];
        int rd = rdh[1];

        int curr_dia = lh + rh + 2;

        int diameter = Math.max(curr_dia, Math.max(rd, ld));
        int height = Math.max(lh, rh) + 1;
        return new int[] { height, diameter };
    }

    // 112
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;

        if (root.left == null && root.right == null) {
            return targetSum - root.val == 0;
        }

        boolean res = hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
        return res;
    }

    // 113
    public void pathSum(TreeNode root, int targetSum, List<Integer> ans, List<List<Integer>> res) {

        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            if (targetSum - root.val == 0) {
                ans.add(root.val);
                List<Integer> base = new ArrayList<>(ans);
                res.add(base);
                ans.remove(ans.size() - 1);
            }
            return;
        }

        // adding
        ans.add(root.val);

        pathSum(root.left, targetSum - root.val, ans, res);
        pathSum(root.right, targetSum - root.val, ans, res);

        // removing
        ans.remove(ans.size() - 1);

    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        pathSum(root, targetSum, ans, res);
        return res;
    }

    // gfg
    int ans = -(int)1e8;
    
    public int maxLeafToNode(TreeNode root){
        
        if(root == null) return -(int)1e8;
        
        if(root.left == null && root.right == null) return root.val;
        
        int leftans = maxLeafToNode(root.left);
        int rightans = maxLeafToNode(root.right);
        
        int myAns = Math.max(leftans,rightans)+root.val; // jaha se max ans a raha hai vo path me include hoga
        
        if(leftans!=-(int)1e8 && rightans!=-(int)1e8 ){
            int left_to_left = leftans + rightans + root.val;
            ans = Math.max(ans,left_to_left);
        }
        
        return myAns;
    }
    
    int maxPathSum(TreeNode root)
    { 
       int res = maxLeafToNode(root);
       if(ans == -(int)1e8) ans = res; // skew tree
       return ans;
    } 
}
