import java.util.*;

public class A{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int t = scn.nextInt();

        while(t-->0){
            int n = scn.nextInt();

            int k = n/3;
            System.out.println(k-2);

        }
    }
}