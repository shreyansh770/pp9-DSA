
// https://www.geeksforgeeks.org/find-maximum-path-sum-in-a-binary-tree/
import java.util.*;

public class Gfg2 {

    class Node {

        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    static int max = 0;

    public static int solve(Node root) {

        if (root == null)
            return 0;

        int left = solve(root.left);
        int right = solve(root.right);

        int res = Math.max(root.data, Math.max(left + root.data, right + root.data));

        max = Math.max(res, left + root.data + right);

        return res;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
    }
}
