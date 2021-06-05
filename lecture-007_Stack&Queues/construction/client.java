import java.util.LinkedList;

public class client {


    public static void stackBehaviourUsingLL(){
            LinkedList<Integer> st = new LinkedList<>();

            for(int i = 1 ; i  <= 10 ; i++)
            {
                st.addFirst(i*10);
            }

            while(st.size() != 0){
                System.out.println(st.removeFirst());
            }
    }



    public static void main(String[] args) throws Exception {
        // stack st = new stack();

         stackBehaviourUsingLL();

    }
}
