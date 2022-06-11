public class q6 {
    static ArrayList <Integer> max_of_subarrays(int nums[], int n, int k)
    {
        // Your code here
        //  int n = nums.length;

        //  int[] arr = new int[n-k+1];
        ArrayList<Integer> res = new ArrayList<>();
         Deque<Integer> dq = new ArrayDeque<>();

         int idx = 0;

         for(int i=0;i<n;i++){

            // check whether the top element is in the window or not

            while(dq.size()!=0 && dq.peek() <=i-k){
                dq.remove();
            }

            // check that all the previous elemt in 
            // dq are greater than me so that we can maintain the max at the top
            // if not keep removing
            while(dq.size() > 0 && nums[dq.peekLast()] <=nums[i]){
                 dq.removeLast();
            }


            dq.addLast(i);

            if(i>=k-1){
                res.add(nums[dq.peek()]);
            }
         }
        
        return res;
    }

    
}
