import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C5 {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) {

        FastReader fs = new FastReader();

        String s = fs.next();

        HashMap<Integer, Integer> map = new HashMap<>();

        LinkedList<Integer> st = new LinkedList<>();
        st.addFirst(-1);
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == ')' && st.getFirst() != -1 && s.charAt(st.getFirst()) == '(') {
 
                st.removeFirst();
                int len = i - st.getFirst();
                maxLen = Math.max(len, maxLen);
                // System.out.print(i+"->"+maxLen+" ");
                if (!map.containsKey(len)) {
                    map.put(len, 1);
                } else {
                    int f = map.get(len);
                    f += 1;
                    map.put(len, f);
                }
            }else{
                st.addFirst(i);
            }
        }

        if(maxLen == 0){
            System.out.println(0+" "+1);
            return;
        }

        int f = map.get(maxLen);
        // System.out.println(f);
        System.out.println(maxLen +" "+f);
    }
}
