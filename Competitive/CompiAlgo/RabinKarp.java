import java.util.*;

public class RabinKarp {
    // generate hash for string b and then use sliding window over a to match the
    // hash

    // we take prime greater than the range in this case it is 26 since a-z is 26 because we have to produce unique hash

    
    public boolean rabinKarp(String s1, String s2) {


        // generating hash for s2
        long p = 31;
        long pow = 1;
        long dsv = 0;
        long mod = 1000000007;
        for (int i = 0; i < s2.length(); i++) {
            dsv = (dsv + (s2.charAt(i) - 'a' + 1) * pow) % mod;
            pow = (pow * p) % mod; // 29 , 29^2 , 29^3...
        }

        // Rabin karp

        long[] pha = new long[s1.length()]; // prefix hash array
        long[] pith = new long[s1.length()]; // power for substring starting from ith index

        pha[0] = s1.charAt(0) - 'a' + 1;
        pith[0] = 1;
        pow = p;

        // generating hash for s1
        for (int i = 1; i < s1.length(); i++) {
            pha[i] = (pha[i - 1] + (s1.charAt(i) - 'a' + 1) * pow) % mod;
            pith[i] = pow;
            pow = (pow * p) % mod;
        }

        // using sliding window to check which substring of s1 has hash similar to s2
        int si = 0;
        int ei = s2.length() - 1;

        // ArrayList<Long> res = new ArrayList<Long>(0); // requirement of ques

        while (ei < s1.length()) {

            long hith = pha[ei]; // hash value of string till ei

            if (si > 0) {
                hith = (hith - pha[si - 1] + mod) % mod;
            }

            if ((dsv * pith[si]) % mod == hith) {
                // res.add((long) si);
                return true;
            }
            si++;
            ei++;
        }

        return false;

    }

    public int repeatedStringMatch(String a, String b) {

        StringBuilder sb = new StringBuilder();

        // int l = a.length();
        int ans = 0;
        while (sb.length() < b.length()) {
            sb.append(a);
            ans++;
        }

        // rabin karp
        if (rabinKarp(sb.toString(), b)) {
            return ans;
        } else if (rabinKarp(sb.toString() + a, b)) {
            return ans + 1;
        } else {
            return -1;
        }

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
    }

}
