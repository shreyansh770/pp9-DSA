import java.util.*;
import java.io.*;
public class B {
    public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);

            int t = scn.nextInt();
            while(t-->0){

                int n = scn.nextInt();
                int q = scn.nextInt();

                long odd = 0;
                long even = 0;

                long ec = 0;
                long oc = 0;
                for(int i=0;i<n;i++){
                    long num = scn.nextLong();

                    if(num%2==0){
                        even+= num;
                        ec++;
                    }else{
                        odd+= num;
                        oc++;
                    }
                }

                // odd + odd = even
                // odd + even = odd
                // even + odd = odd
                // even +even = even
                while(q-->0){

                    int type = scn.nextInt();
                    int val = scn.nextInt();

                    if(type==1){
                        odd+=(oc*val);
                        if(val%2!=0){ //  odd + odd
                           ec+=oc;
                           oc = 0;
                        }
                    }else{
                        even+=(ec*val); 
                        if(val%2!=0){ // even + odd
                            oc+=ec;
                            ec = 0;
                        }
                    }

                    System.out.println(odd+even);
                }

                
            }
    }
}
