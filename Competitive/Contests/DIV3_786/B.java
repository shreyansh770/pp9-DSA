import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B {

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

            int t = fs.nextInt();

            while(t-->0){

                String s = fs.next();

                HashMap<String,Integer> map = new HashMap<>();//string ,idx
                
                int idx = 1;
                for(int i=1;i<=26;i++){
                    char one = Character.valueOf((char)(i+96));;

                    for(int j=1;j<=26;j++){
                        if(i==j) continue;

                        char two = Character.valueOf((char)(j+96));

                        String word = one+""+two;
                        map.put(word, idx);
                        idx++;
                    }

                }

                System.out.println(map.get(s));
            }
        }
}
