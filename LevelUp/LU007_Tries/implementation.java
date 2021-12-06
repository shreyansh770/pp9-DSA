import java.util.*;

public class implementation {

    class Trie {

        public class TrieNode {
            TrieNode[] node;
            boolean isWord;

            TrieNode() {
                node = new TrieNode[26];
                isWord = false;
            }
        }

        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {

            TrieNode curr = root;

            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);

                if (curr.node[ch - 'a'] == null) {
                    curr.node[ch - 'a'] = new TrieNode();
                }

                curr = curr.node[ch - 'a'];

            }

            curr.isWord = true;

        }

        public boolean search(String word) {
            TrieNode curr = root;

            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);

                if (curr.node[ch - 'a'] == null) {
                    return false;
                }

                curr = curr.node[ch - 'a'];

            }

            return curr.isWord;
        }

        public boolean startsWith(String prefix) {
            TrieNode curr = root;

            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);

                if (curr.node[ch - 'a'] == null) {
                    return false;
                }

                curr = curr.node[ch - 'a'];

            }

            return true;
        }
    }

   // 211
   class WordDictionary {

    public class TrieNode{
        TrieNode[] node;
        boolean isWord;
        
        TrieNode(){
            node = new TrieNode[26];
            isWord = false;
        }
        
        
    }
    
    TrieNode root;
    
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr = root;
        
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            
            if(curr.node[ch-'a']==null){
                curr.node[ch-'a'] = new TrieNode();
            }
            
            curr = curr.node[ch-'a'];
            
        }
        
        curr.isWord = true;
    }
    
    public boolean rec(String word , int idx , TrieNode curr){
        
        if(idx == word.length()) return curr.isWord;
        
        char ch = word.charAt(idx);
        
        boolean ans = false;
        
        if(ch == '.'){
            
              for(int i=0;i<26;i++){
                  if(curr.node[i]!=null){
                        ans = ans || rec(word, idx+1,curr.node[i]);
                  }
              }
            
        }else{
            
            if(curr.node[ch-'a'] == null) return false;
           ans = ans || rec(word, idx+1,curr.node[ch-'a']);
        }
        
        return ans;
    }
    
    public boolean search(String word) {
        
        TrieNode curr = root;
        
        return rec(word , 0 , curr);
    }
}

}