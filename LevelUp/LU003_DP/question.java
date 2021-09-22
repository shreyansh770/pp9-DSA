public class question {

    int dx[] = { -2, -1, 1, 2, -2, -1, 1, 2 };
    int dy[] = { -1, -2, -2, -1, 1, 2, 2, 1 };
    

    // row , col , k
    public double knightProbability_(int n, int k, int row, int column,double[][][] dp) {
        
        if(k==0) return dp[row][column][k] = 1.0;


        if(dp[row][column][k]!=0.0) return dp[row][column][k];

        double prob  = 0;
        for(int d=0;d<8;d++){

            int r = row + dx[d];
            int c = column + dy[d];

            if(r>=0 && c>=0 && r<n && c<n){
                prob+=knightProbability_(n,k-1,r,c,dp);
            }
        }


        return dp[row][column][k]=  prob/8.0;

    }    
    

    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[n+1][n+1][k+1];
        return knightProbability_(n,k,row,column,dp);
    }



}
