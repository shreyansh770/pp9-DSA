import java.util.*;

public class l001_SQ {

    // next greater/smaller elements

    // to right
    public static int[] ngeR(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Arrays.fill(ans, n);
        LinkedList<Integer> st = new LinkedList<>();

        st.addFirst(-1);

        for (int i = 0; i < n; i++) {
            while (st.getFirst() != -1 && arr[st.getFirst()] < arr[i]) {
                ans[st.removeFirst()] = i;
            }

            st.addFirst(i);
        }

        return ans;
    }

    // to right
    public static int[] nseR(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Arrays.fill(ans, n);
        LinkedList<Integer> st = new LinkedList<>();

        st.addFirst(-1);

        for (int i = 0; i < n; i++) {
            while (st.getFirst() != -1 && arr[st.getFirst()] > arr[i]) {
                ans[st.removeFirst()] = i;
            }

            st.addFirst(i);
        }

        return ans;
    }

    // to left
    public static int[] ngeL(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        LinkedList<Integer> st = new LinkedList<>();

        st.addFirst(-1);

        for (int i = n - 1; i >= 0; i--) {
            while (st.getFirst() != -1 && arr[st.getFirst()] < arr[i]) {
                ans[st.removeFirst()] = i;
            }

            st.addFirst(i);
        }

        return ans;
    }

    // to left
    public static int[] nseL(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        LinkedList<Integer> st = new LinkedList<>();

        st.addFirst(-1);

        for (int i = n - 1; i >= 0; i--) {
            while (st.getFirst() != -1 && arr[st.getFirst()] > arr[i]) {
                ans[st.removeFirst()] = i;
            }

            st.addFirst(i);
        }

        return ans;
    }

    // 503

    public int[] nextGreaterElements(int[] A) {
        int n = A.length, res[] = new int[n];
        Arrays.fill(res, -1);

        LinkedList<Integer> st = new LinkedList<>();
        st.addFirst(-1);
        for (int i = 0; i < 2 * n; i++) {

            while (st.getFirst() != -1 && A[st.getFirst()] < A[i % n]) {
                res[st.removeFirst()] = A[i % n];
            }

            st.addFirst(i % n);
        }

        return res;
    }

    // https://practice.geeksforgeeks.org/problems/stock-span-problem-1587115621/1
    public static int[] calculateSpan(int price[], int n) {

        int res[] = new int[n];

        LinkedList<Integer> st = new LinkedList<>();

        st.addFirst(-1);

        for (int i = 0; i < n; i++) {

            while (st.getFirst() != -1 && price[st.getFirst()] <= price[i]) {
                st.removeFirst();
            }

            res[i] = i - st.getFirst();

            st.addFirst(i);
        }

        return res;
    }

    // online stock span
    class StockSpanner {

        int day = 0;
        LinkedList<int[]> st = new LinkedList<>();

        public StockSpanner() {

            // {idx , val}
            st.addFirst(new int[] { -1, -1 });
        }

        public int next(int price) {

            while (st.getFirst()[0] != -1 && st.getFirst()[1] <= price) {
                st.removeFirst();
            }

            int span = day - st.getFirst()[0];

            st.addFirst(new int[] { day++, price });
            return span;
        }
    }

    // 739
    public int[] dailyTemperatures(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];

        LinkedList<Integer> st = new LinkedList<>();

        st.addFirst(-1);

        for (int i = 0; i < n; i++) {
            while (st.getFirst() != -1 && arr[st.getFirst()] < arr[i]) {
                int idx = st.getFirst();
                ans[st.removeFirst()] = i - idx;
            }

            st.addFirst(i);
        }

