import java.util.*;
public class q3 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int t = scn.nextInt();
        while(t-->0){

            StringBuilder sb = new StringBuilder();

            sb.append(scn.next());

            int max = 10;

            LinkedList<Integer> st = new LinkedList<>();
            LinkedList<Integer> st2 = new LinkedList<>();
            int[] num = new int[10];
            for(int i=sb.length()-1;i>=0;i--){

                int d = sb.charAt(i)-'0';

                // if(d<=max){
                //     num[d]++;
                //     max = d;
                // }else{

                //     if(d==9){
                //         num[9]++;
                //     }else{
                //         num[d+1]++;
                //     }
                // }

                if(st.isEmpty() || d <= st.getFirst()) st.addFirst(d);
                else {

                    while(!st.isEmpty() && d> st.getFirst()){
                        st2.addFirst(st.removeFirst());
                    }

                    if(d!=9)st.addFirst(d+1);
                    else st.addFirst(9);
                    while(!st2.isEmpty()){
                        st.addFirst(st2.removeFirst());
                    }
                }
            }

            StringBuilder res = new StringBuilder();

            // for(int i=0;i<10;i++){
            //     while(num[i]>0){
            //         res.append(i);
            //         num[i]--;
            //     }
            // }

            while(!st.isEmpty()){

                res.append(st.removeFirst());
            }

            System.out.println(res.toString());
        }
    }
}
