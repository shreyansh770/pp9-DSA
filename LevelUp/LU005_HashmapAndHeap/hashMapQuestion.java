import java.util.*;

public class hashMapQuestion {
    public int longestConsecutive(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int ele : nums) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }

        int maxL = 0;
        // for(int i=0;i<nums.length;i++){
        // int curr = nums[i];
        // int len = 0;

        // if(map.containsKey(curr-1)) continue;

        // while(map.containsKey(curr)){
        // len ++;
        // curr++;
        // }

        // maxL = Math.max(maxL,len);
        // }

        for (int ele : nums) {

            int prev = ele - 1, next = ele + 1;

            while (map.containsKey(prev))
                map.remove(prev--);
            while (map.containsKey(next))
                map.remove(next++);

            maxL = Math.max(maxL, next - prev - 1);

        }

        return maxL;
    }

    public int numRabbits(int[] answers) {

        int n = answers.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        int minRabbits = 0;
        for (int ele : answers) {

            if (!map.containsKey(ele)) {
                minRabbits += 1 + ele;
                map.put(ele, 1);
            } else {
                map.put(ele, map.get(ele) + 1);
            }

            if (map.get(ele) == ele + 1)
                map.remove(ele);

        }

        return minRabbits;
    }

    public int longestSubsequence(int[] arr, int d) {

        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>(); // ele , longestArithemeticsubsequence length till that ele
        int maxL = 0;
        for (int ele : arr) {
            map.put(ele, map.getOrDefault(ele - d, 0) + 1);
            maxL = Math.max(maxL, map.get(ele));
        }

        return maxL;
    }

    public int[] findDiagonalOrder(List<List<Integer>> nums) {

        HashMap<Integer, LinkedList<Integer>> map = new HashMap<>(); // (r+c) v/s element in that
        int maxDig = 0;
        int len = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                int dig = i + j;
                map.putIfAbsent(dig, new LinkedList<>());
                map.get(dig).addFirst(nums.get(i).get(j));
                len++;
                maxDig = Math.max(maxDig, dig);
            }
        }

        int[] ans = new int[len];
        int idx = 0;
        for (int i = 0; i <= maxDig; i++) {
            LinkedList<Integer> l = map.get(i);
            while (l.size() != 0) {
                ans[idx++] = l.removeFirst();
            }
        }

        return ans;

    }



    public int longestArithSeqLength(int[] nums) {
        
        int n = nums.length;
        HashMap<Integer , Integer>[] dp = new HashMap[n]; //  diff v/s LAS length
        
        for(int i = 0 ; i <n;i++) dp[i] = new HashMap<>();
        
        
        int len = 0;
        for(int i=0;i<n;i++){
            for(int j=i-1;j>=0;j--){
                int diff = nums[i] - nums[j] ;
                
                int currLen =dp[i].getOrDefault(diff,0);
                int newLength = dp[j].getOrDefault(diff,1) + 1;
                
                dp[i].put(diff,Math.max(currLen , newLength));
                len = Math.max(len , dp[i].get(diff));
            }
        }
        
        return len;
    }

    public boolean canReorderDoubled(int[] arr) {
        
        int n = arr.length;
        Integer[] ARR = new Integer[n]; // made array of class Integer bcoz we have do custom sort which ask for class obj as a paramter
            
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(arr[i] , map.getOrDefault(arr[i],0)+1);
            ARR[i] = arr[i];
        }
        
        
        // WHY WE DID SORTING DRY RUN ON 8 4 2 1
        Arrays.sort(ARR,(a,b)->{
            return Math.abs(a) - Math.abs(b); // sorting irrespective of -/+ bcoz then we will just have to check for 2 * ele otherwise for - we will have to chek for ele/2
        });
        
        
        for(int ele : ARR){
            if(map.get(ele) == 0) continue;
            
            if(map.getOrDefault(2 * ele ,0) <=0) return false;
            
            map.put(ele , map.get(ele)-1);
            map.put(2 *ele , map.get(2*ele)-1);
        }
        
        
        return true;
         
        
    }
}
