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

    public static boolean areMirror(Node n1, Node n2) {
           
        if(n1.children.size() != n2.children.size()) return false;
        if(n1.val != n2.val) return false;
        int size = n1.children.size();

        for(int i=0;i<size;i++){

            if(!areMirror(n1.children.get(i), n2.children.get(size-i-1))) return false;
        }

        return true;
    }


}

