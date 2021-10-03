package Construction;


public class client {
    public static void main(String[] args) throws Exception {
        DynamicStack st  = new DynamicStack(6);
        // st.push(1);
        for(int i=0;i<10;i++){
            st.push(i*10);
        }

        st.displayStack();
    }
}
