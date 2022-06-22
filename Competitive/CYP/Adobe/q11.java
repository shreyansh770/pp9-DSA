public class q11 {
    public String amendSentence(String s) {

        StringBuilder sb = new StringBuilder();

        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if ('A' <= ch && ch <= 'Z') {

                if (i > 0) {
                    sb.append(str.toString());
                    sb.append(" ");
                }

                str = new StringBuilder();
                str.append(Character.toLowerCase(ch));
                continue;
            }

            str.append(ch);
        }

        sb.append(str.toString());
        return sb.toString();
    }
}
