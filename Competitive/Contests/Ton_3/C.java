import java.util.*;
import java.io.*;
public class C {
    public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);

            int t = scn.nextInt();

            while(t-->0){

                int n = scn.nextInt();

                char[] a = scn.next().toCharArray();
                char[] b = scn.next().toCharArray();

                int sc = 0;
                for(int i=0;i<n;i++){

                    if(a[i]==b[i]){
                        sc++;
                    }
                }


                if(sc>0 && sc<n){
                    System.out.println("NO");
                }else{
                    
                    if(sc==n){
                        System.out.println("YES");
                        System.out.println("1 1");
                        System.out.println("2"+" "+n);
                    }
                }
                        
            }
    }
}
