import java.util.*;

public class a{
    
        public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);
            int t = scn.nextInt();
            int n = scn.nextInt();
            
            int[] arr = new int[n];
            // HashMap<Integer>
            for(int i=0;i<n;i++){
                arr[i] = scn.nextInt();
            }
            
            Arrays.sort(arr);
            int cnt = 0;
            for(int i=0;i<n;i++){
                int f = t - arr[i];
                if(f>0){
                    for(int j=i+1;j<n;j++){
                        if(arr[j]==f) cnt++;
                    }
                }
            }
            
            System.out.print(cnt);
            
        }
    
}