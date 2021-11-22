import java.util.*;

public class l002 {

    public void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;

        int rot = (k % n + n) % n; // for both negative and positive k

        // reverse 0->n-rot-1

        reverse(nums, 0, n - rot - 1);
        // reverse n-rot->n
        reverse(nums, n - rot, n - 1);

        // reverse complete
        reverse(nums, 0, n - 1);
    }

    // segregate neg and pos

    public static void segeregate(int[] nums) {
        int n = nums.length;
        int neg_ptr = -1;
        int ptr = 0;

        while (ptr < n) {
            if (nums[ptr] < 0) {
                neg_ptr++;
                int temp = nums[neg_ptr];
                nums[neg_ptr] = nums[ptr];
                nums[ptr] = temp;
            }

            ptr++;
        }
    }

    // segregate 0 and 1

    public static void segeregate01(int[] nums) {
        int n = nums.length;
        int zero_ptr = -1;
        int ptr = 0;

        while (ptr < n) {
            if (nums[ptr] == 0) {
                zero_ptr++;
                int temp = nums[zero_ptr];
                nums[zero_ptr] = nums[ptr];
                nums[ptr] = temp;
            }

            ptr++;
        }
    }

    // sort 0,1,2
    public void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }

    public void sortColors(int[] nums) {

        int n = nums.length;

        int p1 = -1, p2 = 0, p3 = n - 1;

        // Regions -> [0,p1]->0's ; [p1+1,p2-1]->1's ; [p2,p3]->undef ; [p3+1,n-1]-> 2's

        while (p2 <= p3) {

            if (nums[p2] == 2) {
                swap(nums, p2, p3);
                p3--;
            } else if (nums[p2] == 0) {
                p1++;
                swap(nums, p1, p2);
                p2++;
            } else {
                p2++;
            }
        }
    }

    int max_sum(int A[], int n) {
        int total_sum = 0;
        int csum = 0;

        for (int i = 0; i < n; i++) {
            total_sum += A[i];
            csum += A[i] * i;
        }

        // i = 1 bcoz we have already calculated for i = 0 ie csum
        int max = csum;
        for (int i = 1; i < n; i++) {
            int nsum = csum - (total_sum) + n * A[i - 1];
            csum = nsum;

            max = Math.max(csum, max);
        }

        return max;
    }

    public int maxArea(int[] height) {

        int p1 = 0;
        int p2 = height.length - 1;

        int maxWater = 0;

        while (p1 < p2) {
            int area = Math.min(height[p1], height[p2]) * (p2 - p1);

            // Moving the min(p1,p2) boz if we move the max the height will still remain the
            // min of p1 and p2 and that would not affect our area
            if (height[p1] > height[p2])
                p2--;
            else
                p1++;

            maxWater = Math.max(area, maxWater);
        }

        return maxWater;

    }

    public int lengthOfLongestSubstring(String s) {

        int si = 0;
        int ei = 0;

        int n = s.length();
        int count = 0;// -> no of repeating chars in the window
        int[] frq = new int[128];
        int len = 0;

        while (ei < n) {
            if (frq[s.charAt(ei)] > 0) {
                count++;
            }

            frq[s.charAt(ei)]++;
            ei++;

            while (count > 0) {

                if (frq[s.charAt(si)] == 2) {
                    count--;
                }

                frq[s.charAt(si)]--;
                si++;
            }

            len = Math.max(len, ei - si);

        }

        return len;
    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {

        int si = 0;
        int ei = 0;

        int n = s.length();
        int count = 0;// -> no of distinct characters
        int[] frq = new int[128];
        int len = 0;

        while (ei < n) {
            if (frq[s.charAt(ei)] == 0) {
                count++;
            }

            frq[s.charAt(ei)]++;
            ei++;

            while (count > 2) {

                if (frq[s.charAt(si)] == 1)
                    count--;

                frq[s.charAt(si)]--;
                si++;

            }

            len = Math.max(len, ei - si);
        }

        return len;
    }

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int si = 0;
        int ei = 0;

        int n = s.length();
        int count = 0;// -> no of distinct characters
        int[] frq = new int[128];
        int len = 0;

        while (ei < n) {
            if (frq[s.charAt(ei)] == 0) {
                count++;
            }

            frq[s.charAt(ei)]++;
            ei++;

            while (count > k) {

                if (frq[s.charAt(si)] == 1)
                    count--;

                frq[s.charAt(si)]--;
                si++;

            }

            len = Math.max(len, ei - si);
        }

        return len;
    }

    public String findSubString(String s) {

        int[] fore = new int[128];
        int need = 0;
        int n = s.length();
        for (int i = 0; i < s.length(); i++) {
            if (fore[s.charAt(i)] == 0) {
                fore[s.charAt(i)]++;
                need++;
            }
        }

        int len = (int) 1e9;
        int ssi = 0, eei = 0;
        int si = 0, ei = 0;

        while (ei < n) {

            if (fore[s.charAt(ei)] > 0)
                need--;

            fore[s.charAt(ei)]--;
            ei++;

            // if need==0 we will contract our string until the substring skips any required
            // char that will in turn increase the need
            while (need == 0) {
                if (len > (ei - si)) {
                    len = ei - si;
                    ssi = si;
                    eei = ei;
                }

                if (fore[s.charAt(si)] == 0) {
                    need++;
                }

                fore[s.charAt(si)]++;
                si++;

            }

        }

        return len == (int) 1e9 ? "" : s.substring(ssi, eei);
    }

    public int maxVowels(String s, int k) {

        int si = 0;
        int ei = k;
        int n = s.length();

        int vowelCount = 0;
        for (int i = 0; i < k; i++) {

            char ch = s.charAt(i);

            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowelCount++;
            }

        }

        int ans = vowelCount;

        // ei - si is always maintained as k
        while (ei < n) {

            char ch = s.charAt(ei);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {

                vowelCount++;
            }
            ei++;

            char cs = s.charAt(si);
            if (cs == 'a' || cs == 'e' || cs == 'i' || cs == 'o' || cs == 'u') {
                vowelCount--;
            }
            si++;

            ans = Math.max(vowelCount, ans);

        }

        return ans;
    }


    /****************************************************************/

    public int subarraysWithAtmostKDistinct(int[] nums, int k) {
        
        int n = nums.length;
        int si = 0;
        int ei = 0;

        HashMap<Integer , Integer> freq = new HashMap<>(); // try with freq array it will be fast
        int count = 0;
        int ans = 0;

        while(ei<n){
            if(freq.containsKey(nums[ei]) == false){
                count++;
            }

            freq.put(nums[ei],freq.getOrDefault(nums[ei], 0)+1);
             ei++;
            while(count > k){
                if(freq.get(nums[si]) == 1){
                       count--;
                }

                freq.put(nums[si],freq.get(nums[si])-1);

                if(freq.get(nums[si]) == 0){
                    freq.remove(nums[si]);
                }

                si++;
            }

            ans +=(ei-si); //  ei increase ya si decrease hone se ei -si new subarrys add honge (dry run->array_str_03)
        }

        return ans;

    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        
        return subarraysWithAtmostKDistinct(nums, k) - subarraysWithAtmostKDistinct(nums, k-1);
    }
    

    // 1248

    public int numberOfSubarraysWithAtmostK(int[] nums , int k){
        int si = 0, ei = 0;
        int count = 0;

        int n = nums.length;
         int ans = 0;
        while(ei<n){

            if(nums[ei]%2 != 0) count++;
 
            ei++;

            while(count > k){
                if(nums[si]%2!=0) count--;

                si++;
            }


            ans+= (ei-si);


        }

        return ans;
    }


    public int numberOfSubarrays(int[] nums, int k) {
        
         return numberOfSubarraysWithAtmostK(nums, k) - numberOfSubarraysWithAtmostK(nums,k-1);

    }

    // 239

    // nlogn
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            return nums[b]-nums[a];
        });
        
        int n = nums.length;
        
        int[] ans = new int[n-k+1];// jitne ending pts utne max elements
        
        int idx = 0;
  
        for(int i=0;i<n;i++){ // i is the ending pnt of window
            // top pe jo element hai agr vo window se bhar h
            while(pq.size()>0 && pq.peek()<=i-k){
                pq.remove();
            }
            
            pq.add(i);
            
            if(i>=k-1){
                ans[idx++] = nums[pq.peek()];
            }
            
        }
        return ans;
    }

    // n
    public int[] maxSlidingWindow_(int[] nums, int k) {

         int n = nums.length
    }

    public static void main(String[] args) {

        int[] nums = { 10, 20, 30, -1, -5, 2, 7, -8, -9 };
        segeregate(nums);
        for (int e : nums)
            System.out.print(e + " ");
    }

}