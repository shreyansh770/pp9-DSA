import java.util.*;

public class C1389 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int t = scn.nextInt();
        while (t-- > 0) {
            String s = scn.next();

            int res = (int)1e9;
            int i, j = 0;
            for (i = 0; i < 10; i++) {

                for (j = 0; j < 10; j++) {
                    // longest ij subsequence

                    int cnt = 0;
                    boolean flag = true;
                    for (char ch : s.toCharArray()) {

                        int num = (int) ch - '0';

                        // System.out.println(num);
                        if (flag && num == i) {
                            cnt++;
                            flag = !flag;
                        } else if (!flag && num == j) {
                            cnt++;
                            flag = !flag;
                        }
                    }
                    if (i != j && cnt % 2 == 1) {
                        cnt--;
                    }

                    res = Math.min(res, s.length() - cnt);
                }

            }

            System.out.println(res);
        }
    }
}
