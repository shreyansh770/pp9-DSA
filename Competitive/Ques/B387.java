import java.util.*;

public class B387 {
    
    public static void main(String[] args) {
         Scanner scn = new Scanner(System.in);
         
         int n = scn.nextInt();
         int m = scn.nextInt();

         int[] a = new int[n];
         for(int i=0;i<n;i++){
            a[i] =scn.nextInt();
         }

         int[] b = new int[m];
         for(int i=0;i<m;i++){
            b[i] =scn.nextInt();
         }

         Arrays.sort(a);
         Arrays.sort(b);

         int cnt = 0;

         int i=0,j=0;
  
         while(i<n&&j<m){

            if(a[i]<=b[j]){i++;j++;}
            else {j++;}
         }

         System.out.println(n-i);
    }
}
