import java.util.*;
import java.io.*;
public class A {
    public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);

            int t = scn.nextInt();
            while(t-->0){

                int n = scn.nextInt();

                int[] a = new int[n];

                for(int i=0;i<n;i++){

                    a[i] = scn.nextInt();
                }

                long s1 = 0;

                for(int i=0;i<n;i++){

                    s1+=a[i];
                }

                long res = Math.abs(s1);

                System.out.println(res);
            }

    }
}
