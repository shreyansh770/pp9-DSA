import java.util.*;

public class recursion_03 {

    // nCr method --------------------------------------------

    public static int coinChangeInfPermutation(int[] coins, int tar, String asf) {

        if (tar == 0) {
            System.out.println(asf);
            return 1;
        }

        int count = 0;
        for (int i = 0; i < coins.length; i++) {

            if (tar - coins[i] >= 0) {
                count += coinChangeInfPermutation(coins, tar - coins[i], asf + coins[i]);
            }
        }

        return count;
    }

    public static int coinChangeInfCombination(int[] coins, int tar, String asf, int idx) {
        if (tar == 0) {
            System.out.println(asf);
            return 1;
        }

        int count = 0;
        for (int i = idx; i < coins.length; i++) {

            if (tar - coins[i] >= 0) {
                count += coinChangeInfCombination(coins, tar - coins[i], asf + coins[i], i);
            }
        }

        return count;
    }

    // ek coin ko ek bar he
    public static int singleCombination(int[] coins, int tar, String asf, int idx) {
        if (tar == 0) {
            System.out.println(asf);
            return 1;
        }

        int count = 0;
        for (int i = idx; i < coins.length; i++) {

            if (tar - coins[i] >= 0) {
                count += singleCombination(coins, tar - coins[i], asf + coins[i], i + 1);
            }
        }

        return count;
    }

    // ek coin ko ek bar he
    public static int singlePermutation(int[] coins, int tar, String asf, boolean[] vis) {
        if (tar == 0) {
            System.out.println(asf);
            return 1;
        }

        int count = 0;
        for (int i = 0; i < coins.length; i++) {

            if (vis[i])
                continue;
            if (tar - coins[i] >= 0) {
                vis[i] = true;
                count += singlePermutation(coins, tar - coins[i], asf + coins[i], vis);
                vis[i] = false;
            }
        }

        return count;
    }

    // https://leetcode.com/problems/combination-sum/ -39

    public void helper(int[] candidates, int target, List<Integer> res, int idx, List<List<Integer>> ans) {
        if (target == 0) {

            List<Integer> base = new ArrayList<>(res);
            ans.add(base);
            return;
        }

        for (int i = idx; i < candidates.length; i++) {

            if (target - candidates[i] >= 0) {
                res.add(candidates[i]);
                helper(candidates, target - candidates[i], res, i, ans);
                res.remove(res.size() - 1);
            }
        }

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        helper(candidates, target, res, 0, ans);
        return ans;

    }

    // 2^n method(subsequence
    // method)-------------------------------------------------

    public static int singleCombination_subq(int[] coins, int target, int idx, String asf) {

        if (target == 0 || idx >= coins.length) {
            if (target == 0) {
                System.out.println(asf);
                return 1;
            }

            return 0;

        }

        int count = 0;
        if (target - coins[idx] >= 0) {
            count += singleCombination_subq(coins, target - coins[idx], idx + 1, asf + coins[idx]);
        }
        count += singleCombination_subq(coins, target, idx + 1, asf);

        return count;

    }

    public static int infiCombination_subq(int[] coins, int target, int idx, String asf) {
        if (target == 0 || idx >= coins.length) {
            if (target == 0) {
                System.out.println(asf);
                return 1;
            }

            return 0;

        }

        int count = 0;
        if (target - coins[idx] >= 0) {
            count += infiCombination_subq(coins, target - coins[idx], idx, asf + coins[idx]);// ek bar ek coint ko use
                                                                                             // kiya usko uske bad bhi
                                                                                             // kar skte hai
        }
        count += infiCombination_subq(coins, target, idx + 1, asf);

        return count;
    }

    public static int infiPermutation_subq(int[] coins, int target, int idx, String asf) {
        if (target == 0 || idx >= coins.length) {
            if (target == 0) {
                System.out.println(asf);
                return 1;
            }

            return 0;
        }

        int count = 0;
        if (target - coins[idx] >= 0) {
            count += infiPermutation_subq(coins, target - coins[idx], 0, asf + coins[idx]);
        }
        count += infiPermutation_subq(coins, target, idx + 1, asf);

        return count;
    }

    public static int singlePermutation_subq(int[] coins, int target, int idx, String asf, boolean[] vis) {

        if (target == 0 || idx >= coins.length) {
            if (target == 0) {
                System.out.println(asf);
                return 1;
            }

            return 0;
        }

        int count = 0;

        if (target - coins[idx] >= 0 && !vis[idx]) {
            vis[idx] = true;
            count += singlePermutation_subq(coins, target - coins[idx], 0, asf + coins[idx], vis);
            vis[idx] = false;
        }

        count += singlePermutation_subq(coins, target, idx + 1, asf, vis);

        return count;
    }

    // 1D_Queen_Set ---------------------------------------------------------

    // m queens in n boxes

