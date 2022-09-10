import java.util.*;
 
public class C371 {
 
    // Binary search on possible ans
    public static boolean isPos(long mid, long[] items, long[] prices, long[] rubles, long[] req) {
 
        // checking in items array
        // if item array is not fulfilling
        // checking if we can buy with rubles
 
        // cloning
        long[] req_= req.clone();
        long[] rubles_ = rubles.clone();
 
        for (int i = 0; i < 3; i++) {
            req_[i] = req_[i] * mid;
        }
 
        req_[0]-=items[0];
        req_[1]-=items[1];
        req_[2]-=items[2];
 
        long tc=0;
        for(int i=0;i<3;i++){
            if(req_[i]>0){ // keep check on extra items that we hold ex we need 100 bread and we have 1000 bread
                tc= tc + req_[i]*prices[i];
            }
        }
 
        if(tc<=rubles_[0]) return true;
 
        return false;
    }
 
    public static void main(String[] args) {
 
        Scanner scn = new Scanner(System.in);
 
        String recipe = scn.next();
 
        long[] req = new long[3];
 
        for (char ch : recipe.toCharArray()) {
            if (ch == 'B') {
                req[0]++;
            } else if (ch == 'S') {
                req[1]++;
            } else {
                req[2]++;
            }
        }
 
        long[] itmes = new long[3];
        for (int i = 0; i < 3; i++) {
            itmes[i] = scn.nextLong();
        }
 
        long[] prices = new long[3];
        for (int i = 0; i < 3; i++) {
            prices[i] = scn.nextLong();
        }
        long[] rubles = new long[1];
        rubles[0] = scn.nextLong();
 
        // Binary search
        long si = 0;
        long ei = (long) 1e14;
        long canMake = 0;
        while (si <= ei) {
            long mid = (si + ei) / 2;
 
            if (isPos(mid, itmes, prices, rubles, req)) {
                canMake = mid;
                si = mid + 1;
            } else {
                ei = mid - 1;
            }
        }
 
        System.out.println(canMake);
        scn.close();
 
    }
}
