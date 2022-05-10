public class q2 {
    public void lis_lr(int[] arr, int[] dp){
        
        int n = arr.length;
         
        dp[0] = 1;
        for(int i=1;i<n;i++){
            dp[i] = 1;
            if(arr[i] > arr[i-1]){
                dp[i] = dp[i-1]+1;
            }
        }
         
     }
     
     public void lis_rl(int[] arr , int[] dp){
         
         int n = arr.length;
         
         dp[n-1] = 1;
         for(int i=n-2;i>=0;i--){
             
             dp[i] = 1;
             if(arr[i]>arr[i+1]){
                 dp[i] = dp[i+1]+1;
             }
             
         }
     }
     
     public int longestMountain(int[] arr) {
         
         int n = arr.length;
         
         if(n<3) return 0;
         
         int[] LIS_LR = new int[n];
         int[] LIS_RL = new int[n];
         
         lis_lr(arr,LIS_LR);        
         lis_rl(arr,LIS_RL);
 
         int maxL = 0;
         
         if(LIS_LR[n-1]==n || LIS_RL[0]==n) return 0;
         for(int i=0;i<n;i++){
             
             if(LIS_LR[i]==1 || LIS_RL[i]==1) continue;
             
             maxL = Math.max(maxL, LIS_LR[i] + LIS_RL[i]-1);
         }
         
         return  maxL;
         
     }
}
