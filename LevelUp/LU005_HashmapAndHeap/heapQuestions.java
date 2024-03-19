import java.util.*;

public class heapQuestions{

    // nlog(k)
    public static int kthSmallest(int[] arr, int l, int r, int k) 
    { 
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
             return b-a;
        });

        // nlog(k)
        while(l<=r){
            pq.add(arr[l]); // log(k)
            if(pq.size() >k){
                pq.remove();
            }
            l++;
        }

        return pq.peek();
    } 

    //n + klog(n)

    class KthLargest {

        private int size = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        public KthLargest(int k, int[] nums) {
            this.size = k;

            for(int e : nums){
                pq.add(e);
                if(pq.size() > k) pq.remove();
            }

        }
        
        public int add(int val) {
            
            pq.add(val);
            if(pq.size()>this.size) pq.remove();

            return pq.peek();
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        

        int n = matrix.length;
        int m = matrix[0].length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
             int r1= a/m , c1 = a%m;
             int r2 = b/m , c2 = b%m;

             return matrix[r1][c1] - matrix[r2][c2];
        });

        for(int i=0;i<n;i++){
            pq.add(i*m +0);
        }

        int r = 0 , c=0;
        while(k-->0){

            int idx = pq.remove();
            r = idx/ m ;
            c = idx%m;
            c+=1;

            if(c<m) pq.add(r*m+c);

        }

        
        return matrix[r][c];
    }


    public int kthSmallest_(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int i1 = a / m, j1 = a % m;
            int i2 = b / m, j2 = b % m;

            return matrix[i1][j1] - matrix[i2][j2];
        });

        for (int i = 0; i < n; i++)
            pq.add(i * m + 0);

        int r = 0, c = 0;
        while (k-- > 0) {
            int idx = pq.remove();
            r = idx / m;
            c = idx % m;
            if (c + 1 < m)
                pq.add(r * m + c + 1);
        }

        return matrix[r][c];
    }

    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> m = new HashMap<>();
        
        for(int ele : nums){
            m.put(ele, m.getOrDefault(ele, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b)->{
            
            int f1 = a.getValue();
            int f2 = b.getValue();
            
            return f1 - f2;
            
        });
        
        for(Map.Entry<Integer,Integer> val :m.entrySet()){
            pq.add(val);
            
            if(pq.size()>k) pq.remove();
        }
        
        int[] ans = new int[k];
        int i = 0;
        while(pq.size()!=0){
            ans[i++] = pq.remove().getKey();
        }
        
        return ans;
    }


    public int[][] kClosest(int[][] points, int k) {
    
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            
            int d1 = points[a][0]*points[a][0] + points[a][1]*points[a][1];
            
            int d2 = points[b][0]*points[b][0] + points[b][1]*points[b][1];
            
            return d2 -d1;
             
        });
            
            
        for(int i=0;i<points.length;i++){
            pq.add(i);
            
            if(pq.size()>k) pq.remove();
        }
        
        int[][] ans = new int[k][];
        int i = 0;
        while(pq.size()!=0){
            int idx = pq.remove();
            
            ans[i++] = points[idx];
        }
        
        return ans;
    }


    public List<String> topKFrequent(String[] words, int k) {
        
        HashMap<String ,Integer> map = new HashMap<>();
        
        for(String s : words){
            map.put(s , map.getOrDefault(s,0)+1);
        }
        
        PriorityQueue<String> pq = new PriorityQueue<>((a,b)->{
            
            if(map.get(a) == map.get(b)) return b.compareTo(a); // lexiographical
            
              return map.get(a) - map.get(b);
            
        }) ;
        
        for(String s : map.keySet()){
            pq.add(s);
            
            if(pq.size()>k) pq.remove();
        }
        
        
        List<String> ans = new LinkedList<>();
        
        while(pq.size()!=0){
            
            ans.add(0,pq.remove()); //  addFirst
        }
        
        return ans;
        
        
    }


    // BFS + storing the heights of block in every direction at which we are standing in pq(min)
    public int swimInWater(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        
        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            int r1 = a/m , c1 = a%m;
            int r2 = b/m , c2 = b%m;
            
            return grid[r1][c1] - grid[r2][c2];
        });
        
        boolean[][] vis = new boolean[n][m];
        
        pq.add(0);
        
        vis[0][0] = true;
        int time = 0;
        while(pq.size()!=0){
           int idx = pq.remove();
         
           int r1 = idx/m , c1 = idx%m;
            
            int height = grid[r1][c1];
            
            time = Math.max(time , height);
            
            if(r1 == n-1 && c1 == m-1) break;
            
            for(int[] d : dir){
                int r = r1 + d[0];
                int c = c1 + d[1];
                
                if(r>=0 && c>=0 && r<n && c<m && !vis[r][c]){
                    vis[r][c] = true;
                    pq.add(r*m + c);
                }
            }
            
           
        }
        
        
        return time;
    }

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // we will store the diff in heights here
        
        int n = heights.length;
        
        for(int i=1;i<n;i++){
            int diff = heights[i] - heights[i-1];
            
            if(diff > 0){
                pq.add(diff);
                
                if(pq.size()>ladders){
                    bricks-=pq.remove(); // if the size of pq becomes more than ladders than we remove the min diff and say that we will cover that with bricks
                }
                
                if(bricks < 0) return i-1;
            }
        }
        
        return n-1;
        
    }
    public int[] smallestRange(List<List<Integer>> nums) {
        
        int n = nums.size();
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            int r1 = a[0]; // 1d row array ka index
            int c1 = a[1] ; // 1d array kaa row ka index
            int r2 = b[0];
            int c2 = b[1];
            
            return nums.get(r1).get(c1) - nums.get(r2).get(c2);
        });
        
        int maxValueofRange = -(int)1e9;
        for(int i=0;i<n;i++){
            pq.add(new int[]{i,0});
            maxValueofRange = Math.max(maxValueofRange , nums.get(i).get(0));
        }
        
        int sp = -1 , ep = -1 , range = (int)1e9;
        
        while(pq.size() == n){
            int[] arr = pq.remove();
            
            int r = arr[0] , c = arr[1] , val = nums.get(r).get(c);
            
            if(maxValueofRange - val < range){
                range = maxValueofRange - val;
                sp = val;
                ep = maxValueofRange;
            }
            
            c++;
            
            if(c<nums.get(r).size()){
                pq.add(new int[]{r,c});
                maxValueofRange = Math.max(maxValueofRange , nums.get(r).get(c));
            }
            
        }

        return new int[]{sp,ep};

    }


    class MedianFinder {

        public MedianFinder() {
            
        }
        
        public void addNum(int num) {
            
        }
        
        public double findMedian() {
            return 4.5;
        }
    }



    // class RandomizedSet {

    //     HashMap<Integer, Integer> map;
    //     ArrayList<Integer> list;

    //     public RandomizedSet() {
    //         this.map = new HashMap<>();
    //     }

    //     public boolean insert(int val) {
    //         if (map.containsKey(val))
    //             return false;

    //             list.add(val);
    //             map.putIfAbsent(val, list.size());

    //         return true;

    //     }

    //     public boolean remove(int val) {

    //         if (map.containsKey(val) == false)
    //             return false;

    //         int idx=map.get(val);
    //         int lidx=list.size()-1;
    //         list.set(idx, list.get(lidx));
    //         list.remove(list.size()-1);
    //         map.put(list.get(idx),idx);
    //         map.remove(val);

    //         return true;

    //     }

    //     public int getRandom() {
    //         Random rand = new Random();

    //         int idx = rand.nextInt(list.size());

    //         return list.get(idx);

    //     }

    // }



    // task scheduler
    class Solution {
        public int leastInterval(char[] tasks, int n) {
            
            // we are trying to fit as many non-repating task in a cycle 
            
            HashMap<Character,Integer> map = new HashMap<>();
    
            for(char ch : tasks){
                map.put(ch,map.getOrDefault(ch,0)+1);
            }
    
            PriorityQueue<Character> pq = new PriorityQueue<>((a,b)->{
                 return map.get(b)-map.get(a);
            });
           for(Map.Entry<Character,Integer> mp : map.entrySet()) pq.add(mp.getKey());
    
            int tt=0;
            // In one cycle on no repeat task can occur only unique task or ideal period
            while(pq.size()!=0){
                List<Character> repeat = new ArrayList<>();// task that are repeating in a cycle
    
                int cycleTime = n + 1; // because cycle or cool down will start after CPU has executed one task like if n=1 to when CPU will do task1 after that 1 sec timer in which some other task will be done so in total a cycle would of 2 sec
                while(cycleTime>0 && pq.size()>0){
                    char ch = pq.remove();
                    if(map.get(ch)>1){
                        int count = map.get(ch);
                        count--;
                        map.put(ch,count);
                        repeat.add(ch);
                    }
    
                    tt++;
                    cycleTime--;
                }
    
    
                for(char rt : repeat){
                    pq.add(rt);
                }
    
    
                if(pq.size()==0) break;
    
                tt+=cycleTime; // ideal period
            }
    
            return tt;
        }
    }




    public void main(String[] args){

    }
}