        return ans;
    }

    // 735

    public int[] asteroidCollision(int[] arr) {
        int n = arr.length;

        LinkedList<Integer> st = new LinkedList<>();

        for (int ele : arr) {

            if (ele > 0) {
                st.addFirst(ele);
                continue;
            }

            while (st.size() != 0 && st.getFirst() > 0 && st.getFirst() < -ele)
                st.removeFirst();

            if (st.size() != 0 && st.getFirst() == -ele)
                st.removeFirst();
            else if (st.size() == 0 || st.getFirst() < 0)
                st.addFirst(ele);
            else {
                // nothing to do -> we got a asteroid greater than -ele
            }
        }

        int[] ans = new int[st.size()];
        int idx = ans.length - 1;
        while (st.size() != 0) {
            ans[idx--] = st.removeFirst();
        }

        return ans;
    }

    // 946

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        LinkedList<Integer> st = new LinkedList<>();

        int idx = 0;
        for (int ele : pushed) {
            st.addFirst(ele);
            while (st.size() != 0 && st.getFirst() == popped[idx]) {
                st.removeFirst();
                idx++;
            }
        }

        return st.size() == 0;
    }

    // 856
    public int scoreOfParentheses(String s) {

        LinkedList<Integer> st = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                st.addFirst(0);
            } else if (ch == ')') {

                int top = st.getFirst();

                if (top == 0) {
                    st.removeFirst();
                    st.addFirst(1);
                } else {
                    // anthing other than 0
                    int sum = 0;
                    while (st.getFirst() != 0) {
                        sum += st.getFirst();
                        st.removeFirst();
                    }

                    st.removeFirst();

                    st.addFirst(2 * sum);
                }
            }

        }

        int ans = 0;
        while (st.size() != 0) {
            ans += st.getFirst();
            st.removeFirst();
        }

        return ans;
    }

    // 84
    // 7n
    public int largestRectangleArea_01(int[] heights) {
        int[] nsol = nseL(heights);
        int[] nsor = nseR(heights);

        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            maxArea = Math.max(maxArea, (heights[i] * (nsor[i] - nsol[i] - 1)));
        }

        return maxArea;
    }

    // 2n

    /*
     * here we are keeping the left boundary for each element below them in the
     * staack and we are pushing until we find the right boundary for that element
     */

    public int largestRectangleArea_02(int[] heights) {

        int maxArea = 0;

        int n = heights.length;
        LinkedList<Integer> st = new LinkedList<>();
        st.addFirst(-1);
        for (int i = 0; i < n; i++) {

            while (st.getFirst() != -1 && heights[st.getFirst()] >= heights[i]) {
                int h = heights[st.removeFirst()];
                int w = i - st.getFirst() - 1;
                maxArea = Math.max(maxArea, (h * w));
            }

            st.addFirst(i);

        }

        // there might me some ele left in stack for which right boundary is n;

        while (st.getFirst() != -1) {
            int h = heights[st.removeFirst()];
            int w = n - st.getFirst() - 1;
            maxArea = Math.max(maxArea, (h * w));
        }

        return maxArea;
    }

    // 85

    /*
     * har ek row ko base bnao and vaha pe har coloumn ke corresponding height nikal
     * lo agr kisi row pe col == 0 tab vaha se histogram nhi bn skta
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int maxArea = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int histoGramArr[] = new int[m];
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {
                int num = matrix[i][j] - '0';
                if (num == 0) {
                    histoGramArr[j] = 0;
                } else {
                    histoGramArr[j] += num;
                }

            }

            maxArea = Math.max(maxArea, largestRectangleArea_02(histoGramArr));
        }

        return maxArea;
    }

    // 32

    /*
     * The top of stack here is signify that till that index there are invalid
     * sequence
     */
    public int longestValidParentheses(String s) {

        LinkedList<Integer> st = new LinkedList<>();
        st.addFirst(-1);
        int maxL = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {

            char ch = s.charAt(i);

            if (ch == ')' && st.getFirst() != -1 && s.charAt(st.getFirst()) == '(') {
                st.removeFirst();
                int len = i - st.getFirst();
                maxL = Math.max(maxL, len);
            } else {
                st.addFirst(i);
            }
        }

        return maxL;
    }

    // 402
    public String removeKdigits(String num, int k) {

        int n = num.length();

        ArrayList<Character> st = new ArrayList<>(); // so that we can iterate from starting

        for (int i = 0; i < n; i++) {

            char ch = num.charAt(i);
            while (st.size() != 0 && st.get(st.size() - 1) > ch && k > 0) {
                k--;
                st.remove(st.size() - 1);// dry run for 112 , 1
            }

            st.add(ch);
        }

        // when k!=0
        while (k-- > 0) {
            st.remove(st.size() - 1);
        }

        // if starting me 0 hai

        StringBuilder sb = new StringBuilder();
        boolean nonZero = false;
        for (Character ch : st) {

            if (ch == '0' && !nonZero)
                continue;

            nonZero = true;
            sb.append(ch);
        }

        return sb.length() != 0 ? sb.toString() : "0"; // "10" , 1 pe dry run kr

    }

    // 316 . 1081
    /*
     * freq arr will keep a check on when we are removing a char will we find it
     * later on if not than we won't remove it bcoz we have to form lexigraphically
     * smallest string using all chars
     */
    public String removeDuplicateLetters(String s) {

        ArrayList<Character> st = new ArrayList<>();
        int n = s.length();
        boolean[] vis = new boolean[26];
        int[] frq = new int[26];

        for (int i = 0; i < n; i++) {
            frq[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            frq[ch - 'a']--;
            if (vis[ch - 'a'])
                continue;

            while (st.size() != 0 && st.get(st.size() - 1) > ch && frq[st.get(st.size() - 1) - 'a'] > 0) {
                vis[st.get(st.size() - 1) - 'a'] = false; // jo char remove kr rahe hai
                st.remove(st.size() - 1);

            }

            vis[ch - 'a'] = true;
            st.add(ch);
        }

        StringBuilder sb = new StringBuilder();

        for (Character ch : st) {
            sb.append(ch);
        }

        return sb.toString();
    }

    // 1249

    public String minRemoveToMakeValid(String s) {

        ArrayList<Integer> st = new ArrayList<>();
        int n = s.length();
        boolean[] vis = new boolean[n];

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == ')') {
                if (st.size() != 0 && s.charAt(st.get(st.size() - 1)) == '(') {

                    vis[st.get(st.size() - 1)] = false;
                    st.remove(st.get(st.size() - 1));
                } else {
                    vis[i] = true;
                }
            } else if (ch == '(') {
                st.add(i);
                vis[i] = true;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {

                sb.append(s.charAt(i));
            }
        }

        return sb.toString();

    }

    // 895

    class FreqStack {

        private class pair implements Comparable<pair> {
            int val = 0;
            int idx = 0;
            int freq = 0;

            pair(int val, int idx, int freq) {
                this.val = val;
                this.idx = idx;
                this.freq = freq;
            }

            public int compareTo(pair o) {
                if (this.freq == o.freq)
                    return o.idx - this.idx;
                else
                    return o.freq - this.freq;
            }
        }

        private PriorityQueue<pair> pq;
        private HashMap<Integer, Integer> map;
        private int idx = 0;

        public FreqStack() {
            pq = new PriorityQueue<>(); // jab class ka obj bne tbhi pq ko memory mile
            map = new HashMap<>();
        }

        // logn
        public void push(int val) {
            map.put(val, map.getOrDefault(val, 0) + 1);
            pq.add(new pair(val, idx++, map.get(val)));
        }

        // logn
        public int pop() {
            pair rp = pq.remove();
            map.put(rp.val, rp.freq - 1);
            if (map.get(rp.val) == 0) {
                map.remove(rp.val);
            }
            return rp.val;
        }

        private int top() {
            pair rp = pq.peek();
            return rp.val;
        }
    }

    class FreqStack_ {

        private ArrayList<LinkedList<Integer>> freqMap; // arraylist of stack where idx of arrayList tell us the freq of
                                                        // element in the stack at that position
        private HashMap<Integer, Integer> map;
        private int maxFreq = 0;

        public FreqStack_() {
            freqMap = new ArrayList<>();
            map = new HashMap<>();
            freqMap.add(new LinkedList<>()); // default stack index = 0
        }

        // O(1)
        public void push(int val) {
            map.put(val, map.getOrDefault(val, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(val));

            if (maxFreq == freqMap.size())
                freqMap.add(new LinkedList<>());

            freqMap.get(map.get(val)).addFirst(val);

        }

        // O(1)
        public int pop() {

            int rv = freqMap.get(maxFreq).removeFirst();
            if (freqMap.get(maxFreq).size() == 0) {
                freqMap.remove(maxFreq--); // removing the emptied stack
            }

            map.put(rv, map.get(rv) - 1); // decreasing its overall freq
            if (map.get(rv) == 0)
                map.remove(rv);

            return rv;

        }
    }

    // 115 -> Important mathemetical concept of encoding minValue
    class MinStack {

        LinkedList<Long> st;
        long minSf = 0;

        public MinStack() {
            st = new LinkedList<>();
        }

        public void push(int val) {

            long x = val;
            if (st.size() == 0) {
                st.addFirst(x);
                minSf = x;
                return;
            }

            if (x < minSf) {
                st.addFirst(2 * x - minSf);
                minSf = x;
            } else {
                st.addFirst(x);
            }
        }

        public void pop() {

            if (st.getFirst() < minSf) {
                // must be modified value

                minSf = 2 * minSf - st.getFirst(); // minsf = prevMinSf
            }

            st.removeFirst();

        }

        public int top() {

            if (st.getFirst() < minSf) {
                return (int) minSf;
            }

            // Long(obj) -> long -> int
            return (int) (long) st.getFirst();

        }

        public int getMin() {

            return (int) minSf;
        }
    }

    public int[] exclusiveTime(int n, List<String> logs) {

        class logPair {
            int id, timeStamp, sleepTime;
            boolean isStart;

            // sleepTime-> us process ke beech me baki kitni id's ne callStack use
            // kiya(single threaded)
            logPair(String str) {
                String[] ar = str.split(":");
                this.id = Integer.parseInt(ar[0]);
                this.timeStamp = Integer.parseInt(ar[2]);
                this.isStart = ar[1].equals("start");
                this.sleepTime = 0;

            }
        }

        LinkedList<logPair> st = new LinkedList<>();

        int[] ans = new int[n];

        for (String s : logs) {
            logPair log = new logPair(s);
            if (log.isStart) {
                st.addFirst(log);
            } else {
                logPair rp = st.removeFirst();
                ans[rp.id] += (log.timeStamp - rp.timeStamp + 1) - rp.sleepTime;
                
                 // rp ke wjha se uske exact niche vala kitne tym ke liye sleep pe tha

                if(st.size()!=0){              // ending       // start
                    st.getFirst().sleepTime += log.timeStamp - rp.timeStamp +1;
                }
            }


        }


        return ans;

    }


    // public int carFleet(int target, int[] position, int[] speed) {
        
    // }
    public static void main(String[] args) {

    }
}