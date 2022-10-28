import java.util.*;
import java.io.*;

public class C678 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int k = scn.nextInt();

        String s = scn.next();

        int i = 0;
        int j = 0;

        int K = k;
        int res = 0;
        while (j < n) {

            if (s.charAt(j) == 'b') {

                if (K > 0)
                    K--;
                else {
                    while (K == 0) {
                        if (s.charAt(i) == 'b')
                            K++;
                        i++;
                    }

                    K--;
                }
            }

            res = Math.max(res, j - i + 1);
            j++;
        }

        i = 0;
        j = 0;
        K = k;

        while (j < n) {

            if (s.charAt(j) == 'a') {

                if (K > 0)
                    K--;
                else {
                    while (K == 0) {
                        if (s.charAt(i) == 'a')
                            K++;
                        i++;
                    }

                    K--;
                }
            }
            res = Math.max(res, j - i + 1);
            j++;
        }

        System.out.println(res);

    }
}
