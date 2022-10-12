import java.util.*;


public class B{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int t  =scn.nextInt();

        while(t-->0){
            int n = scn.nextInt();

            if(n==3){
                System.out.print("-1");
    
               
            }else{
                
                if(n%2!=0){
                    System.out.print(n-1+" "+n+" ");
                    for(int i=1;i<n-1;i++){
                        System.out.print(i+" ");
                    }
                }else{
                    for(int i=n;i>=1;i--){
                        System.out.print(i+" ");
                    }
                }
    
                // System.out.println();
            }
            System.out.println();
        }
    }
}