import java.util.*;
import java.io.*;

public class A{
    public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);

            int t = scn.nextInt();
            while(t-->0){
                long n = scn.nextInt();

                
                long res = (long)Math.ceil(n*1.0/2*1.0);

                System.out.println(res);

            }
    }
}