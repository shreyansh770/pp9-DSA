import java.util.*;

public class t {


    // 13 15 -> 1
    // 10 11 -> 5
    
    static boolean[] primes;
    static int mod = (int)(1000000007);

    public static void soe(int n){
        for(int i=0;i<=n;i++){
            primes[i] = true;
        }
        
        for(int p=2;p*p<=n;p++){
            if(primes[p]==true){
                
                
                for(int i=p*p;i<=n;i+=p){
                    primes[i] = false;
                }
            }
        }
    }
    
    public static int solve(int A, int B) {
        
        int[] fact = new int[A+1];
        
        fact[1] = 1;
        
        for(int i=2;i<=A;i++){
            fact[i] = ((fact[i-1]%mod)*i)%mod;
        }
        
        for(int i=1;i<=A;i++){
            fact[i]= (fact[i]+B)%mod;
        }
        
        primes = new boolean[999999999];
        soe(fact[A]);
        
        int count = 0;
        for(int i=1;i<=A;i++){
            int fs = fact[i];
            if(primes[fs]==true){
                count++;
            }
        }
        
        return count;
        
    }


    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int A = scn.nextInt();
        int B = scn.nextInt();

        System.out.println(solve(A,B));

    }
}
