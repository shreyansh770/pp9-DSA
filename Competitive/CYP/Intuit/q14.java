class q14{
    // multi source bfs
    
    // we have to find the land cell which is fathest away from a water cell 
    // multi sources will be the lands
    // why from land to water ?
    // Time complexity is too much, as I would be visiting same cell multiple times, for each water cell, I have a separate  method. This method takes          input as (i,j) of water cell will do a BFS to arrive at a nearest Land cell, use a N*N visited matrix and return the distance. The 'visited' matrix          is reset to '0' every time this method is called.
    // Memory complexity is also too much as we are requiring a full N*N matrix.
    
    // for water  we need to find closet land
    
    // for land   we need to find farthest water
    
    int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    public int maxDistance(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        
        LinkedList<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    q.addLast(new int[]{i,j});
                    vis[i][j] = true;
                }
            }
        }
        
        
        int level=-1; // coz manhatten distance 
        while(q.size()!=0){
            int s = q.size();
            
            while(s-->0){
                int[] top = q.removeFirst();
                
                int x = top[0];
                int y = top[1];
                
                for(int[] d : dir){
                    
                    int nx = x + d[0];
                    int ny = y + d[1];
                    
                    if(nx>=0 && ny>=0 && nx<n && ny<m && grid[nx][ny]==0 && !vis[nx][ny]){
                        vis[nx][ny] = true;
                        q.addLast(new int[]{nx,ny});
                    }
                }
            }
            
            level++;
        }
        
        // level -> 0 only land
        // level -> -1 only water
        
        return level<=0 ? -1 : level;
        
    }
}