import java.util.*;

public class C1451 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int t = scn.nextInt();

        while (t-- > 0) {

            int n = scn.nextInt();

            int k = scn.nextInt();

            char[] a1 = scn.next().toCharArray();
            char[] b1 = scn.next().toCharArray();

            int[] f1 = new int[26];
            int[] f2 = new int[26];

            for (char c : a1) {
                f1[c - 'a']++;
            }

            for (char c : b1) {
                f2[c - 'a']++;
            }

            // System.out.println(f1[25]);
            boolean flag = true;
            for (int i = 0; i < 26; i++) {

                if (f1[i] < f2[i]) {
                    flag = false;
                    break;
                }

                f1[i] -= f2[i];

                if (f1[i] % k != 0 || (i==25 && f1[i]>0)) {
                    // System.out.println(i);
                    flag = false;
                    break;
                }

                if (i < 25)
                    f1[i + 1] += f1[i];

            }

            if (!flag) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }

        }
    }
}
