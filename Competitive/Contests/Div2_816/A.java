import java.util.*;

public class A {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int t= scn.nextInt();

        while(t-->0){
            int n = scn.nextInt();
            int m = scn.nextInt();

            if(n==1 && m==1){
System.out.println(0);
            }else{
                System.out.println(n+m-2+Math.min(n,m));
            }
    
            
        }



    }
}