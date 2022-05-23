public class q3 {

    static void swap(int[][] arr, int sr, int sc, int rs, int rc) {
        int temp = arr[sr][sc];
        arr[sr][sc] = arr[rs][rc];
        arr[rs][rc] = temp;

    }

    static void rotate(int matrix[][]) {
        // Code Here

        int n = matrix.length;

        // transpose
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                swap(arr, i, j, j, i);
            }
        }


        // swap cols

        for(int i =0;i<n;i++){

            int sc=0;
            int ec=N-1;

            while(sc<ec){
                swap(arr, sc, i, ec, i);
                sc++;
                ec--;
            }
        }

    }
}
