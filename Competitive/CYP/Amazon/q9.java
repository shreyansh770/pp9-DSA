public class q9 {

    static boolean isValid(int[][] mat, int si , int sj){



        for(int i=0;i<9;i++){
            if(sj==i) continue;
            if(i!=sj && mat[si][i]==mat[si][sj]) return false;
            if(i!=si && mat[i][sj]==mat[si][sj]) return false;
            if(((3*(si/3)+i/3)!=si ) &&((3*(sj/3)+i%3)!=sj) && mat[3*(si/3)+i/3][3*(sj/3)+i%3]==mat[si][sj]) return false;
        }

        return true;

    }

    static int isValid(int mat[][]){
        
        
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(mat[i][j]==0) continue;

                if(isValid(mat,i,j)){
                    continue;
                }else{
                    return 0;
                }
            }
        }

        return 1;
    }
}
