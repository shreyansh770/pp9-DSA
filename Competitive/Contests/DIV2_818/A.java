import java.util.*;
public class A {
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int t  =scn.nextInt();

        while(t-->0){

            int n = scn.nextInt();

            long res = n + n / 2 * 2 + n / 3 * 2;
            System.out.println(res);
        }
    }
}