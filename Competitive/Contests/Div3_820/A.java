import java.util.*;

public class A {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int t = scn.nextInt();
        while (t-- > 0) {
            int a = scn.nextInt();
            int b = scn.nextInt();
            int c = scn.nextInt();

            int ca = Math.abs(a - 1);
            int ba = Math.abs(b - c) + Math.abs(c - 1);

            // System.out.println(ca +" " + ba);
            if (ca == ba) {
                System.out.println(3);
            } else {

                if (ca < ba) {
                    System.out.println(1);
                } else {
                    System.out.println(2);
                }
            }

        }
    }
}
