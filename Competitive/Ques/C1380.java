import java.util.*;
import java.io.*;
public class C1380 {
    public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);

            int t = scn.nextInt();

            while(t-->0){

                int n = scn.nextInt();
                int x = scn.nextInt();

                int[] a = new int[n];

                for(int i=0;i<n;i++){
                    a[i] = scn.nextInt();
                }

                Arrays.sort(a);

                int[] dp = new int[n+1];

                dp[n]=0;

                int max = 0;
                for(int i=n-1;i>=0;i--){

                    int nopr = (int)Math.ceil(x/a[i])+1;

                    if(a[i]>=x) nopr = 1;
                    else if(x%a[i]==0) nopr--;
                    dp[i] = (i+nopr<=n ? dp[i+nopr]+1 : 0);
                    max = Math.max(dp[i],max);
                }

                System.out.println(max);
            }
   }
}
