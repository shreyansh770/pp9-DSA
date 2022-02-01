import java.util.*;

public class binaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean find(TreeNode root, TreeNode data) {

        if (root == null)
            return false;

        if (root == data)
            return true;

        return find(root.right, data) || find(root.left, data);

    }

    public boolean nodeToRootPath(TreeNode root, TreeNode p, ArrayList<TreeNode> ntrp) {

        if (root == null || p == null)
            return false;

        if (root == p) {
            ntrp.add(root);
            return true;
        }

        boolean ans = nodeToRootPath(root.left, p, ntrp) || nodeToRootPath(root.right, p, ntrp);

        if (ans) {
            ntrp.add(root);
        }

        return ans;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        ArrayList<TreeNode> ntrp1 = new ArrayList<>();
        nodeToRootPath(root, p, ntrp1);

        ArrayList<TreeNode> ntrp2 = new ArrayList<>();
        nodeToRootPath(root, q, ntrp2);

        int i = ntrp1.size() - 1;
        int j = ntrp2.size() - 1;

        while (i >= 0 && j >= 0 && ntrp1.get(i) == ntrp2.get(j)) {
            i--;
            j--;
        }
        i++;
        return ntrp1.get(i);
    }

    // wo extra space
    TreeNode lca = null;

    public boolean find(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null)
            return false;

        boolean left = find(root.left, p, q);
        boolean right = find(root.right, p, q);

        if (left && right) {
            lca = root;
            return true;
        }

        if (root == p) {
            if (left || right)
                lca = p;

            return true;

        }

        if (root == q) {
            if (left || right)
                lca = q;

            return true;

        }

        return left || right;
    }

    public TreeNode lowestCommonAncestor_(TreeNode root, TreeNode p, TreeNode q) {

        find(root, p, q);

        return lca;
    }

    /*********************************/

    public void getKLevelDown(TreeNode root, int k, List<TreeNode> ans) {

        if (root == null)
            return;

        if (k == 0) {
            ans.add(root);
        }

        getKLevelDown(root.left, k - 1, ans);
        getKLevelDown(root.right, k - 1, ans);

    }

    public List<TreeNode> kdown(TreeNode root, int k) {

        List<TreeNode> ans = new ArrayList<>();
        getKLevelDown(root, k, ans);
        return ans;
    }

    // 863
    public boolean nodeToRootPath(TreeNode root, TreeNode target, List<TreeNode> ans) {

        if (root == null)
            return false;

        if (root == target) {
            ans.add(root);
            return true;
        }

        boolean res = nodeToRootPath(root.left, target, ans) || nodeToRootPath(root.right, target, ans);

        if (res)
            ans.add(root);

        return res;

    }

    public void getKlevelDown(TreeNode root, TreeNode block, int k, List<Integer> ans) {

        if (root == null || k < 0 || root == block)
            return;

        if (k == 0) {
            ans.add(root.val);
            return;
        }

        getKlevelDown(root.left, block, k - 1, ans);
        getKlevelDown(root.right, block, k - 1, ans);

    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if (root == null)
            return new ArrayList<>();
        List<TreeNode> ans = new ArrayList<>();
        nodeToRootPath(root, target, ans);

        TreeNode block = null;
        List<Integer> fans = new ArrayList<>();
        for (int i = 0; i < ans.size(); i++) {

            getKlevelDown(ans.get(i), block, k--, fans);
            block = ans.get(i);
        }
        return fans;
    }

    /* Burning Tree */

    public void getBurningNodes(TreeNode root ,int time ,List<List<Integer>> ans,TreeNode block){
        if(root == null || root == block) return ;

        if(time == ans.size()){
            ans.add(new ArrayList<>());
        }

        ans.get(time).add(root.val);

        getBurningNodes(root.left, time+1, ans,block);
        getBurningNodes(root.right, time+1, ans,block);
    }


    public int burningTreeFind(TreeNode root,TreeNode target,List<List<Integer>> ans){

        if(root == null) return -1;

        if(root == target){
            // get nodes
            getBurningNodes(root, 0, ans, null);
            return 1; //  target node is tell its parent that it s 1 distance away from it this means that the parent node will burn at 1th sec
        }

        int left_dist = burningTreeFind(root.left, target, ans);
        int right_dist = burningTreeFind(root.right, target, ans);

        if(left_dist>=0){
            getBurningNodes(root, left_dist, ans, root.left);
            return left_dist +1;
        }

        if(right_dist >=0){
            getBurningNodes(root, right_dist, ans, root.right);
            return right_dist+1;
        }

        return -1;
    }

    public List<List<Integer>> burningTree(TreeNode root , TreeNode target){

        List<List<Integer>> ans = new ArrayList<>();

        burningTreeFind(root,target,ans);
        return ans;
    }

    
    
}
