import java.util.LinkedList;

public class client {

    public static void stackBehaviourUsingLL() {
        LinkedList<Integer> st = new LinkedList<>();

        for (int i = 1; i <= 10; i++) {
            st.addFirst(i * 10);
        }

        while (st.size() != 0) {
            System.out.println(st.removeFirst());
        }
    }

    public static void dynamicStack() throws Exception {
        dynamicStack st = new dynamicStack(10);

        for (int i = 1; i <= 110; i++) {
                st.push(i * 10);
        }

        System.out.println(st);
        while (st.size() != 5) {
            System.out.println(st.pop());
        }
    }

    public static void main(String[] args) throws Exception {
        // stack st = new stack();

        dynamicStack();

    }
}
