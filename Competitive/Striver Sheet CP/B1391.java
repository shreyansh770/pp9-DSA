import java.util.*;

public class B1391{
    // changing last rows as R
    // changing last col as D
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int t = scn.nextInt();

        while(t-->0){
            int n = scn.nextInt();
            int m =scn.nextInt();

            char[][] c = new char[n][m];

            for(int i=0;i<n;i++){
                String data = "";
                if(scn.hasNext()){
                    data = scn.next();
                }
                for(int j=0;j<m;j++){
                    c[i][j] = data.charAt(j);
                }
            }

            int count = 0;
            for(int i=0;i<n-1;i++){
                if(c[i][m-1]=='R'){
                    count++;
                }
            }

            for(int j=0;j<m-1;j++){
                if(c[n-1][j]=='D'){
                    count++;
                }
            }

            System.out.println(count);
        }
    }
}