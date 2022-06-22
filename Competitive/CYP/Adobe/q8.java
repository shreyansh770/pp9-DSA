public class q8 {
    int atoi(String str) {
        // Your code here
        for (int i = 0; i < str.length(); i++) {

            if (i == 0 && str.charAt(i) == '-')
                continue;

            if (!Character.isDigit(str.charAt(i))) {
                return -1;
            }
        }
        return Integer.parseInt(str);
    }
}
