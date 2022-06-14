public class q11 {
    int mod = (int)1e9 +7;

    // FIRST APPROCH RECURSION (TLE) WITH DP[MLE]
    int max = 0;
    public void rec(int n , int[] speed , int[] eff , int e , int s , int k,int i){
        
        if(k<0 || i>=n){
            return;
        }
        
        if(e!=(int)1e9){
            
            max = Math.max(max , (s*e)%mod);
        }
        // choosing
        
        int ef = Math.min(e,eff[i]);
        rec(n,speed,eff,ef,s+speed[i],k-1,i+1);
        
        
        // not choosing
        rec(n,speed,eff,e,s,k,i+1);

        
    }
    

    public int maxPerformance_(int n, int[] speed, int[] efficiency, int k) {
        int[][] ord = new int[n][2];
        for (int i = 0; i < n; i++)
            ord[i] = new int[] {efficiency[i], speed[i]};
        Arrays.sort(ord, (a, b) -> Integer.compare(b[0], a[0]));
        PriorityQueue<Integer> sppq = new PriorityQueue<>();
        long totalSpeed = 0, best = 0;
        for (int[] pair : ord) {
            int spd = pair[1];
            sppq.add(spd);
            if (sppq.size() <= k) totalSpeed += spd;
            else totalSpeed += spd - sppq.poll();
            best = Math.max(best, totalSpeed * pair[0]); // e[1] will always be minimum in grp coz we have sorted in dec order
        }
        return (int)(best % 1000000007);
    }

    
    public int maxPerformance(int n, int[] speed, int[] eff, int k) {
        rec(n,speed,eff,(int)1e9,0,k,0);
        return max;
    }
}
