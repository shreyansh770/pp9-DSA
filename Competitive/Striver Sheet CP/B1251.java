import java.util.*;

public class B1251 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int t = scn.nextInt();
        while (t-- > 0) {
            int n = scn.nextInt();

            char[][] str = new char[50][50];
            int res = 0;
            int wE = 0;
            boolean oddString = false;
            for (int i = 0; i < n; i++) {
                String s = scn.next();

                int one = 0;
                int zero = 0;

                if (s.length() % 2 == 0) {

                    for (int j = 0; j < s.length(); j++) {

                        char ch = s.charAt(j);

                        if (ch == '1')
                            one++;
                        else
                            zero++;
                    }

                    if (one % 2 == 0 || zero % 2 == 0) {
                        res++;
                    } else {
                        wE++;
                    }

                } else {
                    oddString = true;
                }

            }

            if (oddString) {
                System.out.println(n);
            } else {

                res += (wE/2)*2;
                System.out.println(res);
            }
        }
    }
}
