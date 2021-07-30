public class NqueenSet {

    public static boolean isSafeToPlaceQueen(boolean[][] boxes, int r, int c) {
        // int[][] dir = { { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 } };
        int[][] dir = { { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 } };

        int n = boxes.length, m = boxes[0].length;
        for (int d = 0; d < dir.length; d++) {
            for (int rad = 1; rad < n; rad++) {
                int x = r + rad * dir[d][0];
                int y = c + rad * dir[d][1];
                if (x >= 0 && y >= 0 && x < n && y < m) {
                    if (boxes[x][y])
                        return false;
                } else
                    break;
            }
        }

        return true;
    }

    public static int nqueen_Combination01(boolean[][] boxes, int tnq, int idx, String ans) {
        if (tnq == 0) {
            System.out.println(ans);
            return 1;
        }

        int n = boxes.length, m = boxes[0].length, count = 0;
        for (int i = idx; i < n * m; i++) {
            int r = i / m;
            int c = i % m;
            if (isSafeToPlaceQueen(boxes, r, c)) {
                boxes[r][c] = true;
                count += nqueen_Combination01(boxes, tnq - 1, i + 1, ans + "(" + r + ", " + c + ") ");
                boxes[r][c] = false;
            }
        }

        return count;
    }

    public static int nqueen_Permutation01(boolean[][] boxes, int tnq, int idx, String ans) {
        if (tnq == 0) {
            System.out.println(ans);
            return 1;
        }

        int n = boxes.length, m = boxes[0].length, count = 0;
        for (int i = idx; i < n * m; i++) {
            int r = i / m;
            int c = i % m;
            if (!boxes[r][c] && isSafeToPlaceQueen(boxes, r, c)) {
                boxes[r][c] = true;
                count += nqueen_Permutation01(boxes, tnq - 1, 0, ans + "(" + r + ", " + c + ") ");
                boxes[r][c] = false;
            }
        }

        return count;
    }

    /* branch and bound method */
    static boolean[] row, col, dig, adig;

    public static int nQueen_03_Comb(int n, int m, int bno, int tnq, String asf) {

        if (tnq == 0) {
            System.out.println(asf);
            return 1;
        }

        int count = 0;

        for (int i = bno; i < n * m; i++) {
            int r = i / m;
            int c = i % m;
            if (!row[r] && !col[c] && !dig[r + c] && !adig[r - c + m - 1]) {
                row[r] = col[c] = dig[r + c] = adig[r - c + m - 1] = true;
                count += nQueen_03_Comb(n, m, i + 1, tnq - 1, asf + "(" + r + ", " + c + ") ");
                row[r] = col[c] = dig[r + c] = adig[r - c + m - 1] = false;
            }

        }

        return count;

    }

    public static int nQueen_03Perm(int n, int m, int tnq, String asf) {
        if (tnq == 0) {
            System.out.println(asf);
            return 1;
        }

        int count = 0;

        for (int i = 0; i < n * m; i++) {
            int r = i / m;
            int c = i % m;
            if (!row[r] && !col[c] && !dig[r + c] && !adig[r - c + m - 1]) {
                row[r] = col[c] = dig[r + c] = adig[r - c + m - 1] = true;
                count += nQueen_03Perm(n, m, tnq - 1, asf + "(" + r + ", " + c + ") ");
                row[r] = col[c] = dig[r + c] = adig[r - c + m - 1] = false;
            }

        }

        return count;

    }

    /* Method -3 */

    /*
     * here we assign a row to queen say q1-f1 ,q2-f2 and then we check queen
     * placement only for col , dig , adig
     * 
     */

    public static int nQueen_04_Comb(int n, int m, int floor, int tnq, String asf) {

        if (tnq == 0) {
            System.out.println(asf);
            return 1;
        }

        int count = 0;
        for (int room = 0; room < m; room++) {
            int r = floor, c = room;
            if (!col[c] && !dig[r + c] && !adig[r - c + m - 1]) {
                col[c] = dig[r + c] = adig[r - c + m - 1] = true;
                count += nQueen_04_Comb(n, m, floor + 1, tnq - 1, asf + "(" + r + ", " + c + ") ");
                col[c] = dig[r + c] = adig[r - c + m - 1] = false;
            }

        }

        return count;

    }

    // subsequence method
    public static int nQueen_04_Perm(int n, int m, int floor, int tnq, String asf) {

        if (tnq == 0 || floor > n) {
            if (tnq == 0) {
                System.out.println(asf);
                return 1;
            }

            return 0;
        }

        int count = 0;
        for (int room = 0; room < m; room++) {
            int r = floor, c = room;
            if (!row[r] && !col[c] && !dig[r + c] && !adig[r - c + m - 1]) {
                row[r] = col[c] = dig[r + c] = adig[r - c + m - 1] = true;
                count += nQueen_04_Perm(n, m, 0, tnq - 1, asf + "(" + r + ", " + c + ") ");
                row[r] = col[c] = dig[r + c] = adig[r - c + m - 1] = false;
            }

        }

        count += nQueen_04_Perm(n, m, floor + 1, tnq, asf); // agr kisi ko ko floor nhi milegi to agle floor pe ja

        return count;

    }



    
    public static void main(String[] args) {

        boolean[][] boxes = new boolean[4][4];

        int n = boxes.length;
        int m = boxes[0].length;

        row = new boolean[n];
        col = new boolean[m];
        dig = new boolean[n + m - 1];
        adig = new boolean[n + m - 1];
        // System.out.println(nQueen_03(n, m, 0, 4, ""));
    }
}
