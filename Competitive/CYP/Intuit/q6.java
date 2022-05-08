class q6{

    interface MountainArray {
             public int get(int index) {}
             public int length() {}
    }

    public int binarySearch_findPeak(MountainArray mountainArr){
        
        
        int si = 0;
        int ei = mountainArr.length()-1;
        
        while(si<=ei){
            
            int mid = (si+ei)/2;
            
            int ele = mountainArr.get(mid);
            int next = mountainArr.get(mid+1);
            
            if(ele<next){
                si = mid+1;
            }else{
                ei = mid-1;
            }
        }
        
        return si;
        
    }
    
    // increasing array
    public int binarySearchleft(int tar,MountainArray mountainArr,int si , int ei){
        
        int s = si;
        int e = ei;
        
        while(si <= ei){
            int mid = (si+ei)/2;
            
            int ele = mountainArr.get(mid);
            // System.out.print(si+" "+ei+"->"+mid+",");
            
            if(ele>tar){
                ei = mid-1;
            }else if(ele<tar){
                si = mid+1;
            }else{
                return mid;
            }
        }
        
        return -1;
        
    }
    
    public int binarySearchright(int tar,MountainArray mountainArr,int si , int ei){
        
        int s = si;
        int e = ei;
        
        while(si <= ei){
            int mid = (si+ei)/2;
            
            int ele = mountainArr.get(mid);
            // System.out.print(si+" "+ei+"->"+mid+",");
            
            if(ele>tar){
                si = mid+1;
            }else if(ele<tar){
                ei = mid-1;
            }else{
                return mid;
            }
        }
        
        return -1;
        
    }
    
    public int findInMountainArray(int target, MountainArray mountainArr) {
        
        
        // find the peak 
        
        // as we know that [0,peak] and [peak,n] is sorted so will do a binary search to find target on left and right
        
        int pIdx =  binarySearch_findPeak(mountainArr);
        
        // System.out.print(pIdx);
        
        // binary search on left
        
        int lIdx = binarySearchleft(target,mountainArr,0,pIdx);
        
        if(lIdx==-1){
            return binarySearchright(target,mountainArr,pIdx,mountainArr.length()-1);
        }
        
        return lIdx;
        
        
    }
}