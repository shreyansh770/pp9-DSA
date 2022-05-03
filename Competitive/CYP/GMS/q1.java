import java.util.*;

public class q1 {

    public boolean areAna(String s, String t) {

        if (s.length() != t.length())
            return false;

        int[] freqs = new int[26];
        int[] freqt = new int[26];

        for (int i = 0; i < s.length(); i++) {
            freqs[s.charAt(i) - 'a']++;
            freqt[t.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (freqs[i] != freqt[i])
                return false;
        }

        return true;

    }

    public List<List<String>> Anagrams(String[] string_list) {
        // Code here

        List<List<String>> res = new ArrayList<>();
        // HashSet<String> set = new HashSet<>();
        boolean[] vis = new boolean[string_list.length];

        for (int i = 0; i < string_list.length; i++) {
            if (vis[i])
                continue;
            String tocheck = string_list[i];
            List<String> ans = new ArrayList<>();
            ans.add(tocheck);
            vis[i] = true;

            for (int j = 0; j < string_list.length; j++) {
                if (i == j)
                    continue;

                if (areAna(tocheck, string_list[j])) {
                    vis[j] = true;
                    ans.add(string_list[j]);
                }
            }

            res.add(ans);
        }

        return res;

    }
}
