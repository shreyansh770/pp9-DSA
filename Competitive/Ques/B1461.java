import java.util.*;

public class B1461 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int t = scn.nextInt();

        while (t-- > 0) {

            int n = scn.nextInt();

            int m = scn.nextInt();

            int[][] mat = new int[n][m];

            for (int i = 0; i < n; i++) {
                String s = scn.next();
                for (int j = 0; j < m; j++) {
                    char ch = s.charAt(j);

                    if (ch == '*') {
                        mat[i][j] = 1;
                    }
                }
            }

            // for a tip of tree at (i,j) we will find how many spare tree can it form

            for (int i = n - 2; i >= 0; i--) {
                for (int j = m - 2; j >= 1; j--) {

                    if(mat[i][j]==1)
                        mat[i][j] = 1 + Math.min(mat[i + 1][j - 1], Math.min(mat[i + 1][j], mat[i + 1][j + 1]));
                }
            }

            int res = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    res += mat[i][j];
                }
            }

            System.out.println(res);
        }

    }
}
