import java.util.*;

public class C {

    static List<Long> div;
    static Scanner scn = new Scanner(System.in);

    public static void findDiv(long sum) {

        // int idx = 0;
        for (long i = 1; i * i <= sum; i++) {
            if (sum % i == 0) {
                div.add(i);
                if (sum / i != i) {
                    div.add(sum/i);
                }
            }
        }
    }

    public static long solve(){
        long n = scn.nextInt();
        long[] a = new long[(int) n];
        long[] psum = new long[(int)n];
        for (int i = 0; i < n; i++) {

            a[i] = scn.nextInt();
            psum[i] = i>0 ? psum[i-1] + a[i] : a[i];
        }

        long res = n;
        for(int i=0;i<n;i++){

            long sum = psum[i];
            long sts = sum+sum;

            long sidx = i+1;
            long eidx = i;
            while(eidx!=n-1){

                int idx = Arrays.binarySearch(psum, sts);

                if(idx<0) break;
                sts+=psum[i];
                sidx = Math.max(sidx,idx-eidx);
                eidx = idx;
                // System.out.println(eidx);
                // if(eidx==n-1) break;
            }

            if(eidx==n-1){
                res = Math.min(res,sidx);
            }
        }

        return res;
    }

    public static void main(String[] args) {


        int t = scn.nextInt();

        while (t-- > 0) {

            long res =  solve();
        
            System.out.println(res);

            // div = new ArrayList<>();
            // findDiv(psum);

            // int nod = div.size();

            // // prime number
            // if (nod <= 2) {
            //     System.out.println(n);
            // } else {

            //     // how many parts can be break it up with all the div

            //     long minthick = n;
            //     for (long d : div) {
            //         long sstoa = psum/ d;

            //         long maxthick = 0;

            //         long ssf = 0;
            //         long tsf = 0;

            //         boolean sp = true;
            //         for (long i : a) {

            //             ssf = ssf + i;
                        
            //             tsf++;
            //             if (ssf > sstoa) {
            //                 sp = false;
            //                 break;
            //             } else if (ssf == sstoa) {
            //                 maxthick = Math.max(maxthick, tsf);
            //                 tsf = 0;
            //                 ssf = 0;
            //             }
            //         }

            //         if (sp) {

            //             minthick = Math.min(minthick, maxthick);
            //         }

            //     }

            //     System.out.println(minthick);
            // }

        }
    }
}
