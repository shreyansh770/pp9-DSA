import java.util.*;


public class q2 {



    public static void main(String[] args) {

        Scanner fs = new Scanner(System.in);

        int t = fs.nextInt();

        while (t-- > 0) {

            int n = fs.nextInt();

            String s = fs.next();

            // int[] arr = new int[26];
            int mod = (int) 1e9+7;

            HashSet<Integer> vow = new HashSet<>();

            vow.add(0);
            vow.add(4);
            vow.add(8);
            vow.add(14);
            vow.add(20);

            HashSet<Integer> rep = new HashSet<>();

            rep.add(2);
            rep.add(7);
            rep.add(10);
            rep.add(6);
            rep.add(9);
            rep.add(12);
            rep.add(11);

            int res = 1;
            for (int i = 0; i < s.length(); i++) {

                char ch = s.charAt(i);

                if (ch == 'c') {
                    res = res * 2;
                    res %= mod;
                }

                if (ch == 'g') {
                    res = res * 2;
                    res %= mod;
                }

                if (ch == 'l') {
                    res = res * 2;
                    res %= mod;
                }

                if (ch == 'r') {
                    res = res * 2;
                    res %= mod;
                }

                // if(vow.contains(ch)) continue;

            }

            System.out.println(res);
        }
    }
}
