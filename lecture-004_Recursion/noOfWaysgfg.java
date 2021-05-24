import java.util.*;



public class noOfWaysgfg {
    public static int countWays(int sr , int sc , int[][] arr , int[][] dir)
    {
        if(sr == arr.length -1 && sc == arr[0].length-1)
        {
            return 0;
        }
        
        arr[sr][sc] = 1;
        int count= 0;
        
        for(int d = 0 ; d<dir.length;d++)
        {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];
            
            if(r>=0 && c>=0 && r<arr.length && c<arr[0].length && arr[r][c] == 0)
            {
                count+=countWays(r, c, arr ,  dir);
            }
        }
        
        arr[sr][sc] = 0;
        
        return count;
        
    }
    
    public int FindWays(int n, int m, int[][] blocked_cells)
    {
        // Code here
        int[][] myMatrix = new int[n][m];
        
        for(int[] cell : blocked_cells )
        {
            int i = cell[0];
            int j = cell[1];
            
            myMatrix[i][j] = 1;// we will block it 
        }
        
        if(myMatrix[n-1][m-1] == 1 || myMatrix[0][0] == 1)
        {
            return 0;
        }
        
        int[][] dir = {{0,1},{1,0}};
        

       int count =  countWays(0 , 0 , myMatrix , dir);
       
       return count;
    }

    public static void main(String[] args) 
    {
        int n = 3, m = 3, k = 2;
        int[][] blocked_cells = {{1,2},{3,2}};

        

        
            
    }
}


