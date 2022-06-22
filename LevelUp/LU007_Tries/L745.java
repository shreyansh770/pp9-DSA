import java.util.*;



public class L745 {

    class TrieNode {
        TrieNode[] node;
        HashSet<String> map;

        TrieNode() {
            node = new TrieNode[26];
            map = new HashSet<>();
        }

    }

    TrieNode root_pre;
    TrieNode root_suff;
    HashMap<String,Integer> idx_list;

    public void insert(String word) {

        TrieNode pre = root_pre;
        TrieNode suff = root_suff;

        for (int i = 0; i < word.length(); i++) {

            char p = word.charAt(i);

            if (pre.node[p - 'a'] == null)
                pre.node[p - 'a'] = new TrieNode();

            pre = pre.node[p - 'a'];
            pre.map.add(word);

            char s = word.charAt(word.length() - i - 1);

            if (suff.node[s - 'a'] == null)
                suff.node[s - 'a'] = new TrieNode();

            suff = suff.node[s - 'a'];
            suff.map.add(word);

        }
    }

    public void WordFilter(String[] words) {
        root_pre = new TrieNode();
        root_suff = new TrieNode();
        idx_list  =new HashMap<>();


        int idx =0;
        for (String word : words) {
            insert(word);
            idx_list.put(word,idx);
            idx++;
            
        }
    }

    public int f(String prefix, String suffix) {

        TrieNode sp = this.root_pre;
        TrieNode ss = this.root_suff;

        for (int i = 0; i < prefix.length(); i++) {

            char ch = prefix.charAt(i);

            if (sp.node[ch - 'a'] == null)
                return -1;

            sp = sp.node[ch - 'a'];
        }

        HashSet<String> pre = sp.map;

        for (int i = suffix.length()-1; i >=0; i--) {
            char ch = suffix.charAt(i);

            if (ss.node[ch - 'a'] == null)
                return -1;

            ss = ss.node[ch - 'a'];
        }

        HashSet<String> suf = ss.map;

        int res = -1;
        for(String s : pre){
            if(suf.contains(s)){
                res = Math.max(res,idx_list.get(s));
            }
        }

        return res;
    }
}
