import java.util.*;

public class C611 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int m = scn.nextInt();

        char[][] grid = new char[n][m];

        for (int i = 0; i < n; i++) {
            String s = scn.next();
            for (int j = 0; j < m; j++) {
                grid[i][j] = s.charAt(j);
            }
        }

        int[][] hor = new int[n][m];
        int[][] ver = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (j - 1 >= 0 && grid[i][j] == '.' && grid[i][j - 1] == '.') {
                    hor[i][j] = hor[i][j - 1] + 1;
                }else{
                    if(j-1>=0) hor[i][j] = hor[i][j-1];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (i - 1 >= 0 && grid[i][j] == '.' && grid[i-1][j] == '.') {
                    ver[i][j] = ver[i-1][j] + 1;
                }else{
                    if(i-1>=0) ver[i][j] = ver[i-1][j];
                }
            }
        }

        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < m; j++) {

        //         System.out.print(hor[i][j]+" ");
        //     }

        //     System.out.println();
        // }

        // System.out.println();
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < m; j++) {

        //         System.out.print(ver[i][j]+" ");
        //     }

        //     System.out.println();
        // }

        int q = scn.nextInt();

       
        while(q-->0){

            int res = 0;
            int x1 = scn.nextInt()-1;
            int y1 = scn.nextInt()-1;

            int x2 = scn.nextInt()-1;
            int y2 = scn.nextInt()-1;

            for(int i=x1;i<=x2;i++){

                res += hor[i][y2] - hor[i][y1];
            }

            for(int i=y1;i<=y2;i++){

                res += ver[x2][i] - ver[x1][i];
            }

            System.out.println(res);
        }

        
    }
}
