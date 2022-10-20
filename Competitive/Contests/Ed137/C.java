import java.util.*;
import java.io.*;
public class C {
    public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);
            int t = scn.nextInt();
            while(t-->0){
                int n = scn.nextInt();
                String s = scn.next();
                int[] a = new int[n];
                for(int i=0;i<n;i++){
                    a[i] = scn.nextInt();
                }

                long max = -(long)1e9;

                long res = 0;
                //

                // in case of 0 max update
                // in case of 1 add the max it can either be covered or not

                // now for 

                long[] dp = new long[n]; // max between i-1 and i

                for(int i=0;i<n;i++){

                    if(s.charAt(i)=='1'){
                        res+=Math.max(a[i],max);
                        if(a[i]<max) max = a[i];
                    }
                    if(s.charAt(i)=='0'){
                            max = a[i];
                    }
                    
                }

                // int res = 0;
                // for(int i=0;i<n;i++){
                //     res+=dp[i];
                // }

                System.out.println(res);
            }
    }
}
