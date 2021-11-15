
import java.util.*;

public class l001 {
    public int binarySearch(int[] arr, int si, int ei, int data) {

        while (si <= ei) {

            int mid = (si + ei) / 2;
            if (arr[mid] == data) {
                return mid;
            } else if (arr[mid] < data) {
                ei = mid - 1;
            } else {
                si = mid + 1;
            }
        }

        return -1;
    }

    public int firstIndex(int[] arr, int data) {

        int si = 0;
        int ei = arr.length - 1;

        while (si <= ei) {
            int mid = (si + ei) / 2;

            if (arr[mid] == data) {

                if (mid - 1 >= 0 && arr[mid - 1] == data) {
                    ei = mid - 1;
                } else {
                    return mid;
                }

            } else if (arr[mid] < data) {
                si = mid + 1;
            } else {
                ei = mid - 1;
            }
        }

        return -1;

    }

    public int lastIndex(int[] arr, int data) {
        int si = 0;
        int ei = arr.length - 1;

        while (si <= ei) {
            int mid = (si + ei) / 2;

            if (arr[mid] == data) {

                if (mid + 1 < arr.length && arr[mid + 1] == data) {
                    si = mid + 1;
                } else {
                    return mid;
                }

            } else if (arr[mid] < data) {
                si = mid + 1;
            } else {
                ei = mid - 1;
            }
        }

        return -1;
    }

    public int[] searchRange(int[] arr, int target) {

        if (arr.length == 0)
            return new int[] { -1, -1 };

        return new int[] { firstIndex(arr, target), lastIndex(arr, target) };
    }

    // we have to find the closet element of data if data itself is not present
    public int closetIfNotPresent(int[] arr, int data) {

        int si = 0, ei = arr.length - 1;

        if (data < arr[si])
            return si;
        if (data > arr[ei])
            return ei;

        while (si <= ei) {
            int mid = (si + ei) / 2;
            if (arr[mid] == data) {
                return mid;
            } else if (arr[mid] < data) {
                ei = mid - 1;
            } else {
                si = mid + 1;
            }
        }

        return data - arr[ei] < arr[si] - data ? ei : si;

    }

    // we have to find the perfect index to insert data in a sorted array
    /* dry run */
    public int perfectLocation(int[] arr, int data) {
        int si = 0, ei = arr.length; // ei start from size bcoz possible indexs are from 0 to size

        while (si < ei) {
            int mid = (si + ei) / 2;
            if (arr[mid] <= data)
                si = mid + 1;
            else
                ei = mid;
        }

        return ei; // si
    }

    // Inversion count

    public static long totalInversionCount(long[] arr, long[] sortedArray, long si, long mid, long ei) {
        int i = (int) si, j = (int) mid + 1, k = (int) si;
        long count = 0;

        while (i <= mid && j <= ei) {
            if (arr[i] <= arr[j])
                sortedArray[k++] = arr[i++];
            else {
                sortedArray[k++] = arr[j++];
                count += mid - i + 1;
            }
        }

        while (i <= mid || j <= ei)
            sortedArray[k++] = arr[i <= mid ? i++ : j++];

        // why...?
        while (si <= ei)
            arr[(int) si] = sortedArray[(int) si++];

        return count;
    }

    public static long inversionCount(long[] arr, long[] sortedArray, long si, long ei) {
        if (si >= ei)
            return 0;

        long mid = (si + ei) / 2;
        long count = 0;

        count += inversionCount(arr, sortedArray, si, mid);
        count += inversionCount(arr, sortedArray, mid + 1, ei);

        count += totalInversionCount(arr, sortedArray, si, mid, ei);
        return count;
    }

    public static long inversionCount(long arr[], long N) {
        if (N == 0)
            return 0;

        long[] sortedArray = new long[(int) N];
        return inversionCount(arr, sortedArray, 0, N - 1);
    }

    // 658

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        List<Integer> ans = new ArrayList<>();
        if (x <= arr[0]) {
            for (int i = 0; i < k; i++) { // K
                ans.add(arr[i]);
            }

            return ans;
        } else if (x >= arr[n - 1]) {

            for (int i = n - k; i < n; i++) {// K
                ans.add(arr[i]);
            }

            return ans;
        }

