import java.util.*;

public class BST {
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

    public static int size(Node node) {
        return node == null ? 0 : size(node.left) + size(node.right) + 1;
    }

    public static int height(Node root) {
        return root == null ? -1 : Math.max(height(root.left), height(root.right)) + 1;
    }

    public static int max(Node node) {

        while (node.right != null) {
            node = node.right;
        }

        return node.data;
    }

    public static int min(Node node) {

        while (node.left != null) {
            node = node.left;
        }

        return node.data;
    }

    public static boolean find(Node node, int data) {
        while (node != null) {
            if (node.data == data)
                return true;
            else if (node.data < data)
                node = node.right;
            else
                node = node.left;
        }

        return false;
    }

    public static int sum(Node node) {
        return node == null ? 0 : sum(node.left) + sum(node.right) + node.data;
    }

    // T : O(logn) S: O(1)
    public static ArrayList<Node> RootToNodePath(Node node, int data) {
        ArrayList<Node> ans = new ArrayList<>();
        boolean flag = false;
        while (node != null) {
            if (data == node.data) {
                ans.add(node);
                flag = true;
                break;
            }

            else if (data < node.data) {
                ans.add(node.left);
                node = node.left;
            }

            else {
                ans.add(node.right);
                node = node.right;
            }
        }

        if (!flag)
            ans.clear();
        return ans;

    }

    /*********************************/

    // Recursive
    public static int lca(Node node, int d1, int d2) {
        if (node.data > d1 && node.data > d2) {
            return lca(node.left, d1, d2);
        }

        else if (node.data < d1 && node.data < d2) {
            return lca(node.right, d1, d2);
        }

        return node.data;
    }

    // Iterative

    public static int lca_02(Node node, int d1, int d2) {

        while (node != null) {
            if (node.data > d1 && node.data > d2) {
                node = node.right;
            } else if (node.data < d1 && node.data < d2) {
                node = node.left;
            } else {
                break;
            }
        }
        return node.data;

    }

    /********************************************/

    public static void pir(Node node, int d1, int d2) {
        if (node == null)
            return;

        pir(node.left, d1, d2);

        if (node.data >= d1 && node.data < d2) {
            System.out.println(node.data);
        }

        pir(node.right, d1, d2);
    }

    /********************************************/

    public static Node add(Node node, int data) {
        if (node == null)
            return new Node(data, null, null);

        if (data > node.data) {
            node.right = add(node.right, data);
        } else if (data < node.data) {
            node.left = add(node.left, data);
        }

        return node;

    }

    public static Node remove(Node node, int data) {
        if (node == null)
            return null;

        if (data > node.data) {
            node.right = remove(node.right, data);
        } else if (data < node.data) {
            node.left = remove(node.left, data);
        } else {
            if (node.left != null && node.right != null) {
                int minEle = min(node.right);
                node.data = minEle;
                node.right = remove(node.right, minEle);
                return node;

            } else if (node.left != null) {
                return node.left;
            } else if (node.right != null) {
                return node.right;
            } else {
                return null;// leaf node
            }
        }

        return node;

    }

    /************************************************/

    // https://practice.geeksforgeeks.org/problems/add-all-greater-values-to-every-node-in-a-bst/1#
    public static void modify(Node root, int[] arr) {
        if (root == null)
            return;

        modify(root.right, arr);

        root.data += arr[0];
        arr[0] = root.data;
        modify(root.left, arr);
    }

    // modify the BST and return its root
    public static Node modify(Node root) {
        int[] arr = new int[1];

        modify(root, arr);

        return root;

    }
}
