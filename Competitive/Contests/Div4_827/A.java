import java.util.*;
import java.io.*;

public class A{
    public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);

            int t = scn.nextInt();
            while(t-->0){

                int a  = scn.nextInt();
                int b = scn.nextInt();
                int c  =scn.nextInt();

                if(a==b+c){
                    System.out.println("YES");
                }else if(b==a+c){
                    System.out.println("YES");
                }else if(c==a+b){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }
    }
}