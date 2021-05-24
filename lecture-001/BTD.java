import java.util.*;

public class BTD {
    // decimal to Binary

    public static Scanner scn = new Scanner(System.in);

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

        int n  = scn.nextInt();
        int b = scn.nextInt();
        System.out.println(binaryToDecimal(n,b));
        
    }

}
