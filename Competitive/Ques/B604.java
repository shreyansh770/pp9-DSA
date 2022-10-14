import java.util.*;
import java.io.*;

public class B604 {

    public static boolean solve(int[] a ,int n, long s ,int nob){

        int l = 0;
        int r = n-1;
        while(l<=r){

            if(a[r]+a[l]<=s)l++;
            r--;
            nob--;
        }


        return nob>=0;
        
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int k = scn.nextInt();
        int[] a = new int[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {

            a[i] = scn.nextInt();
            sum += a[i];
        }

        long si = a[n-1];
        long ei = 2*sum;
        long res = 0;
        while (si <= ei) {

            long mid = (si + ei) / 2;
            // System.out.println(mid);
            if(solve(a, n, mid, k)){
                ei = mid-1;
                res = mid;
            }else{
                si = mid+1;
            }

        }

        System.out.println(res);

    }
}
