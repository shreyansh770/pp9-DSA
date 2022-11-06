import java.util.*;
import java.io.*;
public class B {
    public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);

            int t = scn.nextInt();
            while(t-->0){

                int n = scn.nextInt();

                if(n==1){
                    System.out.println("1");
                    System.out.println("1 2");
                }else{

                    
                    if(n%2==0){

                        // System.out.println(n/2);
                        int i = 2;
                        for(int j=1;j<=n/2;j++){
                            int s = i+4;
                            // System.out.println(i+" "+s);
                            i+=6;
                        }
                    }else{
                        // System.out.println((n/2)+1);
                        int N = n-1;
                        int i = 2;
                        for(int j=1;j<=N/2;j++){
                            int s = i+4;
                            // System.out.println(i+" "+s);
                            i+=6;
                        }

                        int s1 = i+1;
                        int s2 = i+2;
                        // System.out.println(s1+" "+s2);
                    }

                    int tp = (n+1)/2;

                    System.out.println(tp);

                    for(int i=0;i<tp;i++){
                        int s1 = i*3+1;
                        int s2 = n*3-(i*3+1)+1;
                        System.out.println(s1+" "+s2);
                    }
                    
                }
            }
    }
}
