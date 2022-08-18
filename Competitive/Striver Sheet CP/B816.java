import java.util.*;

public class B816 {

    
    public static void main(String[] args) {
        
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int k = scn.nextInt();
        int q = scn.nextInt();
        int[] freq = new int[200005];

        while(n-->0){

            int l = scn.nextInt();
            int r = scn.nextInt();

            freq[l]++;  // start point
            freq[r+1]--; // break point
        }

        int[] no_of_rem_temp = new int[200005];

        for(int i=1;i<200005;i++){

            freq[i] = freq[i-1] + freq[i];
            if(freq[i]>=k){
                no_of_rem_temp[i] = no_of_rem_temp[i-1] +1;
            }else{
                no_of_rem_temp[i] = no_of_rem_temp[i-1];
            }            
        }

        while(q-->0){
            int l = scn.nextInt();
            int r = scn.nextInt();

            System.out.println(no_of_rem_temp[r]-no_of_rem_temp[l-1]);
        }
    }
}

