import java.util.*;

public class E16 {

    static double[] dp;

    static double[][] a;

    // ftd -> fish that will die today
    // prev_bitmask -> bitmask when fth was alive
    public static double prob(int prev_bitmask, int ftd, int n) {

        int alive = Integer.bitCount(prev_bitmask);

        long no_way_of_selecting_2_fish_out_of_alive = (alive * (alive - 1)) / 2;

        double probility = 0;
        for (int f = 0; f < n; f++) {

            if((prev_bitmask&(1<<f))>0)
                probility += a[f+1][ftd+1];
        }

        return probility / (no_way_of_selecting_2_fish_out_of_alive*1.0);
    }

    // 0 -> dead
    // 1 -> alive
    public static double solve(int bit_state, int n) {

        int set_bits = Integer.bitCount(bit_state);

        if (set_bits == n)
            return 1; // all alive

        if(dp[bit_state]>-0.9) return dp[bit_state];

        double ans = 0;
        for (int f = 0; f < n; f++) {

            if ((bit_state & (1 << f)) == 0) { // if the fth fish is dead

                int prev_bitmask = bit_state ^ (1 << f);
                double prev_day = solve(prev_bitmask, n); // probility of fth fish alive on prev day

                ans += prob(prev_bitmask, f, n) * prev_day;
            }
        }

        return dp[bit_state] =  ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        a = new double[20][20];

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {

                a[i][j] = scn.nextDouble();

            }
        }

        // System.out.println(Integer.bitCount(31));
        dp = new double[(1<<19)];
        Arrays.fill(dp,-1);
        for (int i = 0; i < n; i++) {
            double res = solve((1 << i), n);
            System.out.print(res + " ");
        }

    }
}
