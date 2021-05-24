import java.util.*;

public class anyBaseToAnyBase {

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

    public static int binaryToDecimal(int n,int b) {
        int num = n;
        int dec_value = 0;
     
        int base = 1; // 2^0
     
        int temp = num;
        while (temp>0) {
            int last_digit = temp % 10;
            temp = temp / 10;
     
            dec_value += last_digit * base;
     
            base = base * b;// 2^1 , 2^2 , 2^3 , 2^4.....
        }
     
        return dec_value;
    }

    public static void main(String[] args) {
        int n = scn.nextInt();
        int b1 = scn.nextInt();
        int b2 = scn.nextInt();
        int decimal_No = binaryToDecimal(n, b1);
        System.out.println(decimalToBinary(decimal_No,b2));
    }
}
