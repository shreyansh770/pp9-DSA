import java.util.*;

public class A514 {
    
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        long n = sn.nextLong();

        long newNo=n;
        long ans = 0;
        int i = 1;
        int loopCount = 0;
        while(newNo>9){
            // System.out.print(newNo+" ");
            long rem = newNo%10;
            loopCount++;
            if(rem >= 5){
                 rem = 9 -rem;
                 ans = ans + rem*i;
            }else{
                ans = ans + rem*i;
            }

            i*=10;

            newNo/=10;
        }

        if(loopCount == 1){
            System.out.println(n);
            return ;
        }
        System.out.println(newNo*i + ans);

    }
}
