import java.util.*;

public class A778 {

    public static boolean check(int[] moves, String t, String p, int m) {

        StringBuilder sb = new StringBuilder();

        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<m;i++){
            set.add(moves[i]);
        }

        int j=0;
        for(int i=0;i<t.length()&&j<p.length();i++){

            if(!set.contains(i) && t.charAt(i)==p.charAt(j)) j++;
        }
        return j==p.length();

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String t = scn.next();
        String p = scn.next();

        int[] moves = new int[t.length()];
        for(int i=0;i<t.length();i++){
            moves[i] = scn.nextInt()-1;
        }

        int si = 0;
        int ei = t.length() - 1;
        int res = 0;
        while (si <= ei) {
            int m = (si + ei) / 2;

            boolean flg  = check(moves, t, p, m);
            if (flg) {
                res = m;
                si = m + 1;
            } else {
                ei = m - 1;
            }
        }

        System.out.println(res);
    }
}
