import java.util.*;


public class recursion6 {
    


    //longest path

    public static int longestPath(int sr ,int sc,int[][] maze ,int[][] dir,int[][] visited)
    {
        
        if(sr == maze.length -1 && sc == maze[0].length-1)
        {
           return 0;
        }

        visited[sr][sc] = 1;

        int longestlen = -1;//if all paths are blocked

        for(int d = 0 ; d<dir.length ;d++)
        {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if(r>=0 && c>=0 && r<maze.length && c<maze[0].length && visited[r][c] == 0 && maze[r][c] == 0 )
            {
              int recAns = longestPath(r, c, maze, dir,visited);
              if(recAns!=-1 && recAns + 1 >longestlen)
              {
                   longestlen = recAns+1;
              }
            }
        }

        visited[sr][sc] = 0;


        return longestlen;
    }

    public static int shortestPath(int sr ,int sc,int[][] maze ,int[][] dir,int[][] visited)
    {
        
        if(sr == maze.length -1 && sc == maze[0].length-1)
        {
           return 0;//every block 1 unit
        }

        visited[sr][sc] = (int)1e9;

        int shortestlen = -1;//if all paths are blocked

        for(int d = 0 ; d<dir.length ;d++)
        {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if(r>=0 && c>=0 && r<maze.length && c<maze[0].length && visited[r][c] == 0 && maze[r][c] == 0 )
            {
              int recAns = shortestPath(r, c, maze, dir,visited);
              if(recAns!=(int)1e9 && recAns + 1 < shortestlen)
              {
                shortestlen = recAns+1;
              }
            }
        }

        visited[sr][sc] = 0;


        return shortestlen;
    }


    public static boolean knightTour(int sr , int sc ,int[][] board , int move , int[] dirX,int[] dirY)
    {

        board[sr][sc] = move;
        if(move == 63)
        {
           return true;
        }

        boolean res = false;
        for(int d = 0 ; d<8;d++)
        {
            int r = sr + dirX[d];
            int c = sc +  dirY[d];

            if(r>=0 && c>=0 && r< board.length && c<board[0].length && board[r][c] == -1)
            {
                res = knightTour(r,c, board, move+1, dirX, dirY);
                if(res)
                   return res;
            }
        }


        board[sr][sc] = -1;//with the given arrangement i will never backtrack

        return res;
    }


    public static void main(String[] args) {

                      //r    //l    //d    //u
    //    int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    //    int[][] maze = {{0,0,0},{0,0,1},{0,0,0}};
    //    int[][] visited = new int[3][3];

    //    System.out.println(longestPath(0,0,maze, dir,visited));

          int[][] board = new int[8][8] ;
          for(int i = 0 ; i <8;i++)
          {
              for(int j=0;j<8;j++)
              {
                  board[i][j] = -1;
              }
          }

          int[] dirX = { 2, 1, -1, -2, -2, -1, 1, 2 };
          int[] dirY = { 1, 2, 2, 1, -1, -2, -2, -1 };
          knightTour(0, 0, board, 0, dirX, dirY);

          for(int i = 0 ; i <8 ; i++)
          {
              for(int j = 0 ; j<8;j++)
              {
                  System.out.print(board[i][j]+ " ");
              }

              System.out.println();
          }
        
    }
}
