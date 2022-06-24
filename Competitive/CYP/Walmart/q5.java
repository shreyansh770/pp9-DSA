public class q5 {

    public int sum(Node root){
        if(root==null) return 0;

        int pre_val = root.data;
 
        int l = sum(root.left);
        int r = sum(root.right);

        root.data = l + r;

        return root.data + pre_val;
    }

    public void toSumTree(Node root){
        sum(root);
   }
}
