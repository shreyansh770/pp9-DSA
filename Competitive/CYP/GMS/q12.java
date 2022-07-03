public class q12 {
    static Long squaresInChessBoard(Long N) {
        // code here
        if(N == 1){
            return N;
        }
        Long ans = N*N;
        N--;
        while(N>1){
            ans += N*N;
            N--;    }
        return ++ans;}  
}
