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
        HashMap<Integer, Integer>[] dp = new HashMap[n]; // diff v/s LAS length

        for (int i = 0; i < n; i++)
            dp[i] = new HashMap<>();

        int len = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int diff = nums[i] - nums[j];

                int currLen = dp[i].getOrDefault(diff, 0);
                int newLength = dp[j].getOrDefault(diff, 1) + 1;

                dp[i].put(diff, Math.max(currLen, newLength));
                len = Math.max(len, dp[i].get(diff));
            }
        }

        return len;
    }

    public boolean canReorderDoubled(int[] arr) {

        int n = arr.length;
        Integer[] ARR = new Integer[n]; // made array of class Integer bcoz we have do custom sort which ask for class
                                        // obj as a paramter

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            ARR[i] = arr[i];
        }

        // WHY WE DID SORTING DRY RUN ON 8 4 2 1
        Arrays.sort(ARR, (a, b) -> {
            return Math.abs(a) - Math.abs(b); // sorting irrespective of -/+ bcoz then we will just have to check for 2
                                              // * ele otherwise for - we will have to chek for ele/2
        });

        for (int ele : ARR) {
            if (map.get(ele) == 0)
                continue;

            if (map.getOrDefault(2 * ele, 0) <= 0)
                return false;

            map.put(ele, map.get(ele) - 1);
            map.put(2 * ele, map.get(2 * ele) - 1);
        }

        return true;

    }

    public int numberOfBoomerangs(int[][] points) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0, n = points.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;
                int dis = distance(points, i, j);
                map.put(dis, map.getOrDefault(dis, 0) + 1);
            }

            for (int ele : map.values()) {
                ans += ele * (ele - 1);// ->
            }

            map.clear();
        }

        return ans;
    }

    public int distance(int[][] points, int i, int j) {
        int x = (points[j][0] - points[i][0]);
        int y = (points[j][1] - points[i][1]);

        return x * x + y * y;
    }

    class Solution {
        public int maxPoints(int[][] points) {

            HashMap<String, Integer> map = new HashMap<>();
            int ans = 0, n = points.length;
            int res = 0;
            for (int i = 0; i < n; i++) {
                int max = 0; // i se start hone vala max pts ka st line
                for (int j = i + 1; j < n; j++) {

                    int xDiff = points[i][0] - points[j][0];
                    int yDiff = points[i][1] - points[j][1];

                    int gcd = gcd(xDiff, yDiff);

                    xDiff /= gcd;
                    yDiff /= gcd;

                    String s = xDiff + "$" + yDiff; // all same slopes will have same string

                    map.put(s, map.getOrDefault(s, 0) + 1);

                    max = Math.max(max, map.get(s));
                }

                res = Math.max(max + 1, res); // max + 1 bcoz ek pt i khud bhi to hai
                map.clear(); // parallel lines

            }
            return res;
        }

        public int gcd(int a, int b) {
            if (b == 0)
                return a;
            else
                return gcd(b, a % b);
        }
    }

    class RandomizedSet {
        // map contains value with it's index
        Map<Integer, Integer> map;
        // contains values
        List<Integer> allValues;

        public RandomizedSet() {
            map = new HashMap<>();
            allValues = new ArrayList<>();
        }

        public boolean insert(int val) {
            if (map.containsKey(val))
                return false;

            allValues.add(val);
            // keep track of index in array
            map.put(val, allValues.size() - 1);

            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val))
                return false;

            // set the index of val with last element
            allValues.set(map.get(val), allValues.get(allValues.size() - 1));
            // update index in map
            map.put(allValues.get(allValues.size() - 1), map.get(val));

            map.remove(val);
            // O(1) remove
            allValues.remove(allValues.size() - 1);

            return true;
        }

        public int getRandom() {
            // [0, size - 1]
            return allValues.get((int) (Math.random() * allValues.size()));
        }
    }
}
