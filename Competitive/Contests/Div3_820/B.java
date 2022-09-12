import java.util.*;

public class B {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();

        while (t-- > 0) {
            int n = scn.nextInt();
            String s = scn.next();
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < n;) {
                int num = s.charAt(i) - '0';

                if (i + 2 < n) {
                    int num2 = s.charAt(i + 2) - '0';
                    int num3 = s.charAt(i + 1) - '0';

                    if (num2 != 0) {
                        char ch = (char) (97 + num - 1);
                        sb.append(ch);
                        i++;
                    } else {

                        if (i + 3 < n) {

                            int zc = s.charAt(i + 3) - '0';
                            if (zc == 0) {
                                char ch = (char) (97 + num - 1);
                                sb.append(ch);
                                i++;
                            } else {
                                int num4 = num * 10 + num3;
                                char ch = (char) (97 + num4 - 1);
                                sb.append(ch);
                                i += 3;
                            }
                        } else {
                            int num4 = num * 10 + num3;
                            char ch = (char) (97 + num4 - 1);
                            sb.append(ch);
                            i += 3;
                        }

                    }
                } else {
                    char ch = (char) (97 + num - 1);
                    sb.append(ch);
                    i++;
                }
            }

            System.out.println(sb.toString());
        }
    }
}
