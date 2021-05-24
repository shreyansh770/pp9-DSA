import java.util.*;

public class recursion5 {

    // Bactraking

    public static int FloodFill(int sr, int sc, int[][] board, String ans, int[][] dir, String[] dirS) {
        if (sr == board.length - 1 && sc == board[0].length - 1) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;

        board[sr][sc] = 1;

        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if (r >= 0 && c >= 0 && r < board.length && c < board[0].length && board[r][c] == 0) {
                count += FloodFill(r, c, board, ans + dirS[d], dir, dirS);
            }
        }

        board[sr][sc] = 0;

        return count;

    }


    
    public static boolean FloodFill1ans(int sr, int sc, int[][] board, String ans, int[][] dir, String[] dirS) {
        if (sr == board.length - 1 && sc == board[0].length - 1) {
            System.out.println(ans);
            return true;
        }

        

        board[sr][sc] = 1;

        boolean res = false;

        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if (r >= 0 && c >= 0 && r < board.length && c < board[0].length && board[r][c] == 0) {
                //we just need one ans
               res = res ||  FloodFill1ans(r, c, board, ans + dirS[d], dir, dirS);
            }
        }

        board[sr][sc] = 0;

        return res;

    }



    // 3 direction right , bottom , dig
    public static int Maze3(int sr, int sc, int er, int ec, String ans, int[][] dir, String[] dirS) {

        if (sr == er && sc == ec) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;

        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];// dest for single steps
            int c = sc + dir[d][1];// dest for single steps

            if (r >= 0 && c >= 0 && r <= er && c <= ec) {
                count += Maze3(r, c, er, ec, ans + dirS[d], dir, dirS);
            }
        }

        return count;
    }



    public static void Maze8(int sr, int sc, int[][] board, String ans, int[][] dir, String[] dirS) {

        if (sr == board.length - 1 && sc == board[0].length - 1) {
            System.out.println(ans);
            return;
        }

        board[sr][sc] = 1;

        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if (r >= 0 && c >= 0 && r < board.length && c < board[0].length && board[r][c] == 0) {
                FloodFill(r, c, board, ans + dirS[d], dir, dirS);
            }
        }

        board[sr][sc] = 0;

    }


    // IMPORTANT CONCEPT *****************
    public static void JumpPaths(int sr, int sc, int[][] board, String ans, int[][] dir, String[] dirS) {

        int n = board.length - 1;
        int m = board[0].length - 1;

        if (sr == n && sc == m) {
            System.out.println(ans);
            return;
        }

        board[sr][sc] = 1;

        for (int d = 0; d < dir.length; d++) {
            // ek direction me sare possible radius
            for (int rad = 1; rad <= Math.max(n, m); rad++) {
                int r = sr + rad * dir[d][0];
                int c = sc + rad * dir[d][1];

                if (r >= 0 && c >= 0 && r < board.length && c < board[0].length)// false -> boundary se bhar->rad
                                                                                // expansion stop
                {
                    if (board[r][c] == 0)// false ->path is block
                    {
                        JumpPaths(r, c, board, ans + rad + dirS[d], dir, dirS);
                    }

                } else {
                    break;
                }
            }

        }

        board[sr][sc] = 0;
    }



    public static void ratInMaze1(int sr, int sc, int[][] board, int[][] dir, String[] dirS, String ans) {
        if (sr == board.length - 1 && sc == board[0].length - 1) {
            System.out.println(ans);
            return;
        }

        board[sr][sc] = 0;//block

        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if (r >= 0 && c >= 0 && r < board.length && c < board[0].length && board[r][c] == 1) {
                ratInMaze1(r, c, board, dir, dirS, ans + dirS[d]);
            }
        }

        board[sr][sc] = 1;//unblock
    }



    public static void ratInMazeMul(int sr, int sc, int[][] board, String ans, int[][] dir, String[] dirS,
            int[][] maze) {
        int n = board.length - 1;
        int m = board[0].length - 1;
        if (sr == n && sc == m) {
            System.out.println(ans);
            return;
        }

        board[sr][sc] = 1;

        for (int d = 0; d < dir.length; d++) {
            for (int rad = 1; rad <= Math.max(n, m); rad++) {
                int r = sr + rad * dir[d][0];
                int c = sc + rad * dir[d][1];

                if (r >= 0 && c >= 0 && r < board.length && c < board[0].length) {
                    if (board[r][c] == 0 && maze[r][c] == 0) {
                        ratInMazeMul(r, c, board, ans + rad + dirS[d], dir, dirS, maze);
                    }

                } else {
                    break;
                }
            }
        }

        board[sr][sc] = 0;
    }



    public static void main(String[] args) {

        // int[][] dir = {{0,1},{1,1},{1,0}};
        // String[] dirS = {"H" , "D" , "V"};

        // int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
        // String[] dirS = {"t","r","d","l"};

        // int[][] dir = {{-1,0},{0,1},{1,0},{0,-1},{-1,1},{1,1},{1,-1},{-1,-1}};
        // String[] dirS = {"n","e","s","w","NE","SE","SW","NW"};

        // KNIGHT-TOUR problem

        // int[][] dir = {{2,1},{1,2},{-1,2},{-2,1},{-2,-1},{-1,-2},{1,-2},{2,-1}};

        // int[][] chess = new int[8][8];

        // for(int i = 0 ; i < 8 ; i++)
        // {
        // for(int j = 0 ;j<8;j++)
        // {
        // chess[i][j] = -1;
        // }
        // }

        // // chess[0][0] = 0;
        // int tn = 64;
        // System.out.println("Running fxn");
        // for(int i=0;i<8;i++){
        // for(int j=0;j<8;j++){
        // knightTour(i, j ,chess.length-1,chess[0].length - 1,dir,chess,tn);
        // }
        // }

        // Rat_In_Maze

        int[][] dir = { { 0, 1 }, { 1, 0 } };

        String[] dirS = { "R", "D" };

        int[][] board = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 1, 1, 0, 0 }, { 0, 1, 1, 1 } };

        ratInMaze1(0, 0, board, dir, dirS, "");

        // Rat_In_Maze_Jumps

        // int[][] dir = {{0,1},{1,0}};

        // String[] dirS = {"R","D"};

        // int[][] maze = {{0, 0, 0, 0}, {0, -1, 0, 0}, {-1, 0, 0, 0}, {0, 0, 0, 0}};

        // int[][] board = new int[4][4];

        // ratInMazeMul(0, 0, board, "", dir, dirS,maze);

    }
}
