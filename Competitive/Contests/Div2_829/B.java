import java.util.*;
import java.io.*;
public class B {
    public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);
            int t = scn.nextInt();

            while(t-->0){
                int n = scn.nextInt();

                boolean flag = (n%2==0 ? true : false);
                if(flag){
                    for(int i=1;i<=n/2;i++){
                        int p1 = i + (n+1)/2;
                        int p2 = i;
                        System.out.print(p1+" "+p2+" ");
                    }
                }else{

                    for(int i=1;i<=n/2;i++){
                        int p1 = i;
                        int p2 = i + (n+1)/2;
                        System.out.print(p1+" "+p2+" ");
                    }

                    int p = (n+1)/2;
                    System.out.print(p+" ");
                }

                System.out.println();
            }
    }
}
