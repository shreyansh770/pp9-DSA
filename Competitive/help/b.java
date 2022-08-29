import java.util.*;

public class b {

    public static int solve(int[] w, int[] v, int W, int n) {
        if (W == 0 || n == 0)
            return 0;

        if (w[n - 1] > W)
            return solve(w, v, W, n - 1);

        else
            return Math.max(
                    solve(w, v, W-w[n-1], n - 1) + v[n - 1],
                    solve(w, v, W, n - 1));
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int[] weights = new int[3];
        for (int i = 0; i < 3; i++) {
            weights[i] = scn.nextInt();
        }

        int[] values = new int[3];
        for (int i = 0; i < 3; i++) {
            values[i] = scn.nextInt();
        }

        int W = scn.nextInt();

        int res = solve(weights, values, W, 3);

        System.out.println(res*1.0);
    }
}
