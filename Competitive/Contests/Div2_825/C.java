import java.util.*;
public class C{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int t = scn.nextInt();

        while(t-->0){
            int n = scn.nextInt();

            int[] a = new int[n];

            for(int i=0;i<n;i++){
                a[i] = scn.nextInt();
            }

            long res = 0;

            int i=0;
            int j=0;

            int idx = 1;

            while(j<n){

                if(a[j]>=idx){
                    res+=(j-i+1);
                    j++;
                    idx++;
                }else{
                    i++;
                    idx--;

                }
            }

            System.out.println(res);
        }
    }
}
