import java.util.*;

public class DTB {
    

    public static Scanner scn = new Scanner(System.in);

    public static int decimalToBinary(int n , int b) {
      int ans = 0;
      int pow = 1;
      int temp = n;
      while(temp>0){
          int rem = temp % b;
          temp /= b;
          ans += rem * pow;
          pow*=10;
      }

      return ans;
     
    }

    public static void main(String[] args) {

        int n  = scn.nextInt();
        int b = scn.nextInt();
        System.out.println(decimalToBinary(n ,b));
    
    }

}
