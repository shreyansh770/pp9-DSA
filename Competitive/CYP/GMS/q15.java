import java.util.HashMap;
import java.util.Scanner;

public class q15 {
    public boolean canPair(int[] arr, int k) {

        if(arr.length%2!=0) return false;
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i : arr){
            int rem = (i%k + k)%k;
            map.put(rem,map.getOrDefault(rem,0)+1);
        }
        
        
        for(int i : arr){
            
            int rem = (i%k + k)%k;
            
            // System.out.print(rem+" ");
            // System.out.print(rem + " "+map.get(rem) + " "+ (k-rem)+" "+ map.get(k-rem)+", ");

            
            if(rem == 0){
                if(map.get(rem)%2!=0) return false;
            }else if(map.get(rem)!=map.get(k-rem)){
                
                return false;
            }
            
        }
        
        return true;
        

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }

        int k = scn.nextInt();

        System.out.println(canPair(arr, k));
    }
}