        int idx = perfectLocation(arr, x);// log(n)
        int si = Math.max(0, idx - k);
        int ei = Math.min(n - 1, idx + k);

        while (ei - si + 1 > k) { // 2K

            if (x - arr[si] > arr[ei] - x)
                si++;

            else
                ei--;
        }

        for (int i = si; i <= ei; i++) {//
            ans.add(arr[i]);
        }

        return ans;
    }

    // 167
    public int[] twoSum(int[] arr, int target) {
        int i = 1, j = arr.length;

        int[] a = new int[2];

        while (i <= j) {
            if (arr[i - 1] + arr[j - 1] < target) {
                i++;
            } else if (arr[i - 1] + arr[j - 1] > target) {
                j--;
            } else {
                a[0] = i;
                a[1] = j;
                break;
            }
        }

        return a;
    }

    // Q find all the unique 'pairs' that sum up to give target

    public List<List<Integer>> allPairs(int[] nums, int SI, int EI, int tar) {

        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        int si = SI, ei = EI;

        while (si < ei) {
            int csum = nums[si] + nums[ei];

            if (csum == tar) {

                List<Integer> sa = new ArrayList<>();

                sa.add(nums[si]);
                sa.add(nums[ei]);

                ans.add(sa);

                si++;
                ei--;
                while (si < ei && nums[si] == nums[si - 1])
                    si++;
                while (si < ei && nums[ei] == nums[ei + 1])
                    ei--;

            } else if (csum < tar) {

                si++;
            } else {

                ei--;
            }
        }

        return ans;
    }

    // 3SUM

    public List<List<Integer>> threeSum(int[] nums, int si, int ei, int tar) {

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = si; i <= ei;) {

            int fix = nums[i];

            List<List<Integer>> res = allPairs(nums, i + 1, ei, tar - fix);

            for (List<Integer> s : res) {
                s.add(fix);
                ans.add(s);
            }

            i++;

            while (i < ei && nums[i] == nums[i - 1])
                i++;

        }

        return ans;

    }

    public List<List<Integer>> threeSum(int[] nums) {

        if (nums.length == 0 || nums.length == 1) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        return threeSum(nums, 0, nums.length - 1, 0);

    }

    // 4SUM

    public List<List<Integer>> fourSum(int[] nums, int si, int ei, int tar) {

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = si; i <= ei;) {
            int fix = nums[i];

            List<List<Integer>> res = threeSum(nums, i + 1, ei, tar - fix);

            for (List<Integer> s : res) {
                s.add(fix);
                ans.add(s);
            }

            i++;
            while (i < ei && nums[i] == nums[i - 1])
                i++;

        }

        return ans;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length == 0 || nums.length == 1) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);

        return fourSum(nums, 0, nums.length - 1, target);

    }

    // K-SUM

    public List<List<Integer>> KSum(int[] nums, int target, int k, int si, int ei) {

        if (k == 2) {
            return allPairs(nums, si, ei, target);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = si; i <= ei;) {
            int fix = nums[si];

            List<List<Integer>> res = KSum(nums, target - fix, k - 1, i + 1, ei);

            for (List<Integer> s : res) {
                s.add(fix);
                ans.add(s);
            }

            i++;

            while (i < ei && nums[i] == nums[i - 1])
                i++;

        }

        return ans;
    }

    // two sum count =================================

    public int twoSumCount(int[] arr1, int[] arr2, int target) {
        int ans = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr1.length; i++) {
            map.put(arr1[i], map.getOrDefault(arr1[i], 0) + 1);
        }

        for (int i = 0; i < arr2.length; i++) {
            int new_target = target - arr2[i];

            if (map.containsKey(new_target)) {
                ans += map.get(new_target);
            }
        }

        return ans;
    }

    // 4sum2

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int e : nums1) {
            for (int f : nums2) {
                map.put(e + f, map.getOrDefault(e + f, 0) + 1);
            }
        }

        int ans = 0;

        for (int e : nums3) {
            for (int f : nums4) {

                if (map.containsKey(0 - (e + f))) {
                    ans += map.get(0 - (e + f));
                }
            }
        }

        return ans;

    }

    // 33

    public int search(int[] arr, int target) {

        int si = 0;
        int ei = arr.length - 1;

        while (si <= ei) {

            int mid = (si + ei) / 2;

            if (arr[mid] == target)
                return mid;

            if (arr[si] <= arr[mid]) {
                if (arr[si] <= target && target < arr[mid]) {
                    ei = mid - 1;
                } else {
                    si = mid + 1;
                }
            } else {
                if (arr[mid] < target && target <= arr[ei]) {
                    si = mid + 1;
                } else {
                    ei = mid - 1;
                }
            }

        }

        return -1;
    }

    // with duplicates
    // tc :- 8,8,8,8,8,8,8,8,7,8,8,8,8,8
    public boolean search_02(int[] arr, int target) {
        int si = 0;
        int ei = arr.length - 1;

        while (si <= ei) {

            int mid = (si + ei) / 2;

            if (arr[mid] == target || arr[si] == target)
                return true;

            if (arr[si] < arr[mid]) {
                if (arr[si] <= target && target < arr[mid]) {
                    ei = mid - 1;
                } else {
                    si = mid + 1;
                }
            } else if (arr[si] > arr[mid]) {
                if (arr[mid] < target && target <= arr[ei]) {
                    si = mid + 1;
                } else {
                    ei = mid - 1;
                }
            } else {
                si++;
            }

        }

        return false;
    }

    public boolean search_03(int[] arr, int target) {
        int si = 0;
        int ei = arr.length - 1;

        while (si <= ei) {

            int mid = (si + ei) / 2;

            if (arr[mid] == target || arr[si] == target || arr[ei] == target)
                return true;

            if (arr[si] < arr[mid]) {
                if (arr[si] <= target && target < arr[mid]) {
                    ei = mid - 1;
                } else {
                    si = mid + 1;
                }
            } else if (arr[si] > arr[mid]) {
                if (arr[mid] < target && target <= arr[ei]) {
                    si = mid + 1;
                } else {
                    ei = mid - 1;
                }
            } else {
                si++;
                ei--;
            }

        }

        return false;
    }

    public int findMin(int[] nums) {

        int n = nums.length;

        int si = 0;
        int ei = n - 1;

        while (si < ei) {

            int mid = (si + ei) / 2;

            if (nums[mid] < nums[ei]) {
                ei = mid;
            } else {// si se mid sorted h
                si = mid + 1;
            }
        }

        return nums[si];
    }

    // with duplicates
    public int findMin_02(int[] nums) {
        int n = nums.length;

        int si = 0;
        int ei = n - 1;

        while (si < ei) {

            int mid = (si + ei) / 2;

            if (nums[mid] < nums[ei]) {
                ei = mid;
            } else if (nums[mid] > nums[ei]) {// si se mid sorted h
                si = mid + 1;
            } else {
                ei--;
            }
        }

        return nums[si];
    }

    /* Binary search application question */

    public boolean isPossible(int curr, int[] piles, int h) {

        int totalHours = 0;

        for (int e : piles) {
            int time = e / curr;

            if (e % curr != 0) {
                time++; // upper limit
            }

            totalHours += time;

            if (totalHours > h)
                return false;
        }

        return true;
    }

    public int minEatingSpeed(int[] piles, int h) {

        int si = 1, ei = (int) 1e9;

        while (si <= ei) {

            int mid = (si + ei) / 2;

            if (!isPossible(mid, piles, h)) {
                si = mid + 1;
            } else {
                ei = mid - 1;
            }
        }

        return si;
    }

    public boolean isPossible_(int w, int[] weights, int days) {

        int wsf = 0;
        int dsf = 0;
        for (int e : weights) {
            wsf += e;

            if (e > w)
                return false;
            if (wsf > w) {
                dsf++;
                wsf = e;
            }

            if (dsf > days) {
                return false;
            }
        }

        dsf++;

        return dsf <= days;
    }

    public int shipWithinDays(int[] weights, int days) {

        int si = 1, ei = (int) 1e9;

        while (si <= ei) {

            int mid = (si + ei) / 2;

            if (!isPossible_(mid, weights, days)) {
                si = mid + 1;
            } else {
                ei = mid - 1;
            }

        }

        return si;
    }

    public boolean isPos(double mid, double[] area, int guests) {
        int guest = 0;

        for (double a : area) {
            guest += a / mid;

            if (guest > guests)
                return true;
        }

        return false;
    }

    public double maxAreaServingCake(int[] arr, int guest) {

        int n = arr.length;
        double[] area = new double[n];
        double si = 0, ei = 0;
        for (int i = 0; i < n; i++) {
            double a = arr[i] * 3.14 * arr[i];
            area[i] = a;
            ei = Math.max(ei, a);
        }

        while (si < ei) {
            double mid = (si + ei) / 2;

            if (isPos(mid, area, guest)) {
                si = mid + 0.1;
            } else {
                ei = mid;
            }
        }

        return si;
    }


    // time -> O(n+m) space-> O(n+m)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int m = nums2.length;
        int[] ans = new int[n + m];
        int midx = 0;

        int i = 0, j = 0, k = 0;

        while (i < n && j < m) {

            if (nums1[i] <= nums2[j]) {
                ans[k] = nums1[i++];
            } else if (nums1[i] > nums2[j]) {
                ans[k] = nums2[j++];
            }

            if (k == (n + m) / 2)
                midx = k;
            k++;
        }

        while (i < n) {
            ans[k] = nums1[i++];
            if (k == (n + m) / 2)
                midx = k;
            k++;
        }

        while (j < m) {
            ans[k] = nums2[j++];
            if (k == (n + m) / 2)
                midx = k;
            k++;
        }

        if ((n + m) % 2 == 0) {
            System.out.println(midx);
            return ((ans[midx] + ans[midx - 1]) * 1.0) / 2 * 1.0;
        } else {
            System.out.println(midx);
            return ans[midx];
        }
    }


    // Time -> log(min(n,m))
    public double findMedianSortedArrays_(int[] nums1, int[] nums2) {
        
        
        int n1 = nums1.length;
        int n2 = nums2.length;
        
        if(n1 > n2){
            // mid might become larger than n2 so bmid will become negative
            
            return findMedianSortedArrays_(nums2,nums1);
        }
        
        
        int total = n1 + n2;
        
        int si = 0;
        int ei = n1; // partition last element se bhi ho skta hai
        
        while(si<=ei){
            
            int mid = (si+ei)/2;
            
            int bmid = ((total+1)/2) - mid;
            
            int al = (mid == 0 ? -(int)1e9 : nums1[mid-1]);
            int ar = (mid == n1 ? (int)1e9  : nums1[mid] );
            
            int bl = (bmid == 0 ? -(int)1e9 : nums2[bmid-1]);
            int br = (bmid == n2 ? (int)1e9  : nums2[bmid]);
            
            if(bl <= ar && al<=br){
                
                if(total%2 == 0){
                    
                    return ((Math.max(al,bl) + Math.min(ar,br))*1.0)/(2*1.0);

                }else{
                    return Math.max(al,bl) *1.0;
                }
            }
            
            
            if(bl>ar){
                si = mid+1;// ar tak to sare elements aenge he
            }
            
            if(al>br){
                ei = mid-1; // [ar,n-1] will not come
            }
        }
        
        return -1;
    }


    public boolean distribution(int[] q ,int n,int nop){
        
        
        for(int p : q){
            
            int store = p/nop;
            if(p%nop!= 0) store++;
            
            n-=store;
            
        }
        
        return n>=0; // n>0 because some stores can get 0 items too
        
    }
    
    public int minimizedMaximum(int n, int[] quantities) {
       
        int si = 1;
        int ei = 1;
        
        for(int e : quantities) ei = Math.max(ei , e);
        
        while(si<=ei){
            int mid = (si+ei)/2;
            
            if(!distribution(quantities , n , mid)){
                
                si=mid+1;
                //System.out.print(si+" ");
            }else{
                ei=mid-1;
                //System.out.print(ei+"* ");
            }
        }
        
        return si;
        
    }

}
