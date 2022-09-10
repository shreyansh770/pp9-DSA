import java.util.*;

public class C975 {

    static long tas = 0; // total arrows strength
    static long[] strength;
    static long[] psum;
    static int n;

    public static int search(int si, long cas) {

        tas += cas;
        if (tas < psum[si]) {
            return si-1;
        }

        if (tas >= psum[n - 1]) {
            tas = 0;
            return n;
        }

        int s = si;
        int e = strength.length - 1;
        int res = 0;

        while (s <= e) {
            int mid = (s + e) / 2;

            if (psum[mid] > tas) {
                e = mid - 1;
            } else {
                s = mid + 1;
                res = mid;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        n = scn.nextInt();
        int q = scn.nextInt();

        strength = new long[n];

        for (int i = 0; i < n; i++) {
            strength[i] = scn.nextLong();
        }

        psum = new long[n];
        psum[0] = strength[0];

        for (int i = 1; i < n; i++) {
            psum[i] = psum[i - 1] + strength[i];
        }

        int idx = -1;
        for (int i = 0; i < q; i++) {

            long arrow = scn.nextLong();

            idx = search(idx+1, arrow);

            if(idx==n){
                System.out.println(n);
                idx = -1;
            }else{
                System.out.println(n-idx-1);
            }
            
        }
    }
}
