import java.util.*;

public class q8 {

    class Node {
        int data;
        Node left;
        Node right;
        Node nextRight;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
            nextRight = null;
        }
    }

    public void connect(Node root) {

        LinkedList<Node> q = new LinkedList<>();

        q.addLast(root);

        while (q.size() != 0) {
            int s = q.size();
            Node prev = null;

            while (s-- > 0) {

                Node top = q.removeFirst();

                if (prev == null) {
                    prev = top;
                } else {
                    prev.nextRight = top;
                    prev = top;
                }

                if (top.left) {

                    q.addLast(top.left);
                }

                if (top.right) {
                    q.addLast(top.right);
                }

            }
        }

    }
}
