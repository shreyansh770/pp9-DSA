import java.util.*;

public class SpojNAJPF {

    // Using Rabin karp algorithm

    static Scanner scn = new Scanner(System.in);
    

    public static void solve() {
        String s1 = scn.next();
        String s2 = scn.next();

        // generating hash for s2 becuase it's hash would be compared
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

        ArrayList<Long> res = new ArrayList<Long>(0); // requirement of ques

        while (ei < s1.length()) {

            long hith = pha[ei]; // hash value of string till ei

            if (si > 0) {
                hith = (hith - pha[si - 1] + mod) % mod;
            }

            if ((dsv * pith[si]) % mod==hith) {
                res.add((long) si);
            }
            si++;
            ei++;
        }

        if (res.size() == 0) {
            System.out.println("Not Found");
        } else {
            System.out.println(res.size());
            for (long x : res)
                System.out.print(x + 1 + " "); // coz we have 1 based indexing
            System.out.println();
        }

        System.out.println();

    }

    public static void main(String[] args) {

        int t = scn.nextInt();
        while (t-- > 0) {
          solve();
        }

        scn.close();

    }
}
