
import java.util.*;

public class construction {

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

    public TreeNode construct(int[] pre, int psi, int pei, int[] in, int isi, int iei) {

        if (psi > pei)
            return null;
        TreeNode root = new TreeNode(pre[psi]);

        int root_ele = pre[psi];

        int idx = isi;

        while (in[idx] != root_ele) {
            idx++;
        }

        int no_of_ele_left = idx - isi;

        root.left = construct(pre, psi + 1, psi + no_of_ele_left, in, isi, idx - 1);
        root.right = construct(pre, psi + no_of_ele_left + 1, pei, in, idx + 1, iei);

        return root;
    }

    public TreeNode buildTree_in_pre(int[] pre, int[] in) {

        return construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    public TreeNode cons(int[] in, int isi, int iei, int[] pos, int psi, int pei) {

        if (psi > pei)
            return null;

        TreeNode root = new TreeNode(pos[pei]);

        int root_ele = pos[pei];

        int idx = isi;

        while (in[idx] != root_ele) {
            idx++;
        }

        int no_of_ele_left = idx - isi;

        root.left = cons(in, isi, idx - 1, pos, psi, psi + no_of_ele_left - 1);
        root.right = cons(in, idx + 1, iei, pos, psi + no_of_ele_left, pei - 1);

        return root;

    }

    public TreeNode buildTreein_post(int[] in, int[] pos) {

        return cons(in, 0, in.length - 1, pos, 0, pos.length - 1);
    }

    public TreeNode construct(int[] nums, int si, int ei) {

        if (si > ei)
            return null;

        int mid = (si + ei) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = construct(nums, si, mid - 1);
        root.right = construct(nums, mid + 1, ei);

        return root;

    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return construct(nums, 0, nums.length - 1);
    }

    // O(N^2)
    public TreeNode construct_(int[] pre, int si, int ei) {

        if (si > ei)
            return null;

        TreeNode root = new TreeNode(pre[si]);
        int idx = si + 1;

        while (idx < pre.length && pre[idx] < pre[si])
            idx++;

        root.left = construct_(pre, si + 1, idx - 1);
        root.right = construct_(pre, idx, ei);

        return root;

    }

    // O(N)

    public TreeNode construct_(int[] pre, int lower_limit, int upper_limit, int[] idx) {

        int i = idx[0];

        if (i >= pre.length || pre[i] < lower_limit || pre[i] > upper_limit)
            return null;

        TreeNode root = new TreeNode(pre[i]);
        idx[0]++; // increasing index value since we can't take global variable so we make a array
                  // for the number of global variables be need

        root.left = construct_(pre, lower_limit, pre[i], idx);
        root.right = construct_(pre, pre[i], upper_limit, idx);

        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {

        return construct_(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE, new int[1]);

        // return construct_(preorder,0,preorder.length-1);
    }

    // leet 449 =====================================================

    public class Codec {
        public void getPre(TreeNode root, StringBuilder sb) {
            if (root == null)
                return;

            sb.append(root.val);
            sb.append(" ");

            getPre(root.left, sb);
            getPre(root.right, sb);

        }

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();

            getPre(root, sb);

            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.equals(""))
                return null;

            String[] arr = data.split(" ");

            int[] preorder = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                preorder[i] = Integer.parseInt(arr[i]);
            }

            return bstFromPreorder(preorder);
        }
    }


    // 297
    public class Codec_ {

        private void encode_(TreeNode root, StringBuilder sb) {

            if (root == null) {
                sb.append("n ");
                return;
            }

            sb.append(root.val);
            sb.append(" ");

            encode_(root.left, sb);

            encode_(root.right, sb);
        }

        private TreeNode decode_(String[] arr, int[] idx) {

            int i = idx[0];

            if (arr[i].equals("n")) {
                idx[0]++;
                return null;
            }

            int rv = Integer.parseInt(arr[i]);
            TreeNode root = new TreeNode(rv);
            idx[0]++;

            root.left = decode_(arr, idx);
            root.right = decode_(arr, idx);

            return root;

        }

        public String serialize(TreeNode root) {

            StringBuilder sb = new StringBuilder();

            encode_(root, sb);

            return sb.toString();
        }

        public TreeNode deserialize(String data) {

            if (data == "")
                return null;

            String[] arr = data.split(" ");

            return decode_(arr, new int[1]);

        }
    }

}
