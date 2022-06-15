public class q11 {
    private void encode_(TreeNode root , StringBuilder sb){
        
        if(root == null){
            sb.append("n ");
            return;
        }
        
        sb.append(root.val);
        sb.append(" ");
        
        encode_(root.left,sb);
        
        encode_(root.right,sb);
    }
    
    
   private TreeNode decode_(String[] arr ,int[] idx ){
       
       int i = idx[0];
       
       if(arr[i].equals("n")){
           idx[0]++;
           return null;
       }
       
       int rv = Integer.parseInt(arr[i]);
       TreeNode root = new TreeNode(rv);
       idx[0]++;
       
       root.left = decode_(arr,idx);
       root.right = decode_(arr,idx);
       
       return root;
       
   }
    
    public String serialize(TreeNode root) {
        
        StringBuilder sb = new StringBuilder();
            
        encode_(root,sb);
        
        return sb.toString();
    }

    
    public TreeNode deserialize(String data) {
        
        if(data == "") return null;
        
        String[] arr= data.split(" ");
        
        return decode_(arr, new int[1]);
        
    }
}
