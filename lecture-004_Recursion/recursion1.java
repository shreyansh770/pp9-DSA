import java.io.*;
import java.util.*;

public class recursion1 {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        int n = scn.nextInt(); 
        powerLog(x, n);
    }

    public static void printDecreasing(int n){
         if(n<1) return ;
         
         System.out.println(n);
         printDecreasing(n-1);

    }

    public static void printIncreasing(int n){
        if(n<1) return ; 
        
        printIncreasing(n-1);
        System.out.println(n);
        
    }

    public static void pdi(int n){
        if(n<1) return ;
         
         System.out.println(n);
         pdi(n-1);
         System.out.println(n);
    }

    public static int factorial(int n){
        
        if( n== 1 || n==0) return 1;
        return n*factorial(n-1);
    }

    public static int power(int x, int n){
        
        if(n == 0) return 1;
        
        int xpown = power(x,n-1);
        return x*xpown;
    }

    public static int powerLog(int x, int n){
        if(n == 0) return 1;
        
        int xpown = powerLog(x,n/2);
        int xn = xpown * xpown;
        
        if( n %2 == 1) xn = xn * x;
        
        
        return xn;
        
       
    }


}
