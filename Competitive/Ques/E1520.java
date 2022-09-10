import java.util.*;

public class E1520 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int t = scn.nextInt();

        while (t-- > 0) {

            int n = scn.nextInt();
            String s = scn.next();

            // moving towards the center most sheep

            int cnt = 0;
            for (char ch : s.toCharArray()) {
                if (ch == '*') {
                    cnt++;
                }
            }

            int middle_sheep = (cnt / 2);

            // finding the position of middle_sheep
            int pos = -1;
            int idx = -1;

            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (ch == '*') {
                    pos++;
                    if (pos == middle_sheep)
                        idx = i;
                }
            }

        }
    }
}
