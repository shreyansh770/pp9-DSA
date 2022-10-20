import java.util.*;
import java.io.*;
public class A{
    public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);

            int t  =scn.nextInt();

            while(t-->0){

                int n = scn.nextInt();

                int[] a = new int[n];

                for(int i=0;i<n;i++){
                    a[i] = scn.nextInt();
                }

                int dl = 10 - n;

                if(dl==2){
                    System.out.println(6);
                }else{
                    System.out.println(dl*(dl-1)*3);
                }
            }
    }
}