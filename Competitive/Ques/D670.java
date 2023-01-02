import java.util.*;
import java.io.*;

public class D670{

    public static boolean solve(long[] req , long[] sup , long mp , long bake){

        for(int i=0;i<req.length;i++){

                 long tir = req[i]*bake;

                 if(sup[i]<tir){
                    long ir = tir-sup[i];

                    if(mp<ir) return false;
                    mp-=ir;
                 }
        }

        return true;

    }

    public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);

            int n = scn.nextInt();
            long k = scn.nextInt();

            long[] a = new long[n];
            for(int i=0;i<n;i++){
                a[i] = scn.nextInt();
            }

            long[] b = new long[n];

            for(int i=0;i<n;i++){
                b[i] = scn.nextInt();
            }

            long si = 1;
            long ei = (long)1e10;
            long res = 0;
            while(si<=ei){
                long mid = (si+ei)/2;

                if(solve(a, b, k, mid)){
                    si=mid+1;
                    res = mid;
                }else{
                    ei=mid-1;
                }
            }

            System.out.println(res);
 
    }
}