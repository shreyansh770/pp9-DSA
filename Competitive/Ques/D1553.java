import java.util.*;

public class D1553 {

    static StringBuilder sb;
    static HashMap<String, Boolean> dp;

    public static boolean rec(String s, String t, int idx) {

        if (idx == s.length()) {
            if (sb.toString().equals(t)) {
                return true;
            } else {
                return false;
            }
        }

        String ss = idx + "->" + sb.toString(); // 2->abc
        if (dp.containsKey(idx + "->" + ss))
            return dp.get(idx + "->" + ss);

        // type -> add curr char and idx+1
        sb.append(s.charAt(idx));
        boolean add = rec(s, t, idx + 1);
        int j = idx - 1;
        String ssa = j + "->" + sb.toString();
        dp.put(ssa, add);
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }

        // backspace -> remove previous char and idx+1
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        boolean back = rec(s, t, idx + 1);

        int i = idx - 1;
        String ssb = i + "->" + sb.toString();
        dp.put(ssb, back);
        return add || back;

    }

    // ababa
    // ba
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int q = scn.nextInt();

        while (q-- > 0) {

            String s = scn.next();
            String t = scn.next();

            int i = s.length() - 1;
            int j = t.length() - 1;
            while (i >= 0 && j >= 0) {

                if (s.charAt(i) == t.charAt(j)) {
                    i--;
                    j--;
                } else {
                    while (i >= 0 && s.charAt(i) != t.charAt(j)) {
                        i -= 2;
                    }
                }
            }

            if (i < 0) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }

        }
    }

}