    public static int queenComb1D(int tnb, int bno, int tnq, int qpsf, String asf) {

        if (qpsf > tnq) {
            System.out.println(asf + " ");
            return 1;
        }
        int count = 0;
        for (int b = bno; b <= tnb; b++) {

            count += queenComb1D(tnb, b + 1, tnq, qpsf + 1, asf + " b" + b + " q" + qpsf);
        }

        return count;
    }

    public static int queenPerm1D(int tnb, int tnq, int qpsf, String asf, boolean[] vis) {

        // because we are starting qpsf from 1
        if (qpsf > tnq) {
            System.out.println(asf + " ");
            return 1;
        }
        int count = 0;
        for (int b = 1; b <= tnb; b++) {
            if (!vis[b]) {
                vis[b] = true;
                count += queenPerm1D(tnb, tnq, qpsf + 1, asf + "b" + b + "q" + qpsf + " ", vis);
                vis[b] = false;
            }

        }

        return count;
    }

    public static int queenComb1D_suq(int tnb, int bno, int tnq, int qpsf, String asf) {

        if (qpsf > tnq || bno > tnb) {
            if (qpsf > tnq) {
                System.out.println(asf + " ");
                return 1;
            }

            return 0;
        }
        int count = 0;

        count += queenComb1D_suq(tnb, bno + 1, tnq, qpsf + 1, asf + " b" + bno + " q" + qpsf);
        count += queenComb1D_suq(tnb, bno + 1, tnq, qpsf, asf);

        return count;
    }

    public static int queenPerm1D_suq(int tnb, int bno, int tnq, int qpsf, String asf, boolean[] vis) {

        if (qpsf > tnq || bno > tnb) {
            if (qpsf > tnq) {
                System.out.println(asf + " ");
                return 1;
            }

            return 0;
        }
        int count = 0;
        if (!vis[bno]) {
            vis[bno] = true;
            count += queenPerm1D_suq(tnb, 1, tnq, qpsf + 1, asf + " b" + bno + " q" + qpsf, vis);
            vis[bno] = false;
        }

        count += queenPerm1D_suq(tnb, bno + 1, tnq, qpsf, asf, vis);

        return count;
    }

    // 2D_Queen_Set ---------------------------------------------------------

    /*
     * here we have mapped 1d array with 2d array so that in case we have 4*4 array
     * and 4 queens we say that we have to place 4 queens in 16 boxes
     */
    public static int queenComb2D(boolean[][] box, int bno, int tnq, String asf) {
        if (tnq == 0) {
            System.out.println(asf);
            return 1;
        }

        int count = 0;
        int n = box.length, m = box[0].length;
        // 1D ka 2D me mapping
        for (int b = bno; b < n * m; b++) {
            int r = b / m;
            int c = b % m;
            count += queenComb2D(box, b + 1, tnq - 1, asf + "(" + r + "," + c + ") ");
        }
        return count;
    }

    public static int queenPerm2D(boolean[][] box, int tnq, String asf) {
        if (tnq == 0) {
            System.out.println(asf);
            return 1;
        }

        int count = 0;
        int n = box.length, m = box[0].length;
        for (int b = 0; b < n * m; b++) {
            int r = b / m;
            int c = b % m;
            if (!box[r][c]) {
                box[r][c] = true;
                count += queenPerm2D(box, tnq - 1, asf + "(" + r + c + ")");
                box[r][c] = false;
            }
        }

        return count;
    }

    public static int queenComb2D_suq(boolean[][] box,int bno,int tnq,String asf){

       int n = box.length , m = box[0].length;
       if(tnq == 0 || bno == n*m){
           if(tnq == 0){
            System.out.println(asf);
            return 1;
           }

           return 0;

       }

       int count = 0;
       
       int r = bno/m;
       int c = bno%m;
       count+=queenComb2D_suq(box,bno+1,tnq-1,asf+"("+r+c+")");
       count+=queenComb2D_suq(box,bno+1,tnq,asf);

       return count;
    }

    public static int queenPerm2D_suq(boolean[][] box, int bno, int tnq, String asf) {

        int n = box.length, m = box[0].length;
        if (tnq == 0 || bno == n * m) {
            if (tnq == 0) {
                System.out.println(asf);
                return 1;
            }

            return 0;

        }

        int count = 0;
        int r = bno / m;
        int c = bno % m;
        if(!box[r][c]){
            box[r][c] = true;
            count += queenPerm2D_suq(box, 0, tnq-1, asf + "(" + r + c + ")");
            box[r][c] = false;
        }
        
        count += queenPerm2D_suq(box, bno + 1, tnq, asf);

        return count;

    }

    public static void main(String[] args) {

        int[] arr = { 2, 3, 5, 7 };
        int tnb = 4, tnq = 4;
        // boolean[] vis = new boolean[tnb+1];

        boolean[][] box = new boolean[4][4];

        System.out.println(queenPerm2D(box,  tnq, ""));

    }
}
