import java.util.*;

public class q3 {

    public static long sti(String s) {

        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            num = num * 10 + s.charAt(i) - '0';
        }

        return num;
    }

    public static int missingNumber(String s) {
        // add code here.

        for (int i = 1; i <= 6; i++) {
            long first = sti(s.substring(0, i));
            // System.out.println(first);

            long missing = 0;
            boolean seq = true;
            int j = i;

            boolean mt = false;
            String check = "";
            while (j < s.length()) {

                check =check+ s.charAt(j);
                //  System.out.println(check);

                if (first + 1 == sti(check)) {

                    first = sti(check);
                    check="";
                } else if (first + 2 == sti(check)) {
                    mt = true;
                    missing = first + 1;
                    first = sti(check);
                    check = "";

                } else if(first < sti(check)) {
                    seq = false; // not correct sequence
                }

                j++;
            }

            if (mt && seq) {
                return (int) missing;
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        
        Scanner scn =new Scanner(System.in);

        String s = scn.next();

        int ans  = missingNumber(s);

        System.out.println(ans);
    }
}
