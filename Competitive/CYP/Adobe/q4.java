public class q4 {

    static Boolean[][] dp;
    static boolean rec(int n,int arr[] , int tar , int ssf,int idx){

        if(tar==ssf || idx>=n) return tar==ssf ? true: false;

        if(dp[idx][ssf]!=null) return dp[idx][ssf];

        if(ssf + arr[idx]>tar) return rec(n,arr,tar,ssf,idx+1);

        boolean inc = rec(n,arr,tar,ssf+arr[idx],idx+1);
        boolean ninc = rec(n,arr,tar,ssf,idx+1);

        return dp[idx][ssf] = inc || ninc;

    }

    static int equalPartition(int N, int arr[])
    {
        // code here
        int sum = 0;
        for(int a : arr){
            sum+=a;
        }

        if(sum%2!=0){
            return 0;
        }

        dp = new Boolean[N+1][sum+1];
        return rec(N,arr,sum/2,0,0);
    }
}
