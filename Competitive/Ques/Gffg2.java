
// https://practice.geeksforgeeks.org/problems/burning-tree/1
import java.util.*;

public class Gffg2 {

    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    static List<List<Integer>> burned;

    public static void burnBachas(Node root, int time, Node blocked) {

        if (root == null)
            return;

        if (burned.get(time).size() == 0)
            burned.add(new ArrayList<>());

        burned.get(time).add(root.data);

        burnBachas(root.left, time + 1, blocked);
        burnBachas(root.right, time + 1, blocked);
    }

    public static int minTime_(Node root, int target) {
        if (root == null)
            return -1;

        if (root.data == target) {
            burnBachas(root, 0, null);
            return 1;
        }

        int left = minTime_(root.left, target);
        int right = minTime_(root.right, target);

        if (left >= 0) {

            burnBachas(root, left, root.left);
            return left + 1;
        }

        if (right >= 0) {
            burnBachas(root, right, root.right);
            return right + 1;
        }

        return -1;
    }

    public static int minTime(Node root, int target) {
        burned = new ArrayList<>();
        minTime_(root, target);
        return burned.size()-1;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
    }
}
