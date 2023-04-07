import java.util.*;

public class Counting_Tiles {

    // we are asking the ith column to tell how many ways tiles can be arranged in
    // it and what mask would each arrangement produce for the (i+1)th column

    static int[][] dp;
    static int n;
    static int m;

    public static void getMaskForNextCol(int col, int curr_mask, int row, int next_mask, List<Integer> next_masks) {

        if (row == n + 1) {

            next_masks.add(next_mask);
            return;
        }

        if ((curr_mask & (1 << row)) != 0) {

            getMaskForNextCol(col, curr_mask, row + 1, next_mask, next_masks); // ith row of the col was occupied by a
                                                                               // tile placed at (col-1)th column
        }

        if (row != n) {

            if ((curr_mask & (1 << row)) == 0 && (curr_mask & (1 << (row + 1))) == 0) {

                getMaskForNextCol(col, curr_mask, row + 2, next_mask, next_masks); // no effect on next column's row coz
                                                                                   // we are using 2*1 tile
            }

        }

        if ((curr_mask & (1 << row)) == 0) {

            getMaskForNextCol(col, curr_mask, row + 1, next_mask ^ (1 << row), next_masks); // using 1*2 tile
        }

    }

    public static int solve(int col, int mask) {
        
        if(col==m+1){
            if(mask==0) return 1;
            return 0;
        }

        if (dp[col][mask] != -1)
            return dp[col][mask];

        List<Integer> next_masks = new ArrayList<>();
        getMaskForNextCol(col, mask, 1, 0, next_masks);

        int ans = 0;
        for(int next_mask : next_masks){
            ans = (ans + solve(col+1, next_mask));
        }

        return dp[col][mask] = ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        n = scn.nextInt();
        m = scn.nextInt();

        dp = new int[1001][1 << 11];
        for(int[] d : dp) Arrays.fill(d,-1);
        int res = solve(1,0);
        System.out.println(res);
    }
}
