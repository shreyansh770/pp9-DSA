import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CdPwd {

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

        FastReader s = new FastReader();

        int t = s.nextInt();
        LinkedList<String> path = new LinkedList<>();
        while (t--!=0){
            String cmd = s.nextLine();
            if(cmd.equals("pwd")){
                System.out.print("/");
                for (String directory : path){
                    System.out.print(directory+"/");
                }
                System.out.println();
            }else{
                String[] cmdWords = cmd.split(" ");
                String argument = cmdWords[1];
                if(argument.equals("..")){
                    path.removeLast();
                }else {
                    for(String directory : argument.split("/")){

                        // when ever we are creating new directory we have to give complete path like /a/b so on spliting on "/" we
                        // will get " " as first string which will indicate that we are forming a new path
                        // if we have to add to a peviously existing directory we will give path like c/d which will not give
                        // " " as the first string hence path stack will not get explty
                        if(directory.isEmpty()){
                            path.clear();
                            continue;
                        }
                        if(directory.equals(".."))
                            path.removeLast();
                        else
                            path.add(directory);
                    }
                }
            }
        }

    }
}
