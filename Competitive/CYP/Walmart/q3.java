public class q3 {
    public boolean winnerOfGame(String s) {

        int Atriplets = 0;
        int Btriplets = 0;

        int n = s.length();

        for (int i = 1; i < n - 1; i++) {

            char ch = s.charAt(i);

            if (ch == s.charAt(i - 1) && ch == s.charAt(i + 1)) {

                if (ch == 'A') {
                    Atriplets++;
                } else {
                    Btriplets++;
                }

            }

        }

        return Atriplets > Btriplets;
    }
}
