import java.util.*;

public class B {

    public static int gcd(int a , int b){

        if(b==0) return a;

        return gcd(b,a%b);
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int t = scn.nextInt();

        while (t-- > 0) {

            int n = scn.nextInt();

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scn.nextInt();
            }

          
            if(n>2){

                boolean check = true;
                for(int i=0;i<n-2;i++){
                    
                    int g1 = gcd(a[i], a[i+2]);
                    int g2 = gcd(a[i], a[i+1]);

                    if(g1>g2){
                        System.out.println("NO");
                        check = false;
                        break;
                    }
                }

                if(check){
                    System.out.println("YES");
                }
            }else{
                System.out.println("YES");
            }

        }
    }
}