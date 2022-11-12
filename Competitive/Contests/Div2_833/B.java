import java.util.*;
import java.io.*;

public class B {

    // public static boolean isValid(String s){

    // HashMap<Character,Integer> m = new HashMap<>();
    // HashSet<Character> set = new HashSet<>();

    // for(int i=0;i<s.length();i++){
    // char ch = s.charAt(i);
    // set.add(ch);
    // m.put(ch, m.getOrDefault(ch, 0)+1);
    // if(m.get(ch)>set.size()) return false;
    // }

    // return true;

    // }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int t = scn.nextInt();

        while (t-- > 0) {
            int n = scn.nextInt();

            String s = scn.next();

            int count = 0;
            for (int i = 0; i < n; i++) {

                int[] d = new int[10];
                int unq = 0;
                for (int j = i; j < Math.min(n, i + 100); j++) {

                    unq += d[s.charAt(j) - '0'] == 0 ? 1 : 0;
                    d[s.charAt(j) - '0']++;

                    boolean flag = false;
                    for (int k = 0; k < 10; k++) {
                        if (d[k] > unq) {
                            flag = true;
                            break;
                        }
                    }

                    if (!flag)
                        count++;
                }
            }

            System.out.println(count);

        }
    }
}