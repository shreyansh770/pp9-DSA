import java.util.*;

public class D271 {

    static class pair {
        long a;
        long b;

        pair(long x, long y) {
            this.a = x;
            this.b = y;
        }

        public boolean equals(Object o) {
            if (o instanceof pair) {
                pair p = (pair) o;
                return p.a == a && p.b == b;
            }
            return false;
        }

        public int hashCode() {
            return (Long.valueOf(a).hashCode()) * 31 + (Long.valueOf(b).hashCode());
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String inp = scn.next();

        int[] arr = new int[26];

        // scn.nextLine();

        String b = scn.next();

        // for (int i = 0; i < 26; i++) {
        // if(b.charAt(i)=='1'){
        // arr[i] = 1;
        // }
        // }

        int k = scn.nextInt();
        // TLE approach
        // getting substring and checking it int hashmap would be as task of 'n'
        // and over all loop is n^2 so O(n^3) will be the overall time complexity
        // HashSet<String> set = new HashSet<>();
        // for (int i = 0; i < inp.length(); i++) {

        //     int count = 0;
        //     for (int j = i; j < inp.length(); j++) {
        //         if (arr[inp.charAt(j) - 'a'] == 0)
        //             count++;
        //         if (count > k)
        //             break;
        //         String sub = inp.substring(i, j + 1);
        //         // System.out.println(sub+" ");
        //         if (!set.contains(sub)) {
        //             set.add(sub);
        //         }
        //     }
        // }

        // here we can use a diffrent method

        HashSet<pair> hset = new HashSet<>();

        long mod = 1000000007;

        // here we are generating hash with two prime nos coz there are some test cases which will cause hash collsions
        for (int i = 0; i < inp.length(); i++) {
            long hash1 = 0, hash2 = 0;
            long p1 = 31, p2 = 29; 
            long pow1 = 1, pow2 = 1;

            int badCharCount = 0;
            for (int j = i; j < inp.length(); j++) {
                badCharCount += b.charAt(inp.charAt(j) - 'a') == '0' ? 1 : 0;
                if (badCharCount > k)
                    break;

                hash1 = (hash1 + (inp.charAt(j) - 'a' + 1) * pow1) % mod;
                hash2 = (hash2 + (inp.charAt(j) - 'a' + 1) * pow2) % mod;

                pow1 = (pow1 * p1) % mod;
                pow2 = (pow2 * p2) % mod;

                hset.add(new pair(hash1, hash2));
            }
        }

        System.out.println(hset.size());
    }

}
