import java.util.*;

public class l002 {

    
    public void reverse(int[] nums , int i , int j){
        while(i<j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;j--;
        }
    }
    
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        
        int rot = ( k % n+ n ) % n; // for both negative and positive k
        
        // reverse 0->n-rot-1
        
        reverse(nums,0,n-rot-1);
        // reverse n-rot->n
        reverse(nums,n-rot,n-1);
        
        // reverse complete
        reverse(nums,0,n-1);
    }


    // segregate neg and pos

    public static segeregate

   public static void main(String[] args) {
       
   }


}