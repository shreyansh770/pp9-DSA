import java.util.*;
import java.io.*;

public class C {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int t = scn.nextInt();

        while (t-- > 0) {

            char[][] arr = new char[8][8];

            boolean flag = true;
            for (int i = 0; i < 8; i++) {
                String s = scn.next();
                for (int j = 0; j < 8; j++) {
                    arr[i][j] = s.charAt(j);
                }
            }

            for (int i = 0; i < 8; i++) {

                int r = 0;
                for (int j = 0; j < 8; j++) {
                    if (arr[i][j] == 'R')
                        r++;
                }

                if(r==8){
                    System.out.println("R");
                    flag = false;
                    break;
                }
           }

           if(flag){
               System.out.println("B");
           }

        }
    }
}
