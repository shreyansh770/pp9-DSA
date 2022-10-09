import java.util.*;

public class B416{


    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int m = scn.nextInt();
        int n = scn.nextInt();

        int[][] list = new int[m+1][n+1];

        
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                int t = scn.nextInt();
                list[i][j] = t; // ith kam krne me jth bnde ko kitna tym lag raha hai 
            }
        }

        int[][] res = new int[m+1][n+1]; // res[i][j] = time taken for ith person to complete jth painting

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                res[i][j] = Math.max(res[i-1][j] , res[i][j-1]) + list[i][j];
            }
        }

        for(int i=1;i<=m;i++){
            System.out.print(res[i][n]+" ");
        }
        
    }
}