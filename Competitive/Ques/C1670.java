import java.util.*;


public class C1670 {
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int t = scn.nextInt();

        while(t-->0){
            int n = scn.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            int[] c = new int[n];

            for(int i=0;i<n;i++){
                a[i] = scn.nextInt();
            }

            for(int i=0;i<n;i++){
                b[i] = scn.nextInt();
            }

            for(int i=0;i<n;i++){
                c[i] = scn.nextInt();
            }
        }
    }
}
