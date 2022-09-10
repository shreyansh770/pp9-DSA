import java.util.*;

public class A263 {
    

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int[][] mat = new int[5][5];

        int si=0;
        int ei = 0;
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                mat[i][j] = scn.nextInt();
                if(mat[i][j] == 1) {
                    si = i;
                    ei = j;
                }
            }
        }

        if(si == 2 && ei == 2){
            System.out.println(0);
            return;
        }

        // int totalDis = 0;

        int rowDiff = Math.abs(si-2);
        int colDiff = Math.abs(ei-2);

        System.out.println(rowDiff+colDiff);
    }
}
