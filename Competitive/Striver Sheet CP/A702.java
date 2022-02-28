import java.util.*;
public class A702 {
    
    public static void main(String[] args) {
        
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }

        int[] dp = new int[n];

        Arrays.fill(dp, 1);
        int maxlen = 1;
        for(int i=1;i<n;i++){

            if(arr[i-1]<arr[i]){
                dp[i] = dp[i-1] + 1;
                maxlen = Math.max(maxlen,dp[i]);
            }
        }

        System.out.println(maxlen);
    }
}
