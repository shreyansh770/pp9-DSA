import java.util.*;
//https://www.geeksforgeeks.org/place-k-elements-such-that-minimum-distance-is-maximized/
public class Gfg1 {
    
    public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);

            int n = scn.nextInt();
            int[] a = new int[n];

            for(int i=0;i<n;i++){
                a[i] = scn.nextInt();
            }

            int k = scn.nextInt();

            Arrays.sort(a);

            int low = 0;
            int high = a[n-1]-a[0];
            int res = 0;
            while(low<=high){

                int mid = (low+high)/2;
                
                int count =1;
                int curr = a[0];

                for(int i=1;i<n;i++){

                    if(a[i]-curr>=mid){
                        count++;
                        curr = a[i];
                    }

                    if(count==k) break;
                    
                }

                if(count>=k){
                    res= mid;
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }

            System.out.println(res);
            
    }
}
