import java.util.*;
public class D1551_1{

    public static void main(String[] args) {
        
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();

        while(t-->0){

            int n = scn.nextInt();
            int m = scn.nextInt();
            int k = scn.nextInt();

            if(n%2==0 && m%2==0){
                if(k%2==0){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }else if(n%2==0){

                int leftDominoes = ((n*m)/2-n/2); // last column would take n/2

                if(leftDominoes>=k && k%2==0){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }

            }else{

                int leastK = m/2;
                if(k>=leastK && (k-leastK)%2==0){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }
        }
    }
}