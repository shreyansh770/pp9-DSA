import java.util.*;

public class q13 {
    public int orangesRotting(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        LinkedList<Integer> q = new LinkedList<>();

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2)
                    q.addLast(i * m + j);
                else if (grid[i][j])
                    count++;
            }
        }

        int time = 0;
        int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        while (q.size() != 0) {

            int s = q.size();

            while (s-- > 0) {

                int rIdx = q.removeFirst();

                int sr = rIdx / m;
                int sc = rIdx % m;

                for (int[] d : dirs) {
                    int nr = sr + d[0];
                    int nc = sr + d[1];

                    if (nr >= 0 && nc >= 0 && nr < n && nc < m && grid[nr][nc] == 1) {
                        q.addLast(nr * m + nc);
                        count--;

                        if(count==0) return time+1;

                    }

                }

            }

            time ++;

        }

        return -1;
    }
}
