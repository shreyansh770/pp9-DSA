import java.util.*;

public class B1343 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int t = scn.nextInt();

        while (t-- > 0) {
            int n = scn.nextInt();

            if ((n / 2) % 2 != 0) {
                System.out.println("NO");
            }

            else {
                System.out.println("YES");
                int j = 2;
                for (int i = 1; i <= n / 2; i++) {

                    System.out.print(j + " ");
                    j += 2;
                }

                int val = j - 2;

                j = 1;
                for (int i = 1; i <n / 2; i++) {
                    System.out.print(j + " ");
                    j += 2;
                }

                System.out.println(val + n / 2 - 1);
            }

        }
    }
}
