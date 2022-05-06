import java.util.*;

public class q13 {

    // this will give tle
    static int minInsAndDel(int[] a, int[] b, int idx1, int idx2, int[][] dp) {

        if (idx1 == 0 || idx2 == 0) {
            return dp[idx1][idx2] = (idx1 == 0 ? idx2 : idx1);
        }

        if(dp[idx1][idx2]!=-1) return dp[idx1][idx2];

        if (a[idx1-1] == b[idx2-1]) {
            return minInsAndDel(a, b, idx1 - 1, idx2 - 1, dp);
        } else {

            int add = minInsAndDel(a, b, idx1, idx2 - 1, dp) + 1;
            int replace = minInsAndDel(a, b, idx1 - 1, idx2 - 1, dp) + 2;
            int del = minInsAndDel(a, b, idx1 - 1, idx2, dp) + 1;

            return dp[idx1][idx2] = Math.min(Math.min(add, del), replace);
        }
    }

    public static int lis(int[] a){



    }

    static int minInsAndDel(int[] A, int[] B, int N, int M) {
        // code here

        // int[][] dp = new int[N + 1][M + 1];

        // for (int[] d : dp)
        //     Arrays.fill(d, -1);

        HashSet<Integer> set = new HashSet<>();

        for(int i:B){
            set.add(i);
        }

        List<Integer> a_new = new ArrayList<>();

        int del = 0;
        for(int i:A){
            if(set.contains(i)){
                 a_new.add(i);
            }else{
                del++;
            }
        }

        int lis_size = lis(A);

        return del + (a_new.size()-lis_size)+(B.length-lis_size);



        // return minInsAndDel(A, B, N, M, dp);
    }

}
