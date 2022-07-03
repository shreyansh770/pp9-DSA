class Solution {
    
  
    int[] par;
    int[] size;
    
    public int findPar(int u){
        if(par[u] == u) return u;
        
        return par[u] = findPar(par[u]);
    }
    
    public void merge(int p1 ,int p2){
        if(size[p1] >= size[p2]){
            par[p2] = p1;
            size[p1]+=size[p2];
        }else{
            par[p1] = p2;
            size[p1]+=size[p2];
        }
    }
    
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int m = isConnected[0].length;
        par = new int[n];
        size = new int[n];
        
        for(int i=0;i<n;i++){
            par[i] = i;
            size[i] = 1;
        }
        
        
        
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i!=j && isConnected[i][j] == 1){
                    int p1 = findPar(i);
                    int p2 = findPar(j);
                    
                    if(p1!=p2){
                        merge(p1,p2);
                        // n--;
                    }
                }
            }
        }
        
        
        int noOfPro = 0;
        
        for(int i=0;i<n;i++){
            int p = findPar(i);
            if(i == p){
                noOfPro++;
            }
        }
        
        return noOfPro;
        
    }
}