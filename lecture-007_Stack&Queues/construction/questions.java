import java.util.*;

public class questions {
    public static void removeDuplicates(String str) {

        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == ')') {
                if (st.peek() == '(') {
                    System.out.println("true");
                    return;
                } else {
                    while (st.peek() != '(') {
                        st.pop();
                    }
                    st.pop();
                }
            } else {
                st.push(ch);
            }
        }

        System.out.println("false");
        return;
    }

    public static void balanceParenthesis(String str) {

        LinkedList<Character> st = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                st.addFirst(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {

                if (st.size() == 0) {
                    System.out.println("false");
                    return;
                }

                else if (ch == ')' && st.getFirst() != '(') {
                    System.out.println("false");
                    return;
                }

                else if (ch == ']' && st.getFirst() != '[') {
                    System.out.println("false");
                    return;
                }

                else if (ch == '}' && st.getFirst() != '{') {
                    System.out.println("false");
                    return;
                }

                else st.removeFirst();
            }

        }

        if (st.size() != 0) {
            System.out.println("false");
            return;
        } else {
            System.out.println("true");
            return;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        String str = scn.nextLine();

        removeDuplicates(str);
    }
}
