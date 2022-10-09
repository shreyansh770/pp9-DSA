import java.util.*;

public class B {

    static Scanner scn = new Scanner(System.in);

    public static void solve() {

        // long l = scn.nextLong();
        // long r = scn.nextLong();

        // long lsrt = (long)Math.floor(Math.sqrt(l*1.0));
        // long rsrt = (long)Math.floor(Math.sqrt(r*1.0));

        // // System.out.println(lsrt+" "+rsrt);
        // long res = 0;
        // if(lsrt*lsrt>=l && lsrt*lsrt<=r){
        //     res++;
        // }

        // if((lsrt+1)*lsrt>=l && (lsrt+1)*lsrt<=r){
        //     res++;
        // }

        // if((lsrt+2)*lsrt>=l && (lsrt+2)*lsrt<=r){
        //     res++;
        // }

        // if(lsrt!=rsrt){
        //     if(rsrt*rsrt>=l && rsrt*rsrt<=r){
        //         res++;
        //     }
    
        //     if((rsrt+1)*rsrt>=l && (rsrt+1)*rsrt<=r){
        //         res++;
        //     }
    
        //     if((rsrt+2)*rsrt>=l && (rsrt+2)*rsrt<=r){
        //         res++;
        //     }
        // }

        // res += Math.max(0, rsrt-lsrt-1)*3;

        long l = scn.nextLong();
        long r = scn.nextLong();
        long rSqrt = (long) Math.floor(Math.sqrt(r));
        long lSqrt = ((long) Math.floor(Math.sqrt(l)));
        if (rSqrt * rSqrt > r) rSqrt--;
        if (lSqrt * lSqrt > l) lSqrt--;
        if ((rSqrt + 1) * (rSqrt + 1) <= r) rSqrt++;
        if ((lSqrt + 1) * (lSqrt + 1) <= l) lSqrt++;
        long rCount = (rSqrt - 1) * 3;
        long lCount = (lSqrt - 1) * 3;
        for (long i = rSqrt * rSqrt; i < Long.MAX_VALUE; i += rSqrt) {
            if (i > r) break;
            rCount++;
        }
        for (long i = lSqrt * lSqrt; i < Long.MAX_VALUE; i += lSqrt) {
            if (i >= l) break;
            lCount++;
        }

        System.out.println(rCount-lCount);
    
    }



    public static void main(String[] args) {

        long t = scn.nextInt();
        // int t = 1;
        while (t-- > 0) {
            solve();
        }
    }
}
