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

                else
                    st.removeFirst();
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

    public static void nextGreater(int[] arr) {

    }

    public static void celebrityProb(int[][] arr) {
        int celeb = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (celeb != i && arr[celeb][i] == 1) {
                celeb = i;
            }
        }

        for (int i = 0; i < n; i++) {
            if (celeb == i)
                continue;
            if ((arr[celeb][i] == 1) || (arr[i][celeb] == 0)) {
                System.out.println("none");
                return;
            }
        }

        System.out.println(celeb);
    }

    public static void mergeIntervals(int[][] arr){

      Arrays.sort(arr,(a,b)->{
            return a[0] - b[0];//default behaviour (increasing)
            //return b[0] - a[0] // opposite of default behaviour (decreasing)
      });

      LinkedList<int[]> st = new LinkedList<>();
        
      for(int[] a :arr){
          int minStartTime = a[0];
          int maxEndTime = a[1];
          while(st.size()!=0 && a[0] <= st.getFirst()[1]){
              minStartTime = st.getFirst()[0];
              maxEndTime = Math.max(maxEndTime, st.getFirst()[1]);
              st.remove();
          }
          
          st.addFirst(new int[] {minStartTime , maxEndTime});
      }
      
      while(st.size()!=0){
          int[] a = st.removeLast();
          System.out.println(a[0] + " "+a[1]);

    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        String str = scn.nextLine();

        removeDuplicates(str);
    }
}
