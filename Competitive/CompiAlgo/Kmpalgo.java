import java.util.*;

public class Kmpalgo {

    // String s = "aabaabaab"
    // String p = "aab"

    // kmp algo help us to find the occurence of p in s

    // but before coding KMP we need to understand the concept of LPS
    // LPS -> Longest proper Prefix which is also a proper Suffix

    public static int[] LPS(String s) {

        int n = s.length();
        int[] lps = new int[n];
        int len = 0;
        int idx = 1;

        // lps
        while (idx < n) {

            if (s.charAt(idx) == s.charAt(len)) {
                len++;
                lps[idx] = len;
                idx++;
            } else {

                if (len > 0) {
                    // important concept 
                    //         A       B
                    // EX -> aaeaa b aaeaa+e

                    // we know that String A(aaeaa) == B(aaeaa)  ->(1)

                    //  now b != e 

                    // but we know (1) => LP A(aa) == LS A(aa) == LP B(aa) == LS B(aa) -> (2)

                    // so now we need to compare LS B(aa)+e with A(aae) as we know (2) 

                    // and so on on until the string is matched or len becomes 0

                    len = lps[len - 1];
                } else {
                    lps[idx] = 0;
                    idx++;
                }
            }
        }

        return lps;

    }

    public int kmp(String s, String p) {

        String str = p + "#" + s;

        int[] lps = LPS(str);

        int reqLen = p.length();

        int count = 0;

        
        for (int l : lps) {
            // l == reqLen
            // that we have found a 
            // suffix of length reqLength
            // which is obviously same as prefix(p)

            // lps[]-> 0 1 0 1 2 '3' 1 2 '3' 1 2 '3'
            // str     a a b#a a  b  a a  b  a a  b
            if (reqLen == l)
                count++;
        }

        return count;

    }

    public static void main(String[] args) {

    }

}