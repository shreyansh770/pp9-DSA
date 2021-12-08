import java.util.*;



public class genricTree{

    class Node {
        public int val;
        public List<Node> children;
    
        public Node() {}
    
        public Node(int _val) {
            val = _val;
        }
    
        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public void rec(Node root , List<Integer> ans){
        ans.add(root.val);
        
        for(Node child : root.children){
            rec(child,ans);
        }
        
    }
    
    public List<Integer> preorder(Node root) {
                
        if(root == null) return new ArrayList<>();
        
        List<Integer> ans = new ArrayList<>();
        rec(root,ans);
        return ans;
    }

    public void rec_(Node root , List<Integer> ans){
        
        for(Node child : root.children){
            rec(child,ans);
        }
        
        ans.add(root.val);
        
    }
    
    public List<Integer> postorder(Node root) {
                
        if(root == null) return new ArrayList<>();
        
        List<Integer> ans = new ArrayList<>();
        rec(root,ans);
        return ans;
    }
}

