class Solution{
    static class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isWord;
        
        public TrieNode(){
            Arrays.fill(children,null);
            isWord = false;
        }
    }
    
    public static void formTrie(TrieNode root,String key){
        TrieNode temp = root;
        for(int i = 0; i < key.length(); i++){
            int index = key.charAt(i)-'a';
            if(temp.children[index] == null) temp.children[index] = new TrieNode();
            temp = temp.children[index];
        }
        
        temp.isWord = true;
    }
    
    static ArrayList<ArrayList<String>> displayContacts(int n, 
                                        String contact[], String s)
    {
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        TrieNode root = new TrieNode();
        for(String key:contact) formTrie(root,key);     
        
        TrieNode keyRoot = root;                        //pointer initialized to root
        for(int i = 0; i < s.length(); i++){
            ArrayList<String> subList = new ArrayList<>();
            String key = s.substring(0,i+1);            
            
            if(keyRoot.children[s.charAt(i)-'a'] == null){      //if keyRoot is null for a key, it will be null for all the keys that follow
                String str = "0";                               
                subList.add(str);
                while(i < s.length()){                          
                    res.add(subList);
                    i++;
                }
            }
            else{                                               //if it is not null, apply dfs to obtain all possible words and add list to res
                keyRoot = keyRoot.children[s.charAt(i)-'a'];
                dfs(keyRoot,subList,key);
                res.add(subList);
            }
        }
        
        return res;
    }
    
    public static void dfs(TrieNode keyRoot,ArrayList<String> subList,String key){
        if(keyRoot.isWord) subList.add(key);                //if a word is found, add it to the list
            
        TrieNode temp = keyRoot;
        for(int i = 0; i < 26; i++){                        //going 0 to 25 will ensure lexicographical order
            if(temp.children[i] != null){
                char c = (char)(i+97);                      //ascii character for 'a' = 97
                dfs(temp.children[i],subList,key+c);        
            }
        }
    }
}