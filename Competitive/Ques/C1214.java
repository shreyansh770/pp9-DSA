import java.util.*;
public class C1214 {
    

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        String s = scn.next();

        int ucc = 0;

        LinkedList<Integer> st  =new LinkedList<>();
        st.addFirst(-1);

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);

            if(ch==')' && st.getFirst()!=-1  && s.charAt(st.getFirst())=='('){
                st.removeFirst();
            }else if(ch=='('){
                 st.addFirst(i);
            }else{
                ucc++;
            }
        }

        if(ucc==0 && st.getFirst()==-1){
            System.out.println("YES");
        }else if(ucc==0 && st.getFirst()!=-1){
            System.out.println("NO");
        }
        else{
            if(ucc==1 && st.getFirst()!=-1 &&  st.size()==2 && s.charAt(st.getFirst())=='('){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }

    }
}
