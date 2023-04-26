import java.util.*;

public class SOE {

    // soe
    public static void soe(int n){
  
         boolean[] num = new boolean[n+1];

         for(int i=2;i*i<=n;i++){

            if(num[i]){

                for(int j=i*i;j<=n;j+=i){
                    num[i] = false;
                }
            }
         }


        for(int i=0;i<n;i++){

            if(num[i]) System.out.println(num[i]); // prime numbers
        }

    }



    // prime factors using soe 

    public static List<Integer> getPrimeFactors(int num){

        int[] spf = new int[num+1]; // smallest prime factors for all numbers till n

        for(int i=0;i<=num;i++){

            spf[i] = i ; // intially smallest pf of i =i
        }

        for(int i=2;i*i<=num;i++){
            
            if(spf[i]==i){

                for(int j=i*i;j<=num;j+=i){
                    if(spf[j]==j) spf[j] = i;
                }
            }

        }

        List<Integer> primeFactors = new ArrayList<>();

        while(num!=1){

              primeFactors.add(spf[num]);

              num = num/spf[num];
        }


        return primeFactors;

    }



    // segemented soe
    

    public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);
    }
}
