import java.util.*;

public class A {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int t = scn.nextInt();

        while (t-- > 0) {

            int n = scn.nextInt();
            long x = scn.nextInt();
            long y = scn.nextInt();

            String s = scn.next();
            String p = scn.next();

            int diff = 0;

            List<Integer> d = new ArrayList<>();
            for (int i = 0; i < n; i++) {

                if (s.charAt(i) != p.charAt(i)) {
                    d.add(i);
                    diff++;
                }
            }

            if (diff == 0) {
                System.out.println(0);
            } else if (diff % 2 != 0) {
                System.out.println(-1);
            } else {

                if (diff == 2) {

                    if (d.get(0) + 1 == d.get(1)) {


                        System.out.println(Math.min(2 * y, x));

                    } else {
                        System.out.println(y);
                    }
                } else {

                    int l = diff/2;
                    System.out.println(l*y);
                }
            }
        }
    }
}
