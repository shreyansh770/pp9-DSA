import java.util.*;

public class q14 {
    public int minSubArrayLen(int target, int[] nums) {
        
        int si=0;
        int ei=0;
        
        int n = nums.length;

        int res = (int)1e9;
        int sum = 0;
        while(ei<n){
           
            sum += nums[ei];
            
            while(sum>=target){
                
                res = Math.min(res,ei-si+1);
                
                sum -= nums[si++];
            }
            
            ei++;
        }
        
        return res == (int)1e9 ? 0 : res;
    }
}
