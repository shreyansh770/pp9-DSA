import java.util.LinkedList;

public class q9 {


    // so this is not pattern problem in which we have to check for the pattern

    // Treat D as increasing from behind so for that we have kept a stack


    static String printMinNumberForPattern(String S) {

        LinkedList<Integer> st = new LinkedList<>();
        int num = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {

            char ch = S.charAt(i);

            if (ch == 'I') {

                st.addFirst(num);
                num++;
                while (st.size() != 0) {
                    sb.append(st.removeFirst());
                }

            } else {
                st.addFirst(num++);
            }
        }

        st.addFirst(num);

        while(st.size()!=0){
            sb.append(st.removeFirst());
        }

        return sb.toString();
    }
}
