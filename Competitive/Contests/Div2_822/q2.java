import java.util.*;

public class q2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int t = scn.nextInt();

        while (t-- > 0) {

            int n = scn.nextInt();

            int[][] res = new int[n][n];
            res[0][0] = 1;
            for (int i = 0; i < n; i++) {

                    if (i == 1) {
                        res[i][0] = 1;
                        res[i][1] = 1;
                    } else {
                        res[i][0] = 1;
                        res[i][i] = 1;
                    }
                
            }

            if(n==1){
                System.out.println(1);
            }else {
                for(int i=0;i<n;i++){
                    for(int j=0;j<=i;j++){
                        System.out.print(res[i][j]+" ");
                    }

                    System.out.println();
                }
            }
        }
    }
}