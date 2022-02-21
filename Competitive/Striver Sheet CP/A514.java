import java.util.*;

public class A514 {
    
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        long n = sn.nextLong();
        // System.out.println(n);
        long newNo=n;
        long ans = 0;
        long i = 1;
        int loopCount = 0;
        while(newNo>0){
            // System.out.print(newNo+" ");
            if(newNo == 9 && loopCount>0) break;
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

        if(newNo ==9){
            System.out.println(newNo*i + ans);
            return ;
        }

        if(loopCount == 1){
            System.out.println(n);
            return ;
        }


        
        System.out.println(ans);

    }
}
