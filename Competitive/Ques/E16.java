import java.util.*;
import java.io.*;
public class E16 {
    public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);

            int n = scn.nextInt();
            double[][] a = new double[n][n];

            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){

                    a[i][j] = scn.nextDouble();
                    
                }
            }
    }
}
