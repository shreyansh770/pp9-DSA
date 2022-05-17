import java.util.*;

public class q1 {



    Integer[][] dp;
    public int rec(int[] arr , int idx , int s1 , int s2){

        if(idx==arr.length && (s1==0||s2==0)){
            return s1 == 0 ? s2 : s1;
        }

        if(idx==arr.length){
            return Math.abs(s1-s2);
        }

        if(dp[idx][s1]!=null) return dp[idx][s1];


        // two choices

        int set1 = rec(arr , idx+1,s1+arr[idx],s2);
        int set2 = rec(arr,idx+1,s1,s2+arr[idx]);

        return dp[idx][s1] = Math.min(set1,set2);

    }

    public int minDifference(int arr[], int n) {
        // Your code goes here

        int s = 0;
        for(int i =0;i<n;i++){
            s += arr[i];
        }
        dp = new Integer[n][s+1];
        return rec(arr, 0, 0, 0);
    }
}
