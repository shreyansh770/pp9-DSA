import java.util.*;

public class q5 {
    public static int[] calculateSpan(int price[], int n) {
        // Your code here
        int[] ans = new int[n];

        LinkedList<Integer> st = new LinkedList<>();

        st.addFirst(-1);

        for(int i=0;i<price.length;i++){
            while(st.getFirst()!=-1 && price[i] >= price[st.getFirst()]){
                     st.removeFirst();
            }
                 
            ans[i] = i - st.getFirst();
            

            st.addFirst(i);
        }
        

        return ans;
    }
}


