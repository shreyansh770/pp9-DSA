import java.util.*;

public class C {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();

        while (t-- > 0) {
            String s = scn.next();
            HashMap<Character, List<Integer>> map = new HashMap<>();

            for (int i = 0; i < s.length(); i++) {

                if (map.containsKey(s.charAt(i))) {
                    map.get(s.charAt(i)).add(i + 1);
                } else {
                    List<Integer> list = new ArrayList<>();
                    map.put(s.charAt(i), list);
                    map.get(s.charAt(i)).add(i + 1);
                }
            }

            if(s.charAt(0)>s.charAt(s.length()-1)){
                int jump = 0;
                int cst  = Math.abs(s.charAt(0)-s.charAt(s.length()-1));

                int[] path = new int[s.length()];

                for(int i=0;s.charAt(0)+i>=s.charAt(s.length()-1);i--){

                    char ch = s.charAt(0)+i;

                    if(map.containsKey(ch)){}
                }
            }
        }
    }
}
