import java.util.*;
public class A189 {


    static int[] dp = new int[40002];
    public static int  dfs(int n ,int a,int b,int c){

        if(n<0) return -(int)1e9;

        if(n==0) return 0;

        if(dp[n]!=-1) return dp[n];

        int f=0,s=0,t=0;

        f= f + dfs(n-a,a,b,c);
        s= s + dfs(n-b,a,b,c);
        t= t + dfs(n-c,a,b,c);

        return dp[n] = Math.max(f,Math.max(s,t))+1;

    }

    public static void main(String[] args) {
        
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int a = scn.nextInt();
        int b = scn.nextInt();
        int c = scn.nextInt();

        // int max = Math.max(a,Math.max(b,c));
        Arrays.fill(dp,-1);
        int ans =dfs(n, a, b, c);
        System.out.println(ans);
    }
    
}
