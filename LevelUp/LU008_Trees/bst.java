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

        return root == null ? -1 : Math.max(root.left.val, root.right.val) + 1;
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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode x) {
        if (root == null)
            return null;

        if (root.val == x.val) {

            if (root.right != null)
                return leftMost_(root.right);

            return null;
        }

        if (root.val < x.val) {
            return inorderSuccessor(root.right, x); // if by any chance we are getting null from right someone above us
                                                    // will be successor
        } else {
            TreeNode left = inorderSuccessor(root.left, x);

            if (left == null)
                return root; // if we are getting null from out left then we are succ

            return left;
        }
    }

    public TreeNode inorderPredecessor(TreeNode root, TreeNode x) {

        if (root == null)
            return null;

        if (root.val >= x.val) {
            return inorderPredecessor(root.left, x);
        } else {
            TreeNode val = inorderPredecessor(root.right, x);

            if (val == null)
                return root;
            else
                return val;
        }
    }

    // O(1)-> space O(n)-> time (Morris Traversal)

    public TreeNode getRightMost(TreeNode leftNode, TreeNode curr) {

        // leftNode.right == curr -> this means thread has already been constructed
        while (leftNode.right != null && leftNode.right != curr) {

            leftNode = leftNode.right;
        }

        return leftNode;
    }

    public TreeNode[] inorderPreSuc(TreeNode root, TreeNode x) {
        TreeNode[] ans = new TreeNode[2];

        TreeNode pre = null;
        TreeNode succ = null;
        TreeNode prev = null;

        TreeNode curr = root;

        while (curr != null) {

            if (curr.left != null) {
                TreeNode rm_node = getRightMost(curr.left, curr);

                if (rm_node.right == null) {
                    rm_node.right = curr;
                    curr = curr.left;
                } else {

                    rm_node.right = null;

                    if (curr == x)
                        pre = prev;

                    if (prev == x)
                        succ = curr;
                    prev = curr;
                    curr = curr.right;

                }
            } else {

                if (curr == x)
                    pre = prev;

                if (prev == x)
                    succ = curr;
                prev = curr;
                curr = curr.right;
            }
        }

        ans[0] = pre;
        ans[1] = succ;

        return ans;
    }

    // O(1)-> space O(logn)-> time

    public TreeNode rightMost_(TreeNode root) {

        if (root.right == null)
            return root;

        return rightMost_(root.right);
    }

    public TreeNode[] inorderPreSuc_(TreeNode root, TreeNode x) {
        TreeNode[] ans = new TreeNode[2];

        TreeNode pre = null;
        TreeNode succ = null;
        // TreeNode prev = null;

        TreeNode curr = root;

        while (curr != null) {

            if (curr.val < x.val) {

            } else if (curr.val > x.val) {

            } else {
                TreeNode lm_node = leftMost_(curr.right);

                if (lm_node != null)
                    succ = lm_node;

                TreeNode rm_node = rightMost_(root.left);

                if (rm_node != null)
                    pre = rm_node;
            }
        }

        ans[0] = pre;
        ans[1] = succ;

        return ans;
    }

    // 1038
    int sum = 0;

    public TreeNode bstToGst(TreeNode root) {

        if (root == null)
            return null;

        bstToGst(root.right);
        sum += root.val;
        root.val = sum;

        bstToGst(root.left);

        return root;
    }

    // 1305
    public void inorder(TreeNode root, List<Integer> list) {

        if (root == null)
            return;

        inorder(root.left, list);

        list.add(root.val);

        inorder(root.right, list);
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

        List<Integer> a1 = new ArrayList<>();
        List<Integer> a2 = new ArrayList<>();

        inorder(root1, a1);
        inorder(root2, a2);

        int i = 0;
        int j = 0;

        List<Integer> list = new ArrayList<>();

        while (i < a1.size() && j < a2.size()) {

            if (a1.get(i) < a2.get(j)) {
                list.add(a1.get(i));
                i++;
            } else {
                list.add(a2.get(j));
                j++;
            }
        }

        while (i < a1.size()) {
            list.add(a1.get(i));
            i++;
        }

        while (j < a2.size()) {
            list.add(a2.get(j));
            j++;
        }

        return list;

    }

    // 669
    public TreeNode trimBST(TreeNode root, int low, int high) {

        if (root == null)
            return null;

        if (root.val < low) { // if root.val < low => left would have much lesser value so we don't have inc
                              // left anymore
            return trimBST(root.right, low, high);
        }

        if (root.val > high) {// if root.val > high => right would have much greater value so we don't have
                              // inc right anymore
            return trimBST(root.left, low, high);
        }

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }

    // 230
    public void push(Stack<TreeNode> st, TreeNode root) {

        while (root != null) {
            st.push(root);
            root = root.left;
        }
    }

    public int kthSmallest(TreeNode root, int k) {

        Stack<TreeNode> st = new Stack<>();

        push(st, root);

        while (st.size() != 0) {
            TreeNode top = st.peek();
            st.pop();
            k--;
            if (k == 0)
                return top.val;

            if (top.right != null)
                push(st, top.right);
        }

        return -1;

    }

    // recursive

    public void dfs(TreeNode root, int[] k, int[] ans) {
        if (root == null)
            return;

        dfs(root.left, k, ans);

        k[0]--;
        if (k[0] == 0)
            ans[0] = root.val;

        dfs(root.right, k, ans);

    }

    public int kthSmallest_(TreeNode root, int k) {
        int[] arr = new int[1];
        arr[0] = k;
        int[] ans = new int[1];
        ans[0] = -1;
        dfs(root, arr, ans);
        return ans[0];
    }

    // morris -- ?

    // 173
    class BSTIterator {

        LinkedList<TreeNode> st;

        public BSTIterator(TreeNode root) {
            st = new LinkedList<>();
            addAllLeft(root);
        }

        private void addAllLeft(TreeNode root) {
            while (root != null) {
                st.addFirst(root);
                root = root.left;
            }
        }

        public int next() {
            TreeNode top = st.removeFirst();

            addAllLeft(top.right);

            return top.val;
        }

        public boolean hasNext() {
            return st.size() != 0;
        }
    }

    // 116
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect(Node root) {

        if (root == null)
            return null;

        LinkedList<Node> q = new LinkedList<>();

        q.addLast(root);
        q.addLast(null);
        Node ptr = root;

        while (q.size() > 1) {

            Node top = q.removeFirst();
            if (top == null) {
                q.addLast(null);
            } else {

                if (top.left != null) {
                    top.left.next = top.right;
                    Node next = q.getFirst();

                    if (next != null) {
                        top.right.next = next.left;
                    }

                    q.addLast(top.left);
                    q.addLast(top.right);
                }

            }

        }

        return root;
    }

    // space O(1)

    public Node connect_(Node root) {

        if (root == null)
            return null;

        Node curr = root;
        while (curr != null) {
            Node prev = curr;

            while (prev != null) {

                if (prev.left == null)
                    break;
                prev.left.next = prev.right;

                Node next = prev.next;

                if (next != null) {
                    prev.right.next = next.left;
                }

                prev = prev.next;

            }

            curr = curr.left;
        }

        return root;

    }

    // 968
    public int findCameraCount(TreeNode root, int camera) {

        if (root == null)
            return -1; // dont need camera

        int left_req = findCameraCount(root.left, camera);
        int right_req = findCameraCount(root.right, camera);

        if (left_req == 1 || right_req == 1) {
            camera++;
            return 0; // i am the camera
        }

        if (left_req == 0 || right_req == 0) {
            return -1;// dont need camera
        }

        // not monitored ,require camera
        return 1;
    }

    public int minCameraCover(TreeNode root) {
        int camera = 0;

        if (findCameraCount(root, camera) == 1)
            camera++;

        return camera;
    }

    // 1373

    int maxSum;

    private class pair {
        int sum;
        int max;
        int min;
        TreeNode node;

        pair(int sum, int max, int min, TreeNode node) {
            this.sum = sum;
            this.max = max;
            this.min = min;
            this.node = node;
        }
    }

    private pair isBST(TreeNode root) {

        if (root == null)
            return new pair(0, -(int) 1e9, (int) 1e9, null);

        pair l = isBST(root.left);
        pair r = isBST(root.right);

        if ((l != null && r != null && root.val > l.max && root.val < r.min) == false) {

            return null; // not bst
        }

        int sum = l.sum + r.sum + root.val;

        maxSum = Math.max(sum, maxSum);

        // just for root whoes left or right or both are null
        if (root.left == null || root.right == null) {
            int min = Math.min(root.val, l.min);
            int max = Math.max(root.val, r.max);
            return new pair(sum, max, min, root);
        }

        return new pair(sum, r.max, l.min, root);
    }

    public int maxSumBST(TreeNode root) {

        maxSum = 0;
        isBST(root);

        return maxSum;
    }

    //979

    int moves=0;
    public int requirement(TreeNode root){

        if(root == null) return 0;
        
        int left_req = requirement(root.left);
        int right_req = requirement(root.right);
        
        moves+= Math.abs(left_req) + Math.abs(right_req);  // moves => sum of coins required/ excess on left and right

        return root.val +left_req + right_req -1; //  total requirement of ith node is its total value + left child req + right child req -1(1 for itlsef)


    }

    public int distributeCoins(TreeNode root) {
        
        requirement(root);
        return moves;
    }

}
