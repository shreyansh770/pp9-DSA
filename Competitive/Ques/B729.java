import java.util.*;
import java.io.*;

public class B729 {


    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int m = scn.nextInt();

        int[][] s = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                s[i][j] = scn.nextInt();
            }
        }

        int count = 0; 
		for(int i =0;i<n;i++) {
			boolean ans = false;
			for(int j = 0;j<m;j++) {
				if(s[i][j] == 1) ans = true;
				if(ans&&s[i][j]==0) count++;
			}
			ans = false;
			for(int j = m-1;j>=0;j--) {
				if(s[i][j] == 1) ans = true;
				if(ans&&s[i][j]==0) count++;
			}
		}
		for(int i = 0 ;i<m;i++) {
			boolean ans = false;
			for(int j =0;j<n;j++ ) {
				if(s[j][i]==1) ans = true;
				if(s[j][i]==0&&ans) count++;
			}
			ans = false;
			for(int j =n-1;j>=0;j-- ) {
				if(s[j][i]==1) ans = true;
				if(s[j][i]==0&&ans) count++;
			}
		}
		System.out.println(count);

    }

}
