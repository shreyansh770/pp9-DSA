public class q2 {
    int bT=0,at=0;

    public int stoneGame(int[] piles , int si ,int ei,int[][] dp){
        
        if(si>ei) return 0;
        
        if(si==ei) return dp[si][ei] = piles[si];
        
        if(dp[si][ei]!=-1) return dp[si][ei];
       
         int iTh = piles[si] + Math.min(  stoneGame(piles,si+2,ei,dp)  , stoneGame(piles,si+1,ei-1,dp));
         int jTH = piles[ei] + Math.min( stoneGame(piles,si,ei-2,dp) , stoneGame(piles,si+1,ei-1,dp) );
        
        return dp[si][ei] =  Math.max(iTh , jTH);
        
    }
    
    
    public boolean stoneGame(int[] piles ) {
        
        int n = piles.length;
        // Alice picks first pile
        int sum = 0;
        for(int ele : piles) sum+=ele;
        
        int[][] dp  = new int[n+1][n+1];
        
        for(int[] d : dp) Arrays.fill(d,-1);
        
        return stoneGame(piles ,0,n-1,dp) >= sum/2 ? true : false;

    }
}
