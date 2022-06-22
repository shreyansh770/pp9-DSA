public class q2 {
    int count(int N, int A[][], int B[][]) 
    { 
        int wz = 0;
        int wo = 0;

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(A[i][j]!=B[i][j]){
                    if(A[i][j]==1){
                        wo++;
                    }else{
                        wz++;
                    }
                }
            }
        }


        return wz == wo ? wz :-1;
    }
}
