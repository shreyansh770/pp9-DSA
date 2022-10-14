import java.util.*;
import java.io.*;
public class B {
    public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);
            int t = scn.nextInt();

            while(t-->0){

                int n = scn.nextInt();

                int[] a  =new int[n];

                for(int i=0;i<n;i++){
                    a[i] = scn.nextInt();
                }

                Arrays.sort(a);

                boolean flag = true;
                for(int i=1;i<n;i++){

                    if(a[i]<=a[i-1]) flag = false;

        
                }

                if(flag){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }
    }
}
