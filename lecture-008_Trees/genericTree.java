import java.util.*;

public class genericTree {

    public static class Node {
        int data = 0;
        ArrayList<Node> childs;

        Node(int data) {
            this.data = data;
            this.childs = new ArrayList<>();
        }
    }

    public static int height(Node node) {

        int h = -1;

        for (Node child : node.childs) {
            int childh = height(child);
            h = Math.max(h, childh);
        }

        return h + 1;
    }

    public static int size(Node node) {

        int sum = 0;

        for (Node child : node.childs) {
            int childSize = size(child);
            sum = sum + childSize;
        }
        sum += 1;
        return sum;
    }

    public static int maximum(Node node) {
        int m = node.data;
        for (Node child : node.childs) {
            m = Math.max(child.data, m);
        }

        return m;
    }

    public static int sum(Node node) {
        int s = 0;

        for (int i = 0; i < node.childs.size(); i++) {
            int cs = sum(node.childs.get(i));
            s += cs;
        }

        s += node.data;
        return s;
    }

    public static boolean find(Node node, int data) {
        if (node.data == data)
            return true;

        for (int i = 0; i < node.childs.size(); i++) {
            boolean f = find(node.childs.get(i), data);
            if (f)
                return true;
        }

        return false;

    }

    public static boolean find_02(Node node ,int data){
        if(node.data == data){
            return true;
        }

        boolean flag = false;
        for(Node child : node.childs){
           flag = flag || find_02(child , data);
        }

        return flag;

    }
   

                  /*****************************/
    public static boolean nodeToRootPath(Node node, int data, ArrayList<Node> ans) {

        if (node.data == data){
            ans.add(node);
            return true;
        }

        for (Node child : node.childs) {
            boolean b = nodeToRootPath(child, data, ans);
            if (b) {
                ans.add(node);
                return b;
            }
        }

        return false;
    }

    public static ArrayList<Node> nodeToRootPath(Node node, int data) {
        ArrayList<Node> ans = new ArrayList<>();
        nodeToRootPath(node, data, ans);
        return ans;
    }


    public static ArrayList<Node> nodeToRootPath_02(Node node,int data){
        if(node.data == data){
            ArrayList<Node> base = new ArrayList<>();
            base.add(node);
            return base;
        }

        for(Node child : node.childs){
            ArrayList<Node> ans = nodeToRootPath_02(child, data);
            if(ans.size()>0){
                ans.add(node);
                return ans;
            }
        }

        return null;
    }

 
                 /*****************************/

    public static int countLeaves(Node root){

        int count = 0;

        for(Node node : root.childs){

            count += countLeaves(node);
        }

        return count+1;
    }




                /*****************************/


    public static int lca(Node node, int d1, int d2) {

        if (node.data == d1 || node.data == d2)
            return -1;
        for (Node child : node.childs) {
            int ans = lca(child, d1, d2);
            if (ans == -1) {
                return node.data;
            }
        }

        return -2;
    }
}
