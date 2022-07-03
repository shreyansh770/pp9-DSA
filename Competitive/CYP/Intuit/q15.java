class Solution {
    
    public boolean isPossible(int curr , int[] piles , int h){
        
        int totalHours = 0;
        
        for(int e : piles){
            int time = e/curr;
            
            if(e%curr!=0){
                time++; // upper limit
            }
            
            totalHours+=time;
            
            if(totalHours > h) return false;
        }
        
        return true;
    }
     
    
    public int minEatingSpeed(int[] piles, int h) {
        
        int si = 1,ei = (int)1e9;
        
        
        while(si<=ei){
            
            int mid = (si+ei)/2;
            
            if(!isPossible(mid,piles,h)){
                si = mid +1;
            }else{
                ei = mid-1;
            }
        }
        
        return si;
    }
}