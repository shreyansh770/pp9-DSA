import java.util.*;

public class C1526 {

    static int[][] dp;

    // public static int memo(long[] arr, int idx, long ssf, int nop) {

    //     if (idx == arr.length)
    //         return 0;

    //     if (dp[idx][nop] != -(int)1e18) {
    //         // System.out.println("here");
    //         return dp[idx][nop];
    //     }
    //     // pick

    //     int res = 0;
    //     if (ssf + arr[idx] >= 0) {
    //         res = Math.max(res, memo(arr, idx + 1, ssf + arr[idx], nop + 1) + 1);
    //     }

    //     // not pick
    //     res = Math.max(res, memo(arr, idx + 1, ssf, nop));

    //     return res;

    // }

    

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        // int space = (int)2e9;

        // dp = new int[n + 1][n + 1];
        // for (int[] d : dp)
        //     Arrays.fill(d, -(int)1e18);
        // int res = memo(arr, 0, 0, 0);
        // System.out.println(res);

        PriorityQueue<Long> pq = new PriorityQueue<>();

        long ssf = 0;
        for(long a : arr){

            ssf+=a;
            pq.add(a);

            while(ssf<0){
                ssf-=pq.remove();
            }
        }

        System.out.println(pq.size());
    }
}
