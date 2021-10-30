
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

    // Q find all the unique pairs that sum up to give target

    public List<List<Integer>> allPairs(int[] nums , int tar,int SI , int EI){

        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        int si =SI,ei = EI;

        while(si<ei){
            int csum = nums[si] + nums[ei];

            if(csum == tar){

                List<Integer> sa = new ArrayList<>();

                sa.add(nums[si]);
                sa.add(nums[ei]);

                ans.add(sa);

                si++ , ei--;
                while(si<ei && nums[si] == nums[si-1]) si++;
                while(si<ei && nums[ei] == nums[ei+1]) ei--;

            }else if(csum<tar){

                si++;
            }else{

                ei--;
            }
        }
    }

    // 3SUM

    // 4SUM

    // K-SUM

    // two sum count =================================

    public int count(int[] arr1 , int[] arr2){
        int ans = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<arr1.length;i++){
            map.put(arr1[i], map.getOrDefault(arr1[i],0)+1);
        }


        for(int i=0;i<arr2.length;i++){
            
            if(map.containsKey(-arr2[i]){
                ans++;
            }
        }

        return ans;
    }

    // 4sum -> 2

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

                if (map.containsKey(-(e + f))) {
                    ans += map.get(-(e + f));
                }
            }
        }

        return ans;

    }

}
