package Amazon;

import java.util.*;
import java.io.*;

public class q1{
    public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);

            int n = scn.nextInt();
            int[] a = new int[n];
            int sum = 0;
            for(int i=0;i<n;i++){
                a[i] = scn.nextInt();
                sum+=a[i];
            }
            int m = scn.nextInt();
            int msf = 0;
            
            int max = 0;

            for(int i=0;i<m;i++){
                msf+=a[i];
            }

            max = Math.max(msf,max);
            for(int i=m;i<n;i++){

                msf = msf+a[i]-a[i-m];
                max = Math.max(msf,max);
            }

            System.out.println(sum-max);
    }
}
