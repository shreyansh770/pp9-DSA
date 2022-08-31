import java.util.*;

public class B {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int t = scn.nextInt();

        while (t-- > 0) {

            int n = scn.nextInt();
            char[][] check = new char[2][n];
            for (int i = 0; i < 2; i++) {
                String s = scn.next();

                for (int j = 0; j < n; j++) {
                    check[i][j] = s.charAt(j);
                }
            }

            boolean valid = false;
            
            for(int j=0;j<n;j++){

                char c1 = check[0][j];
                char c2 = check[1][j];

                if(c1=='G' && c2=='B' || c1=='B' && c2=='G' || c1==c2) continue;

                valid = true;
            }


            if(valid){
                System.out.println("NO");
            }else{
                System.out.println("YES");
            }
            
        }
    }
}