import java.util.*;
import java.io.*;

public class D1511 {
    public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);

            int n = scn.nextInt();
            int k = scn.nextInt();

            StringBuilder sb = new StringBuilder();

            // 0='a'

            // k*k maximum length without getting two or more same length substring
            for(int i=0;i<k;i++){
                sb.append((char)(i+'a')); //abc 'a'+0 ->'a' 
                for(int j=i+1;j<k;j++){
                    sb.append((char)(i+'a'));
                    sb.append((char)(j+'a'));
                }
            }

        
            while(sb.length()<n) {sb.append(sb.toString());} // abcabcabc

            System.out.println(sb.toString().substring(0,n));
    }
}
