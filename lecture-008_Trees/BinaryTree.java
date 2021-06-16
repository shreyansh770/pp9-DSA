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

    public static boolean findData(Node node, int data) {
        if (node == null)
            return false;

        if (node.data == data) {
            return true;
        }

        return findData(node.left, data) || findData(node.right, data);
    }

                  /**********************************************/

    /* Method - 1 */
    public static boolean nodeToRootPath(Node node, int data, ArrayList<Node> ans) {
        if (node == null)
            return false;

        if (node.data == data) {
            ans.add(node);
            return true;
        }

        boolean res = nodeToRootPath(node.left, data, ans) || nodeToRootPath(node.right, data, ans);

        if (res)
            ans.add(node);

        return res;
    }

    public static ArrayList<Node> nodeToRootPath(Node root, int data) {
        ArrayList<Node> ans = new ArrayList<>();

        nodeToRootPath(root, data, ans);
        return ans;
    }

    /* Method - 2 */
    public static ArrayList<Node> nodeToRootPath_02_helper(Node root, int data) {
        if (root == null)
            return null;

        if (root.data == data) {
            ArrayList<Node> list = new ArrayList<>();
            list.add(root);
            return list;// returns address
        }

        ArrayList<Node> left = nodeToRootPath_02_helper(root.left, data);
        if (left != null) {
            left.add(root);
            return left;
        }

        ArrayList<Node> right = nodeToRootPath_02_helper(root.right, data);
        if (right != null) {
            right.add(root);
            return right;
        }

        return null;
    }

    public static ArrayList<Node> nodeToRootPath_02(Node root, int data) {
        ArrayList<Node> ans = nodeToRootPath_02_helper(root, data);

        return ans != null ? ans : new ArrayList<>();
    }

                /**********************************************/

    public static void printKlevelDown(Node root, int k, ArrayList<Integer> ans) {
        if (root == null || k < 0)
            return;

        if (k == 0) {
            ans.add(root.data);
            return;
        }

        printKlevelDown(root.left, k - 1, ans);
        printKlevelDown(root.right, k - 1, ans);

    }

    public static void printKlevelDown(Node root, int k) {
        ArrayList<Integer> ans = new ArrayList<>();

        printKlevelDown(root, k, ans);

        for (int e : ans)
            System.out.print(e + " ");
    }

                /**********************************************/

    // k level niche jata hai aur unke array me add kr deta hai
    public static void printKlevelDown(Node root, int k, Node block, ArrayList<Integer> ans) {
        if (root == null || k < 0 || root == block)
            return;

        if (k == 0) {
            ans.add(root.data);
            return;
        }

        printKlevelDown(root.left, k - 1, block, ans);
        printKlevelDown(root.right, k - 1, block, ans);
    }

    public static ArrayList<Integer> printAtKdistance(Node root, int data, int k) {
        ArrayList<Node> list = new ArrayList<>();

        nodeToRootPath(root, data, list);

        ArrayList<Integer> ans = new ArrayList<>();

        Node block = null;

        for (int i = 0; i < list.size(); i++) {
            printKlevelDown(list.get(i), k - i, block, ans);
            block = list.get(i);
        }
        return ans;
    }

    public static int printAtKdistance_02(Node root, int k, int data, ArrayList<Integer> ans) {
        if (root == null)
            return -1;

        if (root.data == data) {
            printKlevelDown(root, k, null, ans);
            return 1;
        }

        int ld = printAtKdistance_02(root.left, k, data, ans);
        if (ld != -1) {
            printKlevelDown(root, k - ld, root.left, ans);
            return ld + 1;// ke alge node se kitne level ka print krna hai uske liye help karega
        }

        int rd = printAtKdistance_02(root.left, k, data, ans);
        if (rd != -1) {
            printKlevelDown(root, k - rd, root.right, ans);
            return rd + 1;
        }

        return -1;
    }


           /**********************************************/


    public static Node removeLeaves(Node node) {
        if (node == null)
            return null;

        if (node.left == null && node.right == null) {
            return null;
        }

        node.left = removeLeaves(node.left);
        node.right = removeLeaves(node.right);

        return node;

    }


    // METHOD -1;

    static Node prev = null;

    public static boolean isBST(Node node){
        if(node == null) return true;

        if(!isBST(node.left)) return false;

        if(prev!=null && prev.data > node.data) return false;

        prev = node;

        if(!isBST(node.right)) return false;


        return true;

    }


    // METHOD -2;

    public static class isBSTPair{
        boolean isBST = true;
        int maxele = -(int)1e9;
        int minele = (int)1e9;
    }
   
    public static isBSTPair isBST_02(Node node){
        if(node == null) return new isBSTPair();



        isBSTPair left = isBST_02(node.left);
        if(left.isBST == false) return left;
        isBSTPair right = isBST_02(node.right);
        if(right.isBST == false) return right;

        isBSTPair self = new isBSTPair();

        self.isBST = false;

        //left.isBST && right.isBST
        //agr left and right true hai tbhi yaha pe ayenge
        
        if(left.maxele < node.data && right.minele > node.data){
             self.maxele = Math.max(right.maxele,node.data);
             self.minele = Math.min(left.minele , node.data);

             self.isBST = true;
        }

        return self;
    }



}
