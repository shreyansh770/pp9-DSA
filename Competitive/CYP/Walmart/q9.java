public class q9 {
        
    int[][] dp;
    public int guess(int n , int rs , int re ){
        
                
        if(re<=rs) return 0;
        
        if(dp[rs][re]!=(int)1e9) return dp[rs][re];
        
        for(int i=rs;i<=re;i++){
            
           // if num<val (rs,val-1)
           int less = guess(n,rs,i-1) + i; // for wrong guess we add $i
        
           // else num>val (val+1,er)
           int more = guess(n,i+1,re) + i;
            
           int maximumcost = Math.max(less,more);
            
            dp[rs][re] = Math.min(dp[rs][re],maximumcost);
            
        }
        
        return dp[rs][re];
        
    }
    
    
    public int getMoneyAmount(int n) {
        
        dp = new int[n+1][n+1];
        
        for(int[] d : dp) Arrays.fill(d,(int)1e9);
        return guess(n,1,n);
    }
}
