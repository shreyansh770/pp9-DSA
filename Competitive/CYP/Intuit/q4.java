class Solution
{
    
    // static ;
    
    public boolean isWordExist(char[][] board, String word)
    {
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        for( int i=0; i<board.length; i++){
            
            for( int j=0; j<board[0].length; j++){
                
                if( board[i][j] != word.charAt(0) ) continue;
                    
                visited[i][j] = true;
                
                if( searchWord(board,i,j,word.substring(1),visited) ) return true;
                
                visited[i][j] = false;
        
            }
        }
        
        return false;
        
    }
    
    static int[][] directions = {
        {0,1},
        {1,0},
        {-1,0},
        {0,-1},
    };
    public static boolean searchWord(char[][] board,int row,int col,String word,boolean[][] visited){
        // System.out.println(word);
        if( word.length() == 0 ) return true;
        
        boolean out = false;
        
        for( int i = 0; i<directions.length; i++){
            if(charIsHere(
                board,
                row+directions[i][0],
                col+directions[i][1],
                word.charAt(0),
                visited)){
                    
                visited[row+directions[i][0]][col+directions[i][1]] = true;
                
                out = out || searchWord(board,
                row+directions[i][0],col+directions[i][1],
                word.substring(1),visited);
                
                visited[row+directions[i][0]][col+directions[i][1]] = false;
                
            }
        }
        
        return out;
        
    }
    
    public static boolean charIsHere(char[][] board,int row,int col,char curChar,boolean[][] visited){
        if( row >= board.length || row < 0 || col >= board[0].length || col < 0 ) return false;
        // System.out.println(row+" "+col+" "+" "+curChar);
        
        if( visited[row][col] ) return false;
        
        if( board[row][col] == curChar ) return true;
        
        return false;

