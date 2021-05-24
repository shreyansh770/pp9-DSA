import java.util.*;

public class l002 {
    
    public static Scanner sc= new Scanner(System.in);
    

    // public static void mirrorPattern(int n){
    //     int nsp = n-1;
    //     int nst = 1;

    //     for(int row = 1;row<=n;row++){
    //         for(int csp = 1;csp<=nsp;csp++) System.out.print(" ");
    //         for(int cst = 1;cst<=nst;cst++) System.out.print("*");

    //         nsp--;
    //         nst++;
    //         System.out.println();

    //     }
    // }

    
    public static void numberPattern(int n){
        int nst = 1;
        int nsp = n/2;
        
        for(int row=1;row<=n;row++)
        {
            for(int csp=1;csp<=nsp;csp++)
            {
                System.out.print("\t");
            }
            
            int count = row;
            if(row>(nst/2+1)){
               count = n-row +1;
            }
            for(int cst=1;cst<=nst;cst++)
            {
              System.out.print(count+"\t");
              if(cst<=nst/2){
                count++;
              }else{
                count--;
              }
                
            }
            
            if(row<=n/2)
            {
                nsp--;
                nst+=2;
            }else
            {
                 nsp++;
                 nst-=2;
                
            }
            
            System.out.println();
            
        }
    }


    public static void main(String[] args){ 
         int n = sc.nextInt();
         numberPattern(n);
          
    }
}
