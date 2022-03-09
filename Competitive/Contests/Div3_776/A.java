import java.util.*;

public class A {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int t = scn.nextInt();

        while (t-- > 0) {

            String s = scn.next();

            String q = scn.next();

            char[] c = q.toCharArray();
            boolean isPos = false;
            for (int i = 0; i < s.length(); i++) {

                if (s.charAt(i) == c[0]) {
                    if (i % 2 == 0) {
                        isPos = true;
                        break;

                    }
                }
            }

            if (isPos)
                System.out.println("YES");
            else
                System.out.println("NO");

        }
    }

}
