import java.util.*;

public class B475 {


    static boolean[][] check;
    static int count;
    public static void dfs(int n , int m ,int i , int j ,char[][] h , char[][] v ) {

        if(i>=n || j>=m ||i<0 || j<0 || check[i][j]) return;

        check[i][j] = true;count++;

        if(h[i][j]=='>') dfs(n,m,i,j+1,h,v);
        else dfs(n,m,i,j-1,h,v);


        if(v[i][j]=='^') dfs(n,m,i-1,j,h,v);
        else dfs(n,m,i+1,j,h,v);

        
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int m = scn.nextInt();

        String hor = scn.next();
        String ver = scn.next();

        char[][] h = new char[n][m];

        char[][] v = new char[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                h[i][j] = hor.charAt(i);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                v[j][i] = ver.charAt(i);
            }
        }

        boolean flag = true;
        outer:for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                    check = new boolean[n][m];
                    count = 0;
                    dfs(n, m, i, j, h, v);
                    if(count!=n*m) {
                        flag = false;
                        break outer;
                    }
            }
        }

        if(!flag)System.out.println("NO");
        else System.out.println("YES");
    }

}
