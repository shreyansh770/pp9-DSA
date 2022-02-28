import java.util.*;

public class B1501 {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int t = scn.nextInt();

        while (t-->0) {
            int n = scn.nextInt();

            int[] cream = new int[n];

            for (int i = 0; i < n; i++) {
                cream[i] = scn.nextInt();
            }

            int[] res = new int[n];

            // TLE
            // for(int i=0;i<n;i++){
            //     if(cream[i]>0){
            //         int j = i;
            //         while(j>=0 && cream[i]-->0){
            //              res[j] = 1;
            //              j--;
            //         }
            //     }
            // }

            // rather than moving foward checking from cream we will move backward
            int creamWus = cream[n-1];
            for(int i=n-1;i>=0;i--){

                if(creamWus!=0 || cream[i]!=0){
                     res[i] = 1;
                     creamWus = Math.max(creamWus,cream[i]);
                     creamWus--;
                }
            }

            for(int e : res){
                System.out.print(e+" ");
            }
        }
    }
}