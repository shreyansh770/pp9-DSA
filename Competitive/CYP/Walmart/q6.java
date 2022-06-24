public class q6 {

    
    long power(int N,int R)
    {
        //Your code here
        if(R==0) return 1;

        long pow = power(N, R/2);

        long sq = (pow*pow)%1000000007;
        if(R%2==0) return sq;

        return (sq*N)%1000000007;
        
    }
}
