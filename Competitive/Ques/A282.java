import java.util.*;

public class A282{

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n  = scn.nextInt();
        scn.nextLine();
        int x = 0;
        while(n-->0){
            String s = scn.nextLine();
            if(s.charAt(1) == '+') x+=1;
            if(s.charAt(1)=='-') x-=1;
        }

        System.out.println(x);
        
    }
}