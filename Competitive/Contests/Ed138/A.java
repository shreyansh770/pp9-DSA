import java.util.*;
import java.io.*;

public class A {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int t = scn.nextInt();

        while (t-- > 0) {

            int n = scn.nextInt();
            int m = scn.nextInt();

            int[][] pos = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int a = scn.nextInt()-1;
                    int b = scn.nextInt()-1;
                    pos[a][b] = 1;
                }
            }

            boolean check = true;
            for (int i = 0; i < n; i++) {
                
               
                for (int j = 0; j < m; j++) {

                    if (pos[i][j] == 1) {

                        boolean flag = true;
                        for (int k = 0; k < n; k++) {
                            for (int l = 0; l < m; l++) {
                                
                                if(k==i && l==j) continue;

                                if(pos[k][m]==1){
                                    flag = false;
                                }
                            }
                        }

                        if(!flag){
                            check = false;
                            break;
                        }
                    }
                }

                if(!check) break;
            }

            if(!check){
                System.out.println("NO");
            }else{
                System.out.println("YES");
            }

        }
    }
}