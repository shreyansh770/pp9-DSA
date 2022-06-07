import java.util.ArrayList;

public class q1 {
    
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        // PREFIX SUM + SLIDING WINDOW

        // int n = arr.length;
        int[] psum = new int[n];

        psum[0] = arr[0];

        for(int i=0;i<n;i++){
          psum[i] = arr[i] + psum[i-1];
        }

        int si = 0;
        int ei = 0;


        int sum = 0;

        ArrayList<Integer> res = new ArrayList<>();
        while(ei<n){

            sum += arr[ei];

            if(sum==s){
                res.add(si);
                res.add(ei);
                return res;
            }else if(sum<s){
                ei++;
            }else{

                while(sum>s){
                    sum -= arr[si];
                    si++;
                }

                if(sum==s){
                    res.add(ei);
                    res.add(si);

                    return res;
                }

                ei++;
            }

        }

        res.add(-1);
        return res;
    }
}
