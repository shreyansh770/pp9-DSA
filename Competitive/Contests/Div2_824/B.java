import java.util.*;

public class B {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int t = scn.nextInt();

        while(t-->0){
            int n = scn.nextInt();

            int[] arr = new int[n];

            for(int i=0;i<n;i++){
                arr[i] = scn.nextInt();
            }

            Arrays.sort(arr);

            int min = arr[0];
            double step = 0;
            for(int i=n-1;i>0;i--){

                if(arr[i]<2*min) continue;
                double parts = Math.ceil(1.0*arr[i]/(2*min-1)*1.0);
                // System.out.println(parts);
                step+=parts-1;

                
            }

            System.out.println((int)step);
        }
    }
}
