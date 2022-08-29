import java.util.*;

public class F1669 {
    

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int t  =scn.nextInt();

        while(t-->0){
            int n  = scn.nextInt();

            int[] w = new int[n];

            for(int i=0;i<n;i++){
                w[i] = scn.nextInt();
            }

            int[] pre = new int[n];
            pre[0] = w[0];
            for(int i=1;i<n;i++){
                 pre[i] = pre[i-1] + w[i];
            }

            int[] suff = new int[n];
            suff[n-1] = w[n-1];

            for(int i=n-2;i>=0;i--){
                suff[i] = suff[i+1] + w[i];
            }

            int i = 0;
            int j = n-1;

            int no_of_c = 0;
            while(i<j){

                if(pre[i]==suff[j]){
                   no_of_c = (n-j) + (i+1);
                    i++;
                    j--;
                }else if(pre[i]>suff[j]){
                     j--;
                }else{
                    i++;
                }
            }

            System.out.println(no_of_c);
        }
    }
}
