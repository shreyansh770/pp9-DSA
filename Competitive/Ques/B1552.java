import java.util.*;

public class B1552 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int t = scn.nextInt();

        while (t-- > 0) {
            int n = scn.nextInt();

            int[][] data = new int[n][5];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 5; j++) {
                    data[i][j] = scn.nextInt();
                }
            }

            // int[] sup = new int[n];
            // for (int c = 0; c < n; c++) {
            // for (int i = 0; i < n; i++) {
            // if (c == i)
            // continue;
            // int cnt = 0;
            // for (int j = 0; j < 5; j++) {
            // if (data[c][j] < data[i][j]) {
            // cnt++;
            // }
            // }

            // if (cnt >= 3) {
            // sup[c]++;
            // }
            // }
            // }

            int sup = 0;

            for (int i = 0; i < n; i++) {
                if (sup == i)
                    continue;
                int cnt = 0;
                for (int j = 0; j < 5; j++) {
                    if (data[sup][j] < data[i][j]) {
                        cnt++;
                    }
                }

                if (cnt < 3) {
                    sup = i;
                }
            }

            boolean flag = false;
            int cnt = 0;
            for (int i = 0; i < sup; i++) {
                for (int j = 0; j < 5; j++) {
                    if (data[sup][j] < data[i][j]) {
                        cnt++;
                    }
                }
            }

            if (!flag)
                System.out.println(-1);

        }
    }
}
