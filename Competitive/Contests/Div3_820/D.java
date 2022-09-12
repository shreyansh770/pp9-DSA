import java.util.*;

public class D {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int t  =scn.nextInt();

        while(t-->0){

            int n = scn.nextInt();

            int[] a = new int[n];
            int[] b = new int[n];

            for(int i=0;i<n;i++){
                a[i] = scn.nextInt();
            }

            for(int i=0;i<n;i++){
                b[i] = scn.nextInt();
            }

            int[] c = new int[n];

            for(int i=0;i<n;i++){
                c[i] = b[i] - a[i];
            }

            Arrays.sort(c);

            int i=0;
            int j = n-1;

            int cnt = 0;
            while(i<j){

                if(c[i]+c[j]>=0){
                    cnt++;
                    i++;
                    j--;
                }
                else i++;
            }
            System.out.println(cnt);
        }
    }
}
