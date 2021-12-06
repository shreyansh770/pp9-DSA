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

        HashMap<Integer, Integer> freq = new HashMap<>(); // try with freq array it will be fast
        int count = 0;
        int ans = 0;

        while (ei < n) {
            if (freq.containsKey(nums[ei]) == false) {
                count++;
            }

            freq.put(nums[ei], freq.getOrDefault(nums[ei], 0) + 1);
            ei++;
            while (count > k) {
                if (freq.get(nums[si]) == 1) {
                    count--;
                }

                freq.put(nums[si], freq.get(nums[si]) - 1);

                if (freq.get(nums[si]) == 0) {
                    freq.remove(nums[si]);
                }

                si++;
            }

            ans += (ei - si); // ei increase ya si decrease hone se ei -si new subarrys add honge (dry
                              // run->array_str_03)
        }

        return ans;

    }

    public int subarraysWithKDistinct(int[] nums, int k) {

        return subarraysWithAtmostKDistinct(nums, k) - subarraysWithAtmostKDistinct(nums, k - 1);
    }

    // 1248

    public int numberOfSubarraysWithAtmostK(int[] nums, int k) {
        int si = 0, ei = 0;
        int count = 0;

        int n = nums.length;
        int ans = 0;
        while (ei < n) {

            if (nums[ei] % 2 != 0)
                count++;

            ei++;

            while (count > k) {
                if (nums[si] % 2 != 0)
                    count--;

                si++;
            }

            ans += (ei - si);

        }

        return ans;
    }

    public int numberOfSubarrays(int[] nums, int k) {

        return numberOfSubarraysWithAtmostK(nums, k) - numberOfSubarraysWithAtmostK(nums, k - 1);

    }

    // 239

    // nlogn
    public int[] maxSlidingWindow(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return nums[b] - nums[a];
        });

        int n = nums.length;

        int[] ans = new int[n - k + 1];// jitne ending pts utne max elements

        int idx = 0;

        for (int i = 0; i < n; i++) { // i is the ending pnt of window
            // top pe jo element hai agr vo window se bhar h
            while (pq.size() > 0 && pq.peek() <= i - k) {
                pq.remove();
            }

            pq.add(i);

            if (i >= k - 1) {
                ans[idx++] = nums[pq.peek()];
            }

        }
        return ans;
    }

    // n
    public int[] maxSlidingWindow_(int[] nums, int k) {

        int n = nums.length;

        int[] arr = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();

        int idx = 0;

        for (int i = 0; i < n; i++) {

            // check whether the top element is in the window or not

            while (dq.size() != 0 && dq.peek() <= i - k) {
                dq.remove();
            }

            // check that all the previous elemt in
            // dq are greater than me so that we can maintain the max at the top
            // if not keep removing
            while (dq.size() > 0 && nums[dq.peekLast()] <= nums[i]) {
                dq.removeLast();
            }

            dq.addLast(i);

            if (i >= k - 1) {
                arr[idx++] = nums[dq.peek()];
            }
        }

        return arr;

    }

    // 904

    public int totalFruit(int[] fruits) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int si = 0;
        int ei = 0;
        int count = 0;
        int max = 0;
        int n = fruits.length;

        while (ei < n) {

            if (!map.containsKey(fruits[ei])) {
                map.put(fruits[ei], 0);
                count++;
            }

            int frq = map.get(fruits[ei]);
            map.put(fruits[ei], frq + 1);
            ei++;

            while (count > 2) {

                if (map.get(fruits[si]) == 1)
                    count--;

                int fs = map.get(fruits[si]);
                map.put(fruits[si], fs - 1);
                if (map.get(fruits[si]) == 0)
                    map.remove(fruits[si]);
                si++;

            }

            // System.out.print(count);
            max = Math.max(max, ei - si);

        }

        return max;
    }

    // 930
    public int numSubarraysWithSum_(int[] nums, int goal) {

        int si = 0;
        int ei = 0;
        int n = nums.length;
        int sum = 0;
        int ans = 0;
        while (ei < n) {

            sum += nums[ei];

            ei++;

            while (sum > goal) {
                sum -= nums[si];
                si++;
            }

            ans += ei - si;

        }

        return ans;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {

        return numSubarraysWithSum_(nums, goal) - (goal == 0 ? 0 : numSubarraysWithSum_(nums, goal - 1));
    }

    // 485
    public int findMaxConsecutiveOnes(int[] nums) {

        int ei = 0;
        int si = 0;
        int n = nums.length;
        int max = -(int) 1e9;
        int count = 0; // count of 0's

        while (ei < n) {
            if (nums[ei] == 0)
                count++;

            ei++;

            while (count > 0) {
                if (nums[si] == 0)
                    count--;

                si++;
            }

            max = Math.max(max, ei - si);
        }

        return max;

    }

    // https://www.lintcode.com/problem/883/

    // subarray with allones and one zero
    public int findMaxConsecutiveOnes_(int[] nums) {

        int ei = 0;
        int si = 0;
        int n = nums.length;
        int max = -(int) 1e9;
        int count = 0; // count of 0's

        while (ei < n) {
            if (nums[ei] == 0)
                count++;

            ei++;

            // we can keep one 0
            while (count > 1) {
                if (nums[si] == 0)
                    count--;

                si++;
            }

            max = Math.max(max, ei - si);
        }

        return max;

    }

    // 1004

    // subarray with allones and k zero
    public int longestOnes(int[] nums, int k) {

        int ei = 0;
        int si = 0;
        int n = nums.length;
        int max = -(int) 1e9;
        int count = 0; // count of 0's

        while (ei < n) {
            if (nums[ei] == 0)
                count++;

            ei++;

            // we can keep one 0
            while (count > k) {
                if (nums[si] == 0)
                    count--;

                si++;
            }

            max = Math.max(max, ei - si);
        }

        return max;

    }

    public int subarraysDivByK(int[] nums, int k) {

        int[] rem_count = new int[k];

        int sum = 0;
        int ans = 0;
        rem_count[0] = 1; // if rem == 0 than we have to include there will be subarray from i=0 till that
                          // point
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            sum %= k;// if sum>=2k

            int rem = (sum + k) % k;// if sum is neg

            ans += rem_count[rem];
            rem_count[rem]++;
        }

        return ans;
    }

    public boolean checkSubarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>(); // rem v/s first index of that rem;

        int sum = 0;
        map.put(0, -1); // it rem it 0 we have to include first elem also
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            sum %= k;

            int rem = (sum + k) % k;

            if (map.containsKey(rem)) {
                if (i - map.get(rem) >= 2)
                    return true;
            } else {
                map.put(rem, i);
            }
        }

        return false;

    }

    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);// agr kahi pe bhi sum zero hota hai iska mtlb ki humko starting se lekar ab tak
                       // sare 1's and 0's cancel ho gye hai

        int sum = 0;
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (nums[i] == 0)
                sum = sum - 1; // jisse ki agr sum == 0 humko pata lag jaye ki eql 1's and 0's ho hye h

            if (map.containsKey(sum)) {
                ans = Math.max(ans, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }

        return ans;
    }

    // https://practice.geeksforgeeks.org/problems/count-subarrays-with-equal-number-of-1s-and-0s-1587115620/1

    // KADANE ALGO
    public int kadane(int[] nums) {
        int max_sum = -(int) 1e9;
        int csum = 0;

        for (int i = 0; i < nums.length; i++) {
            csum += nums[i];

            max_sum = Math.max(csum, max_sum);

            if (csum < 0) {
                csum = 0;
            }
        }

        return max_sum;
    }

    public int kadanes(int[] arr, int k) {
        int mod = (int) (1e9 + 7);

        long csum = 0;
        long msum = 0;
        int i = 0;

        while (k > 0) {
            while (i < arr.length) {
                csum += arr[i];

                if (csum < 0) {
                    csum = 0;
                }

                msum = Math.max(csum, msum);
                i++;
            }
            i = 0;
            k--;
        }

        return (int) (msum % mod);
    }

    public int kConcatenationMaxSum(int[] arr, int k) {
        int ans_for_2 = 0;
        long mod = (int) (1e9 + 7);

        long arr_sum = 0;
        for (int e : arr) {
            arr_sum += e;
        }

        for (int i = 1; i <= 2; i++) {
            int sum = kadanes(arr, i);

            if (k == i) {
                return sum;
            }

            if (i == 2) {
                ans_for_2 = sum; // kadane of 2
            }
        }

        if (arr_sum < 0) {
            return (int) (ans_for_2 % mod);// if arr_sum is neg than each concatenation will give more and more negtive
                                           // sum => max for k=n will same as kadane of k==1

        }

        int ans = (int) (ans_for_2 + ((k - 2) * (arr_sum) % mod)); // see the notes for explanation yadd rakhio concept
                                                                   // hai

        return Math.max(ans, 0);
    }

    // kadane for returning neg
    public int kadane_neg(int[] arr) {
        int csum = 0;
        int max = -(int) 1e9;

        for (int i = 0; i < arr.length; i++) {

            csum += arr[i];

            max = Math.max(max, csum);

            if (csum < 0)
                csum = 0;
        }

        return max;
    }

    // nice concept
    int maximumSumRectangle(int R, int C, int M[][]) {

        int ans = -(int) 1e9;
        for (int frow = 0; frow < R; frow++) {

            int[] preSum = new int[C];
            for (int mrow = frow; mrow < R; mrow++) {
                for (int col = 0; col < C; col++) {
                    preSum[col] = preSum[col] + M[mrow][col];
                }
                int sum = kadane_neg(preSum);
                ans = Math.max(ans, sum);
            }
        }

        return ans;
    }

    /*************************************/

    public int subArrayCountEqualTotarget(int[] arr, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int csum = 0;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            csum += arr[i];

            if (map.containsKey(csum - target)) {
                count++;
            }

            map.put(csum, map.getOrDefault(csum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {

        int[] nums = { 10, 20, 30, -1, -5, 2, 7, -8, -9 };
        segeregate(nums);
        for (int e : nums)
            System.out.print(e + " ");
    }